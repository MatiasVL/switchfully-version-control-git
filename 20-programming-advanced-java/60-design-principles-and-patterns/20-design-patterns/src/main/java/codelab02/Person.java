package codelab02;

/**
 * Read the README.md
 */
class Person {

    private final String lastName;
    private final String middleName;
    private final String firstName;
    private final int age;
    private final String city;
    private final String street;
    private final String housenumber;
    private final String zipcode;
    private final String phonenumber;
    private final String email;

    Person(
            String lastName,
            String middleName,
            String firstName,
            int age,
            String city,
            String street,
            String housenumber,
            String zipcode,
            String phonenumber,
            String email
    ){
        this.lastName = lastName;
        this.middleName = middleName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.street = street;
        this.housenumber = housenumber;
        this.zipcode = zipcode;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("\n\tlastName='").append(lastName).append('\'');
        sb.append(", \n\tmiddleName='").append(middleName).append('\'');
        sb.append(", \n\tfirstName='").append(firstName).append('\'');
        sb.append(", \n\tage=").append(age);
        sb.append(", \n\tcity='").append(city).append('\'');
        sb.append(", \n\tstreet='").append(street).append('\'');
        sb.append(", \n\thousenumber='").append(housenumber).append('\'');
        sb.append(", \n\tzipcode='").append(zipcode).append('\'');
        sb.append(", \n\tphonenumber='").append(phonenumber).append('\'');
        sb.append(", \n\temail='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
