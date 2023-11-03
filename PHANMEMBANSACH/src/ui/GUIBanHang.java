package ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.toedter.calendar.JDateChooser;

import bus.BUSChuongTrinhKhuyenMai;
import bus.BUSHoaDon;
import bus.BUSKhachHang;
import bus.BUSSanPham;
import customUI.MyButton;
import customUI.MyCombobox;
import customUI.MyTable;
import entity.ChiTietHoaDon;
import entity.ChuongTrinhKhuyenMai;
import entity.HoaDon;
import entity.KhachHang;
import entity.Sach;
import entity.SanPham;
import entity.VanPhongPham;
import tool.Tools;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Dimension;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class GUIBanHang extends JPanel implements Runnable,ThreadFactory{
	private DefaultTableModel modelHoaDonCho, modelGioHang, modelHoaDon, modelChiTietHoaDon;
	private JTable tableHoaDonCho, tableGioHang, tableHoaDon, tableChiTietHoaDon;
	private JTextField txtTimKhachHang;
	private JTextField txtMaSanPham;
	private JTextField txtTienKhachDua;
	private JTextField txtQLHDTimHoaDon;
	private JTextField txtQLHDMaNhanVien;
	private JTextField txtQLHDDienThoaiKH;
	String resultScanQRBefore = "null";
	
	//QR code
	private TrangChu view;
	private WebcamPanel panel = null;
	private Webcam webcam = null;
	private Executor executor = Executors.newSingleThreadExecutor(this);
	private JPanel pnlKhungQuetMa;
	private ImageIcon iconLblBgr;
	private JLabel lblAnhSanPham;
	private JLabel lblMaSach;
	private JLabel lblTenSach;
	private JPanel pnlSanPhamSach;
	private JPanel pnlSanPham;
	private JLabel lblThueSach;
	private JLabel lblGiaBanSach;
	private JLabel lblTheLoaiSach;
	private JLabel lblTacGia;
	private JLabel lblNhaXuatBan;
	private JLabel lblNamSanXuat;
	private JLabel lblSoLuongTonSach;
	private JPanel pnlSanPhamVPP;
	private JLabel lblMaVPP;
	private JLabel lblTenVPP;
	private JLabel lblThueVPP;
	private JLabel lblGiaVPP;
	private JLabel lblTheLoaiVPP;
	private JLabel lblDanhMuc;
	private JLabel lblChatLieu;
	private JLabel lblSoLuongTonVPP;
	private JLabel lblMaKhachHang;
	private JLabel lblTenKhachHang;
	private JLabel lblDiemTichLuy;
//	khai báo bus
	private BUSHoaDon BUSHoaDon = new BUSHoaDon();
	private BUSKhachHang busKhachHang = new BUSKhachHang();
	private BUSChuongTrinhKhuyenMai busCTKM = new BUSChuongTrinhKhuyenMai();
//	Phần dữ liệu cho hóa đơn
	private ArrayList<HoaDon> dsHoaDonCho = new ArrayList<>();
	private HoaDon hoaDonHienTai = null;
	private KhachHang khachHang = busKhachHang.timKhachHangTheoMa("KH1");
	private ChuongTrinhKhuyenMai ctkmCuaHoaDon = busCTKM.timChuongTrinhKhuyenMaiDangApDung();
	private JLabel lblMaHoaDon;
	private JLabel lblTongTien;
	private JLabel lblTenChuongTrinhKhuyenMai;
	private JLabel lblThanhToan;
	private JLabel lblTienThua;
	private JTextArea txtGhiChu;
	private MyCombobox cbbHinhThucThanhToan;
	private MyCombobox cbbDiemGiamGia;
	public GUIBanHang(TrangChu view, ArrayList<HoaDon> ds) {
		this.view = view;
		this.dsHoaDonCho = ds;
		this.hoaDonHienTai = dsHoaDonCho.size() == 0 ? null : dsHoaDonCho.get(0);
		this.setBackground(new Color(255, 255, 255));
		this.setBounds(250, 0, 1302, 800);
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1292, 793);
		add(tabbedPane);
		
//		Phần bán hàng
		JPanel pnlBanHang = new JPanel();
		tabbedPane.addTab("Bán hàng", null, pnlBanHang, null);
		pnlBanHang.setLayout(null);
		
		JPanel pnlThanhToan = new JPanel();
		pnlThanhToan.setBackground(new Color(255, 255, 255));
		pnlThanhToan.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, null));
		pnlThanhToan.setBounds(959, 10, 318, 746);
		pnlBanHang.add(pnlThanhToan);
		pnlThanhToan.setLayout(null);
		
		JLabel lblHan = new JLabel("Hóa đơn");
		lblHan.setForeground(Color.GRAY);
		lblHan.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHan.setBounds(10, 10, 111, 20);
		pnlThanhToan.add(lblHan);
		
		JLabel lblMHan = new JLabel("Mã hóa đơn:");
		lblMHan.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMHan.setBounds(10, 74, 86, 30);
		pnlThanhToan.add(lblMHan);
		
		JLabel lblTngTin = new JLabel("Tổng tiền:");
		lblTngTin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTngTin.setBounds(10, 114, 72, 30);
		pnlThanhToan.add(lblTngTin);
		
		JLabel lblimGimGi = new JLabel("Điểm giảm giá:");
		lblimGimGi.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblimGimGi.setBounds(10, 154, 99, 30);
		pnlThanhToan.add(lblimGimGi);
		
		JLabel lblTinGimGi = new JLabel("Tên CTKM:");
		lblTinGimGi.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTinGimGi.setBounds(10, 34, 99, 30);
		pnlThanhToan.add(lblTinGimGi);
		
		JLabel lblThanhTon = new JLabel("Thanh toán:");
		lblThanhTon.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblThanhTon.setBounds(10, 200, 86, 30);
		pnlThanhToan.add(lblThanhTon);
		
		JLabel lblTinKhcha = new JLabel("Tiền khách đưa:");
		lblTinKhcha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTinKhcha.setBounds(10, 240, 111, 30);
		pnlThanhToan.add(lblTinKhcha);
		
		JLabel lblTinTha = new JLabel("Tiền thừa:");
		lblTinTha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTinTha.setBounds(10, 280, 72, 30);
		pnlThanhToan.add(lblTinTha);
		
		JLabel lblHnhThcThanh = new JLabel("Hình thức thanh toán:");
		lblHnhThcThanh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHnhThcThanh.setBounds(10, 320, 150, 30);
		pnlThanhToan.add(lblHnhThcThanh);
		
		JLabel lblHnhThcThanh_1_1 = new JLabel("Ghi chú:");
		lblHnhThcThanh_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHnhThcThanh_1_1.setBounds(10, 400, 65, 30);
		pnlThanhToan.add(lblHnhThcThanh_1_1);
		
		lblMaHoaDon = new JLabel("Vui lòng tạo!");
		lblMaHoaDon.setForeground(new Color(255, 128, 64));
		lblMaHoaDon.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMaHoaDon.setBounds(170, 74, 138, 30);
		pnlThanhToan.add(lblMaHoaDon);
		
		lblTongTien = new JLabel("0");
		lblTongTien.setHorizontalAlignment(SwingConstants.LEFT);
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTongTien.setBounds(170, 114, 138, 30);
		pnlThanhToan.add(lblTongTien);
		
		lblTenChuongTrinhKhuyenMai = new JLabel("Không có giảm giá");
		lblTenChuongTrinhKhuyenMai.setHorizontalAlignment(SwingConstants.LEFT);
		lblTenChuongTrinhKhuyenMai.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTenChuongTrinhKhuyenMai.setBounds(170, 34, 138, 30);
		pnlThanhToan.add(lblTenChuongTrinhKhuyenMai);
		
		lblThanhToan = new JLabel("0");
		lblThanhToan.setForeground(new Color(255, 128, 64));
		lblThanhToan.setHorizontalAlignment(SwingConstants.LEFT);
		lblThanhToan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThanhToan.setBounds(170, 200, 138, 30);
		pnlThanhToan.add(lblThanhToan);
		
		txtTienKhachDua = new JTextField();
		txtTienKhachDua.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTienKhachDua.setBounds(170, 242, 138, 30);
		pnlThanhToan.add(txtTienKhachDua);
		txtTienKhachDua.setColumns(10);
		
		lblTienThua = new JLabel("0");
		lblTienThua.setForeground(new Color(0, 128, 255));
		lblTienThua.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTienThua.setBounds(170, 280, 138, 30);
		pnlThanhToan.add(lblTienThua);
		
		txtGhiChu = new JTextArea();
		txtGhiChu.setBounds(10, 441, 298, 108);
		txtGhiChu.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlThanhToan.add(txtGhiChu);
		
		cbbHinhThucThanhToan = new MyCombobox();
		cbbHinhThucThanhToan.setFont(new Font("Tahoma", Font.BOLD, 13));
		cbbHinhThucThanhToan.setBounds(10, 360, 298, 30);
		cbbHinhThucThanhToan.addItem("Tiền mặt");
		cbbHinhThucThanhToan.addItem("Chuyển khoản");
		pnlThanhToan.add(cbbHinhThucThanhToan);
		
		cbbDiemGiamGia = new MyCombobox();
		cbbDiemGiamGia.setFont(new Font("Tahoma", Font.BOLD, 13));
		cbbDiemGiamGia.setBounds(170, 154, 138, 30);
		pnlThanhToan.add(cbbDiemGiamGia);
		
		JButton btnHuyHoaDon = new MyButton("Hủy hóa đơn");
		btnHuyHoaDon.setForeground(new Color(255, 255, 255));
		btnHuyHoaDon.setBackground(new Color(255, 0, 0));
		btnHuyHoaDon.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHuyHoaDon.setIcon(new ImageIcon("src\\image\\iconcontrolbtntrangchu\\iconnhantrang.png"));
		btnHuyHoaDon.setBounds(10, 578, 140, 30);
		pnlThanhToan.add(btnHuyHoaDon);
		
		JButton btnLamMoiHoaDon = new MyButton("Làm mới");
		btnLamMoiHoaDon.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLamMoiHoaDon.setIcon(new ImageIcon("src\\image\\iconcontrolbtntrangchu\\iconlammoi.png"));
		btnLamMoiHoaDon.setBounds(168, 578, 140, 30);
		pnlThanhToan.add(btnLamMoiHoaDon);
		
		JButton btnTaoMoiHoaDon = new MyButton("Tạo hóa đơn");
		btnTaoMoiHoaDon.setBackground(new Color(255, 255, 128));
		btnTaoMoiHoaDon.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTaoMoiHoaDon.setIcon(new ImageIcon("src\\image\\iconcontrolbtntrangchu\\icontaomoi.png"));
		btnTaoMoiHoaDon.setBounds(10, 618, 298, 39);
		pnlThanhToan.add(btnTaoMoiHoaDon);
		
		JButton btnThanhTon = new MyButton("Thanh toán");
		btnThanhTon.setBackground(new Color(128, 255, 128));
		btnThanhTon.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThanhTon.setIcon(new ImageIcon("src\\image\\iconcontrolbtntrangchu\\iconthanhtoan.png"));
		btnThanhTon.setBounds(10, 667, 298, 69);
		pnlThanhToan.add(btnThanhTon);
		
