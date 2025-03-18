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
	
	// This is a stub, fill in the correct implementation
	public double getLength() {
		return Math.sqrt((Math.pow(this.b.xCoord(),2) - Math.pow(this.a.xCoord(),2))+(Math.pow(this.b.yCoord(),2) - Math.pow(this.a.yCoord(),2)));
		
		
	}
	
	// This is a stub, fill in the correct implementation
	public double getSlope() {
		return (b.yCoord() - a.yCoord()) / b.xCoord() - a.xCoord();
		
	}
	public String toString() {
		return String.format("(%s,%s)-(%s,%s)",a.xCoord(),a.yCoord(),b.xCoord(),b.yCoord());
	}

}
