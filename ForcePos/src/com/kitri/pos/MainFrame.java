package com.kitri.pos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

import com.kitri.pos.stat.*;

import oracle.sql.ConverterArchive;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import com.kitri.pos.stat.*;
import com.kitri.pos.account.*;
import com.kitri.pos.calc.*;
import com.kitri.pos.sale.*;
import com.kitri.pos.db.*;
import com.kitri.pos.stock.*;

public class MainFrame extends JFrame implements ActionListener, Runnable {
	PosDto posdto;
	public SalesDao salesDao = new SalesDao();
	StockDao stockdao = new StockDao();
	StockPopupIn stockpopupin = new StockPopupIn();
	StockPopupChg stockpopupchg = new StockPopupChg();
	StockPopupSearch stockpopupsearch = new StockPopupSearch();
	StockBtn stockbtn;
	StockMonitor stockmonitor = new StockMonitor();
	public CardLayout monitor;
	public CardLayout btn;
	Thread thread;

	public JButton logout;

	private JPanel contentPane;
	public JTextField notice;
	private JPanel pStatusBar;
	private JLabel titleLabel;
	private JLabel dateLabel;
	private JPanel pMainBtn;
	public JButton mBtnInven;
	public JButton mBtnSale;
	public JButton mBtnCalc;
	public JButton mBtnStat;
	public JButton mBtnAccount;
	public JPanel pMonitor;
	public JPanel pFBtn;

	ViewStatProduct v1 = new ViewStatProduct(); // ��ǰ�� �г�
	ViewStatYear v2 = new ViewStatYear(); // ������ �г�
	ViewStatMonth v3 = new ViewStatMonth(); // ���� �г�
	ViewStatDay v4 = new ViewStatDay(); // �Ϻ� �г�
	ViewStatButtons statbtn;

	Administrator admin = new Administrator();
	AccountBtn accbtn;

	CalcService calcService = new CalcService(this);
	public PCalc pCalc = new PCalc();
	public CalcBtn calcbtn = new CalcBtn();

	public ViewSalesCustomer viewSalesCustomer = new ViewSalesCustomer();
	public ViewSalesDisuse viewSalesDisuse = new ViewSalesDisuse();
	public ViewSalesInput viewSalesInput = new ViewSalesInput();
	public SalesInputService salesInputService = new SalesInputService(this);

	// ������ �������â ������
	public DealCancel dealCancel = new DealCancel();
	public Payment_1 payment_1 = new Payment_1();
	public Payment_2 payment_2 = new Payment_2();
	public Payment_3 payment_3 = new Payment_3();
	public Payment_4 payment_4 = new Payment_4();

	public SaleBtn salebtn = new SaleBtn();

//	��ǰ���� ��ư ���� ���� flag
	boolean isHold = false;
//	������ ��ǰ���� PosDto��ü���� ������ ����
	Vector<PosDto> hodingProductList = null;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainFrame frame = new MainFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		monitor = new CardLayout();
		btn = new CardLayout();
		stockbtn = new StockBtn();
		statbtn = new ViewStatButtons();
		accbtn = new AccountBtn();

		stockpopupin.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		stockpopupsearch.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		stockpopupchg.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		setFont(new Font("���� ���", Font.BOLD, 20));
		setTitle("Force.pos");
//		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1326, 753);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		pStatusBar = new JPanel();
		pStatusBar.setBackground(new Color(0, 0, 128));
		pStatusBar.setBounds(0, 0, 1320, 51);
		contentPane.add(pStatusBar);
		pStatusBar.setLayout(null);

		titleLabel = new JLabel("Force. pos");
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBackground(new Color(0, 0, 128));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("���� ���", Font.BOLD, 25));
		titleLabel.setBounds(14, 8, 241, 31);
		pStatusBar.add(titleLabel);

		notice = new JTextField();
		notice.setDisabledTextColor(Color.BLACK);
		notice.setEnabled(false);
		notice.setEditable(false);
		notice.setFont(new Font("���� ���", Font.PLAIN, 20));
		notice.setText("");
		notice.setHorizontalAlignment(SwingConstants.CENTER);
		notice.setBounds(258, 8, 726, 31);
		pStatusBar.add(notice);
		notice.setColumns(10);

		dateLabel = new JLabel();
		dateLabel.setBackground(new Color(0, 0, 128));
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setForeground(new Color(255, 255, 255));
		dateLabel.setFont(new Font("���� ���", Font.PLAIN, 20));
		dateLabel.setBounds(1016, 8, 278, 31);
		pStatusBar.add(dateLabel);

		pMainBtn = new JPanel();
		pMainBtn.setBackground(new Color(255, 255, 255));
		pMainBtn.setBounds(0, 600, 1157, 125);
		contentPane.add(pMainBtn);
		pMainBtn.setLayout(null);

		mBtnInven = new JButton("\uC7AC\uACE0");
		mBtnInven.setBackground(new Color(28, 94, 94));
		mBtnInven.setForeground(new Color(255, 255, 255));
		mBtnInven.setFont(new Font("���� ���", Font.BOLD, 20));
		mBtnInven.setBounds(0, 0, 157, 125);
		pMainBtn.add(mBtnInven);

		logout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		logout.setBackground(Color.BLACK);
		logout.setForeground(Color.WHITE);
		logout.setFont(new Font("���� ���", Font.BOLD, 20));
		logout.setBounds(988, 0, 157, 125);
		pMainBtn.add(logout);

		mBtnSale = new JButton("\uD310\uB9E4");
		mBtnSale.setBackground(new Color(99, 166, 166));
		mBtnSale.setFont(new Font("���� ���", Font.BOLD, 20));
		mBtnSale.setForeground(new Color(255, 255, 255));
		mBtnSale.setBounds(156, 0, 157, 125);
		pMainBtn.add(mBtnSale);

		mBtnCalc = new JButton("\uC815\uC0B0");
		mBtnCalc.setBackground(new Color(28, 94, 94));
		mBtnCalc.setForeground(new Color(255, 255, 255));
		mBtnCalc.setFont(new Font("���� ���", Font.BOLD, 20));
		mBtnCalc.setBounds(313, 0, 157, 125);
		pMainBtn.add(mBtnCalc);

		mBtnStat = new JButton("\uD1B5\uACC4");
		mBtnStat.setBackground(new Color(99, 166, 166));
		mBtnStat.setFont(new Font("���� ���", Font.BOLD, 20));
		mBtnStat.setForeground(new Color(255, 255, 255));
		mBtnStat.setBounds(470, 0, 157, 125);
		pMainBtn.add(mBtnStat);

		mBtnAccount = new JButton("\uACC4\uC815");
		mBtnAccount.setBackground(new Color(28, 94, 94));
		mBtnAccount.setForeground(new Color(255, 255, 255));
		mBtnAccount.setFont(new Font("���� ���", Font.BOLD, 20));
		mBtnAccount.setBounds(626, 0, 157, 125);
		pMainBtn.add(mBtnAccount);

		pMonitor = new JPanel();
		pMonitor.setBackground(new Color(255, 255, 255));
		pMonitor.setBounds(0, 50, 1157, 552);
		contentPane.add(pMonitor);
		pMonitor.setLayout(monitor);
