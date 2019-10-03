package grasp.codelab01.solution;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Country> countries;

    private Board(List<Country> countries) {
        this.countries = countries;
    }

    /**
     * We use the Static Factory Method pattern here
     * (Notice that it also describes to make the constructor(s) private, which we did)
     * @return a default Board object
     */
    public static Board createDefaultBoard() {
        return new Board(new ArrayList<>(List.of(
                Country.createDefaultCountry("East-Europe"),
                Country.createDefaultCountry("West-Europe"),
                Country.createDefaultCountry("United Kingdom"),
                Country.createDefaultCountry("Scandinavia")
        )));
    }

    @Override
    public String toString() {
        return "Board{" +
                "countries=" + countries +
                '}';
    }
}
