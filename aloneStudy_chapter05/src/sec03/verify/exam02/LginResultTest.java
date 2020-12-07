package sec03.verify.exam02;

import java.util.Scanner;

public class LginResultTest {

	public static void main(String[] args) {
		boolean run = true;
		String ID = "againnr";
		int PASSWORD = 12345;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("ID를 입력하세요 :");
			String id = scanner.nextLine();
			
			System.out.println("PASSWORD를 입력하세요 :");
			int password = Integer.parseInt(scanner.nextLine());
			
			LoginResult result = LoginResult.FAIL_PASSWORD;
			if(ID.equals(id) && PASSWORD == password) {
				result = LoginResult.SUCCESS;
				System.out.println(result);
				run = false;
				System.out.println("로그인 성공");
			}
			else if(ID.equals(id) == false) {
				result = LoginResult.FAIL_ID;
				System.out.println(result);
			}
			else if(PASSWORD != password) {
				result = LoginResult.FAIL_PASSWORD;
				System.out.println(result);
			}			
		}		
	}
}