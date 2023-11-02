package entity;

import java.util.Objects;

public class SanPham {
	private String maSanPham;
	private String tenSanPham;
	private int soLuongTon;
	private float giaNhap;
	private String theLoai;
	private String ke;
	private String hinhAnh;
	private float thue;
	private float phanTramLoiNhuan;
	private String trangThai;
	private NhaCungCap nhaCungCap;
	public SanPham(String maSanPham, String tenSanPham, int soLuongTon, float giaNhap, String theLoai, String ke,
			String hinhAnh, float thue, float phanTramLoiNhuan, String trangThai,
			NhaCungCap nhaCungCap) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.soLuongTon = soLuongTon;
		this.giaNhap = giaNhap;
		this.theLoai = theLoai;
		this.ke = ke;
		this.hinhAnh = hinhAnh;
		this.thue = thue;
		this.phanTramLoiNhuan = phanTramLoiNhuan;
		this.trangThai = trangThai;
		this.nhaCungCap = nhaCungCap;
	}


	public SanPham(String maSanPham) {
		super();
		this.maSanPham = maSanPham;
	}


	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	public float getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(float giaNhap) {
		this.giaNhap = giaNhap;
	}

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	public String getKe() {
		return ke;
	}

	public void setKe(String ke) {
		this.ke = ke;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public float getThue() {
		return thue;
	}

	public void setThue(float thue) {
		this.thue = thue;
	}

	public float getPhanTramLoiNhuan() {
		return phanTramLoiNhuan;
	}

	public void setPhanTramLoiNhuan(float phanTramLoiNhuan) {
		this.phanTramLoiNhuan = phanTramLoiNhuan;
	}

	public float getGiaBan() {
		return this.giaNhap * (1 + this.phanTramLoiNhuan);
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}


	@Override
	public int hashCode() {
		return Objects.hash(maSanPham);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return Objects.equals(maSanPham, other.maSanPham);
	}


	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", soLuongTon=" + soLuongTon
				+ ", giaNhap=" + giaNhap + ", theLoai=" + theLoai + ", ke=" + ke + ", hinhAnh=" + hinhAnh + ", thue="
				+ thue + ", phanTramLoiNhuan=" + phanTramLoiNhuan + ", trangThai=" + trangThai
				+ ", nhaCungCap=" + nhaCungCap + ", giaBan=" + this.getGiaBan() + "]";
	}
}
