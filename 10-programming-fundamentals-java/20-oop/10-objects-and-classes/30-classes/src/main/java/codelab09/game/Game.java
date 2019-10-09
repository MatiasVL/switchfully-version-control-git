package codelab09.game;

public class Game {

    private final Ship ship;

    public Game(Ship ship) {
        this.ship = ship;
    }

    public boolean checkIfHit(Coordinate coordinate) {
        return ship.isHit(coordinate);
    }
}
