package polynomial;

/**
 * 
 * THIS CLASS REPRESENTS A LINEAR POLYNOMIAL.
 * 
 */
public class LinearPolynomial extends Polynomial {

	/* CONSTRUCT THE LINEAR POLYNOMIAL GIVEN ITS COEFFICIENTS */
	public LinearPolynomial(int a, int b) {
		super(new int[]{b, a});
	}
	
	/* SOLVE THE LINEAR EQUATION AX + B = 0 */
	@Override
	public double[] solve() {
		if (coefficients[1] == 0) {
			// NO SOLUTION IF A == 0
			return new double[]{};
		}
		return new double[]{-coefficients[0] / (double) coefficients[1]};
	}
}
