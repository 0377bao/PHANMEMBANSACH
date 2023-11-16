package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.security.GuardedObject;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

import bus.BUSChuongTrinhKhuyenMai;
import bus.BUSKhachHang;
import controller.ControllerChuongTrinhKhuyenMai;
import customUI.MyButton;
import customUI.MyCombobox;
import customUI.MyTable;
import dao.DAOMucKhuyenMai;
import entity.ChuongTrinhKhuyenMai;
import entity.KhachHang;
import entity.MucKhuyenMai;
import tool.phanLuong;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;

public class GUIKhuyenMai extends JPanel{
	private DefaultTableModel modelKMDT, modelDSKhuyenMai, modelChiTietKM;
	private JTextField txtMaCTKM;
	private JTextField txtPhanTram;
	private MyTable tbMucKhuyenMai, tbDSKhuyenMai, tbChiTietKM;
	private JTextField txtMaCTKMTK;
	private JTextField txtTenCTKMTK;
	private JTextField txtTrangThai;
	private MyButton btnApDungCT, btnLuu, btnThem, btnTaoMaCTKM;
	private MyCombobox cboTrangThai, cboSanPham, cboMucKM, cboTheLoai;
	private JTextArea txtAreaTenCTKM;
	private int viTriDongDuocChon = -1;
	private int soThuTuKhuyenMai = 0;
	private ArrayList<MucKhuyenMai> dsMucKhuyenMaiDangTao = new ArrayList<>();
	private JTextField txtMaDuocChon;
	
