package template;

public class CarTest {
	public static void main(String[] args) {
		Car aiCar = new AICar();
		Car manualCar = new ManualCar();
		
		System.out.println("=== 자율 주행하는 자동차 ===");
		aiCar.
		run();
		
		System.out.println("=== 사람이 운전하는 자동차 ===");
		manualCar.run();
	}
}
