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
		double segmentXLen = this.b.xCoord() - this.a.xCoord();
		double segmentYLen = this.b.yCoord() - this.a.yCoord();
		double segmentLen = Math.sqrt(Math.pow(segmentXLen, 2) + Math.pow(segmentYLen, 2));
		return segmentLen; //TODO
		
	}
	
	// This is a stub, fill in the correct implementation
	public double getSlope() {
		double segmentXLen = this.b.xCoord() - this.a.xCoord();
		double segmentYLen = this.b.yCoord() - this.a.yCoord();
		return segmentYLen/segmentXLen; //TODO
		
	}

	public String toString() {
		String aString = this.a.toString();
		String bString = this.b.toString();
		return aString + "-" + bString;
	}

}
