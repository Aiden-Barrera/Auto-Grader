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
		coefficients = new int[coeffs.length];
		
		for (int x = 0; x < coeffs.length; x++)
			coefficients[x] = coeffs[x];
		
		int degreeindex = coeffs.length -1;
		
		while (true)
		{
		if (coeffs[degreeindex] != 0 || degreeindex <= 0)
			{
			degree = degreeindex;
		    break;
			}
		else
			degreeindex--;
		}
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		for (int x = 0; x < coefficients.length;x++)
			coefficients[x] *= factor;
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		for (int x = 0; x < p.coefficients.length; x++)
			this.coefficients[x] += p.coefficients[x];
		
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		for (int x = 0; x < p.coefficients.length; x++)
			this.coefficients[x] -= p.coefficients[x];
	}
	
	 /* Returns the polynomial derivative of this polynomial.
	 * Does NOT change this polynomial */
	public Polynomial getDerivative(){
		int[] derivative = new int[this.coefficients.length];
		for (int x = derivative.length-1; x >= 1; x--)
			derivative[x-1] = coefficients[x]*x;
		return (new Polynomial(derivative)); //STUB
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		double result = 0;
		for (int x = 1; x < coefficients.length; x++)
			result += (Math.pow(arg,x)*coefficients[x]);
		
		result += coefficients[0];
		return result;
	}
	@Override
	public String toString() {
		String s = "";
		for (int x = coefficients.length - 1; x >= 1; x--)
		{
			if (coefficients[x] < 0)
			s +=  coefficients[x] + "x" + "^" + x + " ";
		
			else if (coefficients[x] > 0)
			s += "+ " + coefficients[x] + "x" + "^" + x + " ";
		}
		
		if (coefficients[0] < 0)
			s+= coefficients[0];
		
		else if (coefficients[0] > 0)
		s+= "+ " + coefficients[0];
		
		return s;
	}
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}

	
}
