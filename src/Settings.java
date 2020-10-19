import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Settings {

	public static final String ERR_ARGS = "Enter 4 parameters: --enemiesCount=10 --wallsCount=10 --size=30 --profile=production";
	public char			enemy;
	public String		enemyColor;
	public char			wall;
	public String		wallColor;
	public char			player;
	public String		playerColor;
	public char			goal;
	public String		goalColor;
	public char			empty;
	public String		emptyColor;
	public Integer		size;
	public Integer		enemiesCount;
	public Integer		wallsCount;
	private String      propertiesPath;

	public void putErr(String err) {
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

	private String parsingFieldColor(Properties properties, String name) {
		String tempParam;

		tempParam = properties.getProperty(name);
		if (tempParam == null) {
			System.err.print("Check the correctness of filling in the fields in the property file. Field ");
			System.err.print(name);
			putErr(" missing or filled in incorrectly");
		}
		assert tempParam != null;
		return tempParam;
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
		if (player == wall) {
			putErr("The values of player.char and wall.char are the same");
		}
		if (player == goal) {
			putErr("The values of player.char and goal.char are the same");
		}
		if (player == empty) {
			putErr("The values of player.char and empty.char are the same");
		}
		if (wall == goal) {
			putErr("The values of wall.char and goal.char are the same");
		}
		if (wall == empty) {
			putErr("The values of wall.char and empty.char are the same");
		}
		if (goal == empty) {
			putErr("The values of goal.char and empty.char are the same");
		}
		if (enemyColor.equals(playerColor)) {
			putErr("The values of enemy.color and player.color are the same");
		}
		if (enemyColor.equals(wallColor)) {
			putErr("The values of enemy.color and wall.color are the same");
		}
		if (enemyColor.equals(goalColor)) {
			putErr("The values of enemy.color and goal.color are the same");
		}
		if (enemyColor.equals(emptyColor)) {
			putErr("The values of enemy.color and empty.color are the same");
		}
		if (wallColor.equals(goalColor)) {
			putErr("The values of wall.color and goal.color are the same");
		}
		if (wallColor.equals(emptyColor)) {
			putErr("The values of wall.color and empty.color are the same");
		}
		if (goalColor.equals(emptyColor)) {
			putErr("The values of goal.color and empty.color are the same");
		}
	}

	public Settings(String [] args) {
		int i = 0;

		Properties properties;

		while (i != args.length) {
			try {
				if (args[i].charAt(0) == '-' && args[i].charAt(1) == '-') {
					break;
				}
				i++;
			}
			catch (IndexOutOfBoundsException e) {
				putErr("The parameter should be of the form: --nameParam=count");
			}
		}
		while (i < args.length) {
			parsingParam(args[i]);
			++i;
		}
		properties = loadProperties(propertiesPath);
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
	}
}