//		Phần panel cho hóa đơn chờ
		JPanel pnlHoaDonCho = new JPanel();
		pnlHoaDonCho.setBackground(new Color(255, 255, 255));
		pnlHoaDonCho.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlHoaDonCho.setBounds(10, 10, 592, 200);
		pnlBanHang.add(pnlHoaDonCho);
		pnlHoaDonCho.setLayout(null);
		
		JLabel lblTitleHoaDonCho = new JLabel("Hóa đơn chờ");
		lblTitleHoaDonCho.setForeground(new Color(128, 128, 128));
		lblTitleHoaDonCho.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTitleHoaDonCho.setBounds(10, 10, 111, 20);
		pnlHoaDonCho.add(lblTitleHoaDonCho);
		
		String[] colsHoaDonCho = {"Mã hóa đơn", "Ngày tạo","Nhân viên tạo", "Tên khách hàng", "Số điện thoại"};
		modelHoaDonCho = new DefaultTableModel(colsHoaDonCho, 0);
		tableHoaDonCho = new MyTable(modelHoaDonCho);
		JScrollPane srcTbHoaDonCho = new JScrollPane(tableHoaDonCho);
		srcTbHoaDonCho.setBounds(10, 39, 572, 151);
		pnlHoaDonCho.add(srcTbHoaDonCho);
