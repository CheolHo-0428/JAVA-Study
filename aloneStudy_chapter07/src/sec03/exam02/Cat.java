package sec03.exam02;

public class Cat extends Animal {
	//�ʵ�
	
	//������
	public Cat() {
		this.kind = "������";
	}
	
	//�޼ҵ�
	@Override
	public void sound() {
		System.out.println("�߿�");		
	}
}
