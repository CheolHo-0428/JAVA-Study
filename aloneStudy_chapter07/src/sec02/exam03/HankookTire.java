package sec02.exam03;

public class HankookTire extends Tire {
	//필드
	
	//생성자
	HankookTire(String location, int maxRotation){
		super(location, maxRotation);
	}

	//메소드
	@Override
	public boolean roll() {
		accumulatedRotation = accumulatedRotation + 1;
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + " 잔여 HankookTire 수명: " +
		(maxRotation-accumulatedRotation) + "회");
			return true;
		}
		else {
			System.out.println("*** " + location + " HankookTire 펑크 ***");
			return false;			
		}
	}
}
