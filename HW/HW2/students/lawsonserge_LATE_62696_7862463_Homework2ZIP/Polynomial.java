//package polynomial;

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
		degree = coeffs.length -1;//DONE
		if (degree > 0 && coeffs[degree] == 0)
			degree --;
			
		coefficients = new int[degree + 1];
		for (int i = 0; i <= degree; i++) {
			coefficients[i] = coeffs[i];
		}
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		for (int i = 0; i < coefficients.length; i++){ //DONE
			coefficients[i] *= factor;
		}
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		//DONE
		int maxLength = Math.max(coefficients.length, p.coefficients.length);
        int[] result = new int[maxLength];
		for(int i = 0; i < maxLength; i++){
			if (i < coefficients.length) {
                result[i] += coefficients[i];
            }
            if (i < p.coefficients.length) {
                result[i] += p.coefficients[i];
            }
		}
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		//DONE
		int maxLength = Math.max(coefficients.length, p.coefficients.length);
        int[] result = new int[maxLength];
		for(int i = 0; i < maxLength; i++){
			if (i < coefficients.length) {
                result[i] += coefficients[i];
            }
            if (i < p.coefficients.length) {
                result[i] += p.coefficients[i];
            }
		}
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		//DONE
		if(coefficients.length == 1)
			return new Polynomial(new int[]{0});
		
		int[] deriv = new int[coefficients.length - 1];
	
		for (int i = 0; i < coefficients.length; i++){
			deriv[i-1] = coefficients[i]* i;
		}
		return new Polynomial(deriv); //STUB
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		//DONE
		int res = 0;
        int power = 1;

        for (int coef : coefficients) {
            res += coef * power;
            power *= arg;
        }
        return res; //STUB
	}
	@Override
	public String toString() {
		//TO DO
		String result = "";
		int degree = coefficients.length -1;

		for (int i=degree; i >= 0; i--){
			int coeff = coefficients[i];
			if (coeff == 0){
				continue;
			}
			if (result.equals("")){
				if(coeff >0){
					result +=" + ";
				}else{
					result +=" - ";
				}
			} else if (coeff<0){
				result += " - ";
			}
			if (i > 0){
				result+= "x";
				if (i > 1){
					result += "^" + i;
				}
			}
		}
		if (result.equals("")) {
			return "0";
		}
		return result; //STUB
	}
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	
}