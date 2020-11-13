package Mini_Project;

import java.util.Scanner;

public class ch04_p101_mini_project {

// My Code	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("주민번호를 입력해주세요 ( -를 포함해서 입력)");
	    
		String Jumin = sc.next();
//		String Birth = (Jumin.substring(0,2));
		
		char se = Jumin.charAt(7);
		int se_1 = se;
		
		if((se_1=='1') || (se_1=='3')) {
			System.out.println("주민번호 : "+ Jumin);
			System.out.println("성별 : 남성");
		}
		
		else {
			System.out.println("주민번호 : "+ Jumin);
			System.out.println("여성 입니다.");
			}												
	}

// Another Code
//	public static void main(String[] args) {
//	      // TODO Auto-generated method stub
//	     String jumin = "",gender = "";
//	     Scanner scan = new Scanner(System.in);
//	      System.out.print("당신은 주민등록번호는?(-를 포함해서 입력)");
//	      jumin = scan.next();
//	      
//	      char ch = jumin.charAt(7);
//	      if((int)ch%2==1) {gender = "남성";}
//	      else {gender = "여성";}
//	      System.out.println("성별:"+gender);
//	   }
//





}
