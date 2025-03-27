package comparables;
public class Polynomial implements Comparable<Polynomial>{
	protected int[] coefficients;
	protected int degree;
	public Polynomial(){
		coefficients = new int[] {0};
		degree = 0;
	}
	public Polynomial(int[] coeffs){
		if ((coeffs == null) || (coeffs.length == 0)){
			coefficients = new int[]{0};
			degree = 0;
		}
		else if (coeffs.length == 1){
			coefficients = new int[] {coeffs[0]};
			degree = 0;
		}
		else{
			int i = coeffs.length - 1;
			while (i > 0)
				if (coeffs[i] != 0){
					degree = i;
					coefficients = new int[i+1];
					break;
				}
				else
					--i;
			if (i != 0)
				for (int j = 0; j <= i; ++j)
					coefficients[j] = coeffs[j];
			else{
				coefficients = new int[]{0};
				degree = 0;
			}
		}
	}
	public String toString(){
		if (this.coefficients.length == 1)
			return " " + String.valueOf(this.coefficients[0]);
		String poly = "";
		for (int i = degree; i > 0; i--){
			if (coefficients[i] == 1)
				poly += " + ";
			else if (coefficients[i] == -1)
				poly += " - ";
			else if (coefficients[i] > 0)
            	poly += " + " + coefficients[i];
            else if (coefficients[i] < 0)
            	poly += " - " + (-coefficients[i]);
            else
            	continue;
            if (i == 1)
            	poly += "x";
            else if (i >  1)
            	poly += "x^" + i;
		}
		if (coefficients[0] > 0)
			poly += " + " + String.valueOf(coefficients[0]);
		else if (coefficients[0] < 0)
			poly += " - " + String.valueOf(-coefficients[0]);
		return poly;
	}
	public int getDegree() {
		return degree;
	}
	public int compareTo(Polynomial o) {
		if (degree < o.degree)
			return -1;
		else if (degree > o.degree)
			return 1;
		else{
			for (int i = degree; i >= 0; i--)
				if (coefficients[i] < o.coefficients[i])
					return -1;
				else if (coefficients[i] > o.coefficients[i])
					return 1;
				else continue;
			return 0;
		}
	}
}