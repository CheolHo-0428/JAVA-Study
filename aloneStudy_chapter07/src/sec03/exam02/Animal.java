package sec03.exam02;

public abstract class Animal {
	//�ʵ�
	public String kind;
	
	
	//������
	public Animal() {}
	
	//�޼ҵ�
	public void breathe() {
		System.out.println("���� ���ϴ�.");
	}
	
	public abstract void sound();
}
