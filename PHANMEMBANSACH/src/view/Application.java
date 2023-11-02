package view;

import connect.ConnectDB;
import dao.DAOHoaDon;
import ui.GUIDangNhap;
import ui.TrangChu;

public class Application {
    public static void main(String[] args) {
    	// kết nối database
    	try {
    		ConnectDB.getInstance().connect();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
		new GUIDangNhap().setVisible(true);
	}
}
