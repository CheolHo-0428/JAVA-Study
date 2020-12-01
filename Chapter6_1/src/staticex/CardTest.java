package staticex;

public class CardTest {

	public static void main(String[] args) {
		Card cardLee = new Card();
		cardLee.setGuestName("이지원");
		System.out.println(cardLee.getGuestName() + "님의 카드번호는 " + cardLee.cardNum + "입니다.");
		
		Card cardSon = new Card();
		cardSon.setGuestName("손수경");
		System.out.println(cardSon.getGuestName() + "님의 카드번호는 " + cardSon.cardNum + "입니다.");

	}

}
