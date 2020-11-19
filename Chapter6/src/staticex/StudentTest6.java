package staticex;

public class StudentTest6 {

	public static void main(String[] args) {
		Student3 studentCho = new Student3();
		studentCho.setStudentName("Á¶Ã¶È£");
		System.out.println(Student3.getSerialNum());
		System.out.println(studentCho.studentName + " ÇĞ¹ø:" + studentCho.studentCard);
		
		Student3 studentChoi = new Student3();
		studentChoi.setStudentName("ÃÖ¹ÎÁö");
		System.out.println(Student3.getSerialNum());
		System.out.println(studentChoi.studentName + " ÇĞ¹ø:" + studentChoi.studentCard);

	}

}
