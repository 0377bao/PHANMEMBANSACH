package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.table.DefaultTableModel;

import bus.BUSHoaDon;
import connect.ConnectDB;
import customUI.MyTable;
import entity.HoaDon;
import entity.KhachHang;

public class DAOKhachHang {
    public ArrayList<KhachHang> layDSKhachHang() {
    	ArrayList<KhachHang> dsKhachHang = new ArrayList<>();
    	ConnectDB.getInstance();
    	Connection con = ConnectDB.getConnection();
    	String sql = "select * from KhachHang";
    	try {
    		Statement stmt = con.createStatement();
    		ResultSet rs = stmt.executeQuery(sql);
    		while(rs.next()) {
    			String maKhachHang = rs.getString("maKhachHang").trim();
    			String tenKhachHang = rs.getString("tenKhachHang").trim();
    			String sdt = rs.getString("sdt").trim();
    			String email = rs.getString("email").trim();
    			int diemTichLuy = rs.getInt("diemTichLuy");
    			float tongTienMua = rs.getFloat("tongTienMua");
    			KhachHang kh = new KhachHang(maKhachHang, tenKhachHang, sdt, email, diemTichLuy, tongTienMua);
    			dsKhachHang.add(kh);
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return dsKhachHang;
    }
    
    public boolean themKhachHang(KhachHang kh) {
    	ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        String sql = "insert into KhachHang values (?,?,?,?,?,?)";
        int n = 0;
        try {
        	PreparedStatement stmt = con.prepareStatement(sql);
        	stmt.setString(1, kh.getMaKhachHang());
        	stmt.setString(2, kh.getTenKhachHang());
        	stmt.setString(3, kh.getSdt());
        	stmt.setString(4, kh.getEmail());
        	stmt.setInt(5, kh.getDiemTichLuy());
        	stmt.setFloat(6, kh.getTongTienMua());
            n = stmt.executeUpdate();
        }catch(Exception e) {
        	e.printStackTrace();
        }
        return n > 0 ? true : false;
    }
    
    public boolean capNhatThongTinKhachHang(KhachHang kh) {
    	ConnectDB.getInstance();
    	Connection con = ConnectDB.getConnection();
    	String sql = "update KhachHang set sdt=?, email=?, diemTichLuy=?, tongTienMua=? where maKhachHang =?";
    	int n = 0;
    	try {
    		PreparedStatement stmt = con.prepareStatement(sql);
    		stmt.setString(1, kh.getSdt());
    		stmt.setString(2, kh.getEmail());
    		stmt.setInt(3,kh.getDiemTichLuy());
    		stmt.setFloat(4, kh.getTongTienMua());
    		stmt.setString(5, kh.getMaKhachHang());
    		n = stmt.executeUpdate();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return n > 0 ? true : false;
    }
    
    public KhachHang timKhachHangTheoMa(String maKH) {
    	ConnectDB.getInstance();
    	Connection con = ConnectDB.getConnection();
    	String sql = "select * from KhachHang where maKhachHang =?";
    	KhachHang kh = null;
    	try {
    		PreparedStatement stmt = con.prepareStatement(sql);
    		stmt.setString(1, maKH);
    		ResultSet rs = stmt.executeQuery();
    		while(rs.next()) {
    			String maKhachHang = rs.getString("maKhachHang").trim();
    			String tenKhachHang = rs.getString("tenKhachHang").trim();
    			String sdt = rs.getString("sdt").trim();
    			String email = rs.getString("email").trim();
    			int diemTichLuy = rs.getInt("diemTichLuy");
    			float tongTienMua = rs.getFloat("tongTienMua");
    			kh = new KhachHang(maKhachHang, tenKhachHang, sdt, email, diemTichLuy, tongTienMua);
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return kh;
    }
    
    public KhachHang timKhachHangTheoSDT(String sdtkh) {
    	ConnectDB.getInstance();
    	Connection con = ConnectDB.getConnection();
    	String sql = "select * from KhachHang where sdt =?";
    	KhachHang kh = null;
    	try {
    		PreparedStatement stmt = con.prepareStatement(sql);
    		stmt.setString(1, sdtkh);
    		ResultSet rs = stmt.executeQuery();
    		while(rs.next()) {
    			String maKhachHang = rs.getString("maKhachHang").trim();
    			String tenKhachHang = rs.getString("tenKhachHang").trim();
    			String sdt = rs.getString("sdt").trim();
    			String email = rs.getString("email").trim();
    			int diemTichLuy = rs.getInt("diemTichLuy");
    			float tongTienMua = rs.getFloat("tongTienMua");
    			kh = new KhachHang(maKhachHang, tenKhachHang, sdt, email, diemTichLuy, tongTienMua);
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return kh;
    }
    
    public ArrayList<HoaDon> layLichSuGiaoDichKhachHang(String maKH) {
    	ConnectDB.getInstance();
    	Connection con = ConnectDB.getConnection();
    	ArrayList<HoaDon> dsGiaoDich = new ArrayList<>();
    	String sql = "select * from HoaDon hd join NhanVien nv on hd.maNhanVien = nv.maNhanVien where hd.maKhachHang = ?";
    	try {
    		PreparedStatement stmt = con.prepareStatement(sql);
    		stmt.setString(1, maKH);
    		ResultSet rs = stmt.executeQuery();
    		while(rs.next()) {
    			String maHoaDon = rs.getString("maHoaDon").trim();
    			HoaDon hd = new BUSHoaDon().timHoaDonTheoMa(maHoaDon);
    			dsGiaoDich.add(hd);
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return dsGiaoDich;
    }
    
    public int getMaKhachHangMax() {
    	int ma = 0;
    	ConnectDB.getConnection();
    	Connection con = ConnectDB.getConnection();
    	String sql = "SELECT top 1 CAST(SUBSTRING(maKhachHang, 3, LEN(maKhachHang) - 2) as int) AS maKhachHang "
				+ "FROM KhachHang order by maKhachHang desc";
    	try {
    	    PreparedStatement stmt = con.prepareStatement(sql);
    	    ResultSet rs = stmt.executeQuery();
    	    while(rs.next()) {
    	    	ma = rs.getInt("maKhachHang");
    	    }
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return ma;
    }
}
