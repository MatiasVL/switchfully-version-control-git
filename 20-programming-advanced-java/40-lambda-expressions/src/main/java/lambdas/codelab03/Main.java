package lambdas.codelab03;

import java.util.ArrayList;
import java.util.List;

/**
 * Read the README.md file
 */
public class Main {

    public static void main(String[] args) {
        List<Person> people = createListOfPeople();
        AutomatedContactService service = new AutomatedContactService();

        String calledDrivers = service.callDrivers(people);
        String emailedDraftees = service.emailDraftees(people);
        String mailedPilots = service.mailPilots(people);

        System.out.println("=== CALLED DRIVERS ===");
        System.out.println(calledDrivers);
        System.out.println();

        System.out.println("=== EMAILED DRAFTEES ===");
        System.out.println(emailedDraftees);
        System.out.println();

        System.out.println("=== MAILED PILOTS ===");
        System.out.println(mailedPilots);
        System.out.println();
    }


    private static List<Person> createListOfPeople() {
        List<Person> people = new ArrayList<>();
        people.add(
                new Person.Builder()
                        .withGivenName("Rob")
                        .withSurName("Butcher")
                        .withAge(21)
                        .withGender(Gender.MALE)
                        .withEmail("rob.butcher@my-email.be")
                        .withPhone("0484854502")
                        .withAddress("Koekenstraat 45, 3583 Beringen")
                        .build()
        );
        people.add(
                new Person.Builder()
                        .withGivenName("Tanya")
                        .withSurName("Tanem")
                        .withAge(25)
                        .withGender(Gender.FEMALE)
                        .withEmail("t-and-t@dynamite.com")
                        .withPhone("0485411125")
                        .withAddress("Parkstraat 12, 3000 Leuven")
                        .build()
        );
        people.add(
                new Person.Builder()
                        .withGivenName("Ann")
                        .withSurName("Answegen")
                        .withAge(25)
                        .withGender(Gender.FEMALE)
                        .withEmail("ann@answegen.com")
                        .withPhone("0488002565")
                        .withAddress("Brusselsestraat 881, 1000 Brussel")
                        .build()
        );
        return people;
    }

}
