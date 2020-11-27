package sec01.exam04;

public class RemoteControlExample {

	public static void main(String[] args) {
		RemoteControl rc;
		rc = (RemoteControl) new Television();
		rc = (RemoteControl) new Audio();

	}

}
