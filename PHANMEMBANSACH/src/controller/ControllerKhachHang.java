package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ui.GUIKhachHang;

public class ControllerKhachHang implements MouseListener, ActionListener, KeyListener, ItemListener {
	private GUIKhachHang view;

	public ControllerKhachHang(GUIKhachHang view) {
		super();
		this.view = view;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.view.xuLyKhiChonBangKhachHang();
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
		String src = e.getActionCommand();
		switch (src) {
			case "btnTaoMa": {
				this.view.xuLyTaoMaKhachHang();
				break;
			}
			case "btnXoaTrang": {
				this.view.xuLyXoaTrang();
				break;
			}
			case "btnThemKhachHang":
				this.view.xuLyThemKhachHang();
				break;
			case "btnCapNhat":
				this.view.xuLyCapNhatKhachHang();
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + src);
			}
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
		this.view.xuLyTimKhachHang();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		this.view.xuLySapXepTheoTongTien();
	}

}
