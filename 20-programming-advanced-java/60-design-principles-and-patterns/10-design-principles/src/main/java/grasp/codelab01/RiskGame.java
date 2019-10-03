package grasp.codelab01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.List.of;

public class RiskGame {

    private final Board board;
    private final Map<Country, List<Soldier>> soldiersPerCountry;

    private RiskGame(Board board) {
        this.board = board;
        soldiersPerCountry = new HashMap<>();
    }

    /**
     * We use the Static Factory Method pattern here
     * (Notice that it also describes to make the constructor(s) private, which we did)
     * @return a default RiskGame object
     */
    public static RiskGame createDefaultGameSetup() {
        RiskGame riskGame = new RiskGame(new Board(new ArrayList<>(of(
                new Country("East-Europe"),
                new Country("West-Europe"),
                new Country("United Kingdom"),
                new Country("Scandinavia")
        ))));
        putDefaultSoldiersOnEachCountry(riskGame);
        return riskGame;
    }

    private static void putDefaultSoldiersOnEachCountry(RiskGame riskGame) {
        for (var country : riskGame.board.getCountries()) {
            riskGame.soldiersPerCountry.put(country, List.of(new Soldier(1), new Soldier(1)));
        }
    }

    @Override
    public String toString() {
        return "RiskGame{" +
                "board=" + board +
                ", soldiersPerCountry=" + soldiersPerCountry +
                '}';
    }

    public static void main(String[] args) {
        RiskGame defaultGameSetup = createDefaultGameSetup();
        System.out.println(defaultGameSetup);
    }

}
