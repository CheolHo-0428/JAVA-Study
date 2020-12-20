package com.kitri.pos.account;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import java.util.Vector;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.border.LineBorder;

import com.kitri.pos.ForcePos;
import com.kitri.pos.db.*;
import com.kitri.pos.*;

public class Administrator extends JPanel{

	private static final long serialVersionUID = 1L;
	public ForcePos forcePos; //�α��� ȭ�� 
	JTextField userTf; // ���̵� �Է�
	JTextField passTf; // �н����� �Է�
	JTextField nameTf; // �̸� �Է�
	JTextField notice; // ����â
	public PosDto userDto; //UserDto Ŭ���� 
	public UserDao userDao; //UserDao Ŭ����
	public JComboBox authority; //��� ����
	public JComboBox authorityUp;// ���� ����
	Vector<PosDto> data;
	Vector<String> userColumn;
	public String auth; // �޺��ڽ� ���ÿ� ���� ���� ����
	public JPanel pAcMonitor;
	public JTable table; //���̺�
	public DefaultTableModel tm;
	public JTextField upuserTF; //�������� ���̵��ʵ�
	JTextField upassTf; //�������� ��й�ȣ�ʵ�
	JTextField unameTf; //�������� �̸��ʵ�
	public boolean result; // �μ�Ʈ ����� ����
	
	JScrollPane scrollPane;
	JLabel userIdLabel;
	JPanel panel;
	JLabel passWLabel_1;
	JLabel lblNewLabel_2;
	JLabel lblNewLabel_3;
	JPanel pB;
	public JButton ok;
	public JButton cancel;
	JPanel prInsert;
	JPanel panel_2;
	JLabel upuserL;
	JLabel uppassL;
	JLabel upnameL;
	JLabel upauthL;
	JPanel panel_3;
	public JButton button;
	public JButton button_1;
	JPanel prInput;

	// ȸ����� �г�
	JPanel pRegister = new JPanel();
	// ȸ�����̺� �г�
	JPanel pTable = new JPanel();
	// ȸ������ �г�
	JPanel ppRegister;
	// ȭ���� �������� ī�巹�̾ƿ� 
	public CardLayout card = new CardLayout();
	

	
	//�⺻ ������
	public Administrator() {

		setLayout(null);

		pAcMonitor = new JPanel();
		pAcMonitor.setBackground(new Color(255, 255, 255));
		pAcMonitor.setBounds(0, 50, 1144, 533);
		
		pRegister.setBackground(SystemColor.desktop);
		pRegister.setBorder(new LineBorder(new Color(0, 0, 0)));
		pRegister.setLayout(null);

		ppRegister = new JPanel();
		ppRegister.setBackground(Color.ORANGE);
		ppRegister.setLayout(null);

		prInput = new JPanel();
		prInput.setBorder(new LineBorder(new Color(0, 0, 0)));
		prInput.setBounds(451, 10, 356, 513);
		prInput.setLayout(new GridLayout(11, 1, 0, 0));
		pRegister.add(prInput);

		// Jtable
		userDao = new UserDao();
		data = userDao.getMemberList();

		// ColumnName
		userColumn = new Vector<String>();
		
		userColumn.addElement("�����ڵ�");
		userColumn.addElement("�н�����");
		userColumn.addElement("���̵�");
		userColumn.addElement("����");
		userColumn.addElement("�̸�");

		tm = new DefaultTableModel(userColumn, 0);
		table = new JTable(tm);
		

		scrollPane = new JScrollPane(table);
		pTable.add(scrollPane);
		table.setRowHeight(60);
		MainFrame.tableCellCenter(table);
		pTable.setLayout(null);
		scrollPane.setBounds(0, 5, 1144, 528);

		int size = data.size();

		for (int i = 0; i < size; i++) {
			// �� data�� ���� ���� 
			Vector<String> row = new Vector<String>();

			// �� data �ִ� ��.
			row.addElement(data.get(i).getUserCode() + "");
			row.addElement(data.get(i).getPw());
			row.addElement(data.get(i).getId());
			row.addElement(data.get(i).getAuthority());
			row.addElement(data.get(i).getName());
			
			tm.addRow(row);
		}
		
		// ī�巹�̾ƿ����.
		pAcMonitor.setLayout(card);
		pAcMonitor.add("pTable", pTable);
		pAcMonitor.add("pRegister", pRegister);
		pAcMonitor.add("ppRegister", ppRegister);
		card.show(pAcMonitor, "pTable");

		panel = new JPanel();
		prInput.add(panel);

		userIdLabel = new JLabel("\uC720\uC800ID");
		userIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userIdLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		userIdLabel.setFont(new Font("���� ���", Font.PLAIN, 20));
		prInput.add(userIdLabel);

		// ȸ����� - �������̵��Է�
		userTf = new JTextField();
		userTf.setHorizontalAlignment(SwingConstants.CENTER);
		prInput.add(userTf);
		userTf.setColumns(10);
		passWLabel_1 = new JLabel("\uD328\uC2A4\uC6CC\uB4DC");
		passWLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		passWLabel_1.setFont(new Font("���� ���", Font.PLAIN, 20));
		prInput.add(passWLabel_1);

		// ȸ����� - �н������Է�
		passTf = new JTextField();
		passTf.setHorizontalAlignment(SwingConstants.CENTER);
		prInput.add(passTf);
		passTf.setColumns(10);
		lblNewLabel_2 = new JLabel("\uC774\uB984");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("���� ���", Font.PLAIN, 20));
		prInput.add(lblNewLabel_2);

