package solid.solution_codelab04_interface_segregation_principle.employees;

import solid.solution_codelab04_interface_segregation_principle.employees.behavior.Eatable;
import solid.solution_codelab04_interface_segregation_principle.employees.behavior.Workable;

public class Horse implements Workable, Eatable {

    @Override
    public String work() {
        return "Working like a true working horse";
    }

    @Override
    public String eat() {
        return "Eating some jummy hay!";
    }

}
