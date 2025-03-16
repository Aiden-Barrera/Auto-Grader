package Polynomial;

public class QuadraticPolynomial extends Polynomial {
	public QuadraticPolynomial(int A, int B, int C) {
		super(new int[] { C, B, A });
	}

	public double[] solve() {
		int A = 0;
		if (coefficients.length > 2) {
			A = coefficients[2];
		}
		int B = 0;
		if (coefficients.length > 1) {
			B = coefficients[1];
		}
		int C = coefficients[0];
		if (A == 0) {
			if (B == 0) {
				return new double[0];
			}
			double sol = -C / (double)B;
			double[] solution = new double[1];
			solution[0] = sol;
			return solution;
		}
		double discriminant = B * B - 4 * A * C;
		if (discriminant < 0) {
			return new double[0];
		} else if (discriminant == 0) {
			double sol = -B / (2.0 * A);
			double[] solution = new double[1];
			solution[0] = sol;
			return solution;
		} else {
			double sqrtDisc = Math.sqrt(discriminant);
			double sol1 = (-B + sqrtDisc) / (2.0 * A);
			double sol2 = (-B - sqrtDisc) / (2.0 * A);
			double[] solution = new double[2];
			solution[0] = sol1;
			solution[1] = sol2;
			return solution;
		}
	}
}
