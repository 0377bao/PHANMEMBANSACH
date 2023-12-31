package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class DonDoiTra {
	private String maDonDoiTra;
	private LocalDate ngayDoiTra;
	private ArrayList<ChiTietDonDoiTra> dsChiTietDonDoiTra = new ArrayList<>();
	private HoaDon hoaDon;
	private NhanVien nhanVien;
	private String phuongThucDoiTra;
	private int diemHoanTra;

	public String getPhuongThucDoiTra() {
		return phuongThucDoiTra;
	}

	public void setPhuongThucDoiTra(String phuongThucDoiTra) {
		this.phuongThucDoiTra = phuongThucDoiTra;
	}



	public DonDoiTra(String maDonDoiTra, LocalDate ngayDoiTra, ArrayList<ChiTietDonDoiTra> dsChiTietDonDoiTra,
			HoaDon hoaDon, NhanVien nhanVien, String phuongThucDoiTra, int diemHoanTra) {
		super();
		this.maDonDoiTra = maDonDoiTra;
		this.ngayDoiTra = ngayDoiTra;
		this.dsChiTietDonDoiTra = dsChiTietDonDoiTra;
		this.hoaDon = hoaDon;
		this.nhanVien = nhanVien;
		this.phuongThucDoiTra = phuongThucDoiTra;
		this.diemHoanTra = diemHoanTra;
	}

	public String getMaDonDoiTra() {
		return maDonDoiTra;
	}

	public void setMaDonDoiTra(String maDonDoiTra) {
		this.maDonDoiTra = maDonDoiTra;
	}

	public LocalDate getNgayDoiTra() {
		return ngayDoiTra;
	}

	public void setNgayDoiTra(LocalDate ngayDoiTra) {
		this.ngayDoiTra = ngayDoiTra;
	}

	public ArrayList<ChiTietDonDoiTra> getDsChiTietDonDoiTra() {
		return dsChiTietDonDoiTra;
	}

	public void setDsChiTietDonDoiTra(ArrayList<ChiTietDonDoiTra> dsChiTietDonDoiTra) {
		this.dsChiTietDonDoiTra = dsChiTietDonDoiTra;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDonDoiTra);
	}
	
	public float tinhTienCanTra() {
		if(phuongThucDoiTra.equals("Đổi Hàng")) {
			return 0;
		}
		float tongTien = 0;
		for (ChiTietDonDoiTra ctddt : dsChiTietDonDoiTra) {
			tongTien +=ctddt.getGiaBan()*ctddt.getSoLuongTra();
		}
		return tongTien-diemHoanTra*10000;
	}
	
	public int tinhSoLuongDoiHang() {
		int tongSoLuong = 0;
		for(ChiTietDonDoiTra ctddt: dsChiTietDonDoiTra) {
			tongSoLuong += ctddt.getSoLuongTra();
		}
		return tongSoLuong;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DonDoiTra other = (DonDoiTra) obj;
		return Objects.equals(maDonDoiTra, other.maDonDoiTra);
	}


	

	@Override
	public String toString() {
		return "DonDoiTra [maDonDoiTra=" + maDonDoiTra + ", ngayDoiTra=" + ngayDoiTra + ", dsChiTietDonDoiTra="
				+ dsChiTietDonDoiTra + ", hoaDon=" + hoaDon + ", nhanVien=" + nhanVien + ", phuongThucDoiTra="
				+ phuongThucDoiTra + ", diemHoanTra=" + diemHoanTra + "]";
	}

	public int getDiemHoanTra() {
		return diemHoanTra;
	}

	public void setDiemHoanTra(int diemHoanTra) {
		this.diemHoanTra = diemHoanTra;
	}

	

	

}
