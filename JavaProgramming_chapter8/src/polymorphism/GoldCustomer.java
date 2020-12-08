package polymorphism;

public class GoldCustomer extends Customer {
	//�ʵ�
	double saleRatio;
	
	//������
	public GoldCustomer(int customerID, String customerName) {
		super(customerID, customerName);
		customerGrade = "GOLD";
		bonusRatio = 0.02;
		saleRatio = 0.1;
	}
	//�޼ҵ�
	@Override
	public int calcPrice(int price) {
		bonusPoint = (int)(bonusPoint + (price*bonusRatio));
		return (int)(price-(price*saleRatio));
	}
}
