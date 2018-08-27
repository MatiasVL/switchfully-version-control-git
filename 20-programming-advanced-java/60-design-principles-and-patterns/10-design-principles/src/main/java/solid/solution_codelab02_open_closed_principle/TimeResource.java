package solid.solution_codelab02_open_closed_principle;

public class TimeResource implements Resource {

    @Override
    public int findFree() {
        return (int) (Math.random() * 50);
    }

    @Override
    public void markBusy(int resourceId) {
        System.out.println("Time slot marked as busy for resourceId = " + resourceId);
    }

    @Override
    public void markFree(int resourceId) {
        System.out.println("Time slot marked as free for resourceId = " + resourceId);
    }
}
