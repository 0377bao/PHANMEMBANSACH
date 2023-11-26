package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.GUIDangNhap;

public class ControllerDangNhap implements ActionListener{
	private GUIDangNhap view;
	
	public ControllerDangNhap(GUIDangNhap view) {
		super();
		this.view = view;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if(src.equals("btnDangNhap")) {
			this.view.xuLyDangNhap();
		}
		if(src.equals("btnQuenMatKhau")) {
			this.view.xuLyQuenMatKhau();
		}
	}
}
