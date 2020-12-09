package alone;

import java.util.ArrayList;

public class CarTest {
	public static void main(String[] args) {
		ArrayList<Car> carList = new ArrayList<Car>();
		Car aiCar = new AICar();
		Car manualCar = new ManualCar();
		
		carList.add(aiCar);
		carList.add(manualCar);
		
		for(Car car : carList) {
			if(car == aiCar) {
				System.out.println("=== ���� �����ϴ� �ڵ��� ===");
			}
			else {
				System.out.println("=== ����� �����ϴ� �ڵ��� ===");
			}			
			car.run();
		}
	}
}
