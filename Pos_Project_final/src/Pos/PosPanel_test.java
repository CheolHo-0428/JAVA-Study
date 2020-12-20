package Pos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.ArrayList;
import java.util.Iterator;
import admin.AdminPage_Frame;

public class PosPanel_test extends JPanel {
	// 결제된 정보가 담겨 있는 어레이리스트들(중복값이 있음)
	public static ArrayList<String> ProductName = new ArrayList<String>(); //중복값이 있는 상품이름 리스트
	public static ArrayList<Integer> Price = new ArrayList<Integer>(); //중값이 있는 상품가격 리스트
	
	// 실제 AdminPage_Panel로 넘겨주는 어레이리스트들(중복값이 없음)
	public static ArrayList<String> ProductList = new ArrayList<String>(); //중복값이 없는 상품이름 리스트
	public static ArrayList<Integer> PriceList = new ArrayList<Integer>(); //중복값이 없는 상품가격 리스트
	public static ArrayList<Integer> CntList = new ArrayList<Integer>(); //선택된 상품갯수 리스트
	
	// 위의 중복값이 있는 어레이리스트들을 중복값 없는 데이터로 만들어주는 기능
	public class operation {
		operation(){		
			for(int i = 0; i <ProductName.size(); i=i+1) {
				System.out.println(ProductName.get(i));
				if(!ProductList.contains(ProductName.get(i))) {
					ProductList.add(ProductName.get(i));
					PriceList.add(Price.get(i));
					int cnt = 0;
					for(int I = i; I < ProductName.size(); I = I+1) {
						if(ProductName.get(i) == ProductName.get(I)) {
							cnt = cnt + 1;
						}
					}
					CntList.add(cnt);
				}
				else {
					continue;
				}
			}
			System.out.println(ProductList);
			System.out.println(PriceList);
			System.out.println(CntList);
		}		
	}
	
	//필드 값
	JButton[] MBtn = new JButton[16];
	JTextField tf = new JTextField(30);
	JButton[] SBtn = new JButton[4];
	
	String[] menu = {
					"아메리카노","ICE아메리카노","카페라떼","ICE카페라떼",
					"카페모카","카푸치노","바닐라라떼","ICE바닐라라떼",
					"녹차라떼","아이스티","자몽에이드","청포도에이드",
					"딸기스무디","블루배리스무디","레몬티","유자차"};
	int[] price = {
					1500,1800,2500,2500,
					3000,3000,3500,3500,
					3500,2500,3500,3500,
					4000,4000,3000,3000};
	
	String[] Str = {"쿠폰", "선택취소", "전체취소", "결제"};
	String[] ColName = {"메뉴", "수량", "가격"};
	String[][] Data;
	int count = 1;
	
	DefaultTableModel model = new DefaultTableModel(Data, ColName);
	JTable table = new JTable(model);
	
	//주문시 결제 총액이 뜨는 스크린 클래스
	class Screen extends JPanel{
		Screen() {
			setBackground(Color.BLUE);
			DefaultTableModel m = (DefaultTableModel)table.getModel();
			table.setRowHeight(50);
			table.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 15));
			add(new JScrollPane(table));
			
		}
	}
	
	// 메뉴버튼 레이아웃 클래스
	class MenuBtn extends JPanel{
		MenuBtn() {
			setLayout(new GridLayout(6,3,3,3));
			setBackground(Color.GREEN);
			for(int i=0; i<MBtn.length;i=i+1) {
				MBtn[i] = new JButton(menu[i]);
				add(MBtn[i]);
			}			
		}
	}
	
	//쿠폰, 선택취소, 전체취소, 결제 버튼 레이아웃 클래스
	class StrBtn extends JPanel {
		StrBtn() {
			setLayout(new GridLayout(1,4,3,3));
			setBackground(Color.BLACK);
			for(int i=0; i<SBtn.length; i=i+1) {
				SBtn[i] = new JButton(Str[i]);
				add(SBtn[i]);
			}
		}
	}
	
	//포스기 생성자
	public PosPanel_test() {
		setLayout(null);
		setBackground(Color.YELLOW);
		MenuBtn mbtn = new MenuBtn();
		StrBtn sbtn = new StrBtn();
		Screen sc = new Screen();

		tf.setSize(450, 70);
		tf.setLocation(50, 480);
		add(tf);
		
		sc.setSize(500, 500);
		sc.setLocation(25, 20);
		add(sc);
		
		mbtn.setSize(400, 430);
		mbtn.setLocation(530, 23);
		add(mbtn);
		
		sbtn.setSize(400, 70);
		sbtn.setLocation(530, 480);
		add(sbtn);
						
		//메뉴 입력하면 출력하기
		for(int i=0; i<MBtn.length;i=i+1) {
			final int index = i;
			MBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton MBtn = (JButton)e.getSource();
					DefaultTableModel m = (DefaultTableModel)table.getModel();
					m.addRow(new Object[]{menu[index],count,price[index]});					
					ProductName.add(menu[index]); // 선택된 항목의 이름이 어레이리스트도 보내진다.
					Price.add(price[index]); // 선택된 항목의 가격이 어레이리스트도 보내진다.
				}
			});
		}
						
		//쿠폰
		SBtn[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MBtn = (JButton)e.getSource();
				table.setValueAt(0, table.getSelectedRow(), 2);				
			}
		});
		
		//선택취소
		SBtn[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MBtn = (JButton)e.getSource();
				DefaultTableModel m = (DefaultTableModel)table.getModel();				
				m.removeRow(table.getSelectedRow());			
			}
		});
		
		//전체취소
		SBtn[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MBtn = (JButton)e.getSource();
				DefaultTableModel m = (DefaultTableModel)table.getModel();
				m.setRowCount(0);
				tf.setText(String.valueOf(""));
			}			
		});
		
		//결제
		SBtn[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MBtn = (JButton)e.getSource();
				int rowCont = table.getRowCount();
				int sum = 0;
				for(int i=0; i<rowCont; i=i+1) {
					sum = sum + (int)table.getValueAt(i, 2);
				}
				tf.setText(String.valueOf(" 총금액 : " + sum +"원"));
				tf.setFont(new Font("맑은 고딕", Font.BOLD, 40));		
				
				new operation(); // 결제버튼을 누르면 결제정보가 AdminPage로 넘어간다.
				new AdminPage_Frame();	// 결제버튼을 누르면 AdminPage로 전환된다.			

			}		
		});
		
	}
}