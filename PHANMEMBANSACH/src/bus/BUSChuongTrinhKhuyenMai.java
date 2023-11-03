package bus;

import dao.DAOChuongTrinhKhuyenMai;
import entity.ChuongTrinhKhuyenMai;

public class BUSChuongTrinhKhuyenMai {
	private DAOChuongTrinhKhuyenMai daoCTKM = new DAOChuongTrinhKhuyenMai();
	
	public ChuongTrinhKhuyenMai timChuongTrinhKhuyenMaiTheoMa(String maTim) {
		return daoCTKM.timChuongTrinhKhuyenMaiTheoMa(maTim);
	}
	
	public ChuongTrinhKhuyenMai timChuongTrinhKhuyenMaiDangApDung() {
		return daoCTKM.timChuongTrinhKhuyenMaiDangApDung();
	}
	
	
}
