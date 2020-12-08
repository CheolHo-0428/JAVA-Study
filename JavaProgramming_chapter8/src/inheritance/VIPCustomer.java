package inheritance;

public class VIPCustomer extends Customer {
	//필드
	private int agentID;
	double saleRatio;
	
	//생성자
	public VIPCustomer(int customerID, String customerName, int agentID) {
		super(customerID, customerName);
		this.agentID = agentID;
		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
//		System.out.println("VIPCustomer(int, String, int) 생성자 호출");
	}
	
	//메소드
	@Override
	public int calPrice(int price) {
		bonusPoint = (int)(bonusPoint +(price * bonusRatio));
		return price - (int)(price * saleRatio);
	}
	
	public String showVIPInfo() {
		return super.showCustomerInfo() + "담당 상담원 아이디는 " + agentID + " 입니다.";
	}
	
	public int getAgentID() {
		return agentID;
	}
}
