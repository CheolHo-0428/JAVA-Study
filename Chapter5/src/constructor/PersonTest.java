package constructor;

public class PersonTest {

	public static void main(String[] args) {
		Person personCho = new Person();
		personCho.Name = "조철호";
		personCho.Age = 34;
		personCho.IsMarried = true;
		personCho.Job = "학생";
				
		System.out.println("이름 : " + personCho.Name);
		System.out.println("나이 : " + personCho.Age + "살");
		System.out.println("결혼여부 : " + personCho.IsMarried);
		System.out.println("직업 : " + personCho.Job);
		
		Person personChoi = new Person("최민지", 35, true, "프리랜서" );
	}	
}