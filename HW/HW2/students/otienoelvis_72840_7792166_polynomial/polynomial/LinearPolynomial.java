package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		super(new int[]{b, a});
	}
	public double[] solve() {
        if (coefficients[1] == 0) return new double[]{};
        return new double[]{-coefficients[0] / (double) coefficients[1]};
    }
}
