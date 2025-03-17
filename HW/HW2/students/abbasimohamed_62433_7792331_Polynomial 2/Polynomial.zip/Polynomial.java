package polynomial;

public class Polynomial {
    protected int[] coefficients;
    protected int degree;

    public Polynomial() {
        coefficients = new int[1];
        coefficients[0] = 0;
        degree = 0;
    }

    public Polynomial(int[] coeffs) {
        if (coeffs == null || coeffs.length == 0) {
            coefficients = new int[1];
            coefficients[0] = 0;
            degree = 0;
        } else {
            int d = coeffs.length - 1;
            while (d > 0 && coeffs[d] == 0) {
                d--;
            }
            degree = d;
            coefficients = new int[d + 1];
            for (int i = 0; i < d + 1; i++) {
                coefficients[i] = coeffs[i];
            }
        }
    }

    public void multiplyBy(int factor) {
        if (factor == 0) {
            coefficients = new int[1];
            coefficients[0] = 0;
            degree = 0;
            return;
        }
        for (int i = 0; i < coefficients.length; i++) {
            coefficients[i] = coefficients[i] * factor;
        }
        int d = coefficients.length - 1;
        while (d > 0 && coefficients[d] == 0) {
            d--;
        }
        degree = d;
        if (d + 1 != coefficients.length) {
            int[] temp = new int[d + 1];
            for (int i = 0; i < d + 1; i++) {
                temp[i] = coefficients[i];
            }
            coefficients = temp;
        }
    }

    public void add(Polynomial p) {
        int maxLength = (this.coefficients.length > p.coefficients.length) ? this.coefficients.length : p.coefficients.length;
        int[] result = new int[maxLength];
        for (int i = 0; i < maxLength; i++) {
            int thisCoef = 0;
            int pCoef = 0;
            if (i < this.coefficients.length) {
                thisCoef = this.coefficients[i];
            }
            if (i < p.coefficients.length) {
                pCoef = p.coefficients[i];
            }
            result[i] = thisCoef + pCoef;
        }
        int d = maxLength - 1;
        while (d > 0 && result[d] == 0) {
            d--;
        }
        degree = d;
        int[] trimmed = new int[d + 1];
        for (int i = 0; i < d + 1; i++) {
            trimmed[i] = result[i];
        }
        coefficients = trimmed;
    }

    public void subtract(Polynomial p) {
        int maxLength = (this.coefficients.length > p.coefficients.length) ? this.coefficients.length : p.coefficients.length;
        int[] result = new int[maxLength];
        for (int i = 0; i < maxLength; i++) {
            int thisCoef = 0;
            int pCoef = 0;
            if (i < this.coefficients.length) {
                thisCoef = this.coefficients[i];
            }
            if (i < p.coefficients.length) {
                pCoef = p.coefficients[i];
            }
            result[i] = thisCoef - pCoef;
        }
        int d = maxLength - 1;
        while (d > 0 && result[d] == 0) {
            d--;
        }
        degree = d;
        int[] trimmed = new int[d + 1];
        for (int i = 0; i < d + 1; i++) {
            trimmed[i] = result[i];
        }
        coefficients = trimmed;
    }

    public Polynomial getDerivative() {
        if (degree == 0) {
            int[] der = new int[1];
            der[0] = 0;
            return new Polynomial(der);
        }
        int[] derCoeffs = new int[degree];
        for (int i = 1; i < coefficients.length; i++) {
            derCoeffs[i - 1] = i * coefficients[i];
        }
        return new Polynomial(derCoeffs);
    }

    public double atPoint(float arg) {
        double result = 0;
        for (int i = degree; i >= 0; i--) {
            result = result * arg + coefficients[i];
        }
        return result;
    }

    public String toString() {
        if (degree == 0 && coefficients[0] == 0) {
            return "0";
        }
        String s = "";
        for (int i = degree; i >= 0; i--) {
            int coef = coefficients[i];
            if (coef == 0) {
                continue;
            }
            if (!s.equals("")) {
                if (coef > 0) {
                    s = s + " + ";
                } else {
                    s = s + " - ";
                    coef = -coef;
                }
            } else {
                if (coef < 0) {
                    s = s + "-";
                    coef = -coef;
                }
            }
            if (i == 0 || coef != 1)
                s = s + coef;
            if (i > 0) {
                s = s + "x";
                if (i > 1) {
                    s = s + "^" + i;
                }
            }
        }
        return s;
    }

    public int getDegree() {
        return degree;
    }

    public double[] solve() {
        return null;
    }
}
