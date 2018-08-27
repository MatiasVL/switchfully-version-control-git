package code_example04.duck_v3_composition.behavior.quack;

public class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Doesn't make a sound");
    }
}