//		������гο� ī�巹�̾ƿ��ְ� ��ȭ�� �г� ��ü�����Ͽ� �߰�
		pMonitor.add("ViewSalesInput", viewSalesInput);
		pMonitor.add(stockmonitor, "Stock");
		pMonitor.add("viewStatProduct", v1);
		pMonitor.add("viewStatYear", v2);
		pMonitor.add("viewStatMonth", v3);
		pMonitor.add("viewStatDay", v4);
		admin.pAcMonitor.setLocation(12, 10);
		admin.pAcMonitor.setSize(1133, 532);
		pMonitor.add(admin, "admin");
		pMonitor.add("Calc", pCalc);
		pMonitor.add("ViewSalesCustomer", viewSalesCustomer);
		pMonitor.add("ViewSalesDisuse", viewSalesDisuse);

		pFBtn = new JPanel();
		pFBtn.setBackground(Color.WHITE);
		pFBtn.setBounds(1156, 50, 164, 675);
		contentPane.add(pFBtn);
		pFBtn.setLayout(btn);
		salebtn.sBtnAcencel.setText("\uAC70\uB798\uCD08\uAE30\uD654");
//		��ɹ�ư�г� ī�� ����ɹ�ư �г� ��ü������ �߰�
		pFBtn.add(salebtn, "salebtn");
		pFBtn.add(stockbtn, "Stockbtn");
		pFBtn.add(statbtn, "Statbtn");
		pFBtn.add(accbtn, "Accbtn");
		pFBtn.add(calcbtn, "Calcbtn");

		// ���α�ɹ�ư
		mBtnInven.addActionListener(this);
		mBtnSale.addActionListener(this);
		mBtnCalc.addActionListener(calcService);
		mBtnStat.addActionListener(this);
		mBtnAccount.addActionListener(this);
		// ��� ��ɹ�ư
		stockbtn.stockSearch.addActionListener(this);
		stockbtn.stockIn.addActionListener(this);
		stockbtn.stockChg.addActionListener(this);
		stockbtn.stockevery.addActionListener(this);

		// ���-�˻� �˾� �׼Ǹ�����
		stockpopupsearch.sCbtn.addActionListener(this);
		stockpopupsearch.SearchCode.addActionListener(this);
		stockpopupsearch.searchCancel.addActionListener(this);
		stockpopupsearch.SearchName.addActionListener(this);
		stockpopupsearch.sNbtn.addActionListener(this);

		// ���-���� �˾� �׼Ǹ�����
		stockpopupchg.chgOk.addActionListener(this);
		stockpopupchg.chgCancel.addActionListener(this);
		stockpopupchg.ChgCountTf.addActionListener(this);
		// ���-���� �˾� �׼Ǹ����� ( �԰��ư)
		stockpopupin.inOk.addActionListener(this);
		stockpopupin.inCancel.addActionListener(this);
		stockpopupin.PcodeTf.addActionListener(this);
		stockpopupin.IndateTf.addActionListener(this);
		stockpopupin.PcntTf.addActionListener(this);
		stockpopupin.pcodeInput.addActionListener(this);
		stockpopupin.indateInput.addActionListener(this);
		stockpopupin.pcntInput.addActionListener(this);

		// ��� ��ɹ�ư
		statbtn.sBtnDay.addActionListener(this);
		statbtn.sBtnMonth.addActionListener(this);
		statbtn.sBtnProduct.addActionListener(this);
		statbtn.sBtnYear.addActionListener(this);

		// ���� ��ɹ�ư
		accbtn.userInsert.addActionListener(this);
		accbtn.userDelete.addActionListener(this);
		accbtn.userUpdate.addActionListener(this);
		logout.addActionListener(this);

		// ���� �̺�Ʈ ������ ���
		admin.authority.addActionListener(this);
		admin.authorityUp.addActionListener(this);
		admin.ok.addActionListener(this);
		admin.cancel.addActionListener(this);
		admin.button.addActionListener(this);
		admin.button_1.addActionListener(this);

		// ������� ���콺 Ŭ�� �̺�Ʈ
		admin.table.addMouseListener(ms);

		// ���� ��� ������
		pCalc.btnCalc_0.addActionListener(calcService);
		pCalc.btnCalc_1.addActionListener(calcService);
		pCalc.btnCalc_2.addActionListener(calcService);
		pCalc.btnCalc_3.addActionListener(calcService);
		pCalc.btnCalc_4.addActionListener(calcService);
		pCalc.btnCalc_5.addActionListener(calcService);
		pCalc.btnCalc_6.addActionListener(calcService);
		pCalc.btnCalc_7.addActionListener(calcService);
		pCalc.btnCalc_8.addActionListener(calcService);
		pCalc.btnCalc_9.addActionListener(calcService);
		pCalc.btnCalc_00.addActionListener(calcService);
		pCalc.btnCalc_del.addActionListener(calcService);
		pCalc.btnCalc_C.addActionListener(calcService);
		pCalc.btnCalc_Apply.addActionListener(calcService);

		// �Ǹ� ��� ������
		salebtn.sBtnCustomer.addActionListener(this);
		salebtn.sBtnDisuse.addActionListener(this);
		salebtn.sBtnPdHold.addActionListener(this);
		salebtn.sBtnCancel.addActionListener(this);
		salebtn.sBtnPay.addActionListener(salesInputService);
		salebtn.sBtnAcencel.addActionListener(salesInputService);
		salebtn.sBtnPdChange.addActionListener(salesInputService);
		salebtn.sBtnPdCancel.addActionListener(salesInputService);

		viewSalesCustomer.enroll.addActionListener(this);
		viewSalesCustomer.search.addActionListener(this);
		viewSalesCustomer.delete.addActionListener(this);

