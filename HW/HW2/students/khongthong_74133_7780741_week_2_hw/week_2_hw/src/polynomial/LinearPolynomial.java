package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		super(new int[] {b, a});
	}
	//Override polynomial.solve()
	@Override
	public double[] solve() {
		double[] result = new double[1];
		result[0]  = (double) -super.coefficients[0]/super.coefficients[1];
		return (result);
	}
	
}
