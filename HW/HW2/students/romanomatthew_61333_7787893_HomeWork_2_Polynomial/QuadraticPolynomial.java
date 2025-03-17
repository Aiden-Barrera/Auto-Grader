package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		coefficients = new int[] {C,B,A};
		degree = 2;
	}
	
	public double[] solve() {
		//double[] result = new double[2];
		double root = (double) Math.pow(coefficients[1],2) - 4 * coefficients[2]*coefficients[0];
        double sqrtRoot = (double) Math.sqrt(root);
        double[] result = new double[] {
        		(-coefficients[1] + sqrtRoot) / (2 * coefficients[2]),
        		(-coefficients[1] - sqrtRoot) / (2 * coefficients[2])
        };
        
        if (root < 0) {
            return new double[0]; 
        } else if (result[0] == result[1]) {
            result = new double[] {result[1]};
        	return result; 
        } 
        return result;
	}
}
