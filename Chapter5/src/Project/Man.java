package Project;

public class Man {
	int Age;
	String ManName;
	boolean isMarried;
	int Son;

	public static void main(String[] args) {
		Man man1 = new Man();
		man1.Age = 40;
		man1.ManName = "James";
		man1.isMarried = true;
		man1.Son = 3;
		
		System.out.println("���̰� " + man1.Age + "��, " + "�̸��� " + man1.ManName + "��� ���ڰ� �ֽ��ϴ�. �� ���ڴ� ��ȥ���ΰ� " + man1.isMarried + "�̰�, �ڽ��� " + man1.Son + "�� �ֽ��ϴ�."  );

	}

}
