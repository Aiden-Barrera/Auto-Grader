package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {

		coefficients = new int[] {C,B,A};
		
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

		double determinant = coefficients[1]*coefficients[1] - 4*coefficients[2]*coefficients[0];

		if(determinant < 0){
			return new double[] {};
		}

		else{

			double determinant_plus = (-1*coefficients[1] + Math.pow(determinant, 0.5))/(2*coefficients[2]);
			double determinant_minus= (-1*coefficients[1] - Math.pow(determinant, 0.5))/(2*coefficients[2]);

			return new double[] {determinant_plus, determinant_minus};
		}
	}

}
