package bus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.table.DefaultTableModel;

import dao.DAOSanPham;
import entity.Sach;
import entity.SanPham;
import entity.VanPhongPham;

public class BUSSanPham {
	private DAOSanPham daoSP = new DAOSanPham();
	public String mes = "";

	public ArrayList<SanPham> layDSSanPham() {
		return daoSP.layDSSanPham();
	}

	// lấy dữ liệu sách đưa lên bảng
	public void doDuLieuSachVaoBang(DefaultTableModel modelSach) {
		for (SanPham s : daoSP.layDSSanPham()) {
			if (s instanceof Sach)
				modelSach.addRow(
						new Object[] { s.getMaSanPham(), s.getTenSanPham(), s.getNhaCungCap().getTenNhaCungCap(),
								((Sach) s).getTacGia(), s.getTheLoai(), ((Sach) s).getNhaXuatBan(),
								((Sach) s).getNamXuatBan(), s.getKe(), s.getSoLuongTon(), s.getGiaNhap() });
		}
	}

	// tạo mã sách
	public String taoMaSach() {
		int max = 0;
		for (SanPham sanPham : daoSP.layDSSanPham()) {
			if (sanPham.getMaSanPham().startsWith("SPS")) {
				max++;
			}
		}
		return "SPS" + (max + 1);
	}

	// validData sách
	public boolean validDataSach(String maSanPham, String tenSanPham, String soLuongTon, String giaNhap, String theLoai,
			String ke, String hinhAnh, String thue, String loiNhuan, String tacGia, String nhaXB, String namXB) {
		if (maSanPham.equals("")) {
			mes = "Vui lòng nhấn chọn Tạo mã";
			return false;
		}
		if (tenSanPham.equals("")) {
			mes = "Vui lòng nhập tên sản phẩm";
			return false;
		}
		if (theLoai.equals("")) {
			mes = "Vui lòng nhập thể loại";
			return false;
		} else {
			if (!theLoai.matches("[\\p{L}0-9/.,' -]+")) {
				mes = "Thể loại không chứa ký tự đặc biệt";
				return false;
			}
		}
		if (!soLuongTon.equals("")) {
			try {
				int sl = Integer.parseInt(soLuongTon);
				if (sl < 0) {
					mes = "Số lượng không được âm";
					return false;
				}
			} catch (NumberFormatException e) {
				mes = "Số lượng phải là số nguyên dương";
				return false;
			}
		} else {
			mes = "Vui lòng nhập số lượng";
		}
		if (!thue.equals("")) {
			try {
				double x = Double.parseDouble(thue);
				if (x < 0) {
					mes = "Thuế không được âm";
					return false;
				}
			} catch (NumberFormatException e) {
				mes = "Thuế phải là số dương";
				return false;
			}
		} else {
			mes = "Vui lòng nhập thuế";
		}
		if (!giaNhap.equals("")) {
			try {
				double x = Double.parseDouble(giaNhap);
				if (x < 0) {
					mes = "Giá nhập không được âm";
					return false;
				}
			} catch (NumberFormatException e) {
				mes = "Giá nhập phải là số dương";
				return false;
			}
		} else {
			mes = "Vui lòng nhập giá nhập";
		}
		if (!loiNhuan.equals("")) {
			try {
				double x = Double.parseDouble(loiNhuan);
				if (x < 0) {
					mes = "Lợi nhuận không được âm";
					return false;
				}
			} catch (NumberFormatException e) {
				mes = "Lợi nhuận phải là số dương";
				return false;
			}
		} else {
			mes = "Vui lòng nhập lợi nhuận";
		}
		if (ke.equals("")) {
			mes = "Vui lòng nhập tên kệ";
			return false;
		} else {
			if (!ke.matches("^[A-C]\\d+$")) {
				mes = "Tên kệ bắt đầu là A hoặc B hoặc C theo sau là số";
				return false;
			}
		}
		if (tacGia.equals("")) {
			mes = "Vui lòng nhập tác giả";
			return false;
		} else {
			if (!tacGia.matches("[\\p{L}0-9 ]+")) {
				mes = "Tác giả không chứa ký tự đặc biệt";
				return false;
			}
		}
		if (nhaXB.equals("")) {
			mes = "Vui lòng nhập tên nhà xuất bản";
			return false;
		}
		if (!namXB.equals("")) {
			try {
				LocalDate localDate = LocalDate.now();
				int year = localDate.getYear();
				int nam = Integer.parseInt(namXB);
				if (nam < 0 || nam > year) {
					mes = "Năm xuất bản không được âm và nhỏ hơn năm hiện tại";
					return false;
				}
			} catch (NumberFormatException e) {
				mes = "Năm xuất bản phải là số nguyên";
				return false;
			}
		} else {
			mes = "Vui lòng nhập năm xuất bản";
		}
		if (hinhAnh == null) {
			mes = "Vui lòng chọn ảnh";
			return false;
		}
		return true;
	}

