package loopexample;

public class ContinueExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total = 0;
		int num;
		
		for(num=1; num <= 100; num=num+1) {
			if(num % 2 == 0)
				continue;
			total = total + num;
		}
		System.out.println("1���� 100������ Ȧ���� ����: " + total + "�Դϴ�.");
	}

}