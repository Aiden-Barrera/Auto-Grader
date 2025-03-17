package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		super(new int[] {A,B,C}); 
	}
	public double[] solve()
	{
		double[] solutions = new double[2];
		
		int a = coefficients[2];
		int b = coefficients[1];
		int c = coefficients[0];
		
		double discrim = ((b * b) - (4 * a * c));
		
		if (discrim > 0)
		{
			solutions[0] = (-b+ Math.sqrt(discrim))/(2*a);
			solutions[1] = (-b- Math.sqrt(discrim))/(2*a);
		}
		
		else if (discrim == 0)
		{
			solutions[0] = (-b /(2.0*a));
			
		}
		
		return solutions;
	}
}


