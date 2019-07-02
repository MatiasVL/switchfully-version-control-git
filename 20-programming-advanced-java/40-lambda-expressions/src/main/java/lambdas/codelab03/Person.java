package lambdas.codelab03;

/**
 * Read the README.md file
 */
class Person {

    private final String givenName;
    private final String surName;
    private final int age;
    private final Gender gender;
    private final String email;
    private final String phone;
    private final String address;

    private Person(Builder builder) {
        givenName = builder.givenName;
        surName = builder.surName;
        age = builder.age;
        gender = builder.gender;
        email = builder.email;
        phone = builder.phone;
        address = builder.address;
    }

    String getGivenName() {
        return givenName;
    }

    String getSurName() {
        return surName;
    }

    int getAge() {
        return age;
    }

    Gender getGender() {
        return gender;
    }

    String getEmail() {
        return email;
    }

    String getPhone() {
        return phone;
    }

    String getAddress() {
        return address;
    }

    static class Builder {
        private String givenName;
        private String surName;
        private int age;
        private Gender gender;
        private String email;
        private String phone;
        private String address;

        Person build() {
            return new Person(this);
        }

        Builder withGivenName(String givenName) {
            this.givenName = givenName;
            return this;
        }

        Builder withSurName(String surName) {
            this.surName = surName;
            return this;
        }

        Builder withAge(int age) {
            this.age = age;
            return this;
        }

        Builder withGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        Builder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        Builder withAddress(String address) {
            this.address = address;
            return this;
        }
    }

}
