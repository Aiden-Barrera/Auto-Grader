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
	/*
	 * Returns 1 if this > o
	 * Returns -1 if this < o
	 * Returns if this == o
	 */
	public int compareTo(Polynomial o) {
		// TO DO
		if (this.degree > o.degree)
			return 1;
		if (this.degree < o.degree)
			return -1;
		if (this.degree == o.degree) {
			int i = 0;
			while (i <= degree) {
				if (this.coefficients[degree-i] > o.coefficients[degree-i])
					return 1;
				if (this.coefficients[degree-i] < o.coefficients[degree-i])
					return -1;
				else
					i++;
			}
		}
		return 0;
	}
}