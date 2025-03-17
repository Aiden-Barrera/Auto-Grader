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
		this.coefficients = coeffs;
		}
		//TO DO
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		for (int i = 0; i < degree; i++) {
            coefficients[i] *= factor;
        }
	}

	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		int maxDegree = Math.max(this.degree, p.degree);
        int[] result = new int[maxDegree + 1];
        for (int i = 0; i <= this.degree; i++) {
            result[i] += this.coefficients[i];
        }
        for (int i = 0; i <= p.degree; i++) {
            result[i] += p.coefficients[i];
        }
        this.coefficients = result;
        this.degree = maxDegree;
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		int maxDegree = Math.max(this.degree, p.degree);
        int[] result = new int[maxDegree + 1];
        for (int i = 0; i <= this.degree; i++) {
            result[i] += this.coefficients[i];
        }
        for (int i = 0; i <= p.degree; i++) {
            result[i] -= p.coefficients[i];
        }
        this.coefficients = result;
        this.degree = maxDegree;
		//TO DO
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		//TO DO
		int[] ChangedCoefficient = new int[degree];
	    for (int i = 1; i <= degree; i++) {
	        ChangedCoefficient[i - 1] = coefficients[i] * i;
	    }

	    return new Polynomial(ChangedCoefficient);
	    }
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		//TO DO
		double result = 0;
		for (int i = 0; i <= degree; i++)
			result += coefficients[i] * (int) Math.pow(arg, i);
		return result; //STUB
	}
	@Override
	public String toString() {
		//TO DO
		String result = null;
		for (int i = 0; i <= degree; i++)
			result = this.coefficients + "x^" + this.degree; //STUB
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
