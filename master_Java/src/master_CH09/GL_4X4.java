package master_CH09;

import javax.swing.*;
import java.awt.*;

public class GL_4X4 extends JFrame {
	public GL_4X4() {
		super("4x4 Color Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(4,4));
		
		JLabel[]label = new JLabel[16];
		Color[]color = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY
					, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA
					, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE
					, Color.YELLOW, Color.BLACK, Color.BLUE, Color.CYAN};
		for(int i=0; i<label.length; i=i+1) {
			label[i] = new JLabel(Integer.toString(i));
			label[i].setOpaque(true);
			label[i].setBackground(color[i]);
			c.add(label[i]);
		}
		
		setSize(500,200);
		setVisible(true);		
	}
	
	public static void main(String[] args) {
		new GL_4X4();
	}
}
