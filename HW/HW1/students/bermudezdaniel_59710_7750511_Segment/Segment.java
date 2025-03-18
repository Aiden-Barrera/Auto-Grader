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

	@Override
	public String toString() {
		return " " + a.toString() + " - " + b.toString();
	}

	// This is a stub, fill in the correct implementation
	public double getLength() {
		double gl = b.xCoord() - a.xCoord();
		double gy = b.yCoord() - a.yCoord();
		double glsq = gl * gl;
		double gysq = gy * gy;
		return Math.sqrt(glsq + gysq);
	}

	// This is a stub, fill in the correct implementation
	public double getSlope() {
		return (b.yCoord() - a.yCoord()) / (b.xCoord() - a.xCoord());

	}

}
