package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.GUIQuenMatKhauNhapMa;
import ui.GUIQuenMatKhauNhapMatKhauMoi;

public class ControllerQuenMatKhauNhapMatKhauMoi implements ActionListener {

	private GUIQuenMatKhauNhapMatKhauMoi view;
	
	public ControllerQuenMatKhauNhapMatKhauMoi(GUIQuenMatKhauNhapMatKhauMoi view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("btnXacNhan") || src.equals("txtNhapLaiMatKhau")) {
			this.view.xuLyXacNhan();
		}
		if(src.equals("txtMatKhau")) {
			this.view.xuLyEnterMatKhauMoi();
		}
	}
	
}
