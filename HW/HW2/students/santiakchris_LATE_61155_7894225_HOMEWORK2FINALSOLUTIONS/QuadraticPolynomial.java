package polynomial;

public class QuadraticPolynomial extends Polynomial{
	public QuadraticPolynomial(int A, int B, int C) {
		super(new int[]{C, B, A});
	}

	@Override
	public double[] solve() {
		int A = coefficients[2];
		int B = coefficients[1];
		int C = coefficients[0];
		
double discriminant = B * B - 4 * A * C;
		if (discriminant < 0) return new double[0]; 
   	if (discriminant == 0) return new double[]{-B / (2.0 * A)};
		return new double[]{(-B + Math.sqrt(discriminant)) / (2.0 * A), (-B - Math.sqrt(discriminant)) / (2.0 * A)};
	}
}
