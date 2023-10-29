package ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import CustomUI.MyButton;
import CustomUI.MyCombobox;
import CustomUI.MyTable;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;

public class GUIDoiTraHang extends JPanel {
	private JTextField txtTimKiemHoaDon;
	/**
	 * 
	 */
	private DefaultTableModel modelDanhSachHoaDon;
	private JTable tbDanhSachHoaDon;
	private JScrollPane srcDanhSachHoaDon;
	private DefaultTableModel modelDanhSachSanPham;
	private MyTable tbDanhSachSanPham;
	private JTextField txtMaDonDoiTra;
	private JTextField txtDiemHoanTra;
	private JTextField txtCTKM;
	private DefaultTableModel modelDonDoiTra;
	private MyTable tbDonDoiTra;
	private JTextField txtTongSoLuongDoi;
	private JTextField txtTongTienTra;
	private JTextField txtMaDonDoiTraQL;
	private JTextField txtTenNhanVienQL;
	private JTextField txtPhuongThucQL;
	private JTextField txtCTKMQL;
	private JTextField txtTongTienTraQL;
	private JTextField txtNgayLapQL;
	private JTextField txtTenKhachHangQL;
	private JTextField txtDiemHoanTraQL;
	private JTextField txtTongSoLuongDoiQL;
	private DefaultTableModel modelSanPhamQL;
	private MyTable tbSanPhamQL;
	private JTextField txtMaDonDoiTraTimKiemQL;
	private JTextField txtSDTTimKiemQL;
	private JTextField txtTenNhanVienTimKiemQL;
	private DefaultTableModel modelDonDoiTraQL;
	private MyTable tbDonDoiTraQL;
	private JTextField txtMaHoaDonQLDDT;
	public GUIDoiTraHang() {
		this.setBackground(new Color(255, 255, 255));
		this.setBounds(250, 0, 1250, 800);
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1230, 760);
		add(tabbedPane);
		
		JPanel pnlDonDoiTra = new JPanel();
		pnlDonDoiTra.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane.addTab("Đơn Đổi Trả", null, pnlDonDoiTra, null);
		tabbedPane.setForegroundAt(0, new Color(255, 255, 255));
		tabbedPane.setBackgroundAt(0, new Color(97, 166, 247));
		pnlDonDoiTra.setLayout(null);
		
		JPanel pnlThongTinHoaDon = new JPanel();
		pnlThongTinHoaDon.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlThongTinHoaDon.setLayout(null);
		pnlThongTinHoaDon.setBackground(Color.WHITE);
		pnlThongTinHoaDon.setBounds(27, 28, 542, 160);
		pnlDonDoiTra.add(pnlThongTinHoaDon);
		
		JLabel lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenKhachHang.setBounds(27, 34, 137, 20);
		pnlThongTinHoaDon.add(lblTenKhachHang);
		
		JLabel lblTenKhachHangv = new JLabel("Huỳnh Quốc Bảo");
		lblTenKhachHangv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenKhachHangv.setBounds(155, 34, 154, 20);
		pnlThongTinHoaDon.add(lblTenKhachHangv);
		
		JLabel lblMaHoaDon = new JLabel("Mã hóa đơn:");
		lblMaHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaHoaDon.setBounds(27, 80, 104, 20);
		pnlThongTinHoaDon.add(lblMaHoaDon);
		
		JLabel lblMaHoaDonv = new JLabel("HD12");
		lblMaHoaDonv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaHoaDonv.setBounds(155, 80, 74, 20);
		pnlThongTinHoaDon.add(lblMaHoaDonv);
		
		JLabel lblNgayLapHoaDon = new JLabel("Ngày lập:");
		lblNgayLapHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgayLapHoaDon.setBounds(319, 80, 85, 20);
		pnlThongTinHoaDon.add(lblNgayLapHoaDon);
		
		JLabel lblNgayLapHoaDonv = new JLabel("12/12/2023");
		lblNgayLapHoaDonv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgayLapHoaDonv.setBounds(421, 80, 104, 20);
		pnlThongTinHoaDon.add(lblNgayLapHoaDonv);
		
		MyButton btnXemChiTietHoaDon = new MyButton("Xem chi tiết");
		btnXemChiTietHoaDon.setForeground(new Color(255, 255, 255));
		btnXemChiTietHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXemChiTietHoaDon.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnXemChiTietHoaDon.setBounds(197, 120, 120, 23);
		pnlThongTinHoaDon.add(btnXemChiTietHoaDon);
		
		JLabel lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSDT.setBounds(319, 34, 100, 20);
		pnlThongTinHoaDon.add(lblSDT);
		
