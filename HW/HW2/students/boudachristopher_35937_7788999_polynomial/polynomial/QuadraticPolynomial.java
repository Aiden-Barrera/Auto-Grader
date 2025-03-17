package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		// TO DO
		super(new int[]{A, B, C});

	}
	//Override polynomial.solve()
	public String toString() {
		int a = coefficients[0];
		int b = coefficients[1];
		int c = coefficients[2];

		StringBuilder sb = new StringBuilder();

		if (a != 0) {
			if (a == 1) {
				sb.append("x^2");
			} else if (a == -1) {
				sb.append("-x^2");
			} else {
				sb.append(a).append("x^2");
			}
		}

		if (b != 0) {
			if (sb.length() > 0) {
				sb.append(b > 0 ? " + " : " - ");
			} else if (b < 0) {
				sb.append("-");
			}

			if (Math.abs(b) != 1) {
				sb.append(Math.abs(b)).append("x");
			} else {
				sb.append("x");
			}
		}

		if (c != 0) {
			if (sb.length() > 0) {
				sb.append(c > 0 ? " + " : " - ");
				sb.append(Math.abs(c));
			} else {
				sb.append(c);
			}
		}

		if (sb.length() == 0) {
			return "0";
		}

		return sb.toString();
	}
}
