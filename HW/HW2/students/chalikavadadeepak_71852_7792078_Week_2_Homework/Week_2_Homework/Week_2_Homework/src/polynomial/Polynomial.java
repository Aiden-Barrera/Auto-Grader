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
		int nonZeroIndex = -1;
        for (int i = coeffs.length - 1; i >= 0; i--) {
            if (coeffs[i] != 0) {
                nonZeroIndex = i;
                break;
            }
        }

        if (nonZeroIndex == -1) {
            coefficients = new int[]{0};
            degree = 0;
        } else {
            coefficients = new int[nonZeroIndex + 1];
            System.arraycopy(coeffs, 0, coefficients, 0, nonZeroIndex + 1);
            degree = nonZeroIndex;
        }
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		//TO DO
		for (int i = 0; i <= degree; i++) {
	        coefficients[i] *= factor;
	    }
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		//TO DO
		int maxDegree = Math.max(this.degree, p.getDegree());
	    int[] newCoefficients = new int[maxDegree + 1];

	    for (int i = 0; i <= maxDegree; i++) {
	        int thisCoeff = (i <= this.degree) ? this.coefficients[i] : 0;
	        int pCoeff = (i <= p.getDegree()) ? p.coefficients[i] : 0;
	        newCoefficients[i] = thisCoeff + pCoeff;
	    }

	    this.degree = maxDegree;
	    this.coefficients = newCoefficients;
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		//TO DO
		int maxDegree = Math.max(this.degree, p.getDegree());
	    int[] newCoefficients = new int[maxDegree + 1];

	    for (int i = 0; i <= maxDegree; i++) {
	        int thisCoeff = (i <= this.degree) ? this.coefficients[i] : 0;
	        int pCoeff = (i <= p.getDegree()) ? p.coefficients[i] : 0;
	        newCoefficients[i] = thisCoeff - pCoeff;
	    }

	    this.degree = maxDegree;
	    this.coefficients = newCoefficients;
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		//TO DO
		if (degree == 0) {
	        return new Polynomial(new int[] {0});
	    }
	    
	    int[] newCoefficients = new int[degree];
	    for (int i = 1; i <= degree; i++) {
	        newCoefficients[i - 1] = coefficients[i] * i;
	    }
	    
	    return new Polynomial(newCoefficients);//STUB
		
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		//TO DO
		double result = 0.0;
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
	        if (coefficients[i] != 0) {
	            if (sb.length() > 0 && coefficients[i] > 0) {
	                sb.append(" + ");
	            }
	            if (coefficients[i] < 0) {
	                sb.append(" - ");
	                sb.append(-coefficients[i]);
	            } else {
	                sb.append(coefficients[i]);
	            }
	        } else if (i == 0) {
	            sb.append("0");
	        }
	        
	        if (i > 0 && coefficients[i] != 0) {
	            sb.append("x");
	            if (i > 1) {
	                sb.append("^");
	                sb.append(i);
	            }
	        }
	    }
	    return sb.toString();    }
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	
}
