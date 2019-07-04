package code_example03_operations_and_sources.sources;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sources {

    public static void main(String[] args) {

        // Collections

        List<String> countries = List.of("Belgium", "France", "Germany");
        Stream<String> streamOfList = countries.stream();

        Queue<Customer> customers = new ArrayDeque<>();
        customers.add(new Customer("Joanna"));
        customers.add(new Customer("James"));
        Stream<Customer> streamOfDeque = customers.stream();

        // Arrays

        String[] cars = {"Renault", "Volvo", "Mercedes"};
        Stream<String> streamOfArray = Arrays.stream(cars);

        Stream<String> streamOfArray02 = Stream.of("Renault", "Volvo", "Mercedes");

        // Generator

        Stream<String> infiniteStream = Stream.generate(() -> "Ping").limit(25);

        Stream<Integer> infItStream = Stream.iterate(100, n -> n + 10).limit(20);

        // Primitive

        IntStream intRangeStream = IntStream.range(1, 4);

    }

    private static class Customer {
        Customer(String name) {
            // just a dummy class
        }
    }

}
