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
	
	//length formula
    public double getLength() {
        double diffX = b.xCoord() - a.xCoord();
        double diffY = b.yCoord() - a.yCoord();
        return Math.sqrt(diffX * diffX + diffY * diffY);
    }

    //slope formula
    public double getSlope() {
        double Xslope = b.xCoord() - a.xCoord();
        double Yslope = b.yCoord() - a.yCoord();
        return Yslope / Xslope;
    }
		
	
	//toString part b
    public String toString() {
        return "(" + a.xCoord() + "," + a.yCoord() + ") - (" + b.xCoord() + "," + b.yCoord() + ")";
    }

}
