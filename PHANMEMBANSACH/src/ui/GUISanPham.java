package ui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import customUI.MyButton;
import customUI.MyCombobox;
import customUI.MyTable;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;

public class GUISanPham extends JPanel {
	private JTextField txtTheLoaiS;
	private JTextField txtMaSP;
	private JTextField txtMaSach;
	private JTextField txtTenSP;
	private JTextField txtTenSach;
	private JTextField txtKe;
	private JTextField txtKeS;
	private JTextField txtSoLuong;
	private JTextField txtSoLuongS;
	private JTextField txtGiaNhap;
	private JTextField txtGiaNhapS;
	private JTextField txtThue;
	private JTextField txtThueS;
	private JTextField txtLoiNhuan;
	private JTextField txtLoiNhuanS;
	private JTextField txtTacGia;
	private JTextField txtTheLoai;
	private JTextField txtNhaXB;
	private JTextField txtChatLieu;
	private JTextField txtNamXB;
	private JButton btnHinhAnh;
	private JButton btnHinhAnhS;
	private JButton btnTaoMaSP;
	private JButton btnTaoMaS;
	private JTextField txtTimTheoMa;
	private JTextField txtTimKiemS;
	private JTextField txtLocTheLoai;
	private JTextField txtLocTheLoaiS;
	private JTextField txtLocNamXB;
	private JTextField txtLocTacGia;
	private MyCombobox cboLocNCC;
	private MyCombobox cboLocNCCS;
	private MyCombobox cboNhaCungCap;
	private MyCombobox cboNhaCungCapS;
	private MyCombobox cboDanhMuc;
	private MyCombobox cboLocDanhMuc;
	private JButton btnThemSach;
	private JButton btnCapNhatS;
	private JButton btnXoaTrangS;
	private JButton btnTaiLaiS;
	private JButton btnThemSP;
	private JButton btnCapNhat;
	private JButton btnXoaTrang;
	private JButton btnTaiLai;
	private JButton btnTimMaS;
	private JButton btnTimMa;
	private JComboBox cboLocTrangThaiS;
	private JLabel lblTrangThai_1;
	private JCheckBox chkTrangThai_1;

