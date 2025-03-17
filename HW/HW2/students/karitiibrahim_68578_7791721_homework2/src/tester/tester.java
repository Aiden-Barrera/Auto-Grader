package tester;

import java.util.Arrays;
import polynomial.LinearPolynomial;
import polynomial.Polynomial;
import polynomial.QuadraticPolynomial;

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
            System.out.println(String.format("p%s: %s ,  degree %s", i+1, testPolynomials[i], 
                    testPolynomials[i].getDegree()));
        }
        System.out.println();
    }

    public static void polynomialMethods() {
        initTestCases();
       
        /**
        System.out.println(String.format("p3 derivative: %s", testPolynomials[2].getDerivative()));
        System.out.println(String.format("p3(2.5): %s", testPolynomials[3].atPoint(2)));
        testPolynomials[8].multiplyBy(7);
        System.out.println(String.format("7*p8: %s", testPolynomials[8]));
        testPolynomials[7].add(testPolynomials[3]);
        System.out.println(String.format("p7+p3: %s , degree %s", testPolynomials[7],
                testPolynomials[7].getDegree()));
        testPolynomials[0].subtract(testPolynomials[3]);
        System.out.println(String.format("p0-p3: %s , degree %s", testPolynomials[0], 
                testPolynomials[0].getDegree())); **/
        
     // Add p2 to p1
        testPolynomials[0].add(testPolynomials[1]);
        System.out.println(String.format("Add p2 to p1:\np1 is now: %s , degree: %d", 
                testPolynomials[0], testPolynomials[0].getDegree()));
        System.out.println(String.format("p2 is the same: %s\n", testPolynomials[2]));
        
        // Add p8 to p6
        testPolynomials[5].add(testPolynomials[7]);
        System.out.println(String.format("Add p8 to p6:\np6 is now: %s , degree: %d", 
                testPolynomials[5], testPolynomials[5].getDegree()));
        System.out.println(String.format("p8 is the same: %s\n", testPolynomials[7]));
        
        // Subtract p3 from p1
        testPolynomials[0].subtract(testPolynomials[2]);
        System.out.println(String.format("Subtract p3 from p1:\np1 is now: %s , degree: %d", 
                testPolynomials[0], testPolynomials[0].getDegree()));
        System.out.println(String.format("p3 is the same: %s\n", testPolynomials[3]));
        
        // Subtract p3 from p2
        testPolynomials[1].subtract(testPolynomials[2]);
        System.out.println(String.format("Subtract p3 from p2:\np2 is now: %s , degree: %d", 
                testPolynomials[1], testPolynomials[2].getDegree()));
        System.out.println(String.format("p3 is the same: %s\n", testPolynomials[3]));
        
        // The derivative of p3
        System.out.println(String.format("The derivative of p3 is: %s", testPolynomials[2].getDerivative()));
        System.out.println(String.format("p3 is the same: %s\n", testPolynomials[2]));
        
        // Evaluate p4 at x = 5 and p1 at x = 1
        System.out.println(String.format("The value of p4(5) is: %s", testPolynomials[3].atPoint(5)));
        System.out.println(String.format("The value of p1(1) is: %s\n", testPolynomials[0].atPoint(1)));
        
        // Creating and displaying polynomial q
        Polynomial q = new Polynomial(new int[]{1, 1, 1, 1});
        System.out.println(String.format("q is the polynomial: %s", q));
        System.out.println(String.format("q is the same: %s", q));
    }

    public static void subclassesTests() {
        initTestCases();
        
        LinearPolynomial l1 = new LinearPolynomial(5, 2);
        QuadraticPolynomial q1 = new QuadraticPolynomial(1, -1, -12);
        QuadraticPolynomial q2 = new QuadraticPolynomial(2, 4, 7);
        QuadraticPolynomial q3 = new QuadraticPolynomial(1, -10, 25);

        System.out.println("l1 solutions: " + Arrays.toString(l1.solve()));
        System.out.println("q1 solutions: " + Arrays.toString(q1.solve()));
        System.out.println("q2 solutions: " + Arrays.toString(q2.solve()));
        System.out.println("q3 solutions: " + Arrays.toString(q3.solve()));
    }

    public static void initTestCases() {
        testPolynomials = new Polynomial[] {
            new Polynomial(new int[] {-7, 3, -1, 5}),   // p0: 5x^3 - x^2 + 3x - 7
            new Polynomial(new int[] {0, -2, 0, 0, 1}), // p1: x^4 - 2x
            new Polynomial(new int[] {9, 0, 0, -2}),    // p2: -2x^3 + 9
            new Polynomial(new int[] {-1, 2}),          // p3: 2x - 1
            new Polynomial(new int[] {0, 0, 0, 0, 0, 0, 0, 5}), // p4: 5x^7
            new Polynomial(new int[] {-2}),             // p5: -2
            new Polynomial(new int[] {0}),              // p6: 0
            new Polynomial(new int[] {0, 6}),           // p7: 6x
            //new Polynomial(new int[] {1, -3, 2})        // p8: 2x^2 - 3x + 1
        };
    }

       
    
}
