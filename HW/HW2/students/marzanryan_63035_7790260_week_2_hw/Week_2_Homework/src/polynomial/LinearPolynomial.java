package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		coefficients = new int[] {b, a};
		degree = 1;
	}
	@Override
	public double[] solve() {
		if (coefficients[1] == 0) {
				return new double[0];
		}
		
		return new double[] {- (double) coefficients[0] / coefficients[1]};
	}
	
}
