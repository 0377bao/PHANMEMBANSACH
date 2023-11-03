package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.GUIGiaoHang;

public class ControllerGiaoHang implements ActionListener{
	private GUIGiaoHang view;
	public ControllerGiaoHang(GUIGiaoHang view) {
		this.view = view;
   }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		view.XuLyDonHang(src);;
	}
   
   
}
