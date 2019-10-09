package codelab09.input;

import codelab09.game.Coordinate;
import codelab09.game.Game;
import codelab09.game.Ship;

import java.util.Scanner;
import java.util.regex.Pattern;

import static codelab09.game.Coordinate.coordinate;
import static java.util.Arrays.asList;

public class UserInputScanner {

    private final Game game;

    public UserInputScanner() {
        this.game = new Game(new Ship(asList(coordinate(5,5))));
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(">");
        String input = scanner.nextLine();
        processInput(input);
    }

    private void processInput(String input) {
        if (isCorrectCoordinate(input)) {
            boolean wasHit = game.checkIfHit(toCoordinate(input));
            if(wasHit){
                System.out.println("Hit!");
            } else {
                System.out.println("Miss!");
            }
        }
    }

    static Coordinate toCoordinate(String input) {
        if (!isCorrectCoordinate(input)) {
            throw new RuntimeException("Should have called isCorrectCoordinate");
        }
        String[] coordinates = input.split(",");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);
        return coordinate(x, y);
    }

    private static boolean isCorrectCoordinate(String input) {
        return Pattern.matches("[0-9]+,[0-9]+", input);
    }
}
