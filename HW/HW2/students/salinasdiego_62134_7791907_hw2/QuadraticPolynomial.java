package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		super(A, B, C);
	}
	//Override polynomial.solve()
	public double[] solve() {
        double A = this.getA();
        double B = this.getB();
        double C = this.getC();

        if (A == 0) {
            if (B != 0) {
                double root = -C / B;
                return new double[]{root};
            } else {
                return new double[]{};
            }
        }

        double root1 = (-B) / (2 * A);
        double root2 = Math.sqrt(B * B - 4 * A * C) / (2 * A);
        
        if (B * B - 4 * A * C < 0) {
            return new double[]{};
        }

        if (B * B - 4 * A * C == 0) {
            return new double[]{root1};
        }
        
        return new double[]{root1 + root2, root1 - root2};
    }
}
