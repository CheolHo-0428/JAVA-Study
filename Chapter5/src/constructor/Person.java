package constructor;

public class Person {
	String Name;
	int Age;
	boolean IsMarried;
	String Job;
	
	Person() { }
	
	Person(String name, int age, boolean isMarried, String job) {
		Name = name;
		Age = age;
		IsMarried = isMarried;
		Job = job;
		
		System.out.println(name + " " + age + " " + isMarried + " " + job);
	}
	




}