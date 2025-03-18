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
		double changeInY = a.yCoord() - b.yCoord();
		double changeInX = a.xCoord() - b.xCoord();
		double distanceFormula = Math.sqrt(Math.pow(changeInX, 2) + Math.pow(changeInY, 2));
				return distanceFormula;
		
	}
	
	// This is a stub, fill in the correct implementation
	public double getSlope() {
		double changeInY = a.yCoord() - b.yCoord();
		double changeInX = a.xCoord() - b.xCoord();
		double slope = changeInY / changeInX ;
			return slope; 
		
	}
	public String toString() {
	    return "(" + a.xCoord() + "," + a.yCoord() + ") – (" + b.xCoord() + "," + b.yCoord() + ")";
	}
}


