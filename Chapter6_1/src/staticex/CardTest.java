package staticex;

public class CardTest {

	public static void main(String[] args) {
		Card cardLee = new Card();
		cardLee.setGuestName("������");
		System.out.println(cardLee.getGuestName() + "���� ī���ȣ�� " + cardLee.cardNum + "�Դϴ�.");
		
		Card cardSon = new Card();
		cardSon.setGuestName("�ռ���");
		System.out.println(cardSon.getGuestName() + "���� ī���ȣ�� " + cardSon.cardNum + "�Դϴ�.");

	}

}
