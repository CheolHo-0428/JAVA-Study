package Project;

public class FunctionTest {

	public static void main(String[] args) {
		int num1 = 100;
		int num2 = 200;
	
		int min = minus(num1, num2);
		System.out.println(num2 + " - " + num1 + " = " + min + "�Դϴ�.");
		
		int time = times(num1, num2);
		System.out.println(num2 + " * " + num1 + " = " + time + "�Դϴ�.");
		
		int div = divide(num1, num2);
		System.out.println(num2 + " / " + num1 + " = " + div + "�Դϴ�.");
	}
		
	public static int minus(int n1, int n2) {
		int result = n2 - n1;
		return result;
		}
		
	public static int times(int n1, int n2) {
		int result = n2 * n1;
		return result;			
		}
		
	public static int divide(int n1, int n2) {
		int result = n2 / n1;
		return result;			
		}
}
