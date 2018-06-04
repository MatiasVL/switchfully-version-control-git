package nested_classes.code_example07_local_class;

public class LocalExample {

    public void someMethod() {

        class SomeLocalClass {
            public String getSomeString(){
                return "hello";
            }
        }

        SomeLocalClass loc = new SomeLocalClass();
        System.out.println(loc.getSomeString());
    }

}
