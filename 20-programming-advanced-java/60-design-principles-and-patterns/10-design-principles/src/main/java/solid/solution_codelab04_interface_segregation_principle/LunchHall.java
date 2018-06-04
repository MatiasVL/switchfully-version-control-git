package solid.solution_codelab04_interface_segregation_principle;

import java.util.List;

public class LunchHall {
    private List<Eatable> eaters;

    public LunchHall(List<Eatable> eaters) {
        this.eaters = eaters;
    }

    public void manage() {
        this.eaters.forEach(Eatable::eat);
    }
}
