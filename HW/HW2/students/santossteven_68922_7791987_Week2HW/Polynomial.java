package polynomial;

/**
 * This class represent a polynomial,
 */
public class Polynomial {
    protected int[] coefficients;
    protected int degree;

    public Polynomial() {
        // Default polynomial is 0
        coefficients = new int[]{0};
        degree = 0;
    }

    /* Construct the polynomial given it's coefficients */
    public Polynomial(int[] coeffs) {
        //TO DO
        coefficients = new int[coeffs.length];

        for (int i = 0; i < coeffs.length; i++) {
            coefficients[i] = coeffs[i];
        }

        degree = 0;
        for (int i = coeffs.length - 1; i >= 0; i--) {
            if (coefficients[i] != 0) {
                degree = i;
                break;
            }
        }
    }

    /* Multiply this polynomial by a constant factor */
    public void multiplyBy(int factor) {
        //TO DO
        for (int i = 0; i < coefficients.length; i++) {
            coefficients[i] *= factor;
        }
    }

    /* Adds the polynomial p to this polynomial */
    public void add(Polynomial p) {
        //TO DO

        if (coefficients.length < p.coefficients.length) {
            int[] biggerArray = new int[p.coefficients.length];
            for (int i = 0; i < coefficients.length; i++) {
                biggerArray[i] = coefficients[i];
            }
            coefficients = biggerArray;
        }

        for (int i = 0; i < p.coefficients.length; i++) {
            coefficients[i] += p.coefficients[i];
        }

        degree = 0;
        for (int i = coefficients.length - 1; i >= 0; i--) {
            if (coefficients[i] != 0) {
                degree = i;
                break;
            }
        }
    }

    /* Subtract the polynomial p from this polynomial */
    public void subtract(Polynomial p) {
        //TO DO
        if (coefficients.length < p.coefficients.length) {
            int[] biggerArray = new int[p.coefficients.length];
            for (int i = 0; i < coefficients.length; i++) {
                biggerArray[i] = coefficients[i];
            }
            coefficients = biggerArray;
        }

        for (int i = 0; i < p.coefficients.length; i++) {
            coefficients[i] -= p.coefficients[i];
        }

        degree = 0;
        for (int i = coefficients.length - 1; i >= 0; i--) {
            if (coefficients[i] != 0) {
                degree = i;
                break;
            }
        }
    }

    /* Returns the polynomial derivative of this polynomial.
     * Does NOT change this polynomial */
    public Polynomial getDerivative() {
        //TO DO
        if (coefficients.length == 1) {
            int[] constant = {0};
            Polynomial derivative = new Polynomial(constant);
            return derivative;
        }

        int[] derivativeArray = new int[coefficients.length - 1];

        for (int i = 1; i < coefficients.length; i++) {
            derivativeArray[i - 1] = coefficients[i] * i;
        }

        Polynomial derivative = new Polynomial(derivativeArray);
        return derivative;
    }

    /* Returns the value of the polynomial at a point */
    public double atPoint(float arg) {
        //TO DO

        double sum = 0;
        for (int i = 0; i < coefficients.length; i++) {
            sum += coefficients[i] * (Math.pow(arg, i));
        }
        return sum; //STUB
    }

    @Override
    public String toString() {
        //TO DO
        String result = "";

        for (int i = coefficients.length - 1; i >= 0; i--) {
            int number = coefficients[i];
            if (number != 0) {
                if (number < 0) {
                    result += " - ";
                } else if (!result.equals("")) {
                    result += " + ";
                }


                int noSignNumber = number;
                if (number < 0) {
                    noSignNumber = -number;
                }

                if (noSignNumber != 1 || i == 0) {
                    result += noSignNumber;
                }

                if (i > 0) {
                    result += "x";
                    if (i > 1) {
                        result += "^" + i;
                    }
                }

            }

        }
        if (result.equals("")) {
            result = "0";
        }

        return result;


    }

    public int getDegree() {
        return degree;
    }

    // Unfortunately, solving a general polynomial is not in our scope
    public double[] solve() {
        return null;
    }

}
