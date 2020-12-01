package cooperation;

public class Person {
	String personName;
	int money;
	
	public Person (String personName, int money) {
		this.personName = personName;
		this.money = money;
	}
	
	public void takestarBucks(starBucks StarBucks) {
		StarBucks.take(4000);
		this.money = this.money - 4000;
	}
	
	public void takecoffeeBean(coffeeBean CoffeeBean) {
		CoffeeBean.take(4500);
		this.money = this.money - 4500;
	}
	
	public void showInfo() {
		System.out.println(personName + "´ÔÀÇ ³²Àº µ·Àº " + money + "¿ø ÀÔ´Ï´Ù.");
	}

}
