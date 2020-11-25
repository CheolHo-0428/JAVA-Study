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
		
		System.out.println("나이가 " + man1.Age + "살, " + "이름이 " + man1.ManName + "라는 남자가 있습니다. 이 남자는 결혼여부가 " + man1.isMarried + "이고, 자식이 " + man1.Son + "명 있습니다."  );

	}

}
