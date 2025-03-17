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

		for(int i= coeffs.length -1; i >= 0; i--) {	
			if (coeffs[i] != 0) {
				degree = i;	
				break; 	//allows it to break after finding first non-zero coefficient, otherwise itd keep going
			}
		}
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		for(int i= coefficients.length -1; i >= 0; i--) {
			coefficients[i] *= factor;	//store new product value into coefficients[i]
		}
		  for (int i = coefficients.length - 1; i >= 0; i--) {
		        if (coefficients[i] != 0) {
		            degree = i;	//update new degree
		            break;
		        }
		  }
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
        this.degree = Math.max(this.degree, p.degree);	//to determine the new size of coefficients array 
        int[] newCoeffs = new int[degree + 1];
        
        for (int i = 0; i <= this.degree; i++) {
        	newCoeffs[i] += this.coefficients[i]; //if index is less than degree length it will add in a 0 coefficient for that missing degree 
        }   //transferring this.coefficients to newCOeffs[i] where the correct size for the new larger degree will be at 
        
        for (int i = 0; i <= p.degree; i++) { 	//using each sig. polynomial(i<=p.degree) so that there's no indexOutOfBoundsException 
        	newCoeffs[i] += p.coefficients[i];
        	 //transferring + adding p.coefficients to newCOeffs[i] where the correct size for the new larger degree will be at 
        }  
        
        this.coefficients = newCoeffs;
        
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		
		degree = Math.max(this.degree, p.degree);
        int[] newCoeffs = new int[degree + 1];
        
        for (int i = 0; i <= this.degree; i++) {
        	newCoeffs[i] = this.coefficients[i];  
        }        
    
        for (int i = 0; i <= p.degree; i++) {
        	newCoeffs[i] -= p.coefficients[i];
        }  
        
        this.coefficients = newCoeffs;
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		int[] derivative  = new int[degree];
		
        for(int i = 1; i <=degree; i++) {
        	derivative[i-1] = coefficients[i] * i;
        }
        Polynomial result = new Polynomial(derivative);
        return result;	//the tester calls the toString when calling this method 
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		double value = 0;
        for(int i = 0; i <= degree; i++) {
        	value += coefficients[i] * Math.pow(arg,i);
        }
		return value; //STUB
	}
	@Override
	public String toString() {
		//TO DO
		StringBuilder sb = new StringBuilder();
		
	
		 for (int i = coefficients.length - 1; i >= 0; i--) {
			
	        if (coefficients[i] == 0) {
	            continue; 
	        }
		        if (sb.length() > 0 && coefficients[i] > 0) {
		            sb.append(" + ");
			        } else if (coefficients[i] < 0) {
			           sb.append("-");
			           coefficients[i] = -coefficients[i];
			        	//sb.append(coefficients[i]);
			        	//sb.append(Math.abs(coefficients[i]));
			    }
			        if (i == 0) {	//x^0
			            sb.append(coefficients[i]); 
				        } else if (i == 1) {	//x^1
				            sb.append(coefficients[i] + "x"); 
				        } else {	//x^n
				            sb.append(coefficients[i] + "x^" + i); 
			        }
				 }
		 return sb.toString();
	}
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		 if (coefficients.length == 2) {
			 int a = coefficients[1];
		     int b = coefficients[0];
		     return new double[] {(double)- b / a}; //unary comes before casting even with parentheses 
		 }else if (coefficients.length == 3){
			 int a = coefficients[2];
	         int b = coefficients[1];
	         int c = coefficients[0];
	         double squareRootPortion = Math.pow(b, 2) - 4 * a * c;	//squareRootPortion=discriminant
		         if (squareRootPortion > 0) {
			         double root1 = (-b + Math.sqrt(squareRootPortion)) / (2 * a);
		             double root2 = (-b - Math.sqrt(squareRootPortion)) / (2 * a);
		             return new double[] {root1, root2};
		         } else if (squareRootPortion == 0) {
		        	  double root = -b / (2.0 * a);
		              return new double[] {root};
		         } /*else {
		        	 return new double[] {};	//squareRootPortion<0
		         }*/
		 }
		return new double[] {};	//coefficients.length not 2 or 3 & //squareRootPortion<0
	}
	
}//end
















