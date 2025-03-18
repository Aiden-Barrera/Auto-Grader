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
	
	public double getLength() {
		/*start by finding delta x & y between the two points
		use the quadratic formula to fin the length*/

		double delta_x = this.b.xCoord() - this.a.xCoord();
		double delta_y = this.b.yCoord() - this.a.yCoord();

		double delta_x_squared = delta_x * delta_x;
		double delta_y_squared = delta_y * delta_y;

		return Math.pow((delta_x_squared + delta_y_squared), 0.5); 
	}
	
	public double getSlope() {
		/*rise over run*/

		double delta_x = this.b.xCoord() - this.a.xCoord();

		if(delta_x == 0){
			System.out.println("Slope is undefined [vertical line]");
		}
		
		double delta_y = this.b.yCoord() - this.a.yCoord();

		return delta_y / delta_x;
	}
	
	@Override
	public String toString(){

		return "(" + this.a.xCoord() + "," + this.a.yCoord() + ") - (" + this.b.xCoord() + "," + this.b.yCoord() + ")";
	}
}