	public GUISanPham() {
		this.setBackground(new Color(255, 255, 255));
		this.setBounds(250, 0, 1285, 800);
		this.setLayout(null);

		// tạo tab
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setBounds(0, 0, 1285, 800);

		// tab sách
		JPanel pnlSach = new JPanel();
		pnlSach.setBackground(new Color(240, 240, 240));
		pnlSach.setBounds(0, 0, 1230, 800);
		pnlSach.setLayout(null);

		// thông tin sách
		JPanel pnlThongTinS = new JPanel();
		pnlThongTinS.setBackground(new Color(255, 255, 255));
		pnlThongTinS.setBounds(20, 20, 1235, 255);
		pnlThongTinS.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Th\u00F4ng Tin S\u1EA3n Ph\u1EA9m",
				TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		pnlSach.add(pnlThongTinS);
		pnlThongTinS.setLayout(null);

		JLabel lblMaSach = new JLabel("Mã sách");
		lblMaSach.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaSach.setBounds(25, 35, 90, 15);
		pnlThongTinS.add(lblMaSach);

		JLabel lblTenSach = new JLabel("Tên sách");
		lblTenSach.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenSach.setBounds(25, 77, 90, 15);
		pnlThongTinS.add(lblTenSach);

		JLabel lblNCC = new JLabel("Nhà cung cấp");
		lblNCC.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNCC.setBounds(25, 118, 90, 15);
		pnlThongTinS.add(lblNCC);

		JLabel lblTheLoai = new JLabel("Thể loại");
		lblTheLoai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTheLoai.setBounds(519, 118, 90, 15);
		pnlThongTinS.add(lblTheLoai);

		JLabel lblKe = new JLabel("Kệ");
		lblKe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKe.setBounds(25, 161, 90, 15);
		pnlThongTinS.add(lblKe);

		btnTaoMaS = new MyButton("Tạo mã");
		btnTaoMaS.setForeground(new Color(255, 255, 255));
		btnTaoMaS.setBounds(357, 32, 96, 21);
		pnlThongTinS.add(btnTaoMaS);

		txtMaSach = new JTextField();
		txtMaSach.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMaSach.setEnabled(false);
		txtMaSach.setColumns(10);
		txtMaSach.setBounds(116, 30, 215, 25);
		pnlThongTinS.add(txtMaSach);

		txtTenSach = new JTextField();
		txtTenSach.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTenSach.setColumns(10);
		txtTenSach.setBounds(116, 72, 337, 25);
		pnlThongTinS.add(txtTenSach);

		cboNhaCungCapS = new MyCombobox();
		cboNhaCungCapS.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboNhaCungCapS.setBounds(116, 114, 337, 25);
		pnlThongTinS.add(cboNhaCungCapS);

		txtTheLoaiS = new JTextField();
		txtTheLoaiS.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTheLoaiS.setBounds(609, 113, 120, 25);
		pnlThongTinS.add(txtTheLoaiS);
		txtTheLoaiS.setColumns(10);

		txtKeS = new JTextField();
		txtKeS.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtKeS.setBounds(116, 156, 337, 25);
		pnlThongTinS.add(txtKeS);
		txtKeS.setColumns(10);

		JLabel lblSoLuong = new JLabel("Số lượng");
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSoLuong.setBounds(519, 35, 90, 15);
		pnlThongTinS.add(lblSoLuong);

		JLabel lblGiaNhap = new JLabel("Giá nhập");
		lblGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGiaNhap.setBounds(519, 77, 90, 15);
		pnlThongTinS.add(lblGiaNhap);

		JLabel lblThue = new JLabel("Thuế");
		lblThue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThue.setBounds(761, 35, 68, 15);
		pnlThongTinS.add(lblThue);

		JLabel lblLoiNhuan = new JLabel("Lợi nhuận ");
		lblLoiNhuan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLoiNhuan.setBounds(761, 77, 68, 15);
		pnlThongTinS.add(lblLoiNhuan);

		JLabel lblTacGia = new JLabel("Tác giả");
		lblTacGia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTacGia.setBounds(761, 119, 90, 15);
		pnlThongTinS.add(lblTacGia);

		JLabel lblNhaXB = new JLabel("Nhà xuất bản");
		lblNhaXB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNhaXB.setBounds(519, 161, 90, 15);
		pnlThongTinS.add(lblNhaXB);

		JLabel lblNamXB = new JLabel("Năm xuất bản");
		lblNamXB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNamXB.setBounds(519, 203, 90, 15);
		pnlThongTinS.add(lblNamXB);

		txtSoLuongS = new JTextField();
		txtSoLuongS.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSoLuongS.setBounds(609, 30, 120, 25);
		pnlThongTinS.add(txtSoLuongS);
		txtSoLuongS.setColumns(10);

		txtGiaNhapS = new JTextField();
		txtGiaNhapS.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtGiaNhapS.setBounds(609, 72, 120, 25);
		pnlThongTinS.add(txtGiaNhapS);
		txtGiaNhapS.setColumns(10);

		txtThueS = new JTextField();
		txtThueS.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtThueS.setBounds(825, 30, 120, 25);
		pnlThongTinS.add(txtThueS);
		txtThueS.setColumns(10);

		txtLoiNhuanS = new JTextField();
		txtLoiNhuanS.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtLoiNhuanS.setBounds(825, 72, 120, 25);
		pnlThongTinS.add(txtLoiNhuanS);
		txtLoiNhuanS.setColumns(10);

		txtTacGia = new JTextField();
		txtTacGia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTacGia.setBounds(825, 113, 120, 25);
		pnlThongTinS.add(txtTacGia);
		txtTacGia.setColumns(10);

		txtNhaXB = new JTextField();
		txtNhaXB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNhaXB.setBounds(609, 156, 337, 25);
		pnlThongTinS.add(txtNhaXB);
		txtNhaXB.setColumns(10);

		txtNamXB = new JTextField();
		txtNamXB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNamXB.setBounds(609, 198, 337, 25);
		pnlThongTinS.add(txtNamXB);
		txtNamXB.setColumns(10);

		JLabel lblPhanTramThue = new JLabel("%");
		lblPhanTramThue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhanTramThue.setBounds(956, 35, 30, 15);
		pnlThongTinS.add(lblPhanTramThue);

		JLabel lblPhanTramLN = new JLabel("%");
		lblPhanTramLN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhanTramLN.setBounds(955, 77, 30, 15);
		pnlThongTinS.add(lblPhanTramLN);

		JPanel pnlHinhAnh = new JPanel();
		pnlHinhAnh.setBackground(new Color(255, 255, 255));
		pnlHinhAnh.setBounds(1020, 30, 180, 180);
		pnlHinhAnh.setBorder(null);
		pnlHinhAnh.setForeground(new Color(255, 255, 255));
		pnlThongTinS.add(pnlHinhAnh);
		// ImageIcon anhSach = new
		// ImageIcon("src/image/sanpham/tuoi-tre-dang-gia-bao-nhieu.png");
		pnlHinhAnh.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel lblHinhAnhS = new JLabel();
//		lblHinhAnhS.setIcon(new ImageIcon(GUISanPham.class.getResource("/image/product/SPS4.jpg")));
		pnlHinhAnh.add(lblHinhAnhS);

		btnHinhAnhS = new MyButton("Chọn ảnh ");
		btnHinhAnhS.setBounds(1067, 220, 100, 21);
		btnHinhAnhS.setForeground(new Color(255, 255, 255));
		pnlThongTinS.add(btnHinhAnhS);

		lblTrangThai_1 = new JLabel("Trạng thái");
		lblTrangThai_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTrangThai_1.setBounds(25, 203, 90, 15);
		pnlThongTinS.add(lblTrangThai_1);

		chkTrangThai_1 = new JCheckBox("Đang bán");
		chkTrangThai_1.setSelected(true);
		chkTrangThai_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chkTrangThai_1.setBackground(Color.WHITE);
		chkTrangThai_1.setBounds(116, 198, 93, 25);
		pnlThongTinS.add(chkTrangThai_1);

		// tìm kiếm
		JPanel pnlTimKiemS = new JPanel();
		pnlTimKiemS.setBackground(new Color(255, 255, 255));
		pnlTimKiemS.setBounds(20, 290, 910, 195);
		pnlTimKiemS.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "T\u00ECm Ki\u1EBFm",
				TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		pnlSach.add(pnlTimKiemS);
		pnlTimKiemS.setLayout(null);

		txtTimKiemS = new JTextField();
		txtTimKiemS.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtTimKiemS.setText("Nhập mã sách hoặc tên sách cần tìm");
		txtTimKiemS.setForeground(new Color(128, 128, 128));
		txtTimKiemS.setBounds(25, 30, 320, 19);
		pnlTimKiemS.add(txtTimKiemS);
		txtTimKiemS.setColumns(10);

		JPanel pnlLocS = new JPanel();
		pnlLocS.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "L\u1ECDc S\u1EA3n Ph\u1EA9m",
				TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		pnlLocS.setBackground(new Color(240, 240, 240));
		pnlLocS.setBounds(25, 66, 840, 110);
		pnlTimKiemS.add(pnlLocS);
		pnlLocS.setLayout(null);

		JLabel lblLocNCC = new JLabel("Nhà cung cấp");
		lblLocNCC.setBounds(25, 29, 90, 13);
		pnlLocS.add(lblLocNCC);

		JLabel lblLocTheLoai = new JLabel("Thể loại");
		lblLocTheLoai.setBounds(450, 29, 70, 13);
		pnlLocS.add(lblLocTheLoai);

		JLabel lblLocNamXB = new JLabel("Năm xuất bản");
		lblLocNamXB.setBounds(25, 66, 90, 13);
		pnlLocS.add(lblLocNamXB);

		JLabel lblLocTacGia = new JLabel("Tác giả");
		lblLocTacGia.setBounds(450, 66, 70, 13);
		pnlLocS.add(lblLocTacGia);

		txtLocTheLoaiS = new JTextField();
		txtLocTheLoaiS.setBounds(516, 26, 300, 19);
		pnlLocS.add(txtLocTheLoaiS);
		txtLocTheLoaiS.setColumns(10);

		txtLocNamXB = new JTextField();
		txtLocNamXB.setBounds(110, 63, 300, 19);
		pnlLocS.add(txtLocNamXB);
		txtLocNamXB.setColumns(10);

		txtLocTacGia = new JTextField();
		txtLocTacGia.setBounds(516, 63, 300, 19);
		pnlLocS.add(txtLocTacGia);
		txtLocTacGia.setColumns(10);

		cboLocNCCS = new MyCombobox();
		cboLocNCCS.setBounds(110, 25, 300, 21);
		pnlLocS.add(cboLocNCCS);

		btnTimMaS = new MyButton("Tìm");
		btnTimMaS.setForeground(new Color(255, 255, 255));
		btnTimMaS.setBounds(365, 29, 69, 21);
		pnlTimKiemS.add(btnTimMaS);

		cboLocTrangThaiS = new MyCombobox();
		cboLocTrangThaiS.setBounds(650, 29, 215, 21);
		pnlTimKiemS.add(cboLocTrangThaiS);

		// dữ liệu mẫu
		cboLocTrangThaiS.addItem("Đang bán");
		cboLocTrangThaiS.addItem("Không còn bán");

		JLabel lblLocTrangThaiS = new JLabel("Kiểm tra trạng thái");
		lblLocTrangThaiS.setBounds(538, 33, 104, 13);
		pnlTimKiemS.add(lblLocTrangThaiS);

		// chức năng
		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBackground(new Color(255, 255, 255));
		pnlChucNang.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Ch\u1EE9c N\u0103ng",
				TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		pnlChucNang.setBounds(945, 290, 310, 195);
		pnlSach.add(pnlChucNang);
		pnlChucNang.setLayout(null);

		btnThemSach = new MyButton("THÊM SẢN PHẨM");
		btnThemSach.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThemSach.setForeground(new Color(255, 255, 255));
		btnThemSach.setText("Thêm");
		btnThemSach.setBounds(35, 48, 100, 30);
		pnlChucNang.add(btnThemSach);

		btnCapNhatS = new MyButton("CẬP NHẬT ");
		btnCapNhatS.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCapNhatS.setText("Cập nhật");
		btnCapNhatS.setForeground(new Color(255, 255, 255));
		btnCapNhatS.setBounds(175, 48, 100, 30);
		pnlChucNang.add(btnCapNhatS);

		btnXoaTrangS = new MyButton("XÓA TRẮNG");
		btnXoaTrangS.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoaTrangS.setText("Xóa trắng");
		btnXoaTrangS.setForeground(new Color(255, 255, 255));
		btnXoaTrangS.setBounds(35, 106, 100, 30);
		pnlChucNang.add(btnXoaTrangS);

		btnTaiLaiS = new MyButton("TẢI LẠI");
		btnTaiLaiS.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTaiLaiS.setText("Tải lại");
		btnTaiLaiS.setForeground(new Color(255, 255, 255));
		btnTaiLaiS.setBounds(175, 106, 100, 30);
		pnlChucNang.add(btnTaiLaiS);

		// tạo bảng sách
		JPanel pnlTableS = new JPanel();
		pnlTableS.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Danh S\u00E1ch S\u1EA3n Ph\u1EA9m",
				TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		pnlTableS.setBackground(new Color(255, 255, 255));
		pnlTableS.setBounds(20, 500, 1235, 263);
		pnlSach.add(pnlTableS);
		String[] colsSach = { "Mã SP", "Tên sản phẩm", "Nhà cung cấp", "Tác giả", "Thể loại", "Nhà xuất bản",
				"Năm xuất bản", "Kệ", "Số lượng", "Giá nhập" };
		DefaultTableModel modelS = new DefaultTableModel(colsSach, 0);
		pnlTableS.setLayout(null);
		JTable tableSach = new MyTable(modelS);
		JScrollPane scrSach = new JScrollPane(tableSach, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrSach.setLocation(29, 20);
		scrSach.setSize(1184, 233);
		pnlTableS.add(scrSach);

		// Tab văn phòng phẩm
		JPanel pnlVPP = new JPanel();
		pnlVPP.setBackground(new Color(240, 240, 240));
		pnlVPP.setBounds(0, 0, 1230, 800);
		pnlVPP.setLayout(null);

		// thông tin văn phòng phẩm
		JPanel pnlThongTin = new JPanel();
		pnlThongTin.setBackground(new Color(255, 255, 255));
		pnlThongTin.setBounds(20, 20, 1235, 255);
		pnlThongTin.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Th\u00F4ng Tin S\u1EA3n Ph\u1EA9m",
				TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		pnlVPP.add(pnlThongTin);
		pnlThongTin.setLayout(null);

		JLabel lblMaSP = new JLabel("Mã sản phẩm");
		lblMaSP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaSP.setBounds(25, 35, 90, 15);
		pnlThongTin.add(lblMaSP);

		JLabel lblTenSP = new JLabel("Tên sản phẩm");
		lblTenSP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenSP.setBounds(25, 77, 90, 15);
		pnlThongTin.add(lblTenSP);

		JLabel lblNCC_1 = new JLabel("Nhà cung cấp");
		lblNCC_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNCC_1.setBounds(25, 119, 90, 15);
		pnlThongTin.add(lblNCC_1);

		JLabel lblDanhMuc = new JLabel("Danh mục");
		lblDanhMuc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDanhMuc.setBounds(519, 119, 90, 15);
		pnlThongTin.add(lblDanhMuc);

		JLabel lblKe_1 = new JLabel("Kệ");
		lblKe_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKe_1.setBounds(25, 161, 90, 15);
		pnlThongTin.add(lblKe_1);

		btnTaoMaSP = new MyButton("Tạo mã");
		btnTaoMaSP.setForeground(new Color(255, 255, 255));
		btnTaoMaSP.setBounds(357, 32, 96, 21);
		pnlThongTin.add(btnTaoMaSP);

		txtMaSP = new JTextField();
		txtMaSP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMaSP.setEnabled(false);
		txtMaSP.setColumns(10);
		txtMaSP.setBounds(116, 30, 215, 25);
		pnlThongTin.add(txtMaSP);

		txtTenSP = new JTextField();
		txtTenSP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTenSP.setColumns(10);
		txtTenSP.setBounds(116, 72, 337, 25);
		pnlThongTin.add(txtTenSP);

		cboNhaCungCap = new MyCombobox();
		cboNhaCungCap.setBounds(116, 114, 337, 25);
		pnlThongTin.add(cboNhaCungCap);

		txtKe = new JTextField();
		txtKe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtKe.setBounds(116, 156, 337, 25);
		pnlThongTin.add(txtKe);
		txtKe.setColumns(10);

		JLabel lblSoLuong_1 = new JLabel("Số lượng");
		lblSoLuong_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSoLuong_1.setBounds(519, 35, 90, 15);
		pnlThongTin.add(lblSoLuong_1);

		JLabel lblGiaNhap_1 = new JLabel("Giá nhập");
		lblGiaNhap_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGiaNhap_1.setBounds(519, 77, 90, 15);
		pnlThongTin.add(lblGiaNhap_1);

		JLabel lblThue_1 = new JLabel("Thuế");
		lblThue_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThue_1.setBounds(761, 35, 68, 15);
		pnlThongTin.add(lblThue_1);

		JLabel lblLoiNhuan_1 = new JLabel("Lợi nhuận ");
		lblLoiNhuan_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLoiNhuan_1.setBounds(761, 77, 68, 15);
		pnlThongTin.add(lblLoiNhuan_1);

		JLabel lblTacGia_1 = new JLabel("Thể loại");
		lblTacGia_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTacGia_1.setBounds(519, 161, 90, 15);
		pnlThongTin.add(lblTacGia_1);

		JLabel lblChatLieu = new JLabel("Chất liệu");
		lblChatLieu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblChatLieu.setBounds(519, 203, 90, 15);
		pnlThongTin.add(lblChatLieu);

		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSoLuong.setBounds(609, 30, 120, 25);
		pnlThongTin.add(txtSoLuong);
		txtSoLuong.setColumns(10);

		txtGiaNhap = new JTextField();
		txtGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtGiaNhap.setBounds(609, 72, 120, 25);
		pnlThongTin.add(txtGiaNhap);
		txtGiaNhap.setColumns(10);

		txtThue = new JTextField();
		txtThue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtThue.setBounds(825, 30, 120, 25);
		pnlThongTin.add(txtThue);
		txtThue.setColumns(10);

		txtLoiNhuan = new JTextField();
		txtLoiNhuan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtLoiNhuan.setBounds(825, 72, 120, 25);
		pnlThongTin.add(txtLoiNhuan);
		txtLoiNhuan.setColumns(10);

		txtTheLoai = new JTextField();
		txtTheLoai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTheLoai.setBounds(609, 156, 336, 25);
		pnlThongTin.add(txtTheLoai);
		txtTheLoai.setColumns(10);

		txtChatLieu = new JTextField();
		txtChatLieu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtChatLieu.setBounds(609, 198, 337, 25);
		pnlThongTin.add(txtChatLieu);
		txtChatLieu.setColumns(10);

		JLabel lblPhanTramThue_1 = new JLabel("%");
		lblPhanTramThue_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhanTramThue_1.setBounds(956, 35, 30, 15);
		pnlThongTin.add(lblPhanTramThue_1);

		JLabel lblPhanTramLN_1 = new JLabel("%");
		lblPhanTramLN_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhanTramLN_1.setBounds(956, 77, 30, 15);
		pnlThongTin.add(lblPhanTramLN_1);

		cboDanhMuc = new MyCombobox();
		cboDanhMuc.setBounds(609, 114, 337, 25);
		pnlThongTin.add(cboDanhMuc);

		JPanel pnlHinhAnh_1 = new JPanel();
		pnlHinhAnh_1.setBackground(new Color(255, 255, 255));
		pnlHinhAnh_1.setBounds(1020, 30, 180, 180);
		pnlThongTin.add(pnlHinhAnh_1);
		pnlHinhAnh_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblHinhAnh = new JLabel();
		lblHinhAnh.setBounds(1046, 30, 135, 180);
		pnlHinhAnh_1.add(lblHinhAnh);
		// ImageIcon anhSP = new
		// ImageIcon("src/image/sanpham/tuoi-tre-dang-gia-bao-nhieu.png");
		// lblHinhAnh.setIcon(new
		// ImageIcon(GUISanPham.class.getResource("/image/sanpham/balo-nu.png")));

		btnHinhAnh = new MyButton("Chọn ảnh ");
		btnHinhAnh.setBounds(1067, 220, 100, 21);
		btnHinhAnh.setForeground(new Color(255, 255, 255));
		pnlThongTin.add(btnHinhAnh);

		JLabel lblTrangThai = new JLabel("Trạng thái");
		lblTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTrangThai.setBounds(25, 203, 90, 15);
		pnlThongTin.add(lblTrangThai);

		JCheckBox chkTrangThai = new JCheckBox("Đang bán");
		chkTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chkTrangThai.setBackground(new Color(255, 255, 255));
		chkTrangThai.setSelected(true);
		chkTrangThai.setBounds(116, 199, 93, 25);
		pnlThongTin.add(chkTrangThai);

		// tìm kiếm
		JPanel pnlTimKiem = new JPanel();
		pnlTimKiem.setBackground(new Color(255, 255, 255));
		pnlTimKiem.setBounds(20, 290, 910, 195);
		pnlTimKiem.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "T\u00ECm Ki\u1EBFm",
				TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, null));
		pnlVPP.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		txtTimTheoMa = new JTextField();
		txtTimTheoMa.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtTimTheoMa.setText("Nhập mã sản phẩm cần tìm");
		txtTimTheoMa.setForeground(new Color(128, 128, 128));
		txtTimTheoMa.setBounds(25, 30, 320, 19);
		pnlTimKiem.add(txtTimTheoMa);
		txtTimTheoMa.setColumns(10);

