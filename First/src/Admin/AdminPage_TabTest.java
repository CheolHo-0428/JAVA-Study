package Admin;

import Pos.PosPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;

class MemberV1 { //ȸ�� 1�� ���� �����ϴ� Ŭ���� : ������ ������ �����
	private String Name;  //VOŬ����
	private String Id;
	private String Pw;
	private String Age;
	private String PhoneNumber;
	private String Email;
	private String Gender;
	public MemberV1(String Name, String Id, String Pw, String Age, String PhoneNumber, String Email, String Gender) {
		this.Name = Name;
		this.Id = Id;
		this.Pw = Pw;
		this.Age = Age;
		this.PhoneNumber = PhoneNumber;
		this.Email = Email;
		this.Gender = Gender;}}

//class MemberV2 { //������ ������ �����
//	private int Number;
//	private String ProductName;  //VOŬ����
//	private int Price;
//	private int Count;
//	private int Sum;
//
//	public MemberV2(int Number, String ProductName, int Price) {
//		this.Number = Number;
//		this.ProductName = ProductName;
//		this.Price = Price;}}

//class MemberV2 { //������ ������ �����
//	private String ProductName;  //VOŬ����
//	private String Price;
//	private String Count;
//	private String Sum;
//
//	public MemberV2(String ProductName, String Price, String Count, String Sum) {
//		this.ProductName = ProductName;
//		this.Price = Price;
//		this.Count = Count;
//		this.Sum = Sum;}}

public class AdminPage_TabTest extends JFrame {
	
	public AdminPage_TabTest() {
		createTabbedPane_1();

	}
	
	public void createTabbedPane_1() {			
		JTabbedPane tPane = new JTabbedPane();
		add(tPane);
//********************************** ȸ�������� *************************************//
		
		ArrayList<MemberV1> members = new ArrayList<MemberV1>();
		
		JPanel memberManagePanel = new JPanel();
//		JScrollPane jscp2 = new JScrollPane(memberManagePanel);
//		memberManagePanel.setLayout(null);
			
		String[] mpHeadings = {"�̸�", "���̵�", "��й�ȣ", "�������", "��ȭ��ȣ", "�̸���", "����"};
		DefaultTableModel model = new DefaultTableModel(mpHeadings, 0);
		
		JTable mpTable = new JTable(model);
		mpTable.setPreferredScrollableViewportSize(new Dimension(1000,800));
		mpTable.setFillsViewportHeight(true);
		mpTable.setBackground(Color.WHITE);
		
		JScrollPane jscp1 = new JScrollPane(mpTable);
//		jscp1.setLocation(500,100);
//		jscp1.setSize(1000,1300);
//		memberManagePanel.add(jscp1);
		memberManagePanel.add(jscp1, BorderLayout.CENTER);
		
//		tPane.addTab("ȸ������", memberManagePanel);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(2,1));
		
		JPanel panel1 = new JPanel();
		JTextField tfName = new JTextField(6);
		JTextField tfId = new JTextField(6);
		JTextField tfPw = new JTextField(6);
		JTextField tfAge = new JTextField(6);
		JTextField tfPhoneNumber = new JTextField(10);
		JTextField tfEmail = new JTextField(10);
		
		JRadioButton rb1 = new JRadioButton("Female");
		JRadioButton rb2 = new JRadioButton("male");
		JRadioButton rb3 = new JRadioButton();
				
		ButtonGroup rg = new ButtonGroup();
		rg.add(rb1); rg.add(rb2); rg.add(rb3);
		rb1.setSelected(true);
		
		panel1.add(new JLabel("1.�̸�"));
		panel1.add(tfName);
		panel1.add(new JLabel("2.���̵�"));
		panel1.add(tfId);
		panel1.add(new JLabel("3.��й�ȣ"));
		panel1.add(tfPw);
		panel1.add(new JLabel("4.�������"));
		panel1.add(tfAge);
		panel1.add(new JLabel("5.��ȭ��ȣ"));
		panel1.add(tfPhoneNumber);
		panel1.add(new JLabel("6.E-mail"));
		panel1.add(tfEmail);
		panel1.add(new JLabel("7.����"));
		panel1.add(rb1); 
		panel1.add(rb2);
		bottomPanel.add(panel1);
		
		JPanel panel2 = new JPanel();
		JButton btnAdd = new JButton("�߰��ϱ�");
		JButton btnDel = new JButton("�����ϱ�");
		panel2.add(btnAdd);
		panel2.add(btnDel);
		bottomPanel.add(panel2);
		
		//�Էµ� �� ���̺� �߰��ϱ�
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] rows = new String[7];
				rows[0] = tfName.getText();
				rows[1] = tfId.getText();
				rows[2] = tfPw.getText();
				rows[3] = tfAge.getText();
				rows[4] = tfPhoneNumber.getText();
				rows[5] = tfEmail.getText();
				if(rb1.isSelected()) rows[6] = "����";
				else rows[6] = "����";
				
				model.addRow(rows);
				
				tfName.setText("");
				tfId.setText("");
				tfPw.setText("");
				tfAge.setText("");
				tfPhoneNumber.setText("");
				tfEmail.setText("");
				rb3.setSelected(true);
				
				// ��� ����Ʈ�� ��� ��ü �߰�
				String Name = rows[0];
				String Id = rows[1];
				String Pw = rows[2];
				String Age = rows[3];
				String PhoneNumber = rows[4];
				String Email = rows[5];
				String Gender = rows[6];
				
				members.add(new MemberV1(Name, Id, Pw, Age, PhoneNumber, Email, Gender));
				System.out.println("�� ������ ��: " + members.size());				
			}			
		});
		
		//������ �� �����
		btnDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 
				//������ ��(row)�� ��ȣ �˾Ƴ���
				int rowIndex = mpTable.getSelectedRow();
				//���� ���ϰ� ���� ��� ���ϰ� -1
				if(rowIndex == -1) return;
				model.removeRow(rowIndex);
				//������ �����
				members.remove(rowIndex);
				System.out.println("�� ������ ��: " + members.size());
			}
		});
		
		memberManagePanel.add(bottomPanel, BorderLayout.SOUTH);
		
		tPane.addTab("ȸ������", memberManagePanel);
//		tPane.addTab("ȸ������", jscp2);
//		setVisible(true);
		
//********************************** �ǸŰ����� *************************************//
		JPanel salesManagePanel = new JPanel();
		String[] spHeadings = {"��ȣ", "ǰ���", "����", "����", "�հ�"};
		Object[][] spData = {{1, "�Ƹ޸�ī��", 1500,3},
							{2,"���̽��Ƹ޸�ī��", 1800, 2}, 
							{3, "ī���", 1800, 3}};
		int [] spCount = {};
		int [] spSum = {};
		
		DefaultTableModel model_1 = new DefaultTableModel(spData, spHeadings);
		JTable spTable = new JTable(model_1);
		spTable.setPreferredScrollableViewportSize(new Dimension(1000,800));
		spTable.setFillsViewportHeight(true);
		spTable.setBackground(Color.WHITE);
		
		JScrollPane jscp2 = new JScrollPane(spTable);
		salesManagePanel.add(jscp2, BorderLayout.CENTER);
			
		tPane.addTab("�ǸŰ���", salesManagePanel);		
	}
}
