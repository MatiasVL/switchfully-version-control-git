package codelab03;

import java.awt.*;

public class PointRunner {

    /**
     * Before running this exercise,
     * determine what the output will be and why!
     * Draw on a piece of paper which variables (ref) point to which objects (as we did on the slides)
     * Only when it's clear to you, execute the code and validate your solution.
     */
    public static void main(String[] args) {
        thinkBeforeYouRunThisExercise();

        Point pointAlpha = new Point(99,45);
        Point pointBeta = pointAlpha;
        Point pointCharlie = pointBeta;

        pointCharlie.move(45,205);
        System.out.println(pointAlpha.toString()); // what is the output and why?
        System.out.println("----------------------");

        pointBeta = new Point(85,99);
        System.out.println(pointAlpha.toString()); // what is the output and why?
        System.out.println(pointBeta.toString()); // what is the output and why?
        System.out.println("----------------------");

        Point pointDelta = Add50(pointAlpha);
        System.out.println(pointDelta); // what is the output and why?
        System.out.println(pointAlpha); // what is the output and why?
        System.out.println("----------------------");

        Point pointEcho = moveTo100(pointAlpha);
        System.out.println(pointCharlie.toString()); // what is the output and why?
        System.out.println(pointEcho.toString()); // what is the output and why?
        System.out.println("----------------------");
    }

    private static Point Add50(Point point) {
        return new Point(point.x + 50, point.y + 50);
    }

    private static Point moveTo100(Point point) {
        point.move(100, 100);
        return point;
    }

    private static void thinkBeforeYouRunThisExercise() {
        throw new RuntimeException("Not so fast. Why don't you think about it first? Then remove the call to this method.");
    }



}
