package gameLevel;

public abstract class PlayerLevel {
	//�ʵ�
	//������
	//�޼ҵ�
	public abstract void run();
	public abstract void jump();
	public abstract void turn();
	public abstract void showLevelMessage();
	
	final public void go(int count) {
		run();
		for(int i=0; i<count; i=i+1) {
			jump();
		}
		turn();				
	}
}
