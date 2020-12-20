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
		
		setContentPane(new AdminPage_Panel());
		
		setSize(1600,1000);
		setVisible(true);
	}
}	
	
	


//	public AdminPage_Frame() {
//		AdminPage_TabTest apT = new AdminPage_TabTest();	
//		apT.setTitle("Admin");
//		apT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		apT.setAlwaysOnTop(true);
//						
//		apT.setSize(1600,1000);
//		apT.setVisible(true);
//	}
//}