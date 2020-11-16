package Mini_Project;

import java.util.Scanner;

public class ch04_p112_mini_project {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("해당 층을 입력하세요");
	    int num = sc.nextInt();
		String floor = "";
		
		switch(num) {
		case 1 : floor = "약국";
			break;
			
		case 2 : floor = "정형외과";
			break;
			
		case 3 : floor = "피부과";
			break;
			
		case 4 : floor = "치과";
			break;
			
		case 5 : floor = "헬스클럽";
			break;
		}
		System.out.println(num + "층은 " + floor + "입니다.");

	}

}
