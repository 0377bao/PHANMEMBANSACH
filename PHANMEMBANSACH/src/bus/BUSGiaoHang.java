package bus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import connect.ConnectDB;
import dao.DAODonGiaoHang;
import entity.DonGiaoHang;

public class BUSGiaoHang {
   private DAODonGiaoHang daoDonGiaoHang = new DAODonGiaoHang();
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
   
   public DonGiaoHang timDonHangTheoTenNhanVienGiaoHang(String tenNhanVien) {
	   ArrayList<DonGiaoHang> ds = daoDonGiaoHang.layDSDonHang();
	   for(DonGiaoHang dgh : ds) {
		   if(dgh.getNhanVienGiaoHang().getTenNhanVien().equals(tenNhanVien)) {
			   return dgh;
		   }
	   }
	   return null;
   }

}
