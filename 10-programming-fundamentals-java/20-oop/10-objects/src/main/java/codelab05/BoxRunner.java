package codelab05;

import java.awt.*;

/**
 * Take a piece of paper and draw boxes for all the objects that are in play just before the end of the main method,
 * with little boxes inside that show the values of their attributes.
 *
 * What is the output of the program?
 *
 * At the end of the main method, are the p1 and p2 references equal? Why or why not?
 * If you think you know the answer, write a line of code to make sure.
 *
 * At the end of the main method, are the p1 and p2 objects equal? Why or why not?
 * If you think you know the answer, write a line of code to make sure.
 */
public class BoxRunner {

    private static Point findCenter(Rectangle box) {
        int x = box.x + box.width / 2;
        int y = box.y + box.height / 2;
        return new Point(x, y);
    }

    public static void main(String[] args) {
        thinkBeforeYouRunThisExercise();

        Rectangle box1 = new Rectangle(2, 4, 8, 10);
        Point p1 = findCenter(box1);
        System.out.println(p1);

        box1.grow(1, 1);
        Point p2 = findCenter(box1);
        System.out.println(p2);
    }

    private static void thinkBeforeYouRunThisExercise() {
        throw new RuntimeException("Not so fast. Why don't you think about it first? Then remove the call to this method.");
    }

}
