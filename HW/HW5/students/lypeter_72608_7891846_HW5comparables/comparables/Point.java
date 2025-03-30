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
		//is greater if has greater y value, if same y-value, is greater is has greater x value
		if(yCoord()>o.yCoord()) {
			return 1;
		}else if(yCoord()<o.yCoord()) {
			return -1;
		}else { //if equal
			if(xCoord()>o.xCoord()) {
				return 1;
			}else if(xCoord()<o.xCoord()){
				return -1;
			}else { //if both equal
				return 0;
			}
		}
	}
}  
	

