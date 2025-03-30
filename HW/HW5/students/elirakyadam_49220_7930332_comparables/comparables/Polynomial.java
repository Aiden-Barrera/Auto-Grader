package comparables;

public class Polynomial implements Comparable<Polynomial> {
    private int degree;
    private int[] coefficients;

    public Polynomial(int degree, int[] coefficients) {
        this.degree = degree;
        this.coefficients = coefficients;
    }

    @Override
    public int compareTo(Polynomial o) {
        // Compare degrees first
        if (this.degree != o.degree) {
            return Integer.compare(this.degree, o.degree);
        }

        // If degrees are equal, compare coefficients from highest degree down
        for (int i = this.degree; i >= 0; i--) {
            if (this.coefficients[i] != o.coefficients[i]) {
                return Integer.compare(this.coefficients[i], o.coefficients[i]);
            }
        }

        // If all coefficients are the same, polynomials are equal
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = degree; i >= 0; i--) {
            if (coefficients[i] != 0) {
                sb.append(coefficients[i]).append("x^").append(i).append(" + ");
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 3) : "0";
    }
}
