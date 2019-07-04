package code_example02_optional;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        Integer count = methodReturningOptional()
                .map(trimmedWord -> trimmedWord.length())
                .orElse(0);
        System.out.println(count);

        count = methodReturningEmptyOptional()
                .map(trimmedWord -> trimmedWord.length())
                .orElse(0);
        System.out.println(count);
    }

    /**
     * @return returns an Optional that will always contain a value
     */
    private static Optional<String> methodReturningOptional() {
        return Optional.of("CountMe");
    }

    /**
     * @return returns an Optional that will always contain null (so no value, it is empty!)
     */
    private static Optional<String> methodReturningEmptyOptional() {
        return Optional.of(null);
    }


}
