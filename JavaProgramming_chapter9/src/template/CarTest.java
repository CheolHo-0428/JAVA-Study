package template;

public class CarTest {
	public static void main(String[] args) {
		Car aiCar = new AICar();
		Car manualCar = new ManualCar();
		
		System.out.println("=== ���� �����ϴ� �ڵ��� ===");
		aiCar.
		run();
		
		System.out.println("=== ����� �����ϴ� �ڵ��� ===");
		manualCar.run();
	}
}