//		 Phần panel giỏ hàng
		JPanel pnlGioHang = new JPanel();
		pnlGioHang.setBackground(new Color(255, 255, 255));
		pnlGioHang.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlGioHang.setBounds(10, 525, 939, 230);
		pnlBanHang.add(pnlGioHang);
		pnlGioHang.setLayout(null);
		
		JLabel lblTitleGiohang = new JLabel("Giỏ hàng");
		lblTitleGiohang.setForeground(new Color(128, 128, 128));
		lblTitleGiohang.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTitleGiohang.setBounds(10, 10, 111, 20);
		pnlGioHang.add(lblTitleGiohang);
		
		String[] colsGiohang = {"Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Thuế","Số lượng", "Giảm giá", "Thành tiền"};
		modelGioHang = new DefaultTableModel(colsGiohang, 0);
		tableGioHang = new MyTable(modelGioHang);
		JScrollPane srcTbGioHang = new JScrollPane(tableGioHang);
		srcTbGioHang.setBounds(10, 39, 672, 181);
		tableGioHang.getColumnModel().getColumn(0).setPreferredWidth(70);
		tableGioHang.getColumnModel().getColumn(1).setPreferredWidth(130);
		pnlGioHang.add(srcTbGioHang);
		
		JButton btnXoaTatCa = new MyButton("Xóa tất cả");
		btnXoaTatCa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoaTatCa.setBounds(741, 55, 151, 35);
		pnlGioHang.add(btnXoaTatCa);
		
		JButton btnXoa = new MyButton("Xóa sản phẩm");
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoa.setBounds(741, 109, 151, 35);
		pnlGioHang.add(btnXoa);
		
		JButton btnCapNhat = new MyButton("Cập nhật số lượng");
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCapNhat.setBounds(741, 164, 151, 35);
		pnlGioHang.add(btnCapNhat);
		
//		Phần panel sản phẩm
		pnlSanPham = new JPanel();
		pnlSanPham.setBackground(new Color(255, 255, 255));
		pnlSanPham.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlSanPham.setBounds(272, 220, 677, 295);
		pnlBanHang.add(pnlSanPham);
		pnlSanPham.setLayout(null);
		
		JLabel lblTimSanPham = new JLabel("Mã sản phẩm:");
		lblTimSanPham.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTimSanPham.setBounds(10, 17, 93, 20);
		pnlSanPham.add(lblTimSanPham);
		
		txtMaSanPham = new JTextField();
		txtMaSanPham.setColumns(10);
		txtMaSanPham.setBounds(102, 17, 440, 25);
		pnlSanPham.add(txtMaSanPham);
		
		MyButton btnTimSanPham = new MyButton("Tìm sản phẩm");
		btnTimSanPham.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTimSanPham.setBounds(552, 17, 119, 25);
		pnlSanPham.add(btnTimSanPham);
		
		MyButton btnThemSanPham = new MyButton("Thêm sản phẩm");
		btnThemSanPham.setText("Thêm");
		btnThemSanPham.setBackground(new Color(255, 255, 128));
		btnThemSanPham.setIcon(new ImageIcon("src\\image\\iconcontrolbtntrangchu\\iconcong.png"));
		btnThemSanPham.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThemSanPham.setBounds(540, 165, 131, 35);
		pnlSanPham.add(btnThemSanPham);
		
		lblAnhSanPham = new JLabel();
		lblAnhSanPham.setBounds(21, 77, 131, 189);
		lblAnhSanPham.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
//		lấy hình gốc
		iconLblBgr = new ImageIcon("src\\image\\imagepanel\\logobrand.jpg");
//		phóng to hình
		Image scaledImage = ((ImageIcon) iconLblBgr).getImage().getScaledInstance(lblAnhSanPham.getWidth(), lblAnhSanPham.getHeight(), Image.SCALE_SMOOTH);
