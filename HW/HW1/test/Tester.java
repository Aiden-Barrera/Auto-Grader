package flatland;

public class Tester {

	public static void main(String[] args) {
		System.out.println("Week 1 - FlatLand Lab");
		
		Point a = new Point(3.2,7);
		Point b = new Point(1,8.6);
		
		Segment seg = new Segment(a, b);
		
		System.out.println("point a: " + a);
		System.out.println("point b: " + b);
		
		System.out.println("Segment seg: " + seg);
		System.out.println("length of seg: " + seg.GetLength());
		System.out.println("slope of seg: " + seg.getSlope());

	}

}
