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
		for(int i = coeffs.length - 1; i >= 0; i--){
			if(coeffs[i] != 0){
				degree = i;
				break;
			}
		}
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		for(int i = 0; i < coefficients.length; i++){
			coefficients[i] *= factor;
		}
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		int[] temp;
		if(p.degree > degree) {
			temp = new int[p.coefficients.length];
		}else {
			temp = new int[coefficients.length];
		}
		for(int i = 0; i < coefficients.length; i++){
			if(i > degree) {
				temp[i] = p.coefficients[i];
			}else if(i > p.degree) {
				temp[i] = coefficients[i];
			}else {
				temp[i] = coefficients[i] + p.coefficients[i];
			}
		}
		coefficients = temp;
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		int[] temp;
		if(p.degree > degree) {
			temp = new int[p.coefficients.length];
		}else {
			temp = new int[coefficients.length];
		}
		for(int i = 0; i < coefficients.length; i++){
			if(i > degree) {
				temp[i] = -1 * p.coefficients[i];
			}else if(i > p.degree) {
				temp[i] = coefficients[i];
			}else {
				temp[i] = coefficients[i] - p.coefficients[i];
			}
		}
		coefficients = temp;
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		int[] derivative = new int[coefficients.length - 1];
		for(int i = 1; i < coefficients.length; i++) {
			derivative[i - 1] = coefficients[i] * i;
		}
		return new Polynomial(derivative);
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		double num = coefficients[0];
		for(int i = 1; i < coefficients.length; i++) {
			num += coefficients[i] * Math.pow(arg, i);
		}
		return num;
	}
	@Override
	public String toString() {
		String poly = "";
		for(int i = coefficients.length - 1; i >= 0; i--) {
			if(coefficients[i] != 0) {
				if(coefficients[i] < 0) {
					poly += " - ";
				}else {
					poly += " + ";
				}
				if(i > 1) {
					if(Math.abs(coefficients[i]) == 1) {
						poly += "x^" + i;
					}else {
						poly += Math.abs(coefficients[i]) + "x^" + i;
					}
				}else if(i == 1) {
					if(Math.abs(coefficients[i]) == 1) {
						poly += "x";
					}else {
						poly += Math.abs(coefficients[i]) + "x";
					}
				}else{
					poly += Math.abs(coefficients[i]);
				}
			}
		}
		if(degree == 0 && coefficients[0] == 0) {
			return "0";
		}
		return poly;
	}
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	
}