//		gán lại hình
        iconLblBgr = new ImageIcon(scaledImage);
        lblAnhSanPham.setIcon(iconLblBgr);
        pnlSanPham.add(lblAnhSanPham);
        
        pnlSanPhamSach = new JPanel();
        pnlSanPhamSach.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
        pnlSanPhamSach.setBounds(179, 52, 351, 233);
        pnlSanPham.add(pnlSanPhamSach);
        pnlSanPhamSach.setLayout(null);
        
        JLabel lblMSnPhm = new JLabel("Mã sản phẩm:");
        lblMSnPhm.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblMSnPhm.setBounds(10, 10, 89, 15);
        pnlSanPhamSach.add(lblMSnPhm);
        
        lblMaSach = new JLabel();
        lblMaSach.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblMaSach.setBounds(112, 10, 229, 15);
        pnlSanPhamSach.add(lblMaSach);
        
        JLabel lblTnSnPhm = new JLabel("Tên sản phẩm:");
        lblTnSnPhm.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblTnSnPhm.setBounds(10, 35, 89, 15);
        pnlSanPhamSach.add(lblTnSnPhm);
        
        lblTenSach = new JLabel();
        lblTenSach.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblTenSach.setBounds(112, 35, 229, 15);
        pnlSanPhamSach.add(lblTenSach);
        
        JLabel lblThu = new JLabel("Thuế:");
        lblThu.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblThu.setBounds(10, 60, 89, 15);
        pnlSanPhamSach.add(lblThu);
        
        lblThueSach = new JLabel();
        lblThueSach.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblThueSach.setBounds(112, 60, 229, 15);
        pnlSanPhamSach.add(lblThueSach);
        
        JLabel lblGiBn = new JLabel("Giá bán:");
        lblGiBn.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblGiBn.setBounds(10, 85, 89, 15);
        pnlSanPhamSach.add(lblGiBn);
        
        lblGiaBanSach = new JLabel();
        lblGiaBanSach.setForeground(new Color(255, 0, 0));
        lblGiaBanSach.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblGiaBanSach.setBounds(112, 85, 229, 15);
        pnlSanPhamSach.add(lblGiaBanSach);
        
        JLabel lblThLoi = new JLabel("Thể loại:");
        lblThLoi.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblThLoi.setBounds(10, 110, 89, 15);
        pnlSanPhamSach.add(lblThLoi);
        
        lblTheLoaiSach = new JLabel();
        lblTheLoaiSach.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblTheLoaiSach.setBounds(112, 110, 229, 15);
        pnlSanPhamSach.add(lblTheLoaiSach);
        
        JLabel lblTcGi = new JLabel("Tác giả:");
        lblTcGi.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblTcGi.setBounds(10, 135, 89, 15);
        pnlSanPhamSach.add(lblTcGi);
        
        lblTacGia = new JLabel();
        lblTacGia.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblTacGia.setBounds(112, 135, 229, 15);
        pnlSanPhamSach.add(lblTacGia);
        
        JLabel lblNhXutBn = new JLabel("Nhà xuất bản:");
        lblNhXutBn.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNhXutBn.setBounds(10, 160, 89, 15);
        pnlSanPhamSach.add(lblNhXutBn);
        
        lblNhaXuatBan = new JLabel();
        lblNhaXuatBan.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNhaXuatBan.setBounds(112, 160, 229, 15);
        pnlSanPhamSach.add(lblNhaXuatBan);
        
        JLabel lblNmSnXut = new JLabel("Năm sản xuất:");
        lblNmSnXut.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNmSnXut.setBounds(10, 185, 89, 15);
        pnlSanPhamSach.add(lblNmSnXut);
        
        lblNamSanXuat = new JLabel();
        lblNamSanXuat.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNamSanXuat.setBounds(112, 185, 229, 15);
        pnlSanPhamSach.add(lblNamSanXuat);
        
        JLabel lblSLngTn = new JLabel("Số lượng tồn:");
        lblSLngTn.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblSLngTn.setBounds(10, 208, 89, 15);
        pnlSanPhamSach.add(lblSLngTn);
        
        lblSoLuongTonSach = new JLabel();
        lblSoLuongTonSach.setForeground(new Color(255, 128, 0));
        lblSoLuongTonSach.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblSoLuongTonSach.setBounds(112, 208, 229, 15);
        pnlSanPhamSach.add(lblSoLuongTonSach);
        
        pnlSanPhamVPP = new JPanel();
        pnlSanPhamVPP.setLayout(null);
        pnlSanPhamVPP.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
        pnlSanPhamVPP.setBounds(179, 52, 351, 233);
        
        JLabel lblMSnPhm_1 = new JLabel("Mã sản phẩm:");
        lblMSnPhm_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblMSnPhm_1.setBounds(10, 10, 89, 15);
        pnlSanPhamVPP.add(lblMSnPhm_1);
        
        lblMaVPP = new JLabel("SP02");
        lblMaVPP.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblMaVPP.setBounds(112, 10, 229, 15);
        pnlSanPhamVPP.add(lblMaVPP);
        
        JLabel lblTnSnPhm_1 = new JLabel("Tên sản phẩm:");
        lblTnSnPhm_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblTnSnPhm_1.setBounds(10, 35, 89, 15);
        pnlSanPhamVPP.add(lblTnSnPhm_1);
        
        lblTenVPP = new JLabel();
        lblTenVPP.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblTenVPP.setBounds(112, 35, 229, 15);
        pnlSanPhamVPP.add(lblTenVPP);
        
        JLabel lblThu_1 = new JLabel("Thuế:");
        lblThu_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblThu_1.setBounds(10, 60, 89, 15);
        pnlSanPhamVPP.add(lblThu_1);
        
        lblThueVPP = new JLabel();
        lblThueVPP.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblThueVPP.setBounds(112, 60, 229, 15);
        pnlSanPhamVPP.add(lblThueVPP);
        
        JLabel lblGiBn_1 = new JLabel("Giá bán:");
        lblGiBn_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblGiBn_1.setBounds(10, 85, 89, 15);
        pnlSanPhamVPP.add(lblGiBn_1);
        
        lblGiaVPP = new JLabel();
        lblGiaVPP.setForeground(Color.RED);
        lblGiaVPP.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblGiaVPP.setBounds(112, 85, 229, 15);
        pnlSanPhamVPP.add(lblGiaVPP);
        
        JLabel lblThLoi_1 = new JLabel("Thể loại:");
        lblThLoi_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblThLoi_1.setBounds(10, 135, 89, 15);
        pnlSanPhamVPP.add(lblThLoi_1);
        
        lblTheLoaiVPP = new JLabel();
        lblTheLoaiVPP.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblTheLoaiVPP.setBounds(112, 135, 229, 15);
        pnlSanPhamVPP.add(lblTheLoaiVPP);
        
        JLabel lblTcGi_1 = new JLabel("Danh mục:");
        lblTcGi_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblTcGi_1.setBounds(10, 110, 89, 15);
        pnlSanPhamVPP.add(lblTcGi_1);
        
        lblDanhMuc = new JLabel();
        lblDanhMuc.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblDanhMuc.setBounds(112, 110, 229, 15);
        pnlSanPhamVPP.add(lblDanhMuc);
        
        JLabel lblNhXutBn_1 = new JLabel("Chất liệu:");
        lblNhXutBn_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNhXutBn_1.setBounds(10, 160, 89, 15);
        pnlSanPhamVPP.add(lblNhXutBn_1);
        
        lblChatLieu = new JLabel();
        lblChatLieu.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblChatLieu.setBounds(112, 160, 229, 15);
        pnlSanPhamVPP.add(lblChatLieu);
        
        JLabel lblNmSnXut_1_1 = new JLabel("Số lượng tồn:");
        lblNmSnXut_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNmSnXut_1_1.setBounds(10, 185, 89, 15);
        pnlSanPhamVPP.add(lblNmSnXut_1_1);
        
        lblSoLuongTonVPP = new JLabel();
        lblSoLuongTonVPP.setForeground(new Color(255, 128, 64));
        lblSoLuongTonVPP.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblSoLuongTonVPP.setBounds(112, 185, 229, 15);
        pnlSanPhamVPP.add(lblSoLuongTonVPP);
		
