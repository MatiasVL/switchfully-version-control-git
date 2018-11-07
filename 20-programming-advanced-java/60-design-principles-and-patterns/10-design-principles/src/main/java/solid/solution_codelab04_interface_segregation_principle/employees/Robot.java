package solid.solution_codelab04_interface_segregation_principle.employees;

import solid.solution_codelab04_interface_segregation_principle.employees.behavior.Rechargeable;
import solid.solution_codelab04_interface_segregation_principle.employees.behavior.Workable;

public class Robot implements Workable, Rechargeable {

    @Override
    public String work() {
        return "DOING SO MUCH WORK, BEEP";
    }

    @Override
    public String rechargeBatteries() {
        return "RECHARGING BATTERIES, BEEP";
    }
}
