package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.TaiKhoan;

public class DAOTaiKhoan {
	public boolean kiemTraMatKhau(String taiKhoan, String matKhau) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from TaiKhoan where tenTaiKhoan = ? and matKhau = ?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(0, taiKhoan);
			statement.setString(1, matKhau);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
