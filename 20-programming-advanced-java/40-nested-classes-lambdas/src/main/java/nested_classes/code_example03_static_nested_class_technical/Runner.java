package nested_classes.code_example03_static_nested_class_technical;

public class Runner {

    public static void main(String[] args) {

        // We can create an instance of a static nested class (NestedClass) without creating an
        // instance of the enclosing class (OuterClass).
        OuterClass.NestedClass nested = new OuterClass.NestedClass();

        OuterClass outer = nested.createOuterClass("changing you");
        System.out.println(outer.getCantTouchThis());
        nested.changeOuterClass(outer, "changed once again");
        System.out.println(outer.getCantTouchThis());
    }

}
