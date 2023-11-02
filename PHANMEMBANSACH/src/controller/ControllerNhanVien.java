package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ui.GUINhanVien;

public class ControllerNhanVien implements MouseListener,ActionListener{
	private GUINhanVien guiNhanVien ;
	
	public ControllerNhanVien(GUINhanVien guiNhanVien) {
		super();
		this.guiNhanVien = guiNhanVien;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		guiNhanVien.chonThongTin();
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("btnXoaTrang")) {
			guiNhanVien.xoaTrang();
		}
	}

}