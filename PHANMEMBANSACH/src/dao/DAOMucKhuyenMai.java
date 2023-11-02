package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.MucKhuyenMai;

public class DAOMucKhuyenMai {
	public ArrayList<MucKhuyenMai> layDSMucKhuyenMaiCuaCTKM(String maCTKM) {
		ArrayList<MucKhuyenMai> ds = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from MucKhuyenMai where maCTKM = ?";
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, maCTKM);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String tenMucKhuyenMai = rs.getString("tenMucKhuyenMai");
				float tiLeKhuyenMai = rs.getFloat("tiLeKhuyenMai");
				ds.add(new MucKhuyenMai(tenMucKhuyenMai, tiLeKhuyenMai));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}
}
