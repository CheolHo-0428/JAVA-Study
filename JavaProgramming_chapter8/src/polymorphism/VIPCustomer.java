package polymorphism;

public class VIPCustomer extends Customer {
	//�ʵ�
	private int agentID;
	double saleRatio;
	
	//������
	public VIPCustomer(int customerID, String customerName, int agentID) {
		super(customerID, customerName);
		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
		this.agentID = agentID;
	}
	//�޼ҵ�
	public int calPrice(int price) {
		bonusPoint = (int)(bonusPoint +(price*bonusRatio));
		return (int)(price - (price*saleRatio));
	}
	
	public String showCustomerInfo() {
		return super.showCustomerInfo() +"��� ������ȣ�� " + agentID + " �Դϴ�."; 
	}
	
	public int getAgentID() {
		return agentID;
	}
}