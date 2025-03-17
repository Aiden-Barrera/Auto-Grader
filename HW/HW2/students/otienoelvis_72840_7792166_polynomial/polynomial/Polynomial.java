package polynomial;

/**
 * 
 * This class represent a polynomial, 
 * 
 */
import java.util.Arrays;
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
		
		int highestNonZeroIndex = coeffs.length - 1;
        while (highestNonZeroIndex >= 0 && coeffs[highestNonZeroIndex] == 0) {
            highestNonZeroIndex--;
        }
        degree = highestNonZeroIndex;
        coefficients = Arrays.copyOf(coeffs, highestNonZeroIndex + 1);
        
    }

	
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		for (int i = 0; i < coefficients.length; i++) {
            coefficients[i] *= factor;
        }
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		int maxDegree = Math.max(this.degree, p.degree);
        int[] newCoeffs = new int[maxDegree + 1];
        for (int i = 0; i <= maxDegree; i++) {
            int a = (i <= this.degree) ? this.coefficients[i] : 0;
            int b = (i <= p.degree) ? p.coefficients[i] : 0;
            newCoeffs[i] = a + b;
        }
        this.coefficients = newCoeffs;
        this.degree = maxDegree;
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		int maxDegree = Math.max(this.degree, p.degree);
        int[] newCoeffs = new int[maxDegree + 1];
        for (int i = 0; i <= maxDegree; i++) {
            int a = (i <= this.degree) ? this.coefficients[i] : 0;
            int b = (i <= p.degree) ? p.coefficients[i] : 0;
            newCoeffs[i] = a - b;
        }
        this.coefficients = newCoeffs;
        this.degree = maxDegree;	
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		if (degree == 0) return new Polynomial(new int[]{0});
        int[] derivativeCoeffs = new int[degree];
        for (int i = 1; i <= degree; i++) {
            derivativeCoeffs[i - 1] = i * coefficients[i];
        }
        return new Polynomial(derivativeCoeffs);	
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		double result = 0;
        for (int i = 0; i <= degree; i++) {
            result += coefficients[i] * Math.pow(arg, i);
        }
		return result; 
	}
	@Override
	public String toString() {
        StringBuilder sbd = new StringBuilder();
        for (int i = degree; i >= 0; i--) {
            if (coefficients[i] != 0) {
                if (sbd.length() > 0) sbd.append(" + ");
                sbd.append(coefficients[i]).append(i > 0 ? "x^" + i : "");
            }
        }
        return sbd.toString().isEmpty() ? "0" : sbd.toString();
    }
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	
}
