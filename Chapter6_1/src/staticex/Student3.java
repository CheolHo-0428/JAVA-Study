package staticex;

public class Student3 {
	public static int serialNum = 1000;
	public static int cardNum = 100;
	int studentID;
	int studentCN;
	String studentName;
	int grade;
	String address;
	
	public Student3() {
		serialNum = serialNum + 1;
		studentID = serialNum ;
		cardNum = studentID + 100;
		studentCN = cardNum; 
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String name) {
		studentName = name;
	}

	public static int getSerialNum() {
		return serialNum;
	}

	public static void setSerialNum(int serialNum) {
		Student3.serialNum = serialNum;
	}

	public static int getCardNum() {
		return cardNum;
	}

	public static void setCardNum(int cardNum) {
		Student3.cardNum = cardNum;
	}
	
	
	
}