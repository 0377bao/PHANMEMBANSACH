package bus;

import dao.DAOTaiKhoan;

public class BUSTaiKhoan {
	DAOTaiKhoan daoTaiKhoan = new DAOTaiKhoan();
	public boolean kiemTraMatKhau(String taiKhoan, String matKhau) {
		return daoTaiKhoan.kiemTraMatKhau(taiKhoan, matKhau);
	}
	
}
