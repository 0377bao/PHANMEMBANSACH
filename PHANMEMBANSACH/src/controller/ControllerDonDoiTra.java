package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

import customUI.MyTable;
import ui.GUIDoiTraHang;

public class ControllerDonDoiTra implements FocusListener, ActionListener, MouseListener, KeyListener {
	private GUIDoiTraHang guiDonDoiTra;

	public ControllerDonDoiTra(GUIDoiTraHang guiDonDoiTra) {
		super();
		this.guiDonDoiTra = guiDonDoiTra;
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		guiDonDoiTra.xoaPlaceholder();

	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		guiDonDoiTra.themPlaceholder();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if(src.equals("btnTimKiemKhachHang")|| src.equals("txtTimKiemHoaDon")) {
			guiDonDoiTra.timKiemHoaDonCuaKhachHangTrong7Ngay();
		} else if (src.equals("btnTaoDonDoiTra")) {
			guiDonDoiTra.taoDonDoiTra();
		} else if (src.equals("btnThemSanPham")) {
			guiDonDoiTra.themSanPhamVaoDonDoiTra();
		} else if (src.equals("btnXoaSanPham")) {
			guiDonDoiTra.xoaSanPhamRaDonDoiTra();
		} else if (src.equals("btnHoanThanhDon")) {
			guiDonDoiTra.hoanThanhDonDoiTra();
		} else if (src.equals("btnHuy")) {
			guiDonDoiTra.huyDDT();
		} else if (src.equals("btnXoaTrangQL")) {
			guiDonDoiTra.xoaThongTinDonDoiTraCoSan();
		} else if (src.equals("btnTaiLai")) {
			guiDonDoiTra.taiLaiDSDDT();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		MyTable clickedTable = (MyTable) e.getSource();
		if (clickedTable.getName().equals("tbDanhSachHoaDon")) {
			guiDonDoiTra.hienThongTinHoaDon();
			guiDonDoiTra.hienDSSanPham();
		} else {
			guiDonDoiTra.hienThongTinDonDoiTra();
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		JTextField txtKey = (JTextField) e.getSource();
		if (txtKey.getName().equals("txtMaDonDoiTraTimKiemQL") || txtKey.getName().equals("txtSDTTimKiemQL")
				|| txtKey.getName().equals("txtMaHDTimKiemQL")) {
			guiDonDoiTra.timKiemDonDoiTra();
		}
	}
}
