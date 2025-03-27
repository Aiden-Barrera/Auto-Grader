package comparables;

public class Point implements Comparable<Point>{
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	} 
	public double xCoord() {
		return x;
	}
	
	public double yCoord() {
		return y;
	}
	
	public void move(int newX, int newY) {
		x = newX;
		y = newY;
	}
	
	@Override
	public String toString() {
		return String.format("(%s,%s)", x,y);
	}
	
	@Override
	public int compareTo(Point o) {
     // First compare by y coordinate
	 if (this.y > o.y) {
		return 1;
	} else if (this.y < o.y) {
		return -1;
	}

	// If y coordinates are the same, compare by x coordinate
	if (this.x > o.x) {
		return 1;
	} else if (this.x < o.x) {
		return -1;
	}

	return 0;
}  
	
}

