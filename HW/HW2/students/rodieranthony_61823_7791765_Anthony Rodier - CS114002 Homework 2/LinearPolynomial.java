package polynomial;

public class LinearPolynomial extends Polynomial {
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		super (new int[] {b, a});
	}
	
	@Override
	public double[] solve() {
		int a = coefficients[1];
		int b = coefficients[0];
		
		if (a == 0) {
	        if (b == 0) {
	            return new double[] {};  // Infinitely many solutions
	        }
	    }
		
		return new double[] { (double) -b / a };
	}
	
}