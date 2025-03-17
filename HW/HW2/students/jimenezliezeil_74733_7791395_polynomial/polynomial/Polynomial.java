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
		coefficients = coeffs;
		for (int i = this.coefficients.length - 1; i >= 0; i--) {
			if (this.coefficients[i] != 0) {
				degree = i;
				break;
			} else {
				degree = 0;
			}
		}
		
		
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		//TO DO
		for (int i = 0; i < coefficients.length; i++) {
			coefficients[i] = coefficients[i] * factor; 
		}
		if (factor == 0) {
		    coefficients = new int[]{0};
		    degree = 0;
		} 
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		//TO DO
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
		//TO DO
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
		//TO DO
        if (degree == 0) {
            return new Polynomial(new int[]{0});
        }
        int[] derivativeCoeffs = new int[degree];
        for (int i = 1; i <= degree; i++) {
            derivativeCoeffs[i - 1] = coefficients[i] * i;
        }
        return new Polynomial(derivativeCoeffs);
		
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		//TO DO
        double result = 0;
        double power = 1;
        for (int coeff : coefficients) {
            result += coeff * power;
            power *= arg;
        }
        return result;
	}
	@Override
	public String toString() {
		//TO DO
		String str = "";
		int sum = 0;
		for (int num: this.coefficients) {
			sum += num;
		}
		if (sum == 0) {
			return "0";
		}
		for (int i = this.coefficients.length - 1; i >= 0 ; i--) {
			if (coefficients[i] > 0) {
				str += "+ " ;
			} else if (coefficients[i] < 0) {
				str += "- " ;
			} else {
				continue;
			}
			if (coefficients[i] != 1 && coefficients[i] != -1) {
				str += Math.abs(coefficients[i]);
			}
			if (i > 0) {
				str += "x";
				if (i != 1 && i != -1) {
					str += "^" + i;
				}
			}
			
			str += " "; 
		}
		return str;
	}
	
	public int getDegree() {
		return degree;
	}
	
	public int[] getCoeffs() {
		return coefficients;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	
}
