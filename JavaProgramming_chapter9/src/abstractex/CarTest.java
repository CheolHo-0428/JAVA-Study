package abstractex;

import java.util.ArrayList;

public class CarTest {
	public static void main(String[] args) {
		ArrayList<Car> carList = new ArrayList<Car>();	
		Car bus = new Bus();
		Car autoCar = new AutoCar();
		
		carList.add(bus);
		carList.add(autoCar);
		
		for(Car car : carList) {
			car.run();			
		}
		
		for(Car car : carList) {
			car.refuel();			
		}
		
		for(Car car : carList) {
			if(car == bus) {
				if(bus instanceof Bus) {
					Bus b = (Bus)bus;
					b.takePassenger();
				}
			}
			else {
				if(autoCar instanceof AutoCar) {
					AutoCar a = (AutoCar)autoCar;
					a.load();
			}
			}
		}
		for (Car car : carList) {
			car.stop();
		}
	}
}
