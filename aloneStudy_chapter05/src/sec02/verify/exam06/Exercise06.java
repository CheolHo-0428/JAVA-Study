package sec02.verify.exam06;

import java.util.Scanner;

public class Exercise06 {

	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);
			
		while(run) {
			System.out.println("-------------------------------------");
			System.out.println(
					"1.�л��� | 2.�����Է� | 3.��������Ʈ | 4.�м� | 5.����");
			System.out.println("-------------------------------------");
			System.out.println("����> ");
			
			int selecNo = Integer.parseInt(scanner.nextLine());
			
			if(selecNo == 1) {
				System.out.println("�л���> ");
				studentNum = Integer.parseInt(scanner.nextLine());
				scores = new int[studentNum];
			}
						
			else if(selecNo == 2) {
				for (int i=0; i<studentNum; i=i+1) {
					System.out.println("scores[" + i + "]> ");
					int score = Integer.parseInt(scanner.nextLine());
					scores[i] = score;
					}
			}
				
			else if(selecNo == 3) {
				for (int i=0; i<studentNum; i=i+1) {
					System.out.println("scores[" + i + "]> "+ scores[i]);
				}
			}
			
			else if(selecNo == 4) {
				int max = 0;
				int sum = 0;
				for(int i=0; i<scores.length; i=i+1) {
					sum = sum + scores[i];
					if (max<scores[i]) {
						max = scores[i];
					}
				}
				double avg = (double) sum / scores.length ;
				System.out.println("�ְ� ����: " + max);
				System.out.println("��� ����: " + avg);
				}
			
			else if(selecNo == 5) {
				run = false;
			}						
			}
		System.out.println("���α׷� ����");
	}
}
