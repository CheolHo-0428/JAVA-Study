package sec03.verify.exam03;

public class HttServletExample {

	public static void main(String[] args) {
		LoginServlet lg = new LoginServlet();
		FileDownloadServlet fd = new FileDownloadServlet();		
		lg.service();
		fd.service();
		System.out.println("---------------");
		
		//������ �ڵ� Ÿ�� ��ȯ
		HttServlet hs = null;
		hs = new LoginServlet();
		hs.message();
		hs.service();
		hs = new FileDownloadServlet();
		hs.service();
		System.out.println("-----------------");
				
		//�޼ҵ� ������
		method(new LoginServlet());
		method(new FileDownloadServlet());		
	}
	
	public static void method(HttServlet servlet) {
		servlet.service();
		servlet.message();
	}
}
