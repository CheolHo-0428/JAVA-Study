package master_CH09;

import javax.swing.*;
import java.awt.*;

public class GL extends JFrame {
	public GL() {
		setTitle("Ten Buttons Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		GridLayout grid = new GridLayout(1,10);
		c.setLayout(grid);
		
		JButton[]button = new JButton[10];
//		Color[]color = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
//				Color.CYAN, Color.BLUE, Color.MAGENTA, Color.GRAY,
//				Color.PINK, Color.LIGHT_GRAY};
		for(int i=0; i<button.length; i=i+1) {
			button[i] = new JButton(Integer.toString(i));
//			button[i].setBackground(color[i]);
//			button[i].setOpaque(true);
			c.add(button[i]);
		}
		setSize(500,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new GL();
	}
}
