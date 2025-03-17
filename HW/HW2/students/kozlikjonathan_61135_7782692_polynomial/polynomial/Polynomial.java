package polynomial;

/**
 * 
 * This class represent a polynomial, 
 * 
 */
public class Polynomial {
	protected int[] coefficients;
	protected int degree;
	
	public Polynomial() {
		// Default polynomial is 0
		coefficients = new int[] {0};
		degree = 0;
	}
		
	/* Construct the polynomial given it's coefficients */ 
	public Polynomial(int[] coeffs) {

		coefficients = coeffs;
		
		degree = 0;

		for(int i = coefficients.length - 1; i >= 0 ; i--){

			if(coefficients[i]!=0){

				degree = i;
				break;
			}
		}
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {

		for(int i = 0; i < coefficients.length ; i++){

			coefficients[i]*=factor;
		}

		degree = 0;

		for(int i = coefficients.length - 1; i >= 0 ; i--){

			if(coefficients[i]!=0){

				degree = i;
				break;
			}
		}
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		
		int[] copy;

		if(p.coefficients.length > coefficients.length){
			
			copy = new int[p.coefficients.length];

			for(int i = 0; i < p.coefficients.length; i++){

				copy[i]=p.coefficients[i];
			}

			for(int i = 0; i < coefficients.length; i++){

				copy[i]+=coefficients[i];
			}

			coefficients = copy;
			degree = 0;

			for(int i = coefficients.length - 1; i >= 0 ; i--){

				if(coefficients[i]!=0){
	
					degree = i;
					break;
				}
			}
		}

		if(p.coefficients.length <= coefficients.length){

			for(int i = 0; i < p.coefficients.length; i++){

				coefficients[i]+=p.coefficients[i];
			}
			
			degree = 0;

			for(int i = coefficients.length - 1; i >= 0 ; i--){


				if(coefficients[i]!=0){
	
					degree = i;
					break;
				}
			}
		}
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		
		int[] copy;

		if(p.coefficients.length > coefficients.length){
			
			copy = new int[p.coefficients.length];

			for(int i = 0; i < p.coefficients.length; i++){

				copy[i]=p.coefficients[i];
			}

			for(int i = 0; i < p.coefficients.length; i++){
				if(i<coefficients.length-1){

					copy[i]= -1*(copy[i] - coefficients[i]);
				}

				else{

					copy[i] *= -1;
				}
			}

			coefficients = copy;
			degree = 0;

			for(int i = coefficients.length - 1; i >= 0 ; i--){

				if(coefficients[i]!=0){
	
					degree = i;
					break;
				}
			}
		}

		if(p.coefficients.length <= coefficients.length){

			for(int i = 0; i < p.coefficients.length; i++){

				coefficients[i]-=p.coefficients[i];
			}
			
			degree = 0;

			for(int i = coefficients.length - 1; i >= 0 ; i--){

				if(coefficients[i]!=0){
	
					degree = i;
					break;
				}
			}
		}
	}
	
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		
		Polynomial  p = new Polynomial();
		
		if(coefficients.length == 1){

			p.coefficients = new int[] {0};
			p.degree = 0;

			return p;
		}

		p.coefficients = new int[coefficients.length - 1];
		
		for(int i = coefficients.length-1 ; i >= 1 ; i--){
			
			p.coefficients[i-1] = i*coefficients[i];
		}
		
		for(int i = p.coefficients.length - 1; i >= 0 ; i--){

				if(p.coefficients[i]!=0){
	
					p.degree = i;
					break;
				}
			}

		return p; //STUB
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {

		double value = 0;

		for(int i = 0; i< coefficients.length; i++){

			 value += coefficients[i]*Math.pow(arg, i) ;
		}

		return value; //STUB
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder("");

		if(this.degree == 0 && this.coefficients[0] == 0){

			sb.append(0);
			return sb.toString();
		}

		for(int i = coefficients.length - 1; i >=0 ; i--){

			if(coefficients[i] > 0){

				sb.append(" + ");
			}

			else if(coefficients[i] < 0){

				sb.append(" - ");
			}

			else{
				continue;
			}

			if(Math.abs(coefficients[i]) != 1 || i == 0){

				sb.append(Math.abs(coefficients[i]));
			}

			if (i > 1){

				sb.append("x^");
				sb.append(i);
			} 
			
			else if (i == 1){

				sb.append("x");
			}
			
			
		}

		return sb.toString(); //STUB
	}
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	
}
