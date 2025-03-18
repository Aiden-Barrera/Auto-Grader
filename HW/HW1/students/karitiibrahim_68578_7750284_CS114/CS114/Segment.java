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
		double L1 = b.xCoord() - a.xCoord(); //TODO
		double L2 = b.yCoord() - a.yCoord();
		return Math.sqrt(L1 * L1 + L2 * L2);
	}
	
	// This is a stub, fill in the correct implementation
	public double getSlope() {
		double L1 = b.xCoord() - a.xCoord(); //TODO
		double L2 = b.yCoord() - a.yCoord();
		
		if(L1 == 0) {
			throw new ArithmeticException("Slope is undefined");
		}
		return L2 / L1;
		
	}
	
	public String toString(){
		return a.toString() + " - " + b.toString();
	}

}
