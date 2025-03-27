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
	
	//using a return value variable this time instead of a lot of return statements like in polynomial
	@Override
	public int compareTo(Point o) {
		int returnVal = 0;
		if (this.y > o.y) {
			returnVal = 1;
		}
		else if (this.y == o.y) {
			if (this.x > o.x) {
				returnVal = 1;
			}
			else if (this.x < o.x) {
				returnVal = -1;
			}
			
		}
		else if (this.y == o.y && this.x == o.x) {
			returnVal = 0;
		}
		else {
			returnVal = -1;
		}
		
		return returnVal; //STUB
	}
}  
	

