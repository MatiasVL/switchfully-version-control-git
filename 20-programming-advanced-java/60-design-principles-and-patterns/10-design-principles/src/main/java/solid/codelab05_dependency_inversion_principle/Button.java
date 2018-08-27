package solid.codelab05_dependency_inversion_principle;

public class Button {

    private Lamp lamp;
    private boolean isButtonOn;

    public Button(Lamp lamp) {
        this.lamp = lamp;
    }

    public void toggle() {
        isButtonOn = !isButtonOn;
        if (isButtonOn) {
            lamp.turnOn();
        } else {
            lamp.turnOff();
        }
    }

}
