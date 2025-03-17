package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		// TO DO

		super(new int[] {C, B, A});
	}
	//Override polynomial.solve()

	@Override
	public double[] solve() {
		int a = coefficients[2];
		int b = coefficients[1];
		int c = coefficients[0];

		if (a == 0) {
			LinearPolynomial linearPolynomial = new LinearPolynomial(b, c);
			return linearPolynomial.solve();
		}

		double discriminant = b * b - 4 * a * c;

		if (discriminant < 0) {
			return new double[0];
		} else if (discriminant == 0) {
			double solution = (double) -b / (2 * a);
			return new double[] {solution};
		} else {
			double solution1 = (double) (-b + Math.sqrt(discriminant)) / (2 * a);
			double solution2 = (double) (-b - Math.sqrt(discriminant)) / (2 * a);
			return new double[] {solution1, solution2};
		}
	}
}
