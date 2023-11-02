package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.ChiTietHoaDon;
import entity.SanPham;

public class DAOChiTietHoaDon {
	public boolean themChiTietHoaDon(String maHoaDon, ChiTietHoaDon cthd) {
		int n = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "insert into ChiTietHoaDon values (?, ?, ?, ?, ?)";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, cthd.getSoLuongMua());
			statement.setFloat(2, cthd.getGiaBan());
			String maSP = cthd.getSanPham().getMaSanPham();
			if(maSP.startsWith("SPS")) {
				statement.setString(3, maSP);
				statement.setString(5, "Trống");
			} else {
				statement.setString(5, maSP);
				statement.setString(3, "Trống");
			}
			statement.setString(4, maHoaDon);
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public ArrayList<ChiTietHoaDon> layDSChiTietHoaDonCuaHoaDon(String maHD) {
		ArrayList<ChiTietHoaDon> ds = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from ChiTietHoaDon where maHoaDon = ?";
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, maHD);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				int soLuongMua = rs.getInt("soLuongMua");
				float giaBan = rs.getFloat("giaBan");
				String maSach = rs.getString("maSach");
				String maVPP = rs.getString("maVanPhongPham");
				SanPham sp;
				if(maSach.equals("Trống")) {
					sp = new DAOSach().timSachTheoMa(maVPP);
				} else {
					sp = new DAOVanPhongPham().timVanPhongPhamTheoMa(maSach);
				}
				ds.add(new ChiTietHoaDon(soLuongMua, giaBan, sp));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}
}
