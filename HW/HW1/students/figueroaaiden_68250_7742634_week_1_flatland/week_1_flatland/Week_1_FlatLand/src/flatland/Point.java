package flatland;

public class Point {
	private double x;
	private double y;
	
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	} 
	
	public double xCoord() {
		return x;
	}
	
	public double yCoord() {
		return y;
	}
	
	public void move(double newX, double newY) {
		x = newX;
		y = newY;
	}

	@Override
	public String toString() {
		return String.format("(\"%s\", \"%s\")", x, y);
	}
}
