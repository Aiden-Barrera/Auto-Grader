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
		coefficients = new int[] {0};
		degree = 0;
	}
		
	/* Construct the polynomial given it's coefficients */ 
	public Polynomial(int[] coeffs) {
		this.coefficients = coeffs;
		this.degree = coeffs.length-1;
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		for (int i = 0; i <= this.degree; i++) {
			this.coefficients[i] *= factor;
		}
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		// Finds the Polynomial with the lowest degree to keep the loop in bounds
		int x = Math.min(this.degree, p.getDegree());
		// Adds the corresponding value of p to this
		for (int i = 0; i <= x; i++) {
			int sum = this.coefficients[i] + p.coefficients[i];
			this.coefficients[i] = sum;
		}	
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		// Finds the Polynomial with the lowest degree to keep the loop in bounds
		int x = Math.min(this.degree, p.getDegree());
		// Subtracts the corresponding value of p from this
		for (int i = 0; i <= x; i++) {
			int diff = this.coefficients[i] - p.coefficients[i];
			this.coefficients[i] = diff;
		}
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		// If the polynomial has a degree of 0, return a 0 polynomial
	    if (this.degree == 0) {
	        return new Polynomial(new int[]{0});
	    }
	    int[] derivedCoeffs = new int[this.degree];
	    // Calculates the derivative
	    for (int i = 0; i < this.degree; i++) {
	        derivedCoeffs[i] = coefficients[i+1] * (i+1);
	    }
	    // Return the new derived Polynomial
	    return new Polynomial(derivedCoeffs);
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		double sum = 0;
		// Calculates the value of each term and adds it to sum
		for (int i = 0; i <= this.degree; i++) {
			sum += Math.pow(arg, i) * this.coefficients[i];
		}
		return sum; 
	}
	
	@Override
	public String toString() {
		String polyStr = "";
		// Adds all values of a degree greater than 1 to polyStr
		int i = this.degree;
		while (i > 1) {
			polyStr += this.coefficients[i] + "x^" + i + " + ";
			i--;
		}
		// Adds the value with a degree of 1 to polyStr
		if (i == 1) {
			polyStr += this.coefficients[i] + "x + ";
			i--;
		}
		// Adds the value with a degree of 0 to polyStr
		if (i == 0) {
			polyStr += this.coefficients[i];
		}

		return polyStr;
	}
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	
}
