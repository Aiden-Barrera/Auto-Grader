package flatLand;

public class Segment {
	private Point a;
	private Point b;
	
	// default constructor
	public Segment() {
		this.a = new point(0,0);
		this.b = new point(0,0);
	}
	public Segment (Point a, Point b) {
		this.a = a;
		this.b = b;
	}
	// overloading the setter bc there are two functions
	public void setEndPoints(Point a, Point b) {
		this.a = a;
		this.b = b;
	}
	
	public void setEndPoints(double x1, double y1, double x2, double y2) {
		this.a = new Point(x1, y1);
		this.b = new Point(x2, y2);
	}
	
	// This is a stub, fill in the correct implementation
	public double getLength() {
		double x1 = a.xCoord();
		double y1 = a.yCoord();
		double x2 = b.xCoord();
		double y2 = b.xCoord();
		
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 -y1, 2));
		
	}
	
	// This is a stub, fill in the correct implementation
	public double getSlope() {
		double ret = (b.yCoord()-a.yCoord()) / b.xCoord()-a.xCoord();
		return ret;
		
	}
	
	public String toString() {
		return String.format("(%s, %s)-(%s, %s) ", a.xCoord(),a.yCoord(), b.xCoord(), b.yCoord());
	}
}
