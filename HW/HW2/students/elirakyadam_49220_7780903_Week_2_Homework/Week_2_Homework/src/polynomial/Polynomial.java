package polynomial;

/**
 * This class represents a polynomial.
 */
public class Polynomial {
    protected int[] coefficients;
    protected int degree;

    public Polynomial() {
        coefficients = new int[]{0};
        degree = 0;
    }

    /* Construct the polynomial given its coefficients */
    public Polynomial(int[] coeffs) {
        int d = coeffs.length - 1;
        while (d > 0 && coeffs[d] == 0) {
            d--;
        }
        degree = d;
        coefficients = new int[d + 1];
        System.arraycopy(coeffs, 0, coefficients, 0, d + 1);
    }

    /* Multiply this polynomial by a constant factor */
    public void multiplyBy(int factor) {
        for (int i = 0; i <= degree; i++) {
            coefficients[i] *= factor;
        }
    }

    /* Adds the polynomial p to this polynomial */
    public void add(Polynomial p) {
        int maxDegree = Math.max(degree, p.degree);
        int[] newCoeffs = new int[maxDegree + 1];

        for (int i = 0; i <= maxDegree; i++) {
            int a = (i <= degree) ? coefficients[i] : 0;
            int b = (i <= p.degree) ? p.coefficients[i] : 0;
            newCoeffs[i] = a + b;
        }

        coefficients = newCoeffs;
        degree = maxDegree;
    }

    /* Subtract the polynomial p from this polynomial */
    public void subtract(Polynomial p) {
        int maxDegree = Math.max(degree, p.degree);
        int[] newCoeffs = new int[maxDegree + 1];

        for (int i = 0; i <= maxDegree; i++) {
            int a = (i <= degree) ? coefficients[i] : 0;
            int b = (i <= p.degree) ? p.coefficients[i] : 0;
            newCoeffs[i] = a - b;
        }

        coefficients = newCoeffs;
        degree = maxDegree;
    }

    /* Returns the polynomial derivative of this polynomial */
    public Polynomial getDerivative() {
        if (degree == 0) return new Polynomial(new int[]{0});

        int[] derivativeCoeffs = new int[degree];
        for (int i = 1; i <= degree; i++) {
            derivativeCoeffs[i - 1] = coefficients[i] * i;
        }
        return new Polynomial(derivativeCoeffs);
    }

    /* Returns the value of the polynomial at a point */
    public double atPoint(float arg) {
        double result = 0;
        for (int i = 0; i <= degree; i++) {
            result += coefficients[i] * Math.pow(arg, i);
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
                sb.append(Math.abs(coefficients[i]));
                if (i > 0) {
                    sb.append("x");
                    if (i > 1) {
                        sb.append("^").append(i);
                    }
                }
            }
        }
        return sb.toString().isEmpty() ? "0" : sb.toString();
    }

    public int getDegree() {
        return degree;
    }

    public double[] solve() {
        return null;
    }
}
