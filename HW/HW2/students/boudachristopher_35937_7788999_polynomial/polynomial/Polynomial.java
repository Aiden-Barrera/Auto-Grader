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
		//TO DO
		int firstNonZero = 0;
		while(firstNonZero < coeffs.length && coeffs[firstNonZero] == 0){
			firstNonZero++;
		}
		if (firstNonZero == coeffs.length){
			this.coefficients = new int[]{0};
			this.degree = 0;
		} else {
			this.coefficients = new int[coeffs.length - firstNonZero];
			System.arraycopy(coeffs, firstNonZero, this.coefficients, 0, this.coefficients.length);
			this.degree = this.coefficients.length - 1;
		}
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		//TO DO
		if (factor == 0){
			coefficients = new int[]{0};
			degree = 0;
			return;
		}
		for (int i = 0; i < coefficients.length; i++){
			coefficients[i] *= factor;
		}
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		//TO DO
		int maxDegree = Math.max(this.degree, p.degree);
		int[] newCoefficients = new int[maxDegree + 1];
		for (int i = 0; i <= this.degree; i++){
			newCoefficients[i + (maxDegree - this.degree)] = this.coefficients[i];
		}
		for (int i = 0; i <= p.degree; i++){
			newCoefficients[i + (maxDegree - p.degree)] += p.coefficients[i];
		}

		int firstNonZero = 0;
		while(firstNonZero < newCoefficients.length && newCoefficients[firstNonZero] == 0){
			firstNonZero++;
		}

		if(firstNonZero == newCoefficients.length){
			this.coefficients = new int[]{0};
			this.degree = 0;
		}else{
			this.coefficients = new int[newCoefficients.length - firstNonZero];
			System.arraycopy(newCoefficients, firstNonZero, this.coefficients, 0, this.coefficients.length);
			this.degree = this.coefficients.length - 1;
		}
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		//TO DO
		int maxDegree = Math.max(this.degree, p.degree);
		int [] newCoefficients = new int[maxDegree + 1];

		for (int i = 0; i <= this.degree; i++){
			newCoefficients[i + (maxDegree - this.degree)] = this.coefficients[i];
		}

		for (int i = 0; i <= p.degree; i++){
			newCoefficients[i + (maxDegree - p.degree)] -= p.coefficients[i];
		}

		int firstNonZero = 0;
		while (firstNonZero < newCoefficients.length && newCoefficients[firstNonZero] == 0){
			firstNonZero++;
		}

		if(firstNonZero == newCoefficients.length){
			this.coefficients = new int[]{0};
			this.degree = 0;
		} else{
			this.coefficients = new int[newCoefficients.length - firstNonZero];
			System.arraycopy(newCoefficients, firstNonZero, this.coefficients, 0, this.coefficients.length);
			this.degree = this.coefficients.length-1;
		}
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		//TO DO
		//return this; //STUB
		if (degree == 0){
			return new Polynomial(new int[]{0});
		}

		int[] derivativeCoefficients = new int[degree];

		for (int i = 0; i < degree; i++){
			derivativeCoefficients[i] = coefficients[i] * (degree - i);
		}
		return new Polynomial(derivativeCoefficients);
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		//TO DO
		double result = 0;
		int exponent = degree;
		for(int coeff : coefficients){
			result = result * arg + coeff;
		}
		return result; //STUB
	}
	@Override
	public String toString() {
		//TO DO
		StringBuilder sb = new StringBuilder();
		int n = degree;

		for (int i = 0; i < coefficients.length; i++){
			int coeff = coefficients[i];
			if (coeff == 0) continue;;
			if (sb.length() > 0){
				sb.append(coeff > 0 ? " + " : " - ");
			} else if (coeff < 0){
				sb.append("-");
			}

			int absCoeff = Math.abs(coeff);

			if (n == 0){
				sb.append(absCoeff);
			}else if (n == 1){
				if (absCoeff != 1){
					sb.append(absCoeff).append("x");
				}else {
					sb.append("x");
				}
			}else {
				if (absCoeff != 1){
					sb.append(absCoeff).append("x^").append(n);
				} else {
					sb.append("x^").append(n);
				}
			}

			n--;
		}
		if (sb.length() == 0){
			return "0";
		}
		return sb.toString();
		 //STUB
	}
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	
}
