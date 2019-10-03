package grasp.codelab02;

/**
 * We have provided this class for when
 * you want to manually validate and run your life method.
 * To 'try out' your implementation.
 */
public class GameOfLifeApplication {

    public static void main(String[] args) throws InterruptedException {
        String[] dish = {
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
        int gens = 20;
        for (int i = 0; i < gens; i++) {
            System.out.println("\r\n\r\n\r\n");
            System.out.println("Generation " + i + ":");
            GameOfLife.print(dish);
            dish = GameOfLife.life(dish);
            Thread.sleep(1000);
        }
    }
}
