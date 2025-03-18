package flatland;

public class Tester {

	public static void main(String[] args) {
		System.out.println("Week 1 - FlatLand Lab");

		Point p1 = new Point();
		Point p2 = new Point(2,3);
		
		System.out.println(p1);
		System.out.println("P2, " + p2);
		
		Segment s1 = new Segment(p1, p2);
		Segment s2 = new Segment(p2, new Point(5,7) );
		
		System.out.println("Seg1 - " + s1);
		System.out.println(String.format("Seg2 - length: %s, slope:%s", 
				s2.GetLength(), s2.getSlope()));
	}

}
