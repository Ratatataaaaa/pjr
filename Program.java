package rush00;

enum TypePoint {
	WALL,
	EMPTY,
	GOAL,
	PLAYER,
	ENEMY
}

enum Key {
	UP,
	DOWN,
	LEFT,
	RIGHT
}

public class Program {

	public static void main(String [] args) {
		Settings 		settings = new Settings();
		Map 			zzzz = new Map(settings);
		zzzz.printMap();
	}
	

}