package tool;

import java.text.Format;

public class Tools {
	public static String dinhDangTien(float tien) {
		return String.format("%,.0f VND", tien);
	}
}
