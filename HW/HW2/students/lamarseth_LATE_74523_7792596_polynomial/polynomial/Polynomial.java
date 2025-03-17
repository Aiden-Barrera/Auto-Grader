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
		int LIDX = coeffs.length - 1;
		
		while (LIDX > 0 && coeffs[LIDX] == 0) {
			LIDX--;
		}
		degree = LIDX;
		coefficients = new int[degree + 1];
		for (int i = 0; i <= degree; i++) {
            coefficients[i] = coeffs[i];
        }
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
        for (int i = 0; i <= degree; i++) {
            coefficients[i] *= factor;
        }
    }
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
        int maxdeg = Math.max(this.degree, p.degree);
        int[] newco = new int[maxdeg + 1];

        for (int i = 0; i <= maxdeg; i++) {
            int tcoeff = (i <= this.degree) ? this.coefficients[i] : 0;
            int pcoeff = (i <= p.degree) ? p.coefficients[i] : 0;
            newco[i] = tcoeff + pcoeff;
        }
        coefficients = newco;
        degree = maxdeg;
    }
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
        int maxdeg = Math.max(this.degree, p.degree);
        int[] newco = new int[maxdeg + 1];

        for (int i = 0; i <= maxdeg; i++) {
            int tcoeff = (i <= this.degree) ? this.coefficients[i] : 0;
            int pcoeff = (i <= p.degree) ? p.coefficients[i] : 0;
            newco[i] = tcoeff - pcoeff;
        }
        coefficients = newco;
        degree = maxdeg;
    }
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
        if (degree == 0) {
            return new Polynomial();
        }
        int[] derivitivecoef = new int[degree];
        for (int i = 1; i <= degree; i++) {
        	derivitivecoef[i - 1] = coefficients[i] * i;
        }
        return new Polynomial(derivitivecoef);
    }
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
        double res = 0;
        for (int i = 0; i <= degree; i++) {
        	res += coefficients[i] * Math.pow(arg, i);
        }
        return res;
    }
	
	@Override
	public String toString() {
        String result = "";
        for (int i = degree; i >= 0; i--) {
            if (coefficients[i] != 0) {
                if (!result.isEmpty()) {
                    result += (coefficients[i] > 0) ? " + " : " - ";
                } else {
                    result += (coefficients[i] > 0) ? "+ " : "- ";
                }
                int absco = Math.abs(coefficients[i]);
                if (absco != 1 || i == 0) {
                    result += absco;
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