//		����1 �̺�Ʈ ���
		payment_1.cbP1Cooperation.addActionListener(salesInputService);
		payment_1.btnP1Apply.addActionListener(salesInputService);
		payment_1.btnP1Before.addActionListener(salesInputService);
		payment_1.btnP1Next.addActionListener(salesInputService);

//		����2 �̺�Ʈ ���
		payment_2.btnP2Before.addActionListener(this);
		payment_2.btnP2Cancel.addActionListener(this);
		payment_2.btnP2Next.addActionListener(salesInputService);
		payment_2.btnP2Reference.addActionListener(salesInputService);
		payment_2.btnP2Apply.addActionListener(salesInputService);

//		����3 �̺�Ʈ ���
		payment_3.btnP3Before.addActionListener(this);
		payment_3.btnP3Cancel.addActionListener(this);
		payment_3.btnP3Input.addActionListener(salesInputService);
		payment_3.btnP3Next.addActionListener(salesInputService);

//		���� 4 �̺�Ʈ ���
		
		payment_4.btnP4PrintReceipt.addActionListener(this);
		payment_4.btnP4Payment.addActionListener(salesInputService);

		dealCancel.btnRefund.addActionListener(this);
		viewSalesDisuse.disuse.addActionListener(this);

		viewSalesInput.code_input.addKeyListener(salesInputService);
		viewSalesInput.product_name_input.addKeyListener(salesInputService);

		// thread
		thread = new Thread(this);
		thread.start();

	}// ���������Ӹ޼ҵ� ��

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		Object obb = e.getActionCommand();
		// ���ι�ư�� ���
		if (ob == mBtnInven) {
			mBtnInven.setBackground(new Color(255, 69, 0));
			mBtnAccount.setBackground(new Color(28, 94, 94));
			mBtnCalc.setBackground(new Color(28, 94, 94));
			mBtnSale.setBackground(new Color(99, 166, 166));
			mBtnStat.setBackground(new Color(99, 166, 166));
			monitor.show(pMonitor, "Stock");
			btn.show(pFBtn, "Stockbtn");
		} else if (ob == mBtnAccount) {
			mBtnAccount.setBackground(new Color(255, 69, 0));
			mBtnInven.setBackground(new Color(28, 94, 94));
			mBtnCalc.setBackground(new Color(28, 94, 94));
			mBtnSale.setBackground(new Color(99, 166, 166));
			mBtnStat.setBackground(new Color(99, 166, 166));
			btn.show(pFBtn, "Accbtn");
			monitor.show(pMonitor, "admin");
		} else if (ob == mBtnSale) {
			mBtnSale.setBackground(new Color(255, 69, 0));
			mBtnAccount.setBackground(new Color(28, 94, 94));
			mBtnCalc.setBackground(new Color(28, 94, 94));
			mBtnInven.setBackground(new Color(28, 94, 94));
			mBtnStat.setBackground(new Color(99, 166, 166));
			monitor.show(pMonitor, "ViewSalesInput");
			btn.show(pFBtn, "salebtn");
		} else if (ob == mBtnStat) {
			mBtnStat.setBackground(new Color(255, 69, 0));
			mBtnAccount.setBackground(new Color(28, 94, 94));
			mBtnCalc.setBackground(new Color(28, 94, 94));
			mBtnSale.setBackground(new Color(99, 166, 166));
			mBtnInven.setBackground(new Color(28, 94, 94));
			monitor.show(pMonitor, "viewStatProduct");
			btn.show(pFBtn, "Statbtn");
		}
		// �� ���α�ɵ��� ���α��
		// �Ǹ� ���� ��ɵ�
		else if (ob == salebtn.sBtnCancel) {
			dealCancel.setVisible(true);
		} else if (ob == dealCancel.btnRefund) {
			int choose = JOptionPane.showConfirmDialog(dealCancel, "ȯ�� ������ �����Ͻðڽ��ϱ�?", "ȯ��",
					JOptionPane.OK_CANCEL_OPTION);
			if (choose == 0) {
				refundProcess();
			}
			dealCancel.Sell_id.setText("");
		} else if (ob == salebtn.sBtnDisuse) { // ������ ��ư
			monitor.show(pMonitor, "ViewSalesDisuse"); // ī�巹�̾ƿ����ȭ��
			showAllDisuse5();
		} else if (ob == salebtn.sBtnPdHold) { // ��ǰ ���� ��ư �̺�Ʈ

			// ���� ���
			if (isHold) {

				// *��ư ���� ���󺹱�, �ӽ������ߴ� ���̺� �� �缼��, �� ���� �ʵ� �����
				salebtn.sBtnPdHold.setBackground(new Color(0, 0, 128));
				productsHoldCancelProcess(hodingProductList);

				// ���� ��� ���̺��� �� ���� ����
				int rowsNum = viewSalesInput.table.getRowCount();

				// �߰��� ��� ���̺��� �� ���� ���� ��, ����
				int totalPrice = 0;
				for (int i = 0; i < rowsNum; i++) {
					totalPrice += Integer.parseInt(String.valueOf(viewSalesInput.model.getValueAt(i, 5)));
				}
				viewSalesInput.total_price_input.setText(Integer.toString(totalPrice));

				isHold = false;

				// ���� ����
			} else if (!isHold) {

				// ���� ��� ���̺��� �� ���� ����
				int rowsNum = viewSalesInput.table.getRowCount();

				// ���� ��Ͽ� ��ǰ�� 0���� ��� ��� ��, return
				if (rowsNum == 0) {
					JOptionPane.showMessageDialog(null, "������ ��ǰ�� �����ϴ�.");
					return;
				}

				// ���� ��Ͽ� ��ǰ�� 1�� �̻��� ���,
				// ���� ��ǰ���� ���� Vector<PosDto> ��ü�� holdingProductList�� �ӽ� ����
				hodingProductList = productsHoldProcess();

				// *��ư ���� ����, ���̺� �� ����, �� ���� �ʵ� ����
				salebtn.sBtnPdHold.setBackground(Color.ORANGE);
				clearRows(rowsNum, viewSalesInput.model);
				viewSalesInput.total_price_input.setText("");
				isHold = true;

			}

		}

