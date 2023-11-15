package bus;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import customUI.MyTable;
import dao.DAOKhachHang;
import entity.HoaDon;
import entity.KhachHang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.table.DefaultTableModel;


import customUI.MyTable;
import dao.DAOKhachHang;

import entity.KhachHang;

public class BUSKhachHang {
	private DAOKhachHang daoKhachHang = new DAOKhachHang();
    public ArrayList<KhachHang> layDSKhachHang() {
    	return daoKhachHang.layDSKhachHang();
    }
    
    public String themKhachHang(KhachHang kh) {
    	String message = kiemTraThongTinKhachHangHopLe(kh);
    	if(message.equals("success")) {
    		if(daoKhachHang.themKhachHang(kh)) {
    			message = "Thêm khách hàng thành công";
    		} else {
    			message = "Thêm không thành công vì mã khách hàng đã tồn tại";
    		}
    	}
    	return message;
    }
    
    public String capNhatThongTinKhachHang(KhachHang kh) {
    	String message = kiemTraThongTinKhachHangHopLe(kh);
    	if(message.equals("success")) {
    		if(daoKhachHang.capNhatThongTinKhachHang(kh)) {
    			message = "Cập nhật khách hàng thành công";
    		} else {
    			message = "Cập nhật không thành công vì mã khách hàng không tồn tại";
    		}
    	}
    	return message;
    }
    public KhachHang timKhachHangTheoSDT(String sdtkh) {
    	return daoKhachHang.timKhachHangTheoSDT(sdtkh);
    }
    
    public ArrayList<KhachHang> locKhachHang(String tenTim, String sdtTim) {
    	ArrayList<KhachHang> ds = new ArrayList<>();
    	for (KhachHang kh : this.layDSKhachHang()) {
    		Pattern pTen = Pattern.compile(tenTim,Pattern.CASE_INSENSITIVE);
			Matcher mTen = pTen.matcher(kh.getTenKhachHang());
			if(mTen.find()) {
				ds.add(kh);
			}
		}
    	ArrayList<KhachHang> result = new ArrayList<>();
    	for (KhachHang kh : ds) {
    		Pattern pSDT = Pattern.compile(sdtTim);
    		Matcher mSDT = pSDT.matcher(kh.getSdt());
    		if(mSDT.find()) {
    			result.add(kh);
    		}
    	}
    	return result;
    }
    
    public boolean capNhatDiemTichLuyKhachHang(KhachHang kh) {
    	return daoKhachHang.capNhatDiemTichLuyKhachHang(kh);
    }
    
    public String kiemTraThongTinKhachHangHopLe(KhachHang kh) {
        Pattern tenKH = Pattern.compile("^[\\p{L} ]+$");
        Matcher matchTenKh = tenKH.matcher(kh.getTenKhachHang());
        Pattern sdt = Pattern.compile("^(09|08|07|05|03)\\d{8}$");
        Matcher matchSdt = sdt.matcher(kh.getSdt());
        Pattern email = Pattern.compile("^(\\w)+\\@gmail.com$");
        Matcher matchEmail = email.matcher(kh.getEmail());
        // các trường hợp thông tin không hợp lệ, đưa ra message ngoài gui
        if(kh.getTenKhachHang().trim().equals("")) return "Tên khách hàng không được để trống";
        if(!matchTenKh.find()) {
        	return "Tên khách hàng chỉ chứa chữ và khoảng trắng";
        }
        if(kh.getSdt().trim().equals("")) return "SDT khách hàng không được để trống";
        if(!matchSdt.find()) {
        	return "Số điện thoại phải có 10 kí tự và bắt đầu bằng (09, 08, 07, 05, 03)";
        }
        if(kh.getEmail().trim().equals("")) return "Email khách hàng không được để trống";
        if(!matchEmail.find()) {
        	return "Email khách hàng không hợp lệ";
        }
        // thông tin hợp lệ
        return "success";
    }
    
    public ArrayList<HoaDon> layLichSuGiaoDichKhachHang(String maKH) {
    	return daoKhachHang.layLichSuGiaoDichKhachHang(maKH);
    }
    
    public String taoMaKhachHang() {
    	return "KH" + (daoKhachHang.getMaKhachHangMax() + 1);
    }
    
    public void sapXepTheoTongTienMua(MyTable tb, DefaultTableModel model) {
    	ArrayList<KhachHang> ds = layDSKhachHang();
        Collections.sort(ds,new Comparator<KhachHang>() {

			@Override
			public int compare(KhachHang o1, KhachHang o2) {
				Float kh1 = (Float)o1.getTongTienMua();
				Float kh2 = (Float)o2.getTongTienMua();
				return kh1.compareTo(kh2);
			}
		});
        model.setRowCount(0);
        for(KhachHang kh: ds) {
        	model.addRow(new Object[] {kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getSdt(), kh.getEmail(), kh.getDiemTichLuy(), kh.getTongTienMua()});
        }
        tb.setModel(model);
    }
    
    public KhachHang timKhachHangTheoMa(String maKH) {
    	return daoKhachHang.timKhachHangTheoMa(maKH);
    }
    
    public ArrayList<KhachHang> sapXepTheoTongTien(ArrayList<KhachHang> ds) {
    	Collections.sort(ds, new Comparator<KhachHang>() {
            @Override
            public int compare(KhachHang o1, KhachHang o2) {
            	Float tongTien1 = o1.getTongTienMua();
            	Float tongTien2 = o2.getTongTienMua();
                return tongTien2.compareTo(tongTien1);
            }
        });
    	return ds;
    }
}
