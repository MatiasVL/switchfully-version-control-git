package solid.solution_codelab04_interface_segregation_principle;

import solid.solution_codelab04_interface_segregation_principle.employees.behavior.Eatable;

import java.util.List;

public class LunchHall {
    private final List<Eatable> eaters;

    public LunchHall(List<Eatable> eaters) {
        this.eaters = eaters;
    }

    public void lunchTime() {
        this.eaters
                .forEach(Eatable::eat);
    }

}
