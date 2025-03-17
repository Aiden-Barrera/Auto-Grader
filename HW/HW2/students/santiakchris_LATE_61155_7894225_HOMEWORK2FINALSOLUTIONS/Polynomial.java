package polynomial;

import java.util.Arrays;

public class Polynomial {
    protected int[] coefficients;
    protected int degree;

    public Polynomial() {
        this(new int[]{0});
    }

    public Polynomial(int[] coeffs) {
        this.coefficients = trimLeadingZeros(coeffs);
        this.degree = this.coefficients.length - 1;
    }

    private int[] trimLeadingZeros(int[] coeffs) {
        int i = coeffs.length - 1;
        while (i > 0 && coeffs[i] == 0) {
            i--;
        }
        return Arrays.copyOf(coeffs, i + 1);
    }

    public void multiplyBy(int factor) {
        for (int i = 0; i <= degree; i++) {
            coefficients[i] *= factor;
        }
    }

    public void add(Polynomial p) {
        this.coefficients = performOperation(p, true);
        this.degree = this.coefficients.length - 1;
    }

    public void subtract(Polynomial p) {
        this.coefficients = performOperation(p, false);
        this.degree = this.coefficients.length - 1;
    }

    private int[] performOperation(Polynomial p, boolean isAddition) {
        int maxDegree = Math.max(this.degree, p.degree);
        int[] result = new int[maxDegree + 1];
        
        for (int i = 0; i <= maxDegree; i++) {
            int a = (i <= this.degree) ? this.coefficients[i] : 0;
            int b = (i <= p.degree) ? p.coefficients[i] : 0;
            result[i] = isAddition ? a + b : a - b;
        }
        return trimLeadingZeros(result);
    }

    public Polynomial getDerivative() {
        if (degree == 0) return new Polynomial(new int[]{0});
        
        int[] derivativeCoeffs = new int[degree];
        for (int i = 1; i <= degree; i++) {
            derivativeCoeffs[i - 1] = coefficients[i] * i;
        }
        return new Polynomial(derivativeCoeffs);
    }

    public double atPoint(float arg) {
        double result = 0;
        for (int i = 0; i <= degree; i++) {
            result += coefficients[i] * Math.pow(arg, i);
        }
        return result;
    }

    @Override
    public String toString() {
        if (degree == 0 && coefficients[0] == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        for (int i = degree; i >= 0; i--) {
            if (coefficients[i] != 0) {
                if (sb.length() > 0) {
                    sb.append(coefficients[i] > 0 ? " + " : " - ");
                } else if (coefficients[i] < 0) {
                    sb.append("-");
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
    
    public double[] solve() {
        return new double[0];
    }
}
