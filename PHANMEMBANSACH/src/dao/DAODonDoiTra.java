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
			while (rs.next()) {
				HoaDon hd = new BUSHoaDon().timHoaDonTheoMa(rs.getString("maHoaDon").trim());
				NhanVien nv = new BUSNhanVien().layNhanVienTheoMa(rs.getString("maNhanVien").trim());
				String hinhThucDoiTra = rs.getString("hinhThucDoiTra").trim();
				Date ngay = rs.getDate("ngayDoiTra");
				Calendar c = Calendar.getInstance();
				c.setTime(ngay);
				LocalDate ngayLap = LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1,
						c.get(Calendar.DAY_OF_MONTH));
				ArrayList<ChiTietDonDoiTra> dsChiTietDonDoiTra = new BUSChiTietDonDoiTra()
						.layChiTietDonDoiTraCuaDonDoiTra(maDDT);
				int diemHoanTra = rs.getInt("diemHoanTra");
				donDoiTra = new DonDoiTra(maDDT, ngayLap, dsChiTietDonDoiTra, hd, nv, hinhThucDoiTra, diemHoanTra);
			}
		} catch (Exception e) {
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
			while (rs.next()) {
				String maDonDoiTra = rs.getString("maDonDoiTra").trim();
				Date ngay = rs.getDate("ngayDoiTra");
				Calendar c = Calendar.getInstance();
				c.setTime(ngay);
				LocalDate ngayLap = LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1,
						c.get(Calendar.DAY_OF_MONTH));
				String phuongThucDoiTra = rs.getString("hinhThucDoiTra").trim();
				NhanVien nv = new DAONhanVien().layNhanVienTheoMa(rs.getString("maNhanVien"));
				ArrayList<ChiTietDonDoiTra> ctddt = new BUSChiTietDonDoiTra()
						.layChiTietDonDoiTraCuaDonDoiTra(maDonDoiTra);
				HoaDon hd = new BUSHoaDon().timHoaDonTheoMa(rs.getString("maHoaDon").trim());
				int diemHoanTra = rs.getInt("diemHoanTra");
				ds.add(new DonDoiTra(maDonDoiTra, ngayLap, ctddt, hd, nv, phuongThucDoiTra, diemHoanTra));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}

	public boolean themDonDoiTra(DonDoiTra donDoiTra) {

		Connection con = ConnectDB.getConnection();
		String sql = "insert into DonDoiTra values(?,?,?,?,?,?,?,?)";
		int n = 0;
		boolean m = true;
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, donDoiTra.getMaDonDoiTra());
			Date date = Date.valueOf(donDoiTra.getNgayDoiTra());
			statement.setDate(2, date);
			statement.setFloat(3, donDoiTra.tinhTienCanTra());
			statement.setString(5, donDoiTra.getNhanVien().getMaNhanVien());
			statement.setString(4, donDoiTra.getHoaDon().getMaHoaDon());
			statement.setInt(6, donDoiTra.tinhSoLuongDoiHang());
			statement.setString(7, donDoiTra.getPhuongThucDoiTra());
			statement.setInt(8, donDoiTra.getDiemHoanTra());
			n = statement.executeUpdate();
			for (ChiTietDonDoiTra ct : donDoiTra.getDsChiTietDonDoiTra()) {
				m = new BUSChiTietDonDoiTra().themChiTietDonDoiTra(donDoiTra.getMaDonDoiTra(), ct);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return (n > 0 && m);
	}

	public ArrayList<DonDoiTra> layDonDoiTraTheoHoaDon(String maHD) {
		ArrayList<DonDoiTra> ds = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from DonDoiTra where maHoaDon = ?";
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, maHD);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maDonDoiTra = rs.getString("maDonDoiTra");
				HoaDon hd = new BUSHoaDon().timHoaDonTheoMa(rs.getString("maHoaDon").trim());
				NhanVien nv = new BUSNhanVien().layNhanVienTheoMa(rs.getString("maNhanVien").trim());
				String hinhThucDoiTra = rs.getString("hinhThucDoiTra").trim();
				Date ngay = rs.getDate("ngayDoiTra");
				Calendar c = Calendar.getInstance();
				c.setTime(ngay);
				LocalDate ngayLap = LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1,
						c.get(Calendar.DAY_OF_MONTH));
				ArrayList<ChiTietDonDoiTra> dsChiTietDonDoiTra = new BUSChiTietDonDoiTra()
						.layChiTietDonDoiTraCuaDonDoiTra(maDonDoiTra);
				int diemHoanTra = rs.getInt("diemHoanTra");
				ds.add(new DonDoiTra(maDonDoiTra, ngayLap, dsChiTietDonDoiTra, hd, nv, hinhThucDoiTra, diemHoanTra));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
	}

	public ArrayList<DonDoiTra> layDonDoiTraTuNgayXDenNgayY(LocalDate x, LocalDate y) {
		ArrayList<DonDoiTra> ds = new ArrayList<DonDoiTra>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from DonDoiTra where ngayDoiTra BETWEEN ? AND ?";
		PreparedStatement statement = null;
		try {
			Date ngayx = Date.valueOf(x);
			Date ngayy = Date.valueOf(y);
			statement = con.prepareStatement(sql);
			statement.setDate(1, ngayx);
			statement.setDate(2, ngayy);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maDDT = rs.getString("maDonDoiTra");
				HoaDon hd = new BUSHoaDon().timHoaDonTheoMa(rs.getString("maHoaDon").trim());
				NhanVien nv = new BUSNhanVien().layNhanVienTheoMa(rs.getString("maNhanVien").trim());
				String hinhThucDoiTra = rs.getString("hinhThucDoiTra").trim();
				Date ngay = rs.getDate("ngayDoiTra");
				Calendar c = Calendar.getInstance();
				c.setTime(ngay);
				LocalDate ngayLap = LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1,
						c.get(Calendar.DAY_OF_MONTH));
				ArrayList<ChiTietDonDoiTra> dsChiTietDonDoiTra = new BUSChiTietDonDoiTra()
						.layChiTietDonDoiTraCuaDonDoiTra(maDDT);
				int diemHoanTra = rs.getInt("diemHoanTra");
				ds.add(new DonDoiTra(maDDT, ngayLap, dsChiTietDonDoiTra, hd, nv, hinhThucDoiTra, diemHoanTra));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
	}
}
