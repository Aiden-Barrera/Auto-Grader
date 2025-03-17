package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		// TO DO
		super(new int [] {C,B,A});
	}
	//Override polynomial.solve()
	public double[] solve() {
		double [] sol = new double[2];
		double a = this.coefficients[2];
		double b = this.coefficients[1];
		double c = this.coefficients[0];
		
		double disc = b*b-4*a*c;
		
		if (disc <0)
		{
			return sol;
		}
		
		sol[0]=(-b+Math.sqrt(disc))/(2*a);
		sol[1]=(-b-Math.sqrt(disc))/(2*a);
		return sol;
	}
}
