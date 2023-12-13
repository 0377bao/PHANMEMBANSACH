package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.GuardedObject;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

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

public class GUIKhuyenMai extends JPanel implements MouseListener{
	private DefaultTableModel modelKMDT, modelDSKhuyenMai, modelChiTietKM;
	private JTextField txtMaCTKM;
	private JTextField txtPhanTram;
	private MyTable tbMucKhuyenMai, tbDSKhuyenMai, tbChiTietKM;
	private JTextField txtMaCTKMTK;
	private JTextField txtTenCTKMTK;
	private JTextField txtTrangThai;
	private MyButton btnApDungCT, btnLuu, btnThem, btnTaoMaCTKM, btnCapNhat, btnXoa, btnLuuCapNhat;
	private MyCombobox cboTrangThai, cboSanPham, cboMucKM, cboTheLoai;
	private JTextArea txtAreaTenCTKM;
	private int viTriDongDuocChon = -1;
	private String arrayTheLoaiSach[] = new String[]{"Chính trị", "Kinh tế", "Lịch sử", "Giả tưởng", "Giáo khoa", "Kinh dị", "Nấu ăn", "Tâm lý", "Tình cảm", "Thiếu nhi", "Truyện", "Văn học nghệ thuật"};
	private String arrayTheLoaiVPP[] = new String[]{"Balo", "Bàn", "Bút", "Thước", "Đèn học", "Vở", "Máy tính cầm tay", "Ghế"};
	private ArrayList<MucKhuyenMai> dsMucKhuyenMaiDangTao = new ArrayList<>();
	private JTextField txtMaDuocChon;
	private JCheckBox checkBoxChinhSuaMKM;
	
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
		panel.setBounds(10, 10, 549, 767);
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
		
		JLabel lblNewLabel_1 = new JLabel("Mã CTKM:");
		lblNewLabel_1.setBounds(44, 62, 78, 14);
		panel.add(lblNewLabel_1);
		
		txtMaCTKM = new JTextField();
		txtMaCTKM.setEditable(false);
		txtMaCTKM.setBounds(153, 62, 315, 20);
		panel.add(txtMaCTKM);
		txtMaCTKM.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tên CTKM:");
		lblNewLabel_2.setBounds(42, 98, 78, 14);
		panel.add(lblNewLabel_2);
		
		txtAreaTenCTKM = new JTextArea();
		txtAreaTenCTKM.setBackground(new Color(255, 255, 255));
		txtAreaTenCTKM.setBounds(153, 93, 315, 45);
		txtAreaTenCTKM.setBorder(BorderFactory.createLineBorder(Color.black, 1));
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
		btnThem.setBounds(372, 194, 106, 30);
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
		
		btnXoa = new MyButton("Xóa");
		btnXoa.setText("Xóa");
		btnXoa.setBackground(new Color(97, 166, 247));
		btnXoa.setBounds(256, 194, 106, 30);
		btnXoa.setEnabled(false);
		panel_3.add(btnXoa);
		
		btnCapNhat = new MyButton("Cập nhật");
		btnCapNhat.setText("Cập nhật");
		btnCapNhat.setBackground(new Color(97, 166, 247));
		btnCapNhat.setBounds(140, 194, 106, 30);
		btnCapNhat.setEnabled(false);
		panel_3.add(btnCapNhat);
		
		btnLuuCapNhat = new MyButton("Cập nhật");
		btnLuuCapNhat.setText("Lưu cập nhật");
		btnLuuCapNhat.setBackground(new Color(97, 166, 247));
		btnLuuCapNhat.setBounds(25, 194, 106, 30);
		btnLuuCapNhat.setEnabled(false);
		panel_3.add(btnLuuCapNhat);
		
		JLabel lblNewLabel_13 = new JLabel("Trạng thái:");
		lblNewLabel_13.setBounds(42, 157, 78, 14);
		panel.add(lblNewLabel_13);
		
		txtTrangThai = new JTextField();
		txtTrangThai.setEditable(false);
		txtTrangThai.setText("Không áp dụng");
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
		
		JLabel lblNewLabel_9 = new JLabel("Mã CTKM:");
		lblNewLabel_9.setBounds(29, 24, 78, 14);
		panel_7.add(lblNewLabel_9);
		
		txtMaCTKMTK = new JTextField();
		txtMaCTKMTK.setBounds(97, 20, 188, 20);
		txtMaCTKMTK.setName("maCT");
		panel_7.add(txtMaCTKMTK);
		txtMaCTKMTK.setColumns(10);
		
		JLabel lblNewLabel_9_1 = new JLabel("Tên CTKM:");
		lblNewLabel_9_1.setBounds(337, 24, 78, 14);
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
		
