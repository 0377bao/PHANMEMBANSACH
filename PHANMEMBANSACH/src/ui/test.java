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
		System.out.println(new BUSChuongTrinhKhuyenMai().timChuongTrinhKhuyenMaiDangApDung());
	}
}
