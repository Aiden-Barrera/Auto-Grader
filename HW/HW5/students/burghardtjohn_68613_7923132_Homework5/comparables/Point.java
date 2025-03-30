package comparables;
public class Point implements Comparable<Point>{
	private int x;
	private int y;
	public Point(int newX, int newY){
		x = newX;
		y = newY;
	}
	public double xCoord(){
		return x;
	}
	
	public double yCoord(){
		return y;
	}
	public void move(int newX, int newY){
		x = newX;
		y = newY;
	}
	public String toString(){
		return String.format("(%s,%s)", x,y);
	}
	public int compareTo(Point o) {
		if (y < o.y)
			return -1;
		else if (y > o.y)
			return 1;
		else
			if (x < o.x)
				return -1;
			else if (x > o.x)
				return 1;
			else
				return 0;
	}
}