		// ȸ����� - �̸��Է�
		nameTf = new JTextField();
		nameTf.setHorizontalAlignment(SwingConstants.CENTER);
		prInput.add(nameTf);
		nameTf.setColumns(10);
		lblNewLabel_3 = new JLabel("\uAD8C\uD55C");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("���� ���", Font.PLAIN, 20));
		prInput.add(lblNewLabel_3);

		//������� ���ѹ迭
		authority = new JComboBox();
		authority.addItem("������");
		authority.addItem("����");
		prInput.add(authority);

		pB = new JPanel();
		prInput.add(pB);
		pB.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		ok = new JButton("\uD655\uC778");
		ok.setMargin(new Insets(2, 20, 2, 20));
		ok.setHorizontalTextPosition(SwingConstants.CENTER);
		ok.setFont(new Font("���� ���", Font.PLAIN, 20));
		ok.setAlignmentX(Component.CENTER_ALIGNMENT);
		pB.add(ok);

		cancel = new JButton("\uCDE8\uC18C");
		cancel.setMargin(new Insets(2, 20, 2, 20));
		cancel.setBackground(new Color(255, 99, 71));
		cancel.setHorizontalTextPosition(SwingConstants.CENTER);
		cancel.setFont(new Font("���� ���", Font.BOLD, 20));
		pB.add(cancel);

		prInsert = new JPanel();
		prInsert.setBounds(451, 10, 356, 513);
		prInsert.setBorder(new LineBorder(new Color(0, 0, 0)));
		ppRegister.add(prInsert);
		prInsert.setLayout(new GridLayout(11, 1, 0, 0));

		panel_2 = new JPanel();
		prInsert.add(panel_2);

		upuserL = new JLabel("\uC720\uC800ID");
		upuserL.setHorizontalAlignment(SwingConstants.CENTER);
		upuserL.setFont(new Font("���� ���", Font.PLAIN, 20));
		prInsert.add(upuserL);

		// ȸ�� ���� ���̵� �ʵ�
		upuserTF = new JTextField();
		upuserTF.setHorizontalAlignment(SwingConstants.CENTER);
		upuserTF.setFont(new Font("���� ���", Font.PLAIN, 20));
		upuserTF.setEnabled(false);
		upuserTF.setDragEnabled(true);
		upuserTF.setColumns(10);
		prInsert.add(upuserTF);

		uppassL = new JLabel("\uD328\uC2A4\uC6CC\uB4DC");
		uppassL.setHorizontalAlignment(SwingConstants.CENTER);
		uppassL.setFont(new Font("���� ���", Font.PLAIN, 20));
		prInsert.add(uppassL);

		// ȸ�� ���� �н����� �ʵ� 
		upassTf = new JTextField();
		upassTf.setHorizontalAlignment(SwingConstants.CENTER);
		upassTf.setColumns(10);
		prInsert.add(upassTf);

		upnameL = new JLabel("\uC774\uB984");
		upnameL.setHorizontalAlignment(SwingConstants.CENTER);
		upnameL.setFont(new Font("���� ���", Font.PLAIN, 20));
		prInsert.add(upnameL);

		// ȸ�� ���� �̸� �ʵ� 
		unameTf = new JTextField();
		unameTf.setHorizontalAlignment(SwingConstants.CENTER);
		unameTf.setColumns(10);
		prInsert.add(unameTf);

		upauthL = new JLabel("\uAD8C\uD55C");
		upauthL.setHorizontalAlignment(SwingConstants.CENTER);
		upauthL.setFont(new Font("���� ���", Font.PLAIN, 20));
		prInsert.add(upauthL);

		//�������� ���ѹ迭
		authorityUp = new JComboBox();
		authorityUp.addItem("������");
		authorityUp.addItem("����");
		prInsert.add(authorityUp);

		panel_3 = new JPanel();
		prInsert.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		button = new JButton("\uC218\uC815");
		button.setMargin(new Insets(2, 20, 2, 20));
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setFont(new Font("���� ���", Font.PLAIN, 20));
		button.setAlignmentX(0.5f);
		panel_3.add(button);

		button_1 = new JButton("\uCDE8\uC18C");
		button_1.setMargin(new Insets(2, 20, 2, 20));
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setFont(new Font("���� ���", Font.BOLD, 20));
		button_1.setBackground(new Color(255, 99, 71));
		panel_3.add(button_1);
		
		
		add(pAcMonitor);

		
	}

	// ȸ�����â�� �Էµ� ���� ������
	public PosDto getViewData() {
		userDto = new PosDto();

		userDto.setPw(passTf.getText());
		userDto.setId(userTf.getText());
		userDto.setName(nameTf.getText());
		userDto.setAuthority(auth);

		return userDto;
	}

	// ȸ�� ����â�� �Էµ� ���� ������
	public PosDto getViewUpdata() {
		userDto = new PosDto();

		userDto.setId(upuserTF.getText());
		userDto.setPw(upassTf.getText());
		userDto.setName(unameTf.getText());
		userDto.setAuthority(auth);

		return userDto;
	}
	//������� ��ȿ�� �˻� 
	public boolean isUserId() {

		String user = userTf.getText().trim();
		String pass = passTf.getText().trim();
		String name = nameTf.getText().trim();

		if (user.length() > 10) {
			JOptionPane.showMessageDialog(this, "���̵�� 10�� �̸����� ���������մϴ�.", "ID���� ����", JOptionPane.WARNING_MESSAGE);
			result = false;
		} else if (user.isEmpty() || pass.isEmpty() || name.isEmpty()) {
			JOptionPane.showMessageDialog(this, "������ �ȵǿ�!!!");
				result = false;
		} else {
				result = true;
		}
		return result;
	}

	// ������� ���� �˾� â ��� 
	public void insertUser() {
		getViewData();

		if (isUserId()) {
			JOptionPane.showMessageDialog(this, "����� �Ϸ�Ǿ����ϴ�. �����մϴ�.");
			card.show(pAcMonitor, "pTable");
		} else {
			JOptionPane.showMessageDialog(this, "����� ���еǾ����ϴ�.");
			return;
		}
	}

	//���� ���� ��ȿ�� �˻� 
	public void updateUser() {

		userDao = new UserDao();
		PosDto re = getViewUpdata();

		try {
			boolean result;
			
			result = userDao.updateMember(re);

			if (result) {
				JOptionPane.showMessageDialog(this, "������ �Ϸ�Ǿ����ϴ�.");
				card.show(pAcMonitor, "pTable");
			} else {
				JOptionPane.showMessageDialog(this, "������ ���еǾ����ϴ�.");
			 	return;
			}	
			// select ȣ��
			userDao.userSelectAll(tm);	
		} catch (SQLException e) {
			System.out.println("������Ʈ ����");
			e.printStackTrace();
		}
	}
	
	//�������� 
	public void deleteUser() {
		try {
			// ���� ��ȣ�� �̾ƿ�.
			int numberRow = table.getSelectedRow();
			// ���̺� Ŭ���ϸ� �ప�� ������ (���� : '���̵�'�� ��������) ȣ�� 
			String id = (String) tm.getValueAt(numberRow, 2);
			System.out.println(id);
			userDao = new UserDao();
			boolean result;
			//���̵� �����ͼ� delete ������ ���� 
			//������ �Ǿ��ٸ� result���� true
			result = userDao.deleteMember(id);
			if (result) {
				JOptionPane.showMessageDialog(this, "���� �Ϸ�");
			} else {
				JOptionPane.showMessageDialog(this, "���� ����");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ������� �ؽ�Ʈ�ʵ� �ʱ�ȭ
	public void tfClear() {
		userTf.setText("");
		passTf.setText("");
		nameTf.setText("");
	}

	// �������� �ؽ�Ʈ�ʵ� �ʱ�ȭ
	public void tfUClear() {
		upassTf.setText("");
		upuserTF.setText("");
		unameTf.setText("");
	}

	
}