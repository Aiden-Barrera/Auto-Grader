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
		int maxDegree=0;
		int zeroes = 0;
		for (int i=0; i < coeffs.length; i++){
			maxDegree=coeffs[i];
			if(maxDegree<i){
				maxDegree=i;
			}

			if(coeffs[i]==0){
				zeroes++;
		
			degree=coeffs[i];
			}

			int [] pArr=new int[] {maxDegree-zeroes};

			for(int j=0; j<pArr.length;  j++){
				if(coeffs[i]>0){
					pArr[j]=coeffs[i];
			}
		}
			coeffs=pArr;
			

		}
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		if (factor == 0) {
			coefficients = new int[]{0};
			degree = 0;
			return;
		}
	
		for (int i = 0; i < coefficients.length; i++) {
			coefficients[i] *= factor;
		}
	}	
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		int maxDegree=Math.max(coefficients.length, p.coefficients.length );
		for (int i=maxDegree; i>=0; i--){
			coefficients[i]+=p.coefficients[i];
		}


		}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		int maxDegree=Math.max(coefficients.length, p.coefficients.length );
		for (int i=maxDegree; i>=0; i--){
			coefficients[i]-=p.coefficients[i];
		}


	}	
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		if (coefficients.length == 1) {
			return new Polynomial(new int[]{0});
		}
	
		int[] derivativeCoeffs = new int[coefficients.length - 1];
	
		for (int i = 1; i < coefficients.length; i++) {
			derivativeCoeffs[i - 1] = coefficients[i] * i;
		}
	
		return new Polynomial(derivativeCoeffs);
	}
	
	/* Returns the value of the polynomial at a point */
		
		public double atPoint(float arg) {
			double result = 0;
			for (int i = coefficients.length - 1; i >= 0; i--) {
				result = result * arg + coefficients[i];
			}
			return result;
		}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = coefficients.length - 1; i >= 0; i--) {
			if (coefficients[i] == 0) continue; 
			
			if (sb.length() > 0){ 
			sb.append(coefficients[i] > 0 ? " + " : " - ");
			}
			if (Math.abs(coefficients[i]) != 1 || i == 0) {
			sb.append(Math.abs(coefficients[i]));
			}
			if (i > 0) sb.append("x").append(i > 1 ? "^" + i : "");
		}
	
		return sb.length() > 0 ? sb.toString() : "0";
	}
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	
}
