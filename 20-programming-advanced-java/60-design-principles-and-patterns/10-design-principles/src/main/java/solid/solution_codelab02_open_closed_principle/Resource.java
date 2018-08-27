package solid.solution_codelab02_open_closed_principle;

public interface Resource {
    int findFree();

    void markBusy(int resourceId);

    void markFree(int resourceId);
}
