package bus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectDB;
import dao.DAONhaCungCap;
import entity.NhaCungCap;

public class BUSNhaCungCap {
	DAONhaCungCap daoNCC = new DAONhaCungCap();
	// lấy ds nhà cung cấp
		public ArrayList<NhaCungCap> layDSNhaCungCap() {
			return daoNCC.layDSNhaCungCap();
		}

		// thêm nhà cung cấp
		public boolean taoNCC(NhaCungCap ncc) {
			return daoNCC.taoNCC(ncc);
		}

		// sửa nhà cung cấp
		public boolean capNhatNCC(NhaCungCap ncc) {
			return daoNCC.capNhatNCC(ncc);
		}

		// lấy nhà cung cấp theo mã
		public NhaCungCap timNhaCungCapTheoMa(String maNhaCungCap) {
			return daoNCC.timNhaCungCapTheoMa(maNhaCungCap);
		}
}
