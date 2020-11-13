package Mini_Project;

import java.util.Scanner;

public class ch03_p79_mini_project {

// My Code	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("당신은 몇번인가요?");
	    int n = sc.nextInt();
		int studentNum = n;
		int ref = 10;
		
		int RoomNum = studentNum % ref ;
		System.out.println("당신은"+RoomNum+"번방 입니다.");

		
				
	}

//// Another Code	
////	public static void main(String[] args) {
////	      Scanner scan = new Scanner(System.in);
////
////	      int number;
////	      System.out.println("본인의 번호를 입력하세요.");
////	        number = scan.nextInt();
////
////	        int room_number = number % 10;
////
////	      System.out.println(number + "번은 " + room_number + "번 방 입니다.");
////	        
////	        scan.close();
////	   }
//
//	}

}
