package ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import customUI.MyButton;
import customUI.MyTable;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class GUIKhachHang extends JPanel {
	private JTextField txtMaKhachHang;
	private JTextField txtTenKhachHang;
	private JTextField txtDiemTichLuy;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JTextField textField;
	private JTextField textField_1;
	private DefaultTableModel modelKhachHang, modelLichSuGD;
	private JTable tableKhachHang, tableLichSuGD;
	public GUIKhachHang() {
		setBackground(new Color(240, 240, 240));
		this.setBounds(250, 0, 1250, 800);
		setLayout(null);
		
		JPanel pnlThongTinKhachHang = new JPanel();
		pnlThongTinKhachHang.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlThongTinKhachHang.setBackground(new Color(255, 255, 255));
		pnlThongTinKhachHang.setBounds(10, 10, 954, 191);
		add(pnlThongTinKhachHang);
		pnlThongTinKhachHang.setLayout(null);
		
		JLabel lblThngTinKhch = new JLabel("Thông tin khách hàng");
		lblThngTinKhch.setForeground(Color.GRAY);
		lblThngTinKhch.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblThngTinKhch.setBounds(10, 10, 167, 20);
		pnlThongTinKhachHang.add(lblThngTinKhch);
		
		JLabel lblMKhchHng = new JLabel("Mã khách hàng:");
		lblMKhchHng.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMKhchHng.setBounds(10, 40, 111, 25);
		pnlThongTinKhachHang.add(lblMKhchHng);
		
		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setEnabled(false);
		txtMaKhachHang.setDisabledTextColor(Color.BLACK);
		txtMaKhachHang.setColumns(10);
		txtMaKhachHang.setBounds(131, 40, 230, 25);
		pnlThongTinKhachHang.add(txtMaKhachHang);
		
		JLabel lblTnKhchHng = new JLabel("Tên khách hàng:");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTnKhchHng.setBounds(10, 75, 111, 25);
		pnlThongTinKhachHang.add(lblTnKhchHng);
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(131, 76, 230, 25);
		pnlThongTinKhachHang.add(txtTenKhachHang);
		
		JLabel lblimTichLy = new JLabel("Điểm tich lũy:");
		lblimTichLy.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblimTichLy.setBounds(10, 110, 111, 25);
		pnlThongTinKhachHang.add(lblimTichLy);
		
		txtDiemTichLuy = new JTextField();
		txtDiemTichLuy.setEnabled(false);
		txtDiemTichLuy.setDisabledTextColor(Color.BLACK);
		txtDiemTichLuy.setColumns(10);
		txtDiemTichLuy.setBounds(131, 111, 230, 25);
		pnlThongTinKhachHang.add(txtDiemTichLuy);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSinThoi.setBounds(508, 40, 111, 25);
		pnlThongTinKhachHang.add(lblSinThoi);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(621, 41, 230, 25);
		pnlThongTinKhachHang.add(txtSDT);
		
		JLabel lblTmKimHa_3_1 = new JLabel("Email:");
		lblTmKimHa_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTmKimHa_3_1.setBounds(508, 75, 111, 25);
		pnlThongTinKhachHang.add(lblTmKimHa_3_1);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(621, 76, 230, 25);
		pnlThongTinKhachHang.add(txtEmail);
		
		JButton btnXoaTrang = new MyButton("Xóa trắng");
		btnXoaTrang.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoaTrang.setBounds(425, 146, 99, 30);
		pnlThongTinKhachHang.add(btnXoaTrang);
		
		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlChucNang.setBackground(Color.WHITE);
		pnlChucNang.setBounds(974, 10, 303, 191);
		add(pnlChucNang);
		pnlChucNang.setLayout(null);
		
		JButton btnTaoMa = new MyButton("Tạo mã khách hàng");
		btnTaoMa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTaoMa.setBounds(62, 33, 179, 35);
		pnlChucNang.add(btnTaoMa);
		
		JButton btnThemKhachHang = new MyButton("Thêm khách hàng");
		btnThemKhachHang.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThemKhachHang.setBounds(62, 78, 179, 35);
		pnlChucNang.add(btnThemKhachHang);
		
		JButton btnCapNhat = new MyButton("Cập nhật");
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCapNhat.setBounds(62, 123, 179, 35);
		pnlChucNang.add(btnCapNhat);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 211, 1267, 83);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblTmKimKhch = new JLabel("Tìm kiếm khách hàng");
		lblTmKimKhch.setForeground(Color.GRAY);
		lblTmKimKhch.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTmKimKhch.setBounds(10, 10, 167, 20);
		panel.add(lblTmKimKhch);
		
		JLabel lblMKhchHng_1 = new JLabel("Tên khách hàng:");
		lblMKhchHng_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMKhchHng_1.setBounds(10, 40, 106, 25);
		panel.add(lblMKhchHng_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(131, 40, 345, 25);
		panel.add(textField);
		
		JLabel lblMKhchHng_1_1 = new JLabel("Số điện thoại:");
		lblMKhchHng_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMKhchHng_1_1.setBounds(538, 40, 106, 25);
		panel.add(lblMKhchHng_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(640, 41, 345, 25);
		panel.add(textField_1);
		
		MyButton mbtnSpXpTheo = new MyButton("Xóa trắng");
		mbtnSpXpTheo.setText("Sắp xếp theo tổng tiền");
		mbtnSpXpTheo.setFont(new Font("Tahoma", Font.BOLD, 13));
		mbtnSpXpTheo.setBounds(1061, 37, 167, 30);
		panel.add(mbtnSpXpTheo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 304, 724, 481);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDanhSchKhch = new JLabel("Danh sách khách hàng:");
		lblDanhSchKhch.setForeground(Color.GRAY);
		lblDanhSchKhch.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDanhSchKhch.setBounds(10, 10, 167, 20);
		panel_1.add(lblDanhSchKhch);
		
		String[] colsKhachHang = {"Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Email", "Điểm tích lũy", "Tổng tiền mua"};
		modelKhachHang = new DefaultTableModel(colsKhachHang, 0);
		tableKhachHang = new MyTable(modelKhachHang);
		JScrollPane srcTbKhachHang = new JScrollPane(tableKhachHang);
		srcTbKhachHang.setBounds(10, 40, 704, 431);
		tableKhachHang.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableKhachHang.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableKhachHang.getColumnModel().getColumn(1).setPreferredWidth(151);
		tableKhachHang.getColumnModel().getColumn(2).setPreferredWidth(150);
		tableKhachHang.getColumnModel().getColumn(3).setPreferredWidth(200);
		tableKhachHang.getColumnModel().getColumn(4).setPreferredWidth(100);
		tableKhachHang.getColumnModel().getColumn(5).setPreferredWidth(150);
		modelKhachHang.addRow(new Object[] {"KH1", "Nguyễn Văn A", "0353426938", "hbao27121@gmail.com", "10", "1.000.000"});
		panel_1.add(srcTbKhachHang);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(742, 304, 535, 481);
		add(panel_1_1);
		
		JLabel lblLchSGiao = new JLabel("Lịch sử giao dịch");
		lblLchSGiao.setForeground(Color.GRAY);
		lblLchSGiao.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLchSGiao.setBounds(10, 10, 167, 20);
		panel_1_1.add(lblLchSGiao);
		
		String[] colsLichSuGD = {"Mã hóa đơn", "Mã NV", "Tên NV", "Ngày giao dịch", "Thành tiền"};
		modelLichSuGD = new DefaultTableModel(colsLichSuGD, 0);
		tableLichSuGD = new MyTable(modelLichSuGD);
		JScrollPane srcTbLichSuGD = new JScrollPane(tableLichSuGD);
		srcTbLichSuGD.setBounds(10, 40, 515, 431);
		panel_1_1.add(srcTbLichSuGD);
	}
}
