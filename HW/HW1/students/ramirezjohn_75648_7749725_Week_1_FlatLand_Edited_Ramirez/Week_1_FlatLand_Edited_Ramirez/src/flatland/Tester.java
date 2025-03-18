package flatland;

public class Tester {

	public static void main(String[] args) {
		System.out.println("Week 1 - FlatLand Lab");

		Point p1 = new Point();
		Point p2 = new Point(2,3);

		System.out.println(p1);
		System.out.println("p2:" + p2);

		Segment seg1 = new Segment(p1, p2);
		Segment seg2 = new Segment(p2, new Point(5,7));

		System.out.println("seg1 - " + seg1);

		System.out.println(String.format("seg2 - length: %s, slope: %s", seg2.GetLength(),seg2.getSlope()));

		p2.move(13,20);

		seg1 = new Segment(p1, p2);
		
		System.out.println("seg1 - " + seg1); 
	}

}
