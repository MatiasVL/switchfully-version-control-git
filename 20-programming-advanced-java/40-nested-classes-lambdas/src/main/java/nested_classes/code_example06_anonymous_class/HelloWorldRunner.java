package nested_classes.code_example06_anonymous_class;

public class HelloWorldRunner {

    public static void main(String[] args) {
        HelloWorldImpl helloWorld = new HelloWorldImpl();
        helloWorld.greet();
        helloWorld.spanish.greet();
    }


}
