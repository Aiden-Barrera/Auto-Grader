package flatland;

public class Tester {

	public static void main(String[] args) {
		System.out.println("Week 1 - FlatLand Lab");

		Point pointA = new Point(2, 1);   
		Point pointB = new Point(3, 4);   

		Segment testSegment = new Segment(pointA, pointB); 

		System.out.print("pointA:" + pointA + " pointB:" + pointB + " testSegment:" + testSegment + "Slope: " + testSegment.getSlope() + "Lenght: " + testSegment.GetLength());

	}

}
