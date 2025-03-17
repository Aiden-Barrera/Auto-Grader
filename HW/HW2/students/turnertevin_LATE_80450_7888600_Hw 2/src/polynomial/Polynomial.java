package polynomial;

public class Polynomial {
    protected int[] coefficients;
    protected int degree;

    public Polynomial() {
        coefficients = new int[]{0};
        degree = 0;
    }

    public Polynomial(int[] coeffs) {
        coefficients = coeffs;
        degree = coeffs.length - 1;
    }

    public void multiplyBy(int factor) {
        for (int i = 0; i < coefficients.length; i++) {
            coefficients[i] *= factor;
        }
    }

    public void add(Polynomial p) {
        int maxDegree = Math.max(this.degree, p.degree);
        int[] newCoefficients = new int[maxDegree + 1];

        for (int i = 0; i <= maxDegree; i++) {
            int thisCoeff = (i <= this.degree) ? this.coefficients[i] : 0;
            int pCoeff = (i <= p.degree) ? p.coefficients[i] : 0;
            newCoefficients[i] = thisCoeff + pCoeff;
        }

        this.coefficients = newCoefficients;
        this.degree = maxDegree;
    }

    public void subtract(Polynomial p) {
        int maxDegree = Math.max(this.degree, p.degree);
        int[] newCoefficients = new int[maxDegree + 1];

        for (int i = 0; i <= maxDegree; i++) {
            int thisCoeff = (i <= this.degree) ? this.coefficients[i] : 0;
            int pCoeff = (i <= p.degree) ? p.coefficients[i] : 0;
            newCoefficients[i] = thisCoeff - pCoeff;
        }

        this.coefficients = newCoefficients;
        this.degree = maxDegree;
    }

    public Polynomial getDerivative() {
        if (degree == 0) {
            return new Polynomial(new int[]{0});
        }

        int[] derivativeCoefficients = new int[degree];
        for (int i = 1; i <= degree; i++) {
            derivativeCoefficients[i - 1] = coefficients[i] * i;
        }

        return new Polynomial(derivativeCoefficients);
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
        StringBuilder polynomial = new StringBuilder();
        for (int i = degree; i >= 0; i--) {
            if (coefficients[i] != 0) {
                if (polynomial.length() > 0 && coefficients[i] > 0) {
                    polynomial.append(" + ");
                } else if (coefficients[i] < 0) {
                    polynomial.append(" - ");
                }
                int absCoeff = Math.abs(coefficients[i]);
                if (absCoeff != 1 || i == 0) {
                    polynomial.append(absCoeff);
                }
                if (i > 0) {
                    polynomial.append("x");
                }
                if (i > 1) {
                    polynomial.append("^").append(i);
                }
            }
        }
        return polynomial.toString();
    }

    public int getDegree() {
        return degree;
    }

    public double[] solve() {
        return null;
    }
}
