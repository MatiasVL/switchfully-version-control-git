package code_example05_inner_class_technical;

public class OuterClass {
    private String cantTouchThis;

    public String getCantTouchThis() {
        return cantTouchThis;
    }

    /**
     * An inner (non-static) nested class can use all instance variables and methods of the enclosing / outer class,
     * even the private ones. Since a inner (non-static) class always requires an instance of the enclosing class to be
     * created before being initialized itself, it always has access to the instance of the enclosing class.
     */
    public class InnerClass {
        public InnerClass(String inputString) {
            cantTouchThis = inputString;
        }

        public void changeOuterClass(String inputString) {
            OuterClass.this.cantTouchThis = inputString;
        }
    }

}

