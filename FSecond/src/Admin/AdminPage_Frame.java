package Admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminPage_Frame extends JFrame {
	public AdminPage_Frame() {
		setTitle("Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new AdminPage_Panel_Test());
		
		setSize(1600,1000);
		setVisible(true);
	}
}	