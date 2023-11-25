package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.NhanVien;
import entity.TaiKhoan;

public class DAONhanVien {

	// hàm lấy danh sách nhân viên
	public ArrayList<NhanVien> layDSNhanVien() {
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from NhanVien nv join TaiKhoan tk on nv.maNhanVien = tk.tenTaiKhoan";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
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
				String trangThai = rs.getBoolean("trangThai") ? "Đang làm" : "Đã nghỉ";
				TaiKhoan tk = new TaiKhoan(maNhanVien, matKhau);
				NhanVien nv = new NhanVien(maNhanVien, tenNhanVien, sdt, email, gioiTinh, diaChi, chucVu, cCCD, hinhAnh,
						trangThai, tk);
				dsNhanVien.add(nv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNhanVien;
	}

	// thêm nhân viên
	public boolean themNhanVien(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql_nv = "insert into NhanVien values(?,?,?,?,?,?,?,?,?,?)";
		int n = 0;
		try {
			PreparedStatement stmtNV = con.prepareStatement(sql_nv);
			stmtNV.setString(1, nv.getMaNhanVien());
			stmtNV.setString(2, nv.getTenNhanVien());
			stmtNV.setString(3, nv.getSdt());
			stmtNV.setBoolean(4, nv.isGioiTinh());
			stmtNV.setString(5, nv.getDiaChi());
			stmtNV.setString(6, nv.getChucVu());
			stmtNV.setString(7, nv.getcCCD());
			stmtNV.setString(8, nv.getHinhAnh());
			stmtNV.setString(9, nv.getTrangThai());
			stmtNV.setString(10, nv.getEmail());
			n = stmtNV.executeUpdate();
		} catch (Exception e) {
		}
		return n > 0;
	}

	// sửa nhân viên
	public boolean capNhatNV(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		String sql_nv = "update NhanVien set tenNhanVien = ?, sdt = ?, gioiTinh = ?, diaChi = ?, chucVu = ?, "
				+ "cccd = ?, hinhAnh = ?, email = ?, trangThai = ? where maNhanVien = ?";
		int n = 0;
		try {
			ps = con.prepareStatement(sql_nv);
			ps.setString(1, nv.getTenNhanVien());
			ps.setString(2, nv.getSdt());
			ps.setBoolean(3, nv.isGioiTinh());
			ps.setString(4, nv.getDiaChi());
			ps.setString(5, nv.getChucVu());
			ps.setString(6, nv.getcCCD());
			ps.setString(7, nv.getHinhAnh());
			ps.setString(8, nv.getEmail());
			ps.setBoolean(9, nv.getTrangThai().equals("Đang làm") ? true : false);
			ps.setString(10, nv.getMaNhanVien());
			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	// tìm nhân viên theo mã
	public NhanVien layNhanVienTheoMa(String maNV) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from NhanVien nv join TaiKhoan tk on nv.maNhanVien=tk.tenTaiKhoan where nv.maNhanVien = ?";
		NhanVien nv = null;
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, maNV);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				TaiKhoan tk = new TaiKhoan(maNV, rs.getString("matKhau"));
				String tenNV = rs.getString("tenNhanVien").trim();
				String sdt = rs.getString("sdt").trim();
				Boolean gioiTinh = rs.getBoolean("gioiTinh");
				String diaChi = rs.getString("diaChi").trim();
				String chucVu = rs.getString("chucVu").trim();
				String hinhAnh = rs.getString("hinhAnh").trim();
				String email = rs.getString("email").trim();
				String cccd = rs.getString("cccd").trim();
				String trangThai = rs.getString("trangThai").trim();
				nv = new NhanVien(maNV, tenNV, sdt, email, gioiTinh, diaChi, chucVu, cccd, hinhAnh, trangThai, tk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nv;
	}
	
	public boolean capNhatMatKhauNV(String nv, String matKhau) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		String sql_nv = "update TaiKhoan set matKhau = ? where tenTaiKhoan = ?";
		int n = 0;
		try {
			ps = con.prepareStatement(sql_nv);
			ps.setString(1, matKhau);
			ps.setString(2, nv);
			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
	
	public String layMatKhauNhanVienTheoMa(String ma) {
		String mk = "";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from NhanVien nv join TaiKhoan tk on nv.maNhanVien=tk.tenTaiKhoan where nv.maNhanVien = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				mk = rs.getString("matKhau");
			}
		}catch(Exception e) {
			
		}
		return mk;
		
	}

}
