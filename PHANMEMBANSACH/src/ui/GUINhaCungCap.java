package ui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import CustomUI.MyButton;
import CustomUI.MyTable;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

public class GUINhaCungCap extends JPanel {
	private JTextField txtMaNCC;
	private JTextField txtTenNCC;
	private JTextField txtDiaChi;
	private JTextField txtSdt;
	private JTextField txtEmail;
	private MyButton btnTaoMa;
	private JTextField txtNhpMHoc;
	private MyButton btnTenNCC;
	private MyButton btnCapNhat;
	private MyButton btnXoaTrang;
	private MyTable table;
	private MyButton btnXoa;
	private MyButton btnTaiLai;

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

//		JPanel pnl2 = new JPanel();
//		pnl2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
//		pnl2.setBounds(20, 20, 1162, 710);
//		pnl1.add(pnl2);
//		pnl2.setLayout(null);

		JPanel pnlTongTinNCC = new JPanel();
		pnlTongTinNCC.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
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
		txtMaNCC.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMaNCC.setEditable(false);
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
		btnTaoMa.setBounds(562, 35, 96, 21);
		pnlTongTinNCC.add(btnTaoMa);

		// tìm kiếm
		JPanel pnlTimKiemNCC = new JPanel();
		pnlTimKiemNCC.setBorder(new TitledBorder(null, "T\u00ECm Ki\u1EBFm", TitledBorder.LEADING,
				TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		pnlTimKiemNCC.setBackground(new Color(255, 255, 255));
		pnlTimKiemNCC.setBounds(20, 308, 1201, 100);
		pnl1.add(pnlTimKiemNCC);
		pnlTimKiemNCC.setLayout(null);

		txtNhpMHoc = new JTextField();
		txtNhpMHoc.setForeground(new Color(141, 141, 141));
		txtNhpMHoc.setText("Nhập mã hoặc số điện thoại hoặc tên nhà cung cấp");
		txtNhpMHoc.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtNhpMHoc.setBounds(30, 40, 938, 25);
		pnlTimKiemNCC.add(txtNhpMHoc);
		txtNhpMHoc.setColumns(10);

		btnXoa = new MyButton("Xóa");
		btnXoa.setForeground(new Color(255, 255, 255));
		btnXoa.setText("Tìm");
		btnXoa.setBounds(1016, 43, 85, 21);
		pnlTimKiemNCC.add(btnXoa);

		// chức năng
		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBackground(new Color(255, 255, 255));
		pnlChucNang.setBounds(771, 20, 450, 270);
		pnl1.add(pnlChucNang);
		pnlChucNang.setBorder(new TitledBorder(null, "Ch\u1EE9c N\u0103ng", TitledBorder.LEADING,
				TitledBorder.BELOW_TOP, null, null));
		pnlChucNang.setLayout(null);

		btnTenNCC = new MyButton("THÊM NHÀ CUNG CẤP");
		btnTenNCC.setForeground(new Color(255, 255, 255));
		btnTenNCC.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTenNCC.setText("Thêm");
		btnTenNCC.setBounds(55, 57, 150, 35);
		pnlChucNang.add(btnTenNCC);

		btnCapNhat = new MyButton("CẬP NHẬT");
		btnCapNhat.setForeground(new Color(255, 255, 255));
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCapNhat.setText("Cập nhật");
		btnCapNhat.setBounds(245, 57, 150, 35);
		pnlChucNang.add(btnCapNhat);

		btnXoaTrang = new MyButton("XÓA TRẮNG");
		btnXoaTrang.setForeground(new Color(255, 255, 255));
		btnXoaTrang.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoaTrang.setText("Xóa trắng");
		btnXoaTrang.setBounds(55, 123, 150, 35);
		pnlChucNang.add(btnXoaTrang);

		btnTaiLai = new MyButton("TẢI LẠI");
		btnTaiLai.setForeground(new Color(255, 255, 255));
		btnTaiLai.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTaiLai.setText("Tải lại");
		btnTaiLai.setBounds(245, 123, 150, 35);
		pnlChucNang.add(btnTaiLai);

		// tạo bảng
		JPanel pnlTable = new JPanel();
		pnlTable.setBackground(new Color(255, 255, 255));
		pnlTable.setBorder(new TitledBorder(null, "Danh s\u00E1ch nh\u00E0 cung c\u1EA5p", TitledBorder.LEADING,
				TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		pnlTable.setBounds(20, 429, 1201, 341);
		pnl1.add(pnlTable);
		String[] cols = { "STT", "Mã nhà cung cấp", "Tên nhà cung cấp", "Số điện thoại", "Email", "Địa chỉ" };
		DefaultTableModel model = new DefaultTableModel(cols, 0);
		pnlTable.setLayout(null);
		table = new MyTable(model);
		JScrollPane scr = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scr.setLocation(22, 30);
		scr.setSize(1157, 301);
		pnlTable.add(scr);
	}
}
