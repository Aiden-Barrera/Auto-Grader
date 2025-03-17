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
		coefficients = coeffs;
		int i = coefficients.length - 1;
		degree = coefficients.length - 1;
		while (i > 0 && coefficients[i] == 0)
		{
			degree--;
			i--;
		}
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		for (int i = 0; i < coefficients.length; i++)
		{
			coefficients[i] = coefficients[i] * factor;
		}
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		int size = 0;
	    if (coefficients.length > p.coefficients.length) size = coefficients.length;
	    else size = p.coefficients.length;
	    
	    int[] temp = new int[size];
		
		for (int i = 0; i < p.coefficients.length; i++)
		{
			if (i < coefficients.length) temp[i] = coefficients[i] + p.coefficients[i];
			else temp[i] = 0 + p.coefficients[i];
			
			if(temp[i] != 0) degree = i;
		}
		
		coefficients = temp;
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		int size = 0;
	    if (coefficients.length > p.coefficients.length) size = coefficients.length;
	    else size = p.coefficients.length;
	    
	    int[] temp = new int[size];
		
		for (int i = 0; i < p.coefficients.length; i++)
		{
			if (i < coefficients.length) temp[i] = coefficients[i] - p.coefficients[i];
			else temp[i] = 0 - p.coefficients[i];
			
			if(temp[i] != 0) degree = i;
		}
		
		coefficients = temp;
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		int[] temp = new int[coefficients.length - 1];
		for (int i = 0; i < temp.length; i++)
		{
			temp[i] = coefficients[i+1] * (i + 1);
		}
		return new Polynomial(temp);
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		double sum = 0;
		
		for (int i = 0; i < coefficients.length; i++)
		{
			sum += coefficients[i] * arg;
		}
		
		return sum;
	}
	@Override
	public String toString() {
		String result = "";
		for (int i = coefficients.length - 1; i > 0; i--)
		{
			if (coefficients[i] > 0) result += "+ " + coefficients[i] + "x^" + i + " ";
			if (coefficients[i] < 0) result += "- " + Math.abs(coefficients[i]) + "x^" + i + " ";
			
		}
		if (coefficients[0] >= 0) result += "+ " + coefficients[0];
		else result += "- " + Math.abs(coefficients[0]);
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
