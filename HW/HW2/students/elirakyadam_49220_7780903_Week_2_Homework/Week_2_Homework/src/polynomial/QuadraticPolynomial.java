package polynomial;

public class QuadraticPolynomial extends Polynomial {
    // Creates a quadratic polynomial of the form Ax^2 + Bx + C
    public QuadraticPolynomial(int A, int B, int C) {
        super(new int[]{C, B, A}); // Coefficients for C + Bx + Ax^2
    }
    
    // Override polynomial.solve()
    @Override
    public double[] solve() {
        if (coefficients.length < 3) {
            return new double[]{}; // Not a valid quadratic equation
        }
        
        double a = coefficients[2];
        double b = coefficients[1];
        double c = coefficients[0];
        
        double discriminant = b * b - 4 * a * c;
        
        if (discriminant < 0) {
            return new double[]{}; // No real solutions
        } else if (discriminant == 0) {
            return new double[]{-b / (2 * a)}; // One real solution
        } else {
            double sqrtDiscriminant = Math.sqrt(discriminant);
            return new double[]{
                (-b + sqrtDiscriminant) / (2 * a),
                (-b - sqrtDiscriminant) / (2 * a)
            };
        }
    }
}
