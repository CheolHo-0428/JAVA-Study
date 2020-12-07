package sec01.exam03;

public class Computer extends Calculator {
	//필드
	
	//생성자
	Computer(){
	super();
	}
	//메소드
	@Override
	double areaCircle(double r) {
		System.out.println("Computer 객체의 areaCircle()실행");
		return Math.PI * r * r;
	}	
}
