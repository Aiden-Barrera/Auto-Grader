package polynomial;

public class LinearPolynomial extends Polynomial {
    
    // Create a linear polynomial of the form ax + b
    public LinearPolynomial(int a, int b) {
        super(new int[]{b, a}); // Coefficients for bx + a (constant term first)
    }
    
    // Override polynomial.solve()
    @Override
    public double[] solve() {
        if (coefficients[1] == 0) {
            return new double[]{}; // No solution if the coefficient of x is 0
        }
        return new double[]{-coefficients[0] / (double) coefficients[1]}; // Solve ax + b = 0 -> x = -b/a
    }
}
