package polynomial;

public class QuadraticPolynomial extends Polynomial{
	Polynomial quadratic;
	
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		// TO DO
		quadratic = new Polynomial(new int[] {C, B, A});
	}
	//Override polynomial.solve()
	public double[] solve() {
		double[] solutions;
		int a = quadratic.coefficients[2];
		int b = quadratic.coefficients[1];
		int c = quadratic.coefficients[0];
		int determinant = b * b - 4 * a * c;
		if(determinant > 0) {
			solutions = new double[] {(- b - Math.sqrt(determinant))/ (2 * a), (- b + Math.sqrt(determinant))/ (2 * a)};
		}else if(determinant == 0){
			solutions = new double[] {- b / (2 * a)};
		}else {
			solutions = new double[0];
		}
		
		return solutions;
	}
}
