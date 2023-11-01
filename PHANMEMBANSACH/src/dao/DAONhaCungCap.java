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

	public DAONhaCungCap() {

	}

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
				String maNCC = rs.getString("maNhaCungCap");
				String tenNCC = rs.getString("tenNhaCungCap");
				String diaChi = rs.getString("diaChi");
				String sdt = rs.getString("sdt");
				String email = rs.getString("email");
				NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, diaChi, sdt, email);
				dsNCC.add(ncc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNCC;
	}

	// thêm nhà cung cấp
	public boolean taoNCC(NhaCungCap ncc) {
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
			ps.setString(4, ncc.getEmail());
			ps.setString(5, ncc.getSdt());
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

	// sửa nhà cung cấp
	public boolean capNhatNCC(NhaCungCap ncc) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		String sql = "update NhaCungCap set tenNhaCungCap = ?, diaChi = ?, sdt = ?, email = ?";
		int n = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ncc.getTenNhaCungCap());
			ps.setString(2, ncc.getDiaChi());
			ps.setString(3, ncc.getEmail());
			ps.setString(4, ncc.getSdt());
			ps.setString(5, ncc.getMaNhaCungCap());
			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	// lấy nhà cung cấp theo mã
	public NhaCungCap layNCCTheoMa(String maNhaCungCap) {
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
				String maNCC = rs.getString("maNhaCungCap");
				String tenNCC = rs.getString("tenNhaCungCap");
				String diaChi = rs.getString("diaChi");
				String sdt = rs.getString("sdt");
				String email = rs.getString("email");
				ncc = new NhaCungCap(maNCC, tenNCC, diaChi, sdt, email);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ncc;
	}
}
