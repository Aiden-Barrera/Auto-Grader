package Polynomial;

import Polynomial.LinearPolynomial;
import Polynomial.Polynomial;
import Polynomial.QuadraticPolynomial;

public class tester {
	public static Polynomial[] testPolynomials = null;

	public static void main(String[] args) {
		System.out.println("Test cases for grading Hw2 - Polynomials:\n");
		printPolynomials();
		polynomialMethods();
		subclassesTests();
	}

	public static void printPolynomials() {
		initTestCases();
		System.out.println("Print polynomials:");
		for (int i = 0; i < testPolynomials.length; i++) {
			System.out.println("p" + i + ": " + testPolynomials[i] + " ,  degree " + testPolynomials[i].getDegree());
		}
		System.out.println();
	}

	public static void polynomialMethods() {
		initTestCases();
		System.out.println("p0 derivative: " + testPolynomials[0].getDerivative());
		System.out.println("p3(2): " + testPolynomials[3].atPoint(2));
		testPolynomials[8].multiplyBy(7);
		System.out.println("7*p8: " + testPolynomials[8]);
		testPolynomials[7].add(testPolynomials[3]);
		System.out.println("p7+p3: " + testPolynomials[7] + " , degree " + testPolynomials[7].getDegree());
		testPolynomials[0].subtract(testPolynomials[3]);
		System.out.println("p0-p3: " + testPolynomials[0] + " , degree " + testPolynomials[0].getDegree());
		testPolynomials[5].add(testPolynomials[6]);
		System.out.println("p5+p6: " + testPolynomials[5] + " , degree " + testPolynomials[5].getDegree());
		System.out.println();
	}

	public static void subclassesTests() {
		initTestCases();
		LinearPolynomial l1 = new LinearPolynomial(5, 2);
		QuadraticPolynomial q1 = new QuadraticPolynomial(1, -1, -12);
		QuadraticPolynomial q2 = new QuadraticPolynomial(2, 4, 7);
		QuadraticPolynomial q3 = new QuadraticPolynomial(1, -10, 25);
		testPolynomials[2].add(l1);
		System.out.println("p2+l1: " + testPolynomials[2] + " , degree " + testPolynomials[2].getDegree());
		System.out.println("l1 solutions: " + arrayToString(l1.solve()));
		System.out.println("q1 solutions: " + arrayToString(q1.solve()));
		System.out.println("q2 solutions: " + arrayToString(q2.solve()));
		System.out.println("q3 solutions: " + arrayToString(q3.solve()));
		System.out.println();
	}

	public static String arrayToString(double[] arr) {
		String s = "[";
		for (int i = 0; i < arr.length; i++) {
			s = s + arr[i];
			if (i < arr.length - 1) {
				s = s + ", ";
			}
		}
		s = s + "]";
		return s;
	}

	public static void initTestCases() {
		Polynomial p0 = new Polynomial(new int[] { -6, 4, -3, 1, 2 });
		Polynomial p1 = new Polynomial(new int[] { 4 });
		Polynomial p2 = new Polynomial(new int[] { 0, 4 });
		Polynomial p3 = new Polynomial(new int[] { 3, -1 });
		Polynomial p4 = new Polynomial(new int[] { 0, 3, 0 });
		Polynomial p5 = new Polynomial(new int[] { 0, 3, 0, 0 });
		Polynomial p6 = new Polynomial(new int[] { 0, 0, -2, 0 });
		Polynomial p7 = new Polynomial(new int[] { 2, -3, 0, 9 });
		Polynomial p8 = new Polynomial(new int[] { 0, -1, 4, 0, 0, 2 });
		Polynomial p9 = new Polynomial(new int[] { 0, 0, 0, 0 });
		testPolynomials = new Polynomial[10];
		testPolynomials[0] = p0;
		testPolynomials[1] = p1;
		testPolynomials[2] = p2;
		testPolynomials[3] = p3;
		testPolynomials[4] = p4;
		testPolynomials[5] = p5;
		testPolynomials[6] = p6;
		testPolynomials[7] = p7;
		testPolynomials[8] = p8;
		testPolynomials[9] = p9;
	}
}
