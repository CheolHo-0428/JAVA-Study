package sec03.exam04;

public class Car {
	//�ʵ�
	String company = "�����ڵ���";
	String model;
	String color;
	int maxSpeed;
	
	//������
	Car( ) { }
	
	Car(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	
	Car(String model) {
		this(model, "����", 200);
	}
	
	Car(String model, String color) {
		this(model, color, 250);
	}
	

}