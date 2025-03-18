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
		double dx = b.xCoord() - a.xCoord();
        double dy = b.yCoord() - a.yCoord();
        return Math.sqrt(dx * dx + dy * dy);//TODO
    }
		
	
	// This is a stub, fill in the correct implementation
	public double getSlope() {
		  double dx = b.xCoord() - a.xCoord();
		  double dy = b.yCoord() - a.yCoord();
	        if (dx == 0) {
	        	 return Double.POSITIVE_INFINITY;  
	        }
	        return dy / dx; //TODO
	    }
	
	 @Override
	    public String toString() {
	        return a.toString() + " – " + b.toString();
		
	}

}
