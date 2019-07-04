package code_example03_operations_and_sources.operations;

import java.util.List;
import java.util.stream.Collectors;

public class Aggregate {

    public static void main(String[] args) {
        List<String> countries = List.of("France", "Belgium",
                "Germany", "Albania", "Spain");

        var resultingCountries = countries.stream()
                .filter(word -> word.contains("a"))
                .map(word -> word.toUpperCase())
                .skip(1)
                .limit(2)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(resultingCountries);

    }
}
