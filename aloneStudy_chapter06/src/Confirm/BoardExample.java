package Confirm;

public class BoardExample {

	public static void main(String[] args) {
		Board b1 = new Board();
		System.out.println(b1.title);
		System.out.println(b1.content);
		System.out.println(b1.writer);
		System.out.println(b1.date);
		System.out.println(b1.hitcount);
		System.out.println();
		
		Board b2 = new Board("力格", "林力");
		System.out.println(b2.title);
		System.out.println(b2.content);
		System.out.println(b2.writer);
		System.out.println(b2.date);
		System.out.println(b2.hitcount);
		System.out.println();
		
		Board b3 = new Board("Title", "subject", "writer");
		System.out.println(b3.title);
		System.out.println(b3.content);
		System.out.println(b3.writer);
		System.out.println(b3.date);
		System.out.println(b3.hitcount);
		System.out.println();
		
		Board b5 = new Board("力格", "林力", "累啊", "朝楼", 100);
		System.out.println(b5.title);
		System.out.println(b5.content);
		System.out.println(b5.writer);
		System.out.println(b5.date);
		System.out.println(b5.hitcount);
		System.out.println();
		
	}

}
