package solid.codelab04_interface_segregation_principle;

import java.util.List;

public class LunchHall {
    private List<Worker> workers;

    public LunchHall(List<Worker> workers) {
        this.workers = workers;
    }

    public void manage() {
        this.workers
                .forEach(Worker::eat);
    }

}
