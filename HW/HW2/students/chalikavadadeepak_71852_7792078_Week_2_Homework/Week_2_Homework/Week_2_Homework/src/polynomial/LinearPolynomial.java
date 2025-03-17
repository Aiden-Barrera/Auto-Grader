package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		//TO DO
		super(new int[]{b, a});
	}
	//Override polynomial.solve()
	@Override
    public double[] solve() {
        int a = coefficients[1];
        int b = coefficients[0];
        
        if (a == 0) {
            return new double[] {};
        } else {
            return new double[] {-b / (double) a};
        }
    }
}
