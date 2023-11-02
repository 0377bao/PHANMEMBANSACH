package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connect.ConnectDB;
import entity.DanhMuc;
import entity.NhaCungCap;
import entity.SanPham;
import entity.VanPhongPham;

public class DAOVanPhongPham {
	public VanPhongPham timVanPhongPhamTheoMa(String maSP) {
		VanPhongPham sp = null;
		Connection con = ConnectDB.getConnection();
		String sql = "select * from VanPhongPham vpp join DanhMuc dm on vpp.maDanhMuc = dm.maDanhMuc where vpp.maSanPham = ?";
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, maSP);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String tenSanPham = rs.getString("tenSanPham").trim();; 
				int soLuongTon = rs.getInt("soLuongTon");
				float giaNhap = rs.getFloat("giaNhap");
				String theLoai = rs.getString("theLoai").trim();
				String ke = rs.getString("ke").trim();;
				String hinhAnh = rs.getString("hinhAnh").trim();
				float thue = rs.getFloat("thue");
				float phanTramLoiNhuan = rs.getFloat("phanTramLoiNhuan");
				String trangThai = rs.getBoolean("trangThai") ? "Đang bán" : "Ngưng bán";
				String maNhaCungCap = rs.getString("maNhaCungCap").trim();
				NhaCungCap ncc = new DAONhaCungCap().timNhaCungCapTheoMa(maNhaCungCap);
				String chatLieu = rs.getString("chatLieu").trim();
				String maDanhMuc = rs.getString("maDanhMuc").trim();
				String tenDanhMuc = rs.getString("tenDanhMuc").trim();
				DanhMuc dm = new DanhMuc(maDanhMuc, tenDanhMuc);
				sp = new VanPhongPham(maSP, tenSanPham, soLuongTon, giaNhap, theLoai, ke, hinhAnh, thue, phanTramLoiNhuan, trangThai, ncc, chatLieu, dm);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return sp;
	}
}
