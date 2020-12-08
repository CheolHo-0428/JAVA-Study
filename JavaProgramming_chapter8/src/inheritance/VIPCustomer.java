package inheritance;

public class VIPCustomer extends Customer {
	//�ʵ�
	private int agentID;
	double saleRatio;
	
	//������
	public VIPCustomer(int customerID, String customerName, int agentID) {
		super(customerID, customerName);
		this.agentID = agentID;
		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
//		System.out.println("VIPCustomer(int, String, int) ������ ȣ��");
	}
	
	//�޼ҵ�
	@Override
	public int calPrice(int price) {
		bonusPoint = (int)(bonusPoint +(price * bonusRatio));
		return price - (int)(price * saleRatio);
	}
	
	public String showVIPInfo() {
		return super.showCustomerInfo() + "��� ���� ���̵�� " + agentID + " �Դϴ�.";
	}
	
	public int getAgentID() {
		return agentID;
	}
}
