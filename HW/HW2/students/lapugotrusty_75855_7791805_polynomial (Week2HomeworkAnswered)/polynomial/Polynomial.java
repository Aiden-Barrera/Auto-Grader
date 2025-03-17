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
		for (int x = coefficients.length - 1; x >= 0; x--) {
			if (coeffs[x] != 0) {
				degree = x;
				break;
			}
		}
	}

	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		for (int x = 0; x < coefficients.length; x++) {
			coefficients[x] = coefficients[x] * factor;
		}
	}

	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		for (int x = 0; x < coefficients.length; x++) {
			for (int y = 0; y < p.coefficients.length; y++) {
				if (x == y) {
					coefficients[x] += p.coefficients[x];
				}
			}
		}
	}

	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		for (int x = 0; x < coefficients.length; x++) {
			for (int y = 0; y < p.coefficients.length; y++) {
				if (x == y) {
					coefficients[x] -= p.coefficients[x];
				}
			}
		}
	}

	/*
	 * Returns the polynomial derivative of this polynomial. Does NOT change this
	 * polynomial
	 */
	public Polynomial getDerivative() {
		int[] derCoeffs = new int[coefficients.length - 1];
		for (int x = 1; x < coefficients.length; x++) {
			derCoeffs[x - 1] = coefficients[x] * x;
		}
		return new Polynomial(derCoeffs); // STUB
	}

	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		float sumAtPoint = 0;
		for (int x = 0; x < coefficients.length; x++) {
			sumAtPoint = sumAtPoint + coefficients[x] * arg * x;
		}
		return sumAtPoint; // STUB
	}

	@Override
	public String toString() {
		String polyString = "";
		for (int x = coefficients.length - 1; x >= 0; x--) {
			if (coefficients[x] == 0) {
				continue;
			} else if (coefficients[x] < 0) {
				polyString = polyString + " - ";
			} else {
				polyString = polyString + " + ";
			}
			if (x == 0) {
				polyString = polyString + Math.abs(coefficients[x]);
			} else if (x == 1) {
				if (coefficients[x - 1] == 0) {
					polyString = polyString + Math.abs(coefficients[x]) + "x";
					return polyString;
				}
				polyString = polyString + Math.abs(coefficients[x]) + "x";
			} else {
				if (x > 0 && x < coefficients.length - 1) {
					if (coefficients[x - 1] == 0 && coefficients[x + 1] == 0) {
						polyString = polyString + Math.abs(coefficients[x]) + "x^" + x;
						continue;
					}

				}
				polyString = polyString + Math.abs(coefficients[x]) + "x^" + x;
			}
			if (coefficients.length == 1) {
				return polyString;
			}

		}
		return polyString; // STUB
	}

	public int getDegree() {
		return degree;
	}

	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}

}
