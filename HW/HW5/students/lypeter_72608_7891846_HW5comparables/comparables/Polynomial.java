package comparables;

/**
 * 
 * This class represent a polynomial
 * 
 */
public class Polynomial implements Comparable<Polynomial> {
	protected int[] coefficients;
	protected int degree;
	
	public Polynomial() {
		// Default polynomial is 0
		coefficients = new int[] {0};
		degree = 0;
	}
		
	/* Construct the polynomial given it's coefficients */ 
	public Polynomial(int[] coeffs) {
		//If empty or null:
		if ((coeffs == null) || (coeffs.length == 0)){
			coefficients = new int[]{0};
			degree = 0;
		}
		// If degree is 0:
		else if (coeffs.length == 1) {
			this.coefficients = new int[] {coeffs[0]};
			degree = 0;
		}
		else {
			// Find highest non zero coefficient
			int i = coeffs.length - 1;
			while (i > 0) {
				if (coeffs[i] != 0) {
					degree = i;
					this.coefficients = new int[i+1];
					break;
				}
				else {
					--i;
				}
			}
			// if i == 0, all coeff were 0
			if (i != 0) {
				for (int j = 0; j <= i; ++j) {
					coefficients[j] = coeffs[j]; 
				}
			} else {
				coefficients = new int[]{0};
				degree = 0;
			}
		}
	}
	
	@Override
	public String toString() {
		if (this.coefficients.length == 1) {
			return " " + String.valueOf(this.coefficients[0]);
		}
		
		String poly = "";
		// print coeff
		for (int i = degree; i > 0; i--) {
			if (coefficients[i] == 1) {
				poly += " + ";
			}
			else if (coefficients[i] == -1) {
				poly += " - ";
			}
			else if (coefficients[i] > 0) {
            	poly += " + " + coefficients[i];
            }
            else if (coefficients[i] < 0) {
            	poly += " - " + (-coefficients[i]);
            }
            else {
            	continue;
            }
			
			//print powers
            if (i == 1) {
            	poly += "x";
            }
            else if (i >  1) {
            	poly += "x^" + i;
            }
		}
		// a_0
		if (coefficients[0] > 0) {
			poly += " + " + String.valueOf(coefficients[0]);
		}
		else if (coefficients[0] < 0) {
			poly += " - " + String.valueOf(-coefficients[0]);
		}
		return poly;
	}
	
	public int getDegree() {
		return degree;
	}

	@Override
	public int compareTo(Polynomial o) {
		// is greater if has greater degree but if same degree then compare coefficients individually
		//returns 1 if greater, -1 if less than, 0 if equal
		if(getDegree()>o.getDegree()) {
			return 1;
		}else if(getDegree()<o.getDegree()) {
			return -1;
		}else{
			for(int i=coefficients.length-1;i>=0;i--) {
				if(coefficients[i]>o.coefficients[i]) {
					return 1;
				}else if(coefficients[i]<o.coefficients[i]) {
					return -1;
				}
			}
			return 0;
		}
	}
	
}
