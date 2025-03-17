package polynomial;

/**
 * 
 * This class represent a polynomial, 
 * Last edited by: Ramirez, John
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
		coefficients = coeffs;
		degree = 0;

		for (int i = 0; i < coeffs.length; i++) {
			if (coeffs[i] != 0) {
				degree = i;
			}
		} // DONE
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		for (int i = 0; i < coefficients.length; i++) { // Goes through each coefficient and multiplies by factor
			coefficients[i] *= factor;
		} // DONE
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		// If Polynomial p is longer than this instance
		int[] temp;
		if (p.degree > degree) { 
			// A larger temporary list is made to resize this instance's coefficients
			temp = new int[p.coefficients.length];
			for (int i = 0; i < coefficients.length; i++){
				temp[i] = coefficients[i];
			}
			for (int i = 0; i < p.coefficients.length; i++){
				temp[i] += p.coefficients[i];
			}

			// this instance's coefficients is reassigned to temp post-addition
			coefficients = temp;
		}

		/* If this instance's coefficients is longer or equal 
		to Polynomial p's list */
		else {	
			for (int i = 0; i < p.coefficients.length; i++){
				coefficients[i] += p.coefficients[i];
			}	
		} 
		
		// Recalibrates the degree of this Polynomial instance
		for (int i = 0; i < coefficients.length; i++) {
			if (coefficients[i] != 0) {
				degree = i;
			}
		}// DONE
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		// If Polynomial p is longer than this instance
		if (p.degree > degree) { 
			// temporary list is made
			int[] temp = new int[p.coefficients.length];
			for (int i = 0; i < coefficients.length; i++){
				temp[i] = coefficients[i];
			}
			for (int i = 0; i < p.coefficients.length; i++){
				temp[i] -= p.coefficients[i];
			}

			// coefficients is reassigned with temp post-subtraction
			coefficients = temp; 
		}

		// If this instance's coefficients is longer or equal to Polynomial p's list
		else { 
			for (int i = 0; i < p.coefficients.length; i++){
				coefficients[i] -= p.coefficients[i];
			}	
		} 
		
		// Recalibrates the degree of this instance
		for (int i = 0; i < coefficients.length; i++) {
			if (coefficients[i] != 0) {
				degree = i;
			}
		}// DONE
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		int[] derivativeCoeffs = new int[coefficients.length - 1]; //The 0 index is a constant, derivative of a constant is 0, hence the length - 1
		
		for (int i = 1; i < coefficients.length; i++){
			derivativeCoeffs[i-1] = coefficients[i] * i;
		}
		
		Polynomial derivPolynomial = new Polynomial(derivativeCoeffs);
		return derivPolynomial; // DONE
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		double result = 0;
		for (int i = degree; i > -1; i--) {
			result = result + Math.pow(arg,i) * coefficients[i];
		}
		return result; //DONE
	}
	@Override
	public String toString() {
		String polynomialStr = "";
		
		/* For loop iterates through each term up to the degree as the
		 * variable displays the highest degree with a nonzero coefficient
		 */
		for (int i = degree; i > -1; i--) {
			// if the coefficient is 0, it is not considered
			if (coefficients[i] != 0) {
				// Default state of the term is ax^n
				String term = String.format("%dx^%d", Math.abs(coefficients[i]),i);
				
				// At degree one, the power is removed
				if (i == 1) { 
					term = term.substring(0,term.indexOf("^"));
				}

				// At degree 0, it is just the coefficient
				else if (i == 0) {
					term = Integer.toString(Math.abs(coefficients[i]));
				}

				// At degrees past 1, if the coefficient is 1, it is removed from the string
				else {
					if (coefficients[i] == 1 ) {
						term = term.substring(term.indexOf("x"));
					}
				}

				// The sign is finally added before being appended to polynomialStr
				if (coefficients[i] < 0) {
					term = " - " + term;
				}
				else {
					term = " + " + term;
				}

				polynomialStr += term;
			}
		}


		/* If the string is still empty, it means that the polynomial
		 * is degree 0 and therefore returns "0" 
		 */
		if (polynomialStr == "") {
			return "0";
		}
		return polynomialStr; //DONE
	}
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	
}
