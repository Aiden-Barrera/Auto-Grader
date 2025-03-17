package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		int coeffs[] = {b, a};
		Polynomial p = new Polynomial(coeffs);
	}
	//Override polynomial.solve()
}
