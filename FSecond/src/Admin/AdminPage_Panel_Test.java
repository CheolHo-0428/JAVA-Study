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

//�ǸŰ��� ȸ������ �� �г�
public class AdminPage_Panel_Test extends JPanel {
	//�� ����
	JTabbedPane tPane = new JTabbedPane();
	
	//�ǸŰ��� Tab�� �ʿ��� �ʵ� ��
	String[] Headings = {"��ȣ", "ǰ���", "����", "����", "�հ�"};
	String[] Name;
	int[] Price;
	int[] Count;
	int[] Sum;
	String[][] Data;
	JTextField jtf = new JTextField(10);
	JTextField tf = new JTextField(10);  // ȸ������ �ǿ� �ʿ��� �ʵ尪
	
	DefaultTableModel model = new DefaultTableModel(Data, Headings);
	JTable table = new JTable(model);
	Dimension dim = new Dimension(1200,850);
	
	//�ǸŰ��� �г�
	class SalesTab extends JPanel {
		public SalesTab() {	
			// �ǸŰ��� �г� ������
			setBackground(Color.WHITE);
			
			//������ ���̺� �ٿ�ĳ����
			DefaultTableModel m = (DefaultTableModel)table.getModel();
			//������ �ݾ� ������ ��������(from PosPanel_test)
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
			
			//�� ����� ���
			jtf.setBackground(Color.WHITE);
			jtf.setFont(new Font("���� ���", Font.BOLD, 15));
			add(jtf);
			jtf.setText(String.valueOf("����� : " + totalsum + "��"));
						
			//���̺� ����			
			table.setRowHeight(30);
			table.getTableHeader().setFont(new Font("���� ���", Font.BOLD, 15));
			table.setFont(new Font("���� ���", Font.PLAIN, 13));
			table.setPreferredScrollableViewportSize(dim);
			table.setFillsViewportHeight(true);
			
			//���̺� �ؽ�Ʈ ��� ����
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
			dtcr.setHorizontalAlignment(SwingConstants.CENTER);
			TableColumnModel tcm = table.getColumnModel();
			for(int i =0; i<tcm.getColumnCount(); i=i+1) {
				tcm.getColumn(i).setCellRenderer(dtcr);
			}
			//���̺� ��ũ�ѱ�� �߰� �� �ǸŰ����ǿ� ���̱�
			add(new JScrollPane(table));			
		}
	}
	
	//ȸ������ �г�
	class MemberTab extends JPanel {		
		public MemberTab() {
			// ȸ������ �г� ������			
			setBackground(Color.WHITE);
			// ȸ�� ���� ������
			String[] mtHeadings = {"��ȣ", "�̸�", "���̵�", "��й�ȣ", "�������", "����", "��ȭ��ȣ", "�̸���"};
			String[][] mtData = {{"1", "��öȣ", "CCH12", "playdata1", "1900.04", "��", "010-1234-5678", "12345@gmail.com"},
								{"2", "����ȣ", "SJH34", "playdata1", "1900.05", "��", "010-1111-2222", "5678@gmail.com"},
								{"3", "������", "CJJ56", "playdata1", "1900.06", "��", "010-3333-5555", "0987@gmail.com"},
								{"4", "������", "KJH78", "playdata1", "1900.07", "��", "010-6666-7777", "6543@gmail.com"}};
			
			//�� ȸ�� �� ���
			tf.setBackground(Color.WHITE);
			add(tf);
			setBackground(Color.WHITE);
			tf.setText(String.valueOf("������ �� : 4��"));
			tf.setFont(new Font("���� ���", Font.BOLD, 15));
						
			//���̺� ���� �� ����
			JTable table = new JTable(mtData, mtHeadings);		
			table.setPreferredScrollableViewportSize(dim);
			table.setFillsViewportHeight(true);
			table.setBackground(Color.WHITE);
			table.setRowHeight(30);
			table.getTableHeader().setFont(new Font("���� ���", Font.BOLD, 15));
			
			//���̺� �ؽ�Ʈ ��� ����
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
			dtcr.setHorizontalAlignment(SwingConstants.CENTER);
			TableColumnModel tcm = table.getColumnModel();
			for(int i =0; i<tcm.getColumnCount(); i=i+1) {
				tcm.getColumn(i).setCellRenderer(dtcr);
			}
			
			//���̺� ��ũ�ѱ�� �߰� �� �ǸŰ����ǿ� ���̱�
			add(new JScrollPane(table));
		}
	}
	
	//ȸ������ �г�, �ǸŰ��� �г� �ǿ� ���̱�
	public AdminPage_Panel_Test() {
		//ȸ������ �г� �ǿ� ���̱�
		MemberTab mt = new MemberTab(); 		
		tPane.addTab("ȸ������", mt);
		
		//�ǸŰ��� �г� �ǿ� ���̱�
		SalesTab st = new SalesTab();
		tPane.addTab("�ǸŰ���", st);
		
		//��ü ���� ���̱�
		add(tPane);		
	}
}