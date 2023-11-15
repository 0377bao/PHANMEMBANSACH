package ui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class PopUp extends JFrame{

	public PopUp(String message) {
		getContentPane().setBackground(new Color(255, 255, 255));
		this.setSize(400, 100);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		JLabel lblTitle = new JLabel(message);
		lblTitle.setBackground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));

		// lấy hình gốc
		ImageIcon logoFrame = new ImageIcon("src\\image\\iconcontrolbtntrangchu\\loading.gif");
		lblTitle.setIcon(logoFrame);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(lblTitle, BorderLayout.CENTER);
		ImageIcon logoFrame1 = new ImageIcon(new ImageIcon("src\\image\\logodangnhap\\logo.png").getImage()
				.getScaledInstance(70, 70, Image.SCALE_SMOOTH));
		this.setIconImage(logoFrame1.getImage());
	}

	public static void main(String[] args) {
		new PopUp("Đang chờ xử lý").setVisible(true);
	}
}
