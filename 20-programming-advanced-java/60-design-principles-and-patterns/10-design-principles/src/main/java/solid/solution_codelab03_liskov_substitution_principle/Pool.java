package solid.solution_codelab03_liskov_substitution_principle;

import java.util.stream.Stream;

public class Pool {

    public void openForBusiness() {
        Duck donaldDuck = new Duck();
        ElectronicDuck electronicDuck = new ElectronicDuck();
        quack(donaldDuck, electronicDuck, donaldDuck, electronicDuck);
        swim(donaldDuck, donaldDuck, donaldDuck);
    }

    private void quack(Quackable... ducks) {
        Stream.of(ducks)
                .forEach(Quackable::quack);
    }

    private void swim(Swimmable... ducks) {
        Stream.of(ducks)
                .forEach(Swimmable::swim);
    }

    public static void main(String[] args) {
        Pool pool = new Pool();
        pool.openForBusiness();
    }
}
