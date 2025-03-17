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
		if (coeffs == null || coeffs.length == 0) {
            coefficients = new int[] {0};
            degree = 0;
        } else {
            // Remove leading zeros and determine the degree
            int d = coeffs.length - 1;
            while (d > 0 && coeffs[d] == 0) {
                d--;
            }
            degree = d;
            coefficients = new int[d + 1];
            for (int i = 0; i <= d; i++) {
                coefficients[i] = coeffs[i];
            }
        }
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		//TO DO
		 if (factor == 0) {
	            coefficients = new int[] {0};
	            degree = 0;
	        } else {
	            for (int i = 0; i <= degree; i++) {
	                coefficients[i] *= factor;
	            }
	        }
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		//TO DO
		int maxDegree = Math.max(this.degree, p.degree);
        int[] newCoeffs = new int[maxDegree + 1];
        for (int i = 0; i <= maxDegree; i++) {
            int thisCoeff = (i <= this.degree) ? this.coefficients[i] : 0;
            int pCoeff = (i <= p.degree) ? p.coefficients[i] : 0;
            newCoeffs[i] = thisCoeff + pCoeff;
        }
        this.coefficients = newCoeffs;
        this.degree = maxDegree;
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		//TO DO
		int maxDegree = Math.max(this.degree, p.degree);
        int[] newCoeffs = new int[maxDegree + 1];
        for (int i = 0; i <= maxDegree; i++) {
            int thisCoeff = (i <= this.degree) ? this.coefficients[i] : 0;
            int pCoeff = (i <= p.degree) ? p.coefficients[i] : 0;
            newCoeffs[i] = thisCoeff - pCoeff;
        }
        this.coefficients = newCoeffs;
        this.degree = maxDegree;
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		//TO DO
		if (this.degree == 0) {
            return new Polynomial(new int[] {0});
        }
        int[] derivativeCoeffs = new int[this.degree];
        for (int i = 1; i <= this.degree; i++) {
            derivativeCoeffs[i - 1] = this.coefficients[i] * i;
        }
        return new Polynomial(derivativeCoeffs);
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		double result = 0;
        double power = 1;
        for (int i = 0; i <= this.degree; i++) {
            result += this.coefficients[i] * power;
            power *= arg;
        }
        return result;
	}
	@Override
	public String toString() {
		//TO DO
		StringBuilder sb = new StringBuilder();
        for (int i = degree; i >= 0; i--) {
            if (coefficients[i] != 0) {
                if (sb.length() > 0) {
                    sb.append(coefficients[i] > 0 ? " + " : " - ");
                } else if (coefficients[i] < 0) {
                    sb.append("-");
                }
                int absCoeff = Math.abs(coefficients[i]);
                if (absCoeff != 1 || i == 0) {
                    sb.append(absCoeff);
                }
                if (i > 0) {
                    sb.append("x");
                    if (i > 1) {
                        sb.append("^").append(i);
                    }
                }
            }
        }
        return sb.length() > 0 ? sb.toString() : "0";
	}
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	
}
