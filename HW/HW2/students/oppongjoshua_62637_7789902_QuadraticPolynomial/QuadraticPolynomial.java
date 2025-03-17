package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		super();
		System.out.println(A + "x^" + degree + " " + B + "x " + C);
		// TO DO
	}
	//Override polynomial.solve()
	@Override
    public double[] solve() {
        if (degree != 2) {
            return new double[]{};
        }

        int a = coefficients[2];
        int b = coefficients[1];
        int c = coefficients[0];
        int discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            return new double[]{};
        } else if (discriminant == 0) {
            return new double[]{-b / (2.0 * a)};
        } else {
            double sqrtDiscriminant = Math.sqrt(discriminant);
            return new double[]{
                (-b + sqrtDiscriminant) / (2 * a),
                (-b - sqrtDiscriminant) / (2 * a)
            };
        }
	}
}