		JPanel pnlLoc;
		pnlLoc = new JPanel();
		pnlLoc.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "L\u1ECDc S\u1EA3n Ph\u1EA9m",
				TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		pnlLoc.setBackground(new Color(240, 240, 240));
		pnlLoc.setBounds(25, 66, 840, 110);
		pnlTimKiem.add(pnlLoc);
		pnlLoc.setLayout(null);

		lblLocNCC = new JLabel("Nhà cung cấp");
		lblLocNCC.setBounds(25, 29, 90, 13);
		pnlLoc.add(lblLocNCC);

		lblLocTheLoai = new JLabel("Thể loại");
		lblLocTheLoai.setBounds(450, 29, 70, 13);
		pnlLoc.add(lblLocTheLoai);

		JLabel lblLocDanhMuc = new JLabel("Danh mục");
		lblLocDanhMuc.setBounds(25, 67, 90, 13);
		pnlLoc.add(lblLocDanhMuc);

		txtLocTheLoai = new JTextField();
		txtLocTheLoai.setBounds(516, 25, 300, 19);
		pnlLoc.add(txtLocTheLoai);
		txtLocTheLoai.setColumns(10);

		cboLocNCC = new MyCombobox();
		cboLocNCC.setBounds(110, 25, 300, 21);
		pnlLoc.add(cboLocNCC);

