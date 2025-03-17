package polynomial;

public class QuadraticPolynomial extends Polynomial{
	
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
        super(new int[]{C, B, A});
    }

    @Override
    public double[] solve() {
        if (degree != 2) return null;
        int A = coefficients[2], B = coefficients[1], C = coefficients[0];
        double inside = B * B - 4 * A * C;
        if (inside < 0) return new double[]{};
        if (inside == 0) return new double[]{-B / (2.0 * A)};
        return new double[]{(-B + Math.sqrt(inside)) / (2.0 * A), (-B - Math.sqrt(inside)) / (2.0 * A)};
    }
}