		checkBoxChinhSuaMKM = new JCheckBox("Chỉnh sửa mục khuyến mãi");
		checkBoxChinhSuaMKM.setBackground(new Color(255, 255, 255));
		checkBoxChinhSuaMKM.setBounds(446, 116, 199, 21);
		checkBoxChinhSuaMKM.setFocusable(false);
		panel_6.add(checkBoxChinhSuaMKM);
		
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
		btnXoa.addActionListener(ac);
		btnCapNhat.addActionListener(ac);
		btnLuuCapNhat.addActionListener(ac);
		tbMucKhuyenMai.addMouseListener(this);
		checkBoxChinhSuaMKM.addActionListener(ac);
		
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
        		xoaTrangToanBo();
        	}
        	if(index == 1) {
        		
        		for(ChuongTrinhKhuyenMai ctkm : ds) {
        			if(ctkm.isTrangThai()) {
        				modelDSKhuyenMai.addRow(new Object[] {++stt, ctkm.getMaCTKM(), ctkm.getTenCTKM(), "Đang áp dụng"});
        			}
            	}
        	    xoaTrangToanBo();
        	}
        	if(index == 2) {
        		
        		for(ChuongTrinhKhuyenMai ctkm : ds) {
        			if(!ctkm.isTrangThai()) {
        				modelDSKhuyenMai.addRow(new Object[] {++stt,ctkm.getMaCTKM(), ctkm.getTenCTKM(), "Không áp dụng"});
        			}
            	}
        		xoaTrangToanBo();
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
    		if(viTriDongDuocChon == -1) {
    			JOptionPane.showMessageDialog(this, "Vui lòng chọn chương trình khuyến mãi cần áp dụng");
    			return;
    		}
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
    		tbDSKhuyenMai.getSelectionModel().setSelectionInterval(viTriDongDuocChon, viTriDongDuocChon);
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
    				if(phanTram > 100) {
    					JOptionPane.showMessageDialog(this, "Phần trăm không được vượt quá 100");
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
            boolean trangThai = txtTrangThai.getText().trim().equals("Không áp dụng") ? false : true;
            ChuongTrinhKhuyenMai ctkm = new ChuongTrinhKhuyenMai(maCTKM, tenCTKM, dsMucKhuyenMaiDangTao, trangThai);
            String listItem = loadMucKhuyenMai(ctkm);
            String gmail = layGmailKhachHang();
            if(bus_ctkm.validateChuongTrinhKhuyenMai(ctkm)) {
            	if(bus_ctkm.themChuongTrinhKhuyenMai(ctkm)) {
                	JOptionPane.showMessageDialog(this, "Thêm thành công chương trình khuyến mãi");
                	dsMucKhuyenMaiDangTao.clear();
                	capNhatTrangThaiBangDSKhuyenMai();
                	modelKMDT.setRowCount(0);
                	xoaTrangTextField();
                	btnXoa.setEnabled(false);
                	btnCapNhat.setEnabled(false);
                	
                	// gửi chương trình khuyến mãi cho tất cả khách hàng
                	if(JOptionPane.showConfirmDialog(this, "Bạn có muốn gửi chương trình khuyến mãi này cho khách hàng không?","Có", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION) {
//                		String userMail = "thuykieu.13032003@gmail.com";
//                		String password = "tirfdrdpsbjxqemq";
                		String subject = "Chương trình khuyến mãi tri ân khách hàng của hiệu sách HBDK";
                		String message = "Chào quý khách hàng thân mến, những người đã và đang mua hàng tại hiệu sách chúng tôi.\n" + "Nhân dịp " + "'" + ctkm.getTenCTKM() + "'" + " hiệu sách của chúng tôi sẽ áp dụng ưu đãi cho những sản phẩm sau:\n"
                				         + listItem + "\n" + "Cảm ơn bạn đã ủng hộ hiệu sách của chúng tôi!\n" + "Trân trọng";
         		
                		phanLuong pl = new phanLuong(thongBao,gmail.trim(), subject, message, "Gửi chương trình khuyến mãi thành công");
                		pl.execute();
                	}
                }else {
                	JOptionPane.showMessageDialog(this, "Thêm chương trình khuyến mãi thất bại do trùng mã CTKM");
                	return;
                }
            }else {
            	JOptionPane.showMessageDialog(this, bus_ctkm.getMessage());
            	return;
            }
            
    	}
    	
    	if(src.equals("Xóa")) {
    		int index = tbMucKhuyenMai.getSelectedRow();
    		if(index == -1) {
    			JOptionPane.showMessageDialog(this, "Vui lòng chọn mục khuyến mãi cần xóa");
    			return;
    		}else {
    			if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa mục khuyến mãi này không", "Yes", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
    				modelKMDT.removeRow(index);
        			dsMucKhuyenMaiDangTao.remove(index);
        			cboSanPham.setEnabled(true);
        			cboTheLoai.setEnabled(true);
        			txtPhanTram.setText("");
    			}
    			
    		}
    	}
    	
    	if(src.equals("Cập nhật")) {
    		int index = tbMucKhuyenMai.getSelectedRow();
    		float phanTram = -1;
    		String tenMucKhuyenMai = "";
    		if(index == -1) {
    			JOptionPane.showMessageDialog(this, "Vui lòng chọn mục khuyến mãi cần cập nhật");
    			return;
    		}else {
    			
    			try {
    				phanTram = Float.parseFloat(txtPhanTram.getText());
    				if(phanTram <= 0) {
    					JOptionPane.showMessageDialog(this, "Phần trăm không được <= 0");
    					return;
    				}
    				if(phanTram > 100) {
    					JOptionPane.showMessageDialog(this, "Phần trăm không được vượt quá 100");
    					return;
    				}
    			}catch(Exception e) {
    				JOptionPane.showMessageDialog(this, "Phần trăm không hợp lệ");
    				return;
    			}
    		}
    		modelKMDT.setValueAt(phanTram, index, 1);
    		if(checkBoxChinhSuaMKM.isSelected() == false) {
    			tenMucKhuyenMai = cboTheLoai.getSelectedItem().toString();
    			modelKMDT.setValueAt(tenMucKhuyenMai, index, 0);
    		}
    		MucKhuyenMai m = new MucKhuyenMai(tenMucKhuyenMai.equals("") ? modelKMDT.getValueAt(index, 0).toString() : tenMucKhuyenMai, phanTram);
    		dsMucKhuyenMaiDangTao.set(index, m);
    		if(checkBoxChinhSuaMKM.isSelected()) {
    			txtAreaTenCTKM.setEditable(false);
    		}else {
    			txtAreaTenCTKM.setEditable(true);
    		}
    		
    		txtPhanTram.setText("");
    		tbMucKhuyenMai.clearSelection();
    	}
    	
    	if(src.equals("Lưu cập nhật")) {
    		boolean flag = false;
    		 for(MucKhuyenMai m : dsMucKhuyenMaiDangTao) {
    			 flag = new BUSChuongTrinhKhuyenMai().capNhatMucKhuyenMai(txtMaCTKM.getText(), m);
    		 }
    		 if(flag == true) {
    			 JOptionPane.showMessageDialog(this, "Cập nhật thành công mục khuyến mãi của chương trình này");
    			 xoaTrangToanBo();
    			 btnCapNhat.setEnabled(false);
    			 dsMucKhuyenMaiDangTao.clear();
    			 checkBoxChinhSuaMKM.setSelected(false);
    		 }else {
    			 JOptionPane.showMessageDialog(this, "Cập nhật không thành công mục khuyến mãi vì trùng khóa");
    			 return;
    		 }
    	}
    	
    	if(src.equals("Chỉnh sửa mục khuyến mãi")) {
    		if(checkBoxChinhSuaMKM.isSelected()) {
    			if(tbDSKhuyenMai.getSelectedRow() != -1) {
    			    loadChuongTrinhKhuyenMaiCanChinhSua();
    			    btnCapNhat.setEnabled(true);
    		    	btnLuuCapNhat.setEnabled(true);
    		    	btnLuu.setEnabled(false);
    		    	btnTaoMaCTKM.setEnabled(false);
    		    	btnXoa.setEnabled(false);
    			}else {
    				JOptionPane.showMessageDialog(this, "Vui lòng chọn chương trình khuyến mãi có mục khuyến mãi cần chỉnh sửa");
    				checkBoxChinhSuaMKM.setSelected(false);
    				return;
    			}	
    		}else {
    			loadChuongTrinhKhuyenMaiCanChinhSua();
    	    	btnLuuCapNhat.setEnabled(false);
    	    	btnCapNhat.setEnabled(false);
    	    	cboSanPham.setEnabled(true);
    	    	cboTheLoai.setEnabled(true);
    	    	txtPhanTram.setText("");
    	    	btnLuu.setEnabled(true);
		    	btnTaoMaCTKM.setEnabled(true);
    		}
    	}
    	
    }
    
    // lấy gmail khách hàng
    public String layGmailKhachHang() {
    	String mail = "";
    	ArrayList<KhachHang> dsKh = new BUSKhachHang().layDSKhachHang();
    	for(KhachHang kh : dsKh) {
			if(dsKh.indexOf(kh) == 0) {
				continue;
			}
			if(dsKh.indexOf(kh) == dsKh.size() - 1) {
				mail += kh.getEmail();
			}else {
				mail += kh.getEmail() + ",";
			}
		}
    	return mail;
    }
    
    // load mục khuyến mãi
    public String loadMucKhuyenMai(ChuongTrinhKhuyenMai ctkm) {
    	String message = "";
    	for(MucKhuyenMai c : ctkm.getDsMucKhuyenMai()) {
    		message += "+ " + c.getTenMucKhuyenMai() + " : " + c.getTiLeKhuyenMai() + "%" + "\n";
    	}
    	return message;
    }
