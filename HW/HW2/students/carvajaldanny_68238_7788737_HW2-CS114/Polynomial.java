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
		//TO DO
		int leadingIndex = coeffs.length - 1;
        while (leadingIndex > 0 && coeffs[leadingIndex] == 0) {
            leadingIndex--;
        }
        degree = leadingIndex;
        coefficients = new int[degree + 1];
        for (int i = 0; i <= degree; i++) {
            coefficients[i] = coeffs[i];
        }
		}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		//TO DO
		for(int i = 0;i <= degree; i++) {
			coefficients[i] *= factor;
		}
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		//TO DO
		int degreeMax = Math.max(this.degree, p.degree);
        int[] newCoeffs = new int[degreeMax + 1];
        for (int i = 0; i <= degreeMax; i++) {
            int c1 = 0;
            int c2 = 0;
            if (i <= this.degree) {
                c1 = this.coefficients[i];
            }
            if (i <= p.degree) {
                c2 = p.coefficients[i];
            }
            newCoeffs[i] = c1 + c2;
        }
        this.coefficients = newCoeffs;
        this.degree = degreeMax;
    }
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		//TO DO
		int degreeMax = Math.max(this.degree, p.degree);
        int[] newCoeffs = new int[degreeMax + 1];
        for (int i = 0; i <= degreeMax; i++) {
            int c1 = 0;
            int c2 = 0;
            if (i <= this.degree) {
                c1 = this.coefficients[i];
            }
            if (i <= p.degree) {
                c2 = p.coefficients[i];
            }
            newCoeffs[i] = c1 - c2;
        }
        this.coefficients = newCoeffs;
        this.degree = degreeMax;
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		//TO DO
		if (degree == 0) return new Polynomial(new int[]{0});
        int[] newCoeffs = new int[degree];
        for (int i = 1; i <= degree; i++) {
            newCoeffs[i - 1] = coefficients[i] * i;
        }
		return new Polynomial(newCoeffs); //STUB
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		//TO DO
		 double result = 0;
	        for (int i = 0; i <= degree; i++) {
	            result += coefficients[i] * Math.pow(arg, i);
	        }
		return result; //STUB
	}
	@Override
	public String toString() {
		//TO DO
		StringBuilder sb = new StringBuilder();
        for (int i = degree; i >= 0; i--) {
            if (coefficients[i] == 0) continue;
            if (sb.length() > 0) sb.append(" + ");
            sb.append(coefficients[i]).append("x^").append(i);
        }
		return sb.toString(); //STUB
	}
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	
}
