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

import entity.ChiTietHoaDon;
import entity.DonDoiTra;
import entity.HoaDon;
import entity.NhanVien;

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
	//Hàm tính ngày trong tuần
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
		
		if((ngayHT-ngayTrongTuan)<=0) {
			cbmodel.addElement(1+"-"+ngayHT);
			return;
		}else {
			cbmodel.addElement(ngayHT-ngayTrongTuan+1+"-"+ngayHT);
			ngayHT -= ngayTrongTuan;
			while(ngayHT>0) {
				if(ngayHT>7) {
					cbmodel.addElement(ngayHT-6+"-"+ngayHT);
				}else {
					cbmodel.addElement(1+"-"+ngayHT);
				}
				ngayHT = ngayHT -7;
			}
			return;
		}
	}
	//Hàm đẩy dữ liệu thống kê chi tiết của nhân viên theo tuần vào bảng
	public void layDuLieuThongKeChiTietCuaNVTheoTuan(DefaultTableModel model, DefaultComboBoxModel<String> cbmodel,NhanVien nv) {
		String thuTrongTuan[]= {"Thứ 2","Thứ 3","Thứ 4","Thứ 5","Thứ 6","Thứ 7","Chủ Nhật"};
		int thu = 0;
		String khoangCach[] = cbmodel.getSelectedItem().toString().split("-");
		if(Integer.parseInt(khoangCach[1])<7) {
			thu = 7-Integer.parseInt(khoangCach[1]);
		}
		for(int i = Integer.parseInt(khoangCach[0]);i<= Integer.parseInt(khoangCach[1]);i++) {
			
			int soHoaDon = dsHDTheoNV(nv, LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),i),LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),i)).size();
			int soDonDoiTra = dsDDTTheoNV(nv, LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),i),LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),i)).size();
			float tongDoanhThu = tongDoanhThu(nv, LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),i),LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),i));
			int tongSP = tongSoSanPham(nv, LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),i),LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),i));
			model.addRow(new Object[] {thuTrongTuan[thu],soHoaDon,tongDoanhThu,tongSP,soDonDoiTra});
			thu+=1;
		}
	}
	//Hàm đẩy dữ liệu thống kê chi tiết của nhân viên theo tuần vào biểu đồ
	public void layDuLieuThongKeChiTietCuaNVTheoTuanVaoBieuDo(DefaultComboBoxModel<String> cbmodel,NhanVien nv,DefaultCategoryDataset dataSet) {
		String thuTrongTuan[]= {"Thứ 2","Thứ 3","Thứ 4","Thứ 5","Thứ 6","Thứ 7","Chủ Nhật"};
		int thu = 0;
		String khoangCach[] = cbmodel.getSelectedItem().toString().split("-");
		if(Integer.parseInt(khoangCach[1])<7) {
			thu = 7-Integer.parseInt(khoangCach[1]);
		}
		for(int i = Integer.parseInt(khoangCach[0]);i<= Integer.parseInt(khoangCach[1]);i++) {
			float tongDoanhThu = tongDoanhThu(nv, LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),i),LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),i));
			dataSet.setValue(tongDoanhThu, "VNĐ", thuTrongTuan[thu]);
			thu +=1;
		}
	}
	// Hàm load dữ liệu vào combobox thống kê doanh thu theo quý
	public void taoDuLieuComBoBoxThongKeCHTheoQuy(DefaultComboBoxModel<String> model) {
		for(int i = LocalDate.now().getYear() ; i>=2020;i--) {
			model.addElement(i+"");
		}
	}
	// Hàm thống kê của cửa hàng theo quý
	public void thongKeThongTinCuaHangTheoQuy(String nam,DefaultTableModel model,DefaultPieDataset dataSet) {
		int namTK = Integer.parseInt(nam);
		LocalDate ngayBDQ1 = LocalDate.of(namTK, 1, 1);
		LocalDate ngayKTQ1 = LocalDate.of(namTK, 3, 31);
		float tongDoanhThuQ1 = 0;
		int tongSLQ1 = 0;
		int tongHoaDonQ1 =0;
		int tongDDTQ1 = 0;
		LocalDate ngayBDQ2 = LocalDate.of(namTK, 4, 1);
		LocalDate ngayKTQ2 = LocalDate.of(namTK, 6, 30);
		float tongDoanhThuQ2 = 0;
		int tongSLQ2 = 0;
		int tongHoaDonQ2 =0;
		int tongDDTQ2 = 0;
		LocalDate ngayBDQ3 = LocalDate.of(namTK, 7, 1);
		LocalDate ngayKTQ3 = LocalDate.of(namTK, 9, 30);
		float tongDoanhThuQ3 = 0;
		int tongSLQ3 = 0;
		int tongHoaDonQ3 =0;
		int tongDDTQ3 = 0;
		LocalDate ngayBDQ4 = LocalDate.of(namTK, 10, 1);
		LocalDate ngayKTQ4 = LocalDate.of(namTK, 12, 31);
		float tongDoanhThuQ4 = 0;
		int tongSLQ4 = 0;
		int tongHoaDonQ4 =0;
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
		model.addRow(new Object[] {"Quý 1",tongHoaDonQ1,tongSLQ1,tongDDTQ1,tongDoanhThuQ1});
		model.addRow(new Object[] {"Quý 2",tongHoaDonQ2,tongSLQ2,tongDDTQ2,tongDoanhThuQ2});
		model.addRow(new Object[] {"Quý 3",tongHoaDonQ3,tongSLQ3,tongDDTQ3,tongDoanhThuQ3});
		model.addRow(new Object[] {"Quý 4",tongHoaDonQ4,tongSLQ4,tongDDTQ4,tongDoanhThuQ4});
		dataSet.setValue("Quý 1", tongDoanhThuQ1);
		dataSet.setValue("Quý 2", tongDoanhThuQ2);
		dataSet.setValue("Quý 3", tongDoanhThuQ3);
		dataSet.setValue("Quý 4", tongDoanhThuQ4);
	}
	//Hàm thống kê cửa hàng theo tháng
	public void thongKeCuaHangTrongThang(String thang,JLabel soHD, JLabel doanhThu, JLabel soLuongSP, JLabel soDDT, DefaultTableModel model) {
		int thangTK = Integer.parseInt(thang.substring(6));
		int soNgayTrongThang = YearMonth.of(LocalDate.now().getYear(), thangTK).lengthOfMonth();
		float tongDoanhThu = 0;
		int tongSL = 0;
		int tongHoaDon =0;
		int tongDDT = 0;
		for(int i=1;i<=soNgayTrongThang;i++) {
			float tDT = 0;
			int tSL = 0;
			int tHD = 0;
			int tDDT =0;
			for (NhanVien nv : busNV.layDSNhanVien()) {
				tDT += tongDoanhThu(nv, LocalDate.of(LocalDate.now().getYear(), thangTK, i),  LocalDate.of(LocalDate.now().getYear(), thangTK, i));
				 tSL += tongSoSanPham(nv, LocalDate.of(LocalDate.now().getYear(), thangTK, i), LocalDate.of(LocalDate.now().getYear(), thangTK, i));
				 tHD += dsHDTheoNV(nv, LocalDate.of(LocalDate.now().getYear(), thangTK, i), LocalDate.of(LocalDate.now().getYear(), thangTK, i)).size();
				 tDDT += dsDDTTheoNV(nv, LocalDate.of(LocalDate.now().getYear(), thangTK, i), LocalDate.of(LocalDate.now().getYear(), thangTK, i)).size();
			}
			tongDoanhThu += tDT;
			tongSL += tSL;
			tongHoaDon += tHD;
			tongDDT += tDDT;
			model.addRow(new Object[] {"Ngày "+i,tHD,tSL,tDDT,tDT});
		}
		soHD.setText(tongHoaDon+"");
		doanhThu.setText(tongDoanhThu +"");
		soLuongSP.setText(tongSL +"");
		soDDT.setText(tongDDT +"");
	}
	// Hàm thống kê nhân viên
	public void thongKeNhanVien(JLabel tongNV, JLabel nvBH, JLabel nvNghi, JLabel nvQL) {
		tongNV.setText(busNV.layDSNhanVien().size()+"");
		for (NhanVien nv : busNV.layDSNhanVien()) {
			
			
		}
	}
}