package polynomial;

import java.util.Arrays;

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
		degree = -1;
		for (int i = coefficients.length - 1; i >= 0; i--) {
	        if (coefficients[i] != 0) {
	            degree = i;
	            break;
	        }
	    }
		if (degree == -1) degree = 0;
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		int index = 0;
		for (int i : coefficients) {
			coefficients[index] = i * factor;
			index++;
		}
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		int[] newCoeffs;
		int[] temp;
		
		if (p.coefficients.length >= coefficients.length) {
			newCoeffs = new int[p.coefficients.length];
			temp = Arrays.copyOf(coefficients, p.coefficients.length);
			
			for (int j = 0 ; j < p.coefficients.length ; j++) {
				int sum = temp[j] + p.coefficients[j];
				newCoeffs[j] = sum;
			}
		} else {
			newCoeffs = new int[coefficients.length];
			temp = Arrays.copyOf(p.coefficients, coefficients.length);
			
			for (int j = 0 ; j < coefficients.length ; j++) {
				int sum = coefficients[j] + temp[j];
				newCoeffs[j] = sum;
			}
		}
		coefficients = newCoeffs;
		degree = -1;
		for (int i = coefficients.length - 1; i >= 0; i--) {
	        if (coefficients[i] != 0) {
	            degree = i;
	            break;
	        }
	    }
		if (degree == -1) degree = 0;
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		int[] newCoeffs;
		int[] temp;
		
		if (p.coefficients.length >= coefficients.length) {
			newCoeffs = new int[p.coefficients.length];
			temp = Arrays.copyOf(coefficients, p.coefficients.length);
			
			for (int j = 0 ; j < p.coefficients.length ; j++) {
				int sum = temp[j] - p.coefficients[j];
				newCoeffs[j] = sum;
			}
		} else {
			newCoeffs = new int[coefficients.length];
			temp = Arrays.copyOf(p.coefficients, coefficients.length);
			
			for (int j = 0 ; j < coefficients.length ; j++) {
				int sum = coefficients[j] - temp[j];
				newCoeffs[j] = sum;
			}
		}
		coefficients = newCoeffs;
		degree = -1;
		for (int i = coefficients.length - 1; i >= 0; i--) {
	        if (coefficients[i] != 0) {
	            degree = i;
	            break;
	        }
	    }
		if (degree == -1) degree = 0;
	}
	
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		if (coefficients.length <= 1) {
	        return new Polynomial(new int[]{0});
	    }
		
		int[] temp = new int[coefficients.length - 1];
		
		for (int i = 1; i < coefficients.length; i++) {
	        temp[i - 1] = coefficients[i] * i;
		}
		
		return new Polynomial(temp); //STUB
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		double y = 0.0;
		for (int i = coefficients.length - 1; i >= 0; i--) {
	        y = y * arg + coefficients[i];
	    }
		return y; //STUB
	}
	
	@Override
	public String toString() {
	    StringBuilder str = new StringBuilder();
	    boolean firstTerm = true;
	    boolean isZeroPoly = true;

	    for (int i = coefficients.length - 1; i >= 0; i--) {
	        if (coefficients[i] != 0) {
	            if (!firstTerm) {
	            	if (coefficients[i] > 0) {
	                    str.append(" + ");
	                } else {
	                    str.append(" ");
	                }
	            }
	            
	            if (i == 0) {
	                str.append(coefficients[i]);
	            } else if (i == 1) {
	                str.append(coefficients[i] + "x");
	            } else {
	                str.append(coefficients[i] + "x^" + i);
	            }
	            firstTerm = false;
	            isZeroPoly = false;
	        }
	    }

	    // If the polynomial is zero, return "0"
	    if (isZeroPoly) {
	        return "0";
	    }

	    return str.toString();
	}

	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	
}
