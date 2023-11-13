package bus;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.table.DefaultTableModel;

import dao.DAONhanVien;
import entity.NhanVien;

public class BUSNhanVien {
	private DAONhanVien daoNhanVien = new DAONhanVien();
	public String mes = "";

	// lấy nhân viên theo mã
	public NhanVien layNhanVienTheoMa(String maNV) {
		return daoNhanVien.layNhanVienTheoMa(maNV);
	}

	// lấy danh sách nhân viên
	public ArrayList<NhanVien> layDSNhanVien() {
		return daoNhanVien.layDSNhanVien();
	}

	// ràng buộc để thêm nhân viên
	public boolean validData(String maNhanVien, String tenNhanVien, String sdt, String email, String hinhAnh,
			String diaChi, String cCCD, String taiKhoan) {

		if (maNhanVien.equals("")) {
			mes = "Vui lòng nhấn chọn Tạo mã";
			return false;
		}
		if (tenNhanVien.equals("")) {
			mes = "Vui lòng nhập tên nhân viên";
			return false;
		} else {
			if (!(tenNhanVien.matches("[\\p{L} ]+"))) {
				mes = "Tên nhân viên không chứa ký tự đặc biệt và số";
				return false;
			}
		}
		if (sdt.equals("")) {
			mes = "Vui lòng nhập số điện thoại";
			return false;
		} else {
			if (!sdt.matches("^0[23579]\\d{8,9}$")) {
				mes = "Số điện thoại phải 10 hoặc 11 số và bắt đầu bằng 02 hoặc 03 hoặc 05 hoặc 07 hoặc 09";
				return false;
			}
		}
		if (cCCD.equals("")) {
			mes = "Vui lòng nhập tên nhân viên";
			return false;
		} else {
			if (!(cCCD.matches("^0\\d{11}"))) {
				mes = "CCCD gồm 12 số và bắt đầu bằng 0";
				return false;
			}
		}
		if (email.equals("")) {
			mes = "Vui lòng nhập email";
			return false;
		} else {
			if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
				mes = "Email không hợp lệ";
				return false;
			}
		}
		if (diaChi.equals("")) {
			mes = "Vui lòng nhập địa chỉ";
			return false;
		} else {
			if (!(diaChi.matches("[\\p{L}0-9/.,' -]+"))) {
				mes = "Địa chỉ không chứa ký tự đặc biệt";
				return false;
			}
		}
		if (taiKhoan.equals("")) {
			mes = "Vui lòng nhập mật khẩu để tạo tài khoản";
			return false;
		}
		if (hinhAnh == null) {
			mes = "Vui lòng chọn ảnh";
			return false;
		}
		return true;
	}

	// tạo mã
	public String taoMaNV() {
		int max = layDSNhanVien().size() + 1;
		return "NV" + max;
	}

	// thêm nhân viên
	public boolean themNhanVien(NhanVien nv) {
		return daoNhanVien.themNhanVien(nv);
	}

	// cập nhật nhân viên
	public boolean suaNhanVien(NhanVien nv) {
		return daoNhanVien.capNhatNV(nv);
	}

	// đổ dữ liệu vào bảng
	public void doDSNhanVienVaoBang(DefaultTableModel model) {
		for (NhanVien nv : daoNhanVien.layDSNhanVien()) {
			model.addRow(new Object[] { nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getSdt(),
					nv.isGioiTinh() ? "Nam" : "Nữ", nv.getcCCD(), nv.getEmail(), nv.getChucVu(), nv.getDiaChi(),
					nv.getTaiKhoan().getMatKhau() });
		}
	}

	// lọc nhân viên theo chức vụ
	public ArrayList<NhanVien> locNVTheoChucVu(String chucVu) {
		ArrayList<NhanVien> dsNVTheoChucVu = new ArrayList<NhanVien>();
		for (NhanVien nv : daoNhanVien.layDSNhanVien()) {
			if (nv.getChucVu().equals(chucVu)) {
				dsNVTheoChucVu.add(nv);
			}
		}
		return dsNVTheoChucVu;
	}

	// lọc nhân viên theo giới tính
	public ArrayList<NhanVien> locNVTheoGioiTinh(boolean gt) {
		ArrayList<NhanVien> dsNVTheoGioiTinh = new ArrayList<NhanVien>();
		for (NhanVien nv : daoNhanVien.layDSNhanVien()) {
			if (nv.isGioiTinh() == gt) {
				dsNVTheoGioiTinh.add(nv);
			}
		}
		return dsNVTheoGioiTinh;
	}

	// tìm nhân viên theo số điện thoại
	public void timNVTheoSdt(ArrayList<NhanVien> ds, String sdt) {
		ArrayList<NhanVien> dsNV = new ArrayList<>();
		Pattern p = Pattern.compile(sdt);
		for (NhanVien nv : daoNhanVien.layDSNhanVien()) {
			Matcher m = p.matcher(nv.getSdt());
			if (m.find()) {
				dsNV.add(nv);
			}
		}
		ds.clear();
		ds.addAll(dsNV);
	}

	// tìm nhân viên theo tên
	public void timNVTheoTen(ArrayList<NhanVien> ds, String ten) {
		ArrayList<NhanVien> dsNV = new ArrayList<>();
		Pattern p = Pattern.compile(ten, Pattern.CASE_INSENSITIVE);
		for (NhanVien nv : daoNhanVien.layDSNhanVien()) {
			Matcher m = p.matcher(nv.getTenNhanVien());
			if (m.find()) {
				dsNV.add(nv);
			}
		}
		if (dsNV.size() > 0) {
			ds.clear();
			ds.addAll(dsNV);
		}
	}

}
