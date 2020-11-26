package test;

import hiding.Student;

public class StudentTest {

	public static void main(String[] args) {
		Student studentLee = new Student();
		studentLee.setStudentID(77);
		studentLee.setGrade(90);
		studentLee.setStudentName("Á¶Ã¶È£");
		
		System.out.println(studentLee.getStudentID());
		System.out.println(studentLee.getGrade());
		System.out.println(studentLee.getStudentName());
	}
		
}
