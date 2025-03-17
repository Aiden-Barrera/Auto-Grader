package polynomial;

public class LinearPolynomial extends Polynomial{
	protected Polynomial equation;
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		int[] polynomial=new int[] {b,a};
		equation=new Polynomial(polynomial);

	}
	@Override
	public double[] solve(){
		int[] values=equation.coefficients;
		int b=values[0];
		int a=values[1];
		// the solution is -b/a
		double[] solution=new double[] {(-1*b)/a};
		return solution;
	}
	//Override polynomial.solve()
}
