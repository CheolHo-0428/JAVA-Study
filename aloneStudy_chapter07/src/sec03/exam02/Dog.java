package sec03.exam02;

public class Dog extends Animal {
	//필드
	
	//생성자
	public Dog() {
		this.kind = "포유류";
	}
	
	//메소드
	@Override
	public void sound() {
		System.out.println("멍멍");		
	}
}
