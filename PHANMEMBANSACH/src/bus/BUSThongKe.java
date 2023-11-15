package bus;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.YearMonth;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.itextpdf.text.api.Spaceable;

import entity.ChiTietDonDoiTra;
import entity.ChiTietHoaDon;
import entity.DonDoiTra;
import entity.HoaDon;
import entity.NhanVien;
import entity.SanPham;
import tool.Tools;

public class BUSThongKe {
	BUSNhanVien busNV = new BUSNhanVien();
	BUSHoaDon busHD = new BUSHoaDon();
	BUSDonDoiTra busDDT = new BUSDonDoiTra();
	BUSSanPham busSP = new BUSSanPham();

	/**
	 * @wbp.parser.entryPoint
	 */
	public void thongKeCaNhanTrongNgay(JLabel hoaDon, JLabel doanhThu, JLabel slSP, JLabel ddt) {
		int ngay = LocalDate.now().getDayOfMonth();

	}

	// hàm lấy đơn đổi trả trong từ ngày khởi đầu đến ngày kết thúc của nhân viên nv
	public ArrayList<DonDoiTra> dsDDTTheoNV(NhanVien nv, LocalDate x, LocalDate y) {
		ArrayList<DonDoiTra> ds = new ArrayList<>();
		for (DonDoiTra ddt : busDDT.layDonDoiTraTuNgayXDenNgayY(x, y)) {
			if (nv.getMaNhanVien().equals(ddt.getNhanVien().getMaNhanVien())) {
				ds.add(ddt);
			}
		}
		return ds;
	}

	// hàm lấy số hóa đơn từ ngày khởi đầu đến ngày kết thúc của nhân viên nv
	public ArrayList<HoaDon> dsHDTheoNV(NhanVien nv, LocalDate x, LocalDate y) {
		ArrayList<HoaDon> ds = new ArrayList<>();
		for (HoaDon hd : busHD.layDSHoaDonTuNgayXDenNgayY(x, y)) {
			if (nv.getMaNhanVien().equals(hd.getNhanVien().getMaNhanVien())) {
				ds.add(hd);
			}
		}
		return ds;
	}

	// hàm lấy doanh thu từ ngày khởi đầu đến ngày kết thúc của nhân viên nv
	public float tongDoanhThu(NhanVien nv, LocalDate x, LocalDate y) {
		float tongDoangThu = 0;
		for (HoaDon hd : busHD.layDSHoaDonTuNgayXDenNgayY(x, y)) {
			if (nv.getMaNhanVien().equals(hd.getNhanVien().getMaNhanVien())) {
				tongDoangThu += hd.getThanhTien();
			}
		}
		return tongDoangThu;
	}

	// hàm lấy số sản phẩm từ ngày khởi đầu đến ngày kết thúc của nhân viên nv
	public int tongSoSanPham(NhanVien nv, LocalDate x, LocalDate y) {
		int tongSoSanPham = 0;
		for (HoaDon hd : busHD.layDSHoaDonTuNgayXDenNgayY(x, y)) {
			if (nv.getMaNhanVien().equals(hd.getNhanVien().getMaNhanVien())) {
				for (ChiTietHoaDon cthd : hd.getDsChiTietHoaDon()) {
					tongSoSanPham += cthd.getSoLuongMua();
				}
			}
		}
		return tongSoSanPham;
	}

	// Hàm tính ngày trong tuần
	public int tinhSoNgayTrongTuanNay() {
		int ngayTrongTuan = 0;
		String thuHT = LocalDate.now().getDayOfWeek().toString();
		switch (thuHT) {
		case "MONDAY": {
			ngayTrongTuan = 1;
			break;
		}
		case "TUESDAY": {
			ngayTrongTuan = 2;
			break;
		}
		case "WEDNESDAY": {
			ngayTrongTuan = 3;
			break;
		}
		case "THURSDAY": {
			ngayTrongTuan = 4;
			break;
		}
		case "FRIDAY": {
			ngayTrongTuan = 5;
			break;
		}
		case "SATURDAY": {
			ngayTrongTuan = 6;
			break;
		}
		case "SUNDAY": {
			ngayTrongTuan = 7;
			break;
		}
		}
		return ngayTrongTuan;

	}

