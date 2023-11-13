package bus;

import dao.DAOSanPham;
import entity.Sach;
import entity.SanPham;
import entity.VanPhongPham;

public class BUSSanPham {
	DAOSanPham daoSP = new DAOSanPham();
	public SanPham timKiemSanPham(String maSP) {
		SanPham sp = null;
		if(maSP.startsWith("SPS")) sp = daoSP.timSachTheoMa(maSP);
		else sp = daoSP.timVanPhongPhamTheoMa(maSP);
		return sp;
	}
	
	public boolean themSanPham(SanPham sp) {
		if(sp.getMaSanPham().startsWith("SPS")) return daoSP.themSach((Sach) sp);
		else return daoSP.themVanPhongPham((VanPhongPham) sp);
	}
	
	public boolean capNhatSanPham(SanPham sp) {
		if(sp.getMaSanPham().startsWith("SPS")) return daoSP.capNhatSach((Sach) sp);
		else return daoSP.capNhatVanPhongPham((VanPhongPham) sp);
	}
}
