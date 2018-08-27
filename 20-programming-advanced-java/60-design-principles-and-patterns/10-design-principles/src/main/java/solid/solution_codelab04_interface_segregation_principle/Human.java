package solid.solution_codelab04_interface_segregation_principle;

public class Human implements Workable, Eatable {

    @Override
    public String work() {
        return "Human works";
    }

    @Override
    public String eat() {
        return "Human eats";
    }
}
