package master_CH10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ListenerMouseEx extends JFrame {
	ListenerMouseEx(){
		super("��ư�� Mouse �̺�Ʈ ������ �ۼ�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		//��ư ������Ʈ�� �����ϰ� MouseListener�� �ܴ�.
		JButton btn = new JButton("Mouse Event �׽�Ʈ ��ư");
		btn.setBackground(Color.YELLOW);
		
		//���콺 �����ʸ� �����Ѵ�.
		MyMouseListener listener = new MyMouseListener();
		//���콺 �����ʸ� �ܴ�.
		btn.addMouseListener(listener);
		add(btn);
				
		setSize(300,150);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ListenerMouseEx();
	}
}

//MouseListener�� ��ӹ޾� Mouse �����ʸ� �ۼ��Ѵ�.
//MouseListener�� 5�� �޼ҵ带 ��� �����Ѵ�.
class MyMouseListener implements MouseListener {
	public void mouseEntered(MouseEvent e) { // ���콺�� ��ư�� �ö�� �� ȣ��
		JButton btn = (JButton)e.getSource();//���콺�� �ö� ��ư�� �ּҸ� �˾Ƴ���.
		btn.setBackground(Color.RED);//��ư�� ������ ���������� ����
	}
	
	public void mouseExited(MouseEvent e) { //���콺�� ��ư���� ������ �� ȣ��
		JButton btn = (JButton)e.getSource();//���콺�� ������ �� �ּҸ� �˾Ƴ���.
		btn.setBackground(Color.YELLOW);//��ư�� ������ ��������� ����
	}
	
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
}
