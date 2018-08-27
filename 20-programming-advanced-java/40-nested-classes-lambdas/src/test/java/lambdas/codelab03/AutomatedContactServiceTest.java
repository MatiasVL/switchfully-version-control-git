package lambdas.codelab03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AutomatedContactServiceTest {

    @Test
    void callDrivers() {
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
                        .withGivenName("Hannah")
                        .withSurName("Harlem")
                        .withAge(14)
                        .withGender(Gender.FEMALE)
                        .withEmail("hannah@han.nah")
                        .withPhone("0485411128")
                        .withAddress("Parkstraat 15, 3000 Leuven")
                        .build()
        );

        AutomatedContactService service = new AutomatedContactService();
        String calledDrivers = service.callDrivers(people);

        assertEquals(calledDrivers, "Calling Rob Butcher age 21 at 0484854502" + "\n" + "Calling Tanya Tanem age 25 at 0485411125");

    }

    @Test
    void emailDraftees() {
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
                        .withGivenName("Hannah")
                        .withSurName("Harlem")
                        .withAge(16)
                        .withGender(Gender.FEMALE)
                        .withEmail("hannah@han.nah")
                        .withPhone("0485411128")
                        .withAddress("Parkstraat 15, 3000 Leuven")
                        .build()
        );

        AutomatedContactService service = new AutomatedContactService();
        String calledDrivers = service.emailDraftees(people);

        assertEquals(calledDrivers, "Emailing Rob Butcher age 21 at rob.butcher@my-email.be");
    }

    @Test
    void mailPilots() {
        List<Person> people = new ArrayList<>();
        people.add(
                new Person.Builder()
                        .withGivenName("Rob")
                        .withSurName("Butcher")
                        .withAge(22)
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

        AutomatedContactService service = new AutomatedContactService();
        String calledDrivers = service.mailPilots(people);

        assertEquals(calledDrivers, "Mailing Tanya Tanem age 25 at Parkstraat 12, 3000 Leuven");
    }

}