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
		double length = Math.sqrt(Math.pow(this.a.xCoord() - this.b.xCoord(), 2) + 
				Math.pow(this.a.yCoord() - this.b.yCoord(), 2));
		return length; //TODO
		
	}
	
	// This is a stub, fill in the correct implementation
	public double getSlope() {
		double slope = (this.a.yCoord() - this.b.yCoord()) / (this.a.xCoord() - this.b.xCoord());
		return slope; //TODO
		
	}
	
	public String toString() {
		return this.a + " - " + this.b; 
	}

}
