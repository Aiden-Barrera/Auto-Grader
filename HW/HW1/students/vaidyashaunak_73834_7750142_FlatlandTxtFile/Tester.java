package flatland;

public class Tester {

	public static void main(String[] args) {
		System.out.println("Week 1 - FlatLand Lab");

		Point p1 = new Point();
		Point p2 = new Point(5,6);
		Segment s1 = new Segment(p1,p2);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(s1);
		System.out.println(s1.getSlope());
		System.out.println(s1.getLength());
		p1.move(5, 7);
		System.out.println(s1);

	}
	
}