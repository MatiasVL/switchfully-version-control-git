package solid.solution_codelab05_dependency_inversion_principle;

public class Button {
    private boolean isButtonOn;
    private Toggable toggableDevice;

    public Button(Toggable toggableDevice) {

        this.toggableDevice = toggableDevice;
    }

    public void toggle() {
        isButtonOn = !isButtonOn;
        if (isButtonOn) {
            toggableDevice.turnOn();
        } else {
            toggableDevice.turnOff();
        }
    }

}
