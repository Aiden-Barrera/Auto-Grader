package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		coefficients = new int[3];
		coefficients[0] = C;
		coefficients[1] = B;
		coefficients[2] = A;
		for (int x = coefficients.length - 1; x >= 0; x--) {
			if (coefficients[x] != 0) {
				degree = x;
				break;
			}
		}
	}
	//Override polynomial.solve()
}
