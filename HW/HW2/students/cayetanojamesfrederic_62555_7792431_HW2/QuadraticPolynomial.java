package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		super(new int[] {C, B, A});
		this.degree = 2;
	}
	//Override polynomial.solve()
	public double[] solve()
	{
		double A = this.coefficients[2];
		double B = this.coefficients[1];
		double C = this.coefficients[0];
		
		double discriminant = (B * B) - (4 * A * C);
		
		if(discriminant < 0)
		{
			return null;
		}
		else
		{
			double discriminantRoot= Math.sqrt(discriminant);
			double x1 = (-B + discriminantRoot) / (2 * A);
			double x2 = (-B - discriminantRoot) / (2 * A);
			
			return new double[] {x1, x2};
		}
	}
}
