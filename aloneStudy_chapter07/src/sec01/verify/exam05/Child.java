package sec01.verify.exam05;

public class Child extends Parent {
	//�ʵ�
	private String name;
	
	//������
	public Child() {
		this("ȫ�浿");
		System.out.println("Child() call");
	}
	
	public Child(String name) {
		this.name = name;
		System.out.println("Child(String name) call");
	}

}
