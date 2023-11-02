package bus;

import java.util.ArrayList;

import dao.DAONhanVien;
import entity.NhanVien;

public class BUSNhanVien {
	private DAONhanVien daoNhanVien = new DAONhanVien();

	public NhanVien layNhanVienTheoMa(String maNV) {
		return daoNhanVien.layNhanVienTheoMa(maNV);
	}
	
	public boolean suaNhanVien(NhanVien nv) {
		return daoNhanVien.capNhatNV(nv);
	}
	
	public ArrayList<NhanVien> layDSNhanVien() {
		return daoNhanVien.layDSNhanVien();
	}
}
