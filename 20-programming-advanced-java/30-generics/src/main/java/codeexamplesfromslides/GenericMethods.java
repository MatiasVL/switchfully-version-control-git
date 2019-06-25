package codeexamplesfromslides;

import java.util.List;

public class GenericMethods {

    public <T extends Animal> void doX(List<T> list) {
        // Do nothing
    }

    public void doY(List<Animal> list) {
        // Do nothing
    }

    public void process(List<? super Number> list) {
        for (Object element: list) {
            System.out.println(element);
        }
    }

    public void processY(List<? extends Number> list) {
        for (Number oneNumber: list) {
            System.out.println(oneNumber.intValue());
        }
    }

    public static void main(String[] args) {
        GenericMethods myClass = new GenericMethods();

        List<Integer> ints = List.of(5, 2, 3);
        myClass.processY(ints);

        List<Double> doubles = List.of(5.5, 2.4);
        myClass.processY(doubles);

        List<Number> numbers = List.of(5, 5.5, 10.0);
        myClass.processY(numbers);

        List<Object> objects = List.of(5, "Hello");
        myClass.process(objects);

        List<Animal> animals = List.of(new Cat("Bo"), new Dog("Tio"));
        myClass.doX(animals);

        List<Animal> animals1 = List.of(new Cat("Bo"), new Dog("Tio"));
        myClass.doY(animals1);

        List<Cat> cats = List.of(new Cat("Bo"), new Cat("Flo"));
        myClass.doX(cats);
    }

}