// 		�� �˻� â ������ �� �̺�Ʈ
		else if (ob == salebtn.sBtnCustomer) {
			monitor.show(pMonitor, "ViewSalesCustomer");
			showAll();

		}

		else if (ob == viewSalesCustomer.search) {

//			ȸ�� �˻��� �� ����
			String name;
			String cellphone;
			name = viewSalesCustomer.name.getText().trim();
			cellphone = viewSalesCustomer.cellphone.getText().trim();

			if (name.equals("") && cellphone.equals("")) {
				JOptionPane.showMessageDialog(viewSalesCustomer, "ȸ�� �̸��̳� ��ȭ��ȣ�� �Է����ּ���", "ȸ�� ��ȸ ����",
						JOptionPane.INFORMATION_MESSAGE);
			} else if (name.contentEquals("")) {
				searchNameProcess1();

			} else if (cellphone.contentEquals("")) {
				searchNameProcess();
			} else {
				searchNameProcess2();
			}

		} else if (ob == payment_1.btnP1Before) {
			payment_1.setVisible(false);
			payment_2.setVisible(false);
			payment_4.setVisible(false);
			payment_3.setVisible(false);
		} else if (ob == payment_1.btnP1Next) {
			payment_1.setVisible(false);
			payment_2.setVisible(true);
		} else if (ob == payment_2.btnP2Before) {// ����2 â ����
			payment_1.setVisible(true);
			payment_2.setVisible(false);
			payment_3.setVisible(false);
			payment_4.setVisible(false);
		} else if (ob == payment_2.btnP2Next) {
			payment_3.setVisible(true);
			payment_2.setVisible(false);
		} else if (ob == payment_2.btnP2Cancel) {// ����4â ����
			payment_2.setVisible(false);
		} else if (ob == payment_3.btnP3Before) {
			payment_1.setVisible(false);
			payment_4.setVisible(false);
			payment_3.setVisible(false);
			payment_2.setVisible(true);

		} else if (ob == payment_3.btnP3Cancel) {
			payment_3.setVisible(false);
		} 

		else if (ob == viewSalesCustomer.enroll) {
			enrollprocess();
			showAll();
		} else if (ob.equals(viewSalesCustomer.delete)) {
			int choose = JOptionPane.showConfirmDialog(viewSalesCustomer, "ȸ���� �����Ͻðڽ��ϱ�?", "ȸ�� ����",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (choose == 0) {
				deleteprocess();
				showAll();
			}
		} else if (ob.equals(viewSalesDisuse.disuse)) {
			int choose = JOptionPane.showConfirmDialog(viewSalesDisuse, "��� ó�� �Ͻðڽ��ϰ�?", "��� ó��",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (choose == 0) {// Ȯ�δ�����
				deleteDisuseProcess();// ���� ����!
				setExp();
			}
		}

		// ��� ���� ��ɵ�
		else if (ob == stockbtn.stockevery) {
			stockmonitor.clearRows(stockmonitor.tmodel.getRowCount(), stockmonitor.tmodel);
			stockmonitor.showMon(stockdao.StockAll());
		} else if (ob == stockbtn.stockSearch) {
			stockpopupsearch.setVisible(true);
		} else if (ob == stockbtn.stockChg) {
			// �����Ұ� ������� ��ȿ���˻� getSelectedRow��ߵ�

			int tmp = stockmonitor.StockTable.convertRowIndexToModel(stockmonitor.StockTable.getSelectedRow());

			if (tmp < 0) {
				JOptionPane.showMessageDialog(this, "������ ��� �����ϼ���.", "�̼��� ����", JOptionPane.ERROR_MESSAGE);
				return;
			}

			String tmp1 = (String) stockmonitor.tmodel.getValueAt(tmp, 0);
			String tmp2 = (String) stockmonitor.tmodel.getValueAt(tmp, 1);
			String tmp3 = (String) stockmonitor.tmodel.getValueAt(tmp, 2);
			String tmp4 = (String) stockmonitor.tmodel.getValueAt(tmp, 3);

			stockpopupchg.selecItem.setText("��ǰ�ڵ� : " + tmp1 + " �԰��� : " + tmp2 + " ��ǰ�� : " + tmp3 + " ���� : " + tmp4);
			stockpopupchg.setVisible(true);
		} else if (ob == stockbtn.stockIn) {
			stockpopupin.setVisible(true);
		} else if (ob == stockpopupsearch.SearchCode || ob == stockpopupsearch.sCbtn) {
			// �����ȸ �ڵ�� �˻��ϱ�
			// ��ȿ�� �˻� �ϱ� ��� products���̺� �����ϴ� �ڵ�θ� �˻�������

			stockmonitor.clearRows(stockmonitor.tmodel.getRowCount(), stockmonitor.tmodel);

			String scode = stockpopupsearch.SearchCode.getText();

			stockmonitor.showMon(stockdao.StockSearchCode(scode));

			stockpopupsearch.setVisible(false);
			stockpopupsearch.SearchCode.setText("");
			stockpopupsearch.SearchName.setText("");
		} else if (ob == stockpopupsearch.searchCancel) {
			// �����ȸ ��ҹ�ư
			stockpopupsearch.setVisible(false);
			stockpopupsearch.SearchCode.setText("");
			stockpopupsearch.SearchName.setText("");
		} else if (ob == stockpopupsearch.SearchName || ob == stockpopupsearch.sNbtn) {
			// �����ȸ �̸����� �˻��ϱ�
			// ���������� �����ϴ� �̸��ΰ� �ƴѰ�
			stockmonitor.clearRows(stockmonitor.tmodel.getRowCount(), stockmonitor.tmodel);

			String sname = stockpopupsearch.SearchName.getText();

			stockmonitor.showMon(stockdao.StockSearchName(sname));

			stockpopupsearch.setVisible(false);
			stockpopupsearch.SearchCode.setText("");
			stockpopupsearch.SearchName.setText("");
		} else if (ob == stockpopupchg.chgCancel) {
			// ������ ��ҹ�ư
			stockpopupchg.setVisible(false);
			stockpopupchg.ChgCountTf.setText("");
			stockpopupchg.selecItem.setText("");
		} else if (ob == stockpopupchg.chgOk || ob == stockpopupchg.ChgCountTf) {
			// ������ Ȯ�ι�ư, ���������� ������ �Ŀ� �ٽ� ������ �������� ���̺� ���� �Ѹ�
			if (stockpopupchg.ChgCountTf.getText().trim().isEmpty()
					|| stockpopupchg.ChgCountTf.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this, "������ �Է����ּ���!", "�Է� ����", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (!isNumber(stockpopupchg.ChgCountTf.getText().trim())) {
				JOptionPane.showMessageDialog(this, "���ڸ� �Է����ּ���!", "�Է� ����", JOptionPane.ERROR_MESSAGE);
				return;
			}
			int count = Integer.parseInt(stockpopupchg.ChgCountTf.getText().trim());

			int tmp = stockmonitor.StockTable.convertRowIndexToModel(stockmonitor.StockTable.getSelectedRow());
			String productCode = (String) stockmonitor.tmodel.getValueAt(tmp, 0);
			String inDate = (String) stockmonitor.tmodel.getValueAt(tmp, 1);

			stockdao.StockChange(count, productCode, inDate);

			stockmonitor.clearRows(stockmonitor.tmodel.getRowCount(), stockmonitor.tmodel);

			stockmonitor.showMon(stockdao.StockAll());
			stockpopupchg.ChgCountTf.setText("");
			stockpopupchg.selecItem.setText("");
			stockpopupchg.setVisible(false);
		} else if (ob == stockpopupin.inCancel) {
			// �԰�â ��ҹ�ư ���빰 �ʱ�ȭ�ϰ� ����
			stockpopupin.setVisible(false);
			stockpopupin.IndateTf.setText("");
			stockpopupin.PcodeTf.setText("");
			stockpopupin.PcntTf.setText("");
			stockpopupin.pcodeResult.setText("");
			stockpopupin.pcntResult.setText("");
			stockpopupin.indateResult.setText("");
		} else if (ob == stockpopupin.PcodeTf || ob == stockpopupin.pcodeInput) {
			// �ڵ� �Է��ϸ� �Է����ڵ� ���� ǥ��
			stockpopupin.pcodeResult.setText(stockpopupin.PcodeTf.getText());

		} else if (ob == stockpopupin.IndateTf || ob == stockpopupin.indateInput) {
			// �԰����� �Է��ϸ� �Է��ѳ�¥ ǥ��
			stockpopupin.indateResult.setText(stockpopupin.IndateTf.getText());

		} else if (ob == stockpopupin.PcntTf || ob == stockpopupin.pcntInput) {
			// ���� �Է��ϸ� �Է��� ���� ǥ��
			stockpopupin.pcntResult.setText(stockpopupin.PcntTf.getText());

		} else if (ob == stockpopupin.inOk) {
			// ���� 3������ pcodeResult, indateResult, pcntResult�� ���ڰ� �޾Ƽ� in��
			if (isNumber(stockpopupin.pcntResult.getText())) {

				if (stockpopupin.pcodeResult.getText().isEmpty() || stockpopupin.pcodeResult.getText().trim().equals("")
						|| stockpopupin.indateResult.getText().trim().isEmpty()
						|| stockpopupin.indateResult.getText().trim().equals("")
						|| stockpopupin.pcntResult.getText().trim().isEmpty()
						|| stockpopupin.pcntResult.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(this, "��ĭ�� �ֽ��ϴ�!", "��� ����", JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					String pcode = stockpopupin.pcodeResult.getText().trim();
					String indt = stockpopupin.indateResult.getText().trim();
					int pcnt = Integer.parseInt(stockpopupin.pcntResult.getText().trim());

					int rr = stockdao.StockIn(pcode, indt, pcnt);
					if (rr == 0) {
						JOptionPane.showMessageDialog(this, "������ �԰�� ������ �ֽ��ϴ�!", "��� ����", JOptionPane.ERROR_MESSAGE);
						return;
					}

					stockmonitor.clearRows(stockmonitor.tmodel.getRowCount(), stockmonitor.tmodel);

					stockmonitor.showMon(stockdao.StockAll());
					stockpopupin.IndateTf.setText("");
					stockpopupin.PcodeTf.setText("");
					stockpopupin.PcntTf.setText("");
					stockpopupin.pcodeResult.setText("");
					stockpopupin.pcntResult.setText("");
					stockpopupin.indateResult.setText("");
					stockpopupin.setVisible(false);
				}

			} else {
				JOptionPane.showMessageDialog(this, "������ ���ڷ� ���ּ���!", "��� ����", JOptionPane.ERROR_MESSAGE);
				return;
			}

		}
		// ��� ����� ��ư��
		else if (ob == statbtn.sBtnProduct) {
			monitor.show(pMonitor, "viewStatProduct");
		} else if (ob == statbtn.sBtnYear) {
			monitor.show(pMonitor, "viewStatYear");
		} else if (ob == statbtn.sBtnMonth) {
			monitor.show(pMonitor, "viewStatMonth");
		} else if (ob == statbtn.sBtnDay) {
			monitor.show(pMonitor, "viewStatDay");
		}
		// ������� ��ư��
		// ������� �޺��ڽ����� ���� ���� �� ���� ����
		if (ob == admin.authority) {
			// �޺��ڽ� �ȿ��� ������ ���� ���ڿ��� ����
			String str = admin.authority.getSelectedItem().toString();
			if (str.equals("������")) {
				admin.auth = "T";
			} else if (str.equals("����")) {
				admin.auth = "F";
			}
		}

		// �������� �޺��ڽ����� ���� ���� �� ���� ����
		if (ob == admin.authorityUp) {
			String str = admin.authorityUp.getSelectedItem().toString();
			if (str.equals("������")) {
				admin.auth = "T";
			} else if (str.equals("����")) {
				admin.auth = "F";
			}
		}

		// ȸ������̶������.
		// �ο��̶������
		if (obb.equals("�������")) {
			admin.card.show(admin.pAcMonitor, "pRegister");
			admin.tfClear();
		}

		// ȸ�������̶�� ����.
		if (obb.equals("��������")) {
			admin.tfUClear();
			// ���� ��ȣ�� �̾ƿ�.
			int numberRow = admin.table.getSelectedRow();

			if (admin.table.getSelectedRow() < 0) { // ���̺� ���� �ٸ� ���� Ŭ�� ���� ���
				JOptionPane.showMessageDialog(this, "���̺��� Ŭ�����ּ���.");
			} else {
				String id = (String) admin.tm.getValueAt(numberRow, 2);
				admin.card.show(admin.pAcMonitor, "ppRegister");

				// �������� ���̵� �ؽ�Ʈ�ʵ尪�� ���̵�� ����
				admin.upuserTF.setText(id);
			}
		}

		// ������ ���������� ����.
		if (obb.equals("��������")) {
			UserDao userDao = new UserDao();

			if (admin.table.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(this, "���̺��� Ŭ�����ּ���.");

			} else {
				int x = JOptionPane.showConfirmDialog(this, "���� ���� �Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_OPTION);
				// ������ ������ ���
				if (x == JOptionPane.OK_OPTION) {
					admin.deleteUser();
					try {
						userDao.userSelectAll(admin.tm);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(this, "������ ��� �Ͽ����ϴ�.");
				}
			}
		}
		// ��������ȭ���� ����
		if (obb.equals("����")) {
			admin.updateUser();
		}

		// �������ȭ���� Ȯ��
		if (obb.equals("Ȯ��")) {

			admin.insertUser(); // ��ȿ�� �˻�

			PosDto re = admin.getViewData(); // ���� �Ѿ ������ userDto�� ����.
			admin.userDao = new UserDao(); // userDao ��ü ����

			if (admin.result) { // �����Ͱ� �Ѿ� ���ٸ�.
				try {
					admin.userDao.getMemberList(); // select �� ����.
					admin.userDao.insertMember(re); // insert�� ����.
					admin.userDao.userSelectAll(admin.tm);
				} catch (SQLException e1) {
					System.out.println("��� ����");
					e1.printStackTrace();
				}
			} else {
				admin.result = false;
				return;
			}
		}

		// ��ҹ�ư�� ������ ���ÿ� �ٽ� ���̺�ȭ������.
		if (obb.equals("���")) {
			System.out.println("��ҹ�ư���");
			admin.card.show(admin.pAcMonitor, "pTable");
		}

		// ���״�� �α׾ƿ� �α��� ȭ������ �Ѿ.
		if (obb.equals("�α׾ƿ�")) {
			this.setVisible(false);
			admin.forcePos = new ForcePos();
			admin.forcePos.setVisible(true);
		}

	}// �׼�������

	// <���̺� ���� ��� ����> �޼ҵ�
	public static void tableCellCenter(JTable t) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // ����Ʈ���̺��������� ����
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); // �������� ���������� CENTER��

		TableColumnModel tcm = t.getColumnModel(); // ������ ���̺��� �÷����� ������

		// ��ü ���� ����
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
	}

	private static boolean isNumber(String str) {
		boolean flag = true;
		int len = str.length();
		for (int i = 0; i < len; i++) {
			int num = str.charAt(i) - 48;
			if (num < 0 || num > 9) {
				flag = false;
				break;
			}
		}

		return flag;
	}

	// ���̺��� Ŭ��������� �̺�Ʈ �߻�
	MouseAdapter ms = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			admin.table = (JTable) e.getComponent();
			admin.tm = (DefaultTableModel) admin.table.getModel();
		}
	};

	@Override
	public void run() {
		while (true) {
			SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
			Date d = new Date();
			String str = df.format(d);

			try {
				thread.sleep(1000);
				dateLabel.setText(str);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
//	         System.out.println("����ð� :: " + str);
//	         idLabel.setText();
//	         dateLabel.setText(str);
		}
	}

	private void deleteDisuseProcess() {
		int row = viewSalesDisuse.tableResult.getSelectedRow();// ���õ� ���� ���
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "����� ��ǰ�� �������ּ���.", "��ǰ ��� ����", JOptionPane.WARNING_MESSAGE);
			return;
		}

		// ��ǰ�ڵ�� �԰�¥�� ���ڰ����� �޾Ƽ� (��� �԰�¥�� �ٸ� ������ǰ���� ��ǰ�ڵ尡 ���Ƶ� ���� ���;���)
		String productCode = null;//
		productCode = String.valueOf((viewSalesDisuse.tmodel.getValueAt(row, 0)));
		String inDate = null;
		//
		inDate = String.valueOf((viewSalesDisuse.tmodel.getValueAt(row, 1)));
		//
		int result = salesDao.deleteDisuse(productCode, inDate);
		if (result > 0) {
			showAllDisuse5();// ������� 5�ϳ��� �͵� ����Ʈ�� ������
		}
	}

	private void showAllDisuse5() {

		SalesDao salesDao = new SalesDao();
		SalesDao.clearRows(viewSalesDisuse.tmodel.getRowCount(), viewSalesDisuse.tmodel);
//		�� ������ ���̺��� ���� ���ڸ� �����´�.    
		Vector<PosDto> results = new Vector<PosDto>();// results �� �������� ��������.
		results = salesDao.showAllDisuse5();// �����ȸ�� ����� ��´�.

		int size = results.size();

		for (int i = 0; i < size; i++) {
			Vector<String> rows = new Vector<String>(); // ��
			rows.addElement(results.get(i).getProductCode());
			rows.addElement(results.get(i).getInDate());
			rows.addElement(results.get(i).getProductName());
			rows.addElement(Integer.toString(results.get(i).getPrice()));
			rows.addElement(results.get(i).getRealExp());
			rows.addElement(Integer.toString(results.get(i).getVolume()));
			viewSalesDisuse.tmodel.addRow(rows);
		}
	}

	private void refundProcess() {
		String sellId = null;
		sellId = dealCancel.Sell_id.getText().trim();

		if (sellId.contentEquals("")) {
			JOptionPane.showMessageDialog(dealCancel, "�ŷ� ��ȣ�� �Է����ּ���.", "ȯ�� ��ȸ ����", JOptionPane.WARNING_MESSAGE);
			return;
		}

//		receipt.setVisible(true);
//		receipt.refundDetail.append("��ҿ�����/n" + "�Ǹ��ڵ� : \t" );

		Vector<PosDto> list = new Vector<PosDto>();
		list = salesDao.selectUpdateStock(sellId);

		System.out.println(list.toString());

		if (list.isEmpty()) {
			JOptionPane.showMessageDialog(dealCancel, "�ŷ� ��ȣ�� �ùٸ��� �ʽ��ϴ�.", "ȯ�� ��ȸ ����", JOptionPane.WARNING_MESSAGE);
			return;
		}

		salesDao.updateMembership(sellId); // ����� : ����� ����Ʈ ����
		salesDao.updateMoney(sellId); // ���� update : ���� ����׸�ŭ ����
		salesDao.updateStock(list); // ��� update : ���� ������ŭ ��� ������ ���ϱ�
		salesDao.deletehistory_d(sellId);
		salesDao.deletehisotry(sellId);

		JOptionPane.showMessageDialog(dealCancel, "ȯ�� ó���� �Ϸ�Ǿ����ϴ�.", "ȯ�� �Ϸ�", JOptionPane.INFORMATION_MESSAGE);
		dealCancel.dispose();
	}

	private void deleteprocess() {
		int row = viewSalesCustomer.tableResult.getSelectedRow();

		if (row < 0) {
			JOptionPane.showMessageDialog(this, "������ ȸ���� �������ּ���.", "ȸ�� ���� ����", JOptionPane.WARNING_MESSAGE);
			return;
		}

		String phone = null;
		phone = String.valueOf((viewSalesCustomer.tmodel.getValueAt(row, 0)));
		salesDao.delete(phone);
	}

	// 1) <��ǰ���� ����> �޼ҵ�
	// : ���� ����� ��ǰ���� ������ Vector<PosDto>�� ����
	private Vector<PosDto> productsHoldProcess() {

		Vector<PosDto> currentList = new Vector<PosDto>();

		int rowsNum = viewSalesInput.table.getRowCount();

		for (int i = 0; i < rowsNum; i++) {
			PosDto row = new PosDto();
			// PosDto ��ü�� ���� ����� ��ǰ �� ���� ������ ����
			row.setListNum(Integer.parseInt((String) viewSalesInput.model.getValueAt(i, 0)));
			row.setProductCode((String) viewSalesInput.model.getValueAt(i, 1));
			row.setProductName((String) viewSalesInput.model.getValueAt(i, 2));
			row.setPrice(Integer.parseInt((String) viewSalesInput.model.getValueAt(i, 3)));
			row.setProductSellCount(String.valueOf(viewSalesInput.model.getValueAt(i, 4)));
			row.setProductSellPrice(Integer.parseInt(String.valueOf(viewSalesInput.model.getValueAt(i, 5))));
			row.setInDate(String.valueOf(viewSalesInput.model.getValueAt(i, 6)));

			// ���ڷ� ���� Vector<PosDto> ��ü�� ����
			currentList.add(row);
		}

		// ���� ���� ����
		return currentList;

	}

	// 2) <��ǰ���� ���> �޼ҵ�
	// : ������ ������ ��ǰ ����� �ٽ� ���̺� �߰�
	private void productsHoldCancelProcess(Vector<PosDto> beforeList) {

		// �����س��� ��ǰ ��� �� ����
		int bfRowsNum = beforeList.size();

		for (int i = 0; i < bfRowsNum; i++) {
			Vector<String> plusRows = new Vector<String>();

			// ���� ��Ͽ�, ���� ��� ��ǰ�� ��ǰ�ڵ尡 ��ġ�� ��ǰ�� �ִ� ���
			int overlapRow = checkOverlap(beforeList.get(i).getProductCode());
			if (overlapRow > -1) {
				// ���� ��Ͽ� �ִ� �ش� ��ǰ�� ����, �� ���ݸ� ����
				// ���� +1
				viewSalesInput.model
						.setValueAt(Integer.valueOf(String.valueOf(viewSalesInput.model.getValueAt(overlapRow, 4)))
								+ Integer.valueOf(beforeList.get(i).getProductSellCount()), overlapRow, 4);
				// �� ���� ����
				viewSalesInput.model.setValueAt(
						Integer.valueOf(String.valueOf(viewSalesInput.model.getValueAt(overlapRow, 3)))
								* Integer.valueOf(String.valueOf(viewSalesInput.model.getValueAt(overlapRow, 4))),
						overlapRow, 5);
				// �ش� ��ǰ�� �߰� ��Ͽ� ���� �ʰ�, ���� i�� �Ѿ��
				continue;
			}
			System.out.println(i);
			plusRows.addElement(Integer.toString(beforeList.get(i).getListNum()));
			plusRows.addElement(beforeList.get(i).getProductCode());
			plusRows.addElement(beforeList.get(i).getProductName());
			plusRows.addElement(Integer.toString(beforeList.get(i).getPrice()));
			plusRows.addElement(beforeList.get(i).getProductSellCount());
			plusRows.addElement(Integer.toString(beforeList.get(i).getProductSellPrice()));
			plusRows.addElement(beforeList.get(i).getInDate());

			viewSalesInput.model.addRow(plusRows);
		}

	}

	// 3) <��ǰ ���� ��� ��, �ߺ� ���� üũ> �޼ҵ�
	// : ��ǰ ���� ��� ��, ���� ��ǰ ��ϰ� ��ġ�� ��ǰ �ڵ尡 �ִ��� üũ ��, �ش� �� num�� ��ȯ
	public int checkOverlap(String identifier) {
		System.out.println("check" + identifier);

		// �ߺ� �� ���� ����
		int num = -1;

		// ���� ��ǰ ��� ���� ����
		int rows = viewSalesInput.model.getRowCount();
		// �ߺ� ��ǰ ���� üũ
		for (int i = 0; i < rows; i++) {
			if (viewSalesInput.model.getValueAt(i, 1).equals(identifier)) {
				num = i;
				return num;
			}
		}
		return num;
	}

	// 4) <���̺� �����> �޼ҵ�
	public static void clearRows(int rowSize, DefaultTableModel dtm) {
		if (rowSize > 0) {
			for (int i = rowSize - 1; i >= 0; i--) {
				dtm.removeRow(i);
			}
		}
	}
