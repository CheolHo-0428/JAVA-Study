package Mini_Project;

import java.util.Scanner;

public class ch04_p92_mini_project {

// My Code	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("당신은 몇살인가요?");
	    
		int age = sc.nextInt();
		if (age <= 7) {
			System.out.println("당신은 유치원생 입니다.");
		}

		else if ((age >= 8) && (age <= 13)) {
			System.out.println("당신은 초등학생 입니다.");
		}
		
		else if ((age >= 14) && (age <= 16)) {
			System.out.println("당신은 중학생 입니다.");
		}
		
		else if ((age >= 17) && (age <= 19)) {
			System.out.println("당신은 고등학생 입니다.");
		}
		
		else {
			System.out.println("당신은 성인 입니다.");
		}
								
	}

// Another Code
//	 public static void main(String[] args) {
//	      // TODO Auto-generated method stub
//	      Scanner sc = new Scanner(System.in);
//	      System.out.print("당신은 몇살인가요?");
//	      int n;
//	      n = sc.nextInt();
//	      if (n < 8) {
//	         System.out.println(n+"살은 학교에 다니지 않습니다.");
//	         sc.close();
//	      }
//	      else if ((n>7)&&(n<14)) {
//	         System.out.println(n+"살은 초등학교에 다닙니다.");
//	         sc.close();
//	      }
//	      else if ((n>13)&&(n<17)) {
//	         System.out.println(n+"살은 중학교에 다닙니다.");
//	         sc.close();
//	      }
//	      else if ((n>16)&&(n<20)) {
//	         System.out.println(n+"살은 고등학교에 다닙니다.");
//	         sc.close();
//	      }
//	      else {
//	         System.out.println(n+"살은 대학교에 다닙니다.");
//	         sc.close();
//	      }      
//	   }
//

}
