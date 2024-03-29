package solutions;

public class LoopsCodelabs09Solution {

    /**
     * Create a method that will return the n-th fibonaci number.
     * E.g.
     * fibonaci(1) = 1
     * fibonaci(2) = 1
     * fibonaci(3) = 2
     * fibonaci(4) = 3
     * fibonaci(5) = 5
     * fibonaci(6) = 8
     * ...
     * fibonaci(n) = fibonaci(n - 1) + fibonaci (n - 2)
     */
    public static int fibonaci(int number) {
        if(number <= 0) return 0;
        if (number == 1 || number == 2) {
            return 1;
        }

        int previousNumber = 1;
        int currentNumber = 1;
        for (int index = 2; index < number; index++) {
            int oldCurrentNumber = currentNumber;
            currentNumber += previousNumber;
            previousNumber = oldCurrentNumber;
        }
        return currentNumber;
    }
}
