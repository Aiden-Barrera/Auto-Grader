package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		super(new int[]{C,B,A}); //DONE
	}
	//Override polynomial.solve()
	@Override
	public double[] solve(){
		double[] results = new double[2];
		double xroot1 = (-coefficients[1] + Math.sqrt(Math.pow(coefficients[1], 2) - (4*coefficients[2]*coefficients[0])))/(2*coefficients[2]);
		double xroot2 = (-coefficients[1] - Math.sqrt(Math.pow(coefficients[1], 2) - (4*coefficients[2]*coefficients[0])))/(2*coefficients[2]);

		results[0] = (atPoint((float) xroot1) == 0) ? xroot1 : 0;
		results[1] = (atPoint((float) xroot2) == 0) ? xroot2 : 0;
		return results;
	}
}
