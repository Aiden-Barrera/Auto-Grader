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
		boolean isSameYLevel = this.yCoord() == o.yCoord();
		boolean isSameXLevel = this.xCoord() == o.xCoord();
		
		//Compare the two Y values first as this is the first factor in determining who is greater
		if (!isSameYLevel)
		{
			if (this.yCoord() < o.yCoord())
			{
				return -1;
			} else if (this.yCoord() > o.yCoord())
			{
				return 1;
			}
		} 
		
		//If they're the same y level then compare
		if (!isSameXLevel)
		{
			if (this.xCoord() < o.xCoord())
			{
				return -1;
			} else if (this.xCoord() > o.xCoord())
			{
				return 1;
			}
		}
		
		//If they are the same x and y level then none of this runs and it just returns zero as they are equal
		return 0; //STUB
	}
}  
	

