package Mini_Project;

import java.util.Scanner;

public class ch04_p109_mini_project {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("해당 월을 입력하세요");
	    int n = sc.nextInt();
		int month = n;
		String season = null;
		
		switch(month) {
			case 3 :
			case 4 :
			case 5 :
					season = "봄";
					break;
			
			case 6 :
			case 7 :
			case 8 :
					season = "여름";
					break;
					
			case 9 :
			case 10 :
			case 11 :
					season = "가을";
					break;
					
			case 12 :
			case 1 :
			case 2 :
					season = "겨울";

		}
		System.out.println(month + "월은 " + season + "입니다.");
	}
	
}