		cboLocDanhMuc = new MyCombobox();
		cboLocDanhMuc.setBounds(110, 63, 300, 21);
		pnlLoc.add(cboLocDanhMuc);

		btnTimMa = new MyButton("Tìm");
		btnTimMa.setForeground(new Color(255, 255, 255));
		btnTimMa.setBounds(365, 29, 69, 21);
		pnlTimKiem.add(btnTimMa);

		JLabel lblLocTrangThai = new JLabel("Kiểm tra trạng thái");
		lblLocTrangThai.setBounds(538, 34, 104, 13);
		pnlTimKiem.add(lblLocTrangThai);

		JComboBox cboLocTrangThai = new JComboBox();
		cboLocTrangThai.setBounds(650, 30, 215, 21);
		pnlTimKiem.add(cboLocTrangThai);

		// dữ liệu mẫu
		cboLocTrangThai.addItem("Đang bán");
		cboLocTrangThai.addItem("Không còn bán");

		// chức năng
		JPanel pnlChucNang_1 = new JPanel();
		pnlChucNang_1.setBackground(new Color(255, 255, 255));
		pnlChucNang_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Ch\u1EE9c N\u0103ng",
				TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		pnlChucNang_1.setBounds(945, 290, 310, 195);
		pnlVPP.add(pnlChucNang_1);
		pnlChucNang_1.setLayout(null);

