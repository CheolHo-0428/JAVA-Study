package singleton;

public class Card {
	public static int serialNum = 978098;
	public int cardNum;
//	public String guestName;
	
	public Card () {
		serialNum = serialNum + 1;
		cardNum = serialNum;
	}

	public int getCardNum() {
		return cardNum;
	}

	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}

}
