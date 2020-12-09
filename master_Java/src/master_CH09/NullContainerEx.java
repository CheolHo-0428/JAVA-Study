package master_CH09;
import javax.swing.*;
import java.awt.*;


public class NullContainerEx extends JFrame{
	NullContainerEx() {
		setTitle("Null Container Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		// JLabel ������Ʈ �����ϰ� ���� ��ġ�� ũ�⸦ �����Ѵ�.
		JLabel la = new JLabel("Hello, Press Buttons!");
		la.setLocation(130, 50);
		la.setSize(200, 20);
		c.add(la);
		
		//9���� ��ư ������Ʈ�� �����ϰ� ��� ������ ũ��� �����Ѵ�.
		//��ġ�� ���� �ٸ��� ����
		for(int i=1; i<=9; i=i+1) {
			JButton b = new JButton(Integer.toString(i));
			b.setLocation(i*15, i*15);
			b.setSize(50, 20);
			c.add(b);
		}
		setSize(300,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new NullContainerEx();
	}
}