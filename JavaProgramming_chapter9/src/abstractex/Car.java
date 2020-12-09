package abstractex;

public abstract class Car {
	//필드
	//생성자
	//메소드
	public abstract void run();
	
	public abstract void refuel();
	
	public void stop() {
		System.out.println("차가 멈춥니다.");		
	}
}
