package sec03.exam01;

public class SmartPhone extends Phone {
	//필드
	
	//생성자
	public SmartPhone(String owner) {
		super(owner);
	}
	
	//메소드
	public void internetSerch() {
		System.out.println("인터넷 검색을 합니다.");
	}
}
