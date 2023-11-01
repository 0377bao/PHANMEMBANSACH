package bus;

import java.util.ArrayList;

import dao.DAOSach;
import entity.Sach;

public class BUSSach {
	DAOSach daoSach = new DAOSach();
	ArrayList<Sach> dsS = daoSach.layDSSach();

	public ArrayList<Sach> layDSSach() {
		return daoSach.layDSSach();
	}

	public boolean themSach(Sach s) {
		return daoSach.taoSach(s);
	}

	public boolean suaSach(Sach s) {
		return daoSach.capNhatSach(s);
	}

	public Sach laySachTheoMa(String maS) {
		return daoSach.timSachTheoMa(maS);
	}

	public Sach laySachTheoTen(String tenS) {
		for (Sach sach : dsS) {
			if (sach.getTenSanPham().equals(tenS)) {
				return sach;
			}
		}
		return null;
	}

	public ArrayList<Sach> layDSSachTheoMaNCC(String maNCC) {
		ArrayList<Sach> dsSachTheoNCC = new ArrayList<Sach>();
		for (Sach sach : dsS) {
			if (sach.getNhaCungCap().getMaNhaCungCap().equals(maNCC)) {
				dsSachTheoNCC.add(sach);
			}
		}
		return dsSachTheoNCC;
	}
}
