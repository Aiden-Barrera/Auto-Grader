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
		
 	public Polynomial(int[] coeffs) {
 		//trim of last 0 (high degree 0)
 		degree = coeffs.length;
 		int trimEnd = coeffs.length;
 		for (int i = coeffs.length - 1; i >= 0; i--) { 			
			if (coeffs[i] != 0) {
				trimEnd = i + 1;
				degree -= 1;
				break;
			}
			else {
				degree -= 1;
			}
		}
 		coefficients = Arrays.copyOfRange(coeffs, 0, trimEnd); //shallow copy I guess, so when you change the ref, also change here		
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		for (int i = coefficients.length - 1; i > 0; i--) {
			coefficients[i] = factor*coefficients[i];
		}
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
	    for (int i = 0; i < Math.min(this.coefficients.length, p.coefficients.length); i++) {
	        this.coefficients[i] += p.coefficients[i];
	    }
	    if (p.coefficients.length > this.coefficients.length) {
	        int[] newCoefficients = new int[p.coefficients.length];
	        System.arraycopy(this.coefficients, 0, newCoefficients, 0, this.coefficients.length);
	        for (int i = this.coefficients.length; i < p.coefficients.length; i++) {
	            newCoefficients[i] = p.coefficients[i];
	        }
	        this.coefficients = newCoefficients;
	    }
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
	    for (int i = 0; i < Math.min(this.coefficients.length, p.coefficients.length); i++) {
	        this.coefficients[i] -= p.coefficients[i];
	    }
	    // Handle extra coefficients if p is longer
	    if (p.coefficients.length > this.coefficients.length) {
	        int[] newCoefficients = new int[p.coefficients.length];
	        System.arraycopy(this.coefficients, 0, newCoefficients, 0, this.coefficients.length);
	        for (int i = this.coefficients.length; i < p.coefficients.length; i++) {
	            newCoefficients[i] = p.coefficients[i];
	        }
	        this.coefficients = newCoefficients;
	    }
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		int[] result = new int[coefficients.length]; 
		for (int i = coefficients.length - 1; i > 0; i--) {
			result[i-1] = i*coefficients[i];
		}
		return new Polynomial(result);
		//recursion should be effective here
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		double result = 0;
		for (int i = coefficients.length - 1; i >= 0; i--) {
			result += coefficients[i] * Math.pow(arg, i);
		}
		return result; //STUB
	}
	@Override
	public String toString() {
		String result = "";
		for (int i = coefficients.length - 1; i >= 0; i--) {
			if (coefficients[i] != 0) {							//I love how MSFS taught me this short, funny, over complicated notation 
				result += (coefficients[i] > 0 ? " + " : " - " )	
						+ ((Math.abs(coefficients[i]) == 1)	? "x" : ((i == 0) ? (Math.abs(coefficients[i])) : (Math.abs(coefficients[i]) + "x")))
						+ ((i <= 1) ? "" : ("^" + i));
			}
		}
		return result == "" ? " 0 " : result;
	}
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	
}
