package _03_singleton;

/**
 * When eager, the instance is created at the time of loading the class.
 * This means an instance is always created, even if the client will not use it.
 * (The eager implementation is Thread-safe however)
 */
public class EagerDatabaseConnector {

    private static final EagerDatabaseConnector instance = new EagerDatabaseConnector();

    // private constructor so no instances can be created using the constructor (new keyword)
    private EagerDatabaseConnector() {}

    public static EagerDatabaseConnector getInstance() {
        return instance;
    }

    public void storeData(String data) {
        System.out.println("Storing data to the database");
    }

}
