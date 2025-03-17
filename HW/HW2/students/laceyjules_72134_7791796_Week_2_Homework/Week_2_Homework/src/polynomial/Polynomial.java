package polynomial;

/**
 * 
 * This class represent a polynomial, 
 * 
 */

/**
 * NOTE !!!! coefficients are represented in an array where the value at the first index has the highest !!!! degree
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
		//TO DO
		coefficients = coeffs;
		degree = coeffs.length - 1;
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		//TO DO
		for (int i = 0; i < coefficients.length; i++) {
			coefficients[i] = coefficients[i] * factor;
		}
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		//TO DO
		int counter = 0;
		for (int i = p.degree; i >= 0; i--) {
			this.coefficients[degree-i] += p.coefficients[counter];
			counter++;
		}
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		//TO DO
		int counter = 0;
		for (int i = p.degree; i >= 0; i--) {
			this.coefficients[degree-i] -= p.coefficients[counter];
			counter++;
		}
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		//TO DO
		int[] coeff2 = new int[coefficients.length-1];
		for (int i = 0; i < degree; i++) {
			coeff2[i] = coefficients[i] * (degree-i);
		}
		return new Polynomial(coeff2);
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		//TO DO
		double val = 0.0;
		
		for (int i = 0; i < coefficients.length; i++) {
			if (degree-i != 0) {
				val += coefficients[i] * (Math.pow(arg, degree-i));
			}
			else {
				val+= coefficients[i];
			}
		}
		return val;
	}
	@Override
	public String toString() {
		//TO DO
		String str = "";
		for (int i = 0; i < coefficients.length; i++) {
			if (degree - i == 1) {
				str += coefficients[i] + "x + ";
			}
			else if (degree - i == 0) {
				str+=coefficients[i];
			}
			else {
				str+= coefficients[i] + "x^" + (degree-i) + " + ";
			}
		}
		return str;
	}
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	
}