	// Tạo dữ liệu cho combobox thống kê trong ngày
	public void taoDuLieuComBoBoxTKCuaNV(DefaultComboBoxModel<String> cbmodel) {
		int ngayHT = LocalDate.now().getDayOfMonth();
		int ngayTrongTuan = tinhSoNgayTrongTuanNay();

		if ((ngayHT - ngayTrongTuan) <= 0) {
			cbmodel.addElement("ngày" + 1 + "-" + "ngày" + ngayHT);
			return;
		} else {
			cbmodel.addElement("ngày" + (ngayHT - ngayTrongTuan + 1) + "-ngày" + ngayHT);
			ngayHT -= ngayTrongTuan;
			while (ngayHT > 0) {
				if (ngayHT > 7) {
					cbmodel.addElement("ngày" + (ngayHT - 6) + "-ngày" + ngayHT);
				} else {
					cbmodel.addElement("ngày" + 1 + "-ngày" + ngayHT);
				}
				ngayHT = ngayHT - 7;
			}
			return;
		}
	}

	// Hàm đẩy dữ liệu thống kê chi tiết của nhân viên theo tuần vào bảng
	public void layDuLieuThongKeChiTietCuaNVTheoTuan(DefaultTableModel model, DefaultComboBoxModel<String> cbmodel,
			NhanVien nv) {
		String thuTrongTuan[] = { "Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7", "Chủ Nhật" };
		int thu = 0;
		String khoangCach[] = cbmodel.getSelectedItem().toString().replace("ngày", "").split("-");
		if (Integer.parseInt(khoangCach[1]) < 7) {
			thu = 7 - Integer.parseInt(khoangCach[1]);
		}
		for (int i = Integer.parseInt(khoangCach[0]); i <= Integer.parseInt(khoangCach[1]); i++) {

			int soHoaDon = dsHDTheoNV(nv, LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), i),
					LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), i)).size();
			int soDonDoiTra = dsDDTTheoNV(nv, LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), i),
					LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), i)).size();
			float tongDoanhThu = tongDoanhThu(nv,
					LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), i),
					LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), i));
			int tongSP = tongSoSanPham(nv, LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), i),
					LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), i));
			model.addRow(new Object[] { thuTrongTuan[thu], soHoaDon, Tools.dinhDangTien(tongDoanhThu), tongSP,
					soDonDoiTra });
			thu += 1;
		}
	}

	// Hàm đẩy dữ liệu thống kê chi tiết của nhân viên theo tuần vào biểu đồ
	public void layDuLieuThongKeChiTietCuaNVTheoTuanVaoBieuDo(DefaultComboBoxModel<String> cbmodel, NhanVien nv,
			DefaultCategoryDataset dataSet) {
		String thuTrongTuan[] = { "Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7", "Chủ Nhật" };
		int thu = 0;
		String khoangCach[] = cbmodel.getSelectedItem().toString().replace("ngày", "").split("-");
		if (Integer.parseInt(khoangCach[1]) < 7) {
			thu = 7 - Integer.parseInt(khoangCach[1]);
		}
		for (int i = Integer.parseInt(khoangCach[0]); i <= Integer.parseInt(khoangCach[1]); i++) {
			float tongDoanhThu = tongDoanhThu(nv,
					LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), i),
					LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), i));
			dataSet.setValue(tongDoanhThu, "VNĐ", thuTrongTuan[thu]);
			thu += 1;
		}
	}

	// Hàm load dữ liệu vào combobox thống kê doanh thu theo quý
	public void taoDuLieuComBoBoxThongKeCHTheoQuy(DefaultComboBoxModel<String> model) {
		for (int i = LocalDate.now().getYear(); i >= 2020; i--) {
			model.addElement(i + "");
		}
	}

	// Hàm thống kê của cửa hàng theo quý
	public void thongKeThongTinCuaHangTheoQuy(String nam, DefaultTableModel model, DefaultPieDataset dataSet) {
		int namTK = Integer.parseInt(nam);
		LocalDate ngayBDQ1 = LocalDate.of(namTK, 1, 1);
		LocalDate ngayKTQ1 = LocalDate.of(namTK, 3, 31);
		float tongDoanhThuQ1 = 0;
		int tongSLQ1 = 0;
		int tongHoaDonQ1 = 0;
		int tongDDTQ1 = 0;
		LocalDate ngayBDQ2 = LocalDate.of(namTK, 4, 1);
		LocalDate ngayKTQ2 = LocalDate.of(namTK, 6, 30);
		float tongDoanhThuQ2 = 0;
		int tongSLQ2 = 0;
		int tongHoaDonQ2 = 0;
		int tongDDTQ2 = 0;
		LocalDate ngayBDQ3 = LocalDate.of(namTK, 7, 1);
		LocalDate ngayKTQ3 = LocalDate.of(namTK, 9, 30);
		float tongDoanhThuQ3 = 0;
		int tongSLQ3 = 0;
		int tongHoaDonQ3 = 0;
		int tongDDTQ3 = 0;
		LocalDate ngayBDQ4 = LocalDate.of(namTK, 10, 1);
		LocalDate ngayKTQ4 = LocalDate.of(namTK, 12, 31);
		float tongDoanhThuQ4 = 0;
		int tongSLQ4 = 0;
		int tongHoaDonQ4 = 0;
		int tongDDTQ4 = 0;
		for (NhanVien nv : busNV.layDSNhanVien()) {
			tongDoanhThuQ1 += tongDoanhThu(nv, ngayBDQ1, ngayKTQ1);
			tongSLQ1 += tongSoSanPham(nv, ngayBDQ1, ngayKTQ1);
			tongHoaDonQ1 += dsHDTheoNV(nv, ngayBDQ1, ngayKTQ1).size();
			tongDDTQ1 += dsDDTTheoNV(nv, ngayBDQ1, ngayKTQ1).size();
			tongDoanhThuQ2 += tongDoanhThu(nv, ngayBDQ2, ngayKTQ2);
			tongSLQ2 += tongSoSanPham(nv, ngayBDQ2, ngayKTQ2);
			tongHoaDonQ2 += dsHDTheoNV(nv, ngayBDQ2, ngayKTQ2).size();
			tongDDTQ2 += dsDDTTheoNV(nv, ngayBDQ2, ngayKTQ2).size();
			tongDoanhThuQ3 += tongDoanhThu(nv, ngayBDQ3, ngayKTQ3);
			tongSLQ3 += tongSoSanPham(nv, ngayBDQ3, ngayKTQ3);
			tongHoaDonQ3 += dsHDTheoNV(nv, ngayBDQ3, ngayKTQ3).size();
			tongDDTQ3 += dsDDTTheoNV(nv, ngayBDQ3, ngayKTQ3).size();
			tongDoanhThuQ4 += tongDoanhThu(nv, ngayBDQ4, ngayKTQ4);
			tongSLQ4 += tongSoSanPham(nv, ngayBDQ4, ngayKTQ4);
			tongHoaDonQ4 += dsHDTheoNV(nv, ngayBDQ4, ngayKTQ4).size();
			tongDDTQ4 += dsDDTTheoNV(nv, ngayBDQ4, ngayKTQ4).size();
		}
		model.addRow(new Object[] { "Quý 1", tongHoaDonQ1, tongSLQ1, tongDDTQ1, Tools.dinhDangTien(tongDoanhThuQ1) });
		model.addRow(new Object[] { "Quý 2", tongHoaDonQ2, tongSLQ2, tongDDTQ2, Tools.dinhDangTien(tongDoanhThuQ2) });
		model.addRow(new Object[] { "Quý 3", tongHoaDonQ3, tongSLQ3, tongDDTQ3, Tools.dinhDangTien(tongDoanhThuQ3) });
		model.addRow(new Object[] { "Quý 4", tongHoaDonQ4, tongSLQ4, tongDDTQ4, Tools.dinhDangTien(tongDoanhThuQ4) });
		dataSet.setValue("Quý 1", tongDoanhThuQ1);
		dataSet.setValue("Quý 2", tongDoanhThuQ2);
		dataSet.setValue("Quý 3", tongDoanhThuQ3);
		dataSet.setValue("Quý 4", tongDoanhThuQ4);
	}
	// Hàm thống kê quý hiện tại
	
	
	// Hàm thống kê cửa hàng theo tháng
	public void thongKeCuaHangTrongThang(String thang, JLabel soHD, JLabel doanhThu, JLabel soLuongSP, JLabel soDDT,
			DefaultTableModel model) {
		int thangTK = Integer.parseInt(thang.substring(6));
		int soNgayTrongThang = YearMonth.of(LocalDate.now().getYear(), thangTK).lengthOfMonth();
		float tongDoanhThu = 0;
		int tongSL = 0;
		int tongHoaDon = 0;
		int tongDDT = 0;
		for (int i = 1; i <= soNgayTrongThang; i++) {
			float tDT = 0;
			int tSL = 0;
			int tHD = 0;
			int tDDT = 0;
			for (NhanVien nv : busNV.layDSNhanVien()) {
				tDT += tongDoanhThu(nv, LocalDate.of(LocalDate.now().getYear(), thangTK, i),
						LocalDate.of(LocalDate.now().getYear(), thangTK, i));
				tSL += tongSoSanPham(nv, LocalDate.of(LocalDate.now().getYear(), thangTK, i),
						LocalDate.of(LocalDate.now().getYear(), thangTK, i));
				tHD += dsHDTheoNV(nv, LocalDate.of(LocalDate.now().getYear(), thangTK, i),
						LocalDate.of(LocalDate.now().getYear(), thangTK, i)).size();
				tDDT += dsDDTTheoNV(nv, LocalDate.of(LocalDate.now().getYear(), thangTK, i),
						LocalDate.of(LocalDate.now().getYear(), thangTK, i)).size();
			}
			tongDoanhThu += tDT;
			tongSL += tSL;
			tongHoaDon += tHD;
			tongDDT += tDDT;
			model.addRow(new Object[] { "Ngày " + i, tHD, tSL, tDDT, Tools.dinhDangTien(tDT) });
		}
		soHD.setText(tongHoaDon + "");
		doanhThu.setText(Tools.dinhDangTien(tongDoanhThu).replace("VND", "") + "");
		soLuongSP.setText(tongSL + "");
		soDDT.setText(tongDDT + "");
	}

	// Hàm thống kê nhân viên
	public void thongKeNhanVien(JLabel tongNV, JLabel nvBH, JLabel nvNghi, JLabel nvQL) {
		tongNV.setText(busNV.layDSNhanVien().size() + "");
		for (NhanVien nv : busNV.layDSNhanVien()) {

		}
	}

	// Hàm tính 10 sản phẩm bán chạy nhất
	public void lay10SPBanChayNhat(String trangThaiTK, DefaultTableModel modelS, DefaultTableModel modelVPP,
			LocalDate x, LocalDate y) {
		ArrayList<String> SP = new ArrayList<>();
		ArrayList<Integer> SL = new ArrayList<>();
		SP.add("");
		SL.add(0);
		int bienChay = 1;
		int flag = 0;

		for (NhanVien nv : busNV.layDSNhanVien()) {

			for (HoaDon hd : dsHDTheoNV(nv, x, y)) {

				for (ChiTietHoaDon cthd : hd.getDsChiTietHoaDon()) {
					for (int i = 0; i < SP.size(); ++i) {
						if (i == 0 && SP.size() == 1) {
							SP.set(i, cthd.getSanPham().getMaSanPham());
							SL.set(i, cthd.getSoLuongMua());
							SP.add("");
							SL.add(0);
							flag = 1;
							break;
						}
						if (SP.get(i).equals(cthd.getSanPham().getMaSanPham())) {
							SL.set(i, SL.get(i) + cthd.getSoLuongMua());
							flag = 1;
							break;
						}
					}
					if (flag == 0) {
						SP.add(cthd.getSanPham().getMaSanPham());
						SL.add(cthd.getSoLuongMua());
						bienChay++;

					}
					flag = 0;
				}
			}
		}

		SP.remove(1);
		SL.remove(1);

		int soVPP = 0, soSach = 0;
		while ((soVPP <= 10 || soSach <= 10) && SP.size() > 0) {
			int max = 0;
			int node = 0;
			int min = SL.get(0);

			if (trangThaiTK.equals("Bán chạy nhất")) {
				for (int i = 0; i < SP.size(); i++) {
					if (max < SL.get(i)) {
						max = SL.get(i);
						node = i;
					}
				}
			} else {
				for (int i = 0; i < SP.size(); i++) {
					if (min > SL.get(i)) {
						min = SL.get(i);
						node = i;
					}
				}
			}

			SanPham sp = busSP.timKiemSanPham(SP.get(node));

			if (sp.getMaSanPham().startsWith("SPS")) {

				if (soSach < 10) {
					modelS.addRow(new Object[] { SP.get(node), sp.getTenSanPham(), SL.get(node),
							Tools.dinhDangTien(sp.getGiaBan()), sp.getPhanTramLoiNhuan() });
					soSach += 1;
				}
				SP.remove(node);
				SL.remove(node);

			}
			if (sp.getMaSanPham().startsWith("SPVPP")) {
				if (soVPP < 10) {
					modelVPP.addRow(new Object[] { SP.get(node), sp.getTenSanPham(), SL.get(node),
							Tools.dinhDangTien(sp.getGiaBan()), sp.getPhanTramLoiNhuan() });
					soVPP += 1;
				}
				SP.remove(node);
				SL.remove(node);
			}

		}
	}

	public void lay10SPBiDoiTraNhieuNhat(DefaultTableModel modelDT, LocalDate x, LocalDate y) {
		ArrayList<String> SP = new ArrayList<>();
		ArrayList<Integer> SL = new ArrayList<>();
		SP.add("");
		SL.add(0);

		int flag = 0;
		for (NhanVien nv : busNV.layDSNhanVien()) {
			
		
		for (DonDoiTra ddt : dsDDTTheoNV(nv, x, y)) {
			for (ChiTietDonDoiTra ctddt : ddt.getDsChiTietDonDoiTra()) {
				for (int i = 0; i < SP.size(); ++i) {
					if (i == 0 && SP.size() == 1) {
						SP.set(i, ctddt.getSanPham().getMaSanPham());
						SL.set(i, ctddt.getSoLuongTra());
						SP.add("");
						SL.add(0);
						flag = 1;
						break;
					}
					if (SP.get(i).equals(ctddt.getSanPham().getMaSanPham())) {
						SL.set(i, SL.get(i) + ctddt.getSoLuongTra());
						flag = 1;
						break;
					}
				}
				if (flag == 0) {
					SP.add(ctddt.getSanPham().getMaSanPham());
					SL.add(ctddt.getSoLuongTra());

				}
				flag = 0;
			}
		}
		}
		if(SP.size()==1) {
			return ;
		}
		SP.remove(1);
		SL.remove(1);
		while (SP.size() > 0) {
			int max = 0;
			int node = 0;

			for (int i = 0; i < SP.size(); i++) {
				if (max < SL.get(i)) {
					max = SL.get(i);
					node = i;
				}
				SanPham sp = busSP.timKiemSanPham(SP.get(node));
				modelDT.addRow(new Object[] { SP.get(node), sp.getTenSanPham(), SL.get(node),
						Tools.dinhDangTien(sp.getGiaBan()), sp.getPhanTramLoiNhuan() });
				SP.remove(node);
				SL.remove(node);
			}
		}
	}

	// Hàm thống kê sản phẩm
	public void ThongKeSanPham( String trangThaiTK, String Quy, DefaultTableModel modelSach,
			DefaultTableModel modelVPP) {

		LocalDate x = LocalDate.now();
		LocalDate y = LocalDate.now();
		if (Quy.equals("Quý 1")) {
			x = LocalDate.of(LocalDate.now().getYear(), 1, 1);
			y = LocalDate.of(LocalDate.now().getYear(), 3, 31);
		} else if (Quy.equals("Quý 2")) {
			x = LocalDate.of(LocalDate.now().getYear(), 4, 1);
			y = LocalDate.of(LocalDate.now().getYear(), 6, 30);
		} else if (Quy.equals("Quý 3")) {
			x = LocalDate.of(LocalDate.now().getYear(), 7, 1);
			y = LocalDate.of(LocalDate.now().getYear(), 9, 30);
		} else if (Quy.equals("Quý 4")) {
			x = LocalDate.of(LocalDate.now().getYear(), 10, 1);
			y = LocalDate.of(LocalDate.now().getYear(), 12, 31);
		}
		modelSach.setRowCount(0);
		modelVPP.setRowCount(0);
		lay10SPBanChayNhat(trangThaiTK, modelSach, modelVPP, x, y);
	}

	// Hàm hiển thị thông tin thống kê nhân viên
	public void hienThiThongTinThongKeNV(JLabel tongNV, JLabel nvDaNghi, JLabel nvBanHang, JLabel nvQuanLy) {
		tongNV.setText(busNV.layDSNhanVien().size() + "");
		int nvdaNghi = 0, nvBH = 0, nvQL = 0;

		for (NhanVien nv : busNV.layDSNhanVien()) {
			if (nv.getTrangThai().equals("Đã nghỉ")) {
				nvdaNghi++;
			} else {
				if (nv.getChucVu().equals("Quản lý")) {
					nvQL++;
				} else {
					nvBH++;
				}
			}
		}
		nvDaNghi.setText(nvdaNghi + "");
		nvBanHang.setText(nvBH + "");
		nvQuanLy.setText(nvQL + "");
	}
}
