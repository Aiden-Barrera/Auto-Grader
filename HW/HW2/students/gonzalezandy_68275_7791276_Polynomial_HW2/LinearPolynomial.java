package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		//TO DO
		super(new int[] {b,a});{
			
		}
	}
	//Override polynomial.solve()
	@Override
	public double[] solve() {
		if(coefficients[1] == 0) {
			return new double[] {};
		}
		return new double[] {(double)-coefficients[0]/coefficients[1]}; // casting my b to a double, which will also convert a to a double 
	}
}
