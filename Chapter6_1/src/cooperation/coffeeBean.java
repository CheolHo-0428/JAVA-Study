package cooperation;

public class coffeeBean {
	String coffee;
	int guestCount;
	int money;
	
	public coffeeBean(String coffee) {
		this.coffee = coffee;
	}
	public void take(int money) {
		this.money += money;
		guestCount++ ;
	}
	public void showInfo() {
		System.out.println("Ŀ�Ǻ��� " + coffee + "�� �Ǹ��߰�, �մ��� " 
	+ guestCount + "���̰�, ������ " + money + "�� �Դϴ�." );
	}
}
