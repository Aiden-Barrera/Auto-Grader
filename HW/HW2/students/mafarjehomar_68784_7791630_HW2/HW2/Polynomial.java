package polynomial;

public class Polynomial {
    protected int[] coefficients;
    protected int degree;

    public Polynomial() {
        coefficients = new int[]{0};
        degree = 0;
    }

    public Polynomial(int[] coeffs) {
        int d = coeffs.length - 1;
        while (d > 0 && coeffs[d] == 0) {
            d--;
        }
        degree = d;
        coefficients = new int[d + 1];
        for (int i = 0; i <= d; i++) {
            coefficients[i] = coeffs[i];
        }
    }

    public void multiplyBy(int factor) {
        if (factor == 0) {
            coefficients = new int[]{0};
            degree = 0;
            return;
        }
        for (int i = 0; i <= degree; i++) {
            coefficients[i] *= factor;
        }
    }

    public void add(Polynomial p) {
        int maxDegree = Math.max(this.degree, p.degree);
        int[] newCoefficients = new int[maxDegree + 1];

        for (int i = 0; i <= maxDegree; i++) {
            if (i <= this.degree && i <= p.degree) {
                newCoefficients[i] = this.coefficients[i] + p.coefficients[i];
            } else if (i <= this.degree) {
                newCoefficients[i] = this.coefficients[i];
            } else {
                newCoefficients[i] = p.coefficients[i];
            }
        }

        this.coefficients = newCoefficients;
        this.degree = maxDegree;

        while (degree > 0) {
            if (coefficients[degree] == 0) {
                degree--;
            } else {
                break;
            }
        }
    }

    public void subtract(Polynomial p) {
        int maxDegree = Math.max(this.degree, p.degree);
        int[] newCoefficients = new int[maxDegree + 1];

        for (int i = 0; i <= maxDegree; i++) {
            if (i <= this.degree && i <= p.degree) {
                newCoefficients[i] = this.coefficients[i] - p.coefficients[i];
            } else if (i <= this.degree) {
                newCoefficients[i] = this.coefficients[i];
            } else {
                newCoefficients[i] = -p.coefficients[i];
            }
        }

        this.coefficients = newCoefficients;
        this.degree = maxDegree;

        while (degree > 0) {
            if (coefficients[degree] == 0) {
                degree--;
            } else {
                break;
            }
        }
    }

    public Polynomial getDerivative() {
        if (this.degree == 0) {
            return new Polynomial(new int[]{0});
        }
        int[] derivativeCoefficients = new int[this.degree];
        for (int i = 1; i <= this.degree; i++) {
            derivativeCoefficients[i - 1] = this.coefficients[i] * i;
        }
        return new Polynomial(derivativeCoefficients);
    }

    public double atPoint(float arg) {
        double result = 0;
        for (int i = 0; i <= this.degree; i++) {
            result += this.coefficients[i] * Math.pow(arg, i);
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        boolean firstTerm = true;

        for (int i = this.degree; i >= 0; i--) {
            int coeff = this.coefficients[i];

            if (coeff == 0) continue;

            if (firstTerm) {
                firstTerm = false;
            } else {
                result.append(coeff > 0 ? " + " : " - ");
            }

            if (Math.abs(coeff) != 1 || i == 0) {
                result.append(Math.abs(coeff));
            }

            if (i > 0) {
                result.append("x");
                if (i > 1) {
                    result.append("^").append(i);
                }
            }
        }
        return firstTerm ? "0" : result.toString();
    }

    public int getDegree() {
        return degree;
    }

    public double[] solve() {
        return null;
    }
}
