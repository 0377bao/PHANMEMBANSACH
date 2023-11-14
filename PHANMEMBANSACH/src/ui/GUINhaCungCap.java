package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.ctc.wstx.shaded.msv_core.reader.datatype.xsd.XSTypeOwner;

import bus.BUSNhaCungCap;
import controller.ControllerNhaCungCap;
import customUI.MyButton;
import customUI.MyCombobox;
import customUI.MyTable;
import entity.NhaCungCap;

public class GUINhaCungCap extends JPanel {
	private JTextField txtMaNCC;
	private JTextField txtTenNCC;
	private JTextField txtDiaChi;
	private JTextField txtSdt;
	private JTextField txtEmail;
	private MyButton btnTaoMa;
	private JTextField txtTimTheoMa_Sdt;
	private MyButton btnThemNCC;
	private MyButton btnCapNhat;
	private MyButton btnXoaTrang;
	private MyTable table;
	private MyButton btnTim;
	private MyButton btnTaiLai;
	private DefaultTableModel modelNCC;

	private BUSNhaCungCap busNCC = new BUSNhaCungCap();
	private JTextField txtTimTheoTen;
	private JComboBox<String> cboDiaChi;

	public GUINhaCungCap() {
		this.setBackground(new Color(255, 255, 255));
		this.setBounds(250, 0, 1280, 800);
		setLayout(null);

		JPanel pnl1 = new JPanel();
		pnl1.setBackground(new Color(240, 240, 240));
		pnl1.setBorder(null);
		pnl1.setBounds(20, 20, 1243, 780);
		add(pnl1);
		pnl1.setLayout(null);

		JPanel pnlTongTinNCC = new JPanel();
		pnlTongTinNCC.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
				"Th\u00F4ng Tin Nh\u00E0 Cung C\u1EA5p", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null,
				new Color(0, 0, 0)));
		pnlTongTinNCC.setBackground(new Color(255, 255, 255));
		pnlTongTinNCC.setBounds(20, 20, 730, 270);
		pnl1.add(pnlTongTinNCC);
		pnlTongTinNCC.setLayout(null);

		JLabel lblMaNCC = new JLabel("Mã nhà cung cấp");
		lblMaNCC.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaNCC.setBounds(70, 37, 110, 15);
		pnlTongTinNCC.add(lblMaNCC);

		JLabel lblTenNCC = new JLabel("Tên nhà cung cấp");
		lblTenNCC.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenNCC.setBounds(70, 81, 110, 15);
		pnlTongTinNCC.add(lblTenNCC);

		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDiaChi.setBounds(70, 220, 110, 15);
		pnlTongTinNCC.add(lblDiaChi);

		JLabel lblSdt = new JLabel("Số điện thoại");
		lblSdt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSdt.setBounds(70, 126, 110, 15);
		pnlTongTinNCC.add(lblSdt);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(70, 174, 110, 15);
		pnlTongTinNCC.add(lblEmail);

		txtMaNCC = new JTextField();
		txtMaNCC.setEditable(false);
		txtMaNCC.setEnabled(false);
		txtMaNCC.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMaNCC.setBounds(210, 32, 329, 25);
		pnlTongTinNCC.add(txtMaNCC);
		txtMaNCC.setColumns(10);

		txtTenNCC = new JTextField();
		txtTenNCC.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTenNCC.setBounds(210, 76, 448, 25);
		pnlTongTinNCC.add(txtTenNCC);
		txtTenNCC.setColumns(10);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDiaChi.setBounds(210, 215, 448, 25);
		pnlTongTinNCC.add(txtDiaChi);
		txtDiaChi.setColumns(10);

		txtSdt = new JTextField();
		txtSdt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSdt.setBounds(210, 121, 448, 25);
		pnlTongTinNCC.add(txtSdt);
		txtSdt.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEmail.setBounds(210, 169, 448, 25);
		pnlTongTinNCC.add(txtEmail);
		txtEmail.setColumns(10);

		btnTaoMa = new MyButton("Tạo Mã");
		btnTaoMa.setForeground(new Color(255, 255, 255));
		btnTaoMa.setBounds(562, 32, 96, 25);
		btnTaoMa.setActionCommand("btnTaoMa");
		pnlTongTinNCC.add(btnTaoMa);

		// tìm kiếm
		JPanel pnlTimKiemNCC = new JPanel();
		pnlTimKiemNCC.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
				"T\u00ECm Ki\u1EBFm Nh\u00E0 Cung C\u1EA5p", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null,
				new Color(0, 0, 0)));
		pnlTimKiemNCC.setBackground(new Color(255, 255, 255));
		pnlTimKiemNCC.setBounds(20, 308, 1201, 100);
		pnl1.add(pnlTimKiemNCC);
		pnlTimKiemNCC.setLayout(null);

		txtTimTheoMa_Sdt = new JTextField();
		txtTimTheoMa_Sdt.setForeground(new Color(141, 141, 141));
		txtTimTheoMa_Sdt.setText("Nhập số điện thoại");
		txtTimTheoMa_Sdt.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtTimTheoMa_Sdt.setBounds(30, 40, 300, 25);
		pnlTimKiemNCC.add(txtTimTheoMa_Sdt);
		txtTimTheoMa_Sdt.setName("txtTimTheoMa_Sdt");
		txtTimTheoMa_Sdt.setColumns(10);

