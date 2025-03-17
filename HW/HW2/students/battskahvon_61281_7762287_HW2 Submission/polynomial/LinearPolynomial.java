package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		//TO DO
		super(new int[]{b, a});
	}
	//Override polynomial.solve()
	public double[] solve() {
        if (degree != 1 || coefficients[1] == 0) {
            return new double[]{}; // No solution
        }
        return new double[]{-coefficients[0] / (double) coefficients[1]};
    }
}
