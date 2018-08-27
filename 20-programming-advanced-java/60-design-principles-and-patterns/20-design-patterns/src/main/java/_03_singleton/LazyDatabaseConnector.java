package _03_singleton;

/**
 * When lazy, the instance is created only when it is being used
 * This is the better approach when creating an instance of your Singleton class is resource intensive
 * However, this solution is not thread-safe (Head-first design patterns p179).
 */
public class LazyDatabaseConnector {

    private static LazyDatabaseConnector instance;

    // private constructor so no instances can be created using the constructor (new keyword)
    private LazyDatabaseConnector() {}

    public static LazyDatabaseConnector getInstance() {
        if(instance == null) {
            instance = new LazyDatabaseConnector();
            System.out.println("New instance created");
        }
        return instance;
    }

    public void storeData(String data) {
        System.out.println("Storing data to the database");
    }

}
