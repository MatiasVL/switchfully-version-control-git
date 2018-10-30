package solid.codelab04_interface_segregation_principle;

import solid.codelab04_interface_segregation_principle.workers.Worker;

import java.util.List;

public class FactoryHall {

    private final List<Worker> workers;

    public FactoryHall(List<Worker> workers) {
        this.workers = workers;
    }

    public void manage() {
        this.workers
                .forEach(Worker::work);
    }

}
