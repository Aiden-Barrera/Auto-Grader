package polynomial;

/**
 * 
 * THIS CLASS REPRESENTS A QUADRATIC POLYNOMIAL.
 * 
 */
public class QuadraticPolynomial extends Polynomial {

	/* CONSTRUCT THE QUADRATIC POLYNOMIAL GIVEN ITS COEFFICIENTS */
	public QuadraticPolynomial(int A, int B, int C) {
		super(new int[]{C, B, A});
	}
	
	/* SOLVE THE QUADRATIC EQUATION AX^2 + BX + C = 0 */
	@Override
	public double[] solve() {
		int A = coefficients[2], B = coefficients[1], C = coefficients[0];
		double discriminant = B * B - 4 * A * C;

		if (discriminant < 0) {
			// NO REAL SOLUTIONS
			return new double[]{};
		}
		if (discriminant == 0) {
			// ONE REAL SOLUTION
			return new double[]{-B / (2.0 * A)};
		}
		
		// TWO REAL SOLUTIONS
		double sqrtD = Math.sqrt(discriminant);
		return new double[]{
			(-B + sqrtD) / (2.0 * A),
			(-B - sqrtD) / (2.0 * A)
		};
	}
}