//		Phần panel khách hàng
		JPanel pnlKhachHang = new JPanel();
		pnlKhachHang.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlKhachHang.setBackground(Color.WHITE);
		pnlKhachHang.setBounds(612, 10, 337, 200);
		pnlBanHang.add(pnlKhachHang);
		pnlKhachHang.setLayout(null);
		
		JLabel lblTitleKhachHang = new JLabel("Khách hàng");
		lblTitleKhachHang.setForeground(new Color(128, 128, 128));
		lblTitleKhachHang.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTitleKhachHang.setBounds(10, 10, 111, 20);
		pnlKhachHang.add(lblTitleKhachHang);
		
		JLabel lblSdtKhchHng = new JLabel("SDT khách hàng:");
		lblSdtKhchHng.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSdtKhchHng.setBounds(10, 40, 111, 20);
		pnlKhachHang.add(lblSdtKhchHng);
		
		txtTimKhachHang = new JTextField();
		txtTimKhachHang.setBounds(10, 70, 228, 25);
		pnlKhachHang.add(txtTimKhachHang);
		txtTimKhachHang.setColumns(10);
		
		JButton btnTimKhachHang = new MyButton("Tìm");
		btnTimKhachHang.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTimKhachHang.setBounds(248, 70, 79, 25);
		pnlKhachHang.add(btnTimKhachHang);
		
		JPanel pnlKhachHangDaChon = new JPanel();
		pnlKhachHangDaChon.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
		pnlKhachHangDaChon.setBounds(10, 105, 317, 85);
		pnlKhachHang.add(pnlKhachHangDaChon);
		pnlKhachHangDaChon.setLayout(null);
		
		JLabel lblMKhchHng = new JLabel("Mã khách hàng:");
		lblMKhchHng.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMKhchHng.setBounds(10, 10, 92, 15);
		pnlKhachHangDaChon.add(lblMKhchHng);
		
		lblMaKhachHang = new JLabel();
		lblMaKhachHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaKhachHang.setBounds(112, 10, 195, 15);
		pnlKhachHangDaChon.add(lblMaKhachHang);
		
		JLabel lblSdtKhchHng_1_2 = new JLabel("Tên khách hàng:");
		lblSdtKhchHng_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSdtKhchHng_1_2.setBounds(10, 35, 96, 15);
		pnlKhachHangDaChon.add(lblSdtKhchHng_1_2);
		
		lblTenKhachHang = new JLabel();
		lblTenKhachHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenKhachHang.setBounds(116, 35, 191, 15);
		pnlKhachHangDaChon.add(lblTenKhachHang);
		
		JLabel lblSdtKhchHng_1_2_1 = new JLabel("Điểm tích lũy:");
		lblSdtKhchHng_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSdtKhchHng_1_2_1.setBounds(10, 60, 82, 15);
		pnlKhachHangDaChon.add(lblSdtKhchHng_1_2_1);
		
		lblDiemTichLuy = new JLabel();
		lblDiemTichLuy.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiemTichLuy.setBounds(112, 60, 195, 15);
		pnlKhachHangDaChon.add(lblDiemTichLuy);
		
		this.capNhatThongTinKhachHangGiaoDien();
		
		JPanel pnlQuetMa = new JPanel();
		pnlQuetMa.setLayout(null);
		pnlQuetMa.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlQuetMa.setBackground(Color.WHITE);
		pnlQuetMa.setBounds(10, 220, 252, 296);
		pnlBanHang.add(pnlQuetMa);
		
		JLabel lblQutMSn = new JLabel("Quét mã sản phẩm");
		lblQutMSn.setForeground(new Color(128, 128, 128));
		lblQutMSn.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblQutMSn.setBounds(10, 10, 136, 20);
		pnlQuetMa.add(lblQutMSn);
		
		pnlKhungQuetMa = new JPanel();
		pnlKhungQuetMa.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlKhungQuetMa.setBounds(10, 40, 232, 246);
		pnlQuetMa.add(pnlKhungQuetMa);
		
		this.capNhatDSHoaDonCho();
		this.capNhatHoaDonHienTai();
		
