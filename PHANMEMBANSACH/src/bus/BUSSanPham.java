package bus;

import dao.DAOSach;
import dao.DAOVanPhongPham;
import entity.SanPham;

public class BUSSanPham {
	DAOSach daoSach = new DAOSach();
	DAOVanPhongPham daoVPP = new DAOVanPhongPham();
	public SanPham timKiemSanPham(String maSP) {
		SanPham sp = null;
		if(maSP.startsWith("SPS")) sp = daoSach.timSachTheoMa(maSP);
		else sp = daoVPP.timVanPhongPhamTheoMa(maSP);
		return sp;
	}
}
