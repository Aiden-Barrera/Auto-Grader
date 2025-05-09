package flatland;
public class Point{
	private double x;
	private double y;
	public Point(){
		x = 0;
		y = 0;
	}
	public Point(double newX, double newY) {
		x = newX;
		y = newY;
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public void moveTo(double newX, double newY){
		x = newX;
		y = newY;
	}
	public String toString(){
		return "(" + x + "," + y + ")";
	}
}