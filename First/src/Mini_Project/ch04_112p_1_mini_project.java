//1) �ǹ��� �� ������ �Է¹ޱ�
//2) �� ������ �Է� ������ ���ؼ� �迭�� ������ �����ϱ�
//3) ���� ������ ���ؼ� Scanner�� �Է� �޾� �迭�� �ʱⰪ ���� => ����ڰ� �౹ �����ܰ� => {"�౹", "�����ܰ�"}


package Mini_Project;

import java.util.Scanner;

public class ch04_112p_1_mini_project {

	

	public static void main(String[] args) {
// my code
//		Scanner sc = new Scanner(System.in);
//		System.out.print("���� ��ü���� �Է��ϼ���");
//		String floor = sc.next();	
//		String[] floor_list = floor.split("\\s");
//				
//		Scanner sc_1 = new Scanner(System.in);
//		System.out.print("�ش� ���� �Է��ϼ���");
//	    int num = sc_1.nextInt();
//					
//		switch(num) {
//		case 1 : System.out.println("�ش� ���� " + floor_list[0] +"�Դϴ�.");
//			break;
//			
//		case 2 : System.out.println("�ش� ���� " + floor_list[1] +"�Դϴ�.");
//			break;
//			
//		case 3 : System.out.println("�ش� ���� " + floor_list[2] +"�Դϴ�.");
//			break;
//			
//		case 4 : System.out.println("�ش� ���� " + floor_list[3] +"�Դϴ�.");
//			break;
//			
//		case 5 : System.out.println("�ش� ���� " + floor_list[4] +"�Դϴ�.");
//			break;
//		}		

		
// another code
		 System.out.println("������ ���� �� �� �ΰ���?"); // �迭���� ���� �Է� �ȳ� �޽���
	      
	      Scanner scan1 = new Scanner(System.in);     // ����ڿ��� �迭���� ���� �Է� ����
	      int floor_count;                            // ����ڿ��� ���� ���� �����ϴ� ����
	      floor_count = scan1.nextInt();              // ����ڿ��� ���� ���� ������ ����
	            
	      String[] name = new String[floor_count];    // name�� �迭���� ������ ����
	      
	      System.out.println("�� ���� ���� ������ �Է��ϼ���. ex) �౹ ����(�� �� ���) �����ܰ�"); // 1�� : �౹, 2�� �����ܰ�
	      Scanner scan2 = new Scanner(System.in);
	      
	      System.out.println(floor_count); // �Էµ� ���� �� ���Դ��� Ȯ���ϴ� ��ɾ�
	      
	      for (int i = 0; i < floor_count; i++) {
	         name[i] = scan2.nextLine();
	      }
	      
	      for (int i = 0; i < floor_count; i++) {
	         System.out.println("���� ���� ���� ������ " + (i+1) + "�� : " + name[i]);
	      }
	      scan1.close();
	      scan2.close();
	      
	}
}