// xóa trắng tất cả các field
    public void xoaTrangToanBo() {
    	xoaTrangTextField();
		modelKMDT.setRowCount(0);
		 cboSanPham.setEnabled(true);
		 cboTheLoai.setEnabled(true);
		 txtAreaTenCTKM.setEditable(true);
		 tbDSKhuyenMai.clearSelection();
		 txtPhanTram.setText("");
		 modelChiTietKM.setRowCount(0);
		 btnLuuCapNhat.setEnabled(false);
		 btnLuu.setEnabled(true);
	    btnTaoMaCTKM.setEnabled(true);
	    txtMaDuocChon.setText("");
	    txtTrangThai.setText("Không áp dụng");
	    viTriDongDuocChon = -1;
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
    
    public String kiemTraTheLoaiThuocSanPham(String m) {
    	for(String SanPham : arrayTheLoaiSach) {
    		if(SanPham.equals(m)) {
    			return "Sản phẩm";
    		}
    	}
    	
    	for(String Vpp : arrayTheLoaiVPP) {
    		if(Vpp.equals(m)) {
    			return "Văn phòng phẩm";
    		}
    	}
    	return null;
    }
    
    public void loadChuongTrinhKhuyenMaiCanChinhSua() {
    	if(checkBoxChinhSuaMKM.isSelected()) {
    		modelChiTietKM.setRowCount(0);
    		int viTri = tbDSKhuyenMai.getSelectedRow();
        	txtMaCTKM.setText(modelDSKhuyenMai.getValueAt(viTri, 1).toString());
        	txtAreaTenCTKM.setText(modelDSKhuyenMai.getValueAt(viTri, 2).toString());
        	txtTrangThai.setText(modelDSKhuyenMai.getValueAt(viTri, 3).toString());
        	txtAreaTenCTKM.setEditable(false);
        	ArrayList<MucKhuyenMai> ds = new DAOMucKhuyenMai().layDSMucKhuyenMaiCuaCTKM(modelDSKhuyenMai.getValueAt(viTri, 1).toString());
        	dsMucKhuyenMaiDangTao.clear();
        	dsMucKhuyenMaiDangTao.addAll(ds);
        	modelKMDT.setRowCount(0);
        	for(MucKhuyenMai mkm : dsMucKhuyenMaiDangTao) {
        		modelKMDT.addRow(new Object[] {mkm.getTenMucKhuyenMai(), mkm.getTiLeKhuyenMai()});
        	}
    	}else {
    		modelKMDT.setRowCount(0);
    		txtMaCTKM.setText("");
        	txtAreaTenCTKM.setText("");
        	txtTrangThai.setText("Không áp dụng");
        	txtAreaTenCTKM.setEditable(true);
        	dsMucKhuyenMaiDangTao.clear();
        	loadChiTietChuongTrinhKhuyenMai();
    	}
    	
    }
    
    public String catChuoiPhanTram(String chuoi) {
    	if(chuoi.length() == 3) {
    		return chuoi.substring(0, 1);
    	}
    	if(chuoi.length() == 4) {
    		return chuoi.substring(0, 2);
    	}
    	if(chuoi.length() == 5) {
    		return chuoi.substring(0, 3);
    	}
    	return null;
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tbMucKhuyenMai.getSelectedRow();
		String theLoai = modelKMDT.getValueAt(row, 0).toString();
		String sanPham = kiemTraTheLoaiThuocSanPham(theLoai);
		if(sanPham.equals("Sản phẩm")) {
			cboSanPham.setSelectedIndex(0);
			cboTheLoai.setSelectedItem(theLoai);
		}else {
			cboSanPham.setSelectedIndex(1);
			cboTheLoai.setSelectedItem(theLoai);
		}
		String phanTramTemp = catChuoiPhanTram(modelKMDT.getValueAt(row, 1).toString());
		txtPhanTram.setText(phanTramTemp);
		if(tbDSKhuyenMai.getSelectedRow() != -1) {
			cboSanPham.setEnabled(false);
			cboTheLoai.setEnabled(false);
		}else {
			cboSanPham.setEnabled(true);
			cboTheLoai.setEnabled(true);
			btnXoa.setEnabled(true);
			btnCapNhat.setEnabled(true);
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
