
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
        if (coeffs == null || coeffs.length == 0) {
            throw new IllegalArgumentException("Coefficient array cannot be null or empty");
        }
        // Determine the actual degree by ignoring leading zeros
        int highestDegree = coeffs.length - 1;
        while (highestDegree > 0 && coeffs[highestDegree] == 0) {
            highestDegree--;
        }
        // Copy only the relevant part of the array
        this.degree = highestDegree;
        this.coefficients = new int[highestDegree + 1];
        System.arraycopy(coeffs, 0, this.coefficients, 0, highestDegree + 1);
    }
    /* Multiply this polynomial by a constant factor */
    public void multiplyBy(int factor) {
        for (int i = 0; i <= degree; i++) {
            coefficients[i] *= factor;
        }
    }
    /* Adds the polynomial p to this polynomial */
    public void add(Polynomial p) {
        int maxDegree = Math.max(this.degree, p.degree);
        int[] newCoeffs = new int[maxDegree + 1];
        for (int i = 0; i <= maxDegree; i++) {
            int coeff1 = (i <= this.degree) ? this.coefficients[i] : 0;
            int coeff2 = (i <= p.degree) ? p.coefficients[i] : 0;
            newCoeffs[i] = coeff1 + coeff2;
        }
        this.coefficients = newCoeffs;
        this.degree = maxDegree;
    }
    /* Subtract the polynomial p from this polynomial */
    public void subtract(Polynomial p) {
        int maxDegree = Math.max(this.degree, p.degree);
        int[] newCoeffs = new int[maxDegree + 1];
        for (int i = 0; i <= maxDegree; i++) {
            int coeff1 = (i <= this.degree) ? this.coefficients[i] : 0;
            int coeff2 = (i <= p.degree) ? p.coefficients[i] : 0;
            newCoeffs[i] = coeff1 - coeff2;
        }
        this.coefficients = newCoeffs;
        this.degree = maxDegree;
    }
    /* Returns the polynomial derivative of this polynomial. 
     * Does NOT change this polynomial */
    public Polynomial getDerivative() {
        if (degree == 0) {
            return new Polynomial(new int[]{0});
        }
        
        int[] derivativeCoeffs = new int[degree];
        for (int i = 1; i <= degree; i++) {
            derivativeCoeffs[i - 1] = coefficients[i] * i;
        }
        return new Polynomial(derivativeCoeffs);
    }
    /* Returns the value of the polynomial at a point */
    public double atPoint(float arg) {
        double result = 0;
        for (int i = degree; i >= 0; i--) {
            result = result * arg + coefficients[i];
        }
        return result;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = degree; i >= 0; i--) {
            if (coefficients[i] != 0) {
                if (sb.length() > 0 && coefficients[i] > 0) {
                    sb.append(" + ");
                } else if (coefficients[i] < 0) {
                    sb.append(" - ");
                }
                int absCoeff = Math.abs(coefficients[i]);
                if (absCoeff != 1 || i == 0) {
                    sb.append(absCoeff);
                }
                if (i > 0) {
                    sb.append("x");
                    if (i > 1) {
                        sb.append("^").append(i);
                    }
                }
            }
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
