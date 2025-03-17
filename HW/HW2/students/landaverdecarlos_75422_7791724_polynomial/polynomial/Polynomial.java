package polynomial;
import java.lang.Math;

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
		degree = 0;
		coefficients = coeffs;
		for (int i = 0; i < coefficients.length; i++) {
			if (coefficients[i] != 0) {
				degree = i;
			}
		}
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		for (int i = 0; i < coefficients.length; i++) {
			coefficients[i] *= factor;
		}
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		for (int i = 0; i < coefficients.length; i++) {
			if ((i + 1) > p.coefficients.length) {
				break;
			}
			else {
				coefficients[i] += p.coefficients[i];
			}
		}
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		for (int i = 0; i < coefficients.length; i++) {
			if ((i + 1) > p.coefficients.length) {
				break;
			}
			else {
				coefficients[i] -= p.coefficients[i];
			}
		}
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		Polynomial derivative = new Polynomial(new int[coefficients.length - 1]);
		for (int i = 1; i < coefficients.length; i++) {
			derivative.coefficients[i - 1] = i * coefficients[i]; 
		}
		return derivative;
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		double total = 0;
		for (int i = 0; i < coefficients.length; i++) {
			total += Math.pow(arg, i) * coefficients[i];
		}
		return total;
	}
	@Override
	public String toString() {
		String polystring = "";
		boolean allZeroes = true;
		for (int i = coefficients.length - 1; i >= 0; i--) {
			String coefficientSign = "+";
			if (coefficients[i] < 0) {
				coefficientSign = "-";
			}
			if (i > 0) {
				if (coefficients[i] != 0) {
					allZeroes = false;
					if (coefficients[i] < 0) {
						polystring += coefficientSign + " " + (-1 * coefficients[i]) + "x^" + i + " ";
					}
					else {
						polystring += coefficientSign + " " + coefficients[i] + "x^" + i + " ";
					}
					
				}
				
			}
			else {
				if ((coefficients[i] != 0) || (allZeroes)) {
					if (coefficients[i] < 0) {
						polystring += coefficientSign + " " + (-1 * coefficients[i]) + " ";
					}
					else {
						polystring += coefficientSign + " " + coefficients[i] + " ";
					}
				}
				
			}
			
		}
		return polystring; 
	}
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	
}
