package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ui.GUIKhuyenMai;

public class ControllerChuongTrinhKhuyenMai implements ActionListener, MouseListener, KeyListener {
	private GUIKhuyenMai view;

	public ControllerChuongTrinhKhuyenMai(GUIKhuyenMai view) {
		super();
		this.view = view;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		view.loadChiTietChuongTrinhKhuyenMai();
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
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		// TODO Auto-generated method stub
		view.xuLySuKienCboTrangThai(o);
		view.xuLySuKienCboMucKM(o);
        view.xuLySuKienTrenCacBtn(e.getActionCommand());
		view.xuLySuKienCboSanPham(o);	
		
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
		view.xuLyKhiTimKiem(e);
	}
	
	

}
