//package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		super(new int[]{b, a}); //DONE
	}
	//Override polynomial.solve()
	public double[] solve(){
		int a = coefficients[1];
        int b = coefficients[0];

        if (a == 0) {
			if (b == 0 || b != 0) {
				return new double[]{};
			}
		}
        return new double[]{(-1.0 * b) / a};
	}
}
