package singleton;

public class Car {
	private static int serialNum = 10000;
	private int carNum;
	
	public Car () {
		serialNum = serialNum + 1;
		carNum = serialNum;
	}
	
	public int getCarNum() {
		return carNum;
	}
	
	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}
}
