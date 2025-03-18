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
		// Find change in X
		double changeX = b.xCoord() - a.xCoord();
		// Find change in Y
		double changeY = b.yCoord() - a.yCoord();
		// Distance formula
		return Math.sqrt((changeX*changeX)+(changeY*changeY)); //TODO
	}
	
	// This is a stub, fill in the correct implementation
	public double getSlope() {
		// Find change in X
		double changeX = b.xCoord() - a.xCoord();
		// Find change in Y
		double changeY = b.yCoord() - a.yCoord();
		// If slope is undefined:
		if (changeX == 0) {
			return 0;
		}
		// Slope formula
		return (changeY/changeX); //TODO
		
	}

}
