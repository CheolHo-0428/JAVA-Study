package polymorphism;

public class VIPCustomer extends Customer {
	//필드
	private int agentID;
	double saleRatio;
	
	//생성자
	public VIPCustomer(int customerID, String customerName, int agentID) {
		super(customerID, customerName);
		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
		this.agentID = agentID;
	}
	//메소드
	public int calPrice(int price) {
		bonusPoint = (int)(bonusPoint +(price*bonusRatio));
		return (int)(price - (price*saleRatio));
	}
	
	public String showCustomerInfo() {
		return super.showCustomerInfo() +"담당 상담원번호는 " + agentID + " 입니다."; 
	}
	
	public int getAgentID() {
		return agentID;
	}
}