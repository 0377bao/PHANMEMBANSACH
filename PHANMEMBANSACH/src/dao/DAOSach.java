package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.NhaCungCap;
import entity.Sach;

public class DAOSach {
	public DAOSach() {

	}

	// lấy ds sách
	public ArrayList<Sach> layDSSach() {
		ArrayList<Sach> dsSach = new ArrayList<Sach>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {

			Statement stmt = con.createStatement();
			String sql = "select * from Sach";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maS = rs.getString("maSanPham");
				String tenS = rs.getString("tenSanPham");
				int soLuongTon = rs.getInt("soLuongTon");
				float giaNhap = rs.getFloat("giaNhap");
				String theLoai = rs.getString("theLoai");
				String ke = rs.getString("ke");
				String hinhAnh = rs.getString("hinhAnh");
				float thue = rs.getFloat("thue");
				float loiNhuan = rs.getFloat("phanTramLoiNhuan");
				String tg = rs.getString("tacGia");
				String nhaXB = rs.getString("nhaXuatBan");
				int namXB = rs.getInt("namXuatBan");

				String trangThai = rs.getBoolean("trangThai") ? "Đang bán" : "Không còn bán";
				NhaCungCap maNCC = new NhaCungCap(rs.getString("maNhaCungCap"));
				Sach s = new Sach(maS, tenS, soLuongTon, giaNhap, theLoai, ke, hinhAnh, thue, loiNhuan,
						trangThai, maNCC, tg, nhaXB, namXB);
				dsSach.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsSach;
	}

	// thêm sách
	public boolean taoSach(Sach s) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		try {
			String sql = "insert into Sach values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, s.getMaSanPham());
			ps.setString(2, s.getTenSanPham());
			ps.setInt(3, s.getSoLuongTon());
			ps.setFloat(4, s.getGiaNhap());
			ps.setString(5, s.getTheLoai());
			ps.setString(6, s.getNhaCungCap().getMaNhaCungCap());
			ps.setString(7, s.getKe());
			ps.setString(8, s.getHinhAnh());
			ps.setFloat(9, s.getThue());
			ps.setFloat(10, s.getPhanTramLoiNhuan());
			ps.setString(11, s.getTacGia());
			ps.setString(12, s.getNhaXuatBan());
			ps.setInt(13, s.getNamXuatBan());
			ps.setFloat(14, s.getGiaBan());
			ps.setString(15, s.getTrangThai());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	// sửa sách
	public boolean capNhatSach(Sach s) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		String sql = "update Sach set tenSanPham = ?, soLuongTon = ?, giaNhap = ?, theLoai = ?, ke = ?, "
				+ "maNhaCungCap = ?, hinhAnh = ?, thue = ?, phanTramLoiNhuan = ?, tacGia = ?, nhaXuatBan = ?, "
				+ "namXuatBan = ?, giaBan = ?, trangThai = ?";
		int n = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, s.getTenSanPham());
			ps.setInt(2, s.getSoLuongTon());
			ps.setFloat(3, s.getGiaNhap());
			ps.setString(4, s.getTheLoai());
			ps.setString(5, s.getNhaCungCap().getMaNhaCungCap());
			ps.setString(6, s.getKe());
			ps.setString(7, s.getHinhAnh());
			ps.setFloat(8, s.getThue());
			ps.setFloat(9, s.getPhanTramLoiNhuan());
			ps.setString(10, s.getTacGia());
			ps.setString(11, s.getNhaXuatBan());
			ps.setInt(12, s.getNamXuatBan());
			ps.setString(14, s.getTrangThai());
			ps.setString(15, s.getMaSanPham());
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

	// tìm sách theo mã
	public Sach timSachTheoMa(String maSP) {
		Sach sp = null;
		Connection con = ConnectDB.getConnection();
		String sql = "select * from Sach where maSanPham = ?";
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, maSP);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String tenSanPham = rs.getString("tenSanPham").trim();
				int soLuongTon = rs.getInt("soLuongTon");
				float giaNhap = rs.getFloat("giaNhap");
				String theLoai = rs.getString("theLoai").trim();
				String ke = rs.getString("ke").trim();
				String hinhAnh = rs.getString("hinhAnh").trim();
				float thue = rs.getFloat("thue");
				float phanTramLoiNhuan = rs.getFloat("phanTramLoiNhuan");
				float giaBan = rs.getFloat("giaBan");
				String trangThai = rs.getBoolean("trangThai") ? "Đang bán" : "Ngưng bán";
				String maNhaCungCap = rs.getString("maNhaCungCap").trim();
				NhaCungCap ncc = new NhaCungCap(maNhaCungCap);
				String tacGia = rs.getString("tacGia").trim();
				String nhaXuatBan = rs.getString("nhaXuatBan").trim();
				int namXuatBan = rs.getInt("namXuatBan");
				sp = new Sach(maSP, tenSanPham, soLuongTon, giaNhap, theLoai, ke, hinhAnh, thue, phanTramLoiNhuan,

						 trangThai, ncc, tacGia, nhaXuatBan, namXuatBan);

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return sp;
	}
}
