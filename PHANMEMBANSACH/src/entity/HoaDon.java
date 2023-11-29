package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

import bus.BUSHoaDon;

public class HoaDon {
	private String maHoaDon;
	private LocalDate ngayLap;
	private String hinhThucThanhToan;
	private String ghiChu;
	private int diemGiamGia;
	private float giamGia;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private ChuongTrinhKhuyenMai ctkm;
	private float tienKhachDua;
	private ArrayList<ChiTietHoaDon> dsChiTietHoaDon = new ArrayList<>();
	private float thanhTien;

	public HoaDon(String maHoaDon, LocalDate ngayLap, String hinhThucThanhToan, String ghiChu, int diemGiamGia,
			float giamGia, NhanVien nhanVien, KhachHang khachHang, ChuongTrinhKhuyenMai ctkm,
			ArrayList<ChiTietHoaDon> dsChiTietHoaDon, float tienKhachDua) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLap = ngayLap;
		this.hinhThucThanhToan = hinhThucThanhToan;
		this.ghiChu = ghiChu;
		this.diemGiamGia = diemGiamGia;
		this.giamGia = giamGia;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.ctkm = ctkm;
		this.dsChiTietHoaDon = dsChiTietHoaDon;
		this.thanhTien = this.getThanhTien();
		this.tienKhachDua = tienKhachDua;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public LocalDate getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(LocalDate ngayLap) {
		this.ngayLap = ngayLap;
	}

	public String getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}

	public void setHinhThucThanhToan(String hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public int getDiemGiamGia() {
		return diemGiamGia;
	}

	public void setDiemGiamGia(int diemGiamGia) {
		this.diemGiamGia = diemGiamGia;
	}

	public float getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(float giamGia) {
		this.giamGia = giamGia;
	}
	
	public float getTienKhachDua() {
		return this.tienKhachDua;
	}
	
	public void setTienKhachDua(float tienKhachDua) {
		this.tienKhachDua = tienKhachDua;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public ChuongTrinhKhuyenMai getCtkm() {
		return ctkm;
	}

	public void setCtkm(ChuongTrinhKhuyenMai ctkm) {
		this.ctkm = ctkm;
	}

	public ArrayList<ChiTietHoaDon> getDsChiTietHoaDon() {
		return dsChiTietHoaDon;
	}

	public void setDsChiTietHoaDon(ArrayList<ChiTietHoaDon> dsChiTietHoaDon) {
		this.dsChiTietHoaDon = dsChiTietHoaDon;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(maHoaDon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHoaDon, other.maHoaDon);
	}
	
	public float tinhTongTien() {
		float result = 0;
		for (ChiTietHoaDon cthd : dsChiTietHoaDon) {
			result += cthd.tinhThanhTien();
		}
		return result;
	}
	
	public float tinhGiamGia() {
		float result = 0;
		for(ChiTietHoaDon cthd : dsChiTietHoaDon) {
			float giamGia = new BUSHoaDon().hamLayGiamGiaCuaChiTietHoaDon(this.ctkm, cthd.getSanPham());
			result += cthd.tinhThanhTien() * giamGia / 100;
		}
		return result;
	}
	
	public float getThanhTien() {
		return tinhTongTien() - tinhGiamGia() - (diemGiamGia * 10000) + tinhThue();
	}
	
	public float tinhTienThua() {
		return this.tienKhachDua - getThanhTien();
	}
	
	public float tinhThue() {
		float result = 0;
		for(ChiTietHoaDon cthd : dsChiTietHoaDon) {
			result += cthd.getGiaBan() * cthd.getSanPham().getThue() / 100 * cthd.getSoLuongMua();

		}
		return result;
	}

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLap=" + ngayLap + ", hinhThucThanhToan=" + hinhThucThanhToan
				+ ", ghiChu=" + ghiChu + ", diemGiamGia=" + diemGiamGia + ", giamGia=" + giamGia + ", nhanVien="
				+ nhanVien + ", khachHang=" + khachHang + ", ctkm=" + ctkm + "tienKhachDua=" + tienKhachDua + ", dsChiTietHoaDon=" + dsChiTietHoaDon
				+ "]";
	}

	
}
