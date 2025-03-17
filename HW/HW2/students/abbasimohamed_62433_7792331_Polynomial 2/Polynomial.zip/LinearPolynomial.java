package polynomial;

public class LinearPolynomial extends Polynomial {
	public LinearPolynomial(int a, int b) {
		super(new int[] { b, a });
	}

	public double[] solve() {
		int a = 0;
		if (coefficients.length > 1) {
			a = coefficients[1];
		}
		int b = coefficients[0];
		if (a == 0) {
			return new double[0];
		}
		double sol = -b / (double)a;
		double[] solution = new double[1];
		solution[0] = sol;
		return solution;
	}
}
