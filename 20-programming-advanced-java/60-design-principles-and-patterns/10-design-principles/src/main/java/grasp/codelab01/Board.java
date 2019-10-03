package grasp.codelab01;

import java.util.List;

public class Board {

    private final List<Country> countries;

    public Board(List<Country> countries) {
        this.countries = countries;
    }

    public List<Country> getCountries() {
        return countries;
    }

    @Override
    public String toString() {
        return "Board{" +
                "countries=" + countries +
                '}';
    }
}
