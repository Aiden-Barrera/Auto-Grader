package flatland;

public class Tester {

	public static void main(String[] args) {
		System.out.println("Week 1 - FlatLand Lab\n");
foo();
System.out.println("End of foo()\n");
		Point p1 = new Point();
		Point p2 = new Point(2,3);

		//System.out.println();
		System.out.println("p1:" + p1);
		System.out.println("p2:" + p2);

		Segment seg1 = new Segment(p1,p2);
		Segment seg2 = new Segment(p2,new Point(5,7));

		System.out.println("seg1 -" + seg1);
		//System.out.println("seg2 -" + seg2);
		
		//p2.move(1, 1);
		
		System.out.println(String.format("seg2 - length: %s, slope:%s", seg2.GetLength(), seg2.getSlope()));
	}

	public static void foo() {
		int a = 5;
		Point p = new Point(10,20);
		
		bar(a,p);
		System.out.println(a);
		System.out.println(p);
		
		bar2(p);
		
		System.out.println(p); //4,5


	}


	public static void bar(int x, Point q) {
		x=7;
		q.move(4, 5);
	}	
	
	private static void bar2(Point q) {
		q = new Point(9,3);
	}
}