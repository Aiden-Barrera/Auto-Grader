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

	// Calculate the length of the segment
	public double GetLength() {
		double deltaX = b.xCoord() - a.xCoord();
		double deltaY = b.yCoord() - a.yCoord();
		return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
	}

	public double getSlope() {
		double deltaX = b.xCoord() - a.xCoord();
		double deltaY = b.yCoord() - a.yCoord();
		if (deltaX == 0) {
			throw new ArithmeticException("Slope is undefined (vertical line).");
		}
		return deltaY / deltaX;
	}

	public String toString() {
		return a.toString() + " - " + b.toString();
	}
}
