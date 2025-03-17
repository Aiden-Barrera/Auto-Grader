package polynomial;

import java.lang.reflect.Array;

public class Polynomial {
    protected int[] coefficients;
    protected int degree;

    public Polynomial() {
        coefficients = new int[] { 0 };
        degree = 0;
    }

    public Polynomial(int[] coeffs) {
        int n = coeffs.length;
        coefficients = new int[n];
        degree = 0;
        for (int i = 0 ; i <= coeffs.length-1; i++) {
            if (coeffs[i] != 0) {
                coefficients[i] = coeffs[i];
                degree = i;
            }
        }
    }

    public void multiplyBy(int factor) {
        int n = coefficients.length;
        for (int i = 0; i < n; i++) {
            coefficients[i] = coefficients[i] * factor;
        }
    }

    public void add(Polynomial p) {
        // if(coefficients.length >= p.coefficients.length) {
        // int[] result = new int[coefficients.length];
        // }
        // else if(coefficients.length < p.coefficients.length) {
        // int[] result = new int[p.coefficients.length];
        // }
        int maxLength = Math.max(coefficients.length, p.coefficients.length);
        int[] result = new int[maxLength];
        for (int i = 0; i < maxLength; i++) {
            if (i < coefficients.length) {
                result[i] = result[i] + coefficients[i];
            }
            if (i < p.coefficients.length) {
                result[i] = result[i] + p.coefficients[i];
            }
        }
    }

    public void subtract(Polynomial p) {
        int maxLength = Math.max(coefficients.length, p.coefficients.length);
        int[] result = new int[maxLength];
        for (int i = 0; i < maxLength; i++) {
            if (i < coefficients.length) {
                result[i] = result[i] - coefficients[i];
            }
            if (i < p.coefficients.length) {
                result[i] = result[i] - p.coefficients[i];
            }
        }
    }

    public Polynomial getDerivative() {
        int[] der = new int[coefficients.length - 1];
        for (int i = coefficients.length - 1; i > 0; i--) {
            der[i - 1] = coefficients[i] * i;
        }
        return new Polynomial(der);
    }

    public double atPoint(double arg) {
        double poi = 0;
        for (int i = coefficients.length - 1; i >= 0; i--) {
            poi = poi + coefficients[i] * Math.pow(arg, i);
        }
        return poi;
    }

    @Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = coefficients.length - 1; i >= 0; i--) {
        if (coefficients[i] != 0) {
            if (coefficients[i] < 0) { 
                if (i == 0) {
                    sb.append(" - " + Math.abs(coefficients[i])); 
                } else if (i == 1) {
                    if (Math.abs(coefficients[i]) == 1) {
                        sb.append(" - x"); 
                    } else {
                        sb.append(" - " + Math.abs(coefficients[i]) + "x");
                    }
                } else {
                    if (Math.abs(coefficients[i]) == 1) {
                        sb.append(" - x^" + i); 
                    } else {
                        sb.append(" - " + Math.abs(coefficients[i]) + "x^" + i);
                    }
                }
            } else { 
                if (i == 0) {
                    sb.append(" + " + coefficients[i]); 
                } else if (i == 1) {
                    if (coefficients[i] == 1) {
                        sb.append(" + x"); 
                    } else {
                        sb.append(" + " + coefficients[i] + "x");
                    }
                } else {
                    if (coefficients[i] == 1) {
                        sb.append(" + x^" + i); 
                    } else {
                        sb.append(" + " + coefficients[i] + "x^" + i);
                    }
                }
            }
        }
    }
    return sb.toString();
}


    public int getDegree() {
        return degree;
    }

    public double[] solve() {
        return null;
    }
}
