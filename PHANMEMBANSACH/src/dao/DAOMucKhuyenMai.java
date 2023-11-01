package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
				float phanTram = rs.getFloat("tiLeKhuyenMai") / 100;
				MucKhuyenMai mkm = new MucKhuyenMai(tenMucKhuyenMai, phanTram);
				dsMucKhuyenMai.add(mkm);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dsMucKhuyenMai;
	}
}
