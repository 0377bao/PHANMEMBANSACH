package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connect.ConnectDB;
import entity.NhaCungCap;
import entity.Sach;

public class DAOSach {
	public Sach timSachTheoMa(String maSP) {
		Sach sp = null;
		Connection con = ConnectDB.getConnection();
		String sql = "select * from Sach where maSanPham = ?";
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, maSP);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String tenSanPham = rs.getString("tenSanPham").trim();; 
				int soLuongTon = rs.getInt("soLuongTon");
				float giaNhap = rs.getFloat("giaNhap");
				String theLoai = rs.getString("theLoai").trim();;
				String ke = rs.getString("ke").trim();;
				String hinhAnh = rs.getString("hinhAnh").trim();;
				float thue = rs.getFloat("thue");
				float phanTramLoiNhuan = rs.getFloat("phanTramLoiNhuan");
				String trangThai = rs.getBoolean("trangThai") ? "Đang bán" : "Ngưng bán";
				String maNhaCungCap = rs.getString("maNhaCungCap").trim();;
				NhaCungCap ncc = new DAONhaCungCap().timNhaCungCapTheoMa(maNhaCungCap);
				String tacGia = rs.getString("tacGia").trim();;
				String nhaXuatBan = rs.getString("nhaXuatBan").trim();;
				int namXuatBan = rs.getInt("namXuatBan");
				sp = new Sach(maSP, tenSanPham, soLuongTon, giaNhap, theLoai, ke, hinhAnh, thue, phanTramLoiNhuan, trangThai, ncc, tacGia, nhaXuatBan, namXuatBan);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return sp;
	}
}
