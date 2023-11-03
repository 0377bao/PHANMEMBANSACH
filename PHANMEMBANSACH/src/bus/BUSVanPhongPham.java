package bus;

import java.util.ArrayList;

import dao.DAOVanPhongPham;
import entity.VanPhongPham;

public class BUSVanPhongPham {
	DAOVanPhongPham daoVPP;
	ArrayList<VanPhongPham> dsVPP = new ArrayList<VanPhongPham>();

	public ArrayList<VanPhongPham> layDSSach() {
		return daoVPP.layDSVanPhongPham();
	}

	public boolean themSach(VanPhongPham vpp) {
		return daoVPP.taoSach(vpp);
	}

	public boolean suaSach(VanPhongPham vpp) {
		return daoVPP.capNhatVanPhongPham(vpp);
	}

	public VanPhongPham layVPPTheoMa(String maVPP) {
		return daoVPP.timVanPhongPhamTheoMa(maVPP);
	}

	public VanPhongPham timKiemVPPTheoTen(String vpp) {
		for (VanPhongPham vanPhongPham : dsVPP) {
			if (vanPhongPham.getTenSanPham().equals(vpp)) {
				return vanPhongPham;
			}
		}
		return null;
	}

	public ArrayList<VanPhongPham> layDSVPPTheoMaNCC(String maNCC) {
		ArrayList<VanPhongPham> dsSachTheoNCC = new ArrayList<VanPhongPham>();
		for (VanPhongPham vanPhongPham : dsVPP) {
			if (vanPhongPham.getNhaCungCap().getMaNhaCungCap().equals(maNCC)) {
				dsSachTheoNCC.add(vanPhongPham);
			}
		}
		return dsSachTheoNCC;
	}
}
