package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int A, int B) {
		super (new int[] {B, A});
    }

    @Override
    public double[] solve() {
        int A = this.coefficients[1]; 
        int B = this.coefficients[0]; 

        if (A == 0 ) {
        	if (B == 0) {
        		return new double[] {};
        	}
        }
        
        return new double[] { (double) -B / A };
    }
}


