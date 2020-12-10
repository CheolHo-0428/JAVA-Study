package master_CH09;

import javax.swing.*;
import java.awt.*;

public class EX_6 extends JFrame {
	public EX_6() {
		super("Random Labels");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		JLabel [] la = new JLabel[20];
		
		for(int i=0; i<la.length; i=i+1) {
			la[i] = new JLabel();
			int x = (int)(Math.random()*200) + 50;
			int y = (int)(Math.random()*200) + 50;
			la[i].setLocation(x,y);
			la[i].setSize(10,10);
			la[i].setOpaque(true);
			la[i].setBackground(Color.BLUE);
			c.add(la[i]);			
		}
		setSize(300,300);
		setVisible(true);
	}	
	public static void main(String[] args) {
		new EX_6();
	}
}
