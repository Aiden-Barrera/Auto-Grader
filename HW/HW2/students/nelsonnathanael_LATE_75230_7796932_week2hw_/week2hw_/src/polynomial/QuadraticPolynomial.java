package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		int coeffs[] = {C, B, A};
		Polynomial p = new Polynomial(coeffs);
	}
	//Override polynomial.solve()
}
