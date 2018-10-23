package codelab01;

/**
 * Read the README.md.
 * (the current code of this class is OK)
 */
class Soldier {

    private final int attackingStrength;
    private final int defendingStrength;

    public Soldier(int attackingStrength, int defendingStrength) {
        this.attackingStrength = attackingStrength;
        this.defendingStrength = defendingStrength;
    }

    int getAttackingStrength() {
        return attackingStrength;
    }

    int getDefendingStrength() {
        return defendingStrength;
    }
}
