package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		super(new int[]{b, a});
	}
	
	//Override polynomial.solve()
	public float[] solve() {
		if(coefficients.length < 2 || coefficients[1] == 0) {
			return new float[0];
		}
		float solution = -coefficients[0] / (float) coefficients[1];
        return new float[]{ solution };
	}
	
}
