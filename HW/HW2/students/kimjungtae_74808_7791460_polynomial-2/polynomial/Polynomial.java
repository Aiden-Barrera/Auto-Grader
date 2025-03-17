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
		 coefficients = coeffs;
		 int biggestDegree = 0;
		 for (int i = 0; i < coeffs.length; i++) {
			 if (coeffs[i] != 0) {
				 biggestDegree = i;
			 }
		 }
		 degree = biggestDegree;
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		for (int i = 0; i < coefficients.length; i++) {
			coefficients[i] = coefficients[i] * factor;
		}
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		int maxlength = Math.max(coefficients.length, p.coefficients.length);
		int[] newArray = new int[maxlength];
		for (int i = 0; i < maxlength; i++) {
	        if (i < coefficients.length && i < p.coefficients.length) {
	            newArray[i] = coefficients[i] + p.coefficients[i];
	        }
	        else if (i < coefficients.length) {
	            newArray[i] = coefficients[i];
	        }
	        else if (i < p.coefficients.length) {
	            newArray[i] = p.coefficients[i];
	        }
	    }
	    
	    coefficients = newArray;
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		int maxlength = Math.max(coefficients.length, p.coefficients.length);
		int[] newArray = new int[maxlength];
		for (int i = 0; i < maxlength; i++) {
	        if (i < coefficients.length && i < p.coefficients.length) {
	            newArray[i] = coefficients[i] - p.coefficients[i];
	        }
	        else if (i < coefficients.length) {
	            newArray[i] = coefficients[i];
	        }
	        else if (i < p.coefficients.length) {
	            newArray[i] = -p.coefficients[i];
	        }
	    }
	    
	    coefficients = newArray;
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		int[] derivative = new int[coefficients.length - 1];
		for (int i = 1; i < coefficients.length; i++) {
			derivative[i - 1] = coefficients[i] * i;
		}
		return new Polynomial(derivative);
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		int result = 0;
		for (int i = 0; i < coefficients.length; i++) {
	        result += coefficients[i] * Math.pow(arg, i); 
		}
		return result;
	}
	@Override
	public String toString() {
		String format = "";
		for (int i = coefficients.length - 1; i >= 0; i--) {
			if (coefficients[i] == 0) {
				continue;
			}
			if (coefficients[i] == 1) {
				if (i == 1) {
					if (coefficients[i] < 0) {
						format += " - " + -coefficients[i] + "x";
						continue;
					}
					if (coefficients[i] > 0) {
						format += " + " + coefficients[i] + "x";
						continue;
					}
				}
				format += " + x^" + i;
				continue;
			}
			if (coefficients[i] == -1) {
				if (i == 1) {
					if (coefficients[i] < 0) {
						format += " - x";
						continue;
					}
					if (coefficients[i] > 0) {
						format += " + x";
						continue;
					}
				}
				format += " - x^" + i;
				continue;
			}
			if (i == 0) {
				if (coefficients[i] < 0) {
					format += " - " + -coefficients[i];
					continue;
				}
				if (coefficients[i] > 0) {
					format += " + " + coefficients[i];
					continue;
				}
			}
			if (i == 1) {
				if (coefficients[i] < 0) {
					format += " - " + -coefficients[i] + "x";
					continue;
				}
				if (coefficients[i] > 0) {
					format += " + " + coefficients[i] + "x";
					continue;
				}
			}
			if (coefficients[i] < 0) {
				format += " - " + -coefficients[i] + "x^" + i;
				continue;
			}
			if (coefficients[i] > 0) {
				format += " + " + coefficients[i] + "x^" + i;
				continue;
			}
			
		}
		return format; //STUB
	}
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	
}
