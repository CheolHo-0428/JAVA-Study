package Confirm;

public class shopServiceExample {

	public static void main(String[] args) {
		shopService obj1 = shopService.getInstance();
		shopService obj2 = shopService.getInstance();
		
		if(obj1 == obj2) {
			System.out.println("���� ShopService ��ü�Դϴ�.");
		}
		else {
			System.out.println("�ٸ� ShopService ��ü�Դϴ�.");
		}
	}
}
