package master_CH10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ListenerSample extends JFrame {
	public ListenerSample() {
		super("Action 이벤트 리스너 작성");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		//버튼 컴포넌트를 생성하고 ActionListener를 단다.
		JButton btn = new JButton("Action");
		MyActionListener listener = new MyActionListener();
		btn.addActionListener(listener);
		
		add(btn); //버튼을 컨텐트팬에 단다.
		
		setSize(350,150);
		setVisible(true);		
	}

	public static void main(String[] args) {
		new ListenerSample();
	}
}

//ActionListener을 상속받아 Action 리스너를 작성한다.
class MyActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource(); //선택된 버튼을 알아낸다.
		
		//버튼의 문자열이 "Action"이면 "액션"으로, 아니면 다시 "Action"으로 변경한다.
		if(b.getText().equals("Action")) {
			b.setText("액션");
		} else {
			b.setText("Action");
		}
	}
}
