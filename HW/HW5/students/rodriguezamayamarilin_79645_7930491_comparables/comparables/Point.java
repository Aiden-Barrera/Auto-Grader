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
	public int compareTo(Point p2) {
		if (y > p2.y) {
			return 1;
		}else if (y < p2.y) {
			return -1;
		}
		if(y == p2.y && x > p2.x) {
			return 1;
		}else if (y == p2.y && x < p2.x) {
			return -1;
		}
		return 0;
	}
}  
	

