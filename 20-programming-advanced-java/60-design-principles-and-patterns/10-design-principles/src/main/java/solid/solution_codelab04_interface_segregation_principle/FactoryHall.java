package solid.solution_codelab04_interface_segregation_principle;

import solid.solution_codelab04_interface_segregation_principle.employees.behavior.Workable;

import java.util.List;

public class FactoryHall {

    private final List<Workable> workers;

    public FactoryHall(List<Workable> workers) {
        this.workers = workers;
    }

    public void manage() {
        this.workers
                .forEach(Workable::work);
    }

}
