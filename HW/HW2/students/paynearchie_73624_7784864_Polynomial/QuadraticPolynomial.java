package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		// TO DO
		super(new int[] {C, B, A});
	}
	
	
	//Override polynomial.solve()
	@Override
	public double[] solve() {
	    double a = this.coefficients[2];
	    double b = this.coefficients[1];
	    double c = this.coefficients[0];
	    double discriminant = b * b - 4 * a * c;

	    if (discriminant > 0) {
	        double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
	        double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
	        return new double[]{root1, root2}; 
	    } 
	    else if (discriminant == 0) {
	        double root = -b / (2 * a);
	        return new double[]{root};  
	    } 
	    else {
	        return new double[]{}; 
	    }
	}

}
