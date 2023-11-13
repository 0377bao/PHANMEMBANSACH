package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.NhaCungCap;

public class DAONhaCungCap {
	// lấy ds nhà cung cấp
	public ArrayList<NhaCungCap> layDSNhaCungCap() {
		ArrayList<NhaCungCap> dsNCC = new ArrayList<NhaCungCap>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "select * from NhaCungCap";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maNCC = rs.getString("maNhaCungCap").trim();
				String tenNCC = rs.getString("tenNhaCungCap").trim();
				String diaChi = rs.getString("diaChi").trim();
				String sdt = rs.getString("sdt").trim();
				String email = rs.getString("email").trim();
				NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, diaChi, sdt, email);
				dsNCC.add(ncc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNCC;
	}

	// thêm nhà cung cấp
	public boolean themNCC(NhaCungCap ncc) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		try {
			String sql = "insert into NhaCungCap values(?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, ncc.getMaNhaCungCap());
			ps.setString(2, ncc.getTenNhaCungCap());
			ps.setString(3, ncc.getDiaChi());
			ps.setString(4, ncc.getSdt());
			ps.setString(5, ncc.getEmail());
			n = ps.executeUpdate();
		} catch (SQLException e) {
		}
		return n > 0;
	}

	// sửa nhà cung cấp
	public boolean capNhatNCC(NhaCungCap ncc) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		String sql = "update NhaCungCap set tenNhaCungCap = ?, diaChi = ?, sdt = ?, email = ? where maNhaCungCap = ?";
		int n = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ncc.getTenNhaCungCap());
			ps.setString(2, ncc.getDiaChi());
			ps.setString(3, ncc.getSdt());
			ps.setString(4, ncc.getEmail());
			ps.setString(5, ncc.getMaNhaCungCap());
			n = ps.executeUpdate();
		} catch (Exception e) {

		}
		return n > 0;
	}

	// lấy nhà cung cấp theo mã
	public NhaCungCap timNhaCungCapTheoMa(String maNhaCungCap) {
		NhaCungCap ncc = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		String sql = "Select * from NhaCungCap where maNhaCungCap = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, maNhaCungCap);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maNCC = rs.getString("maNhaCungCap").trim();
				String tenNCC = rs.getString("tenNhaCungCap").trim();
				String diaChi = rs.getString("diaChi").trim();
				String sdt = rs.getString("sdt").trim();
				String email = rs.getString("email").trim();
				ncc = new NhaCungCap(maNCC, tenNCC, diaChi, sdt, email);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ncc;
	}
}
