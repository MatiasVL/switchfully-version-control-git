package solid.codelab04_interface_segregation_principle.workers;

public class Robot implements Worker {

    @Override
    public String work() {
        return "DOING SO MUCH WORK, BEEP";
    }

    @Override
    public String eat() {
        throw new UnsupportedOperationException("I AM ROBOT, I DO NOT EAT, BEEP");
    }

    @Override
    public String rechargeBatteries() {
        return "RECHARGING BATTERIES, BEEP";
    }
}
