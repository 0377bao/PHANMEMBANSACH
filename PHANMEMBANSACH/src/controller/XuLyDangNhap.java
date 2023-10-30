package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.GUIDangNhap;

public class XuLyDangNhap {
	private GUIDangNhap view;
	
	public XuLyDangNhap(GUIDangNhap view) {
		super();
		this.view = view;
		
		this.view.addSuKienChoDangNhap(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.xulydangnhap();
			}
		});
	}
}
