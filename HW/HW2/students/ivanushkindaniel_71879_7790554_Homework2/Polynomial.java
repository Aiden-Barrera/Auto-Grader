package college;

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

		// Finds degree from highest non-zero coefficient

		int i = coeffs.length - 1;
		while (i > 0 && coeffs[i] == 0) {
			i--;
		}

		// If there aren't any non-zero coefficients automatically makes a zero
		// polynomial

		if (i < 0) {
			this.degree = 0;
			this.coefficients = new int[] { 0 };
		} else {
			this.degree = i;
			this.coefficients = new int[this.degree + 1];

			// Copies coefficients

			for (int j = 0; j <= this.degree; j++) {
				this.coefficients[j] = coeffs[j];
			}
		}
	}

	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {

		// Runs through every coefficient and multiples by the factor

		for (int i = 0; i < this.degree; i++) {
			this.coefficients[i] *= factor;
		}
	}

	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		// Finds the maximum degree from both polynomials
		int newDegree = Math.max(this.degree, p.degree);
		int[] result = new int[newDegree + 1];

		// Adds coefficients from first polynomial
		for (int i = 0; i <= this.degree; i++) {
			result[i] += this.coefficients[i];
		}

		// Adds coefficients from second polynomial
		for (int i = 0; i <= p.degree; i++) {
			result[i] += p.coefficients[i];
		}

		// Updates new polynomial to the new result
		this.coefficients = result;
		this.degree = newDegree;

		// Removes any leading zeros
		while (this.degree > 0 && this.coefficients[this.degree] == 0) {
			this.degree--;
		}
	}

	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		
		// Practically identical as addition method. 
		// Look at addition method to know what these do
		int newDegree = Math.max(this.degree,  p.degree);
		int [] result = new int[newDegree + 1];
		
		for (int i = 0; i <= this.degree; i++) {
			result[i] += this.coefficients[i];
		}
		
		for (int i = 0; i<=p.degree; i++) {
			result[i] -= p.coefficients[i];
		}
		
		this.coefficients = result;
		this.degree = newDegree;
		
		while (this.degree >0 && this.coefficients[this.degree]== 0) {
			this.degree--;
		}
	}

	/*
	 * Returns the polynomial derivative of this polynomial. Does NOT change this
	 * polynomial
	 */
	public Polynomial getDerivative() {
		// If the polynomial has a degree of 0 then the derivative is 0
		if (this.degree == 0) {
			return new Polynomial(new int[] { 0 });
		}

		int[] derivativeCoeffs = new int[this.degree];

		for (int i = 1; i <= this.degree; i++) {
			derivativeCoeffs[i - 1] = this.coefficients[i] * i;
		}
		return new Polynomial(derivativeCoeffs);
	}

	public double atPoint(float arg) {
		double result = 0;

		for (int i = 0; i <= this.degree; i++) {
			result += this.coefficients[i] * Math.pow(arg, i);
		}
		return result;
	}

	@Override
	public String toString() {
		String result = "";

		// Goes through the coefficients in backwards order
		for (int i = this.degree; i >= 0; i--) {
			if (this.coefficients[i] == 0) {
				continue; // Skips any zero coefficients
			}

			// Handles the sign
			if (result.length() > 0) {
				if (this.coefficients[i] > 0) {
					result += " + ";
				} else {
					result += " - ";
				}
			}
			// This is for the first term. When it's negative it adds the minus sign
			else if (this.coefficients[i] < 0) {
				result += "-";
			}

			// Adds the absolute value of the coefficient

			result += Math.abs(this.coefficients[i]);

			// Adds the x and degree when necessary
			if (i > 0) {
				result += "x";
				if (i > 1) {
					result += "^" + i;
				}
			}
		}
		return result;
	}

	public int getDegree() {
		return degree;
	}

	public double[] solve() {
		return null;
	}

}
