package bus;

import java.util.ArrayList;

import dao.DAONhanVien;
import entity.NhanVien;

public class BUSNhanVien {
	private DAONhanVien daoNhanVien = new DAONhanVien();
	ArrayList<NhanVien> dsNV = daoNhanVien.layDSNhanVien();
	
	public ArrayList<NhanVien> layDSNhanVien(){
		return dsNV;
	}
	
	public boolean suaNhanVien(NhanVien nv) {
		return daoNhanVien.capNhatNV(nv);
	}
	
	public NhanVien layNhanVien(String maNV) {
		return daoNhanVien.layNhanVienTheoMa(maNV);
	}
}
