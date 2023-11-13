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
