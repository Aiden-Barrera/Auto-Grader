package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
        super(new int[]{b, a});
    }

    @Override
    public double[] solve() {
        if (degree != 1) return null;
        int a = coefficients[1];
        int b = coefficients[0];
        if (a == 0) return null;
        return new double[]{-b / (double) a};
    }
}
