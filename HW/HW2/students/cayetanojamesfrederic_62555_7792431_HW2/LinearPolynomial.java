package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		super(new int[] {b, a});
		this.degree = 1;
	}
	//Override polynomial.solve()
	public double[] solve()
	{
		if(this.coefficients[1] != 0)
		{
			return new double[] {-this.coefficients[0] / (double) this.coefficients[1]};
		}
		else
		{
			return null;
		}
	}
}
