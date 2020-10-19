import java.util.Scanner;

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

	public static int W = 87;
	public static int A = 65;
	public static int S = 83;
	public static int D = 68;

	public static boolean parsKey(String key, Settings set) {
		if ((key.equals("a") || key.equals("w") || key.equals("s") || key.equals("d")) && !set.enemyWalk) {
			if (key.equals("a")) {
				return Map.movePlayer(Key.LEFT);
			} else if (key.equals("w")) {
				return Map.movePlayer(Key.UP);
			} else if (key.equals("s")) {
				return Map.movePlayer(Key.DOWN);
			} else {
				return Map.movePlayer(Key.RIGHT);
			}
		} else if (key.equals("8") && set.mode.equals("DEVELOPER")) {
			return false;
		} else if (key.equals("9")) {
			System.out.println("GAME OVER");
			System.exit(0);
		}
		return false;
	}

	public static void main(String[] args) {
		Settings settings = new Settings(args);
		Map map = new Map(settings);
		Scanner scanner = new Scanner(System.in);
		String arg;

		while (1 == 1) {
			arg = scanner.next();
			if (parsKey(arg, settings)) {
				map.printMap();
			} else if (settings.mode.equals("USER")) {
				System.out.println("Enter a numeric value: W - 87 | A - 65 | S - 83 | D - 68");
			}
		}
//		Map.printSteps();
	}
}