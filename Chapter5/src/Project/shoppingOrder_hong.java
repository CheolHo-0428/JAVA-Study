package Project;

public class shoppingOrder_hong {

	public static void main(String[] args) {
		shoppingOrder so = new shoppingOrder();
		so.OrderNumber = "201803120001";
		so.ID = "abc123";
		so.Date = "2018년 3월 12일";
		so.Name = "홍길순";
		so.productNumber = "PD0345-12";
		so.address = "서울시 영등포구 여의도동 20번지";
		
		System.out.println("주문 번호: " + so.OrderNumber);
		System.out.println("주문자 아이디: " + so.ID);
		System.out.println("주문 날짜: " + so.Date);
		System.out.println("주문자 이름: " + so.Name);
		System.out.println("주문 상품 번호: " + so.productNumber);
		System.out.println("배송 주소: " + so.address);
	}

}
