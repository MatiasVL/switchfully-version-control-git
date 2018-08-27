package set_map_comparators.codelab06;

public class User {

    private static int idCounter = 1;

    private int id;
    private String lastname;
    private String firstname;

    public User(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.id = idCounter;
        idCounter++;
    }

    public int getId() {
        return id;
    }

    public static void resetCounter() {
        idCounter = 1;
    }
}
