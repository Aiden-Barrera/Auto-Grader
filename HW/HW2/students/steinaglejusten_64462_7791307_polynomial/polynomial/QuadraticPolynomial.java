package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		super(new int[]{C, B, A});	
	}
	//Override polynomial.solve()
	public float[] solve() {
        if (coefficients.length < 3 || coefficients[2] == 0) {
            if (coefficients.length >= 2 && coefficients[1] != 0) {
                float sol = -coefficients[0] / (float) coefficients[1];
                return new float[]{ sol };
            }
            return new float[0];
        }
        
        int A_coef = coefficients[2];
        int B_coef = coefficients[1];
        int C_coef = coefficients[0];
        
        float discriminant = B_coef * B_coef - 4 * A_coef * C_coef;
        if (discriminant < 0) {
            // No real solutions.
            return new float[0];
        } else if (discriminant == 0) {
            float sol = -B_coef / (2f * A_coef);
            return new float[]{ sol };
        } else {
            float sqrtDisc = (float) Math.sqrt(discriminant);
            float sol1 = (-B_coef + sqrtDisc) / (2f * A_coef);
            float sol2 = (-B_coef - sqrtDisc) / (2f * A_coef);
            return new float[]{ sol1, sol2 };
        }
	}
}