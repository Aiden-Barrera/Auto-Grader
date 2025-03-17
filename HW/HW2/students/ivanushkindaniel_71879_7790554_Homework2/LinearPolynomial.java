package college;

public class LinearPolynomial extends Polynomial{
	
	public LinearPolynomial(int a, int b) {
		super(new int[] {b, a});
	}
	@Override
	public double[] solve() {
		if (this.coefficients[1] != 0) {
			double solution = -this.coefficients[0]/(double) this.coefficients[1];
			return new double[] {solution};
		}
		else if (this.coefficients[0] != 0) {
			return new double[] {};
		}
		else {
			return new double[] {};
		}
	}
}
