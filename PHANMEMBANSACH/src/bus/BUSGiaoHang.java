package bus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


import dao.DAODonGiaoHang;
import entity.DonGiaoHang;


public class BUSGiaoHang {
   private DAODonGiaoHang daoDonGiaoHang = new DAODonGiaoHang();
   private String mes = "";
   
   public String getMessgage() {
	   return mes;
   }
   public ArrayList<DonGiaoHang> layDSDonGiaoHang() {
	   return daoDonGiaoHang.layDSDonHang();
   }
   
   public DonGiaoHang timDonHangTheoMaDonHang(String maCTim) {
	   ArrayList<DonGiaoHang> ds = daoDonGiaoHang.layDSDonHang();
	   for(DonGiaoHang dgh : ds) {
		   if(dgh.getMaDonGiaoHang().equals(maCTim)) {
			   return dgh;
		   }
	   }
	   return null;
   }
   
   public DonGiaoHang timDonHangTheoTenKhachHang(String tenKhachHang) {
	   ArrayList<DonGiaoHang> ds = daoDonGiaoHang.layDSDonHang();
	   for(DonGiaoHang dgh : ds) {
		   if(dgh.getTenKhachHang().equals(tenKhachHang)) {
			   return dgh;
		   }
	   }
	   return null;
   }
   
   
   public boolean themDonHangMoi(DonGiaoHang dgh) {
	   return daoDonGiaoHang.themDonGiaoHang(dgh);
   }
   
   public String taoMaDonHang() {
	   int max = layDSDonGiaoHang().size() + 1;
	   return "DGH" + max;
   }
   
   public boolean capNhatThongTinDonHang(DonGiaoHang dgh) {
	   return daoDonGiaoHang.capNhatThongTinDonHang(dgh);
   }
   

   public ArrayList<DonGiaoHang> sapXepTheoTongTienVanChuyen() {
   	ArrayList<DonGiaoHang> ds = daoDonGiaoHang.layDSDonHang();
       Collections.sort(ds,new Comparator<DonGiaoHang>() {

			@Override
			public int compare(DonGiaoHang o1, DonGiaoHang o2) {
				Float kh1 = (Float)o1.getTienVanChuyen();
				Float kh2 = (Float)o2.getTienVanChuyen();
				return kh1.compareTo(kh2);
			}
		});
      return ds;
   }
   
   public boolean validateDuLieu(DonGiaoHang dgh) {
	   if(!dgh.getTenKhachHang().matches("^[\\p{L} ]+$")) {
		   mes = "Tên không hợp lệ, tên chỉ bao gồm chữ và khoảng trắng";
		   return false;
	   }
	   
	   if(!dgh.getSdt().matches("^(02|03|05|07|08|09)\\d{8}$")) {
		   mes = "Số điện thoại không hợp lê, số điện thoại phải bắt đầu bằng 02 hoặc 03 hoặc 05 hoặc 07 hoặc 08 hoặc 09 và tối đa 10 chữ số";
		   return false;
	   }
	   if(dgh.getSoKg() < 0) {
		   mes = "Số kg phải là 1 số dương";
		   return false;
	   }
	   return true;
   }
  
}
