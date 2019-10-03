package grasp.codelab01;

/**
 * Nothing needs to change here.
 */
public class Soldier {

    private final int strength;

    public Soldier(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public String toString() {
        return "Soldier{" +
                "strength=" + strength +
                '}';
    }
}
