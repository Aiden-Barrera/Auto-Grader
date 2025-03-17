package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		//TO DO
		super(new int[] {b, a});
	}
	//Override polynomial.solve()
	public double[] solve() {
		double [] sol = new double[1];
		double a = this.coefficients[1];
		double b = this.coefficients[0];
		sol[0]=-b/a;
		return sol;
	}
}
