package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
				boolean trangThai = rs.getBoolean("trangThai");
				ArrayList<MucKhuyenMai> dsMucKM = new DAOMucKhuyenMai().layDSMucKhuyenMaiCuaCTKM(maTim);
				ctkm = new ChuongTrinhKhuyenMai(maCTKM, tenCTKM, dsMucKM, trangThai);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ctkm;
	}
	
	public ChuongTrinhKhuyenMai timChuongTrinhKhuyenMaiDangApDung() {
		ChuongTrinhKhuyenMai ctkm = null;
		Connection con = ConnectDB.getConnection();
		String sql = "select * from ChuongTrinhKhuyenMai where trangThai = 1";
		Statement statement = null;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maCTKM = rs.getString("maCTKM");
				String tenCTKM = rs.getString("tenCTKM");
				boolean trangThai = rs.getBoolean("trangThai");
				ArrayList<MucKhuyenMai> dsMucKM = new DAOMucKhuyenMai().layDSMucKhuyenMaiCuaCTKM(maCTKM);
				ctkm = new ChuongTrinhKhuyenMai(maCTKM, tenCTKM, dsMucKM, trangThai);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ctkm;
	}
	
	public ArrayList<ChuongTrinhKhuyenMai> layDSChuongTrinhKhuyenMai() {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		ArrayList<ChuongTrinhKhuyenMai> ds = new ArrayList<>();
		String sql = "select * from ChuongTrinhKhuyenMai";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String maCTLM = rs.getString("maCTKM").trim();
				String tenCTKM = rs.getString("tenCTKM").trim();
				boolean trangThai = rs.getBoolean("trangThai");
				ArrayList<MucKhuyenMai> dsMucKhuyenMai = new DAOMucKhuyenMai().layDSMucKhuyenMaiCuaCTKM(maCTLM);
				ChuongTrinhKhuyenMai ctkm = new ChuongTrinhKhuyenMai(maCTLM, tenCTKM, dsMucKhuyenMai, trangThai);
				ds.add(ctkm);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public void tatTrangThaiChuongTrinhKhuyenMai(ChuongTrinhKhuyenMai ctkm) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "update ChuongTrinhKhuyenMai set trangThai=? where maCTKM=?";
		int n = 0;
		try {
		   PreparedStatement stmt = con.prepareStatement(sql);
		   stmt.setBoolean(1,false);
		   stmt.setString(2, ctkm.getMaCTKM());
		   n = stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void capNhatTrangThaiChuongTrinhKhuyenMaiDuocChon(ChuongTrinhKhuyenMai ctkm) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "update ChuongTrinhKhuyenMai set trangThai=? where maCTKM=?";
		int n = 0;
		try {
		   PreparedStatement stmt = con.prepareStatement(sql);
		   stmt.setBoolean(1,ctkm.isTrangThai());
		   stmt.setString(2, ctkm.getMaCTKM());
		   n = stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean themChuongTrinhKhuyenMai(ChuongTrinhKhuyenMai ctkm) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		int n = 0;
		int m = 0;
		String sql_mucKhuyenMai = "insert into MucKhuyenMai values(?,?,?)";
		String sql_chuongTrinhKhuyenMai = "insert into ChuongTrinhKhuyenMai values(?,?,?)";
		try {
			PreparedStatement stmt_chuongTrinhKhuyenMai = con.prepareStatement(sql_chuongTrinhKhuyenMai);
			stmt_chuongTrinhKhuyenMai.setString(1, ctkm.getMaCTKM());
			stmt_chuongTrinhKhuyenMai.setString(2, ctkm.getTenCTKM());
			stmt_chuongTrinhKhuyenMai.setBoolean(3, ctkm.isTrangThai());
			n = stmt_chuongTrinhKhuyenMai.executeUpdate();
			PreparedStatement stmt_mucKhuyenMai = con.prepareStatement(sql_mucKhuyenMai);
			for(MucKhuyenMai mkm : ctkm.getDsMucKhuyenMai()) {
				stmt_mucKhuyenMai.setString(1, mkm.getTenMucKhuyenMai());
				stmt_mucKhuyenMai.setFloat(2, mkm.getTiLeKhuyenMai());
				stmt_mucKhuyenMai.setString(3, ctkm.getMaCTKM());
				m = stmt_mucKhuyenMai.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return n > 0 && m > 0 ? true : false;
	}
}
