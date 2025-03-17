package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		super(new int[]{C, B, A});
	}
	//Override polynomial.solve()
	public double[] solve() {
		if (degree == 2) {
			double A = coefficients[2];
			double B = coefficients[1];
			double C = coefficients[0];

			double root1 = (-B + Math.sqrt(B * B - 4 * A * C)) / (2 * A);
			double root2 = (-B - Math.sqrt(B * B - 4 * A * C)) / (2 * A);

			if (B * B - 4 * A * C >= 0) {
				return new double[]{root1, root2};
			}
		}
		return new double[]{};
	}
}