	// thêm sản phẩm
	public boolean themSanPham(SanPham sp) {
		if (sp.getMaSanPham().startsWith("SPS"))
			return daoSP.themSach((Sach) sp);
		else
			return daoSP.themVanPhongPham((VanPhongPham) sp);
	}

	// lọc sách theo trạng thái
	public ArrayList<SanPham> locSachTheoTrangThai(String trangThai) {
		ArrayList<SanPham> dsSachTheoTrangThai = new ArrayList<>();
		for (SanPham sanPham : daoSP.layDSSanPham()) {
			if (sanPham.getMaSanPham().startsWith("SPS") && sanPham.getTrangThai().equals(trangThai)) {
				dsSachTheoTrangThai.add(sanPham);
			}
		}
		return dsSachTheoTrangThai;
	}

	// cập nhật sản phẩm
	public boolean capNhatSanPham(SanPham sp) {
		if (sp.getMaSanPham().startsWith("SPS"))
			return daoSP.capNhatSach((Sach) sp);
		else
			return daoSP.capNhatVanPhongPham((VanPhongPham) sp);
	}

	// tìm kiếm sản phẩm theo mã
	public SanPham timKiemSanPham(String maSP) {
		SanPham sp = null;
		if(maSP.toUpperCase().startsWith("SPS")) sp = daoSP.timSachTheoMa(maSP);
		else sp = daoSP.timVanPhongPhamTheoMa(maSP);
		return sp;
	}

	// tìm sách theo tên
	public ArrayList<SanPham> timSachTheoTen(ArrayList<SanPham> ds, String ten) {
		ArrayList<SanPham> temp = new ArrayList<>();
		Pattern p = Pattern.compile(ten, Pattern.CASE_INSENSITIVE);
		for (SanPham sanPham : ds) {
			Matcher m = p.matcher(sanPham.getTenSanPham());
			if (m.find()) {
				temp.add(sanPham);
			}
		}
		ds.clear();
		ds.addAll(temp);
		return ds;
	}

	// tìm sách theo mã nhà cung cấp
	public ArrayList<SanPham> locSachTheoNCC(String maNCC) {
		ArrayList<SanPham> dsSach = daoSP.layDSSanPham();
		ArrayList<SanPham> temp = new ArrayList<>();
		for (SanPham sanPham : dsSach) {
			if (sanPham.getMaSanPham().startsWith("SPS") && sanPham.getNhaCungCap().getMaNhaCungCap().equals(maNCC)) {
				temp.add(sanPham);
			}
			if (sanPham.getMaSanPham().startsWith("SPS") && maNCC.equals("Tất cả")) {
				temp.add(sanPham);
			}
		}
		dsSach.clear();
		dsSach.addAll(temp);
		return dsSach;
	}

	// lọc sách theo năm xuất bản
	public ArrayList<SanPham> locSachTheoNamXB(ArrayList<SanPham> ds, int namXB) {
		ArrayList<SanPham> temp = new ArrayList<>();
		for (SanPham sanPham : ds) {
			if (((Sach) sanPham).getNamXuatBan() == namXB) {
				temp.add(sanPham);
			}
		}
		ds.clear();
		ds.addAll(temp);
		return ds;
	}

	// lọc sách theo thể loại
	public ArrayList<SanPham> locSachTheoTheLoai(ArrayList<SanPham> ds, String theLoai) {
		ArrayList<SanPham> temp = new ArrayList<>();
		Pattern p = Pattern.compile(theLoai, Pattern.CASE_INSENSITIVE);
		for (SanPham sanPham : ds) {
			Matcher m = p.matcher(sanPham.getTheLoai());
			if (m.find()) {
				temp.add(sanPham);
			}
		}
		ds.clear();
		ds.addAll(temp);
		return ds;
	}

