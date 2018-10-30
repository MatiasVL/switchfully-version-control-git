package solid.codelab04_interface_segregation_principle.workers;

public class Horse implements Worker {

    @Override
    public String work() {
        return "Working like a true working horse";
    }

    @Override
    public String eat() {
        return "Eating some jummy hay!";
    }

    @Override
    public String rechargeBatteries() {
        throw new UnsupportedOperationException("Animals don't have batteries to reload...");
    }
}
