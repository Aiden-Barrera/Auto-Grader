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
		
		for (int i = 0; i < coefficients.length; i++) {
			if (coefficients[i] != 0 ) {
				this.degree = i;
			}
		}
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		for (int i = 0; i < this.coefficients.length; i++) {
			this.coefficients[i] = this.coefficients[i] * factor;
		}
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
	    if (p.coefficients.length > this.coefficients.length) {
	        int[] temp = new int[p.coefficients.length];
	        
	        for (int i = 0; i < this.coefficients.length; i++) {
	            temp[i] = this.coefficients[i];
	        }
	        
	        for (int i = 0; i < p.coefficients.length; i++) {
	            temp[i] += p.coefficients[i];
	        }
	        
	        this.coefficients = temp;
	        
	    } else {
	        
	    	for (int i = 0; i < p.coefficients.length; i++) {
	            this.coefficients[i] += p.coefficients[i];
	        }
	    	
	    }
	    
	    this.degree = this.coefficients.length - 1;
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
	    if (p.coefficients.length > this.coefficients.length) {
	        int[] temp = new int[p.coefficients.length];
	        
	        for (int i = 0; i < this.coefficients.length; i++) {
	            temp[i] = this.coefficients[i];
	        }
	        
	        for (int i = 0; i < p.coefficients.length; i++) {
	            temp[i] -= p.coefficients[i];
	        }
	        
	        this.coefficients = temp;
	        
	    } else {
	        for (int i = 0; i < p.coefficients.length; i++) {
	            this.coefficients[i] -= p.coefficients[i];
	        }
	    }
	    
	    this.degree = this.coefficients.length - 1;
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		if (this.coefficients.length == 1 ) {
			return new Polynomial(new int[] {0});
		}
		
		int[] temp = new int[this.coefficients.length - 1];
		
		for (int i = 1; i < this.coefficients.length; i++) {
			temp[i-1] = this.coefficients[i] * i;
		}
		
		return new Polynomial(temp);
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		double value = 0;
		
		for (int i = 0; i < this.coefficients.length; i++) {
			value += Math.pow(arg, i) * this.coefficients[i];
		}
		
		return value;
	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    
	    for (int i = coefficients.length - 1; i >= 0; i--) {
	    	
	    	if (coefficients[i] == 0 ) {
	    		continue;
	    	} else 
	    	
	    	
	    	if (Math.abs(coefficients[i]) == coefficients[i]) {
	    		sb.append(" + ");
	    	} else {
	    		sb.append(" - ");
	    	}
	    	
	    	if (Math.abs(coefficients[i]) != 1 || i == 0) {
	            sb.append(Math.abs(coefficients[i]));
	        }
	    	
	    	if (i > 0) {
	            sb.append("x");
	            if (i > 1) {
	                sb.append("^").append(i);
	            }
	        }
	    }	
	    
	    if (sb.length() == 0) {
	        return "0";
	    }
	    
	    return sb.toString();
	}

	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	
}
