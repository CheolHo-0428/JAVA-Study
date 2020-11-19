package staticex;

public class Student3 {
	private static int serialNum = 1000;
	int studentId;
	String studentName;
	int grade;
	String address;
	int studentCard; // ÇĞ¹ø studentId + 100
	
	public Student3( ) {
		serialNum = serialNum + 100 ;
		studentId = serialNum;
		studentCard = studentId; 
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String name) {
		studentName = name;
	}
	
	public static int getSerialNum( ) {
		int i = 10;
		return serialNum;
	}
	
	public static void setSerialNum(int serialNum) {
		Student3.serialNum = serialNum;
	}
	

}
