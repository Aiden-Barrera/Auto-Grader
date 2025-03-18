package flatland;

public class Tester {
    public static void main(String[] args) {
        System.out.println("Week 1 - FlatLand Lab");

        Point p1 = new Point(2, 3);
        Point p2 = new Point(5, 7);

        Segment s1 = new Segment(p1, p2);

        System.out.println("Point 1: " + p1);
        System.out.println("Point 2: " + p2);
        System.out.println("Segment: " + s1);
        System.out.println("Length: " + s1.getLength());
        System.out.println("Slope: " + s1.getSlope());
    }
}
