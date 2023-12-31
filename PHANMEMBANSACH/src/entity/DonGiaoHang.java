package entity;

import java.util.Objects;

public class DonGiaoHang {
	private String maDonGiaoHang;
	private String tenKhachHang;
	private String sdt;
	private String diaChi;
	private int soKg;
	private boolean trangThai;
	private float soKm;
	private String ghiChu;
	private float tienVanChuyen;
	private String phuongThucThanhToan;
	private HoaDon hoaDon;
	
	public DonGiaoHang(String ma, HoaDon hd) {
		this.maDonGiaoHang = ma;
		this.hoaDon = hd;
	}

	public DonGiaoHang(String maDonGiaoHang, String tenKhachHang, String sdt, String diaChi, int soKg,
			boolean trangThai, String ghiChu, float tienVanChuyen,String phuongThucThanhToan, HoaDon hoaDon) {
		super();
		this.maDonGiaoHang = maDonGiaoHang;
		this.tenKhachHang = tenKhachHang;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.soKg = soKg;
		this.trangThai = trangThai;
		this.ghiChu = ghiChu;
		this.tienVanChuyen = tienVanChuyen;
		this.phuongThucThanhToan = phuongThucThanhToan;
		this.hoaDon = hoaDon;
	}

	public String getMaDonGiaoHang() {
		return maDonGiaoHang;
	}

	public void setMaDonGiaoHang(String maDonGiaoHang) {
		this.maDonGiaoHang = maDonGiaoHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public int getSoKg() {
		return soKg;
	}

	public void setSoKg(int soKg) {
		this.soKg = soKg;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public float getSoKm() {
		return soKm;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}


	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public float getTienVanChuyen() {
		return tienVanChuyen;
	}
	
	
	public String getPhuongThucThanhToan() {
		return phuongThucThanhToan;
	}

	public void setPhuongThucThanhToan(String phuongThucThanhToan) {
		this.phuongThucThanhToan = phuongThucThanhToan;
	}

	public float tinhSoKm(float km) {

		// tính số km gọi bằng google map
		this.soKm = km;
		return this.soKm;
	}

	public float tinhTienVanChuyen() {
		float result = 0;
		// trường hợp giao hàng miễn phí
		if (hoaDon.getThanhTien() >= 3000000) {
			result = 0;
		}
		// trường hợp tính tiền vận chuyển
		if (soKm > 40) {
			return -1; // trường hợp này không giao hàng
		} else {
			if (soKg <= 50) {
				result = soKm * 3000;
			} else if (soKg <= 100) {
				result = soKm * 5000;
			} else if (soKg <= 150) {
				result = soKm * 7000;
			}
		}
		this.tienVanChuyen = result;
		return tienVanChuyen;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDonGiaoHang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DonGiaoHang other = (DonGiaoHang) obj;
		return Objects.equals(maDonGiaoHang, other.maDonGiaoHang);
	}

	@Override
	public String toString() {
		return "DonGiaoHang [maDonGiaoHang=" + maDonGiaoHang + ", tenKhachHang=" + tenKhachHang + ", sdt=" + sdt
				+ ", diaChi=" + diaChi + ", soKg=" + soKg + ", trangThai=" + trangThai + ", soKm=" + soKm + ", ghiChu="
				+ ghiChu + ", tienVanChuyen=" + tienVanChuyen + ", hoaDon=" + hoaDon + "]";
	}

}
