package bus;

import dao.DAONhanVien;
import entity.NhanVien;

public class BUSNhanVien {
	private DAONhanVien daoNhanVien = new DAONhanVien();
	public NhanVien layNhanVienTheoMa(String maNV) {
		return daoNhanVien.layNhanVien(maNV);
	}
}
