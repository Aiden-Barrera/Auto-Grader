package polynomial;

import java.util.Arrays;

public class Polynomial{
	protected int[] coefficients;
	protected int degree;
	public Polynomial(int[] newCoefficients){
		coefficients = newCoefficients;
		degree = coefficients.length - 1;
	}
	public void multiplyBy(int factor){
		for (int i = 0; i < coefficients.length; i++)
			coefficients[i] *= factor;
	}
	public void add(Polynomial p){
		if (coefficients.length > p.coefficients.length)
			for (int i = 0; i < p.coefficients.length; i++)
				coefficients[i] += p.coefficients[i];
		else{
			int[] copyCoefficients = Arrays.copyOf(p.coefficients, p.coefficients.length);
			for (int i = 0; i < coefficients.length; i++)
				copyCoefficients[i] += coefficients[i];
			coefficients = copyCoefficients;
		}
		degree = coefficients.length - 1;
	}
	public void subtract(Polynomial p){
		if (coefficients.length > p.coefficients.length)
			for (int i = 0; i < p.coefficients.length; i++)
				coefficients[i] -= p.coefficients[i];
		else{
			int[] copyCoefficients = Arrays.copyOf(p.coefficients, p.coefficients.length);
			for (int i = 0; i < coefficients.length; i++)
				copyCoefficients[i] -= coefficients[i];
			coefficients = copyCoefficients;
		}
		degree = coefficients.length - 1;
	}
	public Polynomial getDerivative(){
		Polynomial p = new Polynomial(coefficients);
		coefficients[0] = 0;
		for (int i = 1; i <= coefficients.length - 1; i++){
			coefficients[i] *= i;
			coefficients[i - 1] = coefficients[i]; 
		}
		coefficients[coefficients.length - 1] = 0;
		return p;
	}
	public double atPoint(float arg){
		float evaluation = 0;
		for (int i = 0; i <= coefficients.length - 1; i++){
			evaluation += coefficients[i] * Math.pow(arg, i);
		}
		return evaluation;
	}
	public String toString(){
		String expression = "";
		for (int i = coefficients.length - 1; i >= 0; i--){
			if (coefficients[i] == 0 && coefficients.length > 1)
				continue;
			else if (coefficients[i] == 0 && coefficients.length == 1)
				return "0";
			if (coefficients[i] > 0 && i != coefficients.length - 1)
				expression += "+";
			if (coefficients[i] != 1 && coefficients[i] != -1 && i > 0)
				expression += coefficients[i] + "x";
			else if (i == 0)
				expression += coefficients[i];
			else if (coefficients[i] == 1)
				expression += "x";
			else
				expression += "-x";
			if (i > 1)
				expression += "^" + i;
		}
		return expression;
	}
	public int getDegree(){
		return degree;
	}
	public double[] solve(){
		return null;
	}
}