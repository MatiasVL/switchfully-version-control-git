package solid.codelab04_interface_segregation_principle;

public class Robot implements Worker {

    @Override
    public String work() {
        return "Robot works";
    }

    @Override
    public String eat() {
        throw new RuntimeException("Robot can't eat");
    }
}
