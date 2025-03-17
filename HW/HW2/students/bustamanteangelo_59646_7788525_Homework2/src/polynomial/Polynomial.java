package polynomial;

/**
 * 
 * This class represent a polynomial, 
 * 
 */
public class Polynomial {
	protected int[] coefficients;
	protected int degree;
	
	public Polynomial() {
		// Default is 0
		coefficients = new int[] {0};
		degree = 0;
	}
		
	/* Construct the polynomial given it's coefficients */ 
	public Polynomial(int[] coeffs) {
        coefficients = new int[coeffs.length];
        for (int i = 0; i < coeffs.length; i++) {
            coefficients[i] = coeffs[i];
        }
        updateDegree();
    }
	private void updateDegree() {
        degree = coefficients.length - 1;
        while (degree >= 0 && coefficients[degree] == 0) {
            degree--;
        }
        if (degree < 0) {
            degree = 0; // Default to degree 0 for the zero polynomial
        }
	}
	
	/* Multiply this polynomial by a constant factor */
	public void multiplyBy(int factor) {
		for (int i = 0; i < coefficients.length; i++) {
			coefficients[i] = coefficients[i] * factor;
		}
	}
	
	/* Adds the polynomial p to this polynomial */
	public void add(Polynomial p) {
		int maxSize = Math.max(coefficients.length, p.coefficients.length);
    int[] newCoefficients = new int[maxSize];

    for (int i = 0; i < coefficients.length; i++) {
        newCoefficients[i] = coefficients[i];
    }

    for (int i = 0; i < p.coefficients.length; i++) {
        newCoefficients[i] += p.coefficients[i];
    }

    coefficients = newCoefficients;
	}
	
	/* Subtract the polynomial p from this polynomial */
	public void subtract(Polynomial p) {
		int newSize;

		if (coefficients.length > p.coefficients.length) {
			newSize = coefficients.length;
		} else {
			newSize = p.coefficients.length;
		}
	
		int[] newCoefficients = new int[newSize];
	
	
		for (int i = 0; i < coefficients.length; i++) {
			newCoefficients[i] = coefficients[i];
		}
	
		for (int i = 0; i < p.coefficients.length; i++) {
			newCoefficients[i] = newCoefficients[i] - p.coefficients[i];
		}
	
		coefficients = newCoefficients;
	}
	
	 /* Returns the polynomial derivative of this polynomial. 
	 * Does NOT change this polynomial */
	public Polynomial getDerivative() {
		if (coefficients.length == 1) {
			return new Polynomial(new int[]{0});
		}
	
		int[] derivativeCoefficients = new int[coefficients.length - 1];
	
		for (int i = 1; i < coefficients.length; i++) {
			derivativeCoefficients[i - 1] = coefficients[i] * i;
		}
	
		return new Polynomial(derivativeCoefficients);
	
	}
	
	/* Returns the value of the polynomial at a point */
	public double atPoint(float arg) {
		double result = 0;

    for (int i = 0; i < coefficients.length; i++) {
        result += coefficients[i] * Math.pow(arg, coefficients.length - i - 1);
    }

    return result;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();

    for (int i = 0; i < coefficients.length; i++) {
        int coef = coefficients[i];
        int degree = coefficients.length - i - 1;

        if (coef != 0) {
            if (coef > 0 && i != 0) {
                result.append(" + ");
            } else if (coef < 0) {
                result.append(" - ");
                coef = -coef; 
            }

            if (degree == 0) {
                result.append(coef);
            } else if (degree == 1) {
                result.append(coef).append("x");
            } else {
                result.append(coef).append("x^").append(degree);
            }
        }
    }

    if (result.length() == 0) {
        return "0";
    }

    return result.toString();
	}
	
	public int getDegree() {
		return degree;
	}
	
	// Unfortunately, solving a general polynomial is not in our scope
	public double[] solve() {
		return null;
	}
	
}
