package Mini_Project;

import java.util.Scanner;

public class ch04_p112_mini_project {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("�ش� ���� �Է��ϼ���");
	    int num = sc.nextInt();
		String floor = "";
		
		switch(num) {
		case 1 : floor = "�౹";
			break;
			
		case 2 : floor = "�����ܰ�";
			break;
			
		case 3 : floor = "�Ǻΰ�";
			break;
			
		case 4 : floor = "ġ��";
			break;
			
		case 5 : floor = "�ｺŬ��";
			break;
		}
		System.out.println(num + "���� " + floor + "�Դϴ�.");

	}

}
