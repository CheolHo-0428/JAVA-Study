package CHECKTIME;

import javax.swing.*;
import java.awt.*;

public class ck_9_3_2 extends JFrame {
	//�ʵ�
	//������
	ck_9_3_2() {
		setTitle("����2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.BLUE);
		contentPane.setLayout(new FlowLayout());
		for(int i=1; i<=5; i=i+1) {
			contentPane.add(new JButton(i +"��"));
		}	
		setSize(350, 150);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ck_9_3_2();
	}
}
