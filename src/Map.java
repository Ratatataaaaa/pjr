import java.util.Random;

public class Map {
	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	private Settings set;
	private Point player;
	private Point[] enemies;
	private Point[][] map;
	final Random random = new Random();

	public static int findCurEnemy(int x, int y, Point [] enemies) {
		int index = 0;

		while (index != enemies.length) {
			if (enemies[index].xPos == x && enemies[index].yPos == y) {
				break;
			}
			index++;
		}
		if (index >= enemies.length) {
			return -1;
		}
		return index;
	}

	public Map(Settings settings) {

		int indexEnemy;

		this.set = settings;
		enemies = new Point[this.set.enemiesCount];
		for(int i = 0; i < set.enemiesCount; i++) {
			enemies[i] = new Point(set.enemy, set.enemyColor, random.nextInt(this.set.size), random.nextInt(this.set.size));
		}
		player = new Point(set.player, set.playerColor, random.nextInt(this.set.size), random.nextInt(this.set.size));
		map = new Point[this.set.size][this.set.size];

		for (int y = 0; y < set.size; y++) {
			for (int x = 0; x < set.size; x++) {
				if (x == player.xPos && y == player.yPos) {
					this.map[y][x] = player;
				}
				else if ((indexEnemy = findCurEnemy(x, y, enemies)) >= 0) {
					this.map[y][x] = enemies[indexEnemy];
				}
				else {
					this.map[y][x] = new Point(set.empty, set.emptyColor, x, y);
				}
			}
		}
	}

	public void putColorChar(Point point) {
		if (point.type == set.empty) {
			switch (point.color) {
				case "RED":
					System.out.print(ANSI_RED);
					break;
				case "GREEN":
					System.out.print(ANSI_GREEN);
					break;
				case "YELLOW":
					System.out.print(ANSI_YELLOW);
					break;
				case "BLUE":
					System.out.print(ANSI_BLUE);
					break;
				case "PURPLE":
					System.out.print(ANSI_PURPLE);
					break;
				case "CIAN":
					System.out.print(ANSI_CYAN);
					break;
				case "WHITE":
					System.out.print(ANSI_WHITE);
					break;
				case "BLACK":
					System.out.print(ANSI_BLACK);
					break;
				default:
			}
		}
	}

	public void putColorBack(Point point) {
		switch (point.color) {
			case "RED":
				System.out.print(ANSI_RED_BACKGROUND);
				break;
			case "GREEN":
				System.out.print(ANSI_GREEN_BACKGROUND);
				break;
			case "YELLOW":
				System.out.print(ANSI_YELLOW_BACKGROUND);
				break;
			case "BLUE":
				System.out.print(ANSI_BLUE_BACKGROUND);
				break;
			case "PURPLE":
				System.out.print(ANSI_PURPLE_BACKGROUND);
				break;
			case "CIAN":
				System.out.print(ANSI_CYAN_BACKGROUND);
				break;
			case "WHITE":
				System.out.print(ANSI_WHITE_BACKGROUND);
				break;
			case "BLACK":
				System.out.print(ANSI_BLACK_BACKGROUND);
				break;
			default:
				set.putErr("Object color not recognized, please enter one of the available colors\nRED | GREEN | YELLOW | BLUE | PURPLE | CIAN | WHITE | BLACK");
		}
		putColorChar(point);
		System.out.print(point.type);
		System.out.print(ANSI_RESET);
	}

	public void printMap() {

		for (int y = 0; y < set.size; y++) {
			for (int x = 0; x < set.size; x++) {
				if (map[y][x].type == set.empty) {
					putColorChar(this.map[y][x]);
				}
				putColorBack(this.map[y][x]);
			}
			System.out.println();
		}
	}
}