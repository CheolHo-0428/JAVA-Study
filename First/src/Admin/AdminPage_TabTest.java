package Admin;

import Pos.PosPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;

class MemberV1 { //회원 1명 정보 저장하는 클래스 : 오로지 데이터 저장용
	private String Name;  //VO클래스
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

//class MemberV2 { //오로지 데이터 저장용
//	private int Number;
//	private String ProductName;  //VO클래스
//	private int Price;
//	private int Count;
//	private int Sum;
//
//	public MemberV2(int Number, String ProductName, int Price) {
//		this.Number = Number;
//		this.ProductName = ProductName;
//		this.Price = Price;}}

//class MemberV2 { //오로지 데이터 저장용
//	private String ProductName;  //VO클래스
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
//********************************** 회원관리탭 *************************************//
		
		ArrayList<MemberV1> members = new ArrayList<MemberV1>();
		
		JPanel memberManagePanel = new JPanel();
//		JScrollPane jscp2 = new JScrollPane(memberManagePanel);
//		memberManagePanel.setLayout(null);
			
		String[] mpHeadings = {"이름", "아이디", "비밀번호", "생년월일", "전화번호", "이메일", "성별"};
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
		
//		tPane.addTab("회원관리", memberManagePanel);
		
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
		
		panel1.add(new JLabel("1.이름"));
		panel1.add(tfName);
		panel1.add(new JLabel("2.아이디"));
		panel1.add(tfId);
		panel1.add(new JLabel("3.비밀번호"));
		panel1.add(tfPw);
		panel1.add(new JLabel("4.생년월일"));
		panel1.add(tfAge);
		panel1.add(new JLabel("5.전화번호"));
		panel1.add(tfPhoneNumber);
		panel1.add(new JLabel("6.E-mail"));
		panel1.add(tfEmail);
		panel1.add(new JLabel("7.성별"));
		panel1.add(rb1); 
		panel1.add(rb2);
		bottomPanel.add(panel1);
		
		JPanel panel2 = new JPanel();
		JButton btnAdd = new JButton("추가하기");
		JButton btnDel = new JButton("삭제하기");
		panel2.add(btnAdd);
		panel2.add(btnDel);
		bottomPanel.add(panel2);
		
		//입력된 값 테이블에 추가하기
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
				if(rb1.isSelected()) rows[6] = "남성";
				else rows[6] = "여성";
				
				model.addRow(rows);
				
				tfName.setText("");
				tfId.setText("");
				tfPw.setText("");
				tfAge.setText("");
				tfPhoneNumber.setText("");
				tfEmail.setText("");
				rb3.setSelected(true);
				
				// 어레이 리스트에 멤버 객체 추가
				String Name = rows[0];
				String Id = rows[1];
				String Pw = rows[2];
				String Age = rows[3];
				String PhoneNumber = rows[4];
				String Email = rows[5];
				String Gender = rows[6];
				
				members.add(new MemberV1(Name, Id, Pw, Age, PhoneNumber, Email, Gender));
				System.out.println("총 관리자 수: " + members.size());				
			}			
		});
		
		//선택한 줄 지우기
		btnDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 
				//선택한 줄(row)의 번호 알아내기
				int rowIndex = mpTable.getSelectedRow();
				//선택 안하고 누를 경우 리턴값 -1
				if(rowIndex == -1) return;
				model.removeRow(rowIndex);
				//데이터 지우기
				members.remove(rowIndex);
				System.out.println("총 관리자 수: " + members.size());
			}
		});
		
		memberManagePanel.add(bottomPanel, BorderLayout.SOUTH);
		
		tPane.addTab("회원관리", memberManagePanel);
//		tPane.addTab("회원관리", jscp2);
//		setVisible(true);
		
//********************************** 판매관리탭 *************************************//
		JPanel salesManagePanel = new JPanel();
		String[] spHeadings = {"번호", "품목명", "가격", "수량", "합계"};
		Object[][] spData = {{1, "아메리카노", 1500,3},
							{2,"아이스아메리카노", 1800, 2}, 
							{3, "카페라떼", 1800, 3}};
		int [] spCount = {};
		int [] spSum = {};
		
		DefaultTableModel model_1 = new DefaultTableModel(spData, spHeadings);
		JTable spTable = new JTable(model_1);
		spTable.setPreferredScrollableViewportSize(new Dimension(1000,800));
		spTable.setFillsViewportHeight(true);
		spTable.setBackground(Color.WHITE);
		
		JScrollPane jscp2 = new JScrollPane(spTable);
		salesManagePanel.add(jscp2, BorderLayout.CENTER);
			
		tPane.addTab("판매관리", salesManagePanel);		
	}
}
