package sec03.verify.exam03;

public class HttServletExample {

	public static void main(String[] args) {
		LoginServlet lg = new LoginServlet();
		FileDownloadServlet fd = new FileDownloadServlet();		
		lg.service();
		fd.service();
		System.out.println("---------------");
		
		//변수의 자동 타입 변환
		HttServlet hs = null;
		hs = new LoginServlet();
		hs.message();
		hs.service();
		hs = new FileDownloadServlet();
		hs.service();
		System.out.println("-----------------");
				
		//메소드 다형성
		method(new LoginServlet());
		method(new FileDownloadServlet());		
	}
	
	public static void method(HttServlet servlet) {
		servlet.service();
		servlet.message();
	}
}
