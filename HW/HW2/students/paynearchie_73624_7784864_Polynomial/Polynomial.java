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
		this.coefficients = coeffs;
		for(int i=coeffs.length-1; i>=0; i--) {
			if(coeffs[i]!=0) {
				this.degree = i;
				break;
			}
		}
		
	}
	
	public void checkDegree() {
		int[] coeffs=this.coefficients;
		for(int i=coeffs.length-1; i>=0; i--) {
			if(coeffs[i]!=0) {
				this.degree = i;
				break;
			}
		}
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		//TO DO
		for(int i=0; i<coefficients.length; i++) {
			coefficients[i]*=factor;
		}
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		//TO DO
		int end = p.degree;
		
		for(int i=0; i<=end; i++) {
			this.coefficients[i]+=p.coefficients[i];
		}
		checkDegree();
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		//TO DO
		int end = p.degree;
		
		for(int i=0; i<=end; i++) {
			this.coefficients[i]-=p.coefficients[i];
		}
		checkDegree();
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		//TO DO
		int[] derivCoeffs = new int[] {coefficients.length-1};
		for (int i=1; i<derivCoeffs.length; i++) {
			derivCoeffs[i-1]=coefficients[i]*i;
			System.out.println("test "+derivCoeffs[i-1]);
		}
		System.out.println("test "+derivCoeffs.length);
		Polynomial deriv = new Polynomial(derivCoeffs);
		checkDegree();
		return deriv; //STUB
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
	    double sum = 0;
	    
	    for (int i = 0; i <= degree; i++) {
	        double num = coefficients[i];
	        sum += num * (Math.pow(arg, i));
	        System.out.println(num * (Math.pow(arg, i)));
	    }
	    
	    return sum;
	}
	
	@Override
	public String toString() {
		//TO DO
		String myPoly = "";
		for(int i=this.degree; i>=0; i--) {
			int coeff = coefficients[i];
			int deg = i;
			if(coeff!=0) {
				
				if(coeff>0) {
					myPoly+=" + ";
				}
				else {
					myPoly+=" - ";
				}
				
				if(coeff>1 || coeff<-1) {
					myPoly+= Math.abs(coeff);
				}
				
				if(deg>1) {
					myPoly+="x^"+deg;
				}
				else if(deg==1) {
					myPoly+="x";
				}

			}
		}
		return myPoly; //STUB
	}
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	
}
