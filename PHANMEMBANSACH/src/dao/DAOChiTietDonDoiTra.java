package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bus.BUSSach;
import bus.BUSVanPhongPham;
import connect.ConnectDB;
import entity.ChiTietDonDoiTra;
import entity.SanPham;
import entity.VanPhongPham;


public class DAOChiTietDonDoiTra {
	public ArrayList<ChiTietDonDoiTra> layChiTietDonDoiTraCuaDonDoiTra(String maDDT){
		ArrayList<ChiTietDonDoiTra> ds = new ArrayList<>();
		Connection con = ConnectDB.getConnection();
		String sql = "Select * from ChiTietHoaDon where maDonDoiTra = ?";
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, maDDT);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String maSach = rs.getString("maSach").trim();
				String maVPP = rs.getString("maVanPhongPham").trim();
				String lyDo = rs.getString("lyDo").trim();
				int soLuongTra = rs.getInt("soLuongTra");
				float giaBan = rs.getFloat("giaBan");
				SanPham sp ;
				if(maVPP.equals("Trống")) {
					sp = new BUSSach().laySachTheoMa(maSach);
				}else {
					sp = new BUSVanPhongPham().layVPPTheoMa(maVPP);
				}
				ds.add(new ChiTietDonDoiTra(soLuongTra, lyDo, sp,giaBan));

			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
	}
	public boolean themChiTietDonDoiTra(String maDDT,ChiTietDonDoiTra ctddt) {
		int n = 0;
		Connection con = ConnectDB.getConnection();
		String sql = "insert into ChiTietDonDoiTra values(?,?,?,?,?,?)";
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(sql);
			statement.setInt(1, ctddt.getSoLuongTra());
			statement.setString(2, ctddt.getLyDo());
			statement.setString(4, maDDT);
			statement.setFloat(5, ctddt.getGiaBan());
			if(ctddt.getSanPham().getMaSanPham().startsWith("SPS")) {
				statement.setString(3, ctddt.getSanPham().getMaSanPham());
				statement.setString(5, "Trống");
			}else {
				statement.setString(5, ctddt.getSanPham().getMaSanPham());
				statement.setString(3, "Trống");
			}
			n = statement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n > 0;
	}
}
