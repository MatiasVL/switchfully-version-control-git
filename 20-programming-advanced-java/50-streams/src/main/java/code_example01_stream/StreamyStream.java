package code_example01_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamyStream {

    public static void main(String[] args) {
        List<String> myWords = Arrays.asList("my", "milkshake", "brings", "all", "the", "boys", "to", "the", "yard");

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


    }

}
