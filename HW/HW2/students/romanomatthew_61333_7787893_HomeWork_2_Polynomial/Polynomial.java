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
		int d = coeffs.length -1;
		while (d > 0 && coeffs[d] == 0) {
			d--;
		}
		this.degree = d;
        this.coefficients = new int[d + 1];
        for (int i = 0; i <= d; i++) {
            this.coefficients[i] = coeffs[i];
        }

		
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		for(int i = 0; i <= degree; i++) {
			coefficients[i] *= factor;
		}
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		 int maxDegree = Math.max(this.degree, p.degree);
	        int[] newCoeffs = new int[maxDegree + 1];

	        for (int i = 0; i <= maxDegree; i++) {
	            
	        	int thisCoeff;
	            if (i <= this.degree) {
	                thisCoeff = this.coefficients[i];
	            } else {
	                thisCoeff = 0;
	            }

	            int otherCoeff;
	            if (i <= p.degree) {
	                otherCoeff = p.coefficients[i];
	            } else {
	                otherCoeff = 0;
	            }

	            newCoeffs[i] = thisCoeff + otherCoeff;
	        }
	        
	        this.coefficients = newCoeffs;
	        this.degree = maxDegree;
	}

	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		int maxDegree = Math.max(this.degree, p.degree);
        int[] newCoeffs = new int[maxDegree + 1];

        for (int i = 0; i <= maxDegree; i++) {
            int thisCoeff;
            if (i <= this.degree) {
                thisCoeff = this.coefficients[i];
            } else {
                thisCoeff = 0;
            }

            int otherCoeff;
            if (i <= p.degree) {
                otherCoeff = p.coefficients[i];
            } else {
                otherCoeff = 0;
            }

            newCoeffs[i] = thisCoeff - otherCoeff;
        }
        
        this.coefficients = newCoeffs;
        this.degree = maxDegree;

	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		if (degree == 0) { 
			return new Polynomial(new int[]{0});
		}
        int[] newCoeffs = new int[degree];
        for (int i = 1; i <= degree; i++) {
            newCoeffs[i - 1] = coefficients[i] * i;
        }

		return new Polynomial(newCoeffs);
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		double result = 0;
        double temp = 1;
        for (int i = 0; i <= degree; i++) {
            result += coefficients[i] * temp;
            temp *= arg;
        }
        return result;

	}
	@Override
	public String toString() {
		String result = "";
		for (int i = degree; i >= 0; i--) {
	        if (coefficients[i] != 0) {
	            if (!result.equals("") && coefficients[i] > 0) {
	                result += " + ";
	            } else if (coefficients[i] < 0) {
	                result += " - ";
	            }
	            
	            if (coefficients[i] != 1 && coefficients[i] != -1 || i == 0) {
	                result += coefficients[i];
	            }
	            
	            if (i > 0) {
	                result += "x";
	                if (i > 1) result += "^" + i;
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