		btnThemSP = new MyButton("THÊM SẢN PHẨM");
		btnThemSP.setFont(new Font("Tahoma", Font.BOLD, 13));
		// btnThemSP.setBackground(new Color(36, 204, 86));
		// btnThemSP.setIcon(new
		// ImageIcon(GUISanPham.class.getResource("/image/sanpham/icons8-add-24.png")));
		btnThemSP.setForeground(new Color(255, 255, 255));
		btnThemSP.setText("Thêm");
		btnThemSP.setBounds(35, 48, 100, 30);
		pnlChucNang_1.add(btnThemSP);

		btnCapNhat = new MyButton("CẬP NHẬT ");
		// btnCapNhat.setIcon(new
		// ImageIcon(GUISanPham.class.getResource("/image/sanpham/icons8-update-24.png")));
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCapNhat.setBackground(new Color(158, 16, 205));
		btnCapNhat.setText("Cập nhật");
		btnCapNhat.setForeground(new Color(255, 255, 255));
		btnCapNhat.setBounds(175, 48, 100, 30);
		pnlChucNang_1.add(btnCapNhat);

		btnXoaTrang = new MyButton("XÓA TRẮNG");
		// btnXoaTrang.setIcon(new
		// ImageIcon(GUISanPham.class.getResource("/image/sanpham/icons8-clean-24.png")));
		btnXoaTrang.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoaTrang.setBackground(new Color(249, 101, 45));
		btnXoaTrang.setText("Xóa trắng");
		btnXoaTrang.setForeground(new Color(255, 255, 255));
		btnXoaTrang.setBounds(35, 106, 100, 30);
		pnlChucNang_1.add(btnXoaTrang);