		JLabel lblSDTv = new JLabel("0914653334");
		lblSDTv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSDTv.setBounds(421, 34, 100, 20);
		pnlThongTinHoaDon.add(lblSDTv);
		
		JPanel pnlTimKiemHoaDon = new JPanel();
		pnlTimKiemHoaDon.setBackground(new Color(255, 255, 255));
		pnlTimKiemHoaDon.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlTimKiemHoaDon.setBounds(27, 212, 542, 80);
		pnlDonDoiTra.add(pnlTimKiemHoaDon);
		pnlTimKiemHoaDon.setLayout(null);
		
		JLabel lblTimKiemHoaDon = new JLabel("Tìm kiếm hóa đơn");
		lblTimKiemHoaDon.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTimKiemHoaDon.setBackground(new Color(255, 255, 255));
		lblTimKiemHoaDon.setBounds(52, 11, 150, 20);
		pnlTimKiemHoaDon.add(lblTimKiemHoaDon);
		
		txtTimKiemHoaDon = new JTextField();
		txtTimKiemHoaDon.setText("Nhập số điện thoại khách hàng");
		txtTimKiemHoaDon.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		txtTimKiemHoaDon.setToolTipText("");
		txtTimKiemHoaDon.setBounds(52, 36, 320, 24);
		pnlTimKiemHoaDon.add(txtTimKiemHoaDon);
		txtTimKiemHoaDon.setColumns(10);
		txtTimKiemHoaDon.setForeground(Color.GRAY);
		txtTimKiemHoaDon.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 102, 102), null, null, null));
		JButton btnTimKiemKhachHang = new MyButton("Tìm kiếm");
		btnTimKiemKhachHang.setForeground(new Color(255, 255, 255));
		btnTimKiemKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnTimKiemKhachHang.setBounds(387, 36, 117, 24);
		pnlTimKiemHoaDon.add(btnTimKiemKhachHang);
		txtTimKiemHoaDon.addFocusListener(new java.awt.event.FocusAdapter() {
            // Xóa placeholder khi trường JTextField được tương tác
            public void focusGained(java.awt.event.FocusEvent evt) {
            	if (txtTimKiemHoaDon.getText().equals("Nhập số điện thoại khách hàng")) {
                	txtTimKiemHoaDon.setText("");
                	txtTimKiemHoaDon.setForeground(Color.BLACK);
                }
            }
            // Thêm placeholder nếu trường JTextField không có dữ liệu
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtTimKiemHoaDon.getText().isEmpty()) {
                	txtTimKiemHoaDon.setForeground(Color.GRAY);
                	txtTimKiemHoaDon.setText("Nhập số điện thoại khách hàng");
                }
            }
        });

		
		JPanel pnlDanhSachHoaDon = new JPanel();
		pnlDanhSachHoaDon.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlDanhSachHoaDon.setBackground(new Color(255, 255, 255));
		pnlDanhSachHoaDon.setBounds(27, 316, 542, 392);
		pnlDonDoiTra.add(pnlDanhSachHoaDon);
		pnlDanhSachHoaDon.setLayout(null);
		
		JLabel lblDanhSachHoaDon = new JLabel("Danh sách hóa đơn trong 7 ngày gần nhất");
		lblDanhSachHoaDon.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDanhSachHoaDon.setBounds(55, 11, 334, 18);
		pnlDanhSachHoaDon.add(lblDanhSachHoaDon);
		
		
		modelDanhSachHoaDon = new DefaultTableModel(
				new Object[] {"Mã hóa đơn","Ngày lập","Nhân viên","Số lượng SP","Tổng tiền" }, 0);
		
		modelDanhSachHoaDon.addRow(new Object[] {"HD12","12/12/2023","Huỳnh Quốc Bảo","12","800.000"});
		modelDanhSachHoaDon.addRow(new Object[] {"HD12","12/12/2023","Huỳnh Quốc Bảo","12","800.000"});
		modelDanhSachHoaDon.addRow(new Object[] {"HD12","12/12/2023","Huỳnh Quốc Bảo","12","800.000"});
		modelDanhSachHoaDon.addRow(new Object[] {"HD12","12/12/2023","Huỳnh Quốc Bảo","12","800.000"});
		modelDanhSachHoaDon.addRow(new Object[] {"HD12","12/12/2023","Huỳnh Quốc Bảo","12","800.000"});
		modelDanhSachHoaDon.addRow(new Object[] {"HD12","12/12/2023","Huỳnh Quốc Bảo","12","800.000"});
		modelDanhSachHoaDon.addRow(new Object[] {"HD12","12/12/2023","Huỳnh Quốc Bảo","12","800.000"});
		modelDanhSachHoaDon.addRow(new Object[] {"HD12","12/12/2023","Huỳnh Quốc Bảo","12","800.000"});
		
		tbDanhSachHoaDon = new MyTable(modelDanhSachHoaDon);		
		tbDanhSachHoaDon.getColumnModel().getColumn(2).setPreferredWidth(120);
		srcDanhSachHoaDon = new JScrollPane(tbDanhSachHoaDon,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		srcDanhSachHoaDon.setBounds(20, 40, 500, 341);
		
		pnlDanhSachHoaDon.add(srcDanhSachHoaDon);
		
		JPanel pnlSanPhamTrongHoaDon = new JPanel();
		pnlSanPhamTrongHoaDon.setBackground(new Color(255, 255, 255));
		pnlSanPhamTrongHoaDon.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlSanPhamTrongHoaDon.setBounds(592, 28, 611, 332);
		pnlDonDoiTra.add(pnlSanPhamTrongHoaDon);
		pnlSanPhamTrongHoaDon.setLayout(null);
		
		JLabel lblDanhSachSanPham = new JLabel("Danh sách sản phẩm trong hóa đơn");
		lblDanhSachSanPham.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDanhSachSanPham.setBounds(24, 11, 250, 17);
		pnlSanPhamTrongHoaDon.add(lblDanhSachSanPham);
		
		modelDanhSachSanPham = new DefaultTableModel(
				new Object[] {"Mã sản phẩm","Tên sản phẩm","Số lượng","Giá bán"}, 0);
		
		modelDanhSachSanPham.addRow(new Object[] {"SP112","Sách Công Dân","2","100.000"});
		modelDanhSachSanPham.addRow(new Object[] {"SP112","Sách Công Dân","2","100.000"});
		modelDanhSachSanPham.addRow(new Object[] {"SP112","Sách Công Dân","2","100.000"});
		modelDanhSachSanPham.addRow(new Object[] {"SP112","Sách Công Dân","2","100.000"});
		modelDanhSachSanPham.addRow(new Object[] {"SP112","Sách Công Dân","2","100.000"});
		modelDanhSachSanPham.addRow(new Object[] {"SP112","Sách Công Dân","2","100.000"});
		modelDanhSachSanPham.addRow(new Object[] {"SP112","Sách Công Dân","2","100.000"});
		modelDanhSachSanPham.addRow(new Object[] {"SP112","Sách Công Dân","2","100.000"});
		modelDanhSachSanPham.addRow(new Object[] {"SP112","Sách Công Dân","2","100.000"});
		modelDanhSachSanPham.addRow(new Object[] {"SP112","Sách Công Dân","2","100.000"});

		
		tbDanhSachSanPham = new MyTable(modelDanhSachSanPham);	

		
		JScrollPane srcDanhSachSanPham = new JScrollPane(tbDanhSachSanPham,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		srcDanhSachSanPham.setBounds(20, 35, 576, 240);
		pnlSanPhamTrongHoaDon.add(srcDanhSachSanPham);
		
		JComboBox cbPhuongThucDoiTra = new MyCombobox();
		cbPhuongThucDoiTra.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbPhuongThucDoiTra.setModel(new DefaultComboBoxModel(new String[] {"Đổi Hàng", "Trả Tiền"}));
		cbPhuongThucDoiTra.setSelectedIndex(1);
		cbPhuongThucDoiTra.setBounds(44, 294, 230, 22);
		pnlSanPhamTrongHoaDon.add(cbPhuongThucDoiTra);
		
		JButton btnTaoDonDoiTtra = new MyButton("Tạo đơn");
		btnTaoDonDoiTtra.setForeground(new Color(255, 255, 255));
		btnTaoDonDoiTtra.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnTaoDonDoiTtra.setBounds(307, 294, 120, 23);
		pnlSanPhamTrongHoaDon.add(btnTaoDonDoiTtra);
		
		JButton btnThemSanPham = new MyButton("Xóa");
		btnThemSanPham.setText("Thêm");
		btnThemSanPham.setForeground(new Color(255, 255, 255));
		btnThemSanPham.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnThemSanPham.setBounds(458, 294, 120, 23);
		pnlSanPhamTrongHoaDon.add(btnThemSanPham);
		
		JPanel pnlThongTinDonDoiTra = new JPanel();
		pnlThongTinDonDoiTra.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlThongTinDonDoiTra.setBackground(new Color(255, 255, 255));
		pnlThongTinDonDoiTra.setBounds(592, 384, 611, 324);
		pnlDonDoiTra.add(pnlThongTinDonDoiTra);
		pnlThongTinDonDoiTra.setLayout(null);
		
		JLabel lblMaDonDoiTra = new JLabel("Mã đơn đổi trả");
		lblMaDonDoiTra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaDonDoiTra.setBounds(39, 11, 100, 20);
		pnlThongTinDonDoiTra.add(lblMaDonDoiTra);
		
		txtMaDonDoiTra = new JTextField();
		txtMaDonDoiTra.setEnabled(false);
		txtMaDonDoiTra.setText("HD12");
		txtMaDonDoiTra.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtMaDonDoiTra.setBounds(149, 11, 141, 20);
		txtMaDonDoiTra.setDisabledTextColor(Color.black);
		pnlThongTinDonDoiTra.add(txtMaDonDoiTra);
		txtMaDonDoiTra.setColumns(10);
		
		JLabel lblDiemHoanTra = new JLabel("Điểm hoàn trả");
		lblDiemHoanTra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiemHoanTra.setBounds(380, 11, 100, 20);
		pnlThongTinDonDoiTra.add(lblDiemHoanTra);
		
		txtDiemHoanTra = new JTextField();
		txtDiemHoanTra.setEnabled(false);
		txtDiemHoanTra.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtDiemHoanTra.setDisabledTextColor(Color.black);
		txtDiemHoanTra.setBounds(477, 11, 96, 20);
		pnlThongTinDonDoiTra.add(txtDiemHoanTra);
		txtDiemHoanTra.setColumns(10);
		
		JLabel lblCTKM = new JLabel("Chương trình khuyến mãi:");
		lblCTKM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCTKM.setBounds(39, 46, 172, 20);
		pnlThongTinDonDoiTra.add(lblCTKM);
		
		txtCTKM = new JTextField();
		txtCTKM.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtCTKM.setEnabled(false);
		txtCTKM.setBounds(208, 46, 226, 20);
		txtCTKM.setDisabledTextColor(Color.black);
		pnlThongTinDonDoiTra.add(txtCTKM);
		txtCTKM.setColumns(10);
		
		modelDonDoiTra = new DefaultTableModel(
				new Object[] {"Mã sản phẩm","Tên sản phẩm","Số lượng","Giá bán","Lý do"}, 0);
		
		modelDonDoiTra.addRow(new Object[] {"SP112","Sách Công Dân","2","100.000","Mực mờ"});
		modelDonDoiTra.addRow(new Object[] {"SP112","Sách Công Dân","2","100.000","Mực mờ"});
		modelDonDoiTra.addRow(new Object[] {"SP112","Sách Công Dân","2","100.000","Mực mờ"});
		modelDonDoiTra.addRow(new Object[] {"SP112","Sách Công Dân","2","100.000","Mực mờ"});
		modelDonDoiTra.addRow(new Object[] {"SP112","Sách Công Dân","2","100.000","Mực mờ"});
		modelDonDoiTra.addRow(new Object[] {"SP112","Sách Công Dân","2","100.000","Mực mờ"});

		tbDonDoiTra = new MyTable(modelDonDoiTra);	
		
		JScrollPane srcDonDoiTra = new JScrollPane(tbDonDoiTra,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		srcDonDoiTra.setBounds(15, 80, 580, 138);
		pnlThongTinDonDoiTra.add(srcDonDoiTra);
		
		JLabel lblTongSoLuongDoi = new JLabel("Tổng số lượng sản phẩm đổi hàng:");
		lblTongSoLuongDoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTongSoLuongDoi.setBounds(30, 244, 220, 20);
		pnlThongTinDonDoiTra.add(lblTongSoLuongDoi);
		
		txtTongSoLuongDoi = new JTextField();
		txtTongSoLuongDoi.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTongSoLuongDoi.setEnabled(false);
		txtTongSoLuongDoi.setBounds(259, 245, 135, 20);
		txtTongSoLuongDoi.setDisabledTextColor(Color.black);
		pnlThongTinDonDoiTra.add(txtTongSoLuongDoi);
		txtTongSoLuongDoi.setColumns(10);
		
		JLabel lblTongTienTra = new JLabel("Tổng tiền phải trả:");
		lblTongTienTra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTongTienTra.setBounds(30, 274, 150, 20);
		pnlThongTinDonDoiTra.add(lblTongTienTra);
		
		txtTongTienTra = new JTextField();
		txtTongTienTra.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtTongTienTra.setForeground(new Color(255, 0, 0));
		txtTongTienTra.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTongTienTra.setEnabled(false);
		txtTongTienTra.setText("1.000.000");
		txtTongTienTra.setColumns(10);
		txtTongTienTra.setBounds(259, 275, 135, 20);
		txtTongTienTra.setDisabledTextColor(Color.red);
		pnlThongTinDonDoiTra.add(txtTongTienTra);
		
		JButton btnHoanThanhDon = new MyButton("Hoàn thành đơn");
		btnHoanThanhDon.setForeground(new Color(255, 255, 255));
		btnHoanThanhDon.setBackground(new Color(87, 255, 130));
		btnHoanThanhDon.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnHoanThanhDon.setBounds(434, 244, 139, 23);
		pnlThongTinDonDoiTra.add(btnHoanThanhDon);
		
		JButton btnHuy = new MyButton("Hủy đơn");
		btnHuy.setForeground(new Color(255, 255, 255));
		btnHuy.setBackground(new Color(255, 83, 83));
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnHuy.setBounds(434, 274, 139, 23);
		pnlThongTinDonDoiTra.add(btnHuy);
		
		MyButton btnXoaSanPham = new MyButton("Xóa");
		btnXoaSanPham.setForeground(Color.WHITE);
		btnXoaSanPham.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnXoaSanPham.setBounds(453, 43, 120, 23);
		pnlThongTinDonDoiTra.add(btnXoaSanPham);
		
		JPanel pnlQuanLyDonDoiTra = new JPanel();
		pnlQuanLyDonDoiTra.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane.addTab("Quản Lý Đơn Đổi Trả", null, pnlQuanLyDonDoiTra, null);
		tabbedPane.setForegroundAt(1, new Color(255, 255, 255));
		tabbedPane.setBackgroundAt(1, new Color(97, 166, 247));
		pnlQuanLyDonDoiTra.setLayout(null);
		
		JPanel pnlThongTinDonDoiTraQL = new JPanel();
		pnlThongTinDonDoiTraQL.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlThongTinDonDoiTraQL.setBackground(new Color(255, 255, 255));
		pnlThongTinDonDoiTraQL.setBounds(23, 25, 1172, 226);
		pnlQuanLyDonDoiTra.add(pnlThongTinDonDoiTraQL);
		pnlThongTinDonDoiTraQL.setLayout(null);
		
		JLabel lblMaDonDoiTraQL = new JLabel("Mã đơn đổi trả:");
		lblMaDonDoiTraQL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaDonDoiTraQL.setBounds(114, 21, 150, 20);
		pnlThongTinDonDoiTraQL.add(lblMaDonDoiTraQL);
		
		JLabel lblTenNhanVienQL = new JLabel("Tên nhân viên:");
		lblTenNhanVienQL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenNhanVienQL.setBounds(114, 56, 150, 20);
		pnlThongTinDonDoiTraQL.add(lblTenNhanVienQL);
		
		JLabel lblPhuongThucQL = new JLabel("Phương thức đổi trả:");
		lblPhuongThucQL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhuongThucQL.setBounds(114, 91, 150, 20);
		pnlThongTinDonDoiTraQL.add(lblPhuongThucQL);
		
		JLabel lblCTKMQL = new JLabel("Chương trình khuyến mãi:");
		lblCTKMQL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCTKMQL.setBounds(114, 126, 179, 20);
		pnlThongTinDonDoiTraQL.add(lblCTKMQL);
		
		JLabel lblTongTienTraQL = new JLabel("Tổng tiền phải trả:");
		lblTongTienTraQL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTongTienTraQL.setBounds(114, 161, 150, 20);
		pnlThongTinDonDoiTraQL.add(lblTongTienTraQL);
		
		txtMaDonDoiTraQL = new JTextField();
		txtMaDonDoiTraQL.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtMaDonDoiTraQL.setEnabled(false);
		txtMaDonDoiTraQL.setBounds(292, 21, 179, 20);
		txtMaDonDoiTraQL.setDisabledTextColor(Color.black);
		pnlThongTinDonDoiTraQL.add(txtMaDonDoiTraQL);
		txtMaDonDoiTraQL.setColumns(10);
		
		txtTenNhanVienQL = new JTextField();
		txtTenNhanVienQL.setEnabled(false);
		txtTenNhanVienQL.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTenNhanVienQL.setColumns(10);
		txtTenNhanVienQL.setDisabledTextColor(Color.black);
		txtTenNhanVienQL.setBounds(292, 56, 179, 20);
		pnlThongTinDonDoiTraQL.add(txtTenNhanVienQL);
		
		txtPhuongThucQL = new JTextField();
		txtPhuongThucQL.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtPhuongThucQL.setEnabled(false);
		txtPhuongThucQL.setColumns(10);
		txtPhuongThucQL.setBounds(292, 91, 179, 20);
		txtPhuongThucQL.setDisabledTextColor(Color.black);
		pnlThongTinDonDoiTraQL.add(txtPhuongThucQL);
		
		txtCTKMQL = new JTextField();
		txtCTKMQL.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtCTKMQL.setEnabled(false);
		txtCTKMQL.setColumns(10);
		txtCTKMQL.setDisabledTextColor(Color.black);
		txtCTKMQL.setBounds(292, 126, 269, 20);
		pnlThongTinDonDoiTraQL.add(txtCTKMQL);
		
		txtTongTienTraQL = new JTextField();
		txtTongTienTraQL.setEnabled(false);
		txtTongTienTraQL.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTongTienTraQL.setColumns(10);
		txtTongTienTraQL.setBounds(292, 161, 179, 20);
		txtTongTienTraQL.setDisabledTextColor(Color.black);
		pnlThongTinDonDoiTraQL.add(txtTongTienTraQL);
		
		JLabel lblNgayLap = new JLabel("Ngày lập:");
		lblNgayLap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgayLap.setBounds(708, 56, 150, 20);
		pnlThongTinDonDoiTraQL.add(lblNgayLap);
		
		JLabel lblTenKhachHangQL = new JLabel("Tên khách hàng");
		lblTenKhachHangQL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenKhachHangQL.setBounds(708, 91, 150, 20);
		pnlThongTinDonDoiTraQL.add(lblTenKhachHangQL);
		
		JLabel lblDiemHoanTraQL = new JLabel("Điểm hoàn trả:");
		lblDiemHoanTraQL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiemHoanTraQL.setBounds(708, 126, 150, 20);
		pnlThongTinDonDoiTraQL.add(lblDiemHoanTraQL);
		
		JLabel lblTongSoLuongDoiQL = new JLabel("Tổng số lượng đổi:");
		lblTongSoLuongDoiQL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTongSoLuongDoiQL.setBounds(708, 161, 150, 20);
		pnlThongTinDonDoiTraQL.add(lblTongSoLuongDoiQL);
		
		txtNgayLapQL = new JTextField();
		txtNgayLapQL.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtNgayLapQL.setEnabled(false);
		txtNgayLapQL.setColumns(10);
		txtNgayLapQL.setBounds(868, 56, 179, 20);
		txtNgayLapQL.setDisabledTextColor(Color.black);
		pnlThongTinDonDoiTraQL.add(txtNgayLapQL);
		
		txtTenKhachHangQL = new JTextField();
		txtTenKhachHangQL.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTenKhachHangQL.setEnabled(false);
		txtTenKhachHangQL.setColumns(10);
		txtTenKhachHangQL.setBounds(868, 91, 179, 20);
		txtTenKhachHangQL.setDisabledTextColor(Color.black);
		pnlThongTinDonDoiTraQL.add(txtTenKhachHangQL);
		
		txtDiemHoanTraQL = new JTextField();
		txtDiemHoanTraQL.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtDiemHoanTraQL.setEnabled(false);
		txtDiemHoanTraQL.setColumns(10);
		txtDiemHoanTraQL.setBounds(868, 126, 179, 20);
		txtDiemHoanTraQL.setDisabledTextColor(Color.black);
		pnlThongTinDonDoiTraQL.add(txtDiemHoanTraQL);
		
		txtTongSoLuongDoiQL = new JTextField();
		txtTongSoLuongDoiQL.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTongSoLuongDoiQL.setEnabled(false);
		txtTongSoLuongDoiQL.setColumns(10);
		txtTongSoLuongDoiQL.setBounds(868, 161, 179, 20);
		txtTongSoLuongDoiQL.setDisabledTextColor(Color.black);
		pnlThongTinDonDoiTraQL.add(txtTongSoLuongDoiQL);
		
		JButton btnXoaTrangQL = new MyButton("Xóa trắng");
		btnXoaTrangQL.setForeground(new Color(255, 255, 255));
		btnXoaTrangQL.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnXoaTrangQL.setBounds(513, 192, 150, 25);
		pnlThongTinDonDoiTraQL.add(btnXoaTrangQL);
		
		JLabel lblMaHoaDonQLDDT = new JLabel("Mã hóa đơn:");
		lblMaHoaDonQLDDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaHoaDonQLDDT.setBounds(708, 21, 150, 20);
		pnlThongTinDonDoiTraQL.add(lblMaHoaDonQLDDT);
		
		txtMaHoaDonQLDDT = new JTextField();
		txtMaHoaDonQLDDT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtMaHoaDonQLDDT.setEnabled(false);
		txtMaHoaDonQLDDT.setColumns(10);
		txtMaHoaDonQLDDT.setBounds(868, 21, 179, 20);
		txtMaHoaDonQLDDT.setDisabledTextColor(Color.black);
		pnlThongTinDonDoiTraQL.add(txtMaHoaDonQLDDT);
		
		JPanel pnlDanhSachSanPhamQL = new JPanel();
		pnlDanhSachSanPhamQL.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlDanhSachSanPhamQL.setBackground(new Color(255, 255, 255));
		pnlDanhSachSanPhamQL.setBounds(23, 267, 609, 180);
		pnlQuanLyDonDoiTra.add(pnlDanhSachSanPhamQL);
		pnlDanhSachSanPhamQL.setLayout(null);
		
		JLabel lblDanhSachSanPhamQL = new JLabel("Danh sách sản phẩm trong đơn đổi trả");
		lblDanhSachSanPhamQL.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDanhSachSanPhamQL.setBounds(20, 11, 277, 18);
		pnlDanhSachSanPhamQL.add(lblDanhSachSanPhamQL);
		
		modelSanPhamQL = new DefaultTableModel(
				new Object[] {"Mã sản phẩm","Tên sản phẩm","Số lượng","Giá bán","Lý do"}, 0);
		
		modelSanPhamQL.addRow(new Object[] {"SP112","Sách Công Dân","2","100.000","Mực mờ"});
		modelSanPhamQL.addRow(new Object[] {"SP112","Sách Công Dân","2","100.000","Mực mờ"});
		modelSanPhamQL.addRow(new Object[] {"SP112","Sách Công Dân","2","100.000","Mực mờ"});
		modelSanPhamQL.addRow(new Object[] {"SP112","Sách Công Dân","2","100.000","Mực mờ"});
		modelSanPhamQL.addRow(new Object[] {"SP112","Sách Công Dân","2","100.000","Mực mờ"});
		modelSanPhamQL.addRow(new Object[] {"SP112","Sách Công Dân","2","100.000","Mực mờ"});

		tbSanPhamQL = new MyTable(modelSanPhamQL);	
		
		JScrollPane scrDanhSachSanPhamQL = new JScrollPane(tbSanPhamQL, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrDanhSachSanPhamQL.setBounds(31, 40, 559, 129);
		pnlDanhSachSanPhamQL.add(scrDanhSachSanPhamQL);
		
		JPanel pnlTimKiemDonDoiTraQL = new JPanel();
		pnlTimKiemDonDoiTraQL.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlTimKiemDonDoiTraQL.setBackground(new Color(255, 255, 255));
		pnlTimKiemDonDoiTraQL.setBounds(658, 267, 538, 180);
		pnlQuanLyDonDoiTra.add(pnlTimKiemDonDoiTraQL);
		pnlTimKiemDonDoiTraQL.setLayout(null);
		
		JLabel lblTimKiemQL = new JLabel("Tim kiếm đơn đổi trả");
		lblTimKiemQL.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTimKiemQL.setBounds(20, 11, 150, 18);
		pnlTimKiemDonDoiTraQL.add(lblTimKiemQL);
		
		JLabel lblMaDonDoiTraTimKiemQL = new JLabel("Mã đơn đổi trả:");
		lblMaDonDoiTraTimKiemQL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaDonDoiTraTimKiemQL.setBounds(89, 42, 100, 20);
		pnlTimKiemDonDoiTraQL.add(lblMaDonDoiTraTimKiemQL);
		
		JLabel lblSDTTimkiemQL = new JLabel("Số điện thoại:");
		lblSDTTimkiemQL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSDTTimkiemQL.setBounds(89, 72, 100, 20);
		pnlTimKiemDonDoiTraQL.add(lblSDTTimkiemQL);
		
		JLabel lblTenNhanVienTimKiemQL = new JLabel("Tên nhân viên:");
		lblTenNhanVienTimKiemQL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenNhanVienTimKiemQL.setBounds(89, 102, 100, 20);
		pnlTimKiemDonDoiTraQL.add(lblTenNhanVienTimKiemQL);
		
		txtMaDonDoiTraTimKiemQL = new JTextField();
		txtMaDonDoiTraTimKiemQL.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtMaDonDoiTraTimKiemQL.setBounds(242, 41, 213, 20);
		pnlTimKiemDonDoiTraQL.add(txtMaDonDoiTraTimKiemQL);
		txtMaDonDoiTraTimKiemQL.setColumns(10);
		
		txtSDTTimKiemQL = new JTextField();
		txtSDTTimKiemQL.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtSDTTimKiemQL.setColumns(10);
		txtSDTTimKiemQL.setBounds(242, 71, 213, 20);
		pnlTimKiemDonDoiTraQL.add(txtSDTTimKiemQL);
		
		txtTenNhanVienTimKiemQL = new JTextField();
		txtTenNhanVienTimKiemQL.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTenNhanVienTimKiemQL.setColumns(10);
		txtTenNhanVienTimKiemQL.setBounds(242, 101, 213, 20);
		pnlTimKiemDonDoiTraQL.add(txtTenNhanVienTimKiemQL);
		
		JButton btnTaiLai = new MyButton("Tải lại");
		btnTaiLai.setForeground(new Color(255, 255, 255));
		btnTaiLai.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnTaiLai.setBounds(201, 144, 130, 27);
		pnlTimKiemDonDoiTraQL.add(btnTaiLai);
		
		JPanel pnlDanhSachDonDoiTraQL = new JPanel();
		pnlDanhSachDonDoiTraQL.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlDanhSachDonDoiTraQL.setBackground(new Color(255, 255, 255));
		pnlDanhSachDonDoiTraQL.setBounds(23, 462, 1172, 250);
		pnlQuanLyDonDoiTra.add(pnlDanhSachDonDoiTraQL);
		pnlDanhSachDonDoiTraQL.setLayout(null);
		
		JLabel lblDanhSachDonDoiTraQL = new JLabel("Danh sách đơn đổi trả");
		lblDanhSachDonDoiTraQL.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDanhSachDonDoiTraQL.setBounds(20, 15, 200, 20);
		pnlDanhSachDonDoiTraQL.add(lblDanhSachDonDoiTraQL);
		
		modelDonDoiTraQL = new DefaultTableModel(
				new Object[] {"Mã đơn đổi trả","Mã hóa đơn","Tên nhân viên","Tên khách hàng","Ngày lập","Tổng số lượng SP"}, 0);
		
		modelDonDoiTraQL.addRow(new Object[] {"DDT12","HD12","Huỳnh Quốc Bảo","Võ Mạnh Hiếu","12/12/2021","12"});
		modelDonDoiTraQL.addRow(new Object[] {"DDT12","HD12","Huỳnh Quốc Bảo","Võ Mạnh Hiếu","12/12/2021","12"});
		modelDonDoiTraQL.addRow(new Object[] {"DDT12","HD12","Huỳnh Quốc Bảo","Võ Mạnh Hiếu","12/12/2021","12"});
		modelDonDoiTraQL.addRow(new Object[] {"DDT12","HD12","Huỳnh Quốc Bảo","Võ Mạnh Hiếu","12/12/2021","12"});
		modelDonDoiTraQL.addRow(new Object[] {"DDT12","HD12","Huỳnh Quốc Bảo","Võ Mạnh Hiếu","12/12/2021","12"});
		modelDonDoiTraQL.addRow(new Object[] {"DDT12","HD12","Huỳnh Quốc Bảo","Võ Mạnh Hiếu","12/12/2021","12"});
		modelDonDoiTraQL.addRow(new Object[] {"DDT12","HD12","Huỳnh Quốc Bảo","Võ Mạnh Hiếu","12/12/2021","12"});
		modelDonDoiTraQL.addRow(new Object[] {"DDT12","HD12","Huỳnh Quốc Bảo","Võ Mạnh Hiếu","12/12/2021","12"});
		modelDonDoiTraQL.addRow(new Object[] {"DDT12","HD12","Huỳnh Quốc Bảo","Võ Mạnh Hiếu","12/12/2021","12"});
		modelDonDoiTraQL.addRow(new Object[] {"DDT12","HD12","Huỳnh Quốc Bảo","Võ Mạnh Hiếu","12/12/2021","12"});
		modelDonDoiTraQL.addRow(new Object[] {"DDT12","HD12","Huỳnh Quốc Bảo","Võ Mạnh Hiếu","12/12/2021","12"});
		
		tbDonDoiTraQL = new MyTable(modelDonDoiTraQL);	
		
		JScrollPane srcDanhSachDonDoiTraQL = new JScrollPane(tbDonDoiTraQL, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		srcDanhSachDonDoiTraQL.setBounds(30, 41, 1121, 198);
		pnlDanhSachDonDoiTraQL.add(srcDanhSachDonDoiTraQL);

	}
}