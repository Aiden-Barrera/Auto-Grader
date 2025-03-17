package tester;

import java.util.Arrays;

import polynomial.LinearPolynomial;
import polynomial.Polynomial;
import polynomial.QuadraticPolynomial;

public class tester {
	
	public static Polynomial[] testPolynomials = null;
	
	public static void main(String[] args) {
		System.out.println("Test cases for grading Hw2 - Polynomials:\n");
		
		int coeffs[] = {1,2,3,4};
		Polynomial poly = new Polynomial(coeffs);
		System.out.print(poly);
		//Test1 - Polynomial constructor & toString
		printPolynomials();
		
		//Test 2 - call polynomial methods
		polynomialMethods();
		
		// Test 3 - subclasses
		subclassesTests();
	}
	
	// Test 1 - print polynomials
	public static void printPolynomials() {
		
		initTestCases();
		
		System.out.println("Print polynomials:");
		for (int i = 0; i < testPolynomials.length;++i) {
			System.out.println(String.format("p%s: %s ,  degree %s", i, testPolynomials[i], 
					testPolynomials[i].getDegree()));
		}
		System.out.println();
	}
	
	//Test 2 - use interface
	public static void polynomialMethods() {
		
		initTestCases();
		

		//derivative
		System.out.println(String.format("p0 derivative: %s", testPolynomials[0].getDerivative()));
		
		//Evaluate
		System.out.println(String.format("p3(2.5): %s", testPolynomials[3].atPoint(2)));
		
		//multiply by
		testPolynomials[8].multiplyBy(7);
		System.out.println(String.format("7*p8: %s", testPolynomials[8]));
				
		//Add p3 to p7
		testPolynomials[7].add(testPolynomials[3]);
		System.out.println(String.format("p7+p3: %s , degree %s", testPolynomials[7],
				testPolynomials[7].getDegree()));
		
		
		//Subtract p3 from p0
		testPolynomials[0].subtract(testPolynomials[3]);
		System.out.println(String.format("p0-p3: %s , degree %s", testPolynomials[0], 
				testPolynomials[0].getDegree()));
		
		//Add p6 to p5
		testPolynomials[5].add(testPolynomials[6]);
		System.out.println(String.format("p5+p6: %s , degree %s", testPolynomials[5], 
				testPolynomials[6].getDegree()));
		
		System.out.println();
	}
	
	// Test 3 - subclasses
	public static void subclassesTests() {
		initTestCases();
		
		LinearPolynomial l1 = new LinearPolynomial(5, 2);
		
		QuadraticPolynomial q1 = new QuadraticPolynomial(1, -1, -12);
		QuadraticPolynomial q2 = new QuadraticPolynomial(2, 4, 7);
		QuadraticPolynomial q3 = new QuadraticPolynomial(1, -10, 25);
		
		// p2 + l1
		testPolynomials[2].add(l1);
		System.out.println(String.format("p2+l1: %s , degree %s", testPolynomials[2], 
				testPolynomials[2].getDegree()));
		
		System.out.println("l1 solutions: " + Arrays.toString(l1.solve()));
		System.out.println("q1 solutions: " + Arrays.toString(q1.solve()));
		System.out.println("q2 solutions: " + Arrays.toString(q2.solve()));
		System.out.println("q3 solutions: " + Arrays.toString(q3.solve()));
		
		System.out.println();
	}
	
	// Initiate 10 test polynomials
	public static void initTestCases() {
		// Create polynomial objects
		Polynomial p0 = new Polynomial(new int[] {-6, 4, -3, 1, 2});
		Polynomial p1 = new Polynomial(new int[] {4});
		Polynomial p2 = new Polynomial(new int[] {0,4});
		Polynomial p3 = new Polynomial(new int[] {3,-1});
		Polynomial p4 = new Polynomial(new int[] {0,3,0});
		Polynomial p5 = new Polynomial(new int[] {0,3,0,0});
		Polynomial p6 = new Polynomial(new int[] {0,0,-2,0});
		Polynomial p7 = new Polynomial(new int[] {2,-3,0,9});
		Polynomial p8 = new Polynomial(new int[] {0,-1,4,0,0,2});
		Polynomial p9 = new Polynomial(new int[] {0,0,0,0});
		// Save to static content
		testPolynomials = new Polynomial[] {p0,p1,p2,p3,p4,p5,p6,p7,p8,p9};
	}

}
