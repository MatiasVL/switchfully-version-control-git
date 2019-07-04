package codelab11;

public class Author {

    private String name;
    private String surname;
    private int age;
    private Gender gender;

    public Author(String name, String surname, int age, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public String getSurname() {
        return surname;
    }

    public Gender getGender() {
        return gender;
    }

    public enum Gender {
        MALE,
        FEMALE,
        OTHER
    }

}
