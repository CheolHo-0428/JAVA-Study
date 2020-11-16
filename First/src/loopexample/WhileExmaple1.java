package loopexample;

public class WhileExmaple1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 1;
		int sum = 0;
		
		while(num <= 10) { //num 값이 10보다 작거나 같을 동안
			sum = sum + num;
			num = num + 1;
		}
		System.out.println("1부터 10까지의 합은" + sum + "입니다.");
	}
}
