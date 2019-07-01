package code_example02_static_nested_class.v2_private;

public class Calculator {

    private int firstValue;
    private int secondValue;
    private Operation myOperation;

    public Calculator(int firstValue, int secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        myOperation = new Operation();
    }

    int sum() {
        return myOperation.plus(firstValue, secondValue);
    }

    int subtraction() {
        return myOperation.minus(firstValue, secondValue);
    }

    /**
     * Private, so we can't use it outside of the Calculator class
     */
    private static class Operation {

        public int plus(int x, int y) {
            return x + y;
        }

        public int minus(int x, int y) {
            return x - y;
        }

    }

}
