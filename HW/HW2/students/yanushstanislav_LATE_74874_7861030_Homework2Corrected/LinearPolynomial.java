package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		super(new int[] {a,b});
	}
	public double[] solve()
	{
		double[] solution = {(-1.0*this.coefficients[1])/this.coefficients[0]};
		return solution;
	}

}
