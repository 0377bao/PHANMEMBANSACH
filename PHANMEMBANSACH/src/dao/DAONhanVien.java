package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.NhanVien;
import entity.TaiKhoan;

public class DAONhanVien {
   public DAONhanVien() {
	   
   }
   
   // hàm lấy danh sách nhân viên
   public ArrayList<NhanVien> layDSNhanVien() {
	   ArrayList<NhanVien> dsNhanVien = new ArrayList<>();
	   ConnectDB.getInstance();
	   Connection con = ConnectDB.getConnection();
	   String sql = "select * from NhanVien nv join TaiKhoan tk on nv.maNhanVien = tk.tenTaiKhoan";
	   try {
		   Statement stmt = con.createStatement();
		   ResultSet rs = stmt.executeQuery(sql);
		   while(rs.next()) {
			   String maNhanVien = rs.getString("maNhanVien").trim();
			   String tenNhanVien = rs.getString("tenNhanVien").trim();
			   String sdt = rs.getString("sdt").trim();
			   String email = rs.getString("email").trim();
			   String diaChi = rs.getString("diaChi").trim();
			   Boolean gioiTinh = rs.getBoolean("gioiTinh");
			   String chucVu = rs.getString("chucVu").trim();
			   String cCCD = rs.getString("cccd").trim();
			   String hinhAnh = rs.getString("hinhAnh").trim();
			   String matKhau = rs.getString("matKhau").trim();
			   TaiKhoan tk = new TaiKhoan(maNhanVien, matKhau);
			   NhanVien nv = new NhanVien(maNhanVien, tenNhanVien, sdt, email, gioiTinh, diaChi, chucVu, cCCD, hinhAnh, tk);
			   dsNhanVien.add(nv);
		   }
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	   return dsNhanVien;
   }
   
   // hàm thêm nhân viên
   public boolean themNhanVien(NhanVien nv) {
	   ConnectDB.getInstance();
	   Connection con = ConnectDB.getConnection();
	   String sql_nv = "insert into NhanVien values(?,?,?,?,?,?,?,?,?)";
	   String sql_tk = "insert into TaiKhoan values(?,?)";
	   int m = 0;
	   int n = 0;
	   try {
		   PreparedStatement stmtTK = con.prepareStatement(sql_tk);
		   stmtTK.setString(0, nv.getTaiKhoan().getTenTaiKhoan());
		   stmtTK.setString(1, nv.getTaiKhoan().getMatKhau());
		   
		   PreparedStatement stmtNV = con.prepareStatement(sql_nv);
		   stmtNV.setString(1, nv.getMaNhanVien());
		   stmtNV.setString(2, nv.getTenNhanVien());
		   stmtNV.setString(3, nv.getSdt());
		   stmtNV.setBoolean(4, nv.isGioiTinh());
		   stmtNV.setString(5, nv.getDiaChi());
		   stmtNV.setString(6, nv.getChucVu());
		   stmtNV.setString(7, nv.getcCCD());
		   stmtNV.setString(8, nv.getHinhAnh());
		   stmtNV.setString(9, nv.getEmail());
		   n = stmtTK.executeUpdate();
		   m = stmtNV.executeUpdate();
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	   return m > 0 && n > 0 ? true : false;
   }
}
