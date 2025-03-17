package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		// TO DO
		super(new int[] {C,B,A});
	}
	//Override polynomial.solve()
	@Override
	 public double[] solve() {
        int A = coefficients[2], B = coefficients[1], C = coefficients[0]; //writing them in the correct order
        
        if (A == 0) {
            if (B == 0) {
                return new double[] {}; 
            } else {
                return new double[] { -C / (double) B };  
            }
        }
        
        double delta = B * B - 4 * A * C;
        if (delta < 0) return new double[] {}; 

        double sqrtDelta = Math.sqrt(delta);
        return delta == 0
            ? new double[] { -B / (2.0 * A) } 
            : new double[] { (-B + sqrtDelta) / (2.0 * A), (-B - sqrtDelta) / (2.0 * A) }; 
    }
}
	

