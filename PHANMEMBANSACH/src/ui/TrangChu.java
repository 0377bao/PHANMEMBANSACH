package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.util.ArrayList;
import java.util.concurrent.ThreadFactory;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import bus.BUSHoaDon;

import controller.ControllerDangXuat;


import controller.ControllerTrangChu;

import customUI.ButtonSidebar;
import customUI.CustumImage;
import customUI.MyButton;
import entity.HoaDon;
import entity.NhanVien;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class TrangChu extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String indexFrame = "Trang chủ";
	private JLabel lblAvtNhanVien;
	private JLabel lblTenNhanVien;
	private ButtonSidebar btnTrangChu;
	private ButtonSidebar btnBanHang;
	private ButtonSidebar btnGiaoHang;
	private ButtonSidebar btnDoiTraHang;
	private ButtonSidebar btnNhaCungCap;
	private ButtonSidebar btnKhuyenMai;
	private ButtonSidebar btnSanPham;
	private ButtonSidebar btnKhachHang;
	private ButtonSidebar btnNhanVien;
	private ButtonSidebar btnThongKe;
	private ButtonSidebar btnHoTro;
	private MyButton btnThongTin;
	private Color colorBtnActive = new Color(10, 110, 227);
	private JPanel pnlHienTai;
	private NhanVien nvHienTai = null;
	private ArrayList<HoaDon> dsHoaDonCho = new ArrayList<>();
	private GUIThongKe guiTK ;

	public TrangChu(NhanVien nv) {
		this.nvHienTai = nv;

//		Thread daemonThread = new Thread(() -> {
//            guiTK = new GUIThongKe(nvHienTai);
//            
   //     });

        // Đặt thread là daemon
       // daemonThread.setDaemon(true);

        // Bắt đầu thực thi luồng
       // daemonThread.start();
        // Bắt đầu thực thi luồng mới

		this.setTitle("PHẦN MỀM NHÀ SÁCH");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1500, 800);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(new BorderLayout());
		//xét logo
		ImageIcon logoFrame = new ImageIcon(new ImageIcon("src\\image\\logodangnhap\\logo.png").getImage()
				.getScaledInstance(70, 70, Image.SCALE_SMOOTH));
		this.setIconImage(logoFrame.getImage());

		JPanel pnlSideBar = new JPanel();
		pnlSideBar.setBackground(new Color(97, 166, 247));
		pnlSideBar.setPreferredSize(new Dimension(250, 0));
		pnlSideBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		getContentPane().add(pnlSideBar, BorderLayout.WEST);
		pnlSideBar.setLayout(null);

		int widthLblAvtNhanVien = 130;
		lblAvtNhanVien = new JLabel(new CustumImage().taoHinhTronAvt(nv.getHinhAnh(), widthLblAvtNhanVien));
		lblAvtNhanVien.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblAvtNhanVien.setBounds(0, 0, widthLblAvtNhanVien, widthLblAvtNhanVien);
		
		btnThongTin = new MyButton("");
		btnThongTin.setBackground(new Color(97, 166, 247));
		btnThongTin.add(lblAvtNhanVien);
		btnThongTin.setBorder(null);
		btnThongTin.setBounds(60, 20, 130, 130);
		pnlSideBar.add(btnThongTin);

		lblTenNhanVien = new JLabel(nvHienTai.getTenNhanVien());
		lblTenNhanVien.setBounds(10, 150, 230, 50);
		lblTenNhanVien.setHorizontalAlignment(JLabel.CENTER);
		lblTenNhanVien.setFont(new Font("Segoe UI", Font.BOLD, 20));
		pnlSideBar.add(lblTenNhanVien);

		btnTrangChu = new ButtonSidebar("Trang chủ");
		btnTrangChu.setIcon(new ImageIcon("src\\image\\iconcontrolbtntrangchu\\icontrangchu.png"));
		btnTrangChu.setBackground(colorBtnActive);
		btnTrangChu.setForeground(Color.white);
		btnTrangChu.setBounds(30, 211, 192, 39);
		pnlSideBar.add(btnTrangChu);

		btnBanHang = new ButtonSidebar("Bán hàng");
		btnBanHang.setIcon(new ImageIcon("src\\image\\iconcontrolbtntrangchu\\iconmuahang.png"));
		btnBanHang.setBackground(Color.WHITE);
		btnBanHang.setBounds(30, 261, 192, 39);
		pnlSideBar.add(btnBanHang);

		btnGiaoHang = new ButtonSidebar("Giao hàng");
		btnGiaoHang.setIcon(new ImageIcon("src\\image\\iconcontrolbtntrangchu\\icongiaohang.png"));
		btnGiaoHang.setBackground(Color.WHITE);
		btnGiaoHang.setBounds(30, 310, 192, 39);
		pnlSideBar.add(btnGiaoHang);

		btnDoiTraHang = new ButtonSidebar("Đổi trả hàng");
		btnDoiTraHang.setIcon(new ImageIcon("src\\image\\iconcontrolbtntrangchu\\icondoitra.png"));
		btnDoiTraHang.setBackground(Color.WHITE);
		btnDoiTraHang.setBounds(30, 357, 192, 39);
		pnlSideBar.add(btnDoiTraHang);

		btnNhaCungCap = new ButtonSidebar("QL Nhà Cung Cấp");
		btnNhaCungCap.setText("QL Nhà cung cấp");
		btnNhaCungCap.setIcon(new ImageIcon("src\\image\\iconcontrolbtntrangchu\\iconncc.png"));
		btnNhaCungCap.setBackground(Color.WHITE);
		btnNhaCungCap.setBounds(30, 406, 192, 39);
		pnlSideBar.add(btnNhaCungCap);

		btnKhuyenMai = new ButtonSidebar("QL Khuyến Mãi");
		btnKhuyenMai.setText("QL Khuyến mãi");
		btnKhuyenMai.setIcon(new ImageIcon("src\\image\\iconcontrolbtntrangchu\\iconkhuyenmai.png"));
		btnKhuyenMai.setBackground(Color.WHITE);
		btnKhuyenMai.setBounds(30, 455, 192, 39);
		pnlSideBar.add(btnKhuyenMai);

		btnSanPham = new ButtonSidebar("QL Sản phẩm");
		btnSanPham.setIcon(new ImageIcon("src\\image\\iconcontrolbtntrangchu\\iconsanpham.png"));
		btnSanPham.setBackground(Color.WHITE);
		btnSanPham.setBounds(30, 504, 192, 39);
		pnlSideBar.add(btnSanPham);

		btnKhachHang = new ButtonSidebar("QL Khách hàng");
		btnKhachHang.setIcon(new ImageIcon("src\\image\\iconcontrolbtntrangchu\\iconkhachhang.png"));
		btnKhachHang.setBackground(Color.WHITE);
		btnKhachHang.setBounds(30, 553, 192, 39);
		pnlSideBar.add(btnKhachHang);

		btnNhanVien = new ButtonSidebar("QL Nhân viên");
		btnNhanVien.setIcon(new ImageIcon("src\\image\\iconcontrolbtntrangchu\\iconnhanvien.png"));
		btnNhanVien.setBackground(Color.WHITE);
		btnNhanVien.setBounds(30, 602, 192, 39);
		pnlSideBar.add(btnNhanVien);

		btnThongKe = new ButtonSidebar("QL Thống kê");
		btnThongKe.setIcon(new ImageIcon("src\\image\\iconcontrolbtntrangchu\\iconthongke.png"));
		btnThongKe.setBackground(Color.WHITE);
		btnThongKe.setBounds(30, 651, 192, 39);
		pnlSideBar.add(btnThongKe);

		btnHoTro = new ButtonSidebar("Hỗ trợ");
		btnHoTro.setIcon(new ImageIcon("src\\image\\iconcontrolbtntrangchu\\iconhotro.png"));
		btnHoTro.setBackground(Color.WHITE);
		btnHoTro.setBounds(30, 702, 192, 39);
		pnlSideBar.add(btnHoTro);

