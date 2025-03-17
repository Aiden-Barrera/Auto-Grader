package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		//TO DO
		super(new int[] {b,a});
	}
	//Override polynomial.solve()
	public double[] solve() {
		int a = this.coefficients[1];
		int b = this.coefficients[0];
		
		if (a == 0) {
			if (b == 0) {
				return new double[] {};
			}
			else {
			return new double[0];
			}
		}
		return new double[] {-((double) b/a)};
	}
}
