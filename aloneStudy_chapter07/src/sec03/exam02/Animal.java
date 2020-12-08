package sec03.exam02;

public abstract class Animal {
	//필드
	public String kind;
	
	
	//생성자
	public Animal() {}
	
	//메소드
	public void breathe() {
		System.out.println("숨을 쉽니다.");
	}
	
	public abstract void sound();
}
