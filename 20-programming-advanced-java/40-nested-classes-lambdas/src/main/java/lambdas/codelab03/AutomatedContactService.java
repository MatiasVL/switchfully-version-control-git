package lambdas.codelab03;

import java.util.List;
import java.util.StringJoiner;

/**
 * Read the README.md file
 */
class AutomatedContactService {

    String callDrivers(List<Person> pl) {
        StringJoiner joiner = new StringJoiner("\n");
        for (Person p : pl) {
            if (p.getAge() >= 16) {
                joiner.add(automatedCall(p));
            }
        }
        return joiner.toString();
    }

    String emailDraftees(List<Person> pl) {
        StringJoiner joiner = new StringJoiner("\n");
        for (Person p : pl) {
            if (p.getAge() >= 18 && p.getAge() <= 25 && p.getGender() == Gender.MALE) {
                joiner.add(automatedEmail(p));
            }
        }
        return joiner.toString();
    }

    String mailPilots(List<Person> pl) {
        StringJoiner joiner = new StringJoiner("\n");
        for (Person p : pl) {
            if (p.getAge() >= 23 && p.getAge() <= 65) {
                joiner.add(automatedMail(p));
            }
        }
        return joiner.toString();
    }

    private String automatedCall(Person p) {
        return "Calling " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getPhone();
    }

    private String automatedEmail(Person p) {
        return "Emailing " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getEmail();
    }

    private String automatedMail(Person p) {
        return "Mailing " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getAddress();
    }

}
