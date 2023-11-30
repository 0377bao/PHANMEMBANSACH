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

import ui.GUINhaCungCap;

public class ControllerNhaCungCap implements ActionListener, MouseListener, FocusListener, KeyListener {
	private GUINhaCungCap guiNCC;

	public ControllerNhaCungCap(GUINhaCungCap guiNCC) {
		super();
		this.guiNCC = guiNCC;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String btn = e.getActionCommand();
		if (btn.equals("btnTaoMa")) {
			guiNCC.taoMa();
		} else if (btn.equals("btnXoaTrang")) {
			guiNCC.xoaTrang();
		} else if (btn.equals("btnThemNCC")) {
			guiNCC.themNCC();
		} else if (btn.equals("btnCapNhat")) {
			guiNCC.CapNhatNCC();
		} else if (btn.equals("btnTaiLai")) {
			guiNCC.taiLai();
		} else if (btn.equals("cboDiaChi")) {
			guiNCC.xuLyTimKiem();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		guiNCC.chonThongTin();
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
	public void focusGained(FocusEvent e) {
		JTextField txt = (JTextField) e.getSource();
		if (txt.getName().equals("txtTimTheoMa_Sdt")) {
			guiNCC.focusGainedSdt();
		} else if (txt.getName().equals("txtTimTheoTen")) {
			guiNCC.focusGainedTen();
		}

	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField txt = (JTextField) e.getSource();
		if (txt.getName().equals("txtTimTheoMa_Sdt")) {
			guiNCC.focusLostSdt();
		} else if (txt.getName().equals("txtTimTheoTen")) {
			guiNCC.focusLostTen();
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
		guiNCC.xuLyTimKiem();
	}
}
