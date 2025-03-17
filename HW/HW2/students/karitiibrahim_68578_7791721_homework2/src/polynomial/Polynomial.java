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
		int n = coeffs.length;
        
        while (n > 1 && coeffs[n - 1] == 0) {
            n--;
        }
        
        coefficients = new int[n];
        
        for (int i = 0; i < n; i++) {
            coefficients[i] = coeffs[i];
        }
        
        degree = n - 1;
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		for (int i = 0; i <= degree; i++) {
            coefficients[i] *= factor;
        }
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		int maxDegree = Math.max(degree, p.degree);
        int[] newCoeffs = new int[maxDegree + 1];
        
        for (int i = 0; i <= maxDegree; i++) {
            int a = (i <= degree) ? coefficients[i] : 0;
            int b = (i <= p.degree) ? p.coefficients[i] : 0;
            newCoeffs[i] = a + b;
        }
        
        coefficients = newCoeffs;
        degree = maxDegree;
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		int maxDegree = Math.max(degree, p.degree);
        int[] newCoeffs = new int[maxDegree + 1];
        
        for (int i = 0; i <= maxDegree; i++) {
            int a = (i <= degree) ? coefficients[i] : 0;
            int b = (i <= p.degree) ? p.coefficients[i] : 0;
            newCoeffs[i] = a - b;
        }
        
        coefficients = newCoeffs;
        degree = maxDegree;
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		if (degree == 0) {
            return new Polynomial(new int[]{0});
        }
        
        int[] derivCoeffs = new int[degree];
        
        for (int i = 1; i <= degree; i++) {
            derivCoeffs[i - 1] = coefficients[i] * i;
        }
        
        return new Polynomial(derivCoeffs);
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		double result = 0;
        
        for (int i = degree; i >= 0; i--) {
            result = result * arg + coefficients[i];
        }
        
        return result;
	}
	@Override
	public String toString() {
		if (degree == 0 && coefficients[0] == 0) {
            return "0";
        }
        
        String result = "";
        
        for (int i = degree; i >= 0; i--) {
            if (coefficients[i] != 0) {
                if (!result.isEmpty()) {
                    if (coefficients[i] > 0) {
                        result += " + ";
                    } else {
                        result += " - ";
                    }
                } else if (coefficients[i] < 0) {
                    result += "-";
                }
                
                int absCoeff = Math.abs(coefficients[i]);
                
                if (absCoeff != 1 || i == 0) {
                    result += absCoeff;
                }
                
                if (i > 0) {
                    result += "x";
                    
                    if (i > 1) {
                        result += "^" + i;
                    }
                }
            }
        }
        
        return result;
	}
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	
}
