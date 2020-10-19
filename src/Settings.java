import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Settings {

	public static final String ERR_ARGS = "Enter 4 parameters: --enemiesCount=10 --wallsCount=10 --size=30 --profile=production";
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
	private String      propertiesPath;

	public static void putErr(String err) {
		System.err.println(err);
		System.exit(-1);
	}

	private Properties loadProperties(String filePath) {
		File file = new File(filePath);
		Properties properties = new Properties();

		try {
			properties.load(new FileReader(file));
		}
		catch (IOException e) {
			putErr("File properties not found");
		}
		return properties;
	}

	private Integer tryCatchInteger(String line) {
		Integer count = null;

		try {
			count = Integer.parseInt(line);
			if (count < 0) {
				putErr("The number cannot be negative: " + line);
			}
		}
		catch (NumberFormatException e) {
			putErr("The input parameter must be an integer" + line);
		}
		return count;
	}

	private void parsingParam(String line) {
		String [] splitParam;

		splitParam = line.split("=");
		if (splitParam.length == 2) {
			switch (splitParam[0]) {
				case "--enemiesCount":
					this.enemiesCount = tryCatchInteger(splitParam[1]);
					break;
				case "--wallsCount":
					this.wallsCount = tryCatchInteger(splitParam[1]);
					break;
				case "--size":
					this.size = tryCatchInteger(splitParam[1]);
					break;
				case "--profile":
					this.propertiesPath = splitParam[1];
					break;
				default:
					putErr("The parameter should be of the form: --nameParam=count");
					break;
			}
		}
		else {
			putErr("The parameter should be of the form: --nameParam=count");
		}
	}

	private char parsingFieldChar(Properties properties, String name) {
		String tempParam;

		tempParam = properties.getProperty(name);
		if (tempParam == null || tempParam.length() != 1) {
			System.err.print("Check the correctness of filling in the fields in the property file. Field ");
			System.err.print(name);
			putErr(" missing or filled in incorrectly");
		}
		assert tempParam != null;
		return tempParam.charAt(0);
	}

	private char parsingFieldColor(Properties properties, String name) {
		String tempParam;

		tempParam = properties.getProperty(name);
		if (tempParam == null) {
			System.err.print("Check the correctness of filling in the fields in the property file. Field ");
			System.err.print(name);
			putErr(" missing or filled in incorrectly");
		}
		assert tempParam != null;
		return tempParam.charAt(0);
	}

	private void veryLongCheckEquals() {
		if (enemy == player) {
			putErr("The values of enemy.char and player.char are the same");
		}
		if (enemy == wall) {
			putErr("The values of enemy.char and wall.char are the same");
		}
		if (enemy == goal) {
			putErr("The values of enemy.char and goal.char are the same");
		}
		if (enemy == empty) {
			putErr("The values of enemy.char and empty.char are the same");
		}
		if (enemy == enemyColor) {
			putErr("The values of enemy.char and enemy.color are the same");
		}
		if (enemy == playerColor) {
			putErr("The values of enemy.char and player.color are the same");
		}
		if (enemy == wallColor) {
			putErr("The values of enemy.char and wall.color are the same");
		}
		if (enemy == goalColor) {
			putErr("The values of enemy.char and goal.color are the same");
		}
		if (enemy == emptyColor) {
			putErr("The values of enemy.char and empty.color are the same");
		}
		if (player == wall) {
			putErr("The values of player.char and wall.char are the same");
		}
		if (player == goal) {
			putErr("The values of player.char and goal.char are the same");
		}
		if (player == empty) {
			putErr("The values of player.char and empty.char are the same");
		}
		if (player == enemyColor) {
			putErr("The values of player.char and enemy.color are the same");
		}
		if (player == playerColor) {
			putErr("The values of player.char and player.color are the same");
		}
		if (player == wallColor) {
			putErr("The values of player.char and wall.color are the same");
		}
		if (player == goalColor) {
			putErr("The values of player.char and goal.color are the same");
		}
		if (player == emptyColor) {
			putErr("The values of player.char and empty.color are the same");
		}
		if (wall == goal) {
			putErr("The values of wall.char and goal.char are the same");
		}
		if (wall == empty) {
			putErr("The values of wall.char and empty.char are the same");
		}
		if (wall == enemyColor) {
			putErr("The values of wall.char and enemy.color are the same");
		}
		if (wall == playerColor) {
			putErr("The values of wall.char and player.color are the same");
		}
		if (wall == wallColor) {
			putErr("The values of wall.char and wall.color are the same");
		}
		if (wall == goalColor) {
			putErr("The values of wall.char and goal.color are the same");
		}
		if (wall == emptyColor) {
			putErr("The values of wall.char and empty.color are the same");
		}
		if (goal == empty) {
			putErr("The values of goal.char and empty.char are the same");
		}
		if (goal == enemyColor) {
			putErr("The values of goal.char and enemy.color are the same");
		}
		if (goal == playerColor) {
			putErr("The values of goal.char and player.color are the same");
		}
		if (goal == wallColor) {
			putErr("The values of goal.char and wall.color are the same");
		}
		if (goal == goalColor) {
			putErr("The values of goal.char and goal.color are the same");
		}
		if (goal == emptyColor) {
			putErr("The values of goal.char and empty.color are the same");
		}
		if (empty == enemyColor) {
			putErr("The values of empty.char and enemy.color are the same");
		}
		if (empty == playerColor) {
			putErr("The values of empty.char and player.color are the same");
		}
		if (empty == wallColor) {
			putErr("The values of empty.char and wall.color are the same");
		}
		if (empty == goalColor) {
			putErr("The values of empty.char and goal.color are the same");
		}
		if (empty == emptyColor) {
			putErr("The values of empty.char and empty.color are the same");
		}
		if (enemyColor == playerColor) {
			putErr("The values of enemy.color and player.color are the same");
		}
		if (enemyColor == wallColor) {
			putErr("The values of enemy.color and wall.color are the same");
		}
		if (enemyColor == goalColor) {
			putErr("The values of enemy.color and goal.color are the same");
		}
		if (enemyColor == emptyColor) {
			putErr("The values of enemy.color and empty.color are the same");
		}
		if (wallColor == goalColor) {
			putErr("The values of wall.color and goal.color are the same");
		}
		if (wallColor == emptyColor) {
			putErr("The values of wall.color and empty.color are the same");
		}
		if (goalColor == emptyColor) {
			putErr("The values of goal.color and empty.color are the same");
		}
	}

	public Settings(String [] args) {
		int i = 0;

		Properties properties;

		if (args.length > 4) {
			putErr(ERR_ARGS);
		}
		while (i < args.length) {
			parsingParam(args[i]);
			++i;
		}
		properties = loadProperties("src/ " + propertiesPath + ".properties");
		enemy = parsingFieldChar(properties,"enemy.char");
		player = parsingFieldChar(properties, "player.char");
		wall = parsingFieldChar(properties, "wall.char");
		goal = parsingFieldChar(properties, "goal.char");
		empty = parsingFieldChar(properties, "empty.char");
		enemyColor = parsingFieldColor(properties, "enemy.color");
		playerColor = parsingFieldColor(properties, "player.color");
		wallColor = parsingFieldColor(properties, "wall.color");
		goalColor = parsingFieldColor(properties, "goal.color");
		emptyColor = parsingFieldColor(properties, "empty.color");
		if (size == null || enemiesCount == null || wallsCount == null) {
			putErr("One of the values responsible for the parameters of the map is not filled");
		}
		veryLongCheckEquals();
		//Тестовый вывод. На финалке - удалить
		System.out.println(enemy);
		System.out.println(player);
		System.out.println(wall);
		System.out.println(goal);
		System.out.println(empty);
		System.out.println(enemyColor);
		System.out.println(playerColor);
		System.out.println(wallColor);
		System.out.println(goalColor);
		System.out.println(emptyColor);
		System.out.println(size);
		System.out.println(enemiesCount);
		System.out.println(wallsCount);
	}
}