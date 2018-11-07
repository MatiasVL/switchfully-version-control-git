package solid.solution_codelab03_liskov_substitution_principle;

public class ElectronicDuck implements Quackable {

    private boolean isSwitchedOn = false;

    @Override
    public void quack() {
        if(isSwitchedOn) {
            System.out.println("Electronic duck quack...");
        }
    }

    public void turnOn() {
        this.isSwitchedOn = true;
    }

    public void turnOff() {
        this.isSwitchedOn = false;
    }
}
