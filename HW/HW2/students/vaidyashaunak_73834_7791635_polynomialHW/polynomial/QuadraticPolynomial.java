package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		// TO DO
		super(new int[] {A,B,C});
		
		
	}
	//Override polynomial.solve()
	@Override public double[] solve() {
		double sol1 = (double)((-super.coefficients[1] - Math.sqrt(Math.pow(super.coefficients[1], 2)-
				(4*super.coefficients[0]*super.coefficients[2])))
				/
				(2*super.coefficients[0]));
		double sol2 = (double)((-super.coefficients[1] + Math.sqrt(Math.pow(super.coefficients[1], 2)-
				(4*super.coefficients[0]*super.coefficients[2])))
				/
				(2*super.coefficients[0]));
		if(sol1 == sol2) {
			return new double[] {sol1};
		}
		return new double[] {sol1,sol2};
	}
}
