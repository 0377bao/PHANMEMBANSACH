package entity;

public class ChiTietDonDoiTra {
	private int soLuongTra;
	private String lyDo;
	private SanPham sanPham;
	private float giaBan;

	public ChiTietDonDoiTra(int soLuongTra, String lyDo, SanPham sanPham, float giaBan) {
		super();
		this.soLuongTra = soLuongTra;
		this.lyDo = lyDo;
		this.sanPham = sanPham;
		this.giaBan = giaBan;
	}

	public float getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(float giaBan) {
		this.giaBan = giaBan;
	}

	public int getSoLuongTra() {
		return soLuongTra;
	}

	public void setSoLuongTra(int soLuongTra) {
		this.soLuongTra = soLuongTra;
	}

	public String getLyDo() {
		return lyDo;
	}

	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	@Override
	public String toString() {
		return "ChiTietDonDoiTra [soLuongTra=" + soLuongTra + ", lyDo=" + lyDo + ", sanPham=" + sanPham + ", giaBan="
				+ giaBan + "]";
	}

}
