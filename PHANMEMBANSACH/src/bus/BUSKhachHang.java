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
    
    public boolean themKhachHang(KhachHang kh) {
    	return daoKhachHang.themKhachHang(kh);
    }
    
    public boolean capNhatThongTinKhachHang(KhachHang kh) {
    	return daoKhachHang.capNhatThongTinKhachHang(kh);
    }
    
    public int kiemTraThongTinKhachHangHopLe(KhachHang kh) {
        Pattern tenKH = Pattern.compile("^[\\p{L} ]+$");
        Matcher matchTenKh = tenKH.matcher(kh.getTenKhachHang());
        Pattern sdt = Pattern.compile("^(09|08|07|05|03)\\d{8}$");
        Matcher matchSdt = sdt.matcher(kh.getSdt());
        Pattern email = Pattern.compile("^(\\w)+\\@gmail.com$");
        Matcher matchEmail = email.matcher(kh.getEmail());
        // các trường hợp thông tin không hợp lệ, đưa ra message ngoài gui
        if(!matchTenKh.find()) {
        	return 1;
        }
        if(!matchSdt.find()) {
        	return 2;
        }
        if(!matchEmail.find()) {
        	return 3;
        }
        if(kh.getDiemTichLuy() < 0) {
        	return 4;
        }
        if(kh.getTongTienMua() < 0) {
        	return 5;
        }
        // thông tin hợp lệ
        return 0;
    }
    
    public ArrayList<HoaDon> layLichSuGiaoDichKhachHang(String maKH) {
    	return daoKhachHang.layLichSuGiaoDichKhachHang(maKH);
    }
    
    public String taoMaKhachHang() {
    	return "KH" + daoKhachHang.getMaKhachHangMax();
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
}
