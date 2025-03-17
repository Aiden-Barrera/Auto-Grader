package polynomial;

public class LinearPolynomial extends Polynomial {

    // Constructor for a linear polynomial of the form ax + b
    public LinearPolynomial(int a, int b) {
        coefficients = new int[] {b, a};
        degree = 1;
    }

    @Override
    public double[] solve() {
        if (coefficients[1] == 0) {
            if (coefficients[0] == 0) {
                return new double[0];
            } else {
                return new double[0];
            }
        }
        
        double solution = - (double) coefficients[0] / coefficients[1];
        return new double[] {solution};
    }
}
