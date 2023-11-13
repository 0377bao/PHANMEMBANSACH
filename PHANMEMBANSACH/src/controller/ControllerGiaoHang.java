package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import ui.GUIGiaoHang;

public class ControllerGiaoHang implements ActionListener, KeyListener{
	private GUIGiaoHang view;
	public ControllerGiaoHang(GUIGiaoHang view) {
		this.view = view;
   }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		view.XuLyDonHang(src);
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
		view.xuLySuKienTimKiem(e);
	}
}
