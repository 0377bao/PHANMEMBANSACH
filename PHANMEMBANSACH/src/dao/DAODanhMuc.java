package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.DanhMuc;

public class DAODanhMuc {
	public DAODanhMuc() {

	}

	// lấy ds danh mục
	public ArrayList<DanhMuc> layDSDanhMuc() {
		ArrayList<DanhMuc> dsDanhMuc = new ArrayList<DanhMuc>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "select * from DanhMuc";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maDanhMuc = rs.getString("maDanhMuc");
				String tenDanhMuc = rs.getString("tenDanhMuc");
				DanhMuc dm = new DanhMuc(maDanhMuc, tenDanhMuc);
				dsDanhMuc.add(dm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsDanhMuc;
	}

	// thêm danh mục
	public boolean taoDanhMuc(DanhMuc dm) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		try {
			String sql = "insert into DanhMuc values(?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dm.getMaDanhMuc());
			ps.setString(2, dm.getTenDanhMuc());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
}
