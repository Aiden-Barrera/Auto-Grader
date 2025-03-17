package polynomial;

public class QuadraticPolynomial extends Polynomial {

    public QuadraticPolynomial(int A, int B, int C) {
        coefficients = new int[] {C, B, A};
        degree = 2; 
    }

    @Override
    public double[] solve() {
        int A = coefficients[2];
        int B = coefficients[1];
        int C = coefficients[0];

        double discriminant = B * B - 4 * A * C;

        if (discriminant < 0) {
            return new double[0];
        } else if (discriminant == 0) {
            // One real solution
            double solution = -B / (2.0 * A);
            return new double[] {solution};
        } else {
            // Two real solutions
            double sqrtDiscriminant = Math.sqrt(discriminant);
            double solution1 = (-B + sqrtDiscriminant) / (2.0 * A);
            double solution2 = (-B - sqrtDiscriminant) / (2.0 * A);
            return new double[] {solution1, solution2};
        }
    }
}
