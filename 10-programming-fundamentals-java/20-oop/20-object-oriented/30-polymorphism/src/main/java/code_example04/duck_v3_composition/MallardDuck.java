package code_example04.duck_v3_composition;

import code_example04.duck_v3_composition.behavior.fly.FlyWithWings;
import code_example04.duck_v3_composition.behavior.quack.Quack;

public class MallardDuck extends Duck {

    public MallardDuck() {
        super(new FlyWithWings(), new Quack());
    }

    @Override
    public void display() {
        System.out.println("I'm a Mallard duck!");
    }
}
