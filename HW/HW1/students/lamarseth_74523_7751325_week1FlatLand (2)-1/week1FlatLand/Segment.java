package flatland;

public class Segment {
	private Point a;
	private Point b;
	
	void exp (double n1,double n2) {
		
	}
	
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
		double distance = Math.sqrt( Math.pow(b.xCoord() - a.xCoord(),2) + Math.pow(b.yCoord() - a.yCoord(),2) );
		
		return distance;
	}
	
	// This is a stub, fill in the correct implementation
	public double getSlope() {
		
		double deltx = (b.xCoord() - a.xCoord());
		double delty = (b.yCoord() - a.yCoord());
		
		return (delty/deltx);
	}
	
	public String toString() {
		Point pa = this.a;
		Point pb = this.b;
		
		return (pa.toString() + " - " + pb.toString());
	}

}
