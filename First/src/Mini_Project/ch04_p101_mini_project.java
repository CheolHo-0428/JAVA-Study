package Mini_Project;

import java.util.Scanner;

public class ch04_p101_mini_project {

// My Code	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�ֹι�ȣ�� �Է����ּ��� ( -�� �����ؼ� �Է�)");
	    
		String Jumin = sc.next();
//		String Birth = (Jumin.substring(0,2));
		
		char se = Jumin.charAt(7);
		int se_1 = se;
		
		if((se_1=='1') || (se_1=='3')) {
			System.out.println("�ֹι�ȣ : "+ Jumin);
			System.out.println("���� : ����");
		}
		
		else {
			System.out.println("�ֹι�ȣ : "+ Jumin);
			System.out.println("���� �Դϴ�.");
			}												
	}

// Another Code
//	public static void main(String[] args) {
//	      // TODO Auto-generated method stub
//	     String jumin = "",gender = "";
//	     Scanner scan = new Scanner(System.in);
//	      System.out.print("����� �ֹε�Ϲ�ȣ��?(-�� �����ؼ� �Է�)");
//	      jumin = scan.next();
//	      
//	      char ch = jumin.charAt(7);
//	      if((int)ch%2==1) {gender = "����";}
//	      else {gender = "����";}
//	      System.out.println("����:"+gender);
//	   }
//





}
