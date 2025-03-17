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
	
	// public static void main(String[] args){
	// 	Polynomial(new int[]{5,1,-2,0,3,0});
	// }
	/* Construct the polynomial given it's coefficients */ 

	public Polynomial(int[] coeffs) {

		this.coefficients = coeffs;

		for(int i=coeffs.length-1;i>=0;i--){

			if(coeffs[i]==0){
				continue;
			}
			if(coeffs[i]>0){
				System.out.print("+");
			}

			
			if(i==0){
				System.out.print(coeffs[i]);
			}
			else{
				System.out.println(coeffs[i]+"x^^"+i);
			}


		}
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		//TO DO
		for(int i=0;i<polynomial.length;i++){

		}
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		//TO DO
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		//TO DO
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		//TO DO
		return this; //STUB
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		//TO DO
		return 0; //STUB
	}
	@Override
	public String toString() {
		//TO DO
		return ""; //STUB
	}
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	

}
