package comparables;

/**
 * This class represents a polynomial.
 */
public class Polynomial implements Comparable<Polynomial> {
    protected int[] coefficients;
    protected int degree;

    public Polynomial() {
        coefficients = new int[]{0};
        degree = 0;
    }

    public Polynomial(int[] coeffs) {
        if ((coeffs == null) || (coeffs.length == 0)) {
            coefficients = new int[]{0};
            degree = 0;
        }

        else if (coeffs.length == 1) {
            this.coefficients = new int[]{coeffs[0]};
            degree = 0;
        } else {

            int i = coeffs.length - 1;
            while (i > 0 && coeffs[i] == 0) {
                --i;
            }
            degree = i;
            this.coefficients = new int[i + 1];
            for (int j = 0; j <= i; ++j) {
                coefficients[j] = coeffs[j];
            }
        }
    }

    @Override
    public String toString() {
        if (this.coefficients.length == 1) {
            return " " + this.coefficients[0];
        }

        StringBuilder poly = new StringBuilder();
        for (int i = degree; i > 0; i--) {
            if (coefficients[i] == 1) {
                poly.append(" + ");
            } else if (coefficients[i] == -1) {
                poly.append(" - ");
            } else if (coefficients[i] > 0) {
                poly.append(" + ").append(coefficients[i]);
            } else if (coefficients[i] < 0) {
                poly.append(" - ").append(-coefficients[i]);
            } else {
                continue;
            }

            if (i == 1) {
                poly.append("x");
            } else if (i > 1) {
                poly.append("x^").append(i);
            }
        }

        if (coefficients[0] > 0) {
            poly.append(" + ").append(coefficients[0]);
        } else if (coefficients[0] < 0) {
            poly.append(" - ").append(-coefficients[0]);
        }

        return poly.toString();
    }

    public int getDegree() {
        return degree;
    }

    @Override
    public int compareTo(Polynomial o) {
        if (this.degree > o.degree) {
            return 1;
        } else if (this.degree < o.degree) {
            return -1;
        }

        for (int i = this.degree; i >= 0; i--) {
            if (this.coefficients[i] > o.coefficients[i]) {
                return 1;
            } else if (this.coefficients[i] < o.coefficients[i]) {
                return -1;
            }
        }

        return 0;
    }
}
