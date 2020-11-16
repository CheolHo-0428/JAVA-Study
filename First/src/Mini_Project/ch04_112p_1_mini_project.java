//1) 건물이 몇 층인지 입력받기
//2) 몇 층인지 입력 받은걸 통해서 배열방 갯수로 지정하기
//3) 층별 업종에 대해서 Scanner로 입력 받아 배열방 초기값 설정 => 사용자가 약국 정형외과 => {"약국", "정형외과"}


package Mini_Project;

import java.util.Scanner;

public class ch04_112p_1_mini_project {

	

	public static void main(String[] args) {
// my code
//		Scanner sc = new Scanner(System.in);
//		System.out.print("입주 업체들을 입력하세요");
//		String floor = sc.next();	
//		String[] floor_list = floor.split("\\s");
//				
//		Scanner sc_1 = new Scanner(System.in);
//		System.out.print("해당 층을 입력하세요");
//	    int num = sc_1.nextInt();
//					
//		switch(num) {
//		case 1 : System.out.println("해당 층은 " + floor_list[0] +"입니다.");
//			break;
//			
//		case 2 : System.out.println("해당 층은 " + floor_list[1] +"입니다.");
//			break;
//			
//		case 3 : System.out.println("해당 층은 " + floor_list[2] +"입니다.");
//			break;
//			
//		case 4 : System.out.println("해당 층은 " + floor_list[3] +"입니다.");
//			break;
//			
//		case 5 : System.out.println("해당 층은 " + floor_list[4] +"입니다.");
//			break;
//		}		

		
// another code
		 System.out.println("빌딩의 층이 몇 개 인가요?"); // 배열방의 갯수 입력 안내 메시지
	      
	      Scanner scan1 = new Scanner(System.in);     // 사용자에게 배열방의 갯수 입력 받음
	      int floor_count;                            // 사용자에게 받은 값을 저장하는 변수
	      floor_count = scan1.nextInt();              // 사용자에게 받은 값을 실제로 저장
	            
	      String[] name = new String[floor_count];    // name의 배열방의 갯수를 조정
	      
	      System.out.println("각 층별 입점 정보를 입력하세요. ex) 약국 엔터(한 줄 띄기) 정형외과"); // 1층 : 약국, 2층 정형외과
	      Scanner scan2 = new Scanner(System.in);
	      
	      System.out.println(floor_count); // 입력된 값이 잘 들어왔는지 확인하는 명령어
	      
	      for (int i = 0; i < floor_count; i++) {
	         name[i] = scan2.nextLine();
	      }
	      
	      for (int i = 0; i < floor_count; i++) {
	         System.out.println("빌딩 층별 입점 정보는 " + (i+1) + "층 : " + name[i]);
	      }
	      scan1.close();
	      scan2.close();
	      
	}
}