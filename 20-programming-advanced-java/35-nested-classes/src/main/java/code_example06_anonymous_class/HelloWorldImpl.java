package code_example06_anonymous_class;

public class HelloWorldImpl implements HelloWorld {
    @Override
    public void greet() {
        System.out.println("Hello World!");
    }

    public HelloWorld spanish = new HelloWorld() {
        @Override
        public void greet() {
            System.out.println("Hula Mundo!");
        }
    };
}