//		*******************************************************************************************************************

	private void enrollprocess() {
		SalesDao.clearRows(viewSalesCustomer.tmodel.getRowCount(), viewSalesCustomer.tmodel);
		String name;
		String cellphone;
		name = viewSalesCustomer.name.getText().trim();
		cellphone = viewSalesCustomer.cellphone.getText().trim();
		if (!name.equals("") && !cellphone.equals("")) {
			salesDao.register(name, cellphone);
			viewSalesCustomer.name.setText("");
			viewSalesCustomer.cellphone.setText("");
			JOptionPane.showMessageDialog(viewSalesCustomer, "���ο� ȸ���� ��ϵǾ����ϴ�.", "ȸ�� ��� �Ϸ�",
					JOptionPane.INFORMATION_MESSAGE);

		} else {
			JOptionPane.showMessageDialog(viewSalesCustomer, "ȸ�� �̸��� ��ȭ��ȣ�� �Է����ּ���", "ȸ�� ��� ����",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	private void searchNameProcess() {

		SalesDao salesDao = new SalesDao();
		SalesDao.clearRows(viewSalesCustomer.tmodel.getRowCount(), viewSalesCustomer.tmodel);
		Vector<PosDto> results = new Vector<PosDto>();
		String name;
		name = viewSalesCustomer.name.getText().trim();
		results = salesDao.search(name);
		int size = results.size();
		if (size == 0) {
			JOptionPane.showMessageDialog(viewSalesCustomer, "�������� �ʴ� ȸ���Դϴ�.", "ȸ�� ��ȸ ����",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		for (int i = 0; i < size; i++) {
			Vector<String> rows = new Vector<String>(); // ��
			rows.addElement(results.get(i).getMembershipId());
			rows.addElement(results.get(i).getMemberName());
			rows.addElement(results.get(i).getPhone());
			rows.addElement(Integer.toString(results.get(i).getPoint()));
			viewSalesCustomer.tmodel.addRow(rows);
		}
	}

	private void searchNameProcess1() {

		SalesDao salesDao = new SalesDao();
		SalesDao.clearRows(viewSalesCustomer.tmodel.getRowCount(), viewSalesCustomer.tmodel);
		Vector<PosDto> results = new Vector<PosDto>();
		String cellphone;
		cellphone = viewSalesCustomer.cellphone.getText().trim();
		results = salesDao.search1(cellphone);
		int size = results.size();
		if (size == 0) {
			JOptionPane.showMessageDialog(viewSalesCustomer, "�������� �ʴ� ȸ���Դϴ�.", "ȸ�� ��ȸ ����",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		for (int i = 0; i < size; i++) {
			Vector<String> rows = new Vector<String>(); // ��
			rows.addElement(results.get(i).getMembershipId());
			rows.addElement(results.get(i).getMemberName());
			rows.addElement(results.get(i).getPhone());
			rows.addElement(Integer.toString(results.get(i).getPoint()));
			viewSalesCustomer.tmodel.addRow(rows);
		}
	}

	private void searchNameProcess2() {
		SalesDao salesDao = new SalesDao();
		SalesDao.clearRows(viewSalesCustomer.tmodel.getRowCount(), viewSalesCustomer.tmodel);
		Vector<PosDto> results = new Vector<PosDto>();
		String name;
		String cellphone;

		name = viewSalesCustomer.name.getText().trim();
		cellphone = viewSalesCustomer.cellphone.getText().trim();
		results = salesDao.search2(name, cellphone);
		int size = results.size();
		if (size == 0) {
			JOptionPane.showMessageDialog(viewSalesCustomer, "�������� �ʴ� ȸ���Դϴ�.", "ȸ�� ��ȸ ����",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		for (int i = 0; i < size; i++) {
			Vector<String> rows = new Vector<String>(); // ��
			rows.addElement(results.get(i).getMembershipId());
			rows.addElement(results.get(i).getMemberName());
			rows.addElement(results.get(i).getPhone());
			rows.addElement(Integer.toString(results.get(i).getPoint()));
			viewSalesCustomer.tmodel.addRow(rows);
		}
	}

	private void showAll() {

		SalesDao salesDao = new SalesDao();
		SalesDao.clearRows(viewSalesCustomer.tmodel.getRowCount(), viewSalesCustomer.tmodel);
		Vector<PosDto> results = new Vector<PosDto>();
		results = salesDao.searchAll();

		int size = results.size();

		for (int i = 0; i < size; i++) {
			Vector<String> rows = new Vector<String>(); // ��
			rows.addElement(results.get(i).getMembershipId());
			rows.addElement(results.get(i).getMemberName());
			rows.addElement(results.get(i).getPhone());
			rows.addElement(Integer.toString(results.get(i).getPoint()));
			viewSalesCustomer.tmodel.addRow(rows);
		}

	}
	
	public void setExp() {
		posdto = new PosDto();
		stockdao.expCount();
		notice.setText(ForcePos.expName.getExpName() + " ��ǰ�� ��������� " + ForcePos.exp.getExp() + "�ð� ��ŭ ���ҽ��ϴ�.");
	}

}// Ŭ���� ��