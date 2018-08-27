package codelab01;

class Soldier {

    private int attackingStrength;
    private int defendingStrength;

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
