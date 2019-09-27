package code_example_01_finally;

public class ExcAppFinally {

    public static void main(String[] args) {
        try {
            doSomething();
        } catch(RuntimeException exception) {
            System.err.println("Exception caught: " + exception.getMessage());
            // We're going to throw a new exception here...
            throw new NullPointerException("SOMETHING WENT WRONG");
        } finally {
            System.out.println("I will always be executed!");
        }
    }

    private static void doSomething() {
        throw new RuntimeException("Danger, we can't do something!");
    }


}
