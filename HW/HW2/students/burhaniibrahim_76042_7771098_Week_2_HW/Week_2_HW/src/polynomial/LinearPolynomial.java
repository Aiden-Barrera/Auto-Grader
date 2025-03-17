package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		//TO DO
        super(new int[]{b, a});
	}
	//Override polynomial.solve()
	
	public double[] solve()
	{
		double[] sum = new double[1];
		int[] poly = super.coefficients;
		
		sum[0] = -1.0 * ((double) poly[0]/(double) poly[1]);
		
		return sum;
	}
}
