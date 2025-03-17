package polynomial;

public class QuadraticPolynomial extends Polynomial {
    private int A, B, C;

    public QuadraticPolynomial(int A, int B, int C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public double[] solve() {
        int D = B * B - 4 * A * C;
        if (D > 0) {
            double sqrtD = Math.sqrt(D);
            return new double[]{(-B + sqrtD) / (2 * A), (-B - sqrtD) / (2 * A)};
        } else if (D == 0) {
            return new double[]{-B / (2.0 * A)};
        } else {
            return new double[]{}; // No real solutions
        }
    }

    @Override
    public String toString() {
        return A + "x^2 + " + B + "x + " + C;
    }

    public static void main(String[] args) {
        QuadraticPolynomial quadratic = new QuadraticPolynomial(2, 3, 4);
        System.out.println("Quadratic Polynomial: " + quadratic);
        System.out.println("Solutions: " + java.util.Arrays.toString(quadratic.solve()));
    }
}
