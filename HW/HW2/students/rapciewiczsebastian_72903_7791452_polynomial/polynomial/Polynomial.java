package polynomial;

/**
 * 
 * This class represent a polynomial, 
 * 
 */
public class Polynomial 
{
	protected int[] coefficients;
	protected int degree;
	
	public Polynomial() 
	{
		// Default polynomial is 0
		coefficients = new int[] {0};
		degree = 0;
	}
		
	/* Construct the polynomial given it's coefficients */ 
	public Polynomial(int[] coeffs) 
	{
		//TO DO
		coefficients = coeffs;
		int largestDegree = 0;
		for(int i = 0; i < coeffs.length; i++)
		{
			if(coeffs[i] != 0)
			{
				largestDegree = i;
			}
		}
		degree = largestDegree;
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) 
	{
		//TO DO
		for(int i = 0; i < coefficients.length; i++)
		{
			coefficients[i] *= factor;
		}
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) 
	{
		int greaterLength = 0;
		
		if (p.coefficients.length > this.coefficients.length)
		{
			greaterLength = p.coefficients.length;
		}
		else
		{
			greaterLength = this.coefficients.length;
		}
		
		int[] newCoeffs = new int[(greaterLength + 1)];
		
		for (int i = 0; i < this.coefficients.length; i++) 
		{
		    newCoeffs[i] = this.coefficients[i];
		}
		for (int i = 0; i < p.coefficients.length; i++) 
		{
		    newCoeffs[i] += p.coefficients[i];
		}
		
		coefficients = newCoeffs;
		
		int greaterDegree = 0;
		
		if (p.degree > this.degree)
		{
			greaterDegree = p.degree;
		}
		else
		{
			greaterDegree = this.degree;
		}
		this.degree = greaterDegree;
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) 
	{
		//TO DO
		int greaterLength = 0;
		
		if (p.coefficients.length > this.coefficients.length)
		{
			greaterLength = p.coefficients.length;
		}
		else
		{
			greaterLength = this.coefficients.length;
		}
		
		int[] newCoeffs = new int[(greaterLength + 1)];
		
		for (int i = 0; i < this.coefficients.length; i++) 
		{
		    newCoeffs[i] = this.coefficients[i];
		}
		for (int i = 0; i < p.coefficients.length; i++) 
		{
		    newCoeffs[i] -= p.coefficients[i];
		}
		
		coefficients = newCoeffs;
		
		int greaterDegree = 0;
		
		if (p.degree > this.degree)
		{
			greaterDegree = p.degree;
		}
		else
		{
			greaterDegree = this.degree;
		}
		this.degree = greaterDegree;
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() 
	{
		//TO DO
		int[] derCoeffs = new int[coefficients.length - 1];
		for(int i = 1; i < coefficients.length; i++)
		{
			derCoeffs[i - 1] = coefficients[i] * i;
		}
		return (new Polynomial(derCoeffs)); //STUB
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) 
	{
		//TO DO
		double ans = coefficients[0];
		for(int i = 1; i <= degree; i++)
		{
			ans += coefficients[i] * Math.pow(arg, i);
		}
		return ans; //STUB
	}
	@Override
	public String toString() 
	{
		//TO DO
		if(degree == 0 && coefficients[0] == 0)
		{
			return "" + 0;
		}
		
		String poly = "";
		for(int i = degree; i >= 1; i--)
		{
			if(coefficients[i] != 0)
			{
				if(coefficients[i] > 0)
				{
					poly += "+ ";
					if(coefficients[i] == 1 || coefficients[i] == -1)
					{
						poly += "x";
					}
					else
					{
						poly += coefficients[i] + "x";
					}
				}
				else
				{
					poly += "- ";
					if(coefficients[i] == 1 || coefficients[i] == -1)
					{
						poly += "x";
					}
					else
					{
						poly += coefficients[i] * -1 + "x";
					}
				}
				if(i != 1)
				{
					poly += "^" + i + ' ';
				}
				else
				{
					poly += ' ';
				}
			}
		}
		
		if(coefficients[0] != 0)
		{
			if(coefficients[0] > 0)
			{
				poly += "+ ";
				poly += coefficients[0];
			}
			else
			{
				poly += "- ";
				poly += coefficients[0] * -1;
			}
		}
		return poly; //STUB
	}
	
	public int getDegree() 
	{
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() 
	{
		return null;
	}
	
}
