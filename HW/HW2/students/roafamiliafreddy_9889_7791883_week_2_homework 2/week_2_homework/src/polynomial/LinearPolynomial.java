package polynomial;

public class LinearPolynomial extends Polynomial {

	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		// Call the superclass constructor with the coefficients for ax + b
		super(new int[] { b, a });
	}
	// Override polynomial.solve()
}
