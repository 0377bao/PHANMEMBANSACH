package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.GUIThongKe;

public class ControllerThongKe implements ActionListener{
	GUIThongKe guiThongKe ;
	public ControllerThongKe(GUIThongKe guiThongKe) {
		this.guiThongKe = guiThongKe;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if(src.equals("cboThongKeTheoTuan")) {
			guiThongKe.thayDoiDuLieuBangVaBieuDoTheoComBoBoxTKTheoTuan();
		}else if(src.equals("cbThongKeCuaHangTheoQuy")) {
			guiThongKe.thayDoiDuLieuBangVaBieuDoTheoQuyCuaCH();
		}else if(src.equals("cboThongKeThangCH")) {
			guiThongKe.thayDoiDuLieuBangVaPanelTrongThangCuaCH();
		}else if(src.equals("cbThongKeTrangThaiSanPham")||src.equals("cbThongKeSanPhamTrongQuy")) {
			guiThongKe.thayDoiDuLieuBangThongKeSanPham();
		}
	}
	
}
