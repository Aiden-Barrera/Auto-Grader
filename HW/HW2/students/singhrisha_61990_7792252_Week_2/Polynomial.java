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

		coefficients = new int[] {0};
		degree = 0;
	}
		
	/* Construct the polynomial given it's coefficients */ 
	public Polynomial(int[] coeffs) {
		
		this.coefficients = coeffs;
		
		for (int i = 0; i < coefficients.length; i++ ) {
			if(coefficients[i] != 0) {
				this.degree = i;
			}
		}
		
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		
		for (int i = 0; i < this.coefficients.length; i++) {
			coefficients[i] *= factor;
		}
		
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		
		int biggestDeg = Math.max(this.degree, p.degree);
		int [] sum = new int[biggestDeg + 1];
		
		for (int i = 0; i <= biggestDeg; i++) {
			
			if (i <= p.degree) 
				{
				sum[i] += p.coefficients[i];
				}
			
            if (i <= this.degree) 
            	{
            	sum[i] += this.coefficients[i];
            	}
            
        }

        this.coefficients = sum;
        this.degree = biggestDeg;
    }

	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
	    int biggestDeg = Math.max(this.degree, p.degree);
	    int[] difference = new int[biggestDeg + 1];

	    for (int i = 0; i <= biggestDeg; i++) {
	        if (i <= p.degree) {
	            difference[i] -= p.coefficients[i];
	        }

	        if (i <= this.degree) {
	            difference[i] += this.coefficients[i];
	        }
	    }

	    this.coefficients = difference;
	    this.degree = biggestDeg;
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		
		int[] der = new int[this.coefficients.length - 1];
		
		for (int i = 1; i < this.coefficients.length; i++) {
		    der[i-1] = this.coefficients[i] * i;
		}
	    
	    return new Polynomial(der);
	    
	}
	
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		double valueAtPoint = 0;
		
		for (int i = 0; i < this.coefficients.length; i++) {
			valueAtPoint += coefficients[i] * Math.pow(arg,  i);
		}
		
		return valueAtPoint; //STUB
	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();

	    for (int i = coefficients.length - 1; i >= 0; i--) {
	        if (coefficients[i] == 0) {
	            continue; 
	        }

	        if (coefficients[i] < 0) {
	            sb.append(" - ");
	        } else {
	        	sb.append(" + ");
	        }
	 

	        if (i == 0) {
	            sb.append(Math.abs(coefficients[i]));
	        } else if (Math.abs(coefficients[i]) != 1) {
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
	        sb.append("0");
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