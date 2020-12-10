package master_CH09;

import javax.swing.*;
import java.awt.*;


public class Challenge9 extends JFrame {
	Challenge9(){
		setTitle("Open Challenge 9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		c.add(new NorthPanel(), BorderLayout.NORTH);
		c.add(new CenterPanel(), BorderLayout.CENTER);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	class NorthPanel extends JPanel {
		NorthPanel(){
			setBackground(Color.LIGHT_GRAY);
			setLayout(new FlowLayout());
			add(new JButton("open"));
			add(new JButton("Read"));
			add(new JButton("Close"));
			}	
		}
	class CenterPanel extends JPanel {
		CenterPanel() {
			setLayout(null);
			JLabel a = new JLabel("Hello");
			a.setLocation(100, 10);
			a.setSize(100, 20);
			JLabel b = new JLabel("Java");
			b.setLocation(20, 150);
			b.setSize(100, 20);
			JLabel c = new JLabel("Love");
			c.setLocation(200, 120);
			c.setSize(100, 20);
			add(a);
			add(b);
			add(c);
		}
	}
		
	public static void main(String[] args) {
		new Challenge9();
	}
}
