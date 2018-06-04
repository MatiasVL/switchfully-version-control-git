package solid.solution_codelab02_open_closed_principle;

public class ResourceAllocator {

    public int allocate(Resource resource) {
        int resourceId = resource.findFree();
        resource.markBusy(resourceId);
        return resourceId;
    }

    public void free(Resource resource, int resourceId) {
        resource.markFree(resourceId);
    }
}
