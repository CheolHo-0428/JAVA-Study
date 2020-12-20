package admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import menu.MenuPage;

public class AdminPage_Frame extends JFrame {
	public AdminPage_Frame() {
		
		JButton btn = new JButton("로그아웃");
		JFrame frame = new JFrame();
		
		btn.setBounds(10,10,30,30);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				new menu.PosProgramFrame();
			}
		});

		frame.setTitle("Admin");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setContentPane(new AdminPage_Panel_Test());
		
		frame.setSize(1600,1000);
		frame.setVisible(true);
		
		frame.add(btn);
		

	}
}	