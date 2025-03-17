package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		//TO DO
		super(new int[] {b, a});
	}
	//Override polynomial.solve()
	
	@Override
	public double[] solve() {
		double solution = 0;
		solution-=this.coefficients[0];
		solution/=this.coefficients[1];
		double[] solved = new double[] {solution};
		return solved;
	}
}
