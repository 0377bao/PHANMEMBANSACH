package ui;


import java.awt.Color;

import javax.lang.model.SourceVersion;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.tools.Tool;

import bus.BUSGiaoHang;
import bus.BUSHoaDon;
import controller.ControllerGiaoHang;
import customUI.MyButton;
import customUI.MyCombobox;
import customUI.MyTable;
import entity.DonGiaoHang;
import entity.HoaDon;
import tool.Tools;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class GUIGiaoHang extends JPanel implements MouseListener, KeyListener{
		private JTextField txtTKMaDonHang;
		private JTextField txtTKTenNhanVienGH;
		private JTextField txtTKTenKhachHang;
		private DefaultTableModel model, modelQLDonHangHT, modelQLDonHangCHT;
		private MyTable tbDonHang, tbTabQLDonHang;
		private JScrollPane scrollPaneQLGH;
		private MyCombobox cboLocDonHang, cboPTTT;
        private JPanel pnlQuanLyDonHang, pnlGiaoHang;
        private MyButton btnHuyDon, btnThanhCong, btnInPhieuDonHang, btnTaoMaDonHang, btnTaoDonHang, btnHuyTaoDon, btnXoaTrang, btnSapXep, btnTinhKhoangCach;
        private JTextField txtDiaChi;
        private JTextField txtSDT;
        private JTextField txtTenKhachHang;
        private JTextField txtMaDonHang;
        private JTextField txtMaHoaDon;
        private JTextField txtNgayLap;
        private JTextField txtTenNVLapHD;
        private JTextField txtSoKG;
        private JTextField txtSoKM;
        private JTextField txtChaHonThnh;
        private JTextField txtThanhTien;
        private JTextField txtMaDonHangQL;
        private JTextField txtSDTQL;
        private JTextField txtTenKhachHangQL;
        private HoaDon hd;
        private JTextArea txtArea;
        private BUSGiaoHang busGiaoHang = new BUSGiaoHang();
		public GUIGiaoHang(HoaDon HD) {
			this.hd = HD;
			this.setBackground(new Color(255, 255, 255));
			this.setBounds(250, 0, 1250, 800);
			this.setLayout(null);
			
			JTabbedPane tabbedPane = new JTabbedPane();
			tabbedPane.setBounds(21, 0, 1245, 789);
			
			// tab giao hàng
			pnlGiaoHang = new JPanel();
			pnlGiaoHang.setBackground(new Color(255, 255, 255));
			pnlGiaoHang.setBounds(20, 0, 1195, 800);
			
			
			pnlGiaoHang.setBounds(20, 0, 1195, 800);
			
			tabbedPane.add("Giao Hàng", pnlGiaoHang);
			pnlGiaoHang.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel.setBounds(10, 11, 1220, 219);
			pnlGiaoHang.add(panel);
			panel.setLayout(null);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel_3.setBackground(new Color(255, 255, 255));
			panel_3.setBounds(10, 11, 393, 197);
			panel.add(panel_3);
			panel_3.setLayout(null);
			
			JLabel lblMaDonHang = new JLabel("Mã đơn hàng");
			lblMaDonHang.setBounds(10, 37, 88, 17);
			panel_3.add(lblMaDonHang);
			
			JLabel lblMaHoaDon = new JLabel("Mã hóa đơn");
			lblMaHoaDon.setBounds(10, 67, 76, 17);
			panel_3.add(lblMaHoaDon);
			
			JLabel lblNgayLap = new JLabel("Ngày lập");
			lblNgayLap.setBounds(10, 99, 76, 17);
			panel_3.add(lblNgayLap);
			
			JLabel lblNewLabel_2 = new JLabel("Tên nhân viên lập hóa đơn");
			lblNewLabel_2.setBounds(10, 130, 153, 17);
			panel_3.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Thông tin đơn hàng");
			lblNewLabel_3.setForeground(new Color(255, 128, 0));
			lblNewLabel_3.setBackground(new Color(255, 255, 255));
			lblNewLabel_3.setBounds(151, 6, 141, 17);
			panel_3.add(lblNewLabel_3);
			
			JLabel lblPTTT = new JLabel("Phương thức thanh toán");
			lblPTTT.setBounds(10, 162, 153, 17);
			panel_3.add(lblPTTT);
			
			txtMaDonHang = new JTextField();
			txtMaDonHang.setEditable(false);
			txtMaDonHang.setBounds(173, 34, 200, 20);
			panel_3.add(txtMaDonHang);
			txtMaDonHang.setColumns(10);
			
			txtMaHoaDon = new JTextField();
			txtMaHoaDon.setEditable(false);
			txtMaHoaDon.setBounds(173, 64, 200, 20);
			panel_3.add(txtMaHoaDon);
			txtMaHoaDon.setColumns(10);
			
			txtNgayLap = new JTextField();
			txtNgayLap.setEditable(false);
			txtNgayLap.setBounds(173, 96, 200, 20);
			panel_3.add(txtNgayLap);
			txtNgayLap.setColumns(10);
			
			txtTenNVLapHD = new JTextField();
			txtTenNVLapHD.setEditable(false);
			txtTenNVLapHD.setBounds(173, 128, 200, 20);
			panel_3.add(txtTenNVLapHD);
			txtTenNVLapHD.setColumns(10);
			
			cboPTTT = new MyCombobox();
			cboPTTT.setBounds(173, 159, 200, 22);
			cboPTTT.addItem("Tiền mặt");
			cboPTTT.addItem("Chuyển khoản");
			panel_3.add(cboPTTT);
			
			JPanel panel_4 = new JPanel();
			panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel_4.setBackground(new Color(255, 255, 255));
			panel_4.setBounds(413, 11, 404, 197);
			panel.add(panel_4);
			panel_4.setLayout(null);
			
			JLabel lblTenKhachHang = new JLabel("Tên khách hàng");
			lblTenKhachHang.setBounds(22, 36, 103, 17);
			panel_4.add(lblTenKhachHang);
			
			JLabel lblDiaChi = new JLabel("Địa chỉ");
			lblDiaChi.setBounds(22, 100, 46, 17);
			panel_4.add(lblDiaChi);
			
			JLabel lblSDT = new JLabel("SĐT");
			lblSDT.setBounds(22, 67, 46, 17);
			panel_4.add(lblSDT);
			
			JLabel lblGhiChu = new JLabel("Ghi chú");
			lblGhiChu.setBounds(22, 136, 46, 17);
			panel_4.add(lblGhiChu);
			
			JLabel lblNewLabel_4 = new JLabel("Thông tin khách hàng");
			lblNewLabel_4.setForeground(new Color(255, 128, 0));
			lblNewLabel_4.setBounds(150, 6, 160, 17);
			panel_4.add(lblNewLabel_4);
			
			txtArea = new JTextArea();
			txtArea.setEditable(false);
			txtArea.setBackground(new Color(192, 192, 192));
			txtArea.setBounds(133, 137, 240, 49);
			panel_4.add(txtArea);
			
			txtDiaChi = new JTextField();
			txtDiaChi.setEditable(false);
			txtDiaChi.setBounds(133, 97, 240, 20);
			panel_4.add(txtDiaChi);
			txtDiaChi.setColumns(10);
			
			txtSDT = new JTextField();
			txtSDT.setBounds(133, 64, 240, 20);
			panel_4.add(txtSDT);
			txtSDT.setColumns(10);
			
			txtTenKhachHang = new JTextField();
			txtTenKhachHang.setBounds(133, 33, 240, 20);
			panel_4.add(txtTenKhachHang);
			txtTenKhachHang.setColumns(10);
			
			JPanel panel_5 = new JPanel();
			panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel_5.setBackground(new Color(255, 255, 255));
			panel_5.setBounds(827, 11, 383, 197);
			panel.add(panel_5);
			panel_5.setLayout(null);
			
			JLabel lblNewLabel_5 = new JLabel("Thông tin giao hàng");
			lblNewLabel_5.setForeground(new Color(255, 128, 0));
			lblNewLabel_5.setBounds(161, 6, 149, 17);
			panel_5.add(lblNewLabel_5);
			
			JLabel lblSoKm = new JLabel("Số KM");
			lblSoKm.setBounds(10, 70, 46, 17);
			panel_5.add(lblSoKm);
			
			JLabel lblSoKg = new JLabel("Số KG");
			lblSoKg.setBounds(10, 37, 46, 17);
			panel_5.add(lblSoKg);
			
			JLabel lblTrangThai = new JLabel("Trạng thái");
			lblTrangThai.setBounds(10, 110, 82, 17);
			panel_5.add(lblTrangThai);
			
			JLabel lblVanChuyen = new JLabel("Tiền vận chuyển");
			lblVanChuyen.setBounds(10, 150, 103, 17);
			panel_5.add(lblVanChuyen);
			
			
			btnTinhKhoangCach = new MyButton("Khoảng cách");
			btnTinhKhoangCach.setBounds(224, 66, 149, 27);
			panel_5.add(btnTinhKhoangCach);
			btnTinhKhoangCach.setBackground(new Color(255, 0, 0));
			btnTinhKhoangCach.setIcon(new ImageIcon("src\\image\\iconbtnGiaoHang\\iconmap.png"));
			
			txtSoKG = new JTextField();
			txtSoKG.setBounds(117, 34, 256, 20);
			panel_5.add(txtSoKG);
			txtSoKG.setColumns(10);
			
			txtSoKM = new JTextField();
			txtSoKM.setEditable(false);
			txtSoKM.setBounds(117, 66, 97, 20);
			panel_5.add(txtSoKM);
			txtSoKM.setColumns(10);
			
			txtChaHonThnh = new JTextField();
			txtChaHonThnh.setEditable(false);
			txtChaHonThnh.setText("Chưa hoàn thành");
			txtChaHonThnh.setBounds(117, 107, 256, 20);
			panel_5.add(txtChaHonThnh);
			txtChaHonThnh.setColumns(10);
			
			txtThanhTien = new JTextField();
			txtThanhTien.setHorizontalAlignment(SwingConstants.RIGHT);
			txtThanhTien.setForeground(new Color(255, 128, 64));
			txtThanhTien.setEditable(false);
			txtThanhTien.setFont(new Font("Tahoma", Font.BOLD, 16));
			txtThanhTien.setText(new Tools().dinhDangTien(0));
			txtThanhTien.setBackground(new Color(255, 255, 255));
			txtThanhTien.setBounds(117, 147, 256, 20);
			panel_5.add(txtThanhTien);
			txtThanhTien.setColumns(10);
			
			btnTaoDonHang = new MyButton("Tạo đơn hàng");
			
			btnTaoDonHang.setBackground(new Color(97, 166, 247));
			btnTaoDonHang.setBounds(1059, 247, 157, 30);
			btnTaoDonHang.setIcon(new ImageIcon("src\\image\\iconbtnGiaoHang\\icongiaohang.png"));
			pnlGiaoHang.add(btnTaoDonHang);
			
			btnTaoMaDonHang = new MyButton("Tạo mã đơn hàng");
			
			btnTaoMaDonHang.setBackground(new Color(97, 166, 247));
			btnTaoMaDonHang.setBounds(857, 247, 157, 30);
			btnTaoMaDonHang.setIcon(new ImageIcon("src\\image\\iconbtnGiaoHang\\iconqr.png"));
			pnlGiaoHang.add(btnTaoMaDonHang);
			
			btnInPhieuDonHang = new MyButton("In phiếu đơn hàng");
			btnInPhieuDonHang.setBackground(new Color(97, 166, 247));
			btnInPhieuDonHang.setBounds(661, 247, 157, 30);
			btnInPhieuDonHang.setIcon(new ImageIcon("src\\image\\iconbtnGiaoHang\\iconprint.png"));
			pnlGiaoHang.add(btnInPhieuDonHang);
			
			btnHuyTaoDon = new MyButton("In phiếu đơn hàng");
			btnHuyTaoDon.setText("Hủy tạo đơn");
			btnHuyTaoDon.setBackground(new Color(97, 166, 247));
			btnHuyTaoDon.setBounds(467, 247, 157, 30);
			btnHuyTaoDon.setIcon(new ImageIcon("src\\image\\iconbtnGiaoHang\\iconcancel.png"));
			pnlGiaoHang.add(btnHuyTaoDon);
			
			JLabel lblTìmKiem = new JLabel("Tìm kiếm");
			lblTìmKiem.setBounds(10, 290, 72, 14);
			pnlGiaoHang.add(lblTìmKiem);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel_1.setBounds(10, 315, 1220, 70);
			pnlGiaoHang.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblMaDonHangTK = new JLabel("Mã đơn hàng:");
			lblMaDonHangTK.setBounds(39, 29, 91, 14);
			panel_1.add(lblMaDonHangTK);
			
			txtTKMaDonHang = new JTextField();
			txtTKMaDonHang.setBounds(139, 26, 142, 20);
			panel_1.add(txtTKMaDonHang);
			txtTKMaDonHang.setColumns(10);
			
			JLabel lblTenNhanVienGHTK = new JLabel("Số điện thoại khách hàng:");
			lblTenNhanVienGHTK.setBounds(404, 29, 168, 14);
			panel_1.add(lblTenNhanVienGHTK);
			
			txtTKTenNhanVienGH = new JTextField();
			txtTKTenNhanVienGH.setBounds(582, 26, 142, 20);
			panel_1.add(txtTKTenNhanVienGH);
			txtTKTenNhanVienGH.setColumns(10);
			
			JLabel lblTenKhachHangTK = new JLabel("Tên khách hàng:");
			lblTenKhachHangTK.setBounds(849, 29, 114, 14);
			panel_1.add(lblTenKhachHangTK);
			
			txtTKTenKhachHang = new JTextField();
			txtTKTenKhachHang.setBounds(984, 26, 142, 20);
			panel_1.add(txtTKTenKhachHang);
			txtTKTenKhachHang.setColumns(10);
			
			JLabel lblDSDonGiaoHang = new JLabel("Danh sách đơn hàng đang giao ");
			lblDSDonGiaoHang.setBounds(10, 404, 199, 14);
			pnlGiaoHang.add(lblDSDonGiaoHang);
			
			
			model = new DefaultTableModel(new Object[] {"Mã đơn hàng","Mã hóa đơn","Tên nhân viên lập hóa đơn", "Ngày lập", "Tên khách hàng", "Địa chỉ", "SĐT", "Trọng lượng", "Tiền vận chuyển", "Trạng thái"}, 0);
//			model.addRow(new Object[] {"DGH1", "Trần Quang","18/10/2023", "Trần Hữu Danh", "Tây Thạnh Tân Phú Tp.Hồ Chí Minh", "0332966175", "5","25.000", "Chưa hoàn thành"});
//			model.addRow(new Object[] {"DGH1", "Trần Quang","18/10/2023", "Trần Hữu Danh", "Tây Thạnh Tân Phú Tp.Hồ Chí Minh", "0332966175", "5","25.000", "Chưa hoàn thành"});
//			model.addRow(new Object[] {"DGH1", "Trần Quang", "18/10/2023", "Trần Hữu Danh", "Tây Thạnh Tân Phú Tp.Hồ Chí Minh", "0332966175", "5","25.000", "Chưa hoàn thành"});
//			model.addRow(new Object[] {"DGH1", "Trần Quang", "18/10/2023", "Trần Hữu Danh", "Tây Thạnh Tân Phú Tp.Hồ Chí Minh", "0332966175", "5","25.000", "Chưa hoàn thành"});
//			model.addRow(new Object[] {"DGH1", "Trần Quang","18/10/2023", "Trần Hữu Danh", "Tây Thạnh Tân Phú Tp.Hồ Chí Minh", "0332966175", "5","25.000", "Chưa hoàn thành"});
//			model.addRow(new Object[] {"DGH1", "Trần Quang","18/10/2023", "Trần Hữu Danh", "Tây Thạnh Tân Phú Tp.Hồ Chí Minh", "0332966175", "5","25.000", "Chưa hoàn thành"});
//			model.addRow(new Object[] {"DGH1", "Trần Quang", "18/10/2023", "Trần Hữu Danh", "Tây Thạnh Tân Phú Tp.Hồ Chí Minh", "0332966175", "5","25.000", "Chưa hoàn thành"});
//			model.addRow(new Object[] {"DGH1", "Trần Quang","18/10/2023", "Trần Hữu Danh", "Tây Thạnh Tân Phú Tp.Hồ Chí Minh", "0332966175", "5","25.000", "Chưa hoàn thành"});
//			model.addRow(new Object[] {"DGH1", "Trần Quang", "18/10/2023", "Trần Hữu Danh", "Tây Thạnh Tân Phú Tp.Hồ Chí Minh", "0332966175", "5","25.000", "Chưa hoàn thành"});
//			model.addRow(new Object[] {"DGH1", "Trần Quang", "18/10/2023", "Trần Hữu Danh", "Tây Thạnh Tân Phú Tp.Hồ Chí Minh", "0332966175", "5","25.000", "Chưa hoàn thành"});
//			model.addRow(new Object[] {"DGH1", "Trần Quang", "18/10/2023", "Trần Hữu Danh", "Tây Thạnh Tân Phú Tp.Hồ Chí Minh", "0332966175", "5","25.000", "Chưa hoàn thành"});
//			model.addRow(new Object[] {"DGH1", "Trần Quang", "18/10/2023", "Trần Hữu Danh", "Tây Thạnh Tân Phú Tp.Hồ Chí Minh", "0332966175", "5","25.000", "Chưa hoàn thành"});
//			model.addRow(new Object[] {"DGH1", "Trần Quang", "18/10/2023", "Trần Hữu Danh", "Tây Thạnh Tân Phú Tp.Hồ Chí Minh", "0332966175", "5","25.000", "Chưa hoàn thành"});
//			model.addRow(new Object[] {"DGH1", "Trần Quang", "18/10/2023", "Trần Hữu Danh", "Tây Thạnh Tân Phú Tp.Hồ Chí Minh", "0332966175", "5","25.000", "Chưa hoàn thành"});
//			model.addRow(new Object[] {"DGH1", "Trần Quang", "18/10/2023", "Trần Hữu Danh", "Tây Thạnh Tân Phú Tp.Hồ Chí Minh", "0332966175", "5","25.000", "Chưa hoàn thành"});
//			model.addRow(new Object[] {"DGH1", "Trần Quang", "18/10/2023", "Trần Hữu Danh", "Tây Thạnh Tân Phú Tp.Hồ Chí Minh", "0332966175", "5","25.000", "Chưa hoàn thành"});
//			model.addRow(new Object[] {"DGH1", "Trần Quang", "18/10/2023", "Trần Hữu Danh", "Tây Thạnh Tân Phú Tp.Hồ Chí Minh", "0332966175", "5","25.000", "Chưa hoàn thành"});
			loaddulieulentable(model);
			tbDonHang = new MyTable(model);
			tbDonHang.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			
			for (int i = 0 ; i < tbDonHang.getColumnCount() ; i++) {
				tbDonHang.getColumnModel().getColumn(i).setPreferredWidth(250);
			}
			
			JScrollPane scrollPane = new JScrollPane(tbDonHang, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setBounds(10, 429, 1220, 280);
			pnlGiaoHang.add(scrollPane);
			
			btnThanhCong = new MyButton("Thành công");
			btnThanhCong.setBackground(new Color(0, 255, 128));
			
			btnThanhCong.setBounds(645, 720, 163, 30);
			btnThanhCong.setIcon(new ImageIcon("src\\image\\iconbtnGiaoHang\\iconsuccesfull.png"));
			pnlGiaoHang.add(btnThanhCong);
			
			btnHuyDon = new MyButton("Bị hủy");
			btnHuyDon.setBackground(new Color(255, 128, 128));
			btnHuyDon.setBounds(391, 720, 163, 30);
			pnlGiaoHang.add(btnHuyDon);
			
			btnXoaTrang = new MyButton("In phiếu đơn hàng");
			btnXoaTrang.setText("Xóa trắng");
			btnXoaTrang.setBackground(new Color(97, 166, 247));
			btnXoaTrang.setBounds(272, 247, 157, 30);
			pnlGiaoHang.add(btnXoaTrang);
			
	
			
			// ghi chu
			// tab quản lý giao hàng
			pnlQuanLyDonHang = new JPanel();
			pnlQuanLyDonHang.setBackground(new Color(255, 255, 255));
			
			tabbedPane.add("Quản Lý Đơn Hàng",pnlQuanLyDonHang);
			pnlQuanLyDonHang.setLayout(null);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(200, 221, 242));
			panel_2.setBounds(10, 141, 305, 38);
			pnlQuanLyDonHang.add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Danh sách hóa đơn giao hàng");
			lblNewLabel.setBackground(new Color(200, 221, 242));
			lblNewLabel.setBounds(10, 8, 285, 23);
			panel_2.add(lblNewLabel);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			
			JLabel lblNewLabel_1 = new JLabel("Lọc:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(968, 154, 51, 25);
			pnlQuanLyDonHang.add(lblNewLabel_1);
			
			cboLocDonHang = new MyCombobox();
			cboLocDonHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
			cboLocDonHang.setBounds(1057, 155, 173, 22);
			cboLocDonHang.addItem("Hoàn thành");
			cboLocDonHang.addItem("Chưa hoàn thành");
			
			
			pnlQuanLyDonHang.add(cboLocDonHang);
			
			// table model đơn hàng chưa hoàn thành
            modelQLDonHangCHT = new DefaultTableModel(new Object[] {"Mã đơn hàng","Mã hóa đơn","Tên nhân viên lập hóa đơn","Ngày lập", "Tên khách hàng", "Địa chỉ", "SĐT", "Trọng lượng", "Tiền vận chuyển", "Trạng thái", "Ghi chú"}, 0);
			
			modelQLDonHangHT = new DefaultTableModel(new Object[] {"Mã đơn hàng","Mã hóa đơn","Tên nhân viên lập hóa đơn","Ngày lập", "Tên khách hàng", "Địa chỉ", "SĐT", "Trọng lượng", "Tiền vận chuyển", "Trạng thái"}, 0);
			tbTabQLDonHang = new MyTable(modelQLDonHangHT);
			loaddulieulentableTabQL(modelQLDonHangHT);
//			modelQLDonHangHT.addRow(new Object[] {"DGH1", "Trần Quang", "18/10/2023", "Trần Hữu Danh", "Tây Thạnh Tân Phú Tp.Hồ Chí Minh", "0332966175", "5","25.000", "Hoàn thành"});
//			modelQLDonHangHT.addRow(new Object[] {"DGH1", "Trần Quang", "18/10/2023", "Trần Hữu Danh", "Tây Thạnh Tân Phú Tp.Hồ Chí Minh", "0332966175", "5","25.000", "Hoàn thành"});
//			modelQLDonHangHT.addRow(new Object[] {"DGH1", "Trần Quang", "18/10/2023", "Trần Hữu Danh", "Tây Thạnh Tân Phú Tp.Hồ Chí Minh", "0332966175", "5","25.000", "Hoàn thành"});
//			modelQLDonHangHT.addRow(new Object[] {"DGH1", "Trần Quang", "18/10/2023", "Trần Hữu Danh", "Tây Thạnh Tân Phú Tp.Hồ Chí Minh", "0332966175", "5","25.000", "Hoàn thành"});
//			modelQLDonHangHT.addRow(new Object[] {"DGH1", "Trần Quang",  "18/10/2023", "Trần Hữu Danh", "Tây Thạnh Tân Phú Tp.Hồ Chí Minh", "0332966175", "5","25.000", "Hoàn thành"});
//			modelQLDonHangHT.addRow(new Object[] {"DGH1", "Trần Quang", "18/10/2023", "Trần Hữu Danh", "Tây Thạnh Tân Phú Tp.Hồ Chí Minh", "0332966175", "5","25.000", "Hoàn thành"});
//			modelQLDonHangHT.addRow(new Object[] {"DGH1", "Trần Quang", "18/10/2023", "Trần Hữu Danh", "Tây Thạnh Tân Phú Tp.Hồ Chí Minh", "0332966175", "5","25.000", "Hoàn thành"});
//			modelQLDonHangHT.addRow(new Object[] {"DGH1", "Trần Quang", "18/10/2023", "Trần Hữu Danh", "Tây Thạnh Tân Phú Tp.Hồ Chí Minh", "0332966175", "5","25.000", "Hoàn thành"});
		    tbTabQLDonHang.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		    for(int i = 0 ; i < tbTabQLDonHang.getColumnCount() ; i++) {
		    	tbTabQLDonHang.getColumnModel().getColumn(i).setPreferredWidth(250);
		    }
			
			scrollPaneQLGH = new JScrollPane(tbTabQLDonHang, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollPaneQLGH.setBounds(10, 204, 1220, 546);
			
			pnlQuanLyDonHang.add(scrollPaneQLGH);
			
			JPanel panel_6 = new JPanel();
			panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel_6.setBounds(10, 52, 1220, 69);
			pnlQuanLyDonHang.add(panel_6);
			panel_6.setLayout(null);
			
			JLabel lblNewLabel_14 = new JLabel("Mã đơn hàng:");
			lblNewLabel_14.setBounds(32, 30, 87, 14);
			panel_6.add(lblNewLabel_14);
			
			txtMaDonHangQL = new JTextField();
			txtMaDonHangQL.setBounds(129, 27, 130, 20);
			panel_6.add(txtMaDonHangQL);
			txtMaDonHangQL.setColumns(10);
			
			JLabel lblNewLabel_16 = new JLabel("Số điện thoại khách hàng:");
			lblNewLabel_16.setBounds(315, 30, 173, 14);
			panel_6.add(lblNewLabel_16);
			
			txtSDTQL = new JTextField();
			txtSDTQL.setBounds(498, 28, 130, 20);
			panel_6.add(txtSDTQL);
			txtSDTQL.setColumns(10);
			
			JLabel lblNewLabel_17 = new JLabel("Tên khách hàng:");
			lblNewLabel_17.setBounds(698, 30, 98, 14);
			panel_6.add(lblNewLabel_17);
			
			txtTenKhachHangQL = new JTextField();
			txtTenKhachHangQL.setBounds(823, 28, 130, 20);
			panel_6.add(txtTenKhachHangQL);
			txtTenKhachHangQL.setColumns(10);
			
			btnSapXep = new MyButton("Sắp xếp theo tổng tiền");
			btnSapXep.setBounds(1015, 18, 184, 30);
			panel_6.add(btnSapXep);
			
			JPanel panel_7 = new JPanel();
			panel_7.setBackground(new Color(200, 221, 242));
			panel_7.setBounds(10, 11, 149, 27);
			pnlQuanLyDonHang.add(panel_7);
			panel_7.setLayout(null);
			
			JLabel lblNewLabel_13 = new JLabel("Chức năng");
			lblNewLabel_13.setBackground(new Color(200, 221, 242));
			lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_13.setBounds(21, 4, 102, 20);
			panel_7.add(lblNewLabel_13);
			
			cboLocDonHang.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					chuyenDoiTable();
				}
			});
			add(tabbedPane);
			
			XuLyKhiCoDonHang();
			// đăng kí sự kiện cho các nút
			ActionListener ac = new ControllerGiaoHang(this);
			btnTaoDonHang.addActionListener(ac);
			btnXoaTrang.addActionListener(ac);
			btnTaoMaDonHang.addActionListener(ac);
			btnHuyDon.addActionListener(ac);
			btnInPhieuDonHang.addActionListener(ac);
			btnHuyTaoDon.addActionListener(ac);
			btnSapXep.addActionListener(ac);
			btnTinhKhoangCach.addActionListener(ac);
			btnThanhCong.addActionListener(ac);
			
			// đăng kí sự kiện cho table
			tbDonHang.addMouseListener(this);
			
			// đăng kí sự kiện cho các textfield tìm kiếm
			txtMaDonHangQL.addKeyListener(this);
	}
		
		public void XuLyKhiCoDonHang() {
			if(hd == null) {
				btnTaoDonHang.setEnabled(false);
			}else {
				txtMaHoaDon.setText(hd.getMaHoaDon());
				txtTenNVLapHD.setText(hd.getNhanVien().getTenNhanVien());
				txtNgayLap.setText(hd.getNgayLap().toString());
			}
		}
		
		
		public void chuyenDoiTable() {
			int index = cboLocDonHang.getSelectedIndex();
			 
			if(index == 0) {
				modelQLDonHangHT.setRowCount(0);
				loaddulieulentableTabQL(modelQLDonHangHT);
				
				tbTabQLDonHang.setModel(modelQLDonHangHT);
				tbTabQLDonHang.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			    for(int i = 0 ; i < tbTabQLDonHang.getColumnCount() ; i++) {
			    	
			    	tbTabQLDonHang.getColumnModel().getColumn(i).setPreferredWidth(250);
			    }  
			}
			if(index == 1) {
				modelQLDonHangCHT.setRowCount(0);
				loaddulieulentableTabQL(modelQLDonHangCHT);
				tbTabQLDonHang.setModel(modelQLDonHangCHT);
				tbTabQLDonHang.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			    for(int i = 0 ; i < tbTabQLDonHang.getColumnCount() ; i++) {
			    	tbTabQLDonHang.getColumnModel().getColumn(i).setPreferredWidth(250);
			    }  
			}
		}
		
		
	    public void XuLyDonHang(String src) {
	    	if(src.equals("Tạo đơn hàng")) {
	    		String maDonHang = txtMaDonHang.getText();
	    		String maHoaDon = txtMaHoaDon.getText();
                hd = new BUSHoaDon().timHoaDonTheoMa(maHoaDon);
	    		Date ngayLap = Date.valueOf(LocalDate.now());
	    		String phuongThucThanhToan = cboPTTT.getSelectedItem().toString();
	    		String sdt = txtSDT.getText();
	    		String tenKhachHang = txtTenKhachHang.getText();
	    		String diaChi = txtDiaChi.getText();
	    		String ghiChu = txtArea.getText();
	    		int sokg = Integer.parseInt(txtSoKG.getText());
	    		float soKm = Float.parseFloat(txtSoKM.getText());
	    		String temp = txtThanhTien.getText().replace(',', ' ');
	    		float tienVanChuyen = Float.parseFloat(temp.substring(0, temp.length() - 3).replaceAll(" ", ""));
	    	    boolean trangThai = txtChaHonThnh.getText().equals("Chưa hoàn thành") ? false : true;
	    	    DonGiaoHang dgh = new DonGiaoHang(maDonHang, tenKhachHang, sdt, diaChi, sokg, trangThai, ghiChu, tienVanChuyen,phuongThucThanhToan, hd);
	    	    dgh.tinhSoKm(soKm);
	    		if(busGiaoHang.themDonHangMoi(dgh)) {
	    			JOptionPane.showMessageDialog(this, "Tạo đơn hàng thành công");
	    		}else {
	    			JOptionPane.showMessageDialog(this, "Tạo đơn hàng thất bại");
	    		}
	    	}
	    	if(src.equals("Xóa trắng")) {
	    		txtTenKhachHang.setText("");
	    		txtSDT.setText("");
	    		txtSoKG.setText("");
	    		txtDiaChi.setText("");
	    		txtSoKM.setText("");
	    		txtThanhTien.setText("");
	    	}
	    	if(src.equals("Hủy tạo đơn")) {
	    		xoaTrangThongTinDonHang();
	    	}
	    	if(src.equals("Tạo mã đơn hàng")) {            
	    		txtMaDonHang.setText(busGiaoHang.taoMaDonHang());
	    	}
	    	if(src.equals("Khoảng cách")) {
	    		GUIMap mapui = new GUIMap(this);
	    		mapui.setVisible(true);	
	    	}
	    	if(src.equals("Bị hủy")) {
	    		int index = tbDonHang.getSelectedRow();
	    		String maDH = model.getValueAt(index, 0).toString();
	    		DonGiaoHang dghCT = new BUSGiaoHang().timDonHangTheoMaDonHang(maDH);
	    	    String ghiChu = JOptionPane.showInputDialog(this, "Nhập lý do đơn hàng bị hủy");
	    		dghCT.setGhiChu(ghiChu);
	    		modelQLDonHangCHT.addRow(new Object[] {dghCT.getMaDonGiaoHang(), dghCT.getHoaDon().getMaHoaDon(), 
	    				dghCT.getHoaDon().getNhanVien().getTenNhanVien(), dghCT.getHoaDon().getNgayLap(),
	    				dghCT.getTenKhachHang(), dghCT.getDiaChi(), dghCT.getSdt(), dghCT.getSoKg(), dghCT.getTienVanChuyen(),
	                    dghCT.isTrangThai() == false ? "Chưa hoàn thành" : "", dghCT.getGhiChu()});
	    		if(new BUSGiaoHang().capNhatThongTinDonHang(dghCT)) {
	    			xoaTrangThongTinDonHang();
	    			JOptionPane.showMessageDialog(this, "Đơn hàng đã bị hủy");
	    			model.removeRow(index);
	    		}else {
	    			JOptionPane.showMessageDialog(this, "Hủy đơn hàng không thành công do gặp lỗi");
	    		}
	    	}
	    	if(src.equals("Thành công")) {
	    		int index = tbDonHang.getSelectedRow();
	    		String maDH = model.getValueAt(index, 0).toString();
	    		DonGiaoHang dghCT = new BUSGiaoHang().timDonHangTheoMaDonHang(maDH);
	    		dghCT.setTrangThai(true);
	    		modelQLDonHangHT.addRow(new Object[] {dghCT.getMaDonGiaoHang(), dghCT.getHoaDon().getMaHoaDon(), 
	    				dghCT.getHoaDon().getNhanVien().getTenNhanVien(), dghCT.getHoaDon().getNgayLap(),
	    				dghCT.getTenKhachHang(), dghCT.getDiaChi(), dghCT.getSdt(), dghCT.getSoKg(), dghCT.getTienVanChuyen(),
	                    dghCT.isTrangThai() ? "Thành công": ""});
	    		if(new BUSGiaoHang().capNhatThongTinDonHang(dghCT)) {
	    			xoaTrangThongTinDonHang();
	    			JOptionPane.showMessageDialog(this, "Đơn hàng giao thành công");
	    			model.removeRow(index);
	    		}
	    	}
	    	if(src.equals("Sắp xếp theo tổng tiền")) {
	    		System.out.println(1);
	    		ArrayList<DonGiaoHang> dsTemp = new BUSGiaoHang().sapXepTheoTongTienVanChuyen();
	    		System.out.println(dsTemp);
	    		modelQLDonHangCHT.setRowCount(0);
	    		modelQLDonHangHT.setRowCount(0);
	    		for(DonGiaoHang dgh : dsTemp) {
	    			if(cboLocDonHang.getSelectedIndex() == 0) {
	    				
	    				if(dgh.isTrangThai() == false && dgh.getGhiChu().equals("") == false) {
	    	    			modelQLDonHangCHT.addRow(new Object[] {dgh.getMaDonGiaoHang(), dgh.getHoaDon().getMaHoaDon(), 
	    		    				dgh.getHoaDon().getNhanVien().getTenNhanVien(), dgh.getHoaDon().getNgayLap(),
	    		    				dgh.getTenKhachHang(), dgh.getDiaChi(), dgh.getSdt(), dgh.getSoKg(), new Tools().dinhDangTien(dgh.getTienVanChuyen()),
	    		                    dgh.isTrangThai() == false ? "Chưa hoàn thành": "", dgh.getGhiChu()});
	    	    		}
	    			}
	    			if(cboLocDonHang.getSelectedIndex() == 1) {
	    				if(dgh.isTrangThai()) {
	    	    			modelQLDonHangHT.addRow(new Object[] {dgh.getMaDonGiaoHang(), dgh.getHoaDon().getMaHoaDon(), 
	    		    				dgh.getHoaDon().getNhanVien().getTenNhanVien(), dgh.getHoaDon().getNgayLap(),
	    		    				dgh.getTenKhachHang(), dgh.getDiaChi(), dgh.getSdt(), dgh.getSoKg(), new Tools().dinhDangTien(dgh.getTienVanChuyen()),
	    		                    dgh.isTrangThai() ? "Hoàn thành": ""});
	    	    		}
	    			}
	    		}
	    	}
	    }
	    
	    public void hoanThanhKM(String txt) {
	    	String km = xuLyChuoiKilomet(txt);
	    	txtSoKM.setText(km);
	    }
	    
	    public void layDiaChi(String diaDiem) {
	    	txtDiaChi.setText(diaDiem);
	    }
	    public void kiemTraDeDongMap(String src, GUIMap map) {
	    	if(src.equals("Hoàn tất")) {
	    		map.setVisible(false);
	    	}
	    }
	    
	    public void tinhThanhTienDH(String txtDH) {
	    	if(txtSoKG.getText().equals("") == false && txtSoKM.getText().equals("") == false) {
    			DonGiaoHang dh = new DonGiaoHang(txtDH, hd);
    			dh.tinhSoKm(Float.parseFloat(txtSoKM.getText()));
    			float result = dh.tinhTienVanChuyen();
    			System.out.println(result);
    			if(result == -1) {
    				JOptionPane.showMessageDialog(this, "Số kg đơn hàng dưới mức quy định nên không giao hàng");
    			}else if(result == 0){
    				JOptionPane.showMessageDialog(this, "Đơn hàng được vận chuyển miễn phí");
    				txtThanhTien.setText(new Tools().dinhDangTien(result) + "");
    			}
    			else{
    				txtThanhTien.setText(new Tools().dinhDangTien(result) + "");
    			}
    		}
	    }
	    
	    public String xuLyChuoiKilomet(String kilomet) {
	    	char[] c = kilomet.toCharArray();
	    	int index = 0;
	    	for(int i = 0 ; i < c.length ; i++) {
	    		if(c[i] == 'K') {
	    			index = i;
	    		}
	    	}
	    	return kilomet.substring(0, index);
	    }
	    
	    public void xoaTrangThongTinDonHang() {
	    	txtMaDonHang.setText("");
    		txtMaHoaDon.setText("");
    		txtTenNVLapHD.setText("");
    		txtTenKhachHang.setText("");
    		txtSDT.setText("");
    		txtSoKG.setText("");
    		txtDiaChi.setText("");
    		txtSoKM.setText("");
    		txtThanhTien.setText("");
    		txtNgayLap.setText("");
	    }
	    
	    public void loaddulieulentable(DefaultTableModel modelTemp) {
	    	ArrayList<DonGiaoHang> ds = new BUSGiaoHang().layDSDonGiaoHang();
	    	for(DonGiaoHang dgh : ds) {
	    		if(dgh.isTrangThai() == false && dgh.getGhiChu().equals("")) {
	    		modelTemp.addRow(new Object[] {dgh.getMaDonGiaoHang(), dgh.getHoaDon().getNhanVien().getTenNhanVien(),
	    									dgh.getHoaDon().getNgayLap(), dgh.getTenKhachHang(), dgh.getDiaChi(),
	    									dgh.getSdt(), dgh.getSoKg(), new Tools().dinhDangTien(dgh.getTienVanChuyen()), dgh.isTrangThai() ? "" : "chưa hoàn thành"});
	    		}
	    	}
	    }
	    
	    public void loaddulieulentableTabQL(DefaultTableModel modelTemp) {
	    	ArrayList<DonGiaoHang> ds = new BUSGiaoHang().layDSDonGiaoHang();
	    	for(DonGiaoHang dgh : ds) {
	    		if(dgh.isTrangThai() == false && dgh.getGhiChu().equals("") == false) {
	    			modelQLDonHangCHT.addRow(new Object[] {dgh.getMaDonGiaoHang(), dgh.getHoaDon().getMaHoaDon(), 
		    				dgh.getHoaDon().getNhanVien().getTenNhanVien(), dgh.getHoaDon().getNgayLap(),
		    				dgh.getTenKhachHang(), dgh.getDiaChi(), dgh.getSdt(), dgh.getSoKg(), new Tools().dinhDangTien(dgh.getTienVanChuyen()),
		                    dgh.isTrangThai() == false ? "Chưa hoàn thành": "", dgh.getGhiChu()});
	    		}
	    		if(dgh.isTrangThai()) {
	    			modelQLDonHangHT.addRow(new Object[] {dgh.getMaDonGiaoHang(), dgh.getHoaDon().getMaHoaDon(), 
		    				dgh.getHoaDon().getNhanVien().getTenNhanVien(), dgh.getHoaDon().getNgayLap(),
		    				dgh.getTenKhachHang(), dgh.getDiaChi(), dgh.getSdt(), dgh.getSoKg(), new Tools().dinhDangTien(dgh.getTienVanChuyen()),
		                    dgh.isTrangThai() ? "Hoàn thành": ""});
	    		}
	    	}
	    }
	    
	    public void timKiem() {
	    	String keyWord = txtTKMaDonHang.getText();
	    	ArrayList<DonGiaoHang> ds = new BUSGiaoHang().layDSDonGiaoHang();
	    	modelQLDonHangCHT.setRowCount(0);
	    	for(DonGiaoHang dgh : ds) {
	    		if(dgh.isTrangThai() == false && dgh.getGhiChu().equals("") == false) {
	    			String ma = dgh.getMaDonGiaoHang();
	    			if(ma.contains(keyWord)) {
	    				modelQLDonHangCHT.addRow(new Object[] {dgh.getMaDonGiaoHang(), dgh.getHoaDon().getMaHoaDon(), 
			    				dgh.getHoaDon().getNhanVien().getTenNhanVien(), dgh.getHoaDon().getNgayLap(),
			    				dgh.getTenKhachHang(), dgh.getDiaChi(), dgh.getSdt(), dgh.getSoKg(), dgh.getTienVanChuyen(),
			                    dgh.isTrangThai() == false ? "Chưa hoàn thành": "", dgh.getGhiChu()});
	    			}
	    		}
	    	}
	    }

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int index = tbDonHang.getSelectedRow();
			txtMaDonHang.setText(model.getValueAt(index, 0).toString());
			DonGiaoHang dgh = new BUSGiaoHang().timDonHangTheoMaDonHang(txtMaDonHang.getText());
			txtMaHoaDon.setText(dgh.getHoaDon().getMaHoaDon());
			txtNgayLap.setText(dgh.getHoaDon().getNgayLap() + "");
			txtTenNVLapHD.setText(dgh.getHoaDon().getNhanVien().getTenNhanVien());
			cboPTTT.setSelectedIndex(dgh.getPhuongThucThanhToan().equals("Tiền mặt") == true ? 0: 1);
			txtTenKhachHang.setText(dgh.getTenKhachHang());
			txtSDT.setText(dgh.getSdt());
			txtDiaChi.setText(dgh.getDiaChi());
			txtSoKG.setText(dgh.getSoKg() + "");
			txtSoKM.setText(dgh.getSoKm() + "");
			txtThanhTien.setText(new Tools().dinhDangTien(dgh.getTienVanChuyen()));
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

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			timKiem();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
}
