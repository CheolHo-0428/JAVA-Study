package sec04.exam05;

public class CarTest {

	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.keyTrunOn();
		myCar.run();
		int speed = myCar.getSpeed();
		System.out.println("���� �ӵ�: " + myCar.speed + "km/h");
	}
}
