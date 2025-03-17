package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		super(new int[] {b,a});
	}
	
	@Override
	public double[] solve() {
		int a = coefficients[0];
		int b = coefficients[1];
		
		if (a == 0) {
			return new double[] {};
		}
		return new double[] {-b / (double)a};
	}
}
