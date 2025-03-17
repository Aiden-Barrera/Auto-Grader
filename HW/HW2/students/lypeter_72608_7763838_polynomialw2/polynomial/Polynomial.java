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
		int beforeNumber = 1; //1 is there to account for -1 to length of array
		for(int i=0;i<coefficients.length;i++) {
			if(coefficients[i]!=0) {
				break;
			}else {
				beforeNumber++;
			}
		}
		
		if(coefficients.length-beforeNumber<0) {
			degree=0;
		}else {
			degree=coefficients.length-beforeNumber;
		}
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		for(int i=0; i<coefficients.length;i++) {
			coefficients[i]*=factor;
		}
	}
	
	/* Adds the polynomial p to this polynomial */
	//argument polynomial doesn't change but current does
	public void add(Polynomial p) {
		if(p.getDegree()>getDegree()){
			degree = p.getDegree();
		}
		int[]newCoeff = new int[degree+1];
		int pos = 1;
		for(int i=coefficients.length-1;i>=0;i--) {
			newCoeff[newCoeff.length-pos]+=coefficients[i];
			if(pos<newCoeff.length) {
				pos++;
			}
		}
		pos = 1;
		for(int i=p.coefficients.length-1;i>=0;i--) {
			newCoeff[newCoeff.length-pos]+=p.coefficients[i];
			if(pos<newCoeff.length) {
				pos++;
			}
		}
		coefficients=newCoeff;
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		if(p.getDegree()>getDegree()){
			degree = p.getDegree();
		}
		int[]newCoeff = new int[degree+1];
		int pos = 1;
		for(int i=coefficients.length-1;i>=0;i--) {
			newCoeff[newCoeff.length-pos]+=coefficients[i];
			if(pos<newCoeff.length) {
				pos++;
			}
		}
		pos = 1;
		for(int i=p.coefficients.length-1;i>=0;i--) {
			newCoeff[newCoeff.length-pos]-=p.coefficients[i];
			if(pos<newCoeff.length) {
				pos++;
			}
		}
		coefficients=newCoeff;
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		int[]ddxInts = coefficients;
		int pow = 1;
		for(int i=ddxInts.length-1;i>=1;i--) {
			if(pow==1) {
				ddxInts[i]=ddxInts[i-1];
				ddxInts[i-1] = 0;
			}else {
				ddxInts[i]=ddxInts[i-1]*pow;
				ddxInts[i-1] = 0;
			}
			pow++;
		}
		Polynomial ddxPoly = new Polynomial(ddxInts);	
		return ddxPoly;
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		double result = 0;
		double pow = 0;
		for(int i=coefficients.length-1;i>=0;i--) {
			result+=coefficients[i]*Math.pow(arg, pow);
			pow++;
		}
		return result;
	}
	@Override
	public String toString() {
		String polyText = "";
		for(int i=0;i<coefficients.length;i++) {
			if(coefficients[i]!=0 && i!=coefficients.length-1) {
				polyText+=(""+coefficients[i]+"x^"+(coefficients.length-1-i));
			}else if(coefficients[i]!=0) {
				polyText+=(""+coefficients[i]+"");
			}
			if(polyText.length()>0 && i<coefficients.length-1 && coefficients[i+1]!=0) {
				polyText+=" + ";
			}
		}
		if(polyText.length()==0){
			return "0";
		}else {
			return polyText;
		}
	}
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	
}
