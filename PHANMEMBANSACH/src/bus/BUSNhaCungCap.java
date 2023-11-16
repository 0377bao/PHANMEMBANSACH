package bus;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.DAONhaCungCap;
import entity.NhaCungCap;

public class BUSNhaCungCap {
	private DAONhaCungCap daoNCC = new DAONhaCungCap();
	public String mes = "";

	// lấy ds nhà cung cấp
	public ArrayList<NhaCungCap> layDSNhaCungCap() {
		return daoNCC.layDSNhaCungCap();
	}

	// tạo mã
	public String taoMa() {
		int max = daoNCC.layDSNhaCungCap().size() + 1;
		return "NCC" + max;
	}

	// valid data
	public boolean validData(String maNhaCungCap, String tenNhaCungCap, String diaChi, String sdt, String email) {
		if (maNhaCungCap.equals("")) {
			mes = "Vui lòng nhấn chọn Tạo mã";
			return false;
		}
		if (tenNhaCungCap.equals("")) {
			mes = "Vui lòng nhập tên nhà cung cấp";
			return false;
		} else {
			if (!(tenNhaCungCap.matches("^[\\p{L}0-9][\\p{L}0-9/.,' -]+"))) {
				mes = "Tên nhà cung cấp không chứa ký tự đặc biệt";
				return false;
			}
		}
		if (sdt.equals("")) {
			mes = "Vui lòng nhập số điện thoại";
			return false;
		} else {
			if (!(sdt.matches("^02\\d{9}$") || sdt.matches("^0[3579]\\d{8}$"))) {
				mes = "Số điện thoại bắt đầu là 02 gồm 11 số hoặc bắt đầu là 03 - 05 - 07 - 09 gồm 10 số";
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
			mes = "Vui lòng nhập địa chỉ nhà cung cấp";
			return false;
		} else {
			if (!(diaChi.matches("^[\\p{L}0-9][\\p{L}0-9/.,' -]+"))) {
				mes = "Địa chỉ nhà cung cấp không chứa ký tự đặc biệt";
				return false;
			}
		}
		return true;
	}

	// thêm nhà cung cấp
	public boolean themNCC(NhaCungCap ncc) {
		return daoNCC.themNCC(ncc);
	}

	// sửa nhà cung cấp
	public boolean capNhatNCC(NhaCungCap ncc) {
		return daoNCC.capNhatNCC(ncc);
	}

	// tìm nhà cung cấp theo mã
	public NhaCungCap timNCCTheoMa(String maNhaCungCap) {
		return daoNCC.timNhaCungCapTheoMa(maNhaCungCap);
	}

	// tìm ncc theo tên
	public NhaCungCap timNCCTheoTen(String ten) {
		for (NhaCungCap ncc : daoNCC.layDSNhaCungCap()) {
			if (ncc.getTenNhaCungCap().equals(ten)) {
				return ncc;
			}
		}
		return null;
	}

	// lọc nhà cung cấp theo sdt
	public ArrayList<NhaCungCap> layNCCTheoSdt(String sdt) {
		ArrayList<NhaCungCap> dsNCC = new ArrayList<>();
		Pattern p = Pattern.compile(sdt, Pattern.CASE_INSENSITIVE);
		for (NhaCungCap ncc : daoNCC.layDSNhaCungCap()) {
			Matcher m = p.matcher(ncc.getSdt());
			if (m.find()) {
				dsNCC.add(ncc);
			}
		}
		return dsNCC;
	}

	// lọc nhà cung cấp theo tên
	public ArrayList<NhaCungCap> layNCCTheoTen(String ten) {
		ArrayList<NhaCungCap> dsNCC = new ArrayList<>();
		Pattern p = Pattern.compile(ten, Pattern.CASE_INSENSITIVE);
		for (NhaCungCap ncc : daoNCC.layDSNhaCungCap()) {
			Matcher m = p.matcher(ncc.getTenNhaCungCap());
			if (m.find()) {
				dsNCC.add(ncc);
			}
		}
		return dsNCC;
	}

	// lọc nhà cung cấp theo địa chỉ
	public ArrayList<NhaCungCap> layNCCTheoDiaChi(String diaChi) {
		ArrayList<NhaCungCap> dsNCC = new ArrayList<>();
		Pattern p = Pattern.compile(diaChi, Pattern.CASE_INSENSITIVE);
		for (NhaCungCap ncc : daoNCC.layDSNhaCungCap()) {
			Matcher m = p.matcher(ncc.getDiaChi());
			if (m.find()) {
				dsNCC.add(ncc);
			} else if (diaChi.equals("Tất cả")) {
				dsNCC.add(ncc);
			}
		}
		return dsNCC;
	}
}
