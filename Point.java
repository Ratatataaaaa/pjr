package rush00;

public class Point {
	public char					type;
	public Integer				xPos;
	public Integer				yPos;
	public char					color;

	public Point(char type, char color) {
		this.type = type;
		this.color = color;
	}

	public Point() {
		this.color = 'W';
		this.type = ' ';
		this.xPos = 0;
		this.yPos = 0;
	}

	public void gps() {
	}
}

