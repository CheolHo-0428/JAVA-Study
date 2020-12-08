package virtualfunction;
import javax.swing.*;
import java.awt.*;

public class ContentPaneEx extends JFrame {
	//필드
	
	//생성자
	ContentPaneEx(){
		setTitle("ContentPane과 JFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.BLUE);
		contentPane.setLayout(new FlowLayout());
		contentPane.add(new JButton("OK"));
		contentPane.add(new JButton("Cancel"));
		contentPane.add(new JButton("Ignore"));
		
		setSize(500, 150);
		setVisible(true);		
	}
	
	public static void main(String[] args) {
		new ContentPaneEx();
	}
}
