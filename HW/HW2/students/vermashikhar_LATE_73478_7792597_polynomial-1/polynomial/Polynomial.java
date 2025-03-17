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

	/* Construct the polynomial given its coefficients */
	public Polynomial(int[] coeffs) {
		coefficients=coeffs; // sets the field equal to the array passed through
		degree=degreeChecker(coefficients); // default degree
	}
	public int degreeChecker(int[] coeffs){ // a method that checks what the degree of the polynomial is
		int degreeVal=0;
		for(int i=coeffs.length-1;i>=0;i--){
			if(coeffs[i]==0){ // if the value is zero we skip the current instance and move on to the next
				continue;
			}
			else{ // if the value is not zero then the there is an actual term where we gather the degree
				degreeVal=i;
				return degreeVal;
			}
		}
		return degreeVal; // returns a zero for the default degree
	}
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		for(int i=0;i< coefficients.length;i++){// multiplies every element in the array by the factor
			coefficients[i]*=factor;
		}
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		int[] pVals=p.coefficients;// gets the array from the object passed through
		for(int i=0;i< pVals.length;i++){// iterates through the array from the p object and adds the values to the polynomial
			coefficients[i]+=pVals[i];
		}
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		//TO DO
		int[] pVals=p.coefficients;
		for(int i=0;i<pVals.length;i++){ // iterates through the p object array and subtracts the values are subtracted from the polynomial
			coefficients[i]-=pVals[i];
		}
		degree=degreeChecker(coefficients); // checks the degree of the function and if it has changed the value will be different
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		//TO DO
		int[] derivativeList=new int[coefficients.length];
		for(int i=coefficients.length-1;i>0;i--){
			derivativeList[i-1]=coefficients[i]*i;
		}
		Polynomial derivative=new Polynomial(derivativeList);
		return derivative; //STUB
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		//TO DO
		double[] valArray=new double[coefficients.length];
		valArray[0]=coefficients[0]; // sets the constant value of the value array to be the same as the coefficients list because it will never change
		for(int i= coefficients.length-1;i>0;i--){// calculates the value of each x-term and sets it to the corresponding value in the valArray list
			valArray[i]=(double)(coefficients[i]*Math.pow(arg,i));
		}
		double sum=0;
		for(double num:valArray){ // sums up all the values in the valArray because all the x-terms have been calculated in the previous list, and the constant
			sum+=num;
		}
		return sum; //STUB
	}
	@Override
	public String toString() {
		//TO DO
		String polynomial="";
		for(int i=coefficients.length-1;i>=0;i--){
			if(coefficients[i]==0){// if the value of a term in the polynomial is 0, we skip it and move on to the next index
				continue;
			}
			else{
				if(i==0){// if the index is 0 then the value is a non-zero coefficient
					polynomial+=Integer.toString(coefficients[i]);
				}
				else if(i==1){// if the index is 1 then the value is a non-zero x terms with a degree of 1, that means the degree value doesn't show and is simply an x times the element at the index
					polynomial+=Integer.toString(coefficients[i])+"x";
				}
				else{// if the index is >1 then the value is a non-zero x terms with a degree >1, that means the degree value showa and is simply an x to the power of the index, times the element at the index
					polynomial+="+"+Integer.toString(coefficients[i])+"x^"+Integer.toString(i);
				}
			}
		}
		return String.format("%s, degree %s",polynomial,degree); //formats the polynomial to display along with the degree
	}
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	
}
