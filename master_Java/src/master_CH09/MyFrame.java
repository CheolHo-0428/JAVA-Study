package master_CH09;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
	MyFrame() {
		setTitle("첫번째 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		MyFrame my = new MyFrame();
	}
}
