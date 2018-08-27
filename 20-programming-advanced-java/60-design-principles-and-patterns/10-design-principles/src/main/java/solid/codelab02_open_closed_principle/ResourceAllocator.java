package solid.codelab02_open_closed_principle;

public class ResourceAllocator {
    private static final int INVALID_RESOURCE_ID = -1;

    public int allocate(ResourceType resourceType) {
        int resourceId;
        switch (resourceType) {
            case TIME_SLOT:
                resourceId = findFreeTimeSlot();
                markTimeSlotBusy(resourceId);
                break;
            case SPACE_SLOT:
                resourceId = findFreeSpaceSlot();
                markSpaceSlotBusy(resourceId);
                break;
            default:
                System.out.println("ERROR: Attempted to allocate invalid resource");
                resourceId = INVALID_RESOURCE_ID;
                break;
        }
        return resourceId;
    }

    public void free(ResourceType resourceType, int resourceId) {
        switch (resourceType) {
            case TIME_SLOT:
                markTimeSlotFree(resourceId);
                break;
            case SPACE_SLOT:
                markSpaceSlotFree(resourceId);
                break;
            default:
                System.out.println("ERROR: attempted to free invalid resource");
                break;
        }
    }

    private void markSpaceSlotFree(int resourceId) {
        System.out.println("Space slot marked as free for resourceId = " + resourceId);
    }

    private void markTimeSlotFree(int resourceId) {
        System.out.println("Time slot marked as free for resourceId = " + resourceId);
    }

    private void markSpaceSlotBusy(int resourceId) {
        System.out.println("Space slot marked as busy for resourceId = " + resourceId);
    }

    private int findFreeSpaceSlot() {
        return (int)(Math.random()*100);
    }

    private void markTimeSlotBusy(int resourceId) {
        System.out.println("Time slot marked as busy for resourceId = " + resourceId);
    }

    private int findFreeTimeSlot() {
        return (int)(Math.random()*50);
    }
}
