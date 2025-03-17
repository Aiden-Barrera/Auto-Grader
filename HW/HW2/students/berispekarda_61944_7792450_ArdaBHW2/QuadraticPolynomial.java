package polynomial;

public class QuadraticPolynomial extends Polynomial {
    public QuadraticPolynomial(int a, int b, int c) {
        super(new int[]{c, b, a});
    }

    public double[] solve() {
        int a = coefficients[2], b = coefficients[1], c = coefficients[0];
        int disc = b * b - 4 * a * c;

        if (disc < 0) 
        return new double[]{};
        if (disc== 0) 
        return new double[]{-b / (2.0 * a)};

        double squrtDisc = Math.sqrt(disc);
        return new double[]{(-b + squrtDisc) / (2 * a), (-b - squrtDisc) / (2 * a)};
    }
}
