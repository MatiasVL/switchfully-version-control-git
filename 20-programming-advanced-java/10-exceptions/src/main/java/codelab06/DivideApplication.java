package codelab06;

import java.util.Scanner;

/**
 * Read the README.md file
 */
public class DivideApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Dear human, welcome to the divide program!");
        System.out.println("> Please provide a numerator:");
        String numerator = scanner.next();

        System.out.println("Thank you human!");
        System.out.println("> Please provide a denominator:");
        String denominator = scanner.next();

        System.out.println("Thank you human!");
        System.out.println("Calculating the division...");

        System.out.println(9.5/2);

        double result = Divide.divide(numerator, denominator);
        System.out.println("Result: " + result);

    }

}
