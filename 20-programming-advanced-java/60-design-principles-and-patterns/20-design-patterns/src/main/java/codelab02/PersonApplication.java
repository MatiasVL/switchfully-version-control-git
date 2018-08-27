package codelab02;

/**
 * Read the README.md
 */
public class PersonApplication {

    public static void main(String[] args) {

        // Creaton Person objects like this is really hard to understand, annoying and confusing...
        Person bruce = new Person("Wayne", "Thomas", "Bruce", 25, "Gotham", "Mountain Drive", "1007", "53540", "735-185-7301", "fullofterrors@gmail.com");
        Person misterWayne = new Person("Wayne", null, "Bruce", 25, "Gotham", null, "1007", null, null, null);

        System.out.println(bruce);
        System.out.println("-----------");
        System.out.println(misterWayne);

    }

}
