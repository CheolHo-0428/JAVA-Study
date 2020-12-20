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
	
	String[] Headings = {"��ȣ", "ǰ���", "����", "����", "�հ�"};
	String[] Name;
	int[] Price;
	int[] Count;
	int[] Sum;
	String[][] Data;
	JTextField jtf = new JTextField(10);
	
	DefaultTableModel model = new DefaultTableModel(Data, Headings);
	JTable table = new JTable(model);
	
	//�ǸŰ��� Tab
	class SalesTab extends JPanel {
		public SalesTab() {	
			// �߰� �κ�
			// Pos_Main -> sub �� �߰�
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
			jtf.setText(String.valueOf("�� ����� : " + totalsum + "��"));
			jtf.setFont(new Font("���� ���", Font.BOLD, 20));
			
			Dimension dim = new Dimension(1000,700);			
			table.setRowHeight(30);
			table.getTableHeader().setFont(new Font("���� ���", Font.BOLD, 15));
			table.setPreferredScrollableViewportSize(dim);
			table.setFillsViewportHeight(true);
			add(new JScrollPane(table));
		}
	}	
	//ȸ������ Tab
	class MemberTab extends JPanel {		
		public MemberTab() {
			setBackground(Color.BLUE);
			
			String[] mtHeadings = {"��ȣ", "�̸�", "���̵�", "��й�ȣ", "�������", "����", "��ȭ��ȣ", "�̸���"};
			String[][] mtData = {{"1", "��öȣ", "CCH12", "playdata1", "1900.04", "��", "010-1234-5678", "12345@gmail.com"},
								{"2", "����ȣ", "SJH34", "playdata1", "1900.05", "��", "010-1111-2222", "5678@gmail.com"},
								{"3", "������", "CJJ56", "playdata1", "1900.06", "��", "010-3333-5555", "0987@gmail.com"},
								{"4", "������", "KJH78", "playdata1", "1900.07", "��", "010-6666-7777", "6543@gmail.com"}};
			JTable table = new JTable(mtData, mtHeadings);
			Dimension dim = new Dimension(1000,700);
			table.setPreferredScrollableViewportSize(dim);
			table.setFillsViewportHeight(true);
			table.setBackground(Color.WHITE);
			table.setRowHeight(30);
			table.getTableHeader().setFont(new Font("���� ���", Font.BOLD, 15));
				
			JScrollPane jscp = new JScrollPane(table);		
//			jscp.setLocation(500,100);
//			jscp.setSize(1000,700);
			add(jscp);													
		}
	}		
	//������ �� �� ������
	public AdminPage_Panel() {
		MemberTab mt = new MemberTab(); 		
		tPane.addTab("ȸ������", mt);
				
		SalesTab st = new SalesTab();
		
		tPane.addTab("�ǸŰ���", st);
		add(tPane);		
	}
}
