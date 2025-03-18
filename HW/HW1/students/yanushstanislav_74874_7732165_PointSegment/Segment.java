package flatland;

public class Segment {
	private Point a;
	private Point b;
	
	public Segment (Point a, Point b) {
		this.a = a;
		this.b = b;
	}
	
	public void setEndPoints(Point a, Point b) {
		this.a = a;
		this.b = b;
	}
	
	public void setEndPoints(double x1, double y1, double x2, double y2) {
		this.a = new Point(x1, y1);
		this.b = new Point(x2, y2);
	}

	public String toString() {
		return ("(" + a.xCoord() + "," + a.yCoord() + ") - (" + b.xCoord() + "," + b.yCoord() + ")");
	}
	
	public double GetLength() {
		return (Math.sqrt((Math.pow((a.xCoord() - b.xCoord()),2) + (Math.pow((a.yCoord() - b.yCoord()),2))))); 
	}
	
	public double getSlope() {
		return ((a.yCoord() - b.yCoord()) / ((a.xCoord() - b.xCoord()))); 
	}

}
