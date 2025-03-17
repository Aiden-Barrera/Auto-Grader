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
		int i = coeffs.length - 1;
		while (i >= 0 && coeffs[i] == 0) {
			i--;
		}
		
		if(i >= 0) {
			coefficients = new int[i + 1];
			System.arraycopy(coeffs, 0, coefficients, 0, i + 1);
			degree = i;
		} else {
			coefficients = new int[] {0};
			degree = 0;
		}
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		if (factor == 0 ) {
			coefficients = new int[] {0};
			degree = 0;
		}
		
		for (int i = 0; i < coefficients.length; i++) {
			coefficients[i] *= factor;
		}
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		int hDegree = Math.max(this.degree, p.degree);
		int [] result = new int[hDegree + 1];
		for (int i = 0; i <= hDegree; i++) {
			int tCo = 0;
			int pCo = 0;
			
			if (i <= this.degree) {
				tCo = this.coefficients[i];
			}
			
			if (i <= p.degree) {
				pCo = p.coefficients[i];
			}
			
			result[i] = tCo + pCo;
		}
		
		this.coefficients = result;
		this.degree = hDegree;
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		int hDegree = Math.max(this.degree, p.degree);
		int [] result = new int[hDegree + 1];
		for (int i = 0; i <= hDegree; i++) {
			int thCoeffs = 0;
			int pCoeffs = 0;
			
			if (i <= this.degree) {
				thCoeffs = this.coefficients[i];
			}
			
			if (i <= p.degree) {
				pCoeffs = p.coefficients[i];
			}
			
			result[i] = thCoeffs - pCoeffs;
		}
		
		this.coefficients = result;
		this.degree = hDegree;
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		if (this.degree == 0) {
			return new Polynomial(new int[]{0});
		}
		
		int[] derivCoeffs = new int[this.degree];
		for (int i = 0; i < this.degree; i++) {
			derivCoeffs[i] = this.coefficients[i + 1] * (i + 1);
		}
		
		return new Polynomial(derivCoeffs);
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		double result = 0;
		for (int i=0; i<=this.degree; i++) {
			result += this.coefficients[i] * Math.pow(arg,  i);
		}
		
		return result;
	}
	@Override
	public String toString() {
		String result = "";

		for (int i = degree; i >= 0; i--) {
			int coeff = coefficients[i];  
		    if (coeff != 0) {
		    	if (result.length() > 0) {
		    		if (coeff > 0) {
		    			result += " + ";
		            } else {
		                result += " - ";
		                coeff = -coeff;
		            }
		        }

		    	if (i == 0) {
		    		result += coeff;
		    	} else if (i == 1) {
		    		result += coeff + "x";
		    	} else {
		    		result += coeff + "x^" + i;
		    	}
		    
		    }
       }
		 
		return result.isEmpty() ? "0" : result;
	}
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	
}
