package code_example04.duck_v3_composition.behavior.quack;

public class Squeak implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Squeaaaaak!");
    }

}
