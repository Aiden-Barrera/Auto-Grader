package polynomial;

public class QuadraticPolynomial extends Polynomial {
    
    public QuadraticPolynomial(int A, int B, int C) {
        super(new int[]{C, B, A}); 
    }

    @Override
    public double[] solve() {
        int A = coefficients[2];
        int B = coefficients[1];
        int C = coefficients[0];

        if (A == 0) {
            return new LinearPolynomial(B, C).solve(); 
        }

        double discriminant = B * B - 4 * A * C;

        if (discriminant < 0) {
            return new double[]{}; 
        } else if (discriminant == 0) {
            return new double[]{-B / (2.0 * A)}; 
        } else {
            double sqrtD = Math.sqrt(discriminant);
            return new double[]{
                (-B + sqrtD) / (2.0 * A),
                (-B - sqrtD) / (2.0 * A)
            };
        }
    }
}
