package rush00;

public class Settings {
	public char			enemy;
	public char			enemyColor;
	public char			wall;
	public char			wallColor;
	public char			player;
	public char			playerColor;
	public char			goal;
	public char			goalColor;
	public char			empty;
	public char			emptyColor;
	public Integer		size;
	public Integer		enemiesCount;
	public Integer		wallsCount;

	public Settings() {
		this.empty = 'X';
		this.emptyColor = 'R';
		this.wall = 'O';
		this.wallColor = 'Y';
		this.player = 'P';
		this.playerColor = 'B';
		this.goal = 'G';
		this.goalColor = 'G';
		this.empty = ' ';
		this.emptyColor = 'W';
		this.size = 10;
		this.enemiesCount = 3;
		this.wallsCount = 5;
	}
}