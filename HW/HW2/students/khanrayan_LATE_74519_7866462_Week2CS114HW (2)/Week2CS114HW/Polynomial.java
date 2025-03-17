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
		degree = 0;
		
		for (int i = coeffs.length-1; i>=0; i--)
		{
			if (coeffs[i] != 0)
			{
				degree = i;
				break;
			}
		}
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		
		//TO DO
		for (int i = 0; i < coefficients.length; i++)
		{
			coefficients[i]*=factor;
		}
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		//TO DO
		int [] arr1;
		int [] arr2;
		int [] res;
	
		
		if (this.coefficients.length >= p.coefficients.length)
		{
			arr1 = new int[this.coefficients.length];
			arr2 = new int[this.coefficients.length];
			res = new int[this.coefficients.length];
		}
		
		else
		{
			arr1 = new int[p.coefficients.length];	
			arr2 = new int[p.coefficients.length];
			res = new int[p.coefficients.length];
		}
		
		for (int i = 0; i<p.coefficients.length; i++)
		{
			arr1[i] = p.coefficients[i];
		}
		
		for (int i = 0; i<this.coefficients.length; i++)
		{
			arr2[i] = this.coefficients[i];
		}	
		
		for (int i = 0; i < arr1.length; i++)
		{
			res[i] = arr1[i]+arr2[i];
		}
		
		this.coefficients = res;
		new Polynomial(res);
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		//TO DO
		Polynomial a = p;
		a.multiplyBy(-1);
		this.add(a);	
	}
	
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		//TO DO
		int [] deriv = new int[this.coefficients.length-1];
		
		for (int i = this.coefficients.length-2; i >= 0; i--)
		{
			deriv[i] = this.coefficients[i+1]*(i+1);
		}
		
		Polynomial derivative = new Polynomial(deriv);
		return derivative;
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		//TO DO
		float sum = this.coefficients[0];
		
		for (int i = 1; i < this.coefficients.length; i++)
		{
			sum += this.coefficients[i]*Math.pow(arg, i);
		}
		
		return sum;
	}
	@Override
	public String toString() {
		//TO DO
		String res = "";
		boolean empty = true;
		
		for (int i = 0; i < this.coefficients.length; i++)
		{
			if (this.coefficients[i] != 0)
			{
				empty = false;
				break;
			}
		}
		
		if (empty == true)
		{
			return "0";
		}
		
		for (int i = this.coefficients.length - 1; i>=0;i--)
		{
			
			if (this.coefficients[i] == 0)
			{
				continue;
			}
			
			if (this.coefficients[i] > 0)
			{
				res+="+ ";
			}
			
			else
			{
				res+="- ";
			}
			
			String coeff = "";
			
			if (Math.abs(this.coefficients[i]) != 1)
			{
				coeff += Math.abs(this.coefficients[i]);;
			}
			
			if (i > 1)
			{
				res+=coeff + "x^" + i + " ";
			}
			
			else if (i == 1)
			{
				res+=coeff + "x ";
			}
			
			else
			{
				res+=coeff;
			}
		}
		
		return res;
	}
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	
}
