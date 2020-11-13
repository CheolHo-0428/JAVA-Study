package operator;

public class OpertionEx2 {

	public static void main(String[] args) {
		int gameScore = 150;        //게임에서 획득한 점수는 150점
		
		int lastScore1 = ++gameScore; 
//		int lastScore1 = gameScore++;//gameScore에 1만큼 더한 값을 last Score1에 대입
		System.out.println(lastScore1); // 151
		
		System.out.println(gameScore);
		
		
		int lastScore2 = --gameScore;  //gameScore에 1만큼 더한 값을 last Score1에 대입
//		int lastScore2 = gameScore--;
		System.out.println(lastScore2); // 150
		
		System.out.println(gameScore);
	}

}
