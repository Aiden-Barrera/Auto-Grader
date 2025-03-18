package flatland;
import java.util.*;
public class Tester {

	public static void main(String[] args) {
		System.out.println("Week 1 - FlatLand Lab");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the X coordinate for the 1st point: ");
		double x1=sc.nextDouble();
		System.out.println("Enter the Y coordinate for the 1st point: ");
		double y1=sc.nextDouble();
		Point p1=new Point(x1, y1);
		System.out.println("Enter the X coordinate for the 2nd point: ");
		double x2=sc.nextDouble();
		System.out.println("Enter the Y coordinate for the 2nd point: ");
		double y2=sc.nextDouble();
		Point p2=new Point(x2, y2);
		Segment s1=new Segment(p1, p2);
		Segment s2=new Segment(p2, new Point(5,7));
		System.out.println("Point 1: " + p1);
		System.out.println("Point 2: " + p2);
		System.out.println("Segment 1: " + s1);
		System.out.println("Segment 2: " + s2);
		System.out.println("Length of Segment 1: " + s1.GetLength() + " Slope of Segment 1: " + s1.getSlope());
		System.out.println("Length of Segment 2: " + s2.GetLength() + " Slope of Segment 2: " + s2.getSlope());
		sc.close();
	}

}
