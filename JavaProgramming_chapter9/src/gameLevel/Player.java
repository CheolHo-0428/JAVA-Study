package gameLevel;

public class Player {
	//�ʵ�
	private PlayerLevel level;
	
	//������
	public Player() {
		level = new BeginnerLevel();
		level.showLevelMessage();
	}
	//�޼ҵ�	
	public PlayerLevel getLevel() {
		return level;
	}
	
	public void upgradeLevel(PlayerLevel level) {
		this.level = level;
		level.showLevelMessage();
	}
	
	public void play(int count) {
		level.go(count);
	}
}
