package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connect.ConnectDB;
import entity.TaiKhoan;

public class DAOTaiKhoan {
	public boolean kiemTraMatKhau(String taiKhoan, String matKhau) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from TaiKhoan where tenTaiKhoan = ? and matKhau = ?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, taiKhoan);
			statement.setString(2, matKhau);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// hàm thêm nhân viên
	public boolean themTaiKhoan(TaiKhoan tk) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql_tk = "insert into TaiKhoan values(?,?)";
		int n = 0;
		try {
			PreparedStatement stmtTK = con.prepareStatement(sql_tk);
			stmtTK.setString(1, tk.getTenTaiKhoan());
			stmtTK.setString(2, tk.getMatKhau());

			n = stmtTK.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
}
