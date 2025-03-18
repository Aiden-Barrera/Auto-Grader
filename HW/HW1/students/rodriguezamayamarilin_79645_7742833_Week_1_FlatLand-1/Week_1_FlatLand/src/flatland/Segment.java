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
	public double GetLength() {//TODO
		return Math.sqrt(Math.pow(b.yCoord()-a.yCoord(),2)+ Math.pow(b.xCoord()-a.xCoord(),2));
	}
	
	// This is a stub, fill in the correct implementation
	public double getSlope() {//TODO
		return ((b.yCoord()-a.yCoord())/ (b.xCoord()-a.xCoord()));
	}

	@Override
	public String toString() {
		return this.a + "-" + this.b ;
	}
}
