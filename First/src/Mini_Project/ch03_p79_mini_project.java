package Mini_Project;

import java.util.Scanner;

public class ch03_p79_mini_project {

// My Code	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("����� ����ΰ���?");
	    int n = sc.nextInt();
		int studentNum = n;
		int ref = 10;
		
		int RoomNum = studentNum % ref ;
		System.out.println("�����"+RoomNum+"���� �Դϴ�.");

		
				
	}

//// Another Code	
////	public static void main(String[] args) {
////	      Scanner scan = new Scanner(System.in);
////
////	      int number;
////	      System.out.println("������ ��ȣ�� �Է��ϼ���.");
////	        number = scan.nextInt();
////
////	        int room_number = number % 10;
////
////	      System.out.println(number + "���� " + room_number + "�� �� �Դϴ�.");
////	        
////	        scan.close();
////	   }
//
//	}

}
