package view;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import bus.BUSChuongTrinhKhuyenMai;
import bus.BUSHoaDon;
import bus.BUSKhachHang;
import bus.BUSNhanVien;
import bus.BUSSanPham;
import connect.ConnectDB;
import entity.ChiTietHoaDon;
import entity.ChuongTrinhKhuyenMai;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;

public class ThemHoaDon {
	
	static Random random = new Random();
	
	public static void main(String[] args) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i < 100; i++) {
			new BUSHoaDon().themHoaDon(ranDomHoaDon());
		}
		
	}
	
	public static String random(int so, int doDai) {
		String chuoi = "";
        // Sinh số nguyên ngẫu nhiên từ 0 đến 9
        while(chuoi.length() != doDai) {
        	chuoi += random.nextInt(so);
        }
        return chuoi;
	}
	
	public static int randomSo(int so) {
        return random.nextInt(so) + 1;
	}
	
	public static int randomSoTu0(int so) {
        return random.nextInt(so + 1);
	}
	
	public static HoaDon ranDomHoaDon() {
		String maHoaDon = "";
		maHoaDon = "HD" + random(10, 6);
		
		int thang = randomSo(12);
		int ngay = 0;
		if(thang == 1 || thang == 3 || thang == 5 || thang == 7 || thang == 8 || thang == 10 || thang == 12) {
			ngay = randomSo(31);
		} else if (thang == 2) {
			ngay = randomSo(30);
		} else {
			ngay = randomSo(29);
		}
		
		int nam = randomSoTu0(2);
		LocalDate ngayLap = LocalDate.of(2020 + nam, thang, ngay);
		
		int phuongThuc = randomSo(2);
		String pt = "";
		if(phuongThuc == 1) {
			pt = "Tiền mặt";
		} else {
			pt = "Chuyển khoản";
		}
		
		int maChuongTrinhKhuyenMai = randomSoTu0(9);
		ChuongTrinhKhuyenMai ctkm = new BUSChuongTrinhKhuyenMai().timChuongTrinhKhuyenMaiTheoMa("CTKM" + maChuongTrinhKhuyenMai);
		
		int maNhanVien = randomSo(10);
		NhanVien nhanVien = new BUSNhanVien().layNhanVienTheoMa("NV" + maNhanVien);
		
		int maKhachHang = randomSoTu0(8);
		KhachHang khachHang = new BUSKhachHang().timKhachHangTheoMa("KH" + maKhachHang);
		
		ArrayList<ChiTietHoaDon> dsCTHD = new ArrayList<>();
		int soSanPham = randomSo(10);
		for(int i = 0; i < soSanPham; i++) {
			int sanPhamNao = randomSo(2);
			String maSp = "";
			if(sanPhamNao == 1) {
				maSp = "SPS";
				maSp += randomSo(20);
			} else {
				maSp = "SPVPP";
				maSp += randomSo(34);
			}
			SanPham sanPham = new BUSSanPham().timKiemSanPham(maSp);
			
			int soLuongMua = randomSo(5);
			
			dsCTHD.add(new ChiTietHoaDon(soLuongMua, sanPham.getGiaBan(), sanPham));
		}
		
		int diemGiamGia = randomSo(5) * 5;
		
		HoaDon hoaDon = new HoaDon(maHoaDon, ngayLap, pt, "", diemGiamGia, 0, nhanVien, khachHang, ctkm, dsCTHD, soSanPham);
		hoaDon.setTienKhachDua(hoaDon.getThanhTien() + randomSoTu0(10) * 10000);
		return hoaDon;
	}
}
