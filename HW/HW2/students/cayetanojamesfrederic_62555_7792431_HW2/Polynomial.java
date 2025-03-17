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
		int notZeroIndex = -1;
		for(int i = coeffs.length - 1; i >= 0; i--)
		{
			if(coeffs[i] != 0)
			{
				notZeroIndex = i;
				break;
			}
		}
		
		if(notZeroIndex == -1)
		{
			coefficients = new int[] {0};
			degree = 0;
		}
		else
		{
			coefficients = new int[notZeroIndex + 1];
			
			for(int i = 0; i <= notZeroIndex; i++)
			{
				coefficients[i] = coeffs[i];
			}
			
			degree = notZeroIndex;
		}
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		for(int i = 0; i <= degree; i++)
		{
			coefficients[i] *= factor;
		}
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		int biggerDegree = Math.max(this.degree, p.degree);
		
		int[] totalCoefficient = new int[biggerDegree + 1];
		
		for(int i = 0; i <= this.degree; i++)
		{
			totalCoefficient[i] += this.coefficients[i];
		}
		
		for(int i = 0; i <= p.degree; i++)
		{
			totalCoefficient[i] += p.coefficients[i];
		}
		
		this.coefficients = totalCoefficient;
		this.degree = biggerDegree;
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		int biggerDegree = Math.max(this.degree, p.degree);
		
		int[] totalCoefficient = new int[biggerDegree + 1];
		
		for(int i = 0; i <= this.degree; i++)
		{
			totalCoefficient[i] -= this.coefficients[i];
		}
		
		for(int i = 0; i <= p.degree; i++)
		{
			totalCoefficient[i] -= p.coefficients[i];
		}
		
		this.coefficients = totalCoefficient;
		this.degree = biggerDegree;
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		if(this.degree == 0)
		{
			return new Polynomial(new int[] {0});
		}
		
		int[] derivativeCoefficients = new int[this.degree];
		
		for(int i = 0; i < this.degree; i++)
		{
			int newCoefficient = this.coefficients[i] * (this.degree - i);
			derivativeCoefficients[i] = newCoefficient;
		}
		
		return new Polynomial(derivativeCoefficients);
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		double result = 0;
		
		for(int i = 0; i <= degree; i++)
		{
			result = result * arg + this.coefficients[i];
		}
		return result;
	}
	
	@Override
	public String toString() {
		if(this.degree == 0 && this.coefficients[0] == 0)
		{
			return "0";
		}
		
		String result = "";
		
		for(int i = this.degree; i >= 0; i--)
		{
			int coefficient = this.coefficients[i];
			if(coefficient != 0)
			{
				if(!result.isEmpty())
				{
					if(coefficient > 0)
					{
						result += " + ";
					}
					else
					{
						result += " - ";
					}
				}
				else if(coefficient < 0)
				{
					result += " - ";
				}
				
				result += Math.abs(coefficient);
				
				if(i > 1)
				{
					result += "^" + i;
				}
			}
		}
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