	// lọc sách theo tác giả
	public ArrayList<SanPham> locSachTheoTacGia(ArrayList<SanPham> ds, String tacGia) {
		ArrayList<SanPham> temp = new ArrayList<>();
		Pattern p = Pattern.compile(tacGia, Pattern.CASE_INSENSITIVE);
		for (SanPham sanPham : ds) {
			Matcher m = p.matcher(((Sach) sanPham).getTacGia());
			if (m.find()) {
				temp.add(sanPham);
			}
		}
		ds.clear();
		ds.addAll(temp);
		return ds;
	}

	// kiểm tra số lượng sách gần hết
	public ArrayList<SanPham> layDSSachGanHet() {
		ArrayList<SanPham> dsSach = new ArrayList<>();
		for (SanPham sanPham : daoSP.layDSSanPham()) {
			if (sanPham instanceof Sach) {
				if (sanPham.getSoLuongTon() < 10) {
					dsSach.add(sanPham);
				}
			}
		}
		return dsSach;
	}

//// lấy dữ liệu văn phòng phẩm đưa lên bảng
	public void doDuLieuVPPVaoBang(DefaultTableModel modelVPP) {
		for (SanPham vpp : daoSP.layDSSanPham()) {
			if (vpp instanceof VanPhongPham)
				modelVPP.addRow(new Object[] { vpp.getMaSanPham(), vpp.getTenSanPham(),
						vpp.getNhaCungCap().getTenNhaCungCap(), ((VanPhongPham) vpp).getDanhMuc().getTenDanhMuc(),
						vpp.getTheLoai(), ((VanPhongPham) vpp).getChatLieu(), vpp.getKe(), vpp.getSoLuongTon(),
						vpp.getGiaNhap() });
		}
	}

	// kiểm tra số lượng vpp gần hết
	public ArrayList<SanPham> layDSVPPGanHet() {
		ArrayList<SanPham> dsVPP = new ArrayList<>();
		for (SanPham sanPham : daoSP.layDSSanPham()) {
			if (sanPham instanceof VanPhongPham) {
				if (sanPham.getSoLuongTon() < 10) {
					dsVPP.add(sanPham);
				}
			}
		}
		return dsVPP;
	}

	// lọc vpp theo nhà cung cấp
	public ArrayList<SanPham> locVPPTheoNCC(String maNCC) {
		ArrayList<SanPham> dsVPP = daoSP.layDSSanPham();
		ArrayList<SanPham> temp = new ArrayList<>();
		for (SanPham sanPham : dsVPP) {
			if (sanPham.getMaSanPham().startsWith("SPVPP") && maNCC.equals("Tất cả")) {
				temp.add(sanPham);
			} else {
				if (sanPham.getMaSanPham().startsWith("SPVPP")
						&& sanPham.getNhaCungCap().getMaNhaCungCap().equals(maNCC)) {
					temp.add(sanPham);
				}
			}
		}
		dsVPP.clear();
		dsVPP.addAll(temp);
		return dsVPP;
	}

	// lọc vpp theo danh mục
	public ArrayList<SanPham> locVPPTheoDanhMuc(String danhMuc, ArrayList<SanPham> dsVPP) {
//		ArrayList<SanPham> dsVPP = daoSP.layDSSanPham();
		ArrayList<SanPham> temp = new ArrayList<>();
		for (SanPham sanPham : dsVPP) {
			if (sanPham.getMaSanPham().startsWith("SPVPP") && danhMuc.equals("Tất cả")) {
				temp.add(sanPham);
			} else {
				if (sanPham.getMaSanPham().startsWith("SPVPP")
						&& ((VanPhongPham) sanPham).getDanhMuc().getMaDanhMuc().equals(danhMuc)) {
					temp.add(sanPham);
				}
			}
		}
		dsVPP.clear();
		dsVPP.addAll(temp);
		return dsVPP;
	}

	// lọc vpp theo thể loại
	public ArrayList<SanPham> locVPPTheoTheLoai(ArrayList<SanPham> ds, String theLoai) {
		ArrayList<SanPham> temp = new ArrayList<>();
		Pattern p = Pattern.compile(theLoai, Pattern.CASE_INSENSITIVE);
		for (SanPham sanPham : ds) {
			Matcher m = p.matcher(sanPham.getTheLoai());
			if (m.find()) {
				temp.add(sanPham);
			}
		}
		ds.clear();
		ds.addAll(temp);
		return ds;
	}

