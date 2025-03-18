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
		return a.toString() + "_" + b.toString();
	}
	// This is a stub, fill in the correct implementation
	public double GetLength() {
		double dx = b.xCoord() - a.xCoord();
		double dy = b.yCoord() - a.yCoord();
		return Math.sqrt(dx * dx + dy * dy);
		
		
	}
	
	// This is a stub, fill in the correct implementation
	public double getSlope() {
		double dx = b.xCoord() - a.xCoord();
		if(dx == 0) {
			throw new ArithmeticException("Slope is undefined");
		}
		double dy = b.yCoord() - a.yCoord();
		return dy / dx;
		
	}

}
