package constructor;

public class PersonTest {

	public static void main(String[] args) {
		Person personCho = new Person();
		personCho.Name = "��öȣ";
		personCho.Age = 34;
		personCho.IsMarried = true;
		personCho.Job = "�л�";
				
		System.out.println("�̸� : " + personCho.Name);
		System.out.println("���� : " + personCho.Age + "��");
		System.out.println("��ȥ���� : " + personCho.IsMarried);
		System.out.println("���� : " + personCho.Job);
		
		Person personChoi = new Person("�ֹ���", 35, true, "��������" );
	}	
}