	// lọc vpp theo trạng thái
	public ArrayList<SanPham> locVPPTheoTrangThai(String trangThai) {
		ArrayList<SanPham> dsVPPTheoTrangThai = new ArrayList<>();
		for (SanPham sanPham : daoSP.layDSSanPham()) {
			if (sanPham.getMaSanPham().startsWith("SPVPP") && sanPham.getTrangThai().equals(trangThai)) {
				dsVPPTheoTrangThai.add(sanPham);
			}
		}
		return dsVPPTheoTrangThai;
	}

	// tìm vpp theo tên
	public ArrayList<SanPham> timVPPTheoTen(ArrayList<SanPham> ds, String ten) {
		ArrayList<SanPham> temp = new ArrayList<>();
		Pattern p = Pattern.compile(ten, Pattern.CASE_INSENSITIVE);
		for (SanPham sanPham : ds) {
			Matcher m = p.matcher(sanPham.getTenSanPham());
			if (m.find()) {
				temp.add(sanPham);
			}
		}
		ds.clear();
		ds.addAll(temp);
		return ds;
	}

	// tạo mã vpp
	public String taoMaVPP() {
		int max = 0;
		for (SanPham sanPham : daoSP.layDSSanPham()) {
			if (sanPham.getMaSanPham().startsWith("SPVPP")) {
				max++;
			}
		}
		return "SPVPP" + (max + 1);
	}

	// validData vpp
	public boolean validDataVPP(String maSanPham, String tenSanPham, String soLuongTon, String giaNhap, String theLoai,
			String ke, String hinhAnh, String thue, String loiNhuan, String chatLieu) {
		if (maSanPham.equals("")) {
			mes = "Vui lòng nhấn chọn Tạo mã";
			return false;
		}
		if (tenSanPham.equals("")) {
			mes = "Vui lòng nhập tên sản phẩm";
			return false;
		}
		if (ke.equals("")) {
			mes = "Vui lòng nhập tên kệ";
			return false;
		} else {
			if (!ke.matches("^[D-F]\\d+$")) {
				mes = "Tên kệ bắt đầu là D hoặc E hoặc F theo sau là số";
				return false;
			}
		}
		if (hinhAnh == null) {
			mes = "Vui lòng chọn ảnh";
			return false;
		}
		if (!soLuongTon.equals("")) {
			try {
				int sl = Integer.parseInt(soLuongTon);
				if (sl < 0) {
					mes = "Số lượng không được âm";
					return false;
				}
			} catch (NumberFormatException e) {
				mes = "Số lượng phải là số nguyên dương";
				return false;
			}
		} else {
			mes = "Vui lòng nhập số lượng";
		}
		if (!thue.equals("")) {
			try {
				double x = Double.parseDouble(thue);
				if (x < 0) {
					mes = "Thuế không được âm";
					return false;
				}
			} catch (NumberFormatException e) {
				mes = "Thuế phải là số dương";
				return false;
			}
		} else {
			mes = "Vui lòng nhập thuế";
		}
		if (!giaNhap.equals("")) {
			try {
				double x = Double.parseDouble(giaNhap);
				if (x < 0) {
					mes = "Giá nhập không được âm";
					return false;
				}
			} catch (NumberFormatException e) {
				mes = "Giá nhập phải là số dương";
				return false;
			}
		} else {
			mes = "Vui lòng nhập giá nhập";
		}
		if (!loiNhuan.equals("")) {
			try {
				double x = Double.parseDouble(loiNhuan);
				if (x < 0) {
					mes = "Lợi nhuận không được âm";
					return false;
				}
			} catch (NumberFormatException e) {
				mes = "Lợi nhuận phải là số dương";
				return false;
			}
		} else {
			mes = "Vui lòng nhập lợi nhuận";
		}
		if (theLoai.equals("")) {
			mes = "Vui lòng nhập thể loại";
			return false;
		} else {
			if (!theLoai.matches("[\\p{L} ]+")) {
				mes = "Thể loại không chứa ký tự đặc biệt và số";
				return false;
			}
		}
		if (chatLieu.equals("")) {
			mes = "Vui lòng nhập chất liệu";
			return false;
		} else {
			if (!chatLieu.matches("[\\p{L}0-9 ]+")) {
				mes = "Chất liệu không chứa ký tự đặc biệt";
				return false;
			}
		}
		return true;
	}
	
	public boolean capNhatSoLuongTonSanPham(SanPham sp) {
		return daoSP.capNhatSoLuongTonSanPham(sp);
	}
}
