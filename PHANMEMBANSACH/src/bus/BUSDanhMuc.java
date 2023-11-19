package bus;

import java.util.ArrayList;

import dao.DAODanhMuc;
import entity.DanhMuc;
import entity.NhaCungCap;

public class BUSDanhMuc {
	DAODanhMuc daoDanhMuc = new DAODanhMuc();
	public String mes;

	// lấy ds danh mục
	public ArrayList<DanhMuc> layDSDanhMuc() {
		return daoDanhMuc.layDSDanhMuc();
	}

	public DanhMuc timDanhMucTheoMa(String maDanhMuc) {
		return daoDanhMuc.timDanhMucTheoMa(maDanhMuc);
	}

	// thêm danh mục
	public boolean themDanhMuc(DanhMuc dm) {
		return daoDanhMuc.taoDanhMuc(dm);
	}

	// tạo mã
	public String taoMa() {
		int max = daoDanhMuc.layDSDanhMuc().size() + 1;
		return "DM" + max;
	}

	// validData danh mục
	public boolean validData(String ma, String ten) {
		if (ma.equals("")) {
			mes = "Vui lòng nhấn chọn Tạo mã";
			return false;
		}
		if (ten.equals("")) {
			mes = "Vui lòng nhập tên danh mục";
			return false;
		} else {
			if (!(ten.matches("^[\\p{L}][\\p{L}/.,' -]+"))) {
				mes = "Danh mục không chứa ký tự đặc biệt và số";
				return false;
			}
		}
		return true;
	}

	// tìm danh mục theo tên
	public DanhMuc timDanhMucTheoTen(String ten) {
		for (DanhMuc dm : daoDanhMuc.layDSDanhMuc()) {
			if (dm.getTenDanhMuc().equals(ten)) {
				return dm;
			}
		}
		return null;
	}
}
