package bus;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import connect.ConnectDB;
import dao.DAOChiTietHoaDon;
import dao.DAOChuongTrinhKhuyenMai;
import dao.DAOHoaDon;
import dao.DAOKhachHang;
import dao.DAONhanVien;
import entity.ChiTietHoaDon;
import entity.ChuongTrinhKhuyenMai;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

public class BUSHoaDon {
	DAOHoaDon daoHoaDon = new DAOHoaDon();
	public ArrayList<HoaDon> layHetDSHoaDon() {
		return daoHoaDon.layHetDSHoaDon();
	}
	
	public HoaDon timHoaDonTheoMa(String maTim) {
		return daoHoaDon.timHoaDonTheoMa(maTim);
	}
	
	public boolean themHoaDon(HoaDon hoaDon) {
		return daoHoaDon.themHoaDon(hoaDon);
	}
}
