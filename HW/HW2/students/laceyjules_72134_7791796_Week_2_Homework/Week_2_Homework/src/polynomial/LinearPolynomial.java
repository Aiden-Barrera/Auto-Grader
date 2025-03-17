package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		super(new int[] {a,b});
	}
	//Override polynomial.solve()
	
	@Override
	public double[] solve() {
		double sol = 0-this.coefficients[1];
		sol = sol/this.coefficients[0];
		return new double[] {sol};
	}
}
