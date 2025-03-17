package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		// TO DO
		super(new int[]{C, B, A});
	}
	//Override polynomial.solve()
	//Quadratic formula to solve
	public double[] solve() {
        if (degree != 2 || coefficients[2] == 0) {
            return new double[]{}; // No solution
        }
        double a = coefficients[2], b = coefficients[1], c = coefficients[0];
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            return new double[]{}; // No real solutions
        } else if (discriminant == 0) {
            return new double[]{-b / (2 * a)};
        } else {
            double sqrtD = Math.sqrt(discriminant);
            return new double[]{(-b + sqrtD) / (2 * a), (-b - sqrtD) / (2 * a)};
        }
    }
}
