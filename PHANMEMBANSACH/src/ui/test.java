package ui;

import java.sql.SQLException;

import bus.BUSChuongTrinhKhuyenMai;
import connect.ConnectDB;

public class test {
	public static void main(String[] args) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String temp = "35,400 VND";
		String newT = (temp.replace(',', ' '));
		String result = newT.substring(0, newT.length() - 3).replaceAll(" ", "");
		System.out.println(newT);
		System.out.println(result);
	}
}
