package comparables;

import java.util.Arrays;

public class Polynomial implements Comparable<Polynomial> {
    private int[] coefficients;

    public Polynomial(int[] coefficients) {
        this.coefficients = coefficients;
    }

    public int getDegree() {
        return coefficients.length - 1;
    }

    @Override
    public int compareTo(Polynomial other) {
        if (this.getDegree() > other.getDegree()) {
            return 1;
        } else if (this.getDegree() < other.getDegree()) {
            return -1;
        } else {
            for (int i = this.getDegree(); i >= 0; i--) {
                if (this.coefficients[i] > other.coefficients[i]) {
                    return 1;
                } else if (this.coefficients[i] < other.coefficients[i]) {
                    return -1;
                }
            }
            return 0; // They are equal
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(coefficients);
    }
}
