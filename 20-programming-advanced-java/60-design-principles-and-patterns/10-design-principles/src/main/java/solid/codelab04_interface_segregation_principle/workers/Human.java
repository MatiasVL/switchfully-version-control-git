package solid.codelab04_interface_segregation_principle.workers;

public class Human implements Worker {

    @Override
    public String work() {
        return "Doing some (mildly) hard work";
    }

    @Override
    public String eat() {
        return "Eating my 'bokes'";
    }

    @Override
    public String rechargeBatteries() {
        throw new UnsupportedOperationException("A human does not have batteries to recharge");
    }
}
