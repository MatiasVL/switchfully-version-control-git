package solid.codelab04_interface_segregation_principle;

import java.util.List;

public class FactoryHall {

    private List<Worker> workers;

    public FactoryHall(List<Worker> workers) {
        this.workers = workers;
    }

    public void manage() {
        this.workers
                .forEach(Worker::work);
    }

}
