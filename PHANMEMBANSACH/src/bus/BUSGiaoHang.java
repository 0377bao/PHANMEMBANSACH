package bus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
				return kh2.compareTo(kh1);
			}
		});
      return ds;
   }

}