//		Phần quản lý hóa đơn
		JPanel pnlQlHoaDon = new JPanel();
		tabbedPane.addTab("Quản lý hóa đơn", null, pnlQlHoaDon, null);
		pnlQlHoaDon.setLayout(null);
		
		JPanel pnlTimHoaDon = new JPanel();
		pnlTimHoaDon.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlTimHoaDon.setBackground(new Color(255, 255, 255));
		pnlTimHoaDon.setBounds(10, 10, 954, 197);
		pnlQlHoaDon.add(pnlTimHoaDon);
		pnlTimHoaDon.setLayout(null);
		
		JLabel lblTmHan = new JLabel("Tìm hóa đơn");
		lblTmHan.setForeground(Color.GRAY);
		lblTmHan.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTmHan.setBounds(10, 10, 111, 20);
		pnlTimHoaDon.add(lblTmHan);
		
		JLabel lblTmKimHa = new JLabel("Tìm kiếm hóa đơn:");
		lblTmKimHa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTmKimHa.setBounds(10, 40, 111, 25);
		pnlTimHoaDon.add(lblTmKimHa);
		
		txtQLHDTimHoaDon = new JTextField();
		txtQLHDTimHoaDon.setBounds(156, 40, 230, 25);
		pnlTimHoaDon.add(txtQLHDTimHoaDon);
		txtQLHDTimHoaDon.setColumns(10);
		
		JLabel lblTnNhnVin = new JLabel("Mã nhân viên:");
		lblTnNhnVin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTnNhnVin.setBounds(10, 75, 111, 25);
		pnlTimHoaDon.add(lblTnNhnVin);
		
		txtQLHDMaNhanVien = new JTextField();
		txtQLHDMaNhanVien.setColumns(10);
		txtQLHDMaNhanVien.setBounds(156, 75, 230, 25);
		pnlTimHoaDon.add(txtQLHDMaNhanVien);
		
		JLabel lblSdtKhchHng_1 = new JLabel("SDT khách hàng:");
		lblSdtKhchHng_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSdtKhchHng_1.setBounds(10, 110, 111, 25);
		pnlTimHoaDon.add(lblSdtKhchHng_1);
		
		txtQLHDDienThoaiKH = new JTextField();
		txtQLHDDienThoaiKH.setColumns(10);
		txtQLHDDienThoaiKH.setBounds(156, 110, 230, 25);
		pnlTimHoaDon.add(txtQLHDDienThoaiKH);
		
		JLabel lblHnhThcThanh_1 = new JLabel("Hình thức thanh toán:");
		lblHnhThcThanh_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHnhThcThanh_1.setBounds(10, 145, 136, 25);
		pnlTimHoaDon.add(lblHnhThcThanh_1);
		
		JComboBox cbbQLHDHinhThucTT = new MyCombobox();
		cbbQLHDHinhThucTT.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbbQLHDHinhThucTT.setBounds(156, 145, 230, 25);
		cbbQLHDHinhThucTT.addItem("Tất cả");
		cbbQLHDHinhThucTT.addItem("Tiền mặt");
		cbbQLHDHinhThucTT.addItem("Chuyển khoản");
		pnlTimHoaDon.add(cbbQLHDHinhThucTT);
		
		JLabel lblTNgy = new JLabel("Từ ngày:");
		lblTNgy.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTNgy.setBounds(508, 40, 77, 25);
		pnlTimHoaDon.add(lblTNgy);
		
		JLabel lblnNgy = new JLabel("Đến ngày:");
		lblnNgy.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblnNgy.setBounds(508, 75, 77, 25);
		pnlTimHoaDon.add(lblnNgy);
		
		JPanel pnlQLHDChucNang = new JPanel();
		pnlQLHDChucNang.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlQLHDChucNang.setBackground(new Color(255, 255, 255));
		pnlQLHDChucNang.setBounds(974, 10, 303, 197);
		pnlQlHoaDon.add(pnlQLHDChucNang);
		pnlQLHDChucNang.setLayout(null);
		
		MyButton btnQLHDIn = new MyButton("Tìm");
		btnQLHDIn.setText("In hóa đơn");
		btnQLHDIn.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnQLHDIn.setBounds(70, 56, 163, 36);
		pnlQLHDChucNang.add(btnQLHDIn);
		
		MyButton btnQLHDTaiLai = new MyButton("Tìm");
		btnQLHDTaiLai.setText("Tải lại");
		btnQLHDTaiLai.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnQLHDTaiLai.setBounds(70, 102, 163, 36);
		pnlQLHDChucNang.add(btnQLHDTaiLai);
		
		MyButton btnQLHDSapXep = new MyButton("Tìm");
		btnQLHDSapXep.setText("Sắp xếp theo tổng tiền");
		btnQLHDSapXep.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnQLHDSapXep.setBounds(70, 149, 163, 36);
		pnlQLHDChucNang.add(btnQLHDSapXep);
		
		MyButton btnQLHDLoc = new MyButton("Tìm");
		btnQLHDLoc.setText("Lọc hóa đơn");
		btnQLHDLoc.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnQLHDLoc.setBounds(70, 10, 163, 36);
		pnlQLHDChucNang.add(btnQLHDLoc);
		
		JPanel pnlQLHDDSHoaDon = new JPanel();
		pnlQLHDDSHoaDon.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlQLHDDSHoaDon.setBackground(Color.WHITE);
		pnlQLHDDSHoaDon.setBounds(10, 217, 1267, 280);
		pnlQlHoaDon.add(pnlQLHDDSHoaDon);
		pnlQLHDDSHoaDon.setLayout(null);
		
		JLabel lblDanhSchHa = new JLabel("Danh sách hóa đơn");
		lblDanhSchHa.setForeground(Color.GRAY);
		lblDanhSchHa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDanhSchHa.setBounds(10, 10, 137, 20);
		pnlQLHDDSHoaDon.add(lblDanhSchHa);
		
		String[] colsHoaDon = {"Mã hóa đơn", "Tổng tiền","Thanh toán", "Tiền khách trả", "Tiền thừa", "Phương thức thanh toán", "Ngày lập hóa đơn", "Mã NV", "Tên NV", "Tên KH", "SDT KH", "Ghi chú"};
		modelHoaDon = new DefaultTableModel(colsHoaDon, 0);
		tableHoaDon = new MyTable(modelHoaDon);
		JScrollPane srcTbHoaDon = new JScrollPane(tableHoaDon);
		srcTbHoaDon.setBounds(10, 40, 1247, 230);
		tableHoaDon.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		for(int i = 0; i < tableHoaDon.getColumnCount(); i++) {
			tableHoaDon.getColumnModel().getColumn(i).setPreferredWidth(150);
		}
		modelHoaDon.addRow(new Object[] {
				"HD1", "1.000.000", "900.000", "900.000", "0", "Tiền mặt", "16/08/2023", "NV1", "Huỳnh Quốc Bảo", "Nguyễn Văn A", "0353426938", "Trống"
		});
		modelHoaDon.addRow(new Object[] {
				"HD1", "1.000.000", "900.000", "900.000", "0", "Tiền mặt", "16/08/2023", "NV1", "Huỳnh Quốc Bảo", "Nguyễn Văn A", "0353426938", "Trống"
		});
		modelHoaDon.addRow(new Object[] {
				"HD1", "1.000.000", "900.000", "900.000", "0", "Tiền mặt", "16/08/2023", "NV1", "Huỳnh Quốc Bảo", "Nguyễn Văn A", "0353426938", "Trống"
		});
		modelHoaDon.addRow(new Object[] {
				"HD1", "1.000.000", "900.000", "900.000", "0", "Tiền mặt", "16/08/2023", "NV1", "Huỳnh Quốc Bảo", "Nguyễn Văn A", "0353426938", "Trống"
		});
		pnlQLHDDSHoaDon.add(srcTbHoaDon);
		
		JPanel pnlQLHDChiTietHoaDon = new JPanel();
		pnlQLHDChiTietHoaDon.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlQLHDChiTietHoaDon.setBackground(Color.WHITE);
		pnlQLHDChiTietHoaDon.setBounds(10, 507, 1267, 249);
		pnlQlHoaDon.add(pnlQLHDChiTietHoaDon);
		pnlQLHDChiTietHoaDon.setLayout(null);
		
		JLabel lblChiTitHa = new JLabel("Chi tiết hóa đơn");
		lblChiTitHa.setForeground(Color.GRAY);
		lblChiTitHa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblChiTitHa.setBounds(10, 10, 137, 20);
		pnlQLHDChiTietHoaDon.add(lblChiTitHa);
		
		String[] colsChiTietHoaDon = {"Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá bán", "Đơn giá", "Giảm giá", "Thành tiền"};
		modelChiTietHoaDon = new DefaultTableModel(colsChiTietHoaDon, 0);
		tableChiTietHoaDon = new MyTable(modelChiTietHoaDon);
		JScrollPane srcTbChiTietHoaDon = new JScrollPane(tableChiTietHoaDon);
		srcTbChiTietHoaDon.setBounds(10, 40, 1247, 199);
		modelChiTietHoaDon.addRow(new Object[] {"SP1", "Sách hóa học", "1", "100.000", "100.000", "10.000", "90.000"});
		modelChiTietHoaDon.addRow(new Object[] {"SP1", "Sách hóa học", "1", "100.000", "100.000", "10.000", "90.000"});
		modelChiTietHoaDon.addRow(new Object[] {"SP1", "Sách hóa học", "1", "100.000", "100.000", "10.000", "90.000"});
		modelChiTietHoaDon.addRow(new Object[] {"SP1", "Sách hóa học", "1", "100.000", "100.000", "10.000", "90.000"});
		pnlQLHDChiTietHoaDon.add(srcTbChiTietHoaDon);
		
		JDateChooser dateQLHDTuNgay = new JDateChooser();
		dateQLHDTuNgay.setLocale(new Locale("vi", "VN"));
		dateQLHDTuNgay.setBounds(595, 40, 230, 25);
		
		JDateChooser dateQLHDDenNGay = new JDateChooser();
		dateQLHDDenNGay.setLocale(new Locale("vi", "VN"));
		dateQLHDDenNGay.setBounds(595, 75, 230, 25);
		
		pnlTimHoaDon.add(dateQLHDTuNgay);
		pnlTimHoaDon.add(dateQLHDDenNGay);
		
		JLabel lblSdtKhchHng_1_1 = new JLabel("Tổng tiền:");
		lblSdtKhchHng_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSdtKhchHng_1_1.setBounds(508, 110, 67, 25);
		pnlTimHoaDon.add(lblSdtKhchHng_1_1);
		
		JComboBox cbbQLHDTongTien = new MyCombobox();
		cbbQLHDTongTien.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbbQLHDTongTien.addItem("Tất cả");
		cbbQLHDTongTien.addItem("Dưới 1.000.000");
		cbbQLHDTongTien.addItem("Từ 1.000.000 đến 2.000.000");
		cbbQLHDTongTien.addItem("Từ 2.000.000 đến 5.000.000");
		cbbQLHDTongTien.addItem("Từ 5.000.000 đến 10.000.000");
		cbbQLHDTongTien.addItem("Trên 10.000.000");
		cbbQLHDTongTien.setBounds(595, 113, 230, 25);
		pnlTimHoaDon.add(cbbQLHDTongTien);
