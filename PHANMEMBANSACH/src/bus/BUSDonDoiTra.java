package bus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import customUI.MyTable;
import dao.DAODonDoiTra;
import entity.ChiTietDonDoiTra;
import entity.ChiTietHoaDon;
import entity.ChuongTrinhKhuyenMai;
import entity.DonDoiTra;
import entity.HoaDon;
import entity.KhachHang;

public class BUSDonDoiTra {
	private DAODonDoiTra daoDonDoiTra = new DAODonDoiTra();

	public DonDoiTra layDonDoiTraTheoMa(String maDDT) {
		return daoDonDoiTra.layDonDoiTraTheoMa(maDDT);
	}

	public ArrayList<DonDoiTra> layHetDSDonDoiTra() {
		return daoDonDoiTra.layHetDSDonDoiTra();
	}

	public boolean themDonDoiTra(DonDoiTra donDoiTra) {
		return daoDonDoiTra.themDonDoiTra(donDoiTra);
	}

	public ArrayList<DonDoiTra> layDonDoiTraTheoHoaDon(String maHD) {
		return daoDonDoiTra.layDonDoiTraTheoHoaDon(maHD);
	}

	// tạo mã đơn đổi trả
	public String taoMaDonDoiTra(String maHoaDon) {
		return "DDT" + maHoaDon.substring(2, maHoaDon.length()) + 'v'
				+ (daoDonDoiTra.layDonDoiTraTheoHoaDon(maHoaDon).size() + 1);
	}

	// lấy danh sách đơn đổi trả
	public void layDanhSachDonDoiTraVaoTable(DefaultTableModel model, ArrayList<DonDoiTra> ds) {
		for (DonDoiTra donDoiTra : ds) {
			int tongSoLuongSP = 0;
			for (ChiTietDonDoiTra ctddt : donDoiTra.getDsChiTietDonDoiTra()) {
				tongSoLuongSP += ctddt.getSoLuongTra();
			}
			model.addRow(new Object[] { donDoiTra.getMaDonDoiTra(), donDoiTra.getHoaDon().getMaHoaDon(),
					donDoiTra.getNhanVien().getTenNhanVien(), donDoiTra.getHoaDon().getKhachHang().getTenKhachHang(),
					donDoiTra.getNgayDoiTra(), tongSoLuongSP });
		}

	}

	// lấy hóa đơn của khách hàng trong 7 ngày gần nhất
	public void layDanhSachHoaDonKhachHangTrong7Ngay(DefaultTableModel model, String sdt) {
		LocalDate hanChoPhep = LocalDate.now().minusDays(6);
		model.setRowCount(0);
		if (new BUSKhachHang().timKhachHangTheoSDT(sdt) != null) {

			for (HoaDon hd : new BUSHoaDon()
					.layLichSuGiaoDichKhachHang(new BUSKhachHang().timKhachHangTheoSDT(sdt).getMaKhachHang())) {

				if (!hd.getNgayLap().isBefore(hanChoPhep)) {
					int soLuongSP = 0;
					for (ChiTietHoaDon cthd : hd.getDsChiTietHoaDon()) {
						soLuongSP += cthd.getSoLuongMua();
					}
					model.addRow(new Object[] { hd.getMaHoaDon(), hd.getNgayLap(), hd.getNhanVien().getTenNhanVien(),
							soLuongSP, hd.getThanhTien() });
				}
			}
		}
	}

	// hiện danh sách sản phẩm trong hóa đơn được chọn
	public void hienDanhSachSanPhamTrongHoaDon(DefaultTableModel model, String mahd) {
		model.setRowCount(0);
		for (ChiTietHoaDon cthd : new BUSHoaDon().timHoaDonTheoMa(mahd).getDsChiTietHoaDon()) {
			model.addRow(new Object[] { cthd.getSanPham().getMaSanPham(), cthd.getSanPham().getTenSanPham(),
					cthd.getSoLuongMua(), cthd.getGiaBan() });
		}
	}

	// Tính điểm hoàn trả
	public int soDiemHoanTra(float tongTien, int diemTrongHD) {
		int nuaTien = (int) tongTien / 2;
		if (nuaTien / 10000 > diemTrongHD) {
			return diemTrongHD;
		}
		return nuaTien / 10000;
	}

	// Tính tiền và số lượng đổi trả trong đơn
	public void tinhTongDDT(String PhuongThucDoiTra, MyTable tb, JTextField tongTien, JTextField tongSL,
			JTextField diemHT, int diemTrongHD, ChuongTrinhKhuyenMai ctkm) {
		if (PhuongThucDoiTra.equals("Đổi Hàng")) {
			int tong = 0;
			for (int i = 0; i < tb.getRowCount(); i++) {
				tong += Integer.parseInt(tb.getValueAt(i, 2).toString());
			}
			tongSL.setText(tong + "");
		} else {
			float tong = 0;
			for (int i = 0; i < tb.getRowCount(); i++) {
				tong += Integer.parseInt(tb.getValueAt(i, 2).toString())
						* (Float.parseFloat(tb.getValueAt(i, 3).toString())
								- Float.parseFloat(tb.getValueAt(i, 3).toString())
										* new BUSHoaDon().hamLayGiamGiaCuaChiTietHoaDon(ctkm,
												new BUSSanPham().timKiemSanPham(tb.getValueAt(i, 0).toString())));
			}
			tongTien.setText(tong - soDiemHoanTra(tong, diemTrongHD) * 10000 + "");
			diemHT.setText(soDiemHoanTra(tong, diemTrongHD) + "");
		}
	}

	// Tìm kiếm đơn đổi trả
	public void timKiemBangMaDonDoiTra(ArrayList<DonDoiTra> ds, String maDDT) {
		if(!maDDT.equals("")) {
			ArrayList<DonDoiTra> tam = new ArrayList<>();
			Pattern p = Pattern.compile(maDDT);
			for (DonDoiTra ddt : ds) {
				Matcher m = p.matcher(ddt.getMaDonDoiTra());
				if(m.find()) {
					tam.add(ddt);
				}
			}
			ds.clear();
			ds.addAll(tam);
		}
	}
	public void timKiemBangSDT(ArrayList<DonDoiTra> ds, String sdt) {
		if(!sdt.equals("")) {
			ArrayList<DonDoiTra> tam = new ArrayList<>();
			Pattern p = Pattern.compile(sdt);
			for (DonDoiTra ddt : ds) {
				Matcher m = p.matcher(ddt.getHoaDon().getKhachHang().getSdt());
				if(m.find()) {
					tam.add(ddt);
				}
			}
			ds.clear();
			ds.addAll(tam);
		}
	}
	public void timKiemBangMaHoaDon(ArrayList<DonDoiTra> ds, String maHD) {
		if(!maHD.equals("")) {
			ArrayList<DonDoiTra> tam = new ArrayList<>();
			Pattern p = Pattern.compile(maHD);
			for (DonDoiTra ddt : ds) {
				Matcher m = p.matcher(ddt.getHoaDon().getMaHoaDon());
				if(m.find()) {
					tam.add(ddt);
				}
			}
			ds.clear();
			ds.addAll(tam);
		}
	}
	public ArrayList<DonDoiTra> layDonDoiTraTuNgayXDenNgayY(LocalDate x, LocalDate y){
		return daoDonDoiTra.layDonDoiTraTuNgayXDenNgayY(x, y);
	}

}
