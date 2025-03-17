package polynomial;

public class LinearPolynomial extends Polynomial{
	Polynomial linear;
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		//TO DO
		linear = new Polynomial(new int[] {b, a});
	}
	//Override polynomial.solve()
	public double[] solve() {
		double[] solution;
		if(linear.coefficients[0] == 0) {
			solution = new double[] {0};
		}else {
			solution = new double[] {- (double)linear.coefficients[0] / linear.coefficients[1]};
		}
		return solution;
	}
}
