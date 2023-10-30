package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connect.ConnectDB;
import entity.NhanVien;
import entity.TaiKhoan;

public class DAONhanVien {
	public NhanVien layNhanVien(String maNV) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from NhanVien nv join TaiKhoan tk on nv.maNhanVien=tk.tenTaiKhoan where nv.maNhanVien = ?";
		NhanVien nv =null;
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, maNV);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				TaiKhoan tk = new TaiKhoan(maNV, rs.getString("matKhau"));
				String tenNV = rs.getString("tenNhanVien").trim();
				String sdt  = rs.getString("sdt").trim();
				Boolean gioiTinh = rs.getBoolean("gioiTinh");
				String diaChi = rs.getString("diaChi").trim();
				String chucVu = rs.getString("chucVu").trim();
				String hinhAnh = rs.getString("hinhAnh").trim();
				String email = rs.getString("email").trim();
				String cccd = rs.getString("cccd").trim();
				nv = new NhanVien(maNV, tenNV, sdt, email, gioiTinh, diaChi, chucVu, cccd, hinhAnh, tk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nv;
		
	}
}
