package lambdas.codelab02;

/**
 * Read the README.md file
 */
public class StrictCalculatorV2 {

    public static int multiplyBy2(int operator) {
        return operator * 2;
    }

    public static void main(String[] args) {
        int result1 = StrictCalculatorV2.multiplyBy2(5);// should use ruleset #1
        int result2 = StrictCalculatorV2.multiplyBy2(-2); // should use ruleset #2
        int result3 = StrictCalculatorV2.multiplyBy2(8); // should use ruleset #3

        System.out.println("Should be equal to 10: " + result1);
        System.out.println("Should be equal to -4: " + result2);
        System.out.println("Should be equal to 16: " + result3);
    }

}
