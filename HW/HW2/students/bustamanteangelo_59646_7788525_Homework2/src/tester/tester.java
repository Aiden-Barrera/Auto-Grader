package tester;

import java.util.Arrays;

import polynomial.LinearPolynomial;
import polynomial.Polynomial;
import polynomial.QuadraticPolynomial;

public class tester {
    
    public static Polynomial[] testPolynomials = null;
    
    public static void main(String[] args) {
        System.out.println("Test cases for Hw2 - Polynomials:\n");
        
        // Test 1 - Polynomial constructor & toString
        printPolynomials();
        
        // Test 2 - Polynomial operations
        polynomialOperations();
        
        // Test 3 - Subclasses
        subclassesTests();
    }
    
    // Test 1 - Print polynomials
    public static void printPolynomials() {
        initTestCases();
        
        System.out.println("Print polynomials:");
        for (int i = 0; i < testPolynomials.length; i++) {
            System.out.println(String.format("p%d is the polynomial: %s , degree %d", 
                i + 1, testPolynomials[i], testPolynomials[i].getDegree()));
        }
        System.out.println();
    }
    
    // Test 2 - Polynomial operations
    public static void polynomialOperations() {
        initTestCases();
        
        // Add p2 to p1
        testPolynomials[0].add(testPolynomials[1]);
        System.out.println(String.format("Add p2 to p1:\np1 is now: %s , degree: %d\np2 is the same: %s", 
            testPolynomials[0], testPolynomials[0].getDegree(), testPolynomials[1]));
        
        // Add p8 to p6
        testPolynomials[5].add(testPolynomials[7]);
        System.out.println(String.format("Add p8 to p6:\np6 is now: %s , degree: %d\np8 is the same: %s", 
            testPolynomials[5], testPolynomials[5].getDegree(), testPolynomials[7]));
        
        // Subtract p3 from p1
        testPolynomials[0].subtract(testPolynomials[2]);
        System.out.println(String.format("Subtract p3 from p1:\np1 is now: %s , degree: %d\np3 is the same: %s", 
            testPolynomials[0], testPolynomials[0].getDegree(), testPolynomials[2]));
        
        // Subtract p3 from p2
        testPolynomials[1].subtract(testPolynomials[2]);
        System.out.println(String.format("Subtract p3 from p2:\np2 is now: %s , degree: %d\np3 is the same: %s", 
            testPolynomials[1], testPolynomials[1].getDegree(), testPolynomials[2]));
        
        // Derivative of p3
        System.out.println(String.format("The derivative of p3 is: %s\np3 is the same: %s", 
            testPolynomials[2].getDerivative(), testPolynomials[2]));
        
        // Evaluate p4 at 5
        System.out.println(String.format("The value of p4(5) is: %.1f", testPolynomials[3].atPoint(5)));
        
        // Evaluate p1 at 1
        System.out.println(String.format("The value of p1(1) is: %.1f", testPolynomials[0].atPoint(1)));
        
        System.out.println();
    }
    
    // Test 3 - Subclasses
    public static void subclassesTests() {
        QuadraticPolynomial q = new QuadraticPolynomial(1, 1, 1);
        System.out.println(String.format("q is the polynomial: %s\nq is the same: %s", q, q));
    }
    
    // Initialize test polynomials
    public static void initTestCases() {
        // Create polynomial objects
        Polynomial p1 = new Polynomial(new int[] {-7, 3, -1, 5}); // 5x^3 - x^2 + 3x - 7
        Polynomial p2 = new Polynomial(new int[] {0, -2, 0, 0, 1}); // x^4 - 2x
        Polynomial p3 = new Polynomial(new int[] {9, 0, 0, -2}); // -2x^3 + 9
        Polynomial p4 = new Polynomial(new int[] {-1, 2}); // 2x - 1
        Polynomial p5 = new Polynomial(new int[] {0, 0, 0, 0, 0, 0, 0, 5}); // 5x^7
        Polynomial p6 = new Polynomial(new int[] {-2}); // -2
        Polynomial p7 = new Polynomial(new int[] {0}); // 0
        Polynomial p8 = new Polynomial(new int[] {0, 6}); // 6x

        // Save to static content
        testPolynomials = new Polynomial[] {p1, p2, p3, p4, p5, p6, p7, p8};
    }
}