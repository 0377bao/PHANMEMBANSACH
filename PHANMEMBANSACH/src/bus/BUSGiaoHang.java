package bus;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JTextField;

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
   } public boolean themDonHangMoi(DonGiaoHang dgh) {
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
				return kh2.compareTo(kh1);
			}
		});
      return ds;
   }
   
   public boolean validateDuLieu(String maDonHang, String tenKhachHang, String sdt, JTextField soKg, JTextField soKm) {
	   if(maDonHang.equals("")) {
		   mes = "Vui lòng tạo mã đơn hàng trước";
		   return false;
	   }
	   if(tenKhachHang.equals("")) {
		   mes = "Vui lòng nhập tên khách hàng";
		   return false;
	   }else if(!tenKhachHang.matches("^[\\p{L} ]+$")) {
		   mes = "Tên không hợp lệ, tên chỉ bao gồm chữ và khoảng trắng";
		   return false;
	   }
	   if(sdt.equals("")) {
		   mes = "Vui lòng nhập số điện thoại để liên lạc nhận hàng";
		   return false;
	   }else if(!sdt.matches("^(02|03|05|07|08|09)\\d{8}$")) {
		   mes = "Số điện thoại không hợp lệ, số điện thoại phải bắt đầu bằng 02 hoặc 03 hoặc 05 hoặc 07 hoặc 08 hoặc 09 và tối đa 10 chữ số";
		   return false;
	   } 
	   
	   if(soKg.getText().equals("")) {
		   mes = "Vui lòng nhập số kg";
		   return false;
	   }else {
		  try {
			  int soKgs = Integer.parseInt(soKg.getText());	 
			  if(soKgs < 0) {
				  mes = "Số kg phải là 1 số dương";
				  return false;
			  }
		  }catch(Exception e) {
			  mes = "Số kg chỉ bao gồm kí tự số";
			  return false;
		  }
	   }
	   if(soKm.getText().equals("")) {
		   mes = "Vui lòng chọn chức năng tính khoảng cách để biết tiền chuyển và tiến hành tạo đơn giao hàng";
		   return false;
	   }else {
		   try {
			  float soKms = Float.parseFloat(soKm.getText());
			  if(soKms > 40) {
				  mes = "Số km vượt quá mức quy định nên không giao hàng";
				  return false;
			  }
		   }catch(Exception e) {
			   return false;
		   }
		   
	   }
	   return true;
   }
   
   public ArrayList<DonGiaoHang> layDSDonHangDangGiao(){
	   ArrayList<DonGiaoHang> ds = layDSDonGiaoHang();
	   ArrayList<DonGiaoHang> temp = new ArrayList<>();
	   for(DonGiaoHang dgh : ds) {
		   if(dgh.isTrangThai() == false && dgh.getGhiChu().equals("")) {
			   temp.add(dgh);
		   }
	   }
	   return temp;
   }
   
   public ArrayList<DonGiaoHang> layDSDonHangBiHuy(){
	   ArrayList<DonGiaoHang> ds = layDSDonGiaoHang();
	   ArrayList<DonGiaoHang> temp = new ArrayList<>();
	   for(DonGiaoHang dgh : ds) {
		   if(dgh.isTrangThai() == false && dgh.getGhiChu().equals("") == false) {
			   temp.add(dgh);
		   }
	   }
	   return temp;
   }
   
   public ArrayList<DonGiaoHang> layDSDonHangGiaoThanhCong(){
	   ArrayList<DonGiaoHang> ds = layDSDonGiaoHang();
	   ArrayList<DonGiaoHang> temp = new ArrayList<>();
	   for(DonGiaoHang dgh : ds) {
		   if(dgh.isTrangThai()) {
			   temp.add(dgh);
		   }
	   }
	   return temp;
   }
  
}
