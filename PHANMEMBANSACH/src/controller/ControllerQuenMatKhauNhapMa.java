package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.GUIQuenMatKhauNhapMa;

public class ControllerQuenMatKhauNhapMa implements ActionListener {

	private GUIQuenMatKhauNhapMa view;
	
	public ControllerQuenMatKhauNhapMa(GUIQuenMatKhauNhapMa view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("btnGuiMa")) {
			this.view.xuLyGuiMa();
		}
		if(src.equals("btnXacNhan") || src.equals("txtXacNhan")) {
			this.view.xuLyXacNhan();
		}
	}
	
}
