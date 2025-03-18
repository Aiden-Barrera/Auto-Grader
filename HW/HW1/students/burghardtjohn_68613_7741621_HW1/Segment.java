package flatland;
public class Segment{
	private Point a;
	private Point b;
	public Segment (Point newA, Point newB){
		a = newA;
		b = newB;
	}
	public void setEndPoints(Point newA, Point newB){
		a = newA;
		b = newB;
	}
	public void setEndPoints(double newX1, double newY1, double newX2, double newY2){
		a = new Point(newX1, newY1);
		b = new Point(newX2, newY2);
	}
	public double getLength(){
		return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
	}
	public double getSlope(){
		return (b.getY() - a.getY()) / (b.getX() - a.getX());
	}
	public String toString(){
		return a.toString() + "-" + b.toString();
	}
}