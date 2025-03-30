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
		// TO DO
		if(this.yCoord()>o.yCoord()) {
			return 1;
		}
		else if(this.yCoord()<o.yCoord()) {
			return -1;
		}
		if(this.xCoord()>o.xCoord()) {
			return 1;
		}
		else if(this.xCoord()<o.xCoord()) {
			return -1;
		}
		return 0; //STUB
	}
}  
	

