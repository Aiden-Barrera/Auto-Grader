package polynomial;

/**
 * 
 * This class represents a polynomial. 
 * 
 */
public class Polynomial {
	protected int[] coefficients;
	protected int degree;
	
	public Polynomial() {
		// Default polynomial is 0
		coefficients = new int[] {0};
		degree = 0;
	}
		
	/* Construct the polynomial given its coefficients */ 
	public Polynomial(int[] coeffs) {
		// REMOVE LEADING ZEROS AND DETERMINE DEGREE
		int leadingIndex = coeffs.length - 1;
		while (leadingIndex > 0 && coeffs[leadingIndex] == 0) {
			leadingIndex--;
		}
		degree = leadingIndex;
		coefficients = new int[degree + 1];
		System.arraycopy(coeffs, 0, coefficients, 0, degree + 1);
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		for (int i = 0; i <= degree; i++) {
			coefficients[i] *= factor;
		}
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		int maxDegree = Math.max(this.degree, p.degree);
		int[] result = new int[maxDegree + 1];

		for (int i = 0; i <= maxDegree; i++) {
			int thisCoeff = (i <= this.degree) ? this.coefficients[i] : 0;
			int pCoeff = (i <= p.degree) ? p.coefficients[i] : 0;
			result[i] = thisCoeff + pCoeff;
		}

		this.coefficients = result;
		this.degree = maxDegree;
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		int maxDegree = Math.max(this.degree, p.degree);
		int[] result = new int[maxDegree + 1];

		for (int i = 0; i <= maxDegree; i++) {
			int thisCoeff = (i <= this.degree) ? this.coefficients[i] : 0;
			int pCoeff = (i <= p.degree) ? p.coefficients[i] : 0;
			result[i] = thisCoeff - pCoeff;
		}

		this.coefficients = result;
		this.degree = maxDegree;
	}
	
	/* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		if (degree == 0) {
			return new Polynomial(new int[]{0});
		}
		
		int[] derivative = new int[degree];
		for (int i = 1; i <= degree; i++) {
			derivative[i - 1] = coefficients[i] * i;
		}
		return new Polynomial(derivative);
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		double result = 0;
		double xPower = 1; // Start with x^0 = 1
		
		for (int i = 0; i <= degree; i++) {
			result += coefficients[i] * xPower;
			xPower *= arg;
		}
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = degree; i >= 0; i--) {
			if (coefficients[i] != 0) {
				if (sb.length() > 0) {
					sb.append(coefficients[i] > 0 ? " + " : " - ");
				} else if (coefficients[i] < 0) {
					sb.append("-");
				}

				int absCoeff = Math.abs(coefficients[i]);
				if (!(absCoeff == 1 && i > 0)) sb.append(absCoeff);

				if (i > 0) sb.append("x");
				if (i > 1) sb.append("^").append(i);
			}
		}
		return sb.length() > 0 ? sb.toString() : "0";
	}
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
}
