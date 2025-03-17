package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		coefficients = new int[] {C, B, A};
		degree = 2;
	}
	@Override 
	public double[] solve() {
		int A = coefficients[2];
		int B = coefficients[1];
		int C = coefficients[0];
		
		int discrim = B * B - 4 * A * C;
		
		if (discrim < 0) {
			return new double[0];
		}
		
		double sqrtDiscrim = Math.sqrt(discrim);
		double x1 = (-B + sqrtDiscrim) / (2 * A);
		double x2 = (-B - sqrtDiscrim) / (2 * A);
		
		if (discrim == 0) {
			return new double[] {x1};
		}
		
		return new double[] {x1, x2};
	}
}
