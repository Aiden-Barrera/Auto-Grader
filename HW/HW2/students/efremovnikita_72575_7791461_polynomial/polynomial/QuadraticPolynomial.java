package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		super();
		int[] qp = {A, B, C};
		coefficients = qp;
		
		int i = 2;
		degree = 2;
		while (i >= 0 && coefficients[i] == 0)
		{
			degree--;
			i--;
		}
	}
	
	//Override polynomial.solve()
	public double[] solve() {
		double dis = coefficients[1] * coefficients[1] - 4*coefficients[2]*coefficients[0];
		if (dis > 0)
		{
			double[] result = new double[2];
			result[0] = (-coefficients[1] + Math.sqrt(coefficients[1]*coefficients[1] - 4*coefficients[2]*coefficients[0]))/(2*coefficients[2]);
			result[1] = (-coefficients[1] - Math.sqrt(coefficients[1]*coefficients[1] - 4*coefficients[2]*coefficients[0]))/(2*coefficients[2]);
			return result;
		}
		
		if (dis == 0)
		{
			double[] result = new double[1];
			result[0] = (-coefficients[1]*0.5)/(coefficients[2]);
			return result;
		}
		
		else
		{
			double[] result = new double[0];
			return result;
		}
	}
}
