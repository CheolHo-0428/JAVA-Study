package cooperation;

public class starBucks {
	String coffee;
	int guestCount;
	int money;
	
	public starBucks(String coffee) {
		this.coffee = coffee;
	}
	public void take(int money) {
		this.money += money;
		guestCount++ ;
	}
	public void showInfo() {
		System.out.println("��Ÿ������ " + coffee + "�� �Ǹ��߰�, �մ��� " 
	+ guestCount + "���̰�, ������ " + money + "�� �Դϴ�." );
	}
}
