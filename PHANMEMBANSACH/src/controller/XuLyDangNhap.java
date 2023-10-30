package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.GUIDangNhap;

public class XuLyDangNhap implements ActionListener{
	private GUIDangNhap view;
	
	public XuLyDangNhap(GUIDangNhap view) {
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
		
	}
}
