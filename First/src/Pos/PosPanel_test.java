package Pos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

import Admin.AdminPage_Frame;

import java.util.ArrayList;
import java.util.Iterator;


public class PosPanel_test extends JPanel {
	
	public static ArrayList<Integer> cntList = new ArrayList<Integer>();
	public static ArrayList<Information> tinform = new ArrayList<Information>();
	public static ArrayList<Information> inform = new ArrayList<Information>();	
	public class Information {
		public String menu;
		public int price;
				
		public Information(String menu, int price) {
			this.menu = menu;
			this.price = price;			
		}
//		public String toString() {
//			return String.format("���� {name: %s. price: %d}", menu, price);
//		}
	}
	
	
		
	JButton[] MBtn = new JButton[16];
	JTextField tf = new JTextField(30);
	JButton[] SBtn = new JButton[4];
	
	String[] menu = {
					"�Ƹ޸�ī��","ICE�Ƹ޸�ī��","ī���","ICEī���",
					"ī���ī","īǪġ��","�ٴҶ��","ICE�ٴҶ��",
					"������","���̽�Ƽ","�ڸ����̵�","û�������̵�",
					"���⽺����","���踮������","����Ƽ","������"};
	int[] price = {
					1500,1800,2500,2500,
					3000,3000,3500,3500,
					3500,2500,3500,3500,
					4000,4000,3000,3000};
	
	String[] Str = {"����", "�������", "��ü���", "����"};
	String[] ColName = {"�޴�", "����", "����"};
	String[][] Data;
	int count = 1;
	
	DefaultTableModel model = new DefaultTableModel(Data, ColName);
	JTable table = new JTable(model);
		
	class Screen extends JPanel{
		Screen() {
			setBackground(Color.BLUE);
			DefaultTableModel m = (DefaultTableModel)table.getModel();
			table.setRowHeight(50);
			table.getTableHeader().setFont(new Font("���� ���", Font.BOLD, 15));
			add(new JScrollPane(table));
			
		}
	}
	
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
		

				
		//�޴� �Է��ϸ� ����ϱ�
		for(int i=0; i<MBtn.length;i=i+1) {
			final int index = i;
			MBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton MBtn = (JButton)e.getSource();
					DefaultTableModel m = (DefaultTableModel)table.getModel();
					m.addRow(new Object[]{menu[index],count,price[index]});
					inform.add(new Information(menu[index],price[index]));
//					POS_Main.sub.add(new Information(menu[index],count,price[index]));
					//System.out.println(inform.size());
					//System.out.println(POS_Main.sub.size());
					//System.out.println(inform.get(0));
					
				}				
			});
		}
		
		
		for(int i=0; i<inform.size(); i=i+1) {
			if(!tinform.contains(inform.get(i))) {
				tinform.add(inform.get(i));
			
				int cnt = 0;
				for(int I = i; I < inform.size(); I=I+1) {
					if(inform.get(i) == inform.get(I)) {
						cnt = cnt + 1;
					}
				}
				System.out.println(cnt);
				cntList.add(cnt);			
			}		
		}
		
		
		
				
		//����
		SBtn[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MBtn = (JButton)e.getSource();
				table.setValueAt(0, table.getSelectedRow(), 2);				
			}
		});
		//�������
		SBtn[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MBtn = (JButton)e.getSource();
				DefaultTableModel m = (DefaultTableModel)table.getModel();				
				m.removeRow(table.getSelectedRow());			
			}
		});
		
		//��ü���
		SBtn[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MBtn = (JButton)e.getSource();
				DefaultTableModel m = (DefaultTableModel)table.getModel();
				m.setRowCount(0);
				tf.setText(String.valueOf(""));
			}			
		});
		

		//����
		SBtn[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MBtn = (JButton)e.getSource();
				int rowCont = table.getRowCount();
				int sum = 0;
				for(int i=0; i<rowCont; i=i+1) {
					sum = sum + (int)table.getValueAt(i, 2);
//					inform.add(new Information(menu[i],count,price[i]));
//					System.out.println(inform.size());
//					System.out.println(inform.get(i));
				}
				tf.setText(String.valueOf(" �ѱݾ� : " + sum +"��"));
				tf.setFont(new Font("���� ���", Font.BOLD, 40));		
				// ������ư�� ������ AdminPage�� �Ѿ��.
				new AdminPage_Frame(); 
				// Frame.dispose() �� Ȱ���϶�!
			}		
		});
		
	}
}
