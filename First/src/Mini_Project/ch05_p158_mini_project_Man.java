package Mini_Project;

public class ch05_p158_mini_project_Man {
	int Age;			
	String Name;		
	int son;			
	boolean Married;
	
	public static void main(String[] args) {
		ch05_p158_mini_project_Man Man = new ch05_p158_mini_project_Man( );
		Man.Age = 40;
		Man.Name = "James";
		Man.son = 3;
		Man.Married = true;
		
		System.out.println(Man.Age);
		System.out.println(Man.Name);
		System.out.println(Man.son);
		System.out.println(Man.Married);
	}
}
