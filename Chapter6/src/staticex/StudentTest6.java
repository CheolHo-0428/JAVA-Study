package staticex;

public class StudentTest6 {

	public static void main(String[] args) {
		Student3 studentCho = new Student3();
		studentCho.setStudentName("��öȣ");
		System.out.println(Student3.getSerialNum());
		System.out.println(studentCho.studentName + " �й�:" + studentCho.studentCard);
		
		Student3 studentChoi = new Student3();
		studentChoi.setStudentName("�ֹ���");
		System.out.println(Student3.getSerialNum());
		System.out.println(studentChoi.studentName + " �й�:" + studentChoi.studentCard);

	}

}
