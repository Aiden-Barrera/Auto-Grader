package flatland;

public class Tester {

	public static void main(String[] args) {
		System.out.println("Week 1 - FlatLand Lab");
		/*NOTE TO GRADER: hey i noticed there were some test cases on the homework doc but i just wrote these
		*hope that's fine. also including this tester file just so you can see what i did for testing
		*/
		Point p1 = new Point();
		Point p2 = new Point(2,3);
		System.out.println(p2); //as affected by toString
		
		Segment s1 = new Segment(p1, new Point(3,5));
		System.out.println(s1);
		
		System.out.println(s1.GetLength());
		System.out.println(s1.getSlope());
		
		Segment s2 = new Segment(new Point(5,20), new Point(7,100));
		System.out.println(s2);
		System.out.println(s2.GetLength()); //should be about 80
		System.out.println(s2.getSlope()); //should be 40
		
		//test with the string.format cus it looks handy
		System.out.println(String.format("testingGo:s2 --> segs: %s, len: %s, slope: %s", s2, s2.GetLength(), s2.getSlope()));
		//oh i see it's just format(your text, replace % with value and after just a list of values that go into place)
		
		
		//System.out.println(Math.sqrt(4));
		//System.out.println(Math.pow(5,2));
		//System.out.println(Math.pow(5,3)); //first is number, second is exponent
		//s1.setEndPoints(4, 6, 9, 10); was for testing purposes
		//System.out.println(s1);
	}

}
