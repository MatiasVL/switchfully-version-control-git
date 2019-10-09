package codelab09.game;

import java.util.List;

public class Ship {

    private List<Coordinate> coordinateList;

    public Ship(List<Coordinate> coordinateList) {
        this.coordinateList = coordinateList;
    }

    public boolean isHit(Coordinate coordinate) {
        return coordinateList.contains(coordinate);
    }
}
