public class Point {

	public char 		type;
	public Integer 		xPos;
	public Integer 		yPos;
	public String 		color;
	public Integer 		step;
	public Point		next;

	public Point(char type, String color, Integer x, Integer y) {
		this.type = type;
		this.color = color;
		this.xPos = x;
		this.yPos = y;
		this.next = null;
	}

	public void prinInf() {
		System.out.println(this.type);
		System.out.println(this.color);
		System.out.println(this.xPos);
		System.out.println(this.yPos);
		System.out.println(this.step);
		System.out.println("");
	}

	public void addNext(Point next) {
		Point find = this;
		while (find.next != null)
			find = find.next;
		find.next = next;
	}
}
