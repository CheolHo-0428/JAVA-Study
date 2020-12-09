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
				System.out.println("=== 자율 주행하는 자동차 ===");
			}
			else {
				System.out.println("=== 사람이 운전하는 자동차 ===");
			}			
			car.run();
		}
	}
}
