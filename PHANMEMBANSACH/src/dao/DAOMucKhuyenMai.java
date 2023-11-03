package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.MucKhuyenMai;

public class DAOMucKhuyenMai {
	public ArrayList<MucKhuyenMai> layDSMucKhuyenMaiCuaCTKM(String ma){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		ArrayList<MucKhuyenMai> dsMucKhuyenMai = new ArrayList<>();
		String sql = "select * from MucKhuyenMai where maCTKM = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,ma);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String tenMucKhuyenMai = rs.getString("tenMucKhuyenMai").trim();
				float phanTram = rs.getFloat("tiLeKhuyenMai");
				MucKhuyenMai mkm = new MucKhuyenMai(tenMucKhuyenMai, phanTram);
				dsMucKhuyenMai.add(mkm);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dsMucKhuyenMai;
	}
	
	public boolean themMucKhuyenMai(String maCTKM, MucKhuyenMai mkm) {
		int n = 0;
		Connection con = ConnectDB.getConnection();
		String sql = "insert into MucKhuyenMai values (?, ?, ?)";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, mkm.getTenMucKhuyenMai());
			statement.setFloat(2, mkm.getTiLeKhuyenMai());
			statement.setString(3, maCTKM);
			n = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n > 0;
	}
}
