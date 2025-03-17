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
		this.coefficients = coeffs;
		
		for (int i = coefficients.length - 1; i >0; i--) {
			if (coefficients[i] > 0 && i > 0) {
				this.degree = i;
			}
			else {
				this.degree = 0;
			}
		}
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		for (int i = 0; i < coefficients.length; i ++) {
			int num = coefficients[i] * factor;
			coefficients[i] = num;
		}
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		for (int i = 0; i < coefficients.length; i ++) {
			coefficients[i] = coefficients [i] + p.coefficients[i];
		}
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		for (int i = 0; i < coefficients.length; i ++) {
			coefficients[i] = coefficients [i] - p.coefficients[i];
		}
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		int derivative[] = {};
		for (int i = 0; i < coefficients.length; i ++) {
			int newNum;
			newNum = coefficients[i] * i;
			if (i - 1 != 0 && i - 1 > 0) {
				derivative[i - 1] = newNum;
			}
			
		}
		Polynomial p = new Polynomial(derivative);
		return p; //STUB
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		//I'm not quite sure what I was supposed to do for this one so 
		// i returned the coefficient value at a certain point
		double value = coefficients[(int) arg];
		return value; //STUB
	}
	
	@Override
	public String toString() {
		String str = "";
		for (int i = coefficients.length - 1; i >= 0; i --) {
			if (i > 1 && coefficients[i]!=0) {
				str.concat(String.valueOf(coefficients[i]) + "x^" + String.valueOf(i));
			}
			else if (i == 1) {
				str.concat(String.valueOf(coefficients[i]) + "x");
			}
			else {
				str.concat(String.valueOf(coefficients[i]));
			}
		}
		
		
		for (int i = coefficients.length - 1; i > 0; i --) {
			if (coefficients[i] != 0) {
				degree = i;
				
			}
		}
		str.concat(", Degree is " + String.valueOf(degree));
		return str; //STUB
	}
	
	public int getDegree() {
		for (int i = coefficients.length - 1; i > 0; i --) {
			if (coefficients[i] != 0) {
				degree = i;
				return degree;
			}
		}
		
		return 0;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	
	
	/*
	 *  something i coded for no reason
	 * String newEq  = "";
		List<String> poly = new ArrayList<>();
		for (int i = 0; i <= coeffs.length; i ++) {
			if (coeffs[i] != 0 && i == 0) {
				String str = String.valueOf(coeffs[i]);
				poly.add(str);
			}
			else if (coeffs[i] !=0 && i == 1){
				String str = String.valueOf(coeffs[i]) + "x";
				poly.add(str);
			}
			else if (coeffs[i] !=0 && i > 1) {
				String str = String.valueOf(coeffs[i]) + "x^" + String.valueOf(i);
				poly.add(str);
			}
			else {
				System.out.print("No polynomial exists!");
			}
			
		}
		for (int i = poly.size(); i != 0; i--) {
			newEq.concat(poly.get(i));
			if (i != 0) {
				newEq.concat("+");
			}
		}
	 */
	
	
}
