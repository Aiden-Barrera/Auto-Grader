package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		super();
		int[] qp = {a, b};
		coefficients = qp;
		
		int i = 1;
		degree = 1;
		while (i >= 0 && coefficients[i] == 0)
		{
			degree--;
			i--;
		}
	}
	
	//Override polynomial.solve()
	public double[] solve() {
		double[] result = new double[1];
		result[0] = (double) coefficients[0] / coefficients[1];
		return result;
	}
}
