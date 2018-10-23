package codelab01;

/**
 * Read the README.md.
 * (the current code of this class is OK)
 */
class Army {

    private final Soldier[] soldiers;

    Army(Soldier[] soldiers) {
        this.soldiers = soldiers;
    }

    Soldier[] getSoldiers() {
        return soldiers;
    }
}
