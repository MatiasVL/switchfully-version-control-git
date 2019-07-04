package code_example03_operations_and_sources.operations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Terminal {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World", "Code", "Planet");

        List<String> filteredWords = words.stream()
                .filter(word -> word.startsWith("W"))
                .collect(Collectors.toList());

        long amountOfElements =
                words.stream()
                        .filter(word -> word.startsWith("W"))
                        .count();

        boolean doAllElementsContainO =
                words.stream()
                        .map(String::toLowerCase)
                        .allMatch(word -> word.contains("o"));

        boolean doesOneElementContainO =
                words.stream()
                        .map(String::toLowerCase)
                        .anyMatch(word -> word.contains("o"));

        Optional<String> firstFourLetterWord =
                words.stream()
                        .filter(word -> word.length() == 4)
                        .findFirst();

        List<String> listOfDoubleddWords =
                words.stream()
                        .map(word -> word + word)
                        .collect(Collectors.toList());

        words
                .forEach(word -> System.out.println("Say: " + word));

        OptionalDouble averageLengthOfWords =
                words.stream()
                        .mapToInt(word -> word.length())
                        .average();

        String firstFourLetterWord1 =
                words.stream()
                        .filter(word -> word.length() == 4)
                        .findFirst()
                        .orElse("not-found");

        System.out.println(firstFourLetterWord1.toUpperCase());

        words.stream()
                .filter(word -> word.length() == 4)
                .findFirst()
                .ifPresentOrElse(
                        fourLetterWord -> System.out.println(fourLetterWord.toUpperCase()),
                        () -> {
                        }
                );
    }

    private static Optional<String> methodThatReturnsAnOptional(boolean isMissing) {
        if (isMissing) {
            return Optional.empty(); // contains null
        }
        return Optional.of("I'm here"); // contains a String object
    }

}
