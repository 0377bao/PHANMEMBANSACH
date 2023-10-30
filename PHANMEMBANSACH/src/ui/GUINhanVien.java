package ui;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import customUI.MyButton;
import customUI.MyCombobox;
import customUI.MyTable;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class GUINhanVien extends JPanel implements ActionListener, FocusListener, MouseListener {
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtSdt;
	private JTextField txtCCCD;
	private JTextField txtEmail;
	private JTextField txtDiaChi;
	private JRadioButton radNam;
	private JRadioButton radNu;
	private MyCombobox cboChucVu;
	private MyButton btnHinhAnh;
	private MyButton btnTaoMa;
	private JTextField txtTimNV;
	private JButton btnLocGioiTinh;
	private JButton btnLocChucVu;
	private JButton btnThemNV;
	private JButton btnCapNhatNV;
	private JButton btnXoaTrang;
	private JButton btnTaiLai;
	private DefaultTableModel model;
	private MyTable table;
	private JScrollPane scr;
	private JTextField txtTenTK;
	private JTextField txtMatKhau;
	private MyButton btnTaoTK;

	public GUINhanVien() {
		this.setBackground(new Color(255, 255, 255));
		this.setBounds(250, 0, 1285, 800);
		setLayout(null);

		JPanel pnl = new JPanel();
		pnl.setBackground(new Color(240, 240, 240));
		pnl.setBounds(20, 20, 1250, 780);
		this.add(pnl);
		pnl.setLayout(null);

		JPanel pnlThongTinNV = new JPanel();
		pnlThongTinNV.setBackground(new Color(255, 255, 255));
		pnlThongTinNV.setBorder(new TitledBorder(null, "Th\u00F4ng Tin Nh\u00E2n Vi\u00EAn", TitledBorder.LEADING,
				TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		pnlThongTinNV.setBounds(20, 20, 672, 365);
		pnl.add(pnlThongTinNV);
		pnlThongTinNV.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(30, 30, 150, 200);
		pnlThongTinNV.add(panel_1);

		btnHinhAnh = new MyButton("Chọn ảnh");
		btnHinhAnh.setForeground(new Color(255, 255, 255));
		btnHinhAnh.setBounds(56, 240, 90, 21);
		pnlThongTinNV.add(btnHinhAnh);

		JLabel lblMaNV = new JLabel("Mã nhân viên");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaNV.setBounds(217, 35, 90, 15);
		pnlThongTinNV.add(lblMaNV);

		JLabel lblTenNV = new JLabel("Tên nhân viên");
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenNV.setBounds(217, 77, 90, 15);
		pnlThongTinNV.add(lblTenNV);

		JLabel lblSdt = new JLabel("Số điện thoại");
		lblSdt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSdt.setBounds(217, 119, 90, 15);
		pnlThongTinNV.add(lblSdt);

		JLabel lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGioiTinh.setBounds(217, 159, 90, 15);
		pnlThongTinNV.add(lblGioiTinh);

		JLabel lblCCCD = new JLabel("CCCD");
		lblCCCD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCCCD.setBounds(217, 199, 90, 15);
		pnlThongTinNV.add(lblCCCD);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(217, 242, 90, 15);
		pnlThongTinNV.add(lblEmail);

		JLabel lblChucVu = new JLabel("Chức vụ");
		lblChucVu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblChucVu.setBounds(217, 283, 90, 15);
		pnlThongTinNV.add(lblChucVu);

		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDiaChi.setBounds(30, 325, 45, 15);
		pnlThongTinNV.add(lblDiaChi);

		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMaNV.setEditable(false);
		txtMaNV.setEnabled(false);
		txtMaNV.setBounds(307, 30, 191, 25);
		pnlThongTinNV.add(txtMaNV);
		txtMaNV.setColumns(10);

		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTenNV.setBounds(307, 72, 300, 25);
		pnlThongTinNV.add(txtTenNV);
		txtTenNV.setColumns(10);

		txtSdt = new JTextField();
		txtSdt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSdt.setBounds(307, 114, 300, 25);
		pnlThongTinNV.add(txtSdt);
		txtSdt.setColumns(10);

		txtCCCD = new JTextField();
		txtCCCD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCCCD.setBounds(307, 194, 300, 25);
		pnlThongTinNV.add(txtCCCD);
		txtCCCD.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEmail.setBounds(307, 236, 300, 25);
		pnlThongTinNV.add(txtEmail);
		txtEmail.setColumns(10);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDiaChi.setBounds(95, 320, 512, 25);
		pnlThongTinNV.add(txtDiaChi);
		txtDiaChi.setColumns(10);

		radNam = new JRadioButton("Nam");
		radNam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radNam.setBackground(new Color(255, 255, 255));
		radNam.setSelected(true);
		radNam.setBounds(307, 156, 90, 21);
		pnlThongTinNV.add(radNam);

		radNu = new JRadioButton("Nữ");
		radNu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radNu.setBackground(new Color(255, 255, 255));
		radNu.setBounds(399, 156, 90, 21);
		pnlThongTinNV.add(radNu);

		ButtonGroup gr = new ButtonGroup();
		gr.add(radNu);
		gr.add(radNam);

		cboChucVu = new MyCombobox();
		cboChucVu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboChucVu.setBounds(307, 278, 300, 25);
		pnlThongTinNV.add(cboChucVu);

		// dữ liệu mẫu
		cboChucVu.addItem("Nhân viên");
		cboChucVu.addItem("Quản lý");
		cboChucVu.addItem("Giao hàng");

		btnTaoMa = new MyButton("Tạo mã");
		btnTaoMa.setForeground(new Color(255, 255, 255));
		btnTaoMa.setBounds(511, 33, 96, 21);
		pnlThongTinNV.add(btnTaoMa);

		// tìm kiếm
		JPanel pnlTimKiemNV = new JPanel();
		pnlTimKiemNV.setBackground(new Color(255, 255, 255));
		pnlTimKiemNV.setBorder(new TitledBorder(null, "T\u00ECm Ki\u1EBFm", TitledBorder.LEADING,
				TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		pnlTimKiemNV.setBounds(20, 400, 672, 75);
		pnl.add(pnlTimKiemNV);
		pnlTimKiemNV.setLayout(null);

		txtTimNV = new JTextField();
		txtTimNV.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtTimNV.setForeground(new Color(128, 128, 128));
		txtTimNV.setText("Nhập mã hoặc số điện thoại hoặc tên nhân viên cần tìm");
		txtTimNV.setBounds(30, 25, 575, 28);
		pnlTimKiemNV.add(txtTimNV);
		txtTimNV.setColumns(10);

		JPanel pnlTaiKhoan = new JPanel();
		pnlTaiKhoan.setBorder(new TitledBorder(null, "T\u1EA1o t\u00E0i kho\u1EA3n", TitledBorder.LEADING,
				TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		pnlTaiKhoan.setForeground(new Color(0, 0, 0));
		pnlTaiKhoan.setBackground(new Color(255, 255, 255));
		pnlTaiKhoan.setBounds(708, 20, 520, 175);
		pnl.add(pnlTaiKhoan);
		pnlTaiKhoan.setLayout(null);

		JLabel lblTenTK = new JLabel("Tên tài khoản");
		lblTenTK.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenTK.setBounds(70, 35, 90, 15);
		pnlTaiKhoan.add(lblTenTK);

		JLabel lblMatKhau = new JLabel("Mật khẩu");
		lblMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMatKhau.setBounds(70, 77, 90, 15);
		pnlTaiKhoan.add(lblMatKhau);

		txtTenTK = new JTextField();
		txtTenTK.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTenTK.setEditable(false);
		txtTenTK.setBounds(163, 30, 280, 25);
		pnlTaiKhoan.add(txtTenTK);
		txtTenTK.setColumns(10);

		txtMatKhau = new JTextField();
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMatKhau.setBounds(163, 72, 280, 25);
		pnlTaiKhoan.add(txtMatKhau);
		txtMatKhau.setColumns(10);

		btnTaoTK = new MyButton("Tạo tài khoản");
		btnTaoTK.setForeground(new Color(255, 255, 255));
		btnTaoTK.setBounds(195, 116, 120, 25);
		pnlTaiKhoan.add(btnTaoTK);

		// chức năng
		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBackground(new Color(255, 255, 255));
		pnlChucNang.setBorder(new TitledBorder(null, "Ch\u1EE9c N\u0103ng", TitledBorder.LEADING,
				TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		pnlChucNang.setBounds(708, 210, 520, 175);
		pnl.add(pnlChucNang);
		pnlChucNang.setLayout(null);

		btnThemNV = new MyButton("Thêm");
		btnThemNV.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThemNV.setForeground(new Color(255, 255, 255));
		btnThemNV.setBounds(70, 33, 150, 30);
		pnlChucNang.add(btnThemNV);

		btnCapNhatNV = new MyButton("Cặp nhật");
		btnCapNhatNV.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCapNhatNV.setForeground(new Color(255, 255, 255));
		btnCapNhatNV.setText("Cập nhật");
		btnCapNhatNV.setBounds(290, 33, 150, 30);
		pnlChucNang.add(btnCapNhatNV);

		btnXoaTrang = new MyButton("Xóa trắng");
		btnXoaTrang.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoaTrang.setForeground(new Color(255, 255, 255));
		btnXoaTrang.setBounds(70, 93, 150, 30);
		pnlChucNang.add(btnXoaTrang);

		btnTaiLai = new MyButton("Tải lại");
		btnTaiLai.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTaiLai.setForeground(new Color(255, 255, 255));
		btnTaiLai.setBounds(290, 93, 150, 30);
		pnlChucNang.add(btnTaiLai);

		JPanel pnlLocNV = new JPanel();
		pnlLocNV.setBounds(708, 400, 520, 75);
		pnl.add(pnlLocNV);
		pnlLocNV.setBorder(new TitledBorder(null, "L\u1ECDc Nh\u00E2n Vi\u00EAn", TitledBorder.LEADING,
				TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		pnlLocNV.setBackground(new Color(255, 255, 255));
		pnlLocNV.setLayout(null);

		btnLocGioiTinh = new MyButton("Lọc theo giới tính");
		// btnLocGioiTinh.setIcon(new
		// ImageIcon(GUINhanVien.class.getResource("/image/sanpham/icons8-filter-16.png")));
		btnLocGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLocGioiTinh.setForeground(new Color(255, 255, 255));
		btnLocGioiTinh.setText("Giới tính");
		btnLocGioiTinh.setBounds(70, 25, 150, 30);
		pnlLocNV.add(btnLocGioiTinh);

		btnLocChucVu = new MyButton("Lọc theo chức vụ");
		// btnLocChucVu.setIcon(new
		// ImageIcon(GUINhanVien.class.getResource("/image/sanpham/icons8-filter-16.png")));
		btnLocChucVu.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLocChucVu.setForeground(new Color(255, 255, 255));
		btnLocChucVu.setText("Chức vụ");
		btnLocChucVu.setBounds(290, 25, 150, 30);
		pnlLocNV.add(btnLocChucVu);

		// tạo bảng
		JPanel pnlTable = new JPanel();
		pnlTable.setBorder(new TitledBorder(null, "Danh s\u00E1ch nh\u00E2n vi\u00EAn", TitledBorder.LEADING,
				TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		pnlTable.setBackground(new Color(255, 255, 255));
		pnlTable.setBounds(20, 490, 1208, 280);
		pnl.add(pnlTable);
		String[] cols = { "Mã nhân viên", "Tên nhân viên", "Số điện thoại", "Giới tính", "CCCD", "Email", "Chức vụ",
				"Địa chỉ", "Mật khẩu" };
		model = new DefaultTableModel(cols, 0);
		pnlTable.setLayout(null);
		table = new MyTable(model);
		scr = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scr.setLocation(20, 25);
		scr.setSize(1166, 237);
		pnlTable.add(scr);

		// dữ liệu mẫu
		String[] row1 = { "NV1", "Tên nhân viên", "0147852369", "Nam", "CCCD", "Email", "Nhân viên", "Địa chỉ ABC",
				"Mật khẩu" };
		String[] row2 = { "NV2", "Tên nhân viên", "0147852369", "Nu", "CCCD", "Email", "Quản lý", "Địa chỉ 123",
				"Mật khẩu" };
		model.addRow(row1);
		model.addRow(row2);

		// sự kiện
		btnXoaTrang.addActionListener(this);
		txtTimNV.addFocusListener(this);
		table.addMouseListener(this);
	}

	private void xoaTrang() {
		txtMaNV.setText("");
		txtTenNV.setText("");
		txtSdt.setText("");
		txtCCCD.setText("");
		txtEmail.setText("");
		txtDiaChi.setText("");
		txtTenTK.setText("");
		txtMatKhau.setText("");
		radNam.setSelected(true);
		cboChucVu.setSelectedIndex(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnXoaTrang)) {
			xoaTrang();
		}

	}

	@Override
	public void focusGained(FocusEvent e) {
		if (txtTimNV.getText().equals("Nhập mã hoặc số điện thoại hoặc tên nhân viên cần tìm")) {
			txtTimNV.setText("");
			txtTimNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtTimNV.setForeground(Color.BLACK);
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (txtTimNV.getText().isEmpty()) {
			txtTimNV.setFont(new Font("Tahoma", Font.ITALIC, 13));
			txtTimNV.setForeground(Color.GRAY);
			txtTimNV.setText("Nhập mã hoặc số điện thoại hoặc tên nhân viên cần tìm");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int r = table.getSelectedRow();
		if (r != -1) {
			txtMaNV.setText(model.getValueAt(r, 0).toString());
			txtTenNV.setText(model.getValueAt(r, 1).toString());
			txtSdt.setText(model.getValueAt(r, 2).toString());
			txtCCCD.setText(model.getValueAt(r, 4).toString());
			txtEmail.setText(model.getValueAt(r, 5).toString());
			txtDiaChi.setText(model.getValueAt(r, 7).toString());
			txtMatKhau.setText(model.getValueAt(r, 8).toString());
			txtTenTK.setText(model.getValueAt(r, 0).toString());
			if (model.getValueAt(r, 3).toString().equals("Nam"))
				radNam.setSelected(true);
			else
				radNu.setSelected(true);
			if (model.getValueAt(r, 6).toString().equals("Nhân viên")) {
				cboChucVu.setSelectedIndex(0);
			} else if (model.getValueAt(r, 6).toString().equals("Quản lý")) {
				cboChucVu.setSelectedIndex(1);
			} else {
				cboChucVu.setSelectedIndex(2);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
