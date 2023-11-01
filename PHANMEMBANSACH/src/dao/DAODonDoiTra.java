package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import bus.BUSChiTietDonDoiTra;
import bus.BUSHoaDon;
import bus.BUSNhanVien;
import connect.ConnectDB;
import entity.ChiTietDonDoiTra;
import entity.ChiTietHoaDon;
import entity.ChuongTrinhKhuyenMai;
import entity.DonDoiTra;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

public class DAODonDoiTra {
	public DonDoiTra layDonDoiTraTheoMa(String maDDT) {
		DonDoiTra donDoiTra = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from DonDoiTra where maDonDoiTra = ?";
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, maDDT);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				HoaDon hd = new BUSHoaDon().timHoaDonTheoMa(rs.getString("maHoaDon").trim());
				NhanVien nv = new BUSNhanVien().layNhanVienTheoMa(rs.getString("maNhanVien").trim());
				String hinhThucDoiTra = rs.getString("hinhThucDoiTra").trim();
				Date ngay = rs.getDate("ngayLap");
				Calendar c = Calendar.getInstance();
				c.setTime(ngay);
				LocalDate ngayLap = LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DAY_OF_MONTH));
				ArrayList<ChiTietDonDoiTra> dsChiTietDonDoiTra = new BUSChiTietDonDoiTra().layChiTietDonDoiTraCuaDonDoiTra(maDDT);
				donDoiTra = new DonDoiTra(maDDT, ngayLap, dsChiTietDonDoiTra, hd, nv, hinhThucDoiTra);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return donDoiTra;
	}
	public ArrayList<DonDoiTra> layHetDSDonDoiTra() {
		ArrayList<DonDoiTra> ds = new ArrayList<>();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from DonDoiTra";
		Statement statement = null;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maDonDoiTra = rs.getString("maDonDoiTra").trim();
				Date ngay = rs.getDate("ngayLap");
				Calendar c = Calendar.getInstance();
				c.setTime(ngay);
				LocalDate ngayLap = LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DAY_OF_MONTH));
				String phuongThucDoiTra = rs.getString("phuongThucDoiTra").trim();
				NhanVien nv = new DAONhanVien().layNhanVien(rs.getString("maNhanVien"));
				ArrayList<ChiTietDonDoiTra> ctddt = new DAOChiTietDonDoiTra().layChiTietDonDoiTraCuaDonDoiTra(maDonDoiTra);
				HoaDon hd = new BUSHoaDon().timHoaDonTheoMa(rs.getString("maHoaDon").trim());
				ds.add(new DonDoiTra(maDonDoiTra, ngayLap, ctddt, hd, nv, phuongThucDoiTra));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}
	public boolean themDonDoiTra(DonDoiTra DonDoiTra) {
		Connection con = ConnectDB.getConnection();
		String sqlHD = "insert into DonDoiTra values(?,?,?,?,?,?,?)";
		int n = 0;
		boolean m = true;
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(sqlHD);
			statement.setString(1, DonDoiTra.getMaDonDoiTra());
			Date date = Date.valueOf(DonDoiTra.getNgayDoiTra());
			statement.setDate(2, date);
			statement.setString(3, DonDoiTra.getPhuongThucDoiTra());
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return (n>0 && m);
	}
	}
