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
		//using a while loop to find the highest index which should be the degree of the polynomial
		int newDegree = coeffs.length - 1;
		while (newDegree > 0 && coeffs[newDegree] == 0) {
		    newDegree--;
		}
		
		this.degree = newDegree;		
		
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		//TO DO
		//for loop iterates through each coefficient and then multiplies it by the factor
		for(int i = 0 ; i < coefficients.length ; i++) {
			coefficients[i] *= factor;
		}
		
		
		
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		//TO DO
		
		int maxDegree = Math.max(this.degree, p.degree); //setting maxDegree to the highest value between this.degree and p.degree
	    int[] newCoeffs = new int[maxDegree + 1]; //creating new list of the length of the maxDegree +1
	    
	    //for loop
	    for (int i = 0; i <= this.degree; i++) {
	        newCoeffs[i] = this.coefficients[i];
	    }
	    for (int i = 0; i <= p.degree; i++) {
	        newCoeffs[i] += p.coefficients[i];
	    }

	    this.coefficients = newCoeffs;
	    this.degree = maxDegree;
		
		
		
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		//TO DO
		int maxDegree = Math.max(this.degree, p.degree);
	    int[] newCoeffs = new int[maxDegree + 1];

	    for (int i = 0; i <= this.degree; i++) {
	        newCoeffs[i] = this.coefficients[i];
	    }
	    for (int i = 0; i <= p.degree; i++) {
	        newCoeffs[i] -= p.coefficients[i];
	    }

	    this.coefficients = newCoeffs;
	    this.degree = maxDegree;
		
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		//TO DO
		if(this.degree == 0) {
			return new Polynomial(new int[] {0});
		}
		
		int[] derivativeCoeffs = new int[this.degree];
		
		for (int i = 1 ; i <= this.degree; i++) {
			derivativeCoeffs[i-1] = i*this.coefficients[i];
		}
		return new Polynomial(derivativeCoeffs);
		
		//STUB
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		//TO DO
		float result = 0;
		//for loop goes through all coefficients
		for(int i = 0; i<= this.degree; i++) {
			
			//calculate the value of the current term
			float term = this.coefficients[i]*(float) Math.pow(arg, i);
			result += term; //adding term to result 
		}
		return result;
		 //STUB
	}
	@Override
	public String toString() {
		//TO DO
		String result = "";
		for(int i = this.degree; i>=0; i--) {
			int coeff = this.coefficients[i];
			
			if(coeff == 0) continue;
			
			if(!result.isEmpty() && coeff >0) {
				result += " + ";
			}else if (coeff <0) {
				result += " - ";
				coeff = -coeff;
			}
			
			if(i == 0) {
				result += coeff;
			
			} else if (i==1) {
				result += coeff + "x";
			} else {
				result += coeff + "x" + i;
			}
			
		}
		
		if(result.isEmpty()) {
			return "0";
		}
		return result;
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
