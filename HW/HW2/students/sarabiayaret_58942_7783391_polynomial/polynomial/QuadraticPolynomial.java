package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		super(new int[]{A, B, C});
	}
	//Override polynomial.solve()
	@Override
	public double[] solve() {
        int A = coefficients[0];
        int B = coefficients[1];
        int C = coefficients[2];

        double discriminant = Math.pow(B, 2) - 4 * A * C;

        if (discriminant < 0) {
        	return new double[]{};
        }

        double root1 = (-B + Math.sqrt(discriminant)) / (2 * A);
        double root2 = (-B - Math.sqrt(discriminant)) / (2 * A);

        if (discriminant == 0) {
            return new double[]{root1};
        }

        return new double[]{root1, root2};
    }

}
