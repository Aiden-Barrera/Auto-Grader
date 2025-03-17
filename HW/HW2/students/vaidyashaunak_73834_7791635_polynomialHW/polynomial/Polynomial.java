package polynomial;

/**
 * 
 * This class represent a polynomial,
 * 
 */
public class Polynomial {
	protected int[] coefficients;
	protected int degree;

	public Polynomial() {
		// Default polynomial is 0
		coefficients = new int[] { 0 };
		degree = 0;
	}

	/* Construct the polynomial given it's coefficients */
	public Polynomial(int[] coeffs) {
		coefficients = coeffs;
		for (int i = coefficients.length - 1; i > 0; i--) {
			if (coefficients[i] != 0) {
				degree = i;
				break;
			}
		}
	}

	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		// TO DO
		for (int i = 0; i < coefficients.length; i++) {
			coefficients[i] = coefficients[i] * factor;
		}
	}

	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		if (this.getDegree() >= p.getDegree()) {
			for (int i = 0; i <= p.getDegree(); i++) {
				coefficients[i] = coefficients[i] + p.coefficients[i];
			}
		} else {
			int[] newCoefficients = p.coefficients;
			for (int i = 0; i <= this.getDegree(); i++) {
				newCoefficients[i] = newCoefficients[i] + coefficients[i];
			}
			coefficients = newCoefficients;
			for (int i = coefficients.length - 1; i > 0; i--) {
				if (coefficients[i] != 0) {
					degree = i;
					break;
				}
			}
		}
	}

	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		if (this.getDegree() >= p.getDegree()) {
			for (int i = 0; i <= p.getDegree(); i++) {
				coefficients[i] = coefficients[i] - p.coefficients[i];
			}
		} else {
			int[] newCoefficients = p.coefficients;
			for (int i = 0; i <= this.getDegree(); i++) {
				newCoefficients[i] = -newCoefficients[i];
				newCoefficients[i] = newCoefficients[i] + coefficients[i];
			}
			coefficients = newCoefficients;
			coefficients = newCoefficients;
			for (int i = coefficients.length - 1; i > 0; i--) {
				if (coefficients[i] != 0) {
					degree = i;
					break;
				}
			}
		}

	}

	/*
	 * Returns the polynomial derivative of this polynomial. Does NOT change this
	 * polynomial
	 */
	public Polynomial getDerivative() {
		int[] derivative = new int[coefficients.length - 1];
		for (int i = 0; i <= derivative.length - 1; i++) {
			derivative[i] = coefficients[i + 1] * (i + 1);
		}
		return new Polynomial(derivative); // STUB
	}

	/* Returns the value of the polynomial at a point */
	public double atPoint(double arg) {
		double result = 0;
		for (int i = 0; i < coefficients.length; i++) {
			result = (double) (result + (coefficients[i] * Math.pow(arg, i)));
		}
		return result; // STUB
	}

	@Override
	public String toString() {
		// TO DO
		String word = "";
		for (int i = coefficients.length - 1; i >= 0; i--) {
			if (coefficients[i] != 0) {
				if (i == 0) {
					word = word + "+" + coefficients[i];
				} else {
					if (coefficients[i] >= 0) {
						word = word + "+" + coefficients[i] + "x^" + i;
					} else {
						word = word + coefficients[i] + "x^" + i;

					}
				}
			}
		}
		return word; // STUB
	}

	public int getDegree() {
		return degree;
	}

	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}

}
