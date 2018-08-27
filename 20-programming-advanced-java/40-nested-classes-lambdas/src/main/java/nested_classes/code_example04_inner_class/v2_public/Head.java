package nested_classes.code_example04_inner_class.v2_public;

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

    /**
     * Really consider if you're using a inner class, if you can make it static.
     * If you can't, then really try to keep it private!
     */
    public class Brain {

        private void reacToSunburn() {
            hasHeadache = true;
        }
    }
}
