package staticex;

public class Card {
	public static int serialNum = 978098;
	public int cardNum;
	public String guestName;
	
	public Card () {
		serialNum = serialNum + 1;
		cardNum = serialNum;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
}
