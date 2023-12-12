package bus;

import java.util.ArrayList;
import java.util.Iterator;

import dao.DAOChuongTrinhKhuyenMai;
import dao.DAOMucKhuyenMai;
import entity.ChuongTrinhKhuyenMai;
import entity.MucKhuyenMai;

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
		if(ctkm.getMaCTKM().equals("")) {
			mes = "Vui lòng tạo mã chương trình khuyến mãi trước";
			return false;
		}
		if(ctkm.getTenCTKM().equals("") || ctkm.getTenCTKM().startsWith(" ")) {
			mes = "Vui lòng nhập tên chương trình khuyến mãi";
			return false;
		}else if(ctkm.getTenCTKM().startsWith("/")) {
			mes = "Tên chương trình khuyến mãi không bắt đầu bằng dấu /";
			return false;
		}
		else if(!ctkm.getTenCTKM().matches("^[\\p{L}0-9 ]+\\/?[\\p{L}0-9 ]+$")) {
			mes = "Tên chương trình khuyến mãi không hợp lệ, tên chương trình chỉ được bao gồm chữ, số, dấu / " + "và khoảng trắng, không có kí tự đặc biệt";
			return false;
		}
		else {
			ArrayList<ChuongTrinhKhuyenMai> dsCTKM = new DAOChuongTrinhKhuyenMai().layDSChuongTrinhKhuyenMai();
			for(ChuongTrinhKhuyenMai p : dsCTKM) {
				if(ctkm.getTenCTKM().equals(p.getTenCTKM())) {
					mes = "Tên chương trình khuyến mãi đã tồn tại, vui lòng đặt tên khác";
					return false;
				}
			}
		}
		if(ctkm.getDsMucKhuyenMai().size() == 0) {
			mes = "Vui lòng thêm mục khuyến mãi trước khi lưu chương trình khuyến mãi";
			return false;
		}
		return true;
	}
	
	public String getMessage() {
		return mes;
	}
	
	public boolean capNhatMucKhuyenMai(String ma,MucKhuyenMai m) {
		return new DAOMucKhuyenMai().capNhatMucKhuyenMai(ma, m);
	}
	
	
}
