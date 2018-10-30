package solid.codelab03_liskov_substitution_principle;

import java.util.stream.Stream;

public class Pool {

    public static void main(String[] args) {
        Pool pool = new Pool();
        pool.openForBusiness();
    }

    private void openForBusiness() {
        Duck donaldDuck = new Duck();
        Duck electricDuck = new ElectronicDuck();
        quack(donaldDuck, electricDuck);
        swim(donaldDuck, electricDuck);
    }

    private void quack(Duck... ducks) {
        Stream.of(ducks)
                .forEach(duck -> {
                    // just to make sure the ElectronicDuck is always on...
                    if(duck instanceof ElectronicDuck) {
                        ((ElectronicDuck) duck).turnOn();
                    }
                    duck.quack();
                });
    }

    private void swim(Duck... ducks) {
        Stream.of(ducks)
                .forEach(duck -> {
                    if(!(duck instanceof ElectronicDuck)) {
                        duck.swim();
                    }
                });
    }
}
