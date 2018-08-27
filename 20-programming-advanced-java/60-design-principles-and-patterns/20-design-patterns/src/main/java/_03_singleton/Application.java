package _03_singleton;

public class Application {

    public static void main(String[] args) {
        EagerDatabaseConnector eagerDatabaseConnector = EagerDatabaseConnector.getInstance();
        eagerDatabaseConnector.storeData("Hello");

        LazyDatabaseConnector lazyDatabaseConnector1 = LazyDatabaseConnector.getInstance();
        LazyDatabaseConnector lazyDatabaseConnector2 = LazyDatabaseConnector.getInstance();
        LazyDatabaseConnector lazyDatabaseConnector3 = LazyDatabaseConnector.getInstance();
    }
}
