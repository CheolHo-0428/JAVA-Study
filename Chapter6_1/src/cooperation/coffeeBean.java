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
		System.out.println("커피빈은 " + coffee + "를 판매했고, 손님은 " 
	+ guestCount + "명이고, 수입은 " + money + "원 입니다." );
	}
}
