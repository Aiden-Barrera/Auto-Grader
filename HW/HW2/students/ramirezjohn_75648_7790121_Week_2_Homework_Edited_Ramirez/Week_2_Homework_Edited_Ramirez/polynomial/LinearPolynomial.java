package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		super(new int[]{b,a}); // DONE
	}
	//Override polynomial.solve()
	@Override
	public double[] solve() {
		double[] results = new double[1];
		double xroot = coefficients[0] / (double) coefficients[1];
		xroot *= -1.0;
		
		results[0] = ((atPoint((float) xroot) - 0) < 0.00) ? xroot : 0;
		return results;
	}
}
