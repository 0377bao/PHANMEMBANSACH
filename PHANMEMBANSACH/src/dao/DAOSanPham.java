package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bus.BUSDanhMuc;
import bus.BUSNhaCungCap;
import connect.ConnectDB;
import entity.DanhMuc;
import entity.NhaCungCap;
import entity.Sach;
import entity.SanPham;
import entity.VanPhongPham;

public class DAOSanPham {
	public ArrayList<SanPham> layDSSanPham() {
		ArrayList<SanPham> ds = new ArrayList<>();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from SanPham";
		Statement statement = null;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maS = rs.getString("maSanPham");
				String tenS = rs.getString("tenSanPham");
				int soLuongTon = rs.getInt("soLuongTon");
				float giaNhap = rs.getFloat("giaNhap");
				String theLoai = rs.getString("theLoai");
				String ke = rs.getString("ke");
				NhaCungCap ncc = new BUSNhaCungCap().timNhaCungCapTheoMa(rs.getString("maNhaCungCap"));
				String hinhAnh = rs.getString("hinhAnh");
				float thue = rs.getFloat("thue");
				float loiNhuan = rs.getFloat("phanTramLoiNhuan");
				String trangThai = rs.getBoolean("trangThai") ? "Đang bán" : "Ngưng bán";
				if(maS.startsWith("SPS")) {
					String tg = rs.getString("tacGia");
					String nhaXB = rs.getString("nhaXuatBan");
					int namXB = rs.getInt("namXuatBan");
					ds.add(new Sach(maS, tenS, soLuongTon, giaNhap, theLoai, ke, hinhAnh, thue, loiNhuan, trangThai, ncc, tg, nhaXB, namXB));
				} else {
					DanhMuc danhMuc = new BUSDanhMuc().timDanhMucTheoMa(rs.getString("maDanhMuc"));
					String chatLieu = rs.getString("chatLieu");
					ds.add(new VanPhongPham(maS, tenS, soLuongTon, giaNhap, theLoai, ke, hinhAnh, thue, loiNhuan, trangThai, ncc, chatLieu, danhMuc));	
				} 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}

