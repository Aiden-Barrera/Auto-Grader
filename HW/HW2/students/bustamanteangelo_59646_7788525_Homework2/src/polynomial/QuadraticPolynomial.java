package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		super(new int[]{C, B, A});
    }

    
    public double[] solve() {
       
        int A = coefficients[2];
        int B = coefficients[1];
        int C = coefficients[0];

       
        if (A == 0) {
            
            if (B == 0) {
                
                return new double[0];
            } else {
                
                double solution = -C / (double) B;
                return new double[]{solution};
            }
        }

       
        double discriminant = B * B - 4 * A * C;

        
        if (discriminant < 0) {
           
            return new double[0];
        } else if (discriminant == 0) {
        
            double solution = -B / (2.0 * A);
            return new double[]{solution};
        } else {
           
            double sqrtDiscriminant = Math.sqrt(discriminant);
            double solution1 = (-B - sqrtDiscriminant) / (2.0 * A);
            double solution2 = (-B + sqrtDiscriminant) / (2.0 * A);
            return new double[]{solution1, solution2};
        }
	}
}