//		pnlQlHoaDon.add(dateChooser);dateChooser.addPropertyChangeListener("date", new PropertyChangeListener() {
//		    @Override
//		    public void propertyChange(PropertyChangeEvent e) {
//		        if ("date".equals(e.getPropertyName())) {
//		            // Xử lý khi ngày thay đổi
//		            Date selectedDate = dateChooser.getDate();
//		            System.out.println(selectedDate);
//		            // Thực hiện các thao tác cần thiết với selectedDate
//		        }
//		    }
//		});
		
		//Tạo webcam
		initWebCam();
	}
	//Hàm tạo QR code
	private void initWebCam() {
		Dimension size = WebcamResolution.QVGA.getSize();
		webcam = Webcam.getWebcams().get(0);
		webcam.setViewSize(size);
		
		panel = new WebcamPanel(webcam);
		panel.setSize(232, 246);
		panel.setPreferredSize(size);
		panel.setFPSDisplayed(true);
		pnlKhungQuetMa.add(panel);
		executor.execute(this);
	}
	@Override
	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		Thread t = new Thread(r,"My Thread");
		t.setDaemon(true);
		
		return t;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		do {
			try {
				Thread.sleep(100);
			}catch (InterruptedException ex) {
				Logger.getLogger(GUIBanHang.class.getName()).log(Level.SEVERE,null,ex);
			}
			Result result = null;
			BufferedImage image = null;
			
			if(webcam.isOpen()) {
				if((image = webcam.getImage())==null) {
					continue;
				}
			}
			if(image != null) {
				LuminanceSource source = new BufferedImageLuminanceSource(image);
				BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
				try {
					result = new MultiFormatReader().decode(bitmap);
				} catch (NotFoundException e) {
					// TODO Auto-generated catch block
					
				}
			}
			if(result != null && !result.getText().equals(resultScanQRBefore)) {
				txtMaSanPham.setText(result.getText());
				SanPham sanPhamQuet = new BUSSanPham().timKiemSanPham(result.getText());
//				lấy hình gốc
				iconLblBgr = new ImageIcon(sanPhamQuet.getHinhAnh());
//				phóng to hình
				Image scaledImage = ((ImageIcon) iconLblBgr).getImage().getScaledInstance(lblAnhSanPham.getWidth(), lblAnhSanPham.getHeight(), Image.SCALE_SMOOTH);
//				gán lại hình
		        iconLblBgr = new ImageIcon(scaledImage);
		        lblAnhSanPham.setIcon(iconLblBgr);
		        pnlSanPham.add(lblAnhSanPham);
		        pnlSanPham.remove(pnlSanPhamSach);
		        pnlSanPham.remove(pnlSanPhamVPP);
				if(sanPhamQuet.getMaSanPham().startsWith("SPS")) {
			        lblMaSach.setText(sanPhamQuet.getMaSanPham());
			        lblTenSach.setText(sanPhamQuet.getTenSanPham());
			        lblThueSach.setText(sanPhamQuet.getThue() + "");
			        lblGiaBanSach.setText(sanPhamQuet.getGiaBan() + "");
			        lblTheLoaiSach.setText(sanPhamQuet.getTheLoai());
			        lblTacGia.setText(((Sach) sanPhamQuet).getTacGia());
			        lblNhaXuatBan.setText(((Sach) sanPhamQuet).getNhaXuatBan());
			        lblNamSanXuat.setText(((Sach) sanPhamQuet).getNamXuatBan() + "");
			        lblSoLuongTonSach.setText(sanPhamQuet.getSoLuongTon() + "");
			        pnlSanPham.add(pnlSanPhamSach);
				} else {
					lblMaVPP.setText(sanPhamQuet.getMaSanPham());
			        lblTenVPP.setText(sanPhamQuet.getTenSanPham());
			        lblThueVPP.setText(sanPhamQuet.getThue() + "");
			        lblGiaVPP.setText(sanPhamQuet.getGiaBan() + "");
			        lblTheLoaiVPP.setText(sanPhamQuet.getTheLoai());
			        lblSoLuongTonVPP.setText(sanPhamQuet.getSoLuongTon() + "");
			        lblDanhMuc.setText(((VanPhongPham) sanPhamQuet).getDanhMuc().getTenDanhMuc());
			        lblChatLieu.setText(((VanPhongPham) sanPhamQuet).getChatLieu() + "");
					pnlSanPham.add(pnlSanPhamVPP);
				}
		        pnlSanPham.repaint();
				resultScanQRBefore = result.getText();
			}
		}while(view.indexFrame.equals("Bán hàng"));
		webcam.close();
	}
	
	public void capNhatDSHoaDonCho() {
		for (HoaDon hoaDon : dsHoaDonCho) {
			modelHoaDonCho.addRow(new Object[] {
					hoaDon.getMaHoaDon(), hoaDon.getNgayLap(), hoaDon.getNhanVien().getTenNhanVien(), hoaDon.getKhachHang().getTenKhachHang(), hoaDon.getKhachHang().getSdt()
			});
		}
	}
	
	public void capNhatHoaDonHienTai() {
		if(hoaDonHienTai != null) {
			khachHang = hoaDonHienTai.getKhachHang();
			ctkmCuaHoaDon = hoaDonHienTai.getCtkm();
		}
		this.capNhatThongTinKhachHangGiaoDien();
		this.capNhatGioHang();
		this.capNhatThongTinThanhToan();
	}
	
	public void capNhatThongTinKhachHangGiaoDien() {
		lblMaKhachHang.setText(khachHang.getMaKhachHang());
		lblTenKhachHang.setText(khachHang.getTenKhachHang());
		lblDiemTichLuy.setText(khachHang.getDiemTichLuy() + "");
	}
	
	public void capNhatGioHang() {
		modelGioHang.setRowCount(0);
		for (ChiTietHoaDon cthd : hoaDonHienTai.getDsChiTietHoaDon()) {
			float giamGia = BUSHoaDon.hamLayGiamGiaCuaChiTietHoaDon(ctkmCuaHoaDon, cthd.getSanPham());
			float tongTien = cthd.getGiaBan() * cthd.getSoLuongMua() * (1 + cthd.getSanPham().getThue() / 100) * (1 - giamGia / 100);
			modelGioHang.addRow(new Object[] {
					cthd.getSanPham().getMaSanPham(), cthd.getSanPham().getTenSanPham(), Tools.dinhDangTien(cthd.getGiaBan()), cthd.getSanPham().getThue() + "%", cthd.getSoLuongMua(), giamGia + "%", Tools.dinhDangTien(tongTien) 
			});
		}
	}
	
	public void capNhatThongTinThanhToan() {
		lblMaHoaDon.setText(hoaDonHienTai.getMaHoaDon());
		cbbDiemGiamGia.removeAllItems();
		for(int i = 0; i <= khachHang.getDiemTichLuy() / 5; i++) {
			cbbDiemGiamGia.addItem(5 * i);
		}
		lblTongTien.setText(Tools.dinhDangTien(hoaDonHienTai.tinhTongTien()));
		lblTenChuongTrinhKhuyenMai.setText(hoaDonHienTai.getCtkm().getTenCTKM());
		lblThanhToan.setText(Tools.dinhDangTien(hoaDonHienTai.getThanhTien()));
	}
}
