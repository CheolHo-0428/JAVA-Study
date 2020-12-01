package singleton;

public class CardCompanyTest {

	public static void main(String[] args) {
		CardCompany company = CardCompany.getInstance();
		Card cho = company.createCard();
		Card choi = company.createCard();
		System.out.println(cho.getCardNum());
		System.out.println(choi.getCardNum());

	}

}
