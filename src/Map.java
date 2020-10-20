import sun.misc.Queue;

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

	private static Settings set;
	private static Point player;
	private static Point[] enemies;
	private static Point[][] map;
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

		set = settings;
		enemies = new Point[set.enemiesCount];
		for(int i = 0; i < set.enemiesCount; i++) {
			enemies[i] = new Point(set.enemy, set.enemyColor, random.nextInt(set.size), random.nextInt(set.size));
			enemies[i].step = 0;
		}
		player = new Point(set.player, set.playerColor, random.nextInt(set.size), random.nextInt(set.size));
		//player = new Point(set.player, set.playerColor, 15, 15);
		map = new Point[set.size][set.size];

		for (int y = 0; y < set.size; y++) {
			for (int x = 0; x < set.size; x++) {
				if (x == player.xPos && y == player.yPos) {
					map[y][x] = player;
					player.step = 0;
				}
				else if ((indexEnemy = findCurEnemy(x, y, enemies)) >= 0) {
					map[y][x] = enemies[indexEnemy];
				}
				else {
					map[y][x] = new Point(set.empty, set.emptyColor, x, y);
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
					putColorChar(map[y][x]);
				}
				putColorBack(map[y][x]);
			}
			System.out.println();
		}
	}

	public static void movePoint(Integer yPosStart, Integer xPosStart, Integer yPosFin, Integer xPosFin, Point cur) {
		Point empty = new Point(set.empty, set.emptyColor, xPosStart, yPosStart);

		if (cur.type == player.type) {
			if (player.yPos < yPosFin) {
				player.yPos++;
			}
			else if (player.yPos > yPosFin) {
				player.yPos--;
			}
			else if (player.xPos < xPosFin) {
				player.xPos++;
			}
			else if (player.xPos > xPosFin) {
				player.xPos--;
			}
			map[yPosFin][xPosFin] = player;
		}
		else {
			if (enemies[0].yPos < yPosFin) {
				enemies[0].yPos++;
			}
			else if (enemies[0].yPos > yPosFin) {
				enemies[0].yPos--;
			}
			else if (enemies[0].xPos < xPosFin) {
				enemies[0].xPos++;
			}
			else if (enemies[0].xPos > xPosFin) {
				enemies[0].xPos--;
			}
			map[yPosFin][xPosFin] = enemies[0];
		}
		map[yPosStart][xPosStart] = empty;
	}

	public static boolean movePlayer(Key key) {
		Point	toMove;

		switch (key) {
			case UP:
				if (player.yPos == 0)
					break;
				movePoint(player.yPos, player.xPos, player.yPos - 1, player.xPos, player);
				break;
			case DOWN:
				if (player.yPos == set.size)
					break;
				movePoint(player.yPos, player.xPos, player.yPos + 1, player.xPos , player);
				break;
			case LEFT:
				if (player.xPos == 0)
					break;
				movePoint(player.yPos, player.xPos, player.yPos, player.xPos - 1, player);
				break;

			case RIGHT:
				if (player.xPos == set.size)
					break;
				movePoint(player.yPos, player.xPos, player.yPos, player.xPos + 1, player);
				break;
			default:break;
		}
		return true;
	}

	public static void printSteps() {

		for (int y = 0; y < set.size; y++) {
			for (int x = 0; x < set.size; x++) {
				if (map[y][x].step == null)
					System.out.print(0);
				else
					System.out.print(map[y][x].step);
			}
			System.out.println();
		}
	}

	public final Point getPlayer() {
		return this.player;
	}

	public void setSteps() {
		Point				next = this.getPlayer();

		while (next != null) {
			Integer				i = next.xPos;
			Integer				j = next.yPos;
			if (i < (this.set.size - 1) && this.map[j][i + 1].type == this.set.empty && this.map[j][i + 1].step == null) {
				this.map[j][i + 1].step = this.map[j][i].step + 1;
				next.addNext(this.map[j][i + 1]);
			}
			if (i > 0 && this.map[j][i - 1].type == this.set.empty && this.map[j][i - 1].step == null) {
				this.map[j][i - 1].step = this.map[j][i].step + 1;
				next.addNext(this.map[j][i - 1]);
			}
			if (j < (this.set.size - 1) && this.map[j + 1][i].type == this.set.empty && this.map[j + 1][i].step == null) {
				this.map[j + 1][i].step = this.map[j][i].step + 1;
				next.addNext(this.map[j + 1][i]);
			}
			if (j > 0 && this.map[j - 1][i].type == this.set.empty && this.map[j - 1][i].step == null) {
				this.map[j - 1][i].step = this.map[j][i].step + 1;
				next.addNext(this.map[j - 1][i]);
			}
			next = next.next;
		}
	}
}