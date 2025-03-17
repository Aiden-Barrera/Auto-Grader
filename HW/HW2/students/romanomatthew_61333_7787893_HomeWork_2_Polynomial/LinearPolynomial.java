package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		coefficients = new int[] {b,a};
		degree = 1;
	}
	
	public double[] solve() {
		double[] result = new double[1];
		result[0] = (double) -1 * (coefficients[0] / coefficients[1]);
		return result;
	}
}
