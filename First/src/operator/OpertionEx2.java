package operator;

public class OpertionEx2 {

	public static void main(String[] args) {
		int gameScore = 150;        //���ӿ��� ȹ���� ������ 150��
		
		int lastScore1 = ++gameScore; 
//		int lastScore1 = gameScore++;//gameScore�� 1��ŭ ���� ���� last Score1�� ����
		System.out.println(lastScore1); // 151
		
		System.out.println(gameScore);
		
		
		int lastScore2 = --gameScore;  //gameScore�� 1��ŭ ���� ���� last Score1�� ����
//		int lastScore2 = gameScore--;
		System.out.println(lastScore2); // 150
		
		System.out.println(gameScore);
	}

}