//		phần thêm sự kiện cho các nút điều hướng
		ControllerTrangChu xuLyDieuHuong = new ControllerTrangChu(this);
		btnTrangChu.addActionListener(xuLyDieuHuong);
		btnBanHang.addActionListener(xuLyDieuHuong);
		btnGiaoHang.addActionListener(xuLyDieuHuong);
		btnDoiTraHang.addActionListener(xuLyDieuHuong);
		btnNhaCungCap.addActionListener(xuLyDieuHuong);
		btnKhuyenMai.addActionListener(xuLyDieuHuong);
		btnSanPham.addActionListener(xuLyDieuHuong);
		btnKhachHang.addActionListener(xuLyDieuHuong);
		btnNhanVien.addActionListener(xuLyDieuHuong);
		btnThongKe.addActionListener(xuLyDieuHuong);
		btnHoTro.addActionListener(xuLyDieuHuong);
		
		pnlHienTai = new GUITrangChu();
		getContentPane().add(pnlHienTai);
		
		ControllerDangXuat xuLyDangXuat = new ControllerDangXuat(this);
		btnThongTin.addActionListener(xuLyDangXuat);
		
	}
	
//	public void xetMauButton() {
//		btnThongTin.setBackground(Color.red);
//	}
	
	

	// Đặt lại màu nền trắng cho tất cả các button control
	public void datLaiMauNenChoButtonControll() {
		if(indexFrame.equals("Trang chủ")) {
			btnTrangChu.setBackground(Color.WHITE);
			btnTrangChu.setForeground(Color.BLACK);
		}
		if(indexFrame.equals("Bán hàng")) {
			btnBanHang.setBackground(Color.WHITE);
			btnBanHang.setForeground(Color.BLACK);
		}
		if(indexFrame.equals("Giao hàng")) {
			btnGiaoHang.setBackground(Color.WHITE);
			btnGiaoHang.setForeground(Color.BLACK);
		}
		if(indexFrame.equals("Đổi trả hàng")) {
			btnDoiTraHang.setBackground(Color.WHITE);
			btnDoiTraHang.setForeground(Color.BLACK);
		}
		if(indexFrame.equals("QL Nhà cung cấp")) {
			btnNhaCungCap.setBackground(Color.WHITE);
			btnNhaCungCap.setForeground(Color.BLACK);
		}
		if(indexFrame.equals("QL Khuyến mãi")) {
			btnKhuyenMai.setBackground(Color.WHITE);
			btnKhuyenMai.setForeground(Color.BLACK);
		}
		if(indexFrame.equals("QL Sản phẩm")) {
			btnSanPham.setBackground(Color.WHITE);
			btnSanPham.setForeground(Color.BLACK);
		}
		if(indexFrame.equals("QL Khách hàng")) {
			btnKhachHang.setBackground(Color.WHITE);
			btnKhachHang.setForeground(Color.BLACK);
		} 
		if(indexFrame.equals("QL Nhân viên")) {
			btnNhanVien.setBackground(Color.WHITE);
			btnNhanVien.setForeground(Color.BLACK);
		} 
		if(indexFrame.equals("QL Thống kê")) {
			btnThongKe.setBackground(Color.WHITE);
			btnThongKe.setForeground(Color.BLACK);
		} 
		if(indexFrame.equals("Hỗ trợ")) {
			btnHoTro.setBackground(Color.WHITE);
			btnHoTro.setForeground(Color.BLACK);
		}
	}
	// phần sử lý điều hướng ứng dụng
	public void xuLyDieuHuong(String src) {
		if(src.equals("Hỗ trợ")) {
			openWebLink("https://0377bao.github.io/huongdanwebbansach/");
		} else {
			datLaiMauNenChoButtonControll();
			indexFrame = src;
			this.remove(pnlHienTai);
			if(src.equals("Trang chủ")) {
				pnlHienTai = new GUITrangChu();
				btnTrangChu.setBackground(colorBtnActive);
				btnTrangChu.setForeground(Color.white);
			}
			if(src.equals("Bán hàng")) {
				pnlHienTai = new GUIBanHang(this, dsHoaDonCho, nvHienTai);
				btnBanHang.setBackground(colorBtnActive);
				btnBanHang.setForeground(Color.white);
			}
			if(src.equals("Giao hàng")) {
				pnlHienTai = new GUIGiaoHang(null);
				btnGiaoHang.setBackground(colorBtnActive);
				btnGiaoHang.setForeground(Color.white);
			}
			if(src.equals("Đổi trả hàng")) {
				pnlHienTai = new GUIDoiTraHang(nvHienTai);
				btnDoiTraHang.setBackground(colorBtnActive);
				btnDoiTraHang.setForeground(Color.white);
			}
			if(src.equals("QL Nhà cung cấp")) {
				pnlHienTai = new GUINhaCungCap();
				btnNhaCungCap.setBackground(colorBtnActive);
				btnNhaCungCap.setForeground(Color.white);
			}
			if(src.equals("QL Khuyến mãi")) {
				pnlHienTai = new GUIKhuyenMai();
				btnKhuyenMai.setBackground(colorBtnActive);
				btnKhuyenMai.setForeground(Color.white);
			}
			if(src.equals("QL Sản phẩm")) {
				pnlHienTai = new GUISanPham();
				btnSanPham.setBackground(colorBtnActive);
				btnSanPham.setForeground(Color.white);
			}
			if(src.equals("QL Khách hàng")) {
				pnlHienTai = new GUIKhachHang();
				btnKhachHang.setBackground(colorBtnActive);
				btnKhachHang.setForeground(Color.white);
			} 
			if(src.equals("QL Nhân viên")) {
				pnlHienTai = new GUINhanVien();
				btnNhanVien.setBackground(colorBtnActive);
				btnNhanVien.setForeground(Color.white);
			} 
			if(src.equals("QL Thống kê")) {
				pnlHienTai = new GUIThongKe(nvHienTai);
				btnThongKe.setBackground(colorBtnActive);
				btnThongKe.setForeground(Color.white);
			} 
			
			getContentPane().add(pnlHienTai);
			this.revalidate();
			this.repaint();
		}
	}
	
	// mở web
	private static void openWebLink(String url) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Máy tính không hỗ trợ");
        }
    }
	// phần xủ lý đăng xuất
	public void xuLyDangXuat(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThongTin)) {
			new GUIThongTinNhanVien(nvHienTai, this).setVisible(true);;
		}
	}
	
	
	
	// phần xử lý đóng các chức năng theo chức vụ
	public void xuLyTinhNangTheoChucVuCuaNhanVien() {
		btnNhanVien.setEnabled(false);
		btnDoiTraHang.setEnabled(false);
		btnKhuyenMai.setEnabled(false);
		btnNhaCungCap.setEnabled(false);
	}
	
	public void chuyenHoaDonQuaGiaoHang(HoaDon hoaDon) {
		datLaiMauNenChoButtonControll();
		indexFrame = "Giao hàng";
		this.remove(pnlHienTai);
		pnlHienTai = new GUIGiaoHang(hoaDon);
		btnGiaoHang.setBackground(colorBtnActive);
		btnGiaoHang.setForeground(Color.white);
		getContentPane().add(pnlHienTai);
		this.revalidate();
		this.repaint();

	}
}

