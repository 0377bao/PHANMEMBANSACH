package bus;

import dao.DAONhanVien;
import entity.NhanVien;

public class BUSNhanVien {
	private DAONhanVien daoNhanVien = new DAONhanVien();
	public NhanVien layNhanVien(String maNV) {
		return daoNhanVien.layNhanVien(maNV);
	}
}
