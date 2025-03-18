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
	public double GetLength() {
		double x = b.xCoord()- a.xCoord();
		double y = b.yCoord() - a.yCoord();
		return Math.sqrt(x * x + y * y);
 

		
	}
	
	// This is a stub, fill in the correct implementation
	public double getSlope() {
		    double x = b.xCoord()- a.xCoord();
	        double y = b.yCoord() - a.yCoord();
	        return y/x;
		
	}
	public String toString() {
		return "(" + a.xCoord() + "," + a.yCoord() + ") - (" + b.xCoord() + "," + b.yCoord() + ")";
	}

}
