package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		super(new int[] {A, B, C});
	}
	//Override polynomial.solve()\
	@Override
	public double[] solve() {
		double disc = this.coefficients[1] * this.coefficients[1] - 4 * this.coefficients[0] * this.coefficients[2];
		
		if (disc > 0) {
			double root1 = (-this.coefficients[1] + Math.sqrt(disc)) / (2 * this.coefficients[0]);
            double root2 = (-this.coefficients[1]- Math.sqrt(disc)) / (2 * this.coefficients[0]);
            return new double[]{root1, root2};
        }
		
		else if (disc == 0) {
			double root = -this.coefficients[1] / (2*this.coefficients[0]);
			return new double[] {root};
		}
		else {
			return null;
		}
	}
}
