
public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		super(new int[]{C , B , A }); // DONE
	}
	//Override polynomial.solve()
	public double[] solve(){
		int A = coefficients[2];
		int B = coefficients[1];
		int C = coefficients[0];

		if(A == 0){
			LinearPolynomial linearFunc = new LinearPolynomial(B , C);
			return linearFunc.solve();
		}
		int discriFormula = (B * B) - (4 * A * C);
		if(discriFormula < 0){
			return new double[]{};
		} else if (discriFormula == 0) {
            return new double[]{-1.0 * A / (2 * A)};
		} else {
			double sqrtD = Math.sqrt(discriFormula);
            return new double[]{(-B + sqrtD) / (2 * A) , (-B - sqrtD) / (2 * A)};
		}
	}
}
