package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.DanhMuc;
import entity.NhaCungCap;
import entity.VanPhongPham;

public class DAOVanPhongPham {
	public DAOVanPhongPham() {

	}

	// lấy ds văn phòng phẩm
	public ArrayList<VanPhongPham> layDSVanPhongPham() {
		ArrayList<VanPhongPham> dsVPP = new ArrayList<VanPhongPham>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			Statement stmt = con.createStatement();
			String sql = "select * from VanPhongPham";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maVPP = rs.getString("maSanPham");
				String tenVPP = rs.getString("tenSanPham");
				int soLuongTon = rs.getInt("soLuongTon");
				float giaNhap = rs.getFloat("giaNhap");
				String theLoai = rs.getString("theLoai");
				String ke = rs.getString("ke");
				String hinhAnh = rs.getString("hinhAnh");
				float thue = rs.getFloat("thue");
				float loiNhuan = rs.getFloat("phanTramLoiNhuan");
				String chatLieu = rs.getString("chatLieu");
				String trangThai = rs.getBoolean("trangThai") ? "Đang bán" : "Không còn bán";
				DanhMuc maDM = new DanhMuc(rs.getString("maDanhMuc"));
				NhaCungCap maNCC = new NhaCungCap(rs.getString("maNhaCungCap"));
				VanPhongPham vpp = new VanPhongPham(maVPP, tenVPP, soLuongTon, giaNhap, theLoai, ke, hinhAnh, thue,
						loiNhuan, trangThai, maNCC, chatLieu, maDM);
				dsVPP.add(vpp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsVPP;
	}

	// thêm văn phòng phẩm
	public boolean taoSach(VanPhongPham vpp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		try {
			String sql = "insert into Sach values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, vpp.getMaSanPham());
			ps.setString(2, vpp.getTenSanPham());
			ps.setInt(3, vpp.getSoLuongTon());
			ps.setFloat(4, vpp.getGiaNhap());
			ps.setString(5, vpp.getTheLoai());
			ps.setString(6, vpp.getNhaCungCap().getMaNhaCungCap());
			ps.setString(7, vpp.getKe());
			ps.setString(8, vpp.getHinhAnh());
			ps.setFloat(9, vpp.getThue());
			ps.setFloat(10, vpp.getPhanTramLoiNhuan());
			ps.setString(11, vpp.getDanhMuc().getMaDanhMuc());
			ps.setString(12, vpp.getChatLieu());
			ps.setString(14, vpp.getTrangThai());
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

	// sửa văn phòng phẩm
	public boolean capNhatVanPhongPham(VanPhongPham vpp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		String sql = "update Sach set tenSanPham = ?, soLuongTon = ?, giaNhap = ?, theLoai = ?, ke = ?, "
				+ "maNhaCungCap = ?, hinhAnh = ?, thue = ?, phanTramLoiNhuan = ?, tacGia = ?, nhaXuatBan = ?, "
				+ "namXuatBan = ?, trangThai = ?";
		int n = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, vpp.getTenSanPham());
			ps.setInt(2, vpp.getSoLuongTon());
			ps.setFloat(3, vpp.getGiaNhap());
			ps.setString(4, vpp.getTheLoai());
			ps.setString(5, vpp.getNhaCungCap().getMaNhaCungCap());
			ps.setString(6, vpp.getKe());
			ps.setString(7, vpp.getHinhAnh());
			ps.setFloat(8, vpp.getThue());
			ps.setFloat(9, vpp.getPhanTramLoiNhuan());
			ps.setString(10, vpp.getDanhMuc().getMaDanhMuc());
			ps.setString(11, vpp.getChatLieu());
			ps.setString(13, vpp.getTrangThai());
			ps.setString(14, vpp.getMaSanPham());
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

	// tìm văn phòng phẩm theo mã
	public VanPhongPham timVanPhongPhamTheoMa(String maSP) {
		VanPhongPham sp = null;
		Connection con = ConnectDB.getConnection();
		String sql = "select * from VanPhongPham vpp join DanhMuc dm on vpp.maDanhMuc = dm.maDanhMuc where vpp.maSanPham = ?";
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
				String trangThai = rs.getBoolean("trangThai") ? "Đang bán" : "Ngưng bán";
				String maNhaCungCap = rs.getString("maNhaCungCap").trim();
				NhaCungCap ncc = new NhaCungCap(maNhaCungCap);
				String chatLieu = rs.getString("chatLieu").trim();
				String maDanhMuc = rs.getString("maDanhMuc").trim();
				String tenDanhMuc = rs.getString("tenDanhMuc").trim();
				DanhMuc dm = new DanhMuc(maDanhMuc, tenDanhMuc);
				sp = new VanPhongPham(maSP, tenSanPham, soLuongTon, giaNhap, theLoai, ke, hinhAnh, thue,
						phanTramLoiNhuan, trangThai, ncc, chatLieu, dm);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return sp;
	}
}
