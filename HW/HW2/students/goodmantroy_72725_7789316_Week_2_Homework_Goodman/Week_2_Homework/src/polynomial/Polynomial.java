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
			coefficients = new int[] {0};
			degree = 0;
		}
		else {
			coefficients = coeffs;
			degree = coeffs.length-1;
			while(degree > 0 && coefficients[degree] == 0) {
				degree --;
			}
		}
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		for(int i = 0; i <=degree; i++) {
			coefficients[i] *= factor;
		}
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
       int maxDegree = Math.max(this.degree, p.degree);
       int[] newPolynomial = new int[maxDegree + 1];
       for (int i = 0; i <= this.degree; i++) {
           newPolynomial[i] = this.coefficients[i];
       }
       for (int i = 0; i <= p.degree; i++) {
           newPolynomial[i] += p.coefficients[i];
       }
       this.coefficients = newPolynomial;
       this.degree = maxDegree;
       while (this.degree > 0 && this.coefficients[this.degree] == 0) {
           this.degree--;
       }
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		int maxDegree = Math.max(this.degree, p.degree);
       int[] newPolynomial = new int[maxDegree + 1];
       for (int i = 0; i <= this.degree; i++) {
           newPolynomial[i] = this.coefficients[i];
       }
       for (int i = 0; i <= p.degree; i++) {
           newPolynomial[i] -= p.coefficients[i];
       }
       this.coefficients = newPolynomial;
       this.degree = maxDegree;
       while (this.degree > 0 && this.coefficients[this.degree] == 0) {
           this.degree--;
       }
	}
	
	 /* Returns the polynomial derivative of this polynomial.
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		if (degree == 0) {
			return new Polynomial(new int[] {0});
		}
		
		int[] derivativeCoeffs = new int[degree];
		
		for (int i = 1; i<=degree; i++) {
			derivativeCoeffs[i-1] = i*coefficients[i];
		}
		
		return new Polynomial(derivativeCoeffs);
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		double result = 0;
		for(int i = 0; i<= degree; i++) {
			result += coefficients[i] * Math.pow(arg, i);
		}
		return result;
	}
	@Override
	public String toString() {
		StringBuilder stringBuild = new StringBuilder();
		
		for(int i = degree; i >=0; i--) {
			if (coefficients[i] == 0) {
				continue;
			}
			if (i == 0) {
				if (coefficients[i] > 0) {
					stringBuild.append(" + "+coefficients[i]);
				}
				else {
					stringBuild.append(" "+coefficients[i]);
				}
			}
			else if (i == 1) {
				if (coefficients[i] == 1) {
					stringBuild.append(" + x ");
				}
				else if (coefficients[i] > 1) {
					stringBuild.append(" + "+coefficients[i]+"x");
				}
				else {
					stringBuild.append(" "+coefficients[i]+"x");
				}
			}
			else{
				if (coefficients[i] == 1) {
					stringBuild.append(" + x^"+i);
				}
				else if (coefficients[i] > 1) {
					stringBuild.append(" + "+coefficients[i]+"x^"+i);
				}
				else {
					stringBuild.append(" "+coefficients[i]+"x^"+i);
				}
			}
		}
		
		if (stringBuild.length()==0) {
			return "0";
		}
			
		return stringBuild.toString(); //STUB
	}
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	
}

