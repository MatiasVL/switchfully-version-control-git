package solid.solution_codelab04_interface_segregation_principle.employees;

import solid.solution_codelab04_interface_segregation_principle.employees.behavior.Eatable;
import solid.solution_codelab04_interface_segregation_principle.employees.behavior.Workable;

public class Human implements Workable, Eatable {

    @Override
    public String work() {
        return "Doing some (mildly) hard work";
    }

    @Override
    public String eat() {
        return "Eating my 'bokes'";
    }

}
