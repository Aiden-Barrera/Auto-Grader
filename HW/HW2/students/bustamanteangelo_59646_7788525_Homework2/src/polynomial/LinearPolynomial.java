package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a line of the form ax + b
	public LinearPolynomial(int a, int b) {
		super(new int[]{b, a});
    }

    public double[] solve() {
        
        if (coefficients[1] == 0) {
           
            if (coefficients[0] == 0) {
                return new double[0];
            } else {
                return new double[0];
            }
        } else {
            double solution = -coefficients[0] / (double) coefficients[1];
            return new double[]{solution};
        }
}}
