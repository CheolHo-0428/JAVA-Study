package Mini_Project;

import java.util.Scanner;

public class ch04_p109_mini_project {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("�ش� ���� �Է��ϼ���");
	    int n = sc.nextInt();
		int month = n;
		String season = null;
		
		switch(month) {
			case 3 :
			case 4 :
			case 5 :
					season = "��";
					break;
			
			case 6 :
			case 7 :
			case 8 :
					season = "����";
					break;
					
			case 9 :
			case 10 :
			case 11 :
					season = "����";
					break;
					
			case 12 :
			case 1 :
			case 2 :
					season = "�ܿ�";

		}
		System.out.println(month + "���� " + season + "�Դϴ�.");
	}
	
}
