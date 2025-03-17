package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		// TO DO
		super(new int[] {C,B,A});
	}
	//Override polynomial.solve()
	public double[] solve() {
		int coefA = coefficients[2], coefB = coefficients[1], coefC = coefficients[0];
        double discriminant = coefB * coefB - 4 * coefA * coefC;
        if (discriminant < 0) {
            return new double[]{};
        } else if (discriminant == 0) {
            double root = -coefB / (2.0 * coefA);
            return new double[]{root};
        } else {
            double sqrtD = Math.sqrt(discriminant);
            double root1 = (-coefB + sqrtD) / (2 * coefA);
            double root2 = (-coefB - sqrtD) / (2 * coefA);
            return new double[]{root1, root2};
        }
	}
}
