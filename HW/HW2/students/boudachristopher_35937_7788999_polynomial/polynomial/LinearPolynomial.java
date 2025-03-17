package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		//TO DO
		super(new int[]{a, b});
	}
	public String toString() {
		int a = coefficients[0];
		int b = coefficients[1];

		StringBuilder sb = new StringBuilder();

		if (a != 0) {
			if (a == 1) {
				sb.append("x");
			} else if (a == -1) {
				sb.append("-x");
			} else {
				sb.append(a).append("x");
			}
		}

		if (b != 0) {
			if (sb.length() > 0) {
				sb.append(b > 0 ? " + " : " - ");
				sb.append(Math.abs(b));
			} else {
				sb.append(b);
			}
		}

		if (sb.length() == 0) {
			return "0";
		}

		return sb.toString();
	}
}
