package bus;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import customUI.MyTable;
import dao.DAOKhachHang;
import entity.KhachHang;

public class BUSKhachHang {
	DAOKhachHang daoKhachHang = new DAOKhachHang();
	public ArrayList<KhachHang> layDSKhachHang() {
		return daoKhachHang.layDSKhachHang();
	}

	public boolean themKhachHang(KhachHang kh) {
		return daoKhachHang.themKhachHang(kh);
	}

	public boolean capNhatThongTinKhachHang(KhachHang kh) {
		return daoKhachHang.capNhatThongTinKhachHang(kh);
	}

	public KhachHang timKhachHangTheoMa(String maKH) {
		return daoKhachHang.timKhachHangTheoMa(maKH);
	}


	public void layLichSuGiaoDichKhachHang(String maKH, DefaultTableModel model, MyTable tb) {
		daoKhachHang.layLichSuGiaoDichKhachHang(maKH, model, tb);
	}

	public int getMaKhachHangMax() {
		return daoKhachHang.getMaKhachHangMax();
	}
}
