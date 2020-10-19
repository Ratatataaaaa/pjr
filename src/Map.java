import java.util.Random;

public class Map {

	private Settings		set;
	private Point			player;
	private Point []		enemies;
	private Point [] []		map;


	public Map(Settings settings) {
		Integer			x = 0;
		Integer			y = 0;

		this.set = settings;
		map = new Point[this.set.size][this.set.size];
		enemies = new Point [this.set.enemiesCount];
	}
	
	public void placePlayer() {
		final Random 			random = new Random();
		final Integer			x = random.nextInt(this.set.size);
		final Integer			y = random.nextInt(this.set.size);
		this.map[x][y].type = this.set.enemy;
		this.player.xPos = x;
		this.player.xPos = y;
		this.player.type = this.set.enemy;
	}

	public Boolean movePlayer(Key key) {
		return (true);
	}

	public void printMap() {
		Integer			i = 0;
		Integer			j = 0;

		while (i < this.set.size) {
			while (j < this.set.size) {
				System.out.print(this.map[i][j].type);
				++j;
			}
			System.out.println("");
			j = 0;
			++i;
		}
	}
	
}