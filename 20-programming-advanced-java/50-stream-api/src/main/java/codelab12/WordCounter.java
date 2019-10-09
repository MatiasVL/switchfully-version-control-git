package codelab12;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCounter {

    public String countWords(String word) {
        return Stream.of(word.split(" "))
                .collect(Collectors.groupingBy(String::length, Collectors.counting()))
                .entrySet().stream().map(t -> t.getKey() + ":" + t.getValue())
                .collect(Collectors.joining(", "));
    }
}
