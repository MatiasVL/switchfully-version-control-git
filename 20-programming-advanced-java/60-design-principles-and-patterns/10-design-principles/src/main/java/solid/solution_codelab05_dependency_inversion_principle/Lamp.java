package solid.solution_codelab05_dependency_inversion_principle;

public class Lamp implements Toggable {
    private int color;

    @Override
    public void turnOn() {
        System.out.println("Lamp turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Lamp turned off");
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        color = color;
    }
}
