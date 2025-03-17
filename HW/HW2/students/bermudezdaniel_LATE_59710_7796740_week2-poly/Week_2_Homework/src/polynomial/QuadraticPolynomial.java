package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	public QuadraticPolynomial(int A, int B, int C) {
		// TO DO
		super(new int[]{C, B, A});
	}
	//Override polynomial.solve()
	public double[] solve(){
		int a = coefficients[2];
		int b = coefficients[1];
		int c = coefficients[0];

		if(a==0){
			if(b==0){
				if(c==0){
					return new double[]{};
				}
				else{
					return new double[]{};
				}
			}
		}
		double formula = b * b - 4 * a * c;

        if (formula == 0) {
            double root = -b / (2 * a);
            return new double[]{root};
        } else if (formula > 0) {
			double rootone = (-b + Math.sqrt(formula)) / (2 * a);
            double roottwo = (-b - Math.sqrt(formula)) / (2 * a);
			return new double[]{rootone, roottwo};
        } else {
            return new double[]{};
        }
    }
}
	
	

