package polynomial;

public class LinearPolynomial extends Polynomial{
	
	// Create a linear polynomial of the form ax + b
	public LinearPolynomial(int a, int b) {
		
		coefficients = new int[] {b,a};
		
		degree = 0;

		for(int i = coefficients.length - 1; i >= 0 ; i--){

			if(coefficients[i]!=0){

				degree = i;
				break;
			}
		}

	}
	@Override 

	public double[] solve(){

		if(coefficients[1]==0){

			return new double[] {0};
		}

		return new double[] {-1*coefficients[1] / (double)coefficients[0]};
	}
}
