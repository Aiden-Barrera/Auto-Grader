package Tester;

import comparables.Point;
import comparables.Polynomial;
import Tester.BasicSorting;

public class Tester {

	public static void main(String[] args) {
		System.out.println("Hw5 - Grading");
		polynomialTest();
		pointTest();
	}
	
	/*
	 * Test cases for polynomial class
	 */
	public static void polynomialTest() {
		Polynomial p0 = new Polynomial(new int[] {-4,6,5});
		Polynomial p1 = new Polynomial(new int[] {2, -1});
		Polynomial p2 = new Polynomial(new int[] {3,0,4,1});
		Polynomial p3 = new Polynomial(new int[] {-1,4});
		Polynomial p4 = new Polynomial(new int[] {3,-1});
		Polynomial p5 = new Polynomial(new int[] {-7,0,0,4});
		Polynomial p6 = new Polynomial(new int[] {0,6,5});
		Polynomial p7 = new Polynomial(new int[] {28});
		Polynomial p8 = new Polynomial(new int[] {2, -1});
		Polynomial p9 = new Polynomial(new int[] {0});
		
		Polynomial[] testPolynomials = new Polynomial[] {p0,p1,p2,p3,p4,p5,p6,p7,p8,p9};
		
		// sort
		System.out.println("**Sorted polynomial list**");
		BasicSorting.bubbleSort(testPolynomials);
		
		// After Sorting
		for (int i = 0; i < testPolynomials.length;++i) {
			System.out.println(testPolynomials[i]);
		}
		System.out.println();
	}
	
	/*
	 * Test cases for class Point
	 */
	public static void pointTest() {
		Point p1 = new Point(5, 7);
		Point p2 = new Point(-4, 5);
		Point p3 = new Point(1, 5);
		Point p4 = new Point(-4, 2);
		Point p5 = new Point(2, -2);
		
		Point[] arrPoints = new Point[] {p1,p2,p3,p4,p5};
		
		BasicSorting.insertionSort(arrPoints);
		System.out.println();
		
		// After Sorting
		System.out.println("Print in order:");
		for (int i = 0; i < arrPoints.length;++i) {
			System.out.println(arrPoints[i]);
		}
	}

}