	public Sach timSachTheoMa(String maS) {
		Sach sach = null;
		Connection con = ConnectDB.getConnection();
		String sql = "select * from SanPham where maSanPham = ?";
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, maS);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maSach = rs.getString("maSanPham");
				String tenS = rs.getString("tenSanPham");
				int soLuongTon = rs.getInt("soLuongTon");
				float giaNhap = rs.getFloat("giaNhap");
				String theLoai = rs.getString("theLoai");
				String ke = rs.getString("ke");
				NhaCungCap ncc = new BUSNhaCungCap().timNhaCungCapTheoMa(rs.getString("maNhaCungCap"));
				String hinhAnh = rs.getString("hinhAnh");
				float thue = rs.getFloat("thue");
				float loiNhuan = rs.getFloat("phanTramLoiNhuan");
				String trangThai = rs.getBoolean("trangThai") ? "Đang bán" : "Ngưng bán";
				String tg = rs.getString("tacGia");
				String nhaXB = rs.getString("nhaXuatBan");
				int namXB = rs.getInt("namXuatBan");
				sach = new Sach(maS, tenS, soLuongTon, giaNhap, theLoai, ke, hinhAnh, thue, loiNhuan, trangThai, ncc, tg, nhaXB, namXB);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sach;
	}

	public VanPhongPham timVanPhongPhamTheoMa(String maV) {
		VanPhongPham vpp = null;
		Connection con = ConnectDB.getConnection();
		String sql = "select * from SanPham where maSanPham = ?";
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, maV);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maS = rs.getString("maSanPham");
				String tenS = rs.getString("tenSanPham");
				int soLuongTon = rs.getInt("soLuongTon");
				float giaNhap = rs.getFloat("giaNhap");
				String theLoai = rs.getString("theLoai");
				String ke = rs.getString("ke");
				NhaCungCap ncc = new BUSNhaCungCap().timNhaCungCapTheoMa(rs.getString("maNhaCungCap"));
				String hinhAnh = rs.getString("hinhAnh");
				float thue = rs.getFloat("thue");
				float loiNhuan = rs.getFloat("phanTramLoiNhuan");
				String trangThai = rs.getBoolean("trangThai") ? "Đang bán" : "Ngưng bán";
				DanhMuc danhMuc = new BUSDanhMuc().timDanhMucTheoMa(rs.getString("maDanhMuc"));
				String chatLieu = rs.getString("chatLieu");
				vpp = new VanPhongPham(maS, tenS, soLuongTon, giaNhap, theLoai, ke, hinhAnh, thue, loiNhuan, trangThai, ncc, chatLieu, danhMuc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vpp;
	}
	
	public boolean themSach(Sach s) {
		int n = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		try {
			String sql = "insert into SanPham values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, null)";
			ps = con.prepareStatement(sql);
			ps.setString(1, s.getMaSanPham());
			ps.setString(2, s.getTenSanPham());
			ps.setInt(3, s.getSoLuongTon());
			ps.setFloat(4, s.getGiaNhap());
			ps.setString(5, s.getTheLoai());
			ps.setString(6, s.getKe());
			ps.setString(7, s.getNhaCungCap().getMaNhaCungCap());
			ps.setString(8, s.getHinhAnh());
			ps.setFloat(9, s.getThue());
			ps.setFloat(10, s.getPhanTramLoiNhuan());
			ps.setString(11, s.getTacGia());
			ps.setString(12, s.getNhaXuatBan());
			ps.setInt(13, s.getNamXuatBan());
			ps.setFloat(14, s.getGiaBan());
			ps.setBoolean(15, s.getTrangThai().equals("Đang bán") ? true : false);
			ps.setString(16, "DM8");
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	

	public boolean themVanPhongPham(VanPhongPham vpp) {
		int n = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		try {
			String sql = "insert into SanPham values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, null, null, null, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, vpp.getMaSanPham());
			ps.setString(2, vpp.getTenSanPham());
			ps.setInt(3, vpp.getSoLuongTon());
			ps.setFloat(4, vpp.getGiaNhap());
			ps.setString(5, vpp.getTheLoai());
			ps.setString(6, vpp.getKe());
			ps.setString(7, vpp.getNhaCungCap().getMaNhaCungCap());
			ps.setString(8, vpp.getHinhAnh());
			ps.setFloat(9, vpp.getThue());
			ps.setFloat(10, vpp.getPhanTramLoiNhuan());
			ps.setFloat(11, vpp.getGiaBan());
			ps.setBoolean(12, vpp.getTrangThai().equals("Đang bán") ? true : false);
			ps.setString(13, vpp.getDanhMuc().getMaDanhMuc());
			ps.setString(14, vpp.getChatLieu());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean capNhatSach(Sach sachSua) {
		int n = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		String sql = "update SanPham set tenSanPham = ?, soLuongTon = ?, giaNhap = ?, theLoai = ?, ke = ?, "
				+ "maNhaCungCap = ?, hinhAnh = ?, thue = ?, phanTramLoiNhuan = ?, tacGia = ?, nhaXuatBan = ?, "
				+ "namXuatBan = ?, giaBan = ?, trangThai = ? where maSanPham = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, sachSua.getTenSanPham());
			ps.setInt(2, sachSua.getSoLuongTon());
			ps.setFloat(3, sachSua.getGiaNhap());
			ps.setString(4, sachSua.getTheLoai());
			ps.setString(5, sachSua.getKe());
			ps.setString(6, sachSua.getNhaCungCap().getMaNhaCungCap());
			ps.setString(7, sachSua.getHinhAnh());
			ps.setFloat(8, sachSua.getThue());
			ps.setFloat(9, sachSua.getPhanTramLoiNhuan());
			ps.setString(10, sachSua.getTacGia());
			ps.setString(11, sachSua.getNhaXuatBan());
			ps.setInt(12, sachSua.getNamXuatBan());
			ps.setFloat(13, sachSua.getGiaBan());
			ps.setBoolean(14, sachSua.getTrangThai().equals("Đang bán") ? true : false);
			ps.setString(15, sachSua.getMaSanPham());
			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean capNhatVanPhongPham(VanPhongPham vppSua) {
		int n = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement ps = null;
		String sql = "update SanPham set tenSanPham = ?, soLuongTon = ?, giaNhap = ?, theLoai = ?, ke = ?, "
				+ "maNhaCungCap = ?, hinhAnh = ?, thue = ?, phanTramLoiNhuan = ?, maDanhMuc = ?, chatLieu = ? , giaBan = ?, trangThai = ? where maSanPham = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, vppSua.getTenSanPham());
			ps.setInt(2, vppSua.getSoLuongTon());
			ps.setFloat(3, vppSua.getGiaNhap());
			ps.setString(4, vppSua.getTheLoai());
			ps.setString(5, vppSua.getKe());
			ps.setString(6, vppSua.getNhaCungCap().getMaNhaCungCap());
			ps.setString(7, vppSua.getHinhAnh());
			ps.setFloat(8, vppSua.getThue());
			ps.setFloat(9, vppSua.getPhanTramLoiNhuan());
			ps.setString(10, vppSua.getDanhMuc().getMaDanhMuc());
			ps.setString(11, vppSua.getChatLieu());
			ps.setFloat(12, vppSua.getGiaBan());
			ps.setBoolean(13, vppSua.getTrangThai().equals("Đang bán") ? true : false);
			ps.setString(14, vppSua.getMaSanPham());
			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
}
