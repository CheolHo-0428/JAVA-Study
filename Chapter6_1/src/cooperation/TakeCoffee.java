package cooperation;

public class TakeCoffee {

	public static void main(String[] args) {
		Person personKim = new Person("±è¾¾", 30000);
		Person personLee = new Person("ÀÌ¾¾", 20000);
		
		starBucks StarBucks = new starBucks("¾Æ¸Þ¸®Ä«³ë");
		personKim.takestarBucks(StarBucks);
		personKim.showInfo();
		StarBucks.showInfo();
		
		coffeeBean CoffeeBean = new coffeeBean("¶ó¶¼");
		personLee.takecoffeeBean(CoffeeBean);
		personLee.showInfo();
		CoffeeBean.showInfo();
	}
}
