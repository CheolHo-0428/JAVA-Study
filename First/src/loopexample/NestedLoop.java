package loopexample;

public class NestedLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dan;
		int times;
		
		for(dan = 2; dan <= 9; dan=dan+1) {
			for(times = 1; times <= 9; times = times + 1) {
				System.out.println(dan + "X" + times + "=" + dan * times);
			}
			System.out.println( );
		}
	}

}
