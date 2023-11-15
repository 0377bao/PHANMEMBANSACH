package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import bus.BUSDanhMuc;
import customUI.MyButton;
import customUI.MyCombobox;
import entity.DanhMuc;

public class GUIDanhMuc extends JFrame implements ActionListener {
	private JTextField txtMaDanhMuc;
	private JTextField txtTenDanhMuc;
	private MyButton btnTaoMa;
	private MyButton btnThemDanhMuc;
	private MyCombobox cboDanhMuc;

	BUSDanhMuc busDanhMuc = new BUSDanhMuc();

	public GUIDanhMuc(MyCombobox cboDanhMuc) {
		this.cboDanhMuc = cboDanhMuc;
		this.setSize(600, 200);
		this.setTitle("Thêm danh mục");
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(31, 20, 533, 104);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblMaDanhMuc = new JLabel("Mã danh mục");
		lblMaDanhMuc.setBounds(20, 27, 100, 20);
		lblMaDanhMuc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblMaDanhMuc);

		txtMaDanhMuc = new JTextField();
		txtMaDanhMuc.setEditable(false);
		txtMaDanhMuc.setEnabled(false);
		txtMaDanhMuc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMaDanhMuc.setBounds(135, 24, 295, 24);
		panel.add(txtMaDanhMuc);
		txtMaDanhMuc.setColumns(10);

		JLabel lblTenDanhMuc = new JLabel("Tên danh mục");
		lblTenDanhMuc.setBounds(20, 66, 100, 20);
		lblTenDanhMuc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblTenDanhMuc);

		txtTenDanhMuc = new JTextField();
		txtTenDanhMuc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTenDanhMuc.setColumns(10);
		txtTenDanhMuc.setBounds(135, 66, 295, 24);
		panel.add(txtTenDanhMuc);

		btnTaoMa = new MyButton("Tạo mã");
		btnTaoMa.setBounds(453, 24, 70, 24);
		panel.add(btnTaoMa);

		btnThemDanhMuc = new MyButton("Thêm");
		btnThemDanhMuc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnThemDanhMuc.setBounds(228, 131, 100, 25);
		getContentPane().add(btnThemDanhMuc);

		btnThemDanhMuc.addActionListener(this);
		btnTaoMa.addActionListener(this);

	}

	public void taoMa() {
		txtMaDanhMuc.setText(busDanhMuc.taoMa());
	}

	public void themDanhMuc() {
		String ma = txtMaDanhMuc.getText().trim();
		String ten = txtTenDanhMuc.getText().trim();
		if (busDanhMuc.validData(ma, ten)) {
			DanhMuc dm = new DanhMuc(ma, ten);
			if (busDanhMuc.themDanhMuc(dm)) {
				JOptionPane.showMessageDialog(this, "Thêm thành công");
				ArrayList<DanhMuc> dsDanhMuc = busDanhMuc.layDSDanhMuc();
				cboDanhMuc.removeAllItems();
				for (DanhMuc danhMuc : dsDanhMuc) {
					cboDanhMuc.addItem(danhMuc.getMaDanhMuc());
				}
				this.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(this, "Mã danh mục đã tồn tại");
			}
		} else {
			JOptionPane.showMessageDialog(this, busDanhMuc.mes);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnTaoMa)) {
			taoMa();
		} else if (o.equals(btnThemDanhMuc)) {
			themDanhMuc();
		}
	}
}
