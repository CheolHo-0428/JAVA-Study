package inheritance;

public class OverridingTest2 {

	public static void main(String[] args) {
		Customer vc = new VIPCustomer(10030, "³ª¸ô¶ó", 2000);
		vc.bonusPoint = 1000;
		
		System.out.println(vc.calPrice(10000));
	}

}
