package master_CH09;
import javax.swing.*;
import java.awt.*;

public class FlowLayoutEx extends JFrame {
	FlowLayoutEx() {
		setTitle("FlowLayout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
		String[] button = {"add", "sub", "mul", "div", "Calculate"};
		for(int i=0; i<button.length; i=i+1) {
			c.add(new JButton(button[i]));
		}
		
		setSize(300,200);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new FlowLayoutEx();
	}
}
