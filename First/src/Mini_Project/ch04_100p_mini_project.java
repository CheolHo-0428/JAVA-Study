package Mini_Project;

import java.util.Scanner;

public class ch04_100p_mini_project {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("����� ������ �Է��ϼ���.");
	    int n = sc.nextInt();
		int score = n;
		char grade;

		if ((score >= 90) && (score <=100)) {
			grade = 'A';
			System.out.println("����� ������ "+grade+"�Դϴ�.");
		}
		
		else if ((score >= 80) && (score <=89)) {
			grade = 'B';
			System.out.println("����� ������ "+grade+"�Դϴ�.");
		}
		
		else if ((score >= 70) && (score <=79)) {
			grade = 'C';
			System.out.println("����� ������ "+grade+"�Դϴ�.");
		}
		
		else if ((score >= 60) && (score <=69)) {
			grade = 'D';
			System.out.println("����� ������ "+grade+"�Դϴ�.");
		}
		
		else {
			grade = 'F';
			System.out.println("����� ������ "+grade+"�Դϴ�.");
		}
	}

}
