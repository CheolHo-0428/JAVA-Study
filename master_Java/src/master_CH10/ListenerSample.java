package master_CH10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ListenerSample extends JFrame {
	public ListenerSample() {
		super("Action �̺�Ʈ ������ �ۼ�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		//��ư ������Ʈ�� �����ϰ� ActionListener�� �ܴ�.
		JButton btn = new JButton("Action");
		MyActionListener listener = new MyActionListener();
		btn.addActionListener(listener);
		
		add(btn); //��ư�� ����Ʈ�ҿ� �ܴ�.
		
		setSize(350,150);
		setVisible(true);		
	}

	public static void main(String[] args) {
		new ListenerSample();
	}
}

//ActionListener�� ��ӹ޾� Action �����ʸ� �ۼ��Ѵ�.
class MyActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource(); //���õ� ��ư�� �˾Ƴ���.
		
		//��ư�� ���ڿ��� "Action"�̸� "�׼�"����, �ƴϸ� �ٽ� "Action"���� �����Ѵ�.
		if(b.getText().equals("Action")) {
			b.setText("�׼�");
		} else {
			b.setText("Action");
		}
	}
}
