package solid.solution_codelab04_interface_segregation_principle;

public class Robot implements Workable {

    @Override
    public String work() {
        return "Robot works";
    }
}
