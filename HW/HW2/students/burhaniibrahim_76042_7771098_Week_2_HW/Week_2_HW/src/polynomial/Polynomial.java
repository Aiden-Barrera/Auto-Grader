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
		
		//System.out.println("|| Creating Polynomial ||");
		
		coefficients = new int[coeffs.length]; //Change the size to be the same
		
		for (int i = 0; i < coeffs.length; i++)
		{
			coefficients[i] = coeffs[i]; //Copy content over
			if (coeffs[i] != 0)
			{
				degree = i;
			}
			
			//System.out.println(coefficients[i]);
		}
		
		//System.out.println("\nDegree: "+ degree);
		
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		
		for (int i = this.coefficients.length-1; i > 0;  i--)
		{
			this.coefficients[i] *= factor;
		}
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		
		int[] product = new int[0];
		
		//Control variables
		int maxLength = 0;
		int[] maxArr = new int[0];
		
		int minLength = 0;
		int[] minArr = new int[0];
		
		//Get the product array length
		if ( (p.coefficients.length - this.coefficients.length) == 0)
		{
			product = new int[p.coefficients.length]; //Set the length
			
			//Set the control variables
			maxLength = p.coefficients.length;
			maxArr = p.coefficients;
			
			minLength = this.coefficients.length;
			minArr = this.coefficients;
			
		} else if (p.coefficients.length > this.coefficients.length)
		{
			product = new int[p.coefficients.length]; //Set the length
			
			maxLength = p.coefficients.length;
			maxArr = p.coefficients;
			
			minLength = this.coefficients.length;
			minArr = this.coefficients;
			
		} else if (p.coefficients.length < this.coefficients.length)
		{
			product = new int[this.coefficients.length]; //Set the length
			
			maxLength = this.coefficients.length;
			maxArr = this.coefficients;
			
			minLength = p.coefficients.length;
			minArr = p.coefficients;
		}
		
		//Subtract from both here because I'm too lazy
		minLength--;
		maxLength--;
				
		//System.out.println("Max Length: " + maxLength);
		//System.out.println("Minimum Length: " + minLength);
		
		
		
		// For loop to add them all up
		for (int i = maxLength; i >= 0; i--)
		{
			if (i > minLength)
			{
				product[i] = maxArr[i];
				continue;
			}
			
			product[i] = maxArr[i] + minArr[i];
			
		}
		
		
		//Find the degree
		for (int i = product.length-1; i > 0; i--)
		{
			if (product[i] != 0 && i > this.degree)
			{
				this.degree = i;
			}
		}
		
		//Set the new values added to the class
		this.coefficients = product;
		

		
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		int[] product = new int[0];
		
		//Control variables
		int maxLength = 0;
		int[] maxArr = new int[0];
		
		int minLength = 0;
		int[] minArr = new int[0];
		
		//Get the product array length
		if ( (p.coefficients.length - this.coefficients.length) == 0)
		{
			product = new int[p.coefficients.length]; //Set the length
			
			//Set the control variables
			maxLength = p.coefficients.length;
			maxArr = p.coefficients;
			
			minLength = this.coefficients.length;
			minArr = this.coefficients;
			
		} else if (p.coefficients.length > this.coefficients.length)
		{
			product = new int[p.coefficients.length]; //Set the length
			
			maxLength = p.coefficients.length;
			maxArr = p.coefficients;
			
			minLength = this.coefficients.length;
			minArr = this.coefficients;
			
		} else if (p.coefficients.length < this.coefficients.length)
		{
			product = new int[this.coefficients.length]; //Set the length
			
			maxLength = this.coefficients.length;
			maxArr = this.coefficients;
			
			minLength = p.coefficients.length;
			minArr = p.coefficients;
		}
		
		//Subtract from both here because I'm too lazy
		minLength--;
		maxLength--;
				
		//System.out.println("Max Length: " + maxLength);
		//System.out.println("Minimum Length: " + minLength);
		
		
		
		// For loop to add them all up
		for (int i = maxLength; i >= 0; i--)
		{
			if (i > minLength)
			{
				product[i] =  -1 * maxArr[i];
				continue;
			}
			
			if (maxArr[i] > 0)
			{
				product[i] = (-1*maxArr[i]) + minArr[i];
			}else if (maxArr[i] <= 0)
			{
				product[i] = (-1*maxArr[i]) + minArr[i];
			}
			
			
		}
		
		//Set the new values added to the class
		this.coefficients = product;
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		int[] deriv = new int[this.coefficients.length];
		
		for (int i = 0; i < deriv.length; i++)
		{	
			int num = this.coefficients[i];
			//System.out.println(num);
			
			if (i == 0 || num == 0)
			{continue;}
			
			int newNum = num*i;
			
			deriv[i-1] = newNum;
			//System.out.println("Placed (" + newNum + ") at the degree of " + (i-1));
		}

		
		return new Polynomial(deriv); //STUB
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		//TO DO
		double sum = this.coefficients[0]; //Start off with the first one as we skip it anyways
		
		//Rearranged the math to move from left to right
		for (int i = this.coefficients.length-1; i > 0; i--)
		{
			double num = this.coefficients[i] * 1.0;
			double product = (num*(Math.pow(arg, i)));
			//System.out.println(""+ num + " * " + "("+ arg + "^"+ i +")" + "=" + product);
			
			sum += product;
		}
		
		//System.out.println("Final Sum: " + sum);
		
		return sum; //STUB
	}
	@Override
	public String toString() {
		//TO DO
		String poly = "";
		
		for (int i = coefficients.length-1; i >= 0; i--)
		{
			int num = coefficients[i];
			
			if (num != 0)
			{
				
				int tempDegree = i;
				
				
				
				if (num == 1)
				{
					poly += " + ";
					
					if (tempDegree==0)
					{
						poly += "" + num;
					}
				} else if (num == -1)
				{
					poly += " - ";
					
					if (tempDegree==0)
					{
						poly += "" + num;
					}
				} 
				
				else if (num < 0)
				{
					poly += " - " + Math.abs(num);
				} else if (num > 1)
				{	
					poly += " + " + num;
				}
				
				
				//Handle degrees
				if (tempDegree > 1)
				{
					poly += "x^" + tempDegree ;	
				}
				else if (tempDegree == 1)
				{
					poly += "x" ;	
				}
				
			}
			
			
		}
		
		return poly + ", Degree: " + this.degree; //STU
	}
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	
}