		btnTaiLai = new MyButton("TẢI LẠI");
		// btnTaiLai.setIcon(new
		// ImageIcon(GUISanPham.class.getResource("/image/sanpham/icons8-reload-24.png")));
		btnTaiLai.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTaiLai.setText("Tải lại");
		btnTaiLai.setForeground(new Color(255, 255, 255));
		btnTaiLai.setBounds(175, 106, 100, 30);
		pnlChucNang_1.add(btnTaiLai);

		// tạo bảng vpp
		JPanel pnlTable = new JPanel();
		pnlTable.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Danh S\u00E1ch S\u1EA3n Ph\u1EA9m",
				TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		pnlTable.setBackground(new Color(255, 255, 255));
		pnlTable.setBounds(20, 500, 1235, 263);
		pnlVPP.add(pnlTable);

		String[] cols = { "Mã SP", "Tên sản phẩm", "Nhà cung cấp", "Danh mục", "Thể loại", "Chất liệu", "Kệ",
				"Số lượng", "Giá nhập" };
		DefaultTableModel model = new DefaultTableModel(cols, 0);
		pnlTable.setLayout(null);
		JTable table = new MyTable(model);
		JScrollPane scr = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scr.setLocation(29, 20);
		scr.setSize(1184, 233);
		pnlTable.add(scr);

		tabbedPane.addTab("Sách", pnlSach);
		tabbedPane.addTab("Văn phòng phẩm", pnlVPP);
		this.add(tabbedPane);
	}
}