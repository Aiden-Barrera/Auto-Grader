package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		super(new int[]{C, B, A});
	}
	//Override polynomial.solve()

	@Override
    public double[] solve() {
        int A = coefficients[2];
        int B = coefficients[1];
        int C = coefficients[0];

        double discriminant = B * B - 4 * A * C;
        if (discriminant < 0) {
            return new double[]{};
        }
        if (discriminant == 0) {
            return new double[]{-B / (2.0 * A)};
        }
        double sqrtDisc = Math.sqrt(discriminant);
        return new double[]{(-B + sqrtDisc) / (2.0 * A), (-B - sqrtDisc) / (2.0 * A)};
    }
}
