package bus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.ConnectDB;
import dao.DAOChiTietHoaDon;
import entity.ChiTietHoaDon;
import entity.SanPham;

public class BUSChiTietHoaDon {
	DAOChiTietHoaDon daoCTHD = new DAOChiTietHoaDon();
	public boolean themChiTietHoaDon(String maHoaDon, ChiTietHoaDon cthd) {
		return daoCTHD.themChiTietHoaDon(maHoaDon, cthd);
	}
	public ArrayList<ChiTietHoaDon> layDSChiTietHoaDonCuaHoaDon(String maHD) {
		return daoCTHD.layDSChiTietHoaDonCuaHoaDon(maHD);
	}
}
