package polynomial;

public class LinearPolynomial extends Polynomial {
    private int a, b;

    public LinearPolynomial(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public double value(double x) {
        return a * x + b;
    }

    @Override
    public String toString() {
        return a + "x + " + b;
    }

    public static void main(String[] args) {
        LinearPolynomial polynomial = new LinearPolynomial(2, 3);
        System.out.println("Linear Polynomial: " + polynomial);
        System.out.println("Value at x=5: " + polynomial.value(5));
    }
}

