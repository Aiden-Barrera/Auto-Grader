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
		int leadingZeroCount = 0;
		while (leadingZeroCount < coeffs.length && coeffs[leadingZeroCount] == 0)
		{
			leadingZeroCount++;
		}
		if (leadingZeroCount == coeffs.length)
		{
			coefficients = new int[] {0};
			degree = 0;
		}
		else {
			degree = coeffs.length - 1 - leadingZeroCount;
			coefficients = new int[degree + 1];
			for (int i = 0; i <= degree; i++)
			{
				coefficients[i] = coeffs[leadingZeroCount + i];
			}
		}
	}

	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		for (int i = 0; i < coefficients.length; i++)
		{
			coefficients[i] *= factor;
		}
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		int maxDegree = Math.max(this.degree, p.getDegree());
		int[] sumOfCoefficients = new int[maxDegree + 1];
		for (int i = 0; i <= this.degree; i++)
		{
			sumOfCoefficients[i] = this.coefficients[i];
		}
		for (int i = 0; i <= p.getDegree(); i++)
		{
			sumOfCoefficients[i] += p.coefficients[i];
		}
		this.coefficients = sumOfCoefficients;
		this.degree = maxDegree;
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		int maxDegree = Math.max(this.degree, p.getDegree());
		int[] diffOfCoefficients = new int[maxDegree + 1];
		for (int i = 0; i <= this.degree; i++)
		{
			diffOfCoefficients[i] = this.coefficients[i];
		}
		for (int i = 0; i <= p.getDegree(); i++)
		{
			diffOfCoefficients[i] -= p.coefficients[i];
		}
		this.coefficients = diffOfCoefficients;
		this.degree = maxDegree;
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
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
		double result = 0;
		double powerOfVar = 1;
		for (int i = 0; i <= degree; i++) {
			result += coefficients[i] * powerOfVar;
			powerOfVar *= arg;
		}
		return result;
	}
	@Override
	public String toString() {
		String result = "";
		for (int i = degree; i >= 0; i--) {
			if (coefficients[i] != 0) {
				if (!result.isEmpty()) {
					result += coefficients[i] > 0 ? " + " : " - ";
				}
				if (i == 0 || Math.abs(coefficients[i]) != 1) {
					result += Math.abs(coefficients[i]);
				}
				if (i > 0) {
					result += "x";
				}
				if (i > 1) {
					result += "^" + i;
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
