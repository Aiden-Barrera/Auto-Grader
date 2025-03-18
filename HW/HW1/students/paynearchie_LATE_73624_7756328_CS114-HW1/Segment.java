package flatland;

public class Segment {
	private Point a;
	private Point b;
	
	public Segment(Point a, Point b) {
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
		double x1 = this.a.xCoord();
		double y1 = this.a.yCoord();
		double x2 = this.b.xCoord();
		double y2 = this.b.yCoord();
		double aSq = Math.pow(x2-x1,2);
		double bSq = Math.pow(y2-y1,2);
		return Math.sqrt(aSq+bSq);

		
	}
	
	// This is a stub, fill in the correct implementation
	public double getSlope() {
		double x1 = this.a.xCoord();
		double y1 = this.a.yCoord();
		double x2 = this.b.xCoord();
		double y2 = this.b.yCoord();
		return (y2-y1)/(x2-x1);		
		
	}
	
	public String toString() {
		return "("+this.a.xCoord()+", "+this.a.yCoord()+") - ("+this.b.xCoord()+", "+this.b.yCoord()+")";
	}

}
