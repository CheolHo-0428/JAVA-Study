package sec01.exam03;

public class Computer extends Calculator {
	//�ʵ�
	
	//������
	Computer(){
	super();
	}
	//�޼ҵ�
	@Override
	double areaCircle(double r) {
		System.out.println("Computer ��ü�� areaCircle()����");
		return Math.PI * r * r;
	}	
}