	private PopUp thongBao = new PopUp("Đang tiến hành gửi thống báo");
	public GUIKhuyenMai() {
		this.setBackground(new Color(255, 255, 255));
		this.setBounds(250, 0, 1250, 800);
		setLayout(null);
		
		modelKMDT = new DefaultTableModel(new Object[] {"Tên mục khuyến mãi", "Phần trăm"}, 0);
		
		modelDSKhuyenMai = new DefaultTableModel(new Object[] {"STT", "MaCTKM", "TenCTKM", "Trạng thái"}, 0);
		
		modelChiTietKM = new DefaultTableModel(new Object[] {"Tên mục khuyến mãi", "Phần trăm"}, 0);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(20, 0, 1245, 789);
		add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 549, 767);
		panel_2.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(97, 166, 247));
		panel_1.setBounds(60, 11, 433, 40);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chương trình khuyến mãi");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(89, 7, 245, 24);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MaCTKM:");
		lblNewLabel_1.setBounds(42, 62, 78, 14);
		panel.add(lblNewLabel_1);
		
		txtMaCTKM = new JTextField();
		txtMaCTKM.setEditable(false);
		txtMaCTKM.setBounds(153, 62, 315, 20);
		panel.add(txtMaCTKM);
		txtMaCTKM.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("TenCTKM:");
		lblNewLabel_2.setBounds(42, 98, 62, 14);
		panel.add(lblNewLabel_2);
		
		txtAreaTenCTKM = new JTextArea();
		txtAreaTenCTKM.setBackground(new Color(192, 192, 192));
		txtAreaTenCTKM.setBounds(153, 93, 315, 45);
		panel.add(txtAreaTenCTKM);
		
		btnLuu = new MyButton("Lưu");
		btnLuu.setBackground(new Color(97, 166, 247));
		btnLuu.setBounds(348, 183, 120, 30);
		btnLuu.setIcon(new ImageIcon("src\\image\\khuyenmai\\iconsave.png"));
		panel.add(btnLuu);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(23, 222, 500, 522);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Sản phẩm:");
		lblNewLabel_3.setBounds(34, 56, 63, 14);
		panel_3.add(lblNewLabel_3);
		
		cboSanPham = new MyCombobox();
		cboSanPham.setBounds(169, 52, 235, 22);
		cboSanPham.addItem("Sách");
		cboSanPham.addItem("Văn phòng phẩm");
		panel_3.add(cboSanPham);
		
		JLabel lblNewLabel_4 = new JLabel("Phần trăm:");
		lblNewLabel_4.setBounds(34, 95, 63, 14);
		panel_3.add(lblNewLabel_4);
		
		txtPhanTram = new JTextField();
		txtPhanTram.setBounds(169, 92, 235, 20);
		panel_3.add(txtPhanTram);
		txtPhanTram.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Thể loại:");
		lblNewLabel_5.setBounds(34, 137, 63, 14);
		panel_3.add(lblNewLabel_5);
		
		cboTheLoai = new MyCombobox();
		cboTheLoai.setBounds(169, 133, 235, 22);
		cboTheLoai.addItem("Chính trị");
		cboTheLoai.addItem("Giả tưởng");
		cboTheLoai.addItem("Giáo khoa");
		cboTheLoai.addItem("Kinh dị");
		cboTheLoai.addItem("Kinh tế");
		cboTheLoai.addItem("Lịch sử");
		cboTheLoai.addItem("Nấu ăn");
		cboTheLoai.addItem("Tâm lý");
		cboTheLoai.addItem("Tình cảm");
		cboTheLoai.addItem("Thiếu nhi");
		cboTheLoai.addItem("Truyện");
		cboTheLoai.addItem("Văn học nghệ thuật");
		panel_3.add(cboTheLoai);
		
		btnThem = new MyButton("Thêm");
		btnThem.setBackground(new Color(97, 166, 247));
		btnThem.setBounds(186, 194, 120, 30);
		btnThem.setIcon(new ImageIcon("src\\image\\khuyenmai\\iconplus.png"));
		panel_3.add(btnThem);
		
		
		tbMucKhuyenMai = new MyTable(modelKMDT);
		JScrollPane scrollPaneMKM = new JScrollPane(tbMucKhuyenMai, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneMKM.setBounds(24, 255, 452, 246);
		panel_3.add(scrollPaneMKM);
		
		JLabel lblNewLabel_8 = new JLabel("Tạo tên mục khuyến mãi");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(34, 11, 187, 20);
		panel_3.add(lblNewLabel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new TitledBorder(null, "Danh s\u00E1ch c\u00E1c m\u1EE5c khuy\u1EBFn m\u00E3i \u0111ang t\u1EA1o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_9.setBounds(10, 234, 480, 278);
		panel_3.add(panel_9);
		
		JLabel lblNewLabel_13 = new JLabel("Trạng thái:");
		lblNewLabel_13.setBounds(42, 157, 78, 14);
		panel.add(lblNewLabel_13);
		
		txtTrangThai = new JTextField();
		txtTrangThai.setEditable(false);
		txtTrangThai.setText("chưa áp dụng");
		txtTrangThai.setBounds(153, 153, 315, 20);
		panel.add(txtTrangThai);
		txtTrangThai.setColumns(10);
		
		btnTaoMaCTKM = new MyButton("Lưu");
		btnTaoMaCTKM.setText("Tạo mã CTKM");
		btnTaoMaCTKM.setBackground(new Color(97, 166, 247));
		btnTaoMaCTKM.setBounds(203, 183, 120, 30);
		panel.add(btnTaoMaCTKM);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(580, 11, 655, 162);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(97, 166, 247));
		panel_5.setBounds(22, 11, 148, 40);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Tìm kiếm");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(37, 7, 73, 24);
		panel_5.add(lblNewLabel_7);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_7.setBounds(24, 83, 608, 60);
		panel_4.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("MaCTKM:");
		lblNewLabel_9.setBounds(29, 24, 78, 14);
		panel_7.add(lblNewLabel_9);
		
		txtMaCTKMTK = new JTextField();
		txtMaCTKMTK.setBounds(90, 21, 188, 20);
		txtMaCTKMTK.setName("maCT");
		panel_7.add(txtMaCTKMTK);
		txtMaCTKMTK.setColumns(10);
		
		JLabel lblNewLabel_9_1 = new JLabel("TenCTKM:");
		lblNewLabel_9_1.setBounds(346, 24, 78, 14);
		panel_7.add(lblNewLabel_9_1);
		
		txtTenCTKMTK = new JTextField();
		txtTenCTKMTK.setName("tenCT");
		txtTenCTKMTK.setColumns(10);
		txtTenCTKMTK.setBounds(410, 21, 188, 20);
		panel_7.add(txtTenCTKMTK);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBounds(580, 184, 655, 594);
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
		tbDSKhuyenMai = new MyTable(modelDSKhuyenMai);
		JScrollPane scrollPaneDSKM = new JScrollPane(tbDSKhuyenMai, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneDSKM.setBounds(10,144,635,196);
		panel_6.add(scrollPaneDSKM);
		
		JLabel lblNewLabel_10 = new JLabel("Danh sách chương trình khuyến mãi");
		lblNewLabel_10.setBounds(10, 119, 237, 14);
		panel_6.add(lblNewLabel_10);
		
		tbChiTietKM = new MyTable(modelChiTietKM);
		JScrollPane scrollPaneCTKM = new JScrollPane(tbChiTietKM, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneCTKM.setBounds(10, 418, 635, 165);
		panel_6.add(scrollPaneCTKM);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.setBounds(10, 11, 635, 97);
		panel_6.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("Lọc theo tên mục khuyến mãi");
		lblNewLabel_11.setBounds(10, 26, 171, 14);
		panel_8.add(lblNewLabel_11);
		
		cboMucKM = new MyCombobox();
		cboMucKM.setBounds(175, 22, 156, 22);
		cboMucKM.addItem("Tất cả");
		cboMucKM.addItem("Balo");
		cboMucKM.addItem("Bàn");
		cboMucKM.addItem("Bút");
		cboMucKM.addItem("Thước");
		cboMucKM.addItem("Chính trị");
		cboMucKM.addItem("Đèn học");
		cboMucKM.addItem("Ghế");
		cboMucKM.addItem("Giả tưởng");
		cboMucKM.addItem("Giáo khoa");
		cboMucKM.addItem("Kinh dị");
		cboMucKM.addItem("Kinh tế");
		cboMucKM.addItem("Lịch sử");
		cboMucKM.addItem("Máy tính cầm tay");
		cboMucKM.addItem("Nấu ăn");
		cboMucKM.addItem("Tâm lý");
		cboMucKM.addItem("Tình cảm");
		cboMucKM.addItem("Thiếu nhi");
		cboMucKM.addItem("Truyện");
		cboMucKM.addItem("Văn học nghệ thuật");
		cboMucKM.addItem("Vở");
		
		panel_8.add(cboMucKM);
		
		JLabel lblNewLabel_12 = new JLabel("Lọc theo trạng thái");
		lblNewLabel_12.setBounds(10, 68, 125, 14);
		panel_8.add(lblNewLabel_12);
		
		cboTrangThai = new MyCombobox();
		cboTrangThai.setBounds(175, 64, 156, 22);
		cboTrangThai.addItem("Tất cả");
		cboTrangThai.addItem("Đang áp dụng");
		cboTrangThai.addItem("Không áp dụng");
		
		panel_8.add(cboTrangThai);
		
		 btnApDungCT = new MyButton("Áp dụng chương trình khuyến mãi");
		 btnApDungCT.setBackground(new Color(0, 255, 0));
		 btnApDungCT.setBounds(356, 18, 269, 30);
		panel_8.add(btnApDungCT);
		
		JLabel lblNewLabel_14 = new JLabel("Mã CTKM được chọn");
		lblNewLabel_14.setBounds(356, 69, 134, 13);
		panel_8.add(lblNewLabel_14);
		
		txtMaDuocChon = new JTextField();
		txtMaDuocChon.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtMaDuocChon.setEnabled(false);
		txtMaDuocChon.setBounds(500, 66, 125, 20);
		panel_8.add(txtMaDuocChon);
		txtMaDuocChon.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(311, 349, 30, 30);
		btnNewButton.setIcon(new ImageIcon("src\\image\\khuyenmai\\iconarrowdown.png"));
		panel_6.add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("Chi tiết chương trình khuyến mãi");
		lblNewLabel_6.setBounds(10, 395, 237, 13);
		panel_6.add(lblNewLabel_6);
		
		loadDSKhuyenMai();
		MouseListener mouse = new ControllerChuongTrinhKhuyenMai(this);
		ActionListener ac = new ControllerChuongTrinhKhuyenMai(this);
		tbDSKhuyenMai.addMouseListener(mouse);
		cboTrangThai.addActionListener(ac);
		cboMucKM.addActionListener(ac);
		btnApDungCT.addActionListener(ac);
		cboSanPham.addActionListener(ac);
		btnTaoMaCTKM.addActionListener(ac);
		btnThem.addActionListener(ac);
		btnLuu.addActionListener(ac);
		
		// sự kiện cho textField khi tìm kiếm
		KeyListener key = new ControllerChuongTrinhKhuyenMai(this);
		txtMaCTKMTK.addKeyListener(key);
		txtTenCTKMTK.addKeyListener(key);
	}
	
    public void loadDSKhuyenMai() {
    	int stt = 0;
    	ArrayList<ChuongTrinhKhuyenMai> ds = new BUSChuongTrinhKhuyenMai().layDSChuongTrinhKhuyenMai();
    	for(ChuongTrinhKhuyenMai ctkm : ds) {
    		modelDSKhuyenMai.addRow(new Object[] {++stt,ctkm.getMaCTKM(), ctkm.getTenCTKM(), ctkm.isTrangThai() ? "Đang áp dụng" : "Không áp dụng"});
    	}
    }
    
    public void loadChiTietChuongTrinhKhuyenMai() {
    	
    	modelChiTietKM.setRowCount(0);
    	int index = tbDSKhuyenMai.getSelectedRow() != -1 ? tbDSKhuyenMai.getSelectedRow() : viTriDongDuocChon;
    	viTriDongDuocChon = index;
    	
    	String ma = modelDSKhuyenMai.getValueAt(index, 1).toString();
    	txtMaDuocChon.setText(ma);
    	ArrayList<MucKhuyenMai> ds = new DAOMucKhuyenMai().layDSMucKhuyenMaiCuaCTKM(ma);
    	for(MucKhuyenMai mkm : ds) {
    		modelChiTietKM.addRow(new Object[] {mkm.getTenMucKhuyenMai(), mkm.getTiLeKhuyenMai()});
    	}
    	cboMucKM.setSelectedIndex(0);
    }
    
    public void xuLySuKienCboTrangThai(Object o) {
    	
    	if(o.equals(cboTrangThai)) {
    		txtMaDuocChon.setText("");
    	 	viTriDongDuocChon = -1;
        	int stt = 0;
        	int index = cboTrangThai.getSelectedIndex();
        	ArrayList<ChuongTrinhKhuyenMai> ds = new BUSChuongTrinhKhuyenMai().layDSChuongTrinhKhuyenMai();
        	modelDSKhuyenMai.setRowCount(0);
        	modelChiTietKM.setRowCount(0);
        	if(index == 0) {
        		
        		for(ChuongTrinhKhuyenMai ctkm : ds) {
            		modelDSKhuyenMai.addRow(new Object[] {++stt, ctkm.getMaCTKM(), ctkm.getTenCTKM(), ctkm.isTrangThai() ? "Đang áp dụng" : "Không áp dụng"});
            	}
        	}
        	if(index == 1) {
        		
        		for(ChuongTrinhKhuyenMai ctkm : ds) {
        			if(ctkm.isTrangThai()) {
        				modelDSKhuyenMai.addRow(new Object[] {++stt, ctkm.getMaCTKM(), ctkm.getTenCTKM(), "Đang áp dụng"});
        			}
            	}
        	}
        	if(index == 2) {
        		
        		for(ChuongTrinhKhuyenMai ctkm : ds) {
        			if(!ctkm.isTrangThai()) {
        				modelDSKhuyenMai.addRow(new Object[] {++stt,ctkm.getMaCTKM(), ctkm.getTenCTKM(), "Không áp dụng"});
        			}
            	}
        	}
    	}
    	
    }
    
    public void locTheoTenMucKhuyenMai(String ten, ArrayList<MucKhuyenMai>ds, DefaultTableModel model) {
    	model.setRowCount(0);
    	for(MucKhuyenMai mkm : ds) {
    		if(mkm.getTenMucKhuyenMai().equals(ten)) {
    			model.addRow(new Object[] {mkm.getTenMucKhuyenMai(), mkm.getTiLeKhuyenMai()});
    		}
    	}
    }
    
    public void xuLySuKienCboMucKM(Object o) {
    	
    	if(viTriDongDuocChon == -1 && o.equals(cboMucKM)) {
    		JOptionPane.showMessageDialog(this, "Chỉ lọc khi đã chọn chương trình khuyến mãi");
    		cboMucKM.setSelectedIndex(0);
    	}else if(viTriDongDuocChon != -1 && o.equals(cboMucKM)) {
    		String ma = modelDSKhuyenMai.getValueAt(viTriDongDuocChon, 1).toString();
    		ArrayList<MucKhuyenMai> ds = new DAOMucKhuyenMai().layDSMucKhuyenMaiCuaCTKM(ma);
    		String index = cboMucKM.getSelectedItem().toString();
    		switch(index) {
    		case"Balo":{
    			locTheoTenMucKhuyenMai(index, ds, modelChiTietKM);
    			break;
    		}
    		case"Bàn":{
    			locTheoTenMucKhuyenMai(index, ds, modelChiTietKM);
    			break;
    		}
    		case"Bút":{
    			locTheoTenMucKhuyenMai(index, ds, modelChiTietKM);
    			break;
    		}
    		case"Thước":{
    			locTheoTenMucKhuyenMai(index, ds, modelChiTietKM);
    			break;
    		}
    		case"Chính trị":{
    			locTheoTenMucKhuyenMai(index, ds, modelChiTietKM);
    			break;
    		}
    		case"Đèn học":{
    			locTheoTenMucKhuyenMai(index, ds, modelChiTietKM);
    			break;
    		}
    		case"Ghế":{
    			locTheoTenMucKhuyenMai(index, ds, modelChiTietKM);
    			break;
    		}
    		case"Giả tưởng":{
    			locTheoTenMucKhuyenMai(index, ds, modelChiTietKM);
    			break;
    		}
    		case"Giáo khoa":{
    			locTheoTenMucKhuyenMai(index, ds, modelChiTietKM);
    			break;
    		}case"Kinh dị":{
    			locTheoTenMucKhuyenMai(index, ds, modelChiTietKM);
    			break;
    		}
    		case"Kinh tế":{
    			locTheoTenMucKhuyenMai(index, ds, modelChiTietKM);
    			break;
    		}
    		case"Lịch sử":{
    			locTheoTenMucKhuyenMai(index, ds, modelChiTietKM);
    			break;
    		}
    		case"Máy tính cầm tay":{
    			locTheoTenMucKhuyenMai(index, ds, modelChiTietKM);
    			break;
    		}
    		case"Nấu ăn":{
    			locTheoTenMucKhuyenMai(index, ds, modelChiTietKM);
    			break;
    		}
    		case"Tâm lý":{
    			locTheoTenMucKhuyenMai(index, ds, modelChiTietKM);
    			break;
    		}
    		case"Tình cảm":{
    			locTheoTenMucKhuyenMai(index, ds, modelChiTietKM);
    			break;
    		}
    		case"Thiếu nhi":{
    			locTheoTenMucKhuyenMai(index, ds, modelChiTietKM);
    			break;
    		}
    		case"Truyện":{
    			locTheoTenMucKhuyenMai(index, ds, modelChiTietKM);
    			break;
    		}
    		case"Văn học nghệ thuật":{
    			locTheoTenMucKhuyenMai(index, ds, modelChiTietKM);
    			break;
    		}
    		case"Vở":{
    			locTheoTenMucKhuyenMai(index, ds, modelChiTietKM);
    			break;
    		}
    		case"Tất cả":{
    			loadChiTietChuongTrinhKhuyenMai();
    			break;
    		}
    		
    		}
    	}
    	
    }

	
    
    public void xuLySuKienTrenCacBtn(String src) {
    	
    	if(src.equals("Áp dụng chương trình khuyến mãi")) {
    		String ma = modelDSKhuyenMai.getValueAt(viTriDongDuocChon, 1).toString();
    		// chuyển trạng thái cái sản phẩm về false hết
    		ArrayList<ChuongTrinhKhuyenMai> ds = new BUSChuongTrinhKhuyenMai().layDSChuongTrinhKhuyenMai();
    		for(ChuongTrinhKhuyenMai ctkm : ds) {
    			new BUSChuongTrinhKhuyenMai().tatTrangThaiChuongTrinhKhuyenMai(ctkm);
    		}
    		
    		// cập nhật chương trình khuyến mãi chuẩn bị áp dụng
    		ChuongTrinhKhuyenMai temp = new BUSChuongTrinhKhuyenMai().timChuongTrinhKhuyenMaiTheoMa(ma);
    		temp.setTrangThai(true);
    		new BUSChuongTrinhKhuyenMai().capNhatTrangThaiChuongTrinhKhuyenMaiDuocChon(temp);;
    		
    		// load lại dữ liệu
    		modelDSKhuyenMai.setRowCount(0);
    		loadDSKhuyenMai();
    	}
    	if(src.equals("Tạo mã CTKM")) {
    		txtMaCTKM.setText(new BUSChuongTrinhKhuyenMai().taoMaCTKM());
    	}
    	if(src.equals("Thêm")) {
    		if(txtPhanTram.getText().equals("")) {
    			JOptionPane.showMessageDialog(this, "Vui lòng nhập phần trăm giảm giá cho sản phẩm");
    		}else {
    			Float phanTram = (float)0;
    			try {
    				phanTram = Float.parseFloat(txtPhanTram.getText());
    				if(phanTram < 0) {
    					JOptionPane.showMessageDialog(this, "Phần trăm phải là 1 số dương");
    					return;
    				}
    			}catch(Exception e) {
    				JOptionPane.showMessageDialog(this, "Phần trăm phải là kí tự số");
    				return;
    			}
        		String theLoai = cboTheLoai.getSelectedItem().toString();
        		
        		MucKhuyenMai m = new MucKhuyenMai(theLoai, phanTram);
        		
        		// kiểm tra mục khuyến mãi đã tồn tại hay chưa
        		if(kiemTraMucKhuyenMai(m)) {
        			dsMucKhuyenMaiDangTao.add(m);
        		}else {
        			JOptionPane.showMessageDialog(this, "Mục khuyến mãi đã tồn tại");
        			return;
        		}
        		
        		
        		modelKMDT.setRowCount(0);
        		
        		for(MucKhuyenMai mkm : dsMucKhuyenMaiDangTao) {
        			modelKMDT.addRow(new Object[] {mkm.getTenMucKhuyenMai(), mkm.getTiLeKhuyenMai()});
        		}
    		}
    		
    		txtPhanTram.setText("");
    	}
    	if(src.equals("Lưu")) {
    		BUSChuongTrinhKhuyenMai bus_ctkm = new BUSChuongTrinhKhuyenMai();
    		String maCTKM = txtMaCTKM.getText();
    		String tenCTKM = txtAreaTenCTKM.getText();
            boolean trangThai = txtTrangThai.getText().trim().equals("chưa áp dụng") ? false : true;
            ChuongTrinhKhuyenMai ctkm = new ChuongTrinhKhuyenMai(maCTKM, tenCTKM, dsMucKhuyenMaiDangTao, trangThai);
            if(bus_ctkm.validateChuongTrinhKhuyenMai(ctkm)) {
            	if(bus_ctkm.themChuongTrinhKhuyenMai(ctkm)) {
                	JOptionPane.showMessageDialog(this, "Thêm thành công chương trình khuyến mãi");
                	dsMucKhuyenMaiDangTao.clear();
                	capNhatTrangThaiBangDSKhuyenMai();
                	modelKMDT.setRowCount(0);
                	xoaTrangTextField();
                	
                	// gửi chương trình khuyến mãi cho tất cả khách hàng
                	if(JOptionPane.showConfirmDialog(this, "Bạn có muốn gửi chương trình khuyến mãi này cho khách hàng không?","Có", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION) {
                		ArrayList<KhachHang> dsKh = new BUSKhachHang().layDSKhachHang();
                		String gmail = "";
                		String userMail = "thuykieu.13032003@gmail.com";
                		String password = "tirfdrdpsbjxqemq";
                		String subject = "Chương trình khuyến mãi hàng tháng của cửa hàng";
                		String message = "Chúc ngày mới vui vẻ";
                		for(KhachHang kh : dsKh) {
                			if(dsKh.indexOf(kh) == 0) {
                				continue;
                			}
                			if(dsKh.indexOf(kh) == dsKh.size() - 1) {
                				gmail += kh.getEmail();
                			}else {
                				gmail += kh.getEmail() + ",";
                			}
                		}
                		System.out.println(gmail);
                		phanLuong pl = new phanLuong(thongBao,gmail, subject, message, "Gửi chương trình khuyến mãi thành công");
                		pl.execute();
                	}
                }else {
                	JOptionPane.showMessageDialog(this, "Thêm chương trình khuyến mãi thất bại do trùng mã CTKM");
                }
            }else {
            	JOptionPane.showMessageDialog(this, bus_ctkm.getMessage());
            }
            
    	}
    }
    
    public boolean kiemTraMucKhuyenMai(MucKhuyenMai m) {
    	// kiểm tra mục khuyến mãi đã tồn tại hay chưa
		for(MucKhuyenMai mk : dsMucKhuyenMaiDangTao) {
			if(mk.getTenMucKhuyenMai().trim().equals(m.getTenMucKhuyenMai().trim())) {
				return false;
			}
		}
		return true;
    }
    
    public void xuLySuKienCboSanPham(Object o) {
    	if(o.equals(cboSanPham)) {
    	int sanPham = cboSanPham.getSelectedIndex();
    	if(sanPham == 0) {
    		cboTheLoai.removeAllItems();
    		cboTheLoai.addItem("Chính trị");
    		cboTheLoai.addItem("Giả tưởng");
    		cboTheLoai.addItem("Giáo khoa");
    		cboTheLoai.addItem("Kinh dị");
    		cboTheLoai.addItem("Kinh tế");
    		cboTheLoai.addItem("Lịch sử");
    		cboTheLoai.addItem("Nấu ăn");
    		cboTheLoai.addItem("Tâm lý");
    		cboTheLoai.addItem("Tình cảm");
    		cboTheLoai.addItem("Thiếu nhi");
    		cboTheLoai.addItem("Truyện");
    		cboTheLoai.addItem("Văn học nghệ thuật");
    		
    	}
    	if(sanPham == 1) {
    		cboTheLoai.removeAllItems();
    		cboTheLoai.addItem("Balo");
    		cboTheLoai.addItem("Bàn");
    		cboTheLoai.addItem("Bút");
    		cboTheLoai.addItem("Thước");
    		cboTheLoai.addItem("Đèn học");
    		cboTheLoai.addItem("Ghế");
    		cboTheLoai.addItem("Máy tính cầm tay");
    		cboTheLoai.addItem("Vở");
    	}
    }}
    
    public void capNhatTrangThaiBangDSKhuyenMai() {
    	modelDSKhuyenMai.setRowCount(0);
    	loadDSKhuyenMai();
    }
    
    public void xoaTrangTextField() {
    	txtMaCTKM.setText("");
    	txtAreaTenCTKM.setText("");
    	
    }
    
    public void xuLyKhiTimKiem(KeyEvent e) {
    	Object o = e.getSource();
    	char key = e.getKeyChar();
    	if((Character.isLetterOrDigit(key))|| key == e.VK_BACK_SPACE) {
    		xuLyTimKiemTheoTextField(new BUSChuongTrinhKhuyenMai().layDSChuongTrinhKhuyenMai());
    	}
    }
    
    public void xuLyTimKiemTheoTextField(ArrayList<ChuongTrinhKhuyenMai> ds) {
    	xuLyTimKiemTheoMaCTKM(ds);
    	xuLyTimKiemTheoTenCTKM(ds);
    	modelDSKhuyenMai.setRowCount(0);
    	loadDSKhuyenMaiTheoTimKiem(ds);
    	
    }
    
    
    
    public void xuLyTimKiemTheoMaCTKM(ArrayList<ChuongTrinhKhuyenMai> ds) {
    	String text = txtMaCTKMTK.getText().trim();
    	ArrayList<ChuongTrinhKhuyenMai> temp = new ArrayList<>();
    	Pattern maPattern = Pattern.compile(text, Pattern.CASE_INSENSITIVE);
    	for(ChuongTrinhKhuyenMai ctkm : ds) {
    		if(maPattern.matcher(ctkm.getMaCTKM()).find()) {
    			temp.add(ctkm);
    		}
    	}
    	ds.clear();
    	ds.addAll(temp);
    }
    
    public void xuLyTimKiemTheoTenCTKM(ArrayList<ChuongTrinhKhuyenMai> ds) {
    	String text = txtTenCTKMTK.getText();
    	ArrayList<ChuongTrinhKhuyenMai> temp = new ArrayList<>();
    	Pattern maPattern = Pattern.compile(text, Pattern.CASE_INSENSITIVE);
    	for(ChuongTrinhKhuyenMai ctkm : ds) {
    		if(maPattern.matcher(ctkm.getTenCTKM()).find()) {
    			temp.add(ctkm);
    		}
    	}
    	ds.clear();
    	ds.addAll(temp);
    }
    
    public void loadDSKhuyenMaiTheoTimKiem(ArrayList<ChuongTrinhKhuyenMai> ds) {
    	int stt = 0;
    	for(ChuongTrinhKhuyenMai ctkm : ds) {
    		modelDSKhuyenMai.addRow(new Object[] {++stt,ctkm.getMaCTKM(), ctkm.getTenCTKM(), ctkm.isTrangThai() ? "Đang áp dụng" : "Không áp dụng"});
    	}
    }
}
