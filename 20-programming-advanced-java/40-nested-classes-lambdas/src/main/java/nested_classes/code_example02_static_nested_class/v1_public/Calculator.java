package nested_classes.code_example02_static_nested_class.v1_public;

public class Calculator {

    private int firstValue;
    private int secondValue;
    private Operation myOperation;

    Calculator(int firstValue, int secondValue) {
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
     * Public, so we can use it outside of the Calculator class
     */
    public static class Operation {

        public int plus(int x, int y) {
            return x + y;
        }

        public int minus(int x, int y) {
            return x - y;
        }

    }

}
