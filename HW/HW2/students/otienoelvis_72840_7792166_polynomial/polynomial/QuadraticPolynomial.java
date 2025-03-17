package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	
	public QuadraticPolynomial(int A, int B, int C) {
		super(new int[]{C, B, A});
	}
	//Override polynomial.solve()
	public double[] solve() {
        int A = coefficients[2], B = coefficients[1], C = coefficients[0];
        double discriminant = B * B - 4 * A * C;
        if (discriminant < 0) return new double[]{};
        if (discriminant == 0) return new double[]{-B / (2.0 * A)};
        double sqrtD = Math.sqrt(discriminant);
        return new double[]{(-B + sqrtD) / (2.0 * A), (-B - sqrtD) / (2.0 * A)};
    }
}
