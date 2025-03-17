package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		super(new int[] {C, B, A});
	}
	//Override polynomial.solve()
	@Override
	public double[] solve() {
	    double[] result = new double[2];
	    double A = super.coefficients[2];
	    double B = super.coefficients[1];
	    double C = super.coefficients[0];
	    double common = Math.pow(B, 2) - 4 * A * C;
	    if (common < 0) {
	        // No real roots
	        return new double[] {};
	    }
	    result[0] = (-B - Math.sqrt(common)) / (2 * A);
	    result[1] = (-B + Math.sqrt(common)) / (2 * A);
	    if (result[0] == result[1]) {
	    	return new double[] {result[0]};
	    }
	    return result;
	}

}
