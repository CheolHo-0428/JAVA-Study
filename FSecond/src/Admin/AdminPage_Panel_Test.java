package Admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Container;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.*;
import Pos.POS_Main;
import Pos.PosPanel_test;

//판매관리 회원관리 탭 패널
public class AdminPage_Panel_Test extends JPanel {
	//탭 생성
	JTabbedPane tPane = new JTabbedPane();
	
	//판매관리 Tab에 필요한 필드 값
	String[] Headings = {"번호", "품목명", "수량", "가격", "합계"};
	String[] Name;
	int[] Price;
	int[] Count;
	int[] Sum;
	String[][] Data;
	JTextField jtf = new JTextField(10);
	JTextField tf = new JTextField(10);  // 회원관리 탭에 필요한 필드값
	
	DefaultTableModel model = new DefaultTableModel(Data, Headings);
	JTable table = new JTable(model);
	Dimension dim = new Dimension(1200,850);
	
	//판매관리 패널
	class SalesTab extends JPanel {
		public SalesTab() {	
			// 판매관리 패널 바탕색
			setBackground(Color.WHITE);
			
			//생성된 테이블 다운캐스팅
			DefaultTableModel m = (DefaultTableModel)table.getModel();
			//결제된 금액 데이터 가져오기(from PosPanel_test)
			int totalsum = 0;
			for(int i=0;i<PosPanel_test.ProductList.size();i++) {
				String menu = PosPanel_test.ProductList.get(i);
				int price = PosPanel_test.PriceList.get(i);
				int count = PosPanel_test.CntList.get(i);
				int sum = count * price;
				int number = i+1;
				m.addRow(new Object[]{number,menu,count,price,sum});
				totalsum = totalsum + sum;
			}
			
			//총 매출액 출력
			jtf.setBackground(Color.WHITE);
			jtf.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			add(jtf);
			jtf.setText(String.valueOf("매출액 : " + totalsum + "원"));
						
			//테이블 서식			
			table.setRowHeight(30);
			table.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 15));
			table.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
			table.setPreferredScrollableViewportSize(dim);
			table.setFillsViewportHeight(true);
			
			//테이블 텍스트 가운데 정렬
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
			dtcr.setHorizontalAlignment(SwingConstants.CENTER);
			TableColumnModel tcm = table.getColumnModel();
			for(int i =0; i<tcm.getColumnCount(); i=i+1) {
				tcm.getColumn(i).setCellRenderer(dtcr);
			}
			//테이블 스크롤기능 추가 및 판매관리탭에 붙이기
			add(new JScrollPane(table));			
		}
	}
	
	//회원관리 패널
	class MemberTab extends JPanel {		
		public MemberTab() {
			// 회원관리 패널 바탕색			
			setBackground(Color.WHITE);
			// 회원 정보 데이터
			String[] mtHeadings = {"번호", "이름", "아이디", "비밀번호", "생년월일", "성별", "전화번호", "이메일"};
			String[][] mtData = {{"1", "조철호", "CCH12", "playdata1", "1900.04", "남", "010-1234-5678", "12345@gmail.com"},
								{"2", "신준호", "SJH34", "playdata1", "1900.05", "남", "010-1111-2222", "5678@gmail.com"},
								{"3", "최종준", "CJJ56", "playdata1", "1900.06", "남", "010-3333-5555", "0987@gmail.com"},
								{"4", "김정훈", "KJH78", "playdata1", "1900.07", "남", "010-6666-7777", "6543@gmail.com"}};
			
			//총 회원 수 출력
			tf.setBackground(Color.WHITE);
			add(tf);
			setBackground(Color.WHITE);
			tf.setText(String.valueOf("관리자 수 : 4명"));
			tf.setFont(new Font("맑은 고딕", Font.BOLD, 15));
						
			//테이블 생성 및 서식
			JTable table = new JTable(mtData, mtHeadings);		
			table.setPreferredScrollableViewportSize(dim);
			table.setFillsViewportHeight(true);
			table.setBackground(Color.WHITE);
			table.setRowHeight(30);
			table.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 15));
			
			//테이블 텍스트 가운데 정렬
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
			dtcr.setHorizontalAlignment(SwingConstants.CENTER);
			TableColumnModel tcm = table.getColumnModel();
			for(int i =0; i<tcm.getColumnCount(); i=i+1) {
				tcm.getColumn(i).setCellRenderer(dtcr);
			}
			
			//테이블 스크롤기능 추가 및 판매관리탭에 붙이기
			add(new JScrollPane(table));
		}
	}
	
	//회원관리 패널, 판매관리 패널 탭에 붙이기
	public AdminPage_Panel_Test() {
		//회원관리 패널 탭에 붙이기
		MemberTab mt = new MemberTab(); 		
		tPane.addTab("회원관리", mt);
		
		//판매관리 패널 탭에 붙이기
		SalesTab st = new SalesTab();
		tPane.addTab("판매관리", st);
		
		//전체 탭을 붙이기
		add(tPane);		
	}
}