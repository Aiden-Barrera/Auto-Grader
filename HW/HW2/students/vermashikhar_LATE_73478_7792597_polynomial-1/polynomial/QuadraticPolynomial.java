package polynomial;

public class QuadraticPolynomial extends Polynomial{
	// Creates a quadratic polynomial of the form Ax^2 + Bx + C
	protected Polynomial equation;
	public QuadraticPolynomial(int A, int B, int C) {
		// TO DO
		int[] polynomial=new int[] {C,B,A};
		equation=new Polynomial(polynomial);
	}
	//Override polynomial.solve()
	@Override
	public double[] solve(){
		//uses the quadratic formula to solve for the solution
		int a=equation.coefficients[2];
		int b=equation.coefficients[1];
		int c=equation.coefficients[0];
		int bSquared=(int)(Math.pow(b,2));
		double discriminant=Math.sqrt(bSquared-(4*a*c));
		double solution1=((-1*b)+discriminant) / (2*a);
		double solution2=((-1*b)-discriminant) / (2*a);
		double[] solutions= new double[2];
		double nan=Double.NaN;
		if(solution1==nan && solution2==nan){
			return solutions;
		}
		else if(solution1==nan){
			solutions[0]=solution2;
		}
		else if(solution2==nan){
			solutions[0]=solution1;
		}
		else{
			solutions[0]=solution1;
			solutions[1]=solution2;
		}
		return solutions;
	}
}
