package entity;

public class Sach extends SanPham {
	private String tacGia;
	private String nhaXuatBan;
	private int namXuatBan;

	public Sach(String maSanPham, String tenSanPham, int soLuongTon, float giaNhap, String theLoai, String ke,
			String hinhAnh, float thue, float phanTramLoiNhuan, String trangThai, NhaCungCap nhaCungCap, String tacGia,
			String nhaXuatBan, int namXuatBan) {
		super(maSanPham, tenSanPham, soLuongTon, giaNhap, theLoai, ke, hinhAnh, thue, phanTramLoiNhuan, trangThai, nhaCungCap);
		this.tacGia = tacGia;
		this.nhaXuatBan = nhaXuatBan;
		this.namXuatBan = namXuatBan;
	}

	public Sach(String maSanPham) {
		super(maSanPham);
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	@Override
	public String toString() {
		return super.toString() + "Sach [tacGia=" + tacGia + ", nhaXuatBan=" + nhaXuatBan + ", namXuatBan=" + namXuatBan + "]";
	}

}
