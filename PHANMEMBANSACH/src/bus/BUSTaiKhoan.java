package bus;

import dao.DAONhanVien;
import dao.DAOTaiKhoan;
import entity.TaiKhoan;

public class BUSTaiKhoan {
	DAOTaiKhoan daoTaiKhoan = new DAOTaiKhoan();
	public boolean kiemTraMatKhau(String taiKhoan, String matKhau) {
		return daoTaiKhoan.kiemTraMatKhau(taiKhoan, matKhau);
	}
	
	public boolean themTaiKhoan(TaiKhoan tk) {
		return daoTaiKhoan.themTaiKhoan(tk);
	}
	
	public boolean capNhatMatKhau(String tenTK, String mk) {
		return new DAONhanVien().capNhatMatKhauNV(tenTK, mk);
	}
}
