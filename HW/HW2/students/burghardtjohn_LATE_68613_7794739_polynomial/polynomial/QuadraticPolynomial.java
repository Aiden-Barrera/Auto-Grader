package polynomial;
public class QuadraticPolynomial extends Polynomial{
	public QuadraticPolynomial(int newA, int newB, int newC){
		super(new int[] {newA, newB, newC});
	}
	int a = coefficients[0];
	int b = coefficients[1];
	int c = coefficients[2];
	public double[] solve(double y){
		if (Math.pow(b, 2) - 4 * a * c < 0)
			return new double[] {};
		return new double[] {(-1 * b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a), (-1 * b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a)};
	}
}