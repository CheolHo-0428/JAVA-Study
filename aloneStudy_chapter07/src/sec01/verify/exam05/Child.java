package sec01.verify.exam05;

public class Child extends Parent {
	//필드
	private String name;
	
	//생성자
	public Child() {
		this("홍길동");
		System.out.println("Child() call");
	}
	
	public Child(String name) {
		this.name = name;
		System.out.println("Child(String name) call");
	}

}
