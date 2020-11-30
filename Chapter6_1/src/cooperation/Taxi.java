package cooperation;

public class Taxi {
	String TaxiColor;
	int passengerCount;
	int money;
	
	public Taxi(String TaxiColor) {
		this.TaxiColor = TaxiColor;
	}
	
	public void take(int money) {
		this.money = this.money + money;
		this.passengerCount = this.passengerCount + 1; 
	}
	
	public void showInfo() {
		System.out.println(TaxiColor + "의 승객은 " 
	+ passengerCount + "명이고, 수입은 " + money + "입니다." );
	}
}
