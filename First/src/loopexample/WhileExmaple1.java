package loopexample;

public class WhileExmaple1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 1;
		int sum = 0;
		
		while(num <= 10) { //num ���� 10���� �۰ų� ���� ����
			sum = sum + num;
			num = num + 1;
		}
		System.out.println("1���� 10������ ����" + sum + "�Դϴ�.");
	}
}
