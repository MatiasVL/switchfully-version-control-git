package nested_classes.code_example04_inner_class.v1_private;

public class Head {

    private Brain brain;
    private boolean hasHeadache;

    public Head() {
        brain = new Brain();
        hasHeadache = false;
    }

    public boolean hasHeadache() {
        return hasHeadache;
    }

    public void acquireSunburn() {
        brain.reacToSunburn();
    }

    private class Brain {

        private void reacToSunburn() {
            hasHeadache = true;
        }
    }
}
