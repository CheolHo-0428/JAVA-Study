package sec03.verify.exam03;

public class FileDownloadServlet extends HttServlet {

	@Override
	public void service() {
		System.out.println("파일 다운로드 합니다.");		
	}

	@Override
	public void message() {
		System.out.println("다음에도 이욯해주세요.");
	}
	
}
