package college;

public class QuadraticPolynomial extends Polynomial{
	public QuadraticPolynomial(int A, int B, int C) {
		super(new int[] {C, B, A});
	}
	
	@Override
	public double[] solve() {
		int A = this.coefficients[2];
		int B = this.coefficients[1];
		int C = this.coefficients[0];
		
		double numSolutions = Math.pow(B,  2) - 4 * A * C;
		
		if (numSolutions > 0) {
			// Supposing two real solutions
			double root1 = (-B + Math.sqrt(numSolutions)) / (2*A);
			double root2 = (-B - Math.sqrt(numSolutions)) / (2*A);
			
			return new double[] {root1, root2};
		}
		else if (numSolutions == 0) {
			// Supposing one real solution
			double root = -1.0*B/(2*A);
			return new double[] {root};
		}
		else {
			// Supposing no real solutions
			return new double[] {};
		}
	}
}
