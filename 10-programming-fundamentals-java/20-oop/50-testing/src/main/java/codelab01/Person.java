package codelab01;

import java.time.LocalDate;

/**
 * Read the README.md file
 */
public class Person {

    private boolean isStudent;
    private LocalDate birthDate;

    public Person(boolean isStudent, LocalDate birthDate) {
        this.isStudent = isStudent;
        this.birthDate = birthDate;
    }

    public Person(LocalDate birthDate) {
        this(true, birthDate);
    }

    // Write the test first !
    public double calculateChildAllowance(){
        throw new UnsupportedOperationException("implement me please");
    }

}
