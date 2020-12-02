package sec03.exam04;

public class CarExample {

	public static void main(String[] args) {
		Car car1 = new Car();
		System.out.println("car1.company: " + car1.company);
		System.out.println();
		
		Car car2 = new Car("¾Æ¹Ý¶¼");
		System.out.println("car2.company: " +car2.company);
		System.out.println("car2.model: " +car2.model);
		System.out.println("car2.color: " +car2.color);
		System.out.println("car2.maxSpeed: " +car2.maxSpeed);
		System.out.println();
		
		Car car3 = new Car("¼Ò³ªÅ¸", "»¡°­");
		System.out.println("car3.company: " +car3.company);
		System.out.println("car3.model: " +car3.model);
		System.out.println("car3.color: " +car3.color);
		System.out.println("car3.maxSpeed: " +car3.maxSpeed);
		System.out.println();
		
		Car car5 = new Car("Åõ½Ñ", "°ËÁ¤", 300);
		System.out.println("car5.company: " +car5.company);
		System.out.println("car5.model: " +car5.model);
		System.out.println("car5.color: " +car5.color);
		System.out.println("car5.maxSpeed: " +car5.maxSpeed);
	}

}
