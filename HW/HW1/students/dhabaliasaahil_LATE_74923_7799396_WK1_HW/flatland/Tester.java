package flatland;

public class Tester {

	public static void main(String[] args) {
		System.out.println("Week 1 - FlatLand Lab");
		
		Point P1 = new Point();
		Point P2 = new Point(2,3);
		
		Segment S1 = new Segment(P1,P2);
		
		System.out.println(P1);
		System.out.println(P2);
		
		double s1Length = S1.getLength();
		System.out.println("The length of this segment is " + s1Length);
		
		double s1Slope = S1.getSlope();
		System.out.println("The slope of this segment is " + s1Slope);

	}

}
