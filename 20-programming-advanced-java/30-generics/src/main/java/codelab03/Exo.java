package codelab03;

import java.util.Optional;

public class Exo {

    public static void main(String[] args) {
        Integer count = methodReturningOptional()
                .map(word -> word.trim())
                .map(trimmedWord -> trimmedWord.length())
                .orElse(0);
        System.out.println(count);

        count = methodReturningEmptyOptional()
                .map(word -> word.trim())
                .map(trimmedWord -> trimmedWord.length())
                .orElse(0);
        System.out.println(count);
    }

    private static Optional<String> methodReturningOptional() {
        return Optional.of("CountMe");
    }

    private static Optional<String> methodReturningEmptyOptional() {
        return Optional.empty();
    }


}
