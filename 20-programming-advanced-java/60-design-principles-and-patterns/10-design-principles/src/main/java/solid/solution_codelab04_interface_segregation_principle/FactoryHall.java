package solid.solution_codelab04_interface_segregation_principle;

import java.util.List;

public class FactoryHall {
    private List<Workable> workers;

    public FactoryHall(List<Workable> workers) {
        this.workers = workers;
    }

    public void manage() {
        this.workers.forEach(Workable::work);
    }
}
