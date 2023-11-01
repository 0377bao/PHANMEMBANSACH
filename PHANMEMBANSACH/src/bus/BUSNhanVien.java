package bus;

import java.util.ArrayList;

import dao.DAONhanVien;
import entity.NhanVien;

public class BUSNhanVien {
	private DAONhanVien daoNhanVien = new DAONhanVien();
<<<<<<< HEAD
	public NhanVien layNhanVienTheoMa(String maNV) {
		return daoNhanVien.layNhanVien(maNV);
=======
	ArrayList<NhanVien> dsNV = daoNhanVien.layDSNhanVien();
	
	public ArrayList<NhanVien> layDSNhanVien(){
		return dsNV;
	}
	
	public boolean suaNhanVien(NhanVien nv) {
		return daoNhanVien.capNhatNV(nv);
	}
	
	public NhanVien layNhanVien(String maNV) {
		return daoNhanVien.layNhanVienTheoMa(maNV);
>>>>>>> 3f3e1930aa2f91f496f8c5cc0afe4d88fc8a395c
	}
}
