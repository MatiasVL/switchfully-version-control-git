package solid.codelab03_liskov_substitution_principle;

public class ElectronicDuck extends Duck {
    private boolean isSwitchedOn = false;

    @Override
    public void quack() {
        if (isSwitchedOn) {
            System.out.println("Electronic duck quack...");
        }
    }

    @Override
    public void swim() {
        throw new UnsupportedOperationException("Electronic ducks can't swim, they'll break!");
    }

    public void turnOn() {
        isSwitchedOn = true;
    }

    public void turnOff() {
        isSwitchedOn = false;
    }
}
