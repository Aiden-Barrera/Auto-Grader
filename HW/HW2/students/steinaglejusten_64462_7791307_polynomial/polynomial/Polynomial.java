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
		if (coeffs == null || coeffs.length == 0) {
			coefficients = new int [] {0};
			degree = 0;
		}
		else {
			int d =coeffs.length -1;
			while (d > 0 && coeffs [d] == 0) {
				d--;
			}
			degree = d;
			coefficients = new int[d+1];
			for (int i =0; i<=d; i++) {
				coefficients[i] = coeffs[i];
			}
		}
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		for (int i = 0; i < coefficients.length; i++) {
            coefficients[i] *= factor;
        }
        
        if (factor == 0) {
            coefficients = new int[] {0};
            degree = 0;
        } else {
            
            int d = coefficients.length - 1;
            while (d > 0 && coefficients[d] == 0) {
                d--;
            }
            degree = d;
            if (d + 1 != coefficients.length) {
                int[] trimmed = new int[d + 1];
                for (int i = 0; i <= d; i++) {
                    trimmed[i] = coefficients[i];
                }
                coefficients = trimmed;
            }
        }
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		int maxLength = Math.max(this.coefficients.length, p.coefficients.length);
        int[] result = new int[maxLength];
        
        for (int i = 0; i < maxLength; i++) {
            int a = (i < this.coefficients.length ? this.coefficients[i] : 0);
            int b = (i < p.coefficients.length ? p.coefficients[i] : 0);
            result[i] = a + b;
        }

        int d = maxLength - 1;
        while (d > 0 && result[d] == 0) {
            d--;
        }
        degree = d;
        int[] trimmed = new int[d + 1];
        for (int i = 0; i <= d; i++) {
            trimmed[i] = result[i];
        }
        coefficients = trimmed;
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		int maxLength = Math.max(this.coefficients.length, p.coefficients.length);
        int[] result = new int[maxLength];
        
        for (int i = 0; i < maxLength; i++) {
            int a = (i < this.coefficients.length ? this.coefficients[i] : 0);
            int b = (i < p.coefficients.length ? p.coefficients[i] : 0);
            result[i] = a - b;
        }
        int d = maxLength - 1;
        while (d > 0 && result[d] == 0) {
            d--;
        }
        degree = d;
        int[] trimmed = new int[d + 1];
        for (int i = 0; i <= d; i++) {
            trimmed[i] = result[i];
        }
        coefficients = trimmed;
    }
    
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		if (degree == 0) {
			return new Polynomial(new int[]{0});
	    }
	    int[] derivCoeffs = new int[degree];  // derivative of degree n is degree n-1
	    for (int i = 1; i <= degree; i++) {
	    	derivCoeffs[i - 1] = i * coefficients[i];
	    }
	    return new Polynomial(derivCoeffs);
	}
	
	/* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public float atPoint(float arg) {
		float result = 0;
        float term = 1;
        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i] * term;
            term *= arg;
        }
        return result;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
        boolean firstTerm = true;
        for (int i = degree; i >= 0; i--) {
            int coef = coefficients[i];
            if (coef == 0)
                continue;
            
            if (firstTerm) {
                if (coef < 0)
                    sb.append("-");
                firstTerm = false;
            } else {
                if (coef < 0)
                    sb.append(" - ");
                else
                    sb.append(" + ");
            }
            
            int absCoef = Math.abs(coef);
            if (i == 0) { 
                sb.append(absCoef);
            } else {
                if (absCoef != 1)
                    sb.append(absCoef);
                sb.append("x");
                if (i != 1)
                    sb.append("^").append(i);
            }
        }
        if (firstTerm) { 
            return "0";
        }
        return sb.toString();
	}
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public float[] solve() {
		return null;
	}
	
}
