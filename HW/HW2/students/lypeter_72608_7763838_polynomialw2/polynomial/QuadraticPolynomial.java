package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		coefficients = new int[] {A,B,C};
		degree = 2; //assumed to be 2 since it's said in the form x^2 and otherwise it wouldn't be a quadratic
	}
	
	public double[] solve() {
		double a = coefficients[0];
		double b = coefficients[1];
		double c = coefficients[2];
		int roots = 0;
		double rootOne = ((-1*b)+Math.sqrt(Math.pow(b, 2)-(4*a*c)))/(2*a);
		double rootTwo = ((-1*b)-Math.sqrt(Math.pow(b, 2)-(4*a*c)))/(2*a);
		if(!Double.isNaN(rootOne)) {
			roots++;
		}
		if(!Double.isNaN(rootTwo)) {
			roots++;
		}
		
		if(rootOne==rootTwo) {
			roots=1;
			return new double[] {rootOne};
		}else if(roots==0) {
			return new double[] {};
		}else {
			return new double[] {rootOne, rootTwo};
		}
	}
}
