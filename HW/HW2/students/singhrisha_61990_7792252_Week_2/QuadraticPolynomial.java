package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		
		this.coefficients = new int[]{C, B, A}; 
        this.degree = 2;
		
	}
	//Override polynomial.solve()
	@Override
    public double[] solve() {
 
        int A = this.coefficients[2]; 
        int B = this.coefficients[1]; 
        int C = this.coefficients[0]; 

        int discriminant = B * B - 4 * A * C;
        
        if (discriminant > 0) {

            double firstRoot = (-B + Math.sqrt(discriminant)) / (2.0 * A);
            double secondRoot = (-B - Math.sqrt(discriminant)) / (2.0 * A);
            return new double[]{firstRoot, secondRoot};
            
        } else if (discriminant == 0) {
            double root = -B / (2.0 * A);
            return new double[]{root};
            
        } else {
            return new double[]{};
        }
    }
}
	

