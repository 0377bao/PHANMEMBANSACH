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
	   String sql = "select * from DonGiaoHang dgh join HoaDon hd on dgh.maHoaDon = hd.maHoaDon";
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
		       String phuongThucThanhToan = rs.getString("phuongThucThanhToan").trim();
			   String ghiChu = rs.getString("ghiChu");
			   DonGiaoHang dgh = new DonGiaoHang(maDonGiaoHang, tenKhachHang, sdt, diaChi, sokg, trangThai, ghiChu, tienVanChuyen, phuongThucThanhToan, hd);
			   dgh.tinhSoKm(soKm);
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
		   stmt.setString(3, dgh.getSdt());
		   stmt.setString(4, dgh.getDiaChi());
		   stmt.setInt(5, dgh.getSoKg());
		   stmt.setFloat(6, dgh.getSoKm());
		   stmt.setFloat(7, dgh.getTienVanChuyen());
		   stmt.setString(8, dgh.getHoaDon().getMaHoaDon());
		   stmt.setString(9, dgh.getGhiChu());
		   stmt.setBoolean(10, dgh.isTrangThai()); 
		   stmt.setString(11, dgh.getPhuongThucThanhToan());
		   n = stmt.executeUpdate();
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	   return n > 0 ? true : false;
   }
   
   public boolean capNhatThongTinDonHang(DonGiaoHang dgh) {
	   ConnectDB.getInstance();
	   Connection con = ConnectDB.getConnection();
	   String sql = "update DonGiaoHang set tenKhachHang = ?, diaChi = ?, soKM = ?, ghiChu = ? ,trangThai=?, phuongThucThanhToan = ? where maDonGiaoHang = ?";
	   int n = 0;
	   try {
		   PreparedStatement stmt = con.prepareStatement(sql);
		   
		   stmt.setString(1, dgh.getTenKhachHang());
		   stmt.setString(2, dgh.getDiaChi());
		   stmt.setFloat(3, dgh.getSoKm());
		   stmt.setString(4, dgh.getGhiChu());
		   stmt.setBoolean(5, dgh.isTrangThai());
		   stmt.setString(6, dgh.getPhuongThucThanhToan());
		   stmt.setString(7, dgh.getMaDonGiaoHang());
		   
		   n = stmt.executeUpdate();
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	   return n > 0 ? true : false;
   }
   

   
   
}
