package sec05.exam03;

public class Car {
	int speed;
	
	void run() {
		System.out.println(speed + "km/h로 달립니다.");
	}

	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.speed = 60;
		myCar.run();
	}
}
