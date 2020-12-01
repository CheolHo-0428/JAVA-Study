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
		System.out.println("스타벅스는 " + coffee + "를 판매했고, 손님은 " 
	+ guestCount + "명이고, 수입은 " + money + "원 입니다." );
	}
}
