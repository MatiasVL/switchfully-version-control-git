package grasp.codelab01.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Country {

    private final String name;
    private final List<Soldier> soldiers;

    private Country(String name, Soldier... soldiers) {
        this.name = name;
        this.soldiers = new ArrayList<>(Arrays.asList(soldiers));
    }

    /**
     * We use the Static Factory Method pattern here
     * (Notice that it also describes to make the constructor(s) private, which we did)
     * @return a default Country object
     */
    public static Country createDefaultCountry(String name) {
        return new Country(name, new Soldier(1), new Soldier(1));
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", soldiers=" + soldiers +
                '}';
    }
}
