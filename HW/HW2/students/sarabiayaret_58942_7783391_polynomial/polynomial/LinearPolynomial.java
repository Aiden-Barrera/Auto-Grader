package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		super(new int[]{a, b});
	}
	//Override polynomial.solve()
	@Override
    public double[] solve() {
        int a = coefficients[0];
        int b = coefficients[1];
        
        if (a == 0) {
        	return new double[]{};
        }
        
        double[] solution = new double[1];
        solution[0] = -1.0 * b / a;
        
        return solution;
    }
}
