package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		super(new int[] {C, B, A});
	}
	public double[] solve() {
		int a = coefficients[2];
		int b = coefficients[1];
		int c = coefficients[0];
		double discriminant = Math.pow(b, 2) - 4 * a * c;
		
		if (discriminant < 0) {
			return new double[0];
		}
		
		double solution1 = (-b + Math.sqrt(discriminant)) / (2 * a);
		double solution2 = (-b - Math.sqrt(discriminant)) / (2 * a);
		if (discriminant == 0) {
			return new double[] {solution1};
		}
		
		return new double[] {solution1, solution2};
	}
}
