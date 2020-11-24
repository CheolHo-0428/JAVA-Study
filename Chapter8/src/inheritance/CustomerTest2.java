package inheritance;

public class CustomerTest2 {

	public static void main(String[] args) {
		VIPCustomer customerKim = new VIPCustomer(10000, "±Ë¿ØΩ≈", 10000);
//		VIPCustomer customerKim = new VIPCustomer();
		customerKim.setCustomerID(10020);
		customerKim.setCustomerName("±Ë¿ØΩ≈");
		customerKim.bonusPoint = 10000;
		System.out.println(customerKim.showCustomerInfo());

	}

}
