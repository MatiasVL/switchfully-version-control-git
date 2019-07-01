package code_example05_inner_class_technical;

public class Runner {

    public static void main(String[] args) {

        // We have to create an instance of the enclosing class (OuterClass) before we're able to create an instance
        // of the inner class (InnerClass).
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass("Hello");

        System.out.println(outer.getCantTouchThis());
        inner.changeOuterClass("change me");
        System.out.println(outer.getCantTouchThis());
    }

}
