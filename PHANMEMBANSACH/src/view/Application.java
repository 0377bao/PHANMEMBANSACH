package view;

import connect.ConnectDB;
import ui.TrangChu;

public class Application {
    public static void main(String[] args) {
    	// kết nối database
    	try {
    		ConnectDB.getInstance().connect();
    		System.out.println("Kết nối thành công");
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
		new TrangChu().setVisible(true);
	}
}
