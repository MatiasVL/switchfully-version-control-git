package nested_classes.code_example03_static_nested_class_technical;

public class OuterClass {
    private String cantTouchThis;

    public String getCantTouchThis() {
        return cantTouchThis;
    }

    public static class NestedClass {

        /**
         * A static nested class can use all instance variables and methods of the enclosing / outer class, even the private
         * ones, although it does need an instance of that enclosing class first.
         */
        public OuterClass createOuterClass(String input) {
            OuterClass outer = new OuterClass();
            outer.cantTouchThis = input;
            return outer;
        }

        public void changeOuterClass(OuterClass outer, String input) {
            outer.cantTouchThis = input;
        }

    }

}

