package flatland;

public class Tester {

	public static void main(String[] args) {
		System.out.println("Week 1 - FlatLand Lab");
		
		Point p1 = new Point();
		Point p2 = new Point(2,3);
		
		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
		
		Segment seg1 = new Segment(p1, p2);
		Segment seg2 = new Segment(p2, new Point (5,7));
		
		System.out.println("seg1: " + seg1);
		System.out.println("seg2: " + seg2);
		
		System.out.println("length1: " + seg1.getLength());
		System.out.println("length2: " + seg2.getLength());
	
		System.out.println("slope1: " + seg1.getSlope());
		System.out.println("slope2: " + seg2.getSlope());

	}

}
