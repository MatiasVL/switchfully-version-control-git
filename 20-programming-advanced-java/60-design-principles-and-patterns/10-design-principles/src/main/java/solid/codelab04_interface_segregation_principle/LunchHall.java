package solid.codelab04_interface_segregation_principle;

import solid.codelab04_interface_segregation_principle.workers.Robot;
import solid.codelab04_interface_segregation_principle.workers.Worker;

import java.util.List;

public class LunchHall {
    private final List<Worker> workers;

    public LunchHall(List<Worker> workers) {
        this.workers = workers;
    }

    public void lunchTime() {
        this.workers
                .forEach(worker -> {
                    // A required check because of our bad design :'(
                    if(!(worker instanceof Robot)) {
                        worker.eat();
                    }
                });
    }

}
