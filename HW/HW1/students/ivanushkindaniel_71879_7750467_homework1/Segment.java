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
	
	public double GetLength() {
		double length = Math.sqrt((Math.pow((b.xCoord()+a.xCoord()), 2) 
				+ Math.pow((b.yCoord()+a.yCoord()), 2)));
		return length; 
		
	}
	
	public double getSlope() {
		return ((b.yCoord()-a.yCoord())/(b.xCoord()-a.xCoord())); 
		
	}

}
