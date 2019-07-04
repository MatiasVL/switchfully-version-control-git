package code_example01_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class StreamyStream {

    public static void main(String[] args) {
        List<String> names = asList("Jim", "Jen", "Jan");

        List<String> resultingNames =
                names.stream()
                        .filter(name -> name.endsWith("n"))
                        .map(name -> name.toLowerCase())
                        .collect(Collectors.toList());

        List<String> myWords = asList("my", "milkshake", "brings", "all", "the", "boys", "to", "the", "yard");

        myWords.stream()
                .filter(word -> word.length() < 10)
                .map(word -> word.toUpperCase())
                .forEach(upperCasedWord -> System.out.println("WORD: " + upperCasedWord));

        myWords.stream()
                .filter(singleWurd -> !singleWurd.contains("u"))
                .map(singleWord -> singleWord.replaceAll("a", "u"))
                .map(singleWord -> singleWord.toUpperCase())
                .forEach(word -> System.out.println(word));

        System.out.println("----------------------");

        myWords.stream()
                .map(singleWord -> singleWord.replaceAll("a", "u"))
                .filter(singleWurd -> !singleWurd.contains("u"))
                .map(singleWord -> singleWord.toUpperCase())
                .forEach(word -> System.out.println(word));

        System.out.println("----------------------");

        List<String> myMappedWords = myWords.stream()
                .map(singleWord -> singleWord.replaceAll("a", "o"))
                .collect(Collectors.toList());

        System.out.println(myMappedWords);

        List<Integer> allNumbers = Arrays.asList(5, 2, 9, 3, 2, 4, 6);

        var maxNumber = allNumbers.stream()
                .max(Integer::compare)
                .orElse(Integer.MIN_VALUE);

        System.out.println("Max number: " + maxNumber);


    }

}
