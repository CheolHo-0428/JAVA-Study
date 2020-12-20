package Admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Pos.POS_Main;
import Pos.PosPanel;

public class AdminPage_Panel extends JPanel {
	JTabbedPane tPane = new JTabbedPane();
	
	String[] Headings = {"번호", "품목명", "수량", "가격", "합계"};
	String[] Name;
	int[] Price;
	int[] Count;
	int[] Sum;
	String[][] Data;
	JTextField jtf = new JTextField(10);
	
	DefaultTableModel model = new DefaultTableModel(Data, Headings);
	JTable table = new JTable(model);
	
	//판매관리 Tab
	class SalesTab extends JPanel {
		public SalesTab() {	
			// 추가 부분
			// Pos_Main -> sub 를 추가
			//
			jtf.setBackground(Color.YELLOW);
			add(jtf);
			setBackground(Color.YELLOW);
			DefaultTableModel m = (DefaultTableModel)table.getModel();
			
			int totalsum = 0;
			for(int i=0;i<PosPanel.inform.size();i++) {
				String menu = PosPanel.inform.get(i).menu;
				int count = PosPanel.inform.get(i).count;
				int price = PosPanel.inform.get(i).price;
				int sum = count * price;
				int number = i+1;
				m.addRow(new Object[]{number,menu,count,price,sum});
				totalsum = totalsum + sum;
			}
			jtf.setText(String.valueOf("총 매출액 : " + totalsum + "원"));
			jtf.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			
			Dimension dim = new Dimension(1000,700);			
			table.setRowHeight(30);
			table.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 15));
			table.setPreferredScrollableViewportSize(dim);
			table.setFillsViewportHeight(true);
			add(new JScrollPane(table));
		}
	}	
	//회원관리 Tab
	class MemberTab extends JPanel {		
		public MemberTab() {
			setBackground(Color.BLUE);
			
			String[] mtHeadings = {"번호", "이름", "아이디", "비밀번호", "생년월일", "성별", "전화번호", "이메일"};
			String[][] mtData = {{"1", "조철호", "CCH12", "playdata1", "1900.04", "남", "010-1234-5678", "12345@gmail.com"},
								{"2", "신준호", "SJH34", "playdata1", "1900.05", "남", "010-1111-2222", "5678@gmail.com"},
								{"3", "최종준", "CJJ56", "playdata1", "1900.06", "남", "010-3333-5555", "0987@gmail.com"},
								{"4", "김정훈", "KJH78", "playdata1", "1900.07", "남", "010-6666-7777", "6543@gmail.com"}};
			JTable table = new JTable(mtData, mtHeadings);
			Dimension dim = new Dimension(1000,700);
			table.setPreferredScrollableViewportSize(dim);
			table.setFillsViewportHeight(true);
			table.setBackground(Color.WHITE);
			table.setRowHeight(30);
			table.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 15));
				
			JScrollPane jscp = new JScrollPane(table);		
//			jscp.setLocation(500,100);
//			jscp.setSize(1000,700);
			add(jscp);													
		}
	}		
	//생성자 및 탭 디자인
	public AdminPage_Panel() {
		MemberTab mt = new MemberTab(); 		
		tPane.addTab("회원관리", mt);
				
		SalesTab st = new SalesTab();
		
		tPane.addTab("판매관리", st);
		add(tPane);		
	}
}
