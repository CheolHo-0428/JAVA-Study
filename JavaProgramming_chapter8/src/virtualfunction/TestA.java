package virtualfunction;

public class TestA {
	//�ʵ�
	int num;
	
	//������
	TestA(){}
	
	//�޼ҵ�
	void aaa() {
		System.out.println("aaa() ���");
	}
	
	public static void main(String[] args) {
		TestA a1 = new TestA();
		a1.aaa();
		TestA a2 = new TestA();
		a2.aaa();
	}

}
