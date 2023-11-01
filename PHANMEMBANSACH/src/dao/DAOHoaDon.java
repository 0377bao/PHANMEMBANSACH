package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import connect.ConnectDB;
import entity.ChiTietHoaDon;
import entity.ChuongTrinhKhuyenMai;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

public class DAOHoaDon {
	public HoaDon timHoaDonTheoMa(String maTim) {
		HoaDon hd = null;
		Connection con = ConnectDB.getConnection();
		String sql = "select * from HoaDon where maHoaDon = ?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, maTim);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String maHoaDon = rs.getString("maHoaDon");
				Date ngay = rs.getDate("ngayLap");
				Calendar c = Calendar.getInstance();
				c.setTime(ngay);
				LocalDate ngayLap = LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DAY_OF_MONTH));
				String phuongThucThanhToan = rs.getString("phuongThucThanhToan");
				String ghiChu = rs.getString("ghiChu");
				int diemGiamGia = rs.getInt("diemGiamGia");
				float giamGia = rs.getFloat("giamGia");
				NhanVien nv = new DAONhanVien().layNhanVien(rs.getString("maNhanVien"));
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
}
