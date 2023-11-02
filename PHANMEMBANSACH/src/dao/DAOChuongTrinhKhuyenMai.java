package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.ChuongTrinhKhuyenMai;
import entity.MucKhuyenMai;

public class DAOChuongTrinhKhuyenMai {
	public ChuongTrinhKhuyenMai timChuongTrinhKhuyenMaiTheoMa(String maTim) {
		ChuongTrinhKhuyenMai ctkm = null;
		Connection con = ConnectDB.getConnection();
		String sql = "select * from ChuongTrinhKhuyenMai where maCTKM = ?";
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, maTim);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String maCTKM = rs.getString("maCTKM");
				String tenCTKM = rs.getString("tenCTKM");
				ArrayList<MucKhuyenMai> dsMucKM = new DAOMucKhuyenMai().layDSMucKhuyenMaiCuaCTKM(maTim);
				ctkm = new ChuongTrinhKhuyenMai(maCTKM, tenCTKM, dsMucKM);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ctkm;
	}
}
