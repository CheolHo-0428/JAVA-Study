package sec03.exam02;

public class Dog extends Animal {
	//�ʵ�
	
	//������
	public Dog() {
		this.kind = "������";
	}
	
	//�޼ҵ�
	@Override
	public void sound() {
		System.out.println("�۸�");		
	}
}
