package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		super (new int[] {C, B, A});
	}
	 
	@Override
	public double[] solve() {
		int A = coefficients[2];
		int B = coefficients[1];
		int C = coefficients[0];
		
		int discriminant = B * B - 4 * A * C; 
		
		double[] roots;
		
		if (discriminant > 0) {
		    roots = new double[2];
		    roots[0] = (-B + Math.sqrt(discriminant)) / (2.0 * A);
		    roots[1] = (-B - Math.sqrt(discriminant)) / (2.0 * A);
		} else if (discriminant == 0) {
		    roots = new double[1];
		    roots[0] = -B / (2.0 * A);
		} else {
		    roots = new double[0];
		}

		
		return roots;
		
	}
}
