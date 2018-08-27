package codelab01;

class Army {
    private Soldier[] soldiers;

    Army(Soldier[] soldiers) {
        this.soldiers = soldiers;
    }

    Soldier[] getSoldiers() {
        return soldiers;
    }
}
