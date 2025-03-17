package polynomial;

public class Polynomial {
    protected int[] coefficients;
    protected int degree;

    public Polynomial(int[] coeffs) {
        if (coeffs.length == 0) {
            this.coefficients = new int[]{0};
            this.degree = 0;
            return;
        }
        int deg = coeffs.length - 1;
        while (deg > 0 && coeffs[deg] == 0) {
            deg--;
        }

        this.degree = deg;
        this.coefficients = new int[degree + 1];
        for (int i = 0; i <= deg; i++) {
        this.coefficients[i] = coeffs[i];
}
    }

    public int getDegree() {
        return degree;
    }

    public Polynomial multiplyBy(int factor) {
        if (factor == 0) {
            return new Polynomial(new int[]{0});
        }

        int[] Coefficients2 = new int[degree + 1];
        for (int i = 0; i <= degree; i++) {
            Coefficients2[i] = coefficients[i] * factor;
        }
        return new Polynomial(Coefficients2);
    }

    public Polynomial add(Polynomial p) {
        int maxDegree = Math.max(this.degree, p.getDegree());
        int[] newCoefficients = new int[maxDegree + 1];

        for (int i = 0; i <= maxDegree; i++) {
            int thisCoeff = 0;
            int otherCoeff = 0;
        
            if (i <= this.degree) {
                thisCoeff = this.coefficients[i];
            }
            if (i <= p.degree) {
                otherCoeff = p.coefficients[i];
            }
        
            newCoefficients[i] = thisCoeff + otherCoeff;
        }

        return new Polynomial(newCoefficients);
    }

    public Polynomial subtract(Polynomial p) {
        int maxDegree = Math.max(this.degree, p.degree);
        int[] newCoefficients = new int[maxDegree + 1];

        for (int i = 0; i <= maxDegree; i++) {
            int thisCoeff = 0;
            int otherCoeff = 0;
        
            if (i <= this.degree) {
                thisCoeff = this.coefficients[i];
            }
            if (i <= p.degree) {
                otherCoeff = p.coefficients[i];
            }
        
            newCoefficients[i] = thisCoeff - otherCoeff;
        }

        return new Polynomial(newCoefficients);
    }

    public Polynomial getDerivative() {

        int[] derivativeCoefficients = new int[degree];
        for (int i = 1; i <= degree; i++) {
            derivativeCoefficients[i] = coefficients[i] * i;
        }

        return new Polynomial(derivativeCoefficients);
    }

    public String toString() {
		//TO DO
		return ""; //STUB
	}
}
