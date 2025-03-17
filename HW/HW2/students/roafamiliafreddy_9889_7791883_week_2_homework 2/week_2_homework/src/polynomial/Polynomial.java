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
		// Store the coefficients
		coefficients = coeffs;

		// Set the degree to the last index in the array
		degree = coefficients.length - 1;

		// Check for trailing zeros and adjust the degree
		while (degree > 0 && coefficients[degree] == 0) {
			degree = degree - 1; // Move back one index
		}
	}

	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		for (int i = 0; i < coefficients.length; i++) {
			coefficients[i] = coefficients[i] * factor;
		}
	}

	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		// Find the larger size for the new coefficient array
		int newSize = Math.max(this.coefficients.length, p.coefficients.length);
		int[] newCoefficients = new int[newSize];

		// Copy the coefficients from this polynomial
		for (int i = 0; i < this.coefficients.length; i++) {
			newCoefficients[i] = this.coefficients[i];
		}

		// Add the coefficients from polynomial p
		for (int i = 0; i < p.coefficients.length; i++) {
			newCoefficients[i] = newCoefficients[i] + p.coefficients[i];
		}

		// Update the polynomial
		this.coefficients = newCoefficients;
		this.degree = newSize - 1;

		// Remove trailing zeros
		while (this.degree > 0 && this.coefficients[this.degree] == 0) {
			this.degree = this.degree - 1;
		}
	}

	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {

		int newSize = Math.max(this.coefficients.length, p.coefficients.length);
		int[] newCoefficients = new int[newSize];

		for (int i = 0; i < this.coefficients.length; i++) {
			newCoefficients[i] = this.coefficients[i];
		}

		for (int i = 0; i < p.coefficients.length; i++) {
			newCoefficients[i] = newCoefficients[i] - p.coefficients[i];
		}

		// Update the polynomial
		this.coefficients = newCoefficients;
		this.degree = newSize - 1;

		while (this.degree > 0 && this.coefficients[this.degree] == 0) {
			this.degree = this.degree - 1;
		}
	}

	/*
	 * Returns the polynomial derivative of this polynomial.
	 * Does NOT change this polynomial
	 */
	public Polynomial getDerivative() {
		if (this.degree == 0) {
			return new Polynomial(new int[] { 0 });
		}

		int[] derivCoefficients = new int[this.degree];

		for (int i = 1; i <= this.degree; i++) {
			derivCoefficients[i - 1] = this.coefficients[i] * i;
		}

		return new Polynomial(derivCoefficients);
	}

	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		double result = 0;

		// Loop through the coefficients and evaluate using the power rule
		for (int i = 0; i < coefficients.length; i++) {
			result += coefficients[i] * Math.pow(arg, i);
		}

		return result;
	}

	@Override
	public String toString() {
			String result = "";
	
			for (int i = degree; i >= 0; i--) {
					int coeff = coefficients[i];
	
					// Skip zero coefficients except when it's the only term
					if (coeff == 0 && i != 0) continue;
	
					// Add "+" or "-" sign for non-first terms
					if (!result.isEmpty()) {
							if (coeff > 0) {
									result += " + ";
							} else {
									result += " - ";
									coeff = -coeff; // Make coeff positive for display
							}
					} else if (coeff < 0) {
							result += "-";
							coeff = -coeff; // Make coeff positive for display
					}
	
					// Append coefficient (except when it's 1 and has a variable)
					if (coeff != 1 || i == 0) {
							result += coeff;
					}
	
					if (i > 0) {
							result += "x";
							if (i > 1) {
									result += "^" + i;
							}
					}
			}
	
			return result.isEmpty() ? "0" : result;
	}
	
	public int getDegree() {
		return degree;
	}

	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}

}
