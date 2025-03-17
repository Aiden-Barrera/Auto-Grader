package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		super(new int[]{b, a});
				//TO DO
	}
	//Override polynomial.solve()
	@Override
	public double[] solve() {
		if (degree == 1) {
            return new double[]{-coefficients[0] / (double)coefficients[1]};
        }
        return new double[]{};
	}
}
