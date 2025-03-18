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
		double L1 = (b.xCoord() - a.xCoord()) * (b.xCoord() - a.xCoord());
		double L2 = (b.yCoord() - a.yCoord()) * (b.yCoord() - a.yCoord());
		double lineLength = Math.sqrt(L1 + L2);
		
		
		
		
		return lineLength; //TODO
		
	}
	
	// This is a stub, fill in the correct implementation
	public double getSlope() {
		double M = ((b.yCoord() - a.yCoord()) / (b.xCoord() - a.xCoord()));
		
		return M; //TODO
		
	}
	@Override public String toString() {
		
		return ("(" + a.xCoord() + "," +  a.yCoord() + " ) - (" + b.xCoord() + "," +  b.yCoord() + " )");
	}

}
