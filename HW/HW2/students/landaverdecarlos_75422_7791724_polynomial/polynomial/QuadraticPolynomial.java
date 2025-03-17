package polynomial;
import java.lang.Math;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		super(new int[] {C, B, A});
	}
	//Override polynomial.solve()
	@Override
	public double[] solve() {
		if ((quadraticFormulaPlus().length != 0) && (quadraticFormulaMinus().length != 0)) {
			return new double[] {quadraticFormulaPlus()[0], quadraticFormulaMinus()[0]};
		}
		else if ((quadraticFormulaPlus().length != 0) && (quadraticFormulaMinus().length == 0)) {
			return new double[] {quadraticFormulaPlus()[0]};
		}
		else if ((quadraticFormulaPlus().length == 0) && (quadraticFormulaMinus().length != 0)) {
			return new double[] {quadraticFormulaMinus()[0]};
		}
		else {
			return new double[] {};
		}
	}

	public double[] quadraticFormulaPlus() {
		try {
			return new double[] {(-1 * coefficients[1] + Math.sqrt(Math.pow(coefficients[1], 2) - (4 * coefficients[2] * coefficients[0]))) / (2 * coefficients[2])};
		}
		catch (Exception e) {
			return new double[] {};
		}
	}
	public double[] quadraticFormulaMinus() {
		try {
			return new double[] {(-1 * coefficients[1] - Math.sqrt(Math.pow(coefficients[1], 2) - (4 * coefficients[2] * coefficients[0]))) / (2 * coefficients[2])};
		}
		catch (Exception e) {
			return new double[] {};
		}
	}
}
