package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		// TO DO
        super(new int[]{C, B, A});

	}
	//Override polynomial.solve()
	
	public double[] solve()
	{
		double[] sum = new double[2];
		int[] poly = super.coefficients;
		
		double discrim = Math.pow(poly[1], 2) - 4*poly[2]*poly[0];
		double a2 = 2*poly[2];
		
		if (discrim > -1)
		{
			
			double solution1 = (-1.0*poly[1] + Math.sqrt(discrim)) / a2;
			double solution2 = (-1.0*poly[1] - Math.sqrt(discrim) / a2);
			
			sum[0] = solution1;
			sum[1] = solution2;
		}
		
		return sum;
	}
}
