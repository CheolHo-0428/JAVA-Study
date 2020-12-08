package polymorphism;

public class GoldCustomer extends Customer {
	//필드
	double saleRatio;
	
	//생성자
	public GoldCustomer(int customerID, String customerName) {
		super(customerID, customerName);
		customerGrade = "GOLD";
		bonusRatio = 0.02;
		saleRatio = 0.1;
	}
	//메소드
	@Override
	public int calcPrice(int price) {
		bonusPoint = (int)(bonusPoint + (price*bonusRatio));
		return (int)(price-(price*saleRatio));
	}
}
