package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		super(new int[] {b, a});
	}
	@Override
	public double[] solve() {
		try {
			return new double[] {-1 * ((double)(coefficients[0])) / ((double)coefficients[1])};
		}
		catch (Exception e) {
			return new double[] {};
		}
			
		
		
	}
}
