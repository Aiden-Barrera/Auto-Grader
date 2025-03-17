package polynomial;
public class LinearPolynomial extends Polynomial{
	public LinearPolynomial(int newM, int newB){
		super(new int[] {newM,newB});
	}
	int m = coefficients[0];
	int b = coefficients[1];
	public double[] solve(double y){
		return new double[] {(y - b) / m};
	}
}