package cooperation;

public class TakeCoffee {

	public static void main(String[] args) {
		Person personKim = new Person("�达", 30000);
		Person personLee = new Person("�̾�", 20000);
		
		starBucks StarBucks = new starBucks("�Ƹ޸�ī��");
		personKim.takestarBucks(StarBucks);
		personKim.showInfo();
		StarBucks.showInfo();
		
		coffeeBean CoffeeBean = new coffeeBean("��");
		personLee.takecoffeeBean(CoffeeBean);
		personLee.showInfo();
		CoffeeBean.showInfo();
	}
}
