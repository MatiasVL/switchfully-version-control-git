package nested_classes.code_example02_static_nested_class.v2_private;

public class CalculatorRunner {

    public static void main(String[] args) {

        Calculator calculator = new Calculator(10, 15);
        System.out.println("Sum: " + calculator.sum());
        System.out.println("Division: " + calculator.subtraction());

        // This will no longer compile...
//        Calculator.Operation operation = new Calculator.Operation();
//        System.out.println("Plus: " + operation.plus(20, 15));
//        System.out.println("Minus: " + operation.minus(20, 15));
    }

}
