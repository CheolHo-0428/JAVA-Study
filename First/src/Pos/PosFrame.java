package Pos;

import javax.swing.*;

public class PosFrame extends JFrame {
	public PosFrame() {
	
	setTitle("POS �׽�Ʈ");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	setContentPane(new PosPanel());
	
	setSize(985,660);
	setVisible(true);
	
	}	
}
