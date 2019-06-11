package codelab02;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        System.out.println("================================");
        System.out.println("================================");
        System.out.println("===========          ===========");
        System.out.println("=========  CALCULATOR  =========");
        System.out.println("===========          ===========");
        System.out.println("================================");
        System.out.println("=======                  =======");
        System.out.println("=====   (divisions only)  ======");
        System.out.println("=======                  =======");
        System.out.println("================================");
        System.out.println("================================");

        Scanner in = new Scanner(System.in);
        System.out.print("Provide a numerator (int): ");
        int numerator = in.nextInt();

        System.out.print("Provide a denominator (int): ");
        in.nextLine();
        int denominator = in.nextInt();

        var result = CalculatorService.divide(numerator, denominator);
        System.out.println("The quotient of the division is: " + result);
    }

}
