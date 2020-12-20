package Pos;

import javax.swing.*;

public class PosFrame extends JFrame {
	public PosFrame() {
	
	setTitle("POS Å×½ºÆ®");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	setContentPane(new PosPanel_test());
	
	setSize(985,660);
	setVisible(true);
	
	}	
}