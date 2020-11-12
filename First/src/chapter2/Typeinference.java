package chapter2;

public class Typeinference {

	public static void main(String[] args) {
		var i = 10;
		var j = 10.0;
		var str = "hello";
		
		System.out.println(i);
		System.out.println(j);
		System.out.println(str);
		
		str = "test";
		//str = 3 ;  ----> str은 이미지 string으로 선언되었기 때문에 정수가 올수없다.
		System.out.println(str);
	}

}