//		btnTim = new MyButton("Tìm");
//		btnTim.setForeground(new Color(255, 255, 255));
//		btnTim.setBounds(416, 43, 85, 21);
//		btnTim.setActionCommand("btnTim");
//		pnlTimKiemNCC.add(btnTim);

		txtTimTheoTen = new JTextField();
		txtTimTheoTen.setText("Nhập tên nhà cung cấp cần tìm");
		txtTimTheoTen.setForeground(new Color(141, 141, 141));
		txtTimTheoTen.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtTimTheoTen.setColumns(10);
		txtTimTheoTen.setBounds(464, 40, 300, 25);
		txtTimTheoTen.setName("txtTimTheoTen");
		pnlTimKiemNCC.add(txtTimTheoTen);

		cboDiaChi = new MyCombobox();
		cboDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboDiaChi.setBounds(1026, 40, 150, 25);
		cboDiaChi.setActionCommand("cboDiaChi");
		pnlTimKiemNCC.add(cboDiaChi);

		cboDiaChi.addItem("Tất cả");
		cboDiaChi.addItem("Hồ Chí Minh");
		cboDiaChi.addItem("Hà Nội");
		cboDiaChi.addItem("Đà Nẵng");

		JLabel lblLocDiaChi = new JLabel("Lọc theo địa chỉ");
		lblLocDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLocDiaChi.setForeground(new Color(0, 0, 0));
		lblLocDiaChi.setBounds(918, 45, 109, 15);
		pnlTimKiemNCC.add(lblLocDiaChi);

		// chức năng
		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBackground(new Color(255, 255, 255));
		pnlChucNang.setBounds(771, 20, 450, 270);
		pnl1.add(pnlChucNang);
		pnlChucNang.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
				"Ch\u1EE9c N\u0103ng", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		pnlChucNang.setLayout(null);

		btnThemNCC = new MyButton("Thêm");
		btnThemNCC.setForeground(new Color(255, 255, 255));
		btnThemNCC.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThemNCC.setBounds(55, 57, 150, 35);
		btnThemNCC.setActionCommand("btnThemNCC");
		pnlChucNang.add(btnThemNCC);

		btnCapNhat = new MyButton("Cập nhật");
		btnCapNhat.setForeground(new Color(255, 255, 255));
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCapNhat.setBounds(245, 57, 150, 35);
		btnCapNhat.setActionCommand("btnCapNhat");
		pnlChucNang.add(btnCapNhat);

		btnXoaTrang = new MyButton("Xóa trắng");
		btnXoaTrang.setForeground(new Color(255, 255, 255));
		btnXoaTrang.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoaTrang.setBounds(55, 123, 150, 35);
		btnXoaTrang.setActionCommand("btnXoaTrang");
		pnlChucNang.add(btnXoaTrang);

		btnTaiLai = new MyButton("Tải lại");
		btnTaiLai.setForeground(new Color(255, 255, 255));
		btnTaiLai.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTaiLai.setBounds(245, 123, 150, 35);
		btnTaiLai.setActionCommand("btnTaiLai");
		pnlChucNang.add(btnTaiLai);

		// tạo bảng
		JPanel pnlTable = new JPanel();
		pnlTable.setBackground(new Color(255, 255, 255));
		pnlTable.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
				"Danh s\u00E1ch nh\u00E0 cung c\u1EA5p", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null,
				new Color(0, 0, 0)));
		pnlTable.setBounds(20, 429, 1201, 341);
		pnl1.add(pnlTable);
		String[] cols = { "Mã nhà cung cấp", "Tên nhà cung cấp", "Số điện thoại", "Email", "Địa chỉ" };
		modelNCC = new DefaultTableModel(cols, 0);
		pnlTable.setLayout(null);
		table = new MyTable(modelNCC);

		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(4).setPreferredWidth(300);

		JScrollPane scr = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scr.setLocation(22, 30);
		scr.setSize(1157, 301);
		pnlTable.add(scr);

		ArrayList<NhaCungCap> dsNCC = busNCC.layDSNhaCungCap();
		hienThiDuLieu(dsNCC);

		// dữ liệu test
		txtTenNCC.setText("Công Ty TNHH Thương Mại Và Dịch Vụ Sách Gia Định");
		txtSdt.setText("0287303680");
		txtEmail.setText("giadinhbook@gmail.com");
		txtDiaChi.setText("6/20A Lê Đức Thọ, P. 16, Q. Gò Vấp, Tp. Hồ Chí Minh");

		// sự kiện
		ActionListener ac = new ControllerNhaCungCap(this);
		btnTaoMa.addActionListener(ac);
		btnThemNCC.addActionListener(ac);
		btnCapNhat.addActionListener(ac);
		btnTaiLai.addActionListener(ac);
		btnXoaTrang.addActionListener(ac);
		cboDiaChi.addActionListener(ac);

		table.addMouseListener(new ControllerNhaCungCap(this));

		txtTimTheoMa_Sdt.addFocusListener(new ControllerNhaCungCap(this));
		txtTimTheoTen.addFocusListener(new ControllerNhaCungCap(this));

		txtTimTheoMa_Sdt.addKeyListener(new ControllerNhaCungCap(this));
		txtTimTheoTen.addKeyListener(new ControllerNhaCungCap(this));
	}

	// tìm ncc theo địa chỉ
	public void timTheoDiaChi() {
		String diaChi = cboDiaChi.getSelectedItem().toString();
		xoaDuLieuBang();
		hienThiDuLieu(busNCC.layNCCTheoDiaChi(diaChi));
	}

	// tìm ncc theo tên
	public void timTheoTen() {
		String ten = txtTimTheoTen.getText().trim();
		xoaDuLieuBang();
		hienThiDuLieu(busNCC.layNCCTheoTen(ten));
	}

	// tìm ncc theo số điện thoại
	public void timTheoMa_Sdt() {
		String info = txtTimTheoMa_Sdt.getText().trim();
		xoaDuLieuBang();
		hienThiDuLieu(busNCC.layNCCTheoSdt(info));
	}

	// tải lại
	public void taiLai() {
		ArrayList<NhaCungCap> dsNCC = busNCC.layDSNhaCungCap();
		xoaDuLieuBang();
		hienThiDuLieu(dsNCC);
		cboDiaChi.setSelectedIndex(0);
		txtTimTheoMa_Sdt.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtTimTheoMa_Sdt.setForeground(Color.GRAY);
		txtTimTheoMa_Sdt.setText("Nhập số điện thoại");
		txtTimTheoTen.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtTimTheoTen.setForeground(Color.GRAY);
		txtTimTheoTen.setText("Nhập tên nhà cung cấp cần tìm");
	}

	// cập nhật nhà cung cấp
	public void CapNhatNCC() {
		int r = table.getSelectedRow();
		if (r < 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa");
			return;
		} else {
			String ma = txtMaNCC.getText().trim();
			String ten = txtTenNCC.getText().trim();
			String sdt = txtSdt.getText().trim();
			String email = txtEmail.getText().trim();
			String diaChi = txtDiaChi.getText().trim();
			if (busNCC.validData(ma, ten, diaChi, sdt, email)) {
				NhaCungCap ncc = new NhaCungCap(ma, ten, diaChi, sdt, email);
				if (busNCC.capNhatNCC(ncc)) {
					modelNCC.setValueAt(ten, r, 1);
					modelNCC.setValueAt(sdt, r, 2);
					modelNCC.setValueAt(email, r, 3);
					modelNCC.setValueAt(diaChi, r, 4);
					xoaTrang();
					JOptionPane.showMessageDialog(this, "Cập nhật thành công");
				} else {
					JOptionPane.showMessageDialog(this, "Thất bại");
				}
			} else {
				JOptionPane.showMessageDialog(this, busNCC.mes);
			}

		}
	}

	// thêm nhà cung cấp
	public void themNCC() {
		String ma = txtMaNCC.getText().trim();
		String ten = txtTenNCC.getText().trim();
		String sdt = txtSdt.getText().trim();
		String email = txtEmail.getText().trim();
		String diaChi = txtDiaChi.getText().trim();
		if (busNCC.validData(ma, ten, diaChi, sdt, email)) {
			NhaCungCap ncc = new NhaCungCap(ma, ten, diaChi, sdt, email);
			if (busNCC.themNCC(ncc)) {
				xoaTrang();
				taiLai();
				JOptionPane.showMessageDialog(this, "Thêm thành công");
			} else {
				JOptionPane.showMessageDialog(this, "Thêm thất bại - Mã nhà cung cấp đã tồn tại");
			}
		} else {
			JOptionPane.showMessageDialog(this, busNCC.mes);
		}

	}

	// tạo mã
	public void taoMa() {
		txtMaNCC.setText(busNCC.taoMa());
	}

	// xóa dữ liệu bảng
	public void xoaDuLieuBang() {
		while (modelNCC.getRowCount() != 0) {
			modelNCC.removeRow(0);
		}
	}

	// xóa trắng
	public void xoaTrang() {
		txtMaNCC.setText("");
		txtTenNCC.setText("");
		txtSdt.setText("");
		txtEmail.setText("");
		txtDiaChi.setText("");
		btnTaoMa.setEnabled(true);
	}

	// chọn thông tin trong bảng hiện lên
	public void chonThongTin() {
		int r = table.getSelectedRow();
		if (r != -1) {
			txtMaNCC.setText(modelNCC.getValueAt(r, 0).toString());
			txtTenNCC.setText(modelNCC.getValueAt(r, 1).toString());
			txtSdt.setText(modelNCC.getValueAt(r, 2).toString());
			txtEmail.setText(modelNCC.getValueAt(r, 3).toString());
			txtDiaChi.setText(modelNCC.getValueAt(r, 4).toString());
			btnTaoMa.setEnabled(false);
		}
	}

	// hiển thị dữ liệu
	public void hienThiDuLieu(ArrayList<NhaCungCap> dsNCC) {
		for (NhaCungCap ncc : dsNCC) {
			modelNCC.addRow(new Object[] { ncc.getMaNhaCungCap(), ncc.getTenNhaCungCap(), ncc.getSdt(), ncc.getEmail(),
					ncc.getDiaChi() });
		}
	}

	public void focusGainedTen() {
		if (txtTimTheoTen.getText().equals("Nhập tên nhà cung cấp cần tìm")) {
			txtTimTheoTen.setText("");
			txtTimTheoTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtTimTheoTen.setForeground(Color.BLACK);
		}
	}

	public void focusLostTen() {
		if (txtTimTheoTen.getText().isEmpty()) {
			txtTimTheoTen.setFont(new Font("Tahoma", Font.ITALIC, 13));
			txtTimTheoTen.setForeground(Color.GRAY);
			txtTimTheoTen.setText("Nhập tên nhà cung cấp cần tìm");
		}
	}

	public void focusGainedSdt() {
		if (txtTimTheoMa_Sdt.getText().equals("Nhập số điện thoại")) {
			txtTimTheoMa_Sdt.setText("");
			txtTimTheoMa_Sdt.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtTimTheoMa_Sdt.setForeground(Color.BLACK);
		}
	}

	public void focusLostSdt() {
		if (txtTimTheoMa_Sdt.getText().isEmpty()) {
			txtTimTheoMa_Sdt.setFont(new Font("Tahoma", Font.ITALIC, 13));
			txtTimTheoMa_Sdt.setForeground(Color.GRAY);
			txtTimTheoMa_Sdt.setText("Nhập số điện thoại");
		}
	}
}
