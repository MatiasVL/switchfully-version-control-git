package codelab05;

import static codelab05.GameOfLife.life;
import static codelab05.GameOfLife.print;

/**
 * We have provided this class for when
 * you want to manually validate and run your life method.
 * To 'try out' your implementation.
 */
public class GameOfLifeApplication {

    public static void main(String[] args) throws InterruptedException {
        String[] dish= {
                "-X-----------",
                "--X----------",
                "XXX----------",
                "-------------",
                "-------------",
                "-------------",
                "-------------",
                "-------------",
                "-------------",
                "-------------",
                "-------------",
                "-------------",
                "-------------"
        };
        int gens= 20;
        for(int i= 0;i < gens;i++){
            System.out.println("\r\n\r\n\r\n");
            System.out.println("Generation " + i + ":");
            print(dish);
            dish= life(dish);
            Thread.sleep(1000);
        }
    }

}
