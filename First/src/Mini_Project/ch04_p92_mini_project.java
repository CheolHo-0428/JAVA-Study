package Mini_Project;

import java.util.Scanner;

public class ch04_p92_mini_project {

// My Code	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("����� ����ΰ���?");
	    
		int age = sc.nextInt();
		if (age <= 7) {
			System.out.println("����� ��ġ���� �Դϴ�.");
		}

		else if ((age >= 8) && (age <= 13)) {
			System.out.println("����� �ʵ��л� �Դϴ�.");
		}
		
		else if ((age >= 14) && (age <= 16)) {
			System.out.println("����� ���л� �Դϴ�.");
		}
		
		else if ((age >= 17) && (age <= 19)) {
			System.out.println("����� ����л� �Դϴ�.");
		}
		
		else {
			System.out.println("����� ���� �Դϴ�.");
		}
								
	}

// Another Code
//	 public static void main(String[] args) {
//	      // TODO Auto-generated method stub
//	      Scanner sc = new Scanner(System.in);
//	      System.out.print("����� ����ΰ���?");
//	      int n;
//	      n = sc.nextInt();
//	      if (n < 8) {
//	         System.out.println(n+"���� �б��� �ٴ��� �ʽ��ϴ�.");
//	         sc.close();
//	      }
//	      else if ((n>7)&&(n<14)) {
//	         System.out.println(n+"���� �ʵ��б��� �ٴմϴ�.");
//	         sc.close();
//	      }
//	      else if ((n>13)&&(n<17)) {
//	         System.out.println(n+"���� ���б��� �ٴմϴ�.");
//	         sc.close();
//	      }
//	      else if ((n>16)&&(n<20)) {
//	         System.out.println(n+"���� ����б��� �ٴմϴ�.");
//	         sc.close();
//	      }
//	      else {
//	         System.out.println(n+"���� ���б��� �ٴմϴ�.");
//	         sc.close();
//	      }      
//	   }
//

}
