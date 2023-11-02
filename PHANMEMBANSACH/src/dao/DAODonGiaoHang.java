package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bus.BUSNhanVien;
import connect.ConnectDB;
import entity.DonGiaoHang;
import entity.HoaDon;
import entity.NhanVien;

public class DAODonGiaoHang {
   public ArrayList<DonGiaoHang> layDSDonHang() {
	   ConnectDB.getInstance();
	   Connection con = ConnectDB.getConnection();
	   ArrayList<DonGiaoHang> dsDonHang = new ArrayList<>();
	   String sql = "select * from DonGiaoHang dgh join HoaDon hd on dgh.maHoaDon = hd.maHoaDon join NhanVien nv on dgh.maNhanVienGiaoHang = nv.maNhanVien";
	   try {
		   PreparedStatement stmt = con.prepareStatement(sql);
		   ResultSet rs = stmt.executeQuery();
		   while(rs.next()) {
			   String maDonGiaoHang = rs.getString("maDonGiaoHang").trim();
			   String tenKhachHang = rs.getString("tenKhachHang").trim();
			   String sdt = rs.getString("sdt").trim();
			   String diaChi = rs.getString("diaChi").trim();
			   int sokg = rs.getInt("soKG");
			   float soKm = rs.getFloat("soKM");
			   float tienVanChuyen = rs.getFloat("tienVanChuyen");
			   Boolean trangThai = rs.getBoolean("trangThai");
			   String maHoaDon = rs.getString("maHoaDon");
			   HoaDon hd = new DAOHoaDon().timHoaDonTheoMa(maHoaDon);
			   String maNhanVienGiaoHang = rs.getString("maNhanVienGiaoHang");
			   NhanVien nvGiaoHang = (new BUSNhanVien()).layNhanVienTheoMa(maNhanVienGiaoHang);
			   String maNhanVienBanHang = rs.getString("maNhanVien");
			   NhanVien nvBanHang = (new BUSNhanVien()).layNhanVienTheoMa(maNhanVienBanHang);
			   String ghiChu = rs.getString("ghiChu");
			   DonGiaoHang dgh = new DonGiaoHang(maDonGiaoHang, tenKhachHang, sdt, diaChi, sokg, trangThai, ghiChu, tienVanChuyen, nvGiaoHang, nvBanHang, hd);
			   dsDonHang.add(dgh);
		   }
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	   return dsDonHang;
   }
   
   public boolean themDonGiaoHang(DonGiaoHang dgh) {
	   ConnectDB.getInstance();
	   Connection con = ConnectDB.getConnection();
	   String sql = "insert into DonGiaoHang values (?,?,?,?,?,?,?,?,?,?,?)";
	   int n = 0;
	   try {
		   PreparedStatement stmt = con.prepareStatement(sql);
		   stmt.setString(1, dgh.getMaDonGiaoHang());
		   stmt.setString(2, dgh.getTenKhachHang());
		   stmt.setString(3, dgh.getDiaChi());
		   stmt.setString(4, dgh.getDiaChi());
		   stmt.setInt(4, dgh.getSoKg());
		   stmt.setFloat(5, dgh.getSoKm());
		   stmt.setFloat(6, dgh.getTienVanChuyen());
		   stmt.setString(7, dgh.getNhanVienGiaoHang().getMaNhanVien());
		   stmt.setString(8, dgh.getNhanVienLapHoaDon().getMaNhanVien());
		   stmt.setString(9, dgh.getGhiChu());
		   n = stmt.executeUpdate();
	   }catch(Exception e) {
		   
	   }
	   return n > 0 ? true : false;
   }
   
   public boolean capNhatThongTinDonHang(DonGiaoHang dgh) {
	   ConnectDB.getInstance();
	   Connection con = ConnectDB.getConnection();
	   String sql = "update DonGiaoHang set tenKhachHang = ?, diaChi = ?, soKM = ?, maNhanVienGiaoHang = ?, ghiChu = ? where maDonHang = ?";
	   int n = 0;
	   try {
		   PreparedStatement stmt = con.prepareStatement(sql);
		   
		   stmt.setString(1, dgh.getTenKhachHang());
		   stmt.setString(2, dgh.getDiaChi());
		   stmt.setFloat(3, dgh.getSoKm());
		   stmt.setString(4, dgh.getNhanVienGiaoHang().getMaNhanVien());
		   stmt.setString(5, dgh.getGhiChu());
		   stmt.setString(7, dgh.getMaDonGiaoHang());
		   
		   n = stmt.executeUpdate();
	   }catch(Exception e) {
		   
	   }
	   return n > 0 ? true : false;
   }
   

   
   
}
