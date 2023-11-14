package bus;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import entity.MucKhuyenMai;
import entity.NhanVien;
import entity.Sach;
import entity.SanPham;
import entity.VanPhongPham;

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
	
	public float hamLayGiamGiaCuaChiTietHoaDon(ChuongTrinhKhuyenMai ctkm, SanPham sp) {
		String theLoai = "";
		if(sp instanceof Sach) theLoai = sp.getTheLoai();
		else theLoai = ((VanPhongPham) sp).getDanhMuc().getTenDanhMuc();
		for (MucKhuyenMai mkm : ctkm.getDsMucKhuyenMai()) {
			if(mkm.getTenMucKhuyenMai().equals(theLoai)) return mkm.getTiLeKhuyenMai();
		}
		return 0;
	}
	
	public String taoMaHoaDon() {
        long timestamp = Instant.now().toEpochMilli();
        String maHoaDon = String.valueOf(timestamp % 1000000);
        return "HD" + maHoaDon;
	}
	
	public ArrayList<HoaDon> locHoaDonQLHD(String maHD, String maNV, String sdt, String httt, java.util.Date tuNgay, java.util.Date denNgay, String tongTien) {
		ArrayList<HoaDon> ds = new ArrayList<>();
		for (HoaDon hoaDon : layHetDSHoaDon()) {
			if(kiemTraHoaDonLocQLHD(hoaDon, maHD, maNV, sdt, httt, tuNgay, denNgay, tongTien)) ds.add(hoaDon);
		}
		return ds;
	}
	
	public boolean kiemTraHoaDonLocQLHD(HoaDon hd, String maHD, String maNV, String sdt, String httt, java.util.Date tuNgay, java.util.Date denNgay, String tongTien) {
		Pattern pmaHD = Pattern.compile(maHD,Pattern.CASE_INSENSITIVE);
		Matcher mmaHD = pmaHD.matcher(hd.getMaHoaDon());
		if(!mmaHD.find()) return false;
		Pattern pNV = Pattern.compile(maNV,Pattern.CASE_INSENSITIVE);
		Matcher mNV = pNV.matcher(hd.getNhanVien().getMaNhanVien());
		if(!mNV.find()) return false;
		Pattern pSDT = Pattern.compile(sdt);
		Matcher mSDT = pSDT.matcher(hd.getKhachHang().getSdt());
		if(!mSDT.find()) return false;
		if(!hd.getHinhThucThanhToan().equals(httt) && !httt.equals("Tất cả")) return false;
		if(tuNgay != null) {
	        LocalDate lcdtuNgay = tuNgay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	        if(lcdtuNgay.isAfter(hd.getNgayLap())) return false;
 		}
		if(denNgay != null) {
			LocalDate lcddenNgay = denNgay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			if(lcddenNgay.isBefore(hd.getNgayLap())) return false;
		}
		if(tongTien.equals("Dưới 1.000.000")) {
			if(hd.tinhTongTien() >= 1000000) return false;
		}
		if(tongTien.equals("Từ 1.000.000 đến 2.000.000")) {
			if(hd.tinhTongTien() < 1000000 || hd.tinhTongTien() >= 2000000) return false;
		}
		if(tongTien.equals("Từ 2.000.000 đến 5.000.000")) {
			if(hd.tinhTongTien() < 2000000 || hd.tinhTongTien() >= 5000000) return false;
		}
		if(tongTien.equals("Từ 5.000.000 đến 10.000.000")) {
			if(hd.tinhTongTien() < 5000000 || hd.tinhTongTien() >= 10000000) return false;
		}
		if(tongTien.equals("Trên 10.000.000")) {
			if(hd.tinhTongTien() <= 10000000) return false;
		}
		return true;
	}

	
	public int layTongSoHoaDonTrongHeThong() {
		return daoHoaDon.layTongSoHoaDonTrongHeThong();
	}
	public ArrayList<HoaDon> layLichSuGiaoDichKhachHang(String maKH) {
		return daoHoaDon.layLichSuGiaoDichKhachHang(maKH);
	}
	public ArrayList<HoaDon> layDSHoaDonTuNgayXDenNgayY(LocalDate x, LocalDate y){
		return daoHoaDon.layDSHoaDonTuNgayXDenNgayY(x, y);
	}
}
