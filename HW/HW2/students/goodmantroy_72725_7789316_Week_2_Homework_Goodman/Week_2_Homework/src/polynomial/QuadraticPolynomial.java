package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int a, int b, int c) {
		super(new int[] {c,b,a});
	}
	@Override
	public double[] solve() {
		int a = coefficients[0];
		int b = coefficients[1];
		int c = coefficients[2];
		
		if (a==0) {
			LinearPolynomial linearLine = new LinearPolynomial(b,c);
			return linearLine.solve();
		}
		
		double quadFormula = b*b-4*a*c;
		
		if (quadFormula < 0) {
			return new double[]{};
		}
		else if (quadFormula == 0){
			return new double[] {-b/(2.0*a)};
		}
		else {
			double sqrtQuadFormula=Math.sqrt(quadFormula);
			return new double[] {
					(-b - sqrtQuadFormula) / (2.0*a),
					(-b + sqrtQuadFormula) / (2.0*a)};
			}
		}
	}
