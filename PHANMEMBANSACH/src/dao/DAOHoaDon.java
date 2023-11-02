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
import bus.BUSNhanVien;
import connect.ConnectDB;
import entity.ChiTietHoaDon;
import entity.ChuongTrinhKhuyenMai;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

public class DAOHoaDon {
	public ArrayList<HoaDon> layHetDSHoaDon() {
		ArrayList<HoaDon> ds = new ArrayList<>();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from HoaDon";
		Statement statement = null;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maHoaDon = rs.getString("maHoaDon").trim();
				Date ngay = rs.getDate("ngayLap");
				Calendar c = Calendar.getInstance();
				c.setTime(ngay);
				LocalDate ngayLap = LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DAY_OF_MONTH));
				String phuongThucThanhToan = rs.getString("phuongThucThanhToan").trim();
				String ghiChu = rs.getString("ghiChu").trim();
				int diemGiamGia = rs.getInt("diemGiamGia");
				float giamGia = rs.getFloat("giamGia");
				NhanVien nv = new DAONhanVien().layNhanVienTheoMa(rs.getString("maNhanVien"));
				KhachHang kh = new DAOKhachHang().timKhachHangTheoMa(rs.getString("maKhachHang"));
				ChuongTrinhKhuyenMai ctkm = new DAOChuongTrinhKhuyenMai().timChuongTrinhKhuyenMaiTheoMa(rs.getString("maCTKM"));
				ArrayList<ChiTietHoaDon> cthd = new DAOChiTietHoaDon().layDSChiTietHoaDonCuaHoaDon(maHoaDon);
				ds.add(new HoaDon(maHoaDon, ngayLap, phuongThucThanhToan, ghiChu, diemGiamGia, giamGia, nv, kh, ctkm, cthd));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}

	public HoaDon timHoaDonTheoMa(String maTim) {
		HoaDon hd = null;
		Connection con = ConnectDB.getConnection();
		String sql = "select * from HoaDon where maHoaDon = ?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, maTim);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String maHoaDon = rs.getString("maHoaDon").trim();
				Date ngay = rs.getDate("ngayLap");
				Calendar c = Calendar.getInstance();
				c.setTime(ngay);
				LocalDate ngayLap = LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DAY_OF_MONTH));
				String phuongThucThanhToan = rs.getString("phuongThucThanhToan").trim();
				String ghiChu = rs.getString("ghiChu").trim();
				int diemGiamGia = rs.getInt("diemGiamGia");
				float giamGia = rs.getFloat("giamGia");
				NhanVien nv = new BUSNhanVien().layNhanVienTheoMa(rs.getString("maNhanVien"));
				KhachHang kh = new DAOKhachHang().timKhachHangTheoMa(rs.getString("maKhachHang"));
				ChuongTrinhKhuyenMai ctkm = new DAOChuongTrinhKhuyenMai().timChuongTrinhKhuyenMaiTheoMa(rs.getString("maCTKM"));
				ArrayList<ChiTietHoaDon> cthd = new DAOChiTietHoaDon().layDSChiTietHoaDonCuaHoaDon(maHoaDon);
				hd = new HoaDon(maHoaDon, ngayLap, phuongThucThanhToan, ghiChu, diemGiamGia, giamGia, nv, kh, ctkm, cthd);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hd;
	}
	
	public boolean themHoaDon(HoaDon hoaDon) {
		Connection con = ConnectDB.getConnection();
		String sqlHD = "insert into HoaDon values(?,?,?,?,?,?,?,?,?,?)";
		int n = 0;
		boolean m = true;
		PreparedStatement statementHD = null;
		try {
			statementHD = con.prepareStatement(sqlHD);
			statementHD.setString(1, hoaDon.getMaHoaDon());
			Date date = Date.valueOf(hoaDon.getNgayLap());
			statementHD.setDate(2, date);
			statementHD.setString(3, hoaDon.getHinhThucThanhToan());
			statementHD.setString(4, hoaDon.getGhiChu());
			statementHD.setFloat(5, hoaDon.getThanhTien());
			statementHD.setString(6, hoaDon.getCtkm().getMaCTKM());
			statementHD.setString(7, hoaDon.getNhanVien().getMaNhanVien());
			statementHD.setString(8, hoaDon.getKhachHang().getMaKhachHang());
			statementHD.setDouble(9, hoaDon.getDiemGiamGia());
			statementHD.setDouble(10, hoaDon.getGiamGia());
			n = statementHD.executeUpdate();
			for (ChiTietHoaDon ct : hoaDon.getDsChiTietHoaDon()) {
				m = new DAOChiTietHoaDon().themChiTietHoaDon(hoaDon.getMaHoaDon(), ct);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return (n>0 && m);
	}
}
