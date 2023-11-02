package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connect.ConnectDB;
import entity.NhaCungCap;

public class DAONhaCungCap {
	public NhaCungCap timNhaCungCapTheoMa(String maNCC) {
		NhaCungCap ncc = null;
		Connection con = ConnectDB.getConnection();
		String sql = "select * from NhaCungCap where maNhaCungCap = ?";
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, maNCC);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maNhaCungCap = rs.getString("maNhaCungCap").trim();
				String tenNhaCungCap = rs.getString("tenNhaCungCap").trim();;
				String sdt = rs.getString("sdt").trim();;
				String email = rs.getString("email").trim();;
				String diaChi = rs.getString("diaChi").trim();;
				ncc = new NhaCungCap(maNhaCungCap, tenNhaCungCap, sdt, email, diaChi);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return ncc;
	}
}
