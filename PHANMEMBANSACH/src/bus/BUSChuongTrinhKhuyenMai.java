package bus;

import java.util.ArrayList;

import dao.DAOChuongTrinhKhuyenMai;
import entity.ChuongTrinhKhuyenMai;

public class BUSChuongTrinhKhuyenMai {
	private String mes ="";
	private DAOChuongTrinhKhuyenMai daoCTKM = new DAOChuongTrinhKhuyenMai();
	
	public ChuongTrinhKhuyenMai timChuongTrinhKhuyenMaiTheoMa(String maTim) {
		return daoCTKM.timChuongTrinhKhuyenMaiTheoMa(maTim);
	}
	
	public ChuongTrinhKhuyenMai timChuongTrinhKhuyenMaiDangApDung() {
		return daoCTKM.timChuongTrinhKhuyenMaiDangApDung();
	}
	
	public ArrayList<ChuongTrinhKhuyenMai> layDSChuongTrinhKhuyenMai() {
		return daoCTKM.layDSChuongTrinhKhuyenMai();
	}
	
	public void tatTrangThaiChuongTrinhKhuyenMai(ChuongTrinhKhuyenMai ctkm) {
		daoCTKM.tatTrangThaiChuongTrinhKhuyenMai(ctkm);
	}
	
	public void capNhatTrangThaiChuongTrinhKhuyenMaiDuocChon(ChuongTrinhKhuyenMai ctkm) {
		daoCTKM.capNhatTrangThaiChuongTrinhKhuyenMaiDuocChon(ctkm);
	}
	
	public String taoMaCTKM() {
		return "CTKM" + (daoCTKM.layDSChuongTrinhKhuyenMai().size() + 1);
	}
	
	public boolean themChuongTrinhKhuyenMai(ChuongTrinhKhuyenMai ctkm) {
		return daoCTKM.themChuongTrinhKhuyenMai(ctkm);
	}
	
	public boolean validateChuongTrinhKhuyenMai(ChuongTrinhKhuyenMai ctkm) {
		if(ctkm.getTenCTKM().equals("")) {
			mes = "Vui lòng nhập tên chương trình khuyến mãi";
			return false;
		}else if(!ctkm.getTenCTKM().matches("^[\\p{L}0-9 ]+\\/?[\\p{L}0-9 ]+$")) {
			mes = "Tên chương trình khuyến mãi không hợp lệ, tên chương trình chỉ được bao gồm chữ, số, dấu / " + "và khoảng trắng, không có kí tự đặc biệt";
			return false;
		}else {
			ArrayList<ChuongTrinhKhuyenMai> dsCTKM = new DAOChuongTrinhKhuyenMai().layDSChuongTrinhKhuyenMai();
			for(ChuongTrinhKhuyenMai p : dsCTKM) {
				if(ctkm.getTenCTKM().equals(p.getTenCTKM())) {
					mes = "Tên chương trình khuyến mãi đã tồn tại, vui lòng đặt tên khác";
					return false;
				}
			}
		}
		return true;
	}
	
	public String getMessage() {
		return mes;
	}
}
