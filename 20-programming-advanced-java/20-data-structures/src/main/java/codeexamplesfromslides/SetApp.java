package codeexamplesfromslides;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetApp {

    public static void main(String[] args) {
        Set<String> humans = new HashSet<>(
                List.of("Adam",
                        "Eva",
                        "Kate")
        );
        Set<String> females = new HashSet<>(
                List.of("Eva",
                        "Kate"));

        // will be true
        boolean containsKate = humans.contains("Kate");

        // subset --> will be true
        boolean isSubset = humans.containsAll(females);

        // Will modify humans to only hold "Eva" and "Kate"
        humans.retainAll(females);

        System.out.println(isSubset);
        System.out.println(containsKate);

        humans.forEach(oneHuman -> System.out.println(oneHuman));

    }

}
