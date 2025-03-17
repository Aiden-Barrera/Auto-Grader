package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		coefficients = new int[] {a,b};
		degree = 1;
	}
	
	public double[] solve() {
		double m = coefficients[0];
		double b = coefficients[1];
		double num = ((0-b)/m);
		double[]root = new double[1];
		root[0] = num;
		return root;
	}
}
