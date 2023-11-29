package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ui.TrangChu;

public class ControllerDangXuat implements ActionListener{
	private TrangChu view;
	
	public ControllerDangXuat(TrangChu view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		view.xuLyDangXuat(e);
	}

	

	

	

	

}
