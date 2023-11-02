package bus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectDB;
import dao.DAODanhMuc;
import entity.DanhMuc;

public class BUSDanhMuc {
	DAODanhMuc daoDanhMuc = new DAODanhMuc();
	// lấy ds danh mục
		public ArrayList<DanhMuc> layDSDanhMuc() {
			return daoDanhMuc.layDSDanhMuc();
		}
		
		public DanhMuc timDanhMucTheoMa(String maDanhMuc) {
			return daoDanhMuc.timDanhMucTheoMa(maDanhMuc);
		}

		// thêm danh mục
		public boolean taoDanhMuc(DanhMuc dm) {
			return daoDanhMuc.taoDanhMuc(dm);
		}
}
