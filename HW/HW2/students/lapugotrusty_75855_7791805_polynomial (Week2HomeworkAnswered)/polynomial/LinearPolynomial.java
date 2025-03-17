package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		coefficients = new int[2];
		coefficients[0] = b;
		coefficients[1] = a;
		for (int x = coefficients.length - 1; x >= 0; x--) {
			if (coefficients[x] != 0) {
				degree = x;
				break;
			}
		}
	}
		
	//Override polynomial.solve()
}
