package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		// TO DO
		super(new int[] {C,B,A});
	}
	//Override polynomial.solve()
	public double[] solve() {
		int a = this.coefficients[2];
		int b = this.coefficients[1];
		int c = this.coefficients[0];
		
		double x1 = (-1*b - Math.sqrt((Math.pow(b, 2)-(4*a*c)))) / (2*a);
		double x2 = (-1*b + Math.sqrt((Math.pow(b, 2)-(4*a*c)))) / (2*a);
		
		return new double[] {x1,x2};
	}
}
