package grasp.codelab01.solution;

public class RiskGame {

    private final Board board;

    private RiskGame(Board board) {
        this.board = board;
    }

    /**
     * We use the Static Factory Method pattern here
     * (Notice that it also describes to make the constructor(s) private, which we did)
     * @return a default RiskGame object
     */
    public static RiskGame createDefaultGameSetup() {
        return new RiskGame(Board.createDefaultBoard());
    }

    @Override
    public String toString() {
        return "RiskGame{" +
                "board=" + board +
                '}';
    }

    public static void main(String[] args) {
        RiskGame defaultGameSetup = createDefaultGameSetup();
        System.out.println(defaultGameSetup);
    }

}
