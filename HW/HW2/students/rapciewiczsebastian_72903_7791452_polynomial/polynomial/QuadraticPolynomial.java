package polynomial;

public class QuadraticPolynomial extends Polynomial
{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) 
	{
		// TO DO
		super (new int[] {C, B, A});
	}
	//Override polynomial.solve()
	public double[] solve()
	{
		int A = coefficients[2];
		int B = coefficients[1];
		int C = coefficients[0];
		
		double disc = B * B - 4 * A * C;
		
		if(disc > 0)
		{
			double root1 = (-1 * B + Math.sqrt(disc)) / (2.0 * A);
            double root2 = (-1 * B - Math.sqrt(disc)) / (2.0 * A);
            return new double[]{root1, root2};
		}
		else if (disc == 0)
		{
			double root1 = -1 * B / (2.0 * A);
			return new double[] {root1};
		}
		else
		{
			return new double[] {};
		}
